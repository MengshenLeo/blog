package fun.mengshenleo.blog.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import fun.mengshenleo.blog.listener.ExcelListener;
import fun.mengshenleo.blog.mapper.ApiLogMapper;
import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.req.ApiLogReq;
import fun.mengshenleo.blog.service.ApiLogService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


/**
 * @author mengshen
 */
@Service
public class ApiLogServiceImpl implements ApiLogService {

    @Resource
    ApiLogMapper apiLogMapper;

    @Override
    public int updateById(ApiLog apiLog) {
        return apiLogMapper.updateById(apiLog);
    }

    @Override
    public int save(ApiLog apiLog) {
        return apiLogMapper.insert(apiLog);
    }

    @Override
    public List<ApiLog> getList(ApiLogReq apiLogReq) {
        PageHelper.startPage(apiLogReq.getPageNum(), apiLogReq.getPageSize());
        List<ApiLog> list = apiLogMapper.getList(apiLogReq);
        return list;
    }

    @Override
    public Boolean uploadExcel(MultipartFile file) {

        boolean isSuccess = false;

        ExcelListener excelListener = new ExcelListener();
        try {
            EasyExcel
                    .read(file.getInputStream(), ApiLog.class,excelListener)
                    .sheet()
                    .doRead();
            List<ApiLog> data = excelListener.getData();
            int i = apiLogMapper.insertBatch(data);
            if (i > 0) {
                isSuccess = true;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return isSuccess;
    }
}
