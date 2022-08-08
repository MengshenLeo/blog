package fun.mengshenleo.blog.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mengshen
 * @date 2022/8/8 0:11
 * 结果集返回处理类
 */
@Data
@NoArgsConstructor
public class ResultInfo<T> {
    /**
     * 状态
     */
    private Integer status;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 数据集合
     */
    private T data;

    /**
     * 附加数据
     */
    private Long count = 1L;

    public ResultInfo(ResultStatus status) {
        this.status = status.getCode();
        this.msg = status.getName();
    }

    public ResultInfo(ResultStatus status, String msg) {
        this(status);
        this.msg = msg;
    }

    public ResultInfo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultInfo(ResultStatus status, String msg, T data) {
        this(status, msg);
        this.data = data;
    }

    public ResultInfo(ResultStatus status, String msg, T data, Long count) {
        this(status, msg, data);
        this.count = count;
    }

    public static <T> ResultInfo<T> ok() {
        return okWith(ResultStatus.SUCCESS.getName());
    }

    public static <T> ResultInfo<T> okWith(String msg) {
        return ok(msg, null, 1L);
    }

    public static <T> ResultInfo<T> ok(T data) {
        return ok(ResultStatus.SUCCESS.getName(), data);
    }

    public static <T> ResultInfo<T> ok(String msg,T data) {
        return ok(msg, data,1L);
    }

    public static <T> ResultInfo<T> ok(String msg, T data, Long count) {
        return new ResultInfo<>(ResultStatus.SUCCESS, msg, data, count);
    }

    public static <T> ResultInfo<T> error() {
        return error(ResultStatus.FAIL.getName());
    }

    public static <T> ResultInfo<T> error(String msg) {
        return error(ResultStatus.FAIL, msg);
    }

    public static <T> ResultInfo<T> error(ResultStatus code, String msg) {
        return new ResultInfo<>(code, msg);
    }

    public static <T> ResultInfo<T> test(boolean test) {
        return test ? ok() : error();
    }

    public static <T> ResultInfo<T> test(boolean test, String msg) {
        return test ? ok() : error(msg);
    }
}
