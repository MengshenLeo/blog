package fun.mengshenleo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.mengshenleo.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mengshen
 * @date 2022/9/8 17:21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
