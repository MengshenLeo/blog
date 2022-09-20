package fun.mengshenleo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.req.ApiLogReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author mengshen
*/
@Mapper
public interface ApiLogMapper extends BaseMapper<ApiLog> {


    /**
     * 更改接口日志
     * @param apiLog
     * @return
     */
    @Override
    int updateById(ApiLog apiLog);

    /**
     * 获取全部接口信息
     * @return
     * @param apiLogReq
     */
    List<ApiLog> getList(ApiLogReq apiLogReq);

    /**
     * 插入接口日志
     * @param apiLog
     * @return
     */
    int insertBatch(@Param("entities") List<ApiLog> apiLog);

}
