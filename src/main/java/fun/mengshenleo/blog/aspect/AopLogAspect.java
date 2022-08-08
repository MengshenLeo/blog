package fun.mengshenleo.blog.aspect;


import fun.mengshenleo.blog.domain.ResultInfo;
import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.service.ApiLogService;
import fun.mengshenleo.blog.utils.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;


/**
 * @author mengshen
 * @date 2022/7/26 15:21
 */
@Component
@Aspect
public class AopLogAspect {

    @Resource
    ApiLogService apiLogService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final int SUCCESSFUL_STATUS = 200;

    ApiLog apiLog = new ApiLog();

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long logStartTime = 0L;

    /**
     * Description:线程局部的变量，用于解决多线程中相同变量的访问冲突问题
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    /**
     * 定义切入点
     */
    @Pointcut("execution(public * fun.mengshenleo.blog.controller..*.*(..))")
    public void aopWebLog() {
    }

    @Before("aopWebLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        /*
          接收到请求，记录请求内容
         */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        /*
            记录下请求内容
         */
        logger.info("URL：" + request.getRequestURI());
        logger.info("HTTP方法：" + request.getMethod());
        logger.info("IP地址：" + IpUtil.getRealIp(request));
        logger.info("类的方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数：" + request.getQueryString());
        /*
            记录接口日志
         */
        try {
            //*========数据库日志=========*//
            //请求接口
            apiLog.setAccessApi(request.getRequestURI());
            apiLog.setIpAddress(IpUtil.getRealIp(request));
            //请求方式
            apiLog.setApiType(request.getMethod());
            apiLog.setName(joinPoint.getSignature().getName());
            logStartTime = System.currentTimeMillis();
            String format = df.format(new java.sql.Date(logStartTime));
            //请求时间
            apiLog.setAccessTime(df.parse(format));
            apiLogService.save(apiLog);
        }catch (Exception e){
            //记录本地异常日志
            logger.error("异常信息：{}",e.getMessage());
            apiLog.setMessage(e.getMessage());
            apiLogService.save(apiLog);
        }
    }

    @AfterReturning(pointcut = "aopWebLog()",returning = "retObject")
    public void doAfterReturning(Object retObject) {
        /*
          处理完请求，返回内容
         */
        logger.info("应答值：" + retObject);
        logger.info("费时：" + (System.currentTimeMillis() - startTime.get()));
        try{
            // 处理完请求，返回内容
            ResultInfo resultInfo = (ResultInfo) retObject;
            //如果成功就设置为1正常
            if (resultInfo.getStatus() == SUCCESSFUL_STATUS){
                apiLog.setIsSuccessful(1);
            } else {
                apiLog.setIsSuccessful(0);
            }
            //结束时间
            apiLog.setEndTime(df.parse(df.format(System.currentTimeMillis())));
            apiLog.setMessage(resultInfo.getMsg());
            apiLogService.updateById(apiLog);
        }catch (Exception e){e.printStackTrace();}

        startTime.remove();
    }

    /**
     * 方法抛出异常退出时执行的通知
     */
    @AfterThrowing(pointcut = "aopWebLog()",throwing = "ex")
    public void addAfterThrowingLogger(Exception ex){
        logger.error("执行" + "异常",ex);
    }



}
