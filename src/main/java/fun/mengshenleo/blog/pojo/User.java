package fun.mengshenleo.blog.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
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


    @ExcelProperty(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ExcelProperty(value = "用户名")
    @TableField(value = "username")
    private String username;

    @ExcelProperty(value = "密码")
    private String password;

    @ExcelProperty(value = "备注")
    @TableField(exist = false)
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
