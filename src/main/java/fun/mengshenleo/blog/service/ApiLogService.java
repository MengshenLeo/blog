package fun.mengshenleo.blog.service;


import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.req.ApiLogReq;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author mengshen
 * Discription:接口日志Service
*/
@Service
public interface ApiLogService {


    /**
     * 通过Id更新接口日志
     * @param apiLog
     * @return
     */
    int updateById(ApiLog apiLog);

    /**
     * 插入接口日志
     * @param apiLog
     * @return
     */
    int save(ApiLog apiLog);

    /**
     * 获取接口信息列表
     * @return
     */
    List<ApiLog> getList(ApiLogReq apiLogReq);
}
