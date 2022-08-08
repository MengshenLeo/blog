package fun.mengshenleo.blog.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * @author mengshen
 * @date 2022/8/8 0:14
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResultStatus {

    /*================= 状态码 ================== */

    SUCCESS(200, "成功"),

    FAIL(400, "失败"),

    INVALID_TOKEN(401, "无效 token"),

    INVALID_AUTHORITY(403, "您的权限不足"),

    SERVER_ERROR(500, "服务器错误"),
    ;

    private final Integer code;

    private final String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getName(Integer code) {
        switch (code){
            case 200:
                return "成功";
            case 401:
                return "无效 token";
            case 403:
                return "您的权限不足";
            case 500:
                return "服务器错误";
            default:
        }
        return "失败";
    }
}
