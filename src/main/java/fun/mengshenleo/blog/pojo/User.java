package fun.mengshenleo.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mengshen
 * @date 2022/9/8 16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "userTable",schema = "blog")
public class User {


    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "username")
    private String username;

    private String password;

    @TableField(exist = false)
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
