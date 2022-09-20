package fun.mengshenleo.blog.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 接口日志
 * TableName api_log
 * @author mengshen
 */

@Data
public class ApiLog extends Model<ApiLog> {
    /**
     * id
     */
    @ExcelProperty(value = "序号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 访问时间
     */
    @ExcelProperty(value = "访问时间")
    private Date accessTime;

    /**
     *结束时间
     */
    @ExcelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 访问的方法名
     */
    @ExcelProperty(value = "访问的方法名")
    private String name;

    /**
     * 访问接口名
     */
    @ExcelProperty(value = "访问接口名")
    private String accessApi;

    /**
     * 是否正常（1:正常；0:异常）
     */
    @ExcelProperty(value = "是否正常")
    private Integer isSuccessful;

    /**
     * 信息
     */
    @ExcelProperty(value = "信息")
    private String message;

    /**
     * IP地址
     */
    @ExcelProperty(value = "IP地址")
    private String ipAddress;

    /**
     * 访问接口类型
     */
    @ExcelProperty(value = "访问接口类型")
    private String apiType;

}