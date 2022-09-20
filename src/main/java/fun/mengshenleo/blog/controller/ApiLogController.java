package fun.mengshenleo.blog.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.api.R;
import fun.mengshenleo.blog.listener.ExcelListener;
import fun.mengshenleo.blog.utils.DownloadExcel;
import fun.mengshenleo.blog.domain.ResultInfo;
import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.req.ApiLogReq;
import fun.mengshenleo.blog.service.ApiLogService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @PostMapping("/getListExcel")
    public ResultInfo<String> getListExcel(@RequestBody ApiLogReq apiLogReq, HttpServletResponse response) throws IOException {
        apiLogReq.setPageSize(Integer.MAX_VALUE);
        apiLogReq.setPageNum(1);
        List<ApiLog> list = apiLogService.getList(apiLogReq);
        DownloadExcel.download(response, ApiLog.class,list,"apiLog");
        return ResultInfo.ok("接口日志表格导出成功");
    }

    @PostMapping("/uploadExcel")
    @ResponseBody
    public ResultInfo<String> uploadExcel(MultipartFile file){
        Boolean uploadExcel = apiLogService.uploadExcel(file);
        return uploadExcel ? ResultInfo.ok("导入成功"):ResultInfo.error("导入失败");
    }
}
