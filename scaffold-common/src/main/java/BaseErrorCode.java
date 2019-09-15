/**
 * Created by liuyuzhe on 2019/9/16.
 */
public enum BaseErrorCode {
    PARAMETER_ILLEGAL("400", "paramter illegal"),
    SYSTEM_INTERNAL_ERROR("500", "system internal error"),
    FORBIDDEN("403", "forbidden");

    private String code;
    private String msg;

    BaseErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
