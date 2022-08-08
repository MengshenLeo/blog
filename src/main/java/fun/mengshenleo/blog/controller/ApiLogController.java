package fun.mengshenleo.blog.controller;

import fun.mengshenleo.blog.domain.ResultInfo;
import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.req.ApiLogReq;
import fun.mengshenleo.blog.service.ApiLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mengshen
 * @date 2022/7/26 15:54
 */
@RestController
@RequestMapping("/apiLog")
public class ApiLogController {

    @Resource
    ApiLogService apiLogService;

    @GetMapping("/aopTest")
    public ResultInfo<String> aVoid(){
        return ResultInfo.ok("测试成功！","hello,aop");
    }

    @PostMapping("/getList")
    public ResultInfo<List<ApiLog>> getList(@RequestBody ApiLogReq apiLogReq){
        List<ApiLog> list = apiLogService.getList(apiLogReq);
        return list.size()>0?ResultInfo.ok("获取成功",list, (long)list.size()):ResultInfo.error("未查询到数据");
    }
}
