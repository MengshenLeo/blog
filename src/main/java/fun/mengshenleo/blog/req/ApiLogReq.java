package fun.mengshenleo.blog.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mengshen
 * @date 2022/8/8 12:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiLogReq {

    /**
     * id
     */
    private Long id;

    /**
     * 一页的记录数
     */
    private Integer pageSize = 10;

    /**
     * 页数
     */
    private Integer pageNum = 1;
}
