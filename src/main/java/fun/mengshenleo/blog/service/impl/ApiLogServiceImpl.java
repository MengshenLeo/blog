package fun.mengshenleo.blog.service.impl;

import com.github.pagehelper.PageHelper;
import fun.mengshenleo.blog.mapper.ApiLogMapper;
import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.req.ApiLogReq;
import fun.mengshenleo.blog.service.ApiLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
