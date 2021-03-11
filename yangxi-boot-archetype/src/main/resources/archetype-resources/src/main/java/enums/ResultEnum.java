package ${package}.enums;

import com.deepexi.util.constant.BaseEnumType;

/**
 * Created by donh on 2019/1/8.
 */
public enum ResultEnum implements BaseEnumType {

    /**
     * 公共请求
     */
    UNKNOWN_ERROR("500", "系统出异常啦!请联系管理员!!!"),
    SUCCESS("200", "success"),
    USER_EXIST("100002", "用户已存在！"),
    NETWORK_LIMIT("100001", "网络限流！"),
    TOKEN_NOT_FOUND("200001", "token不能为空！"),
    TENANT_ID_NOT_FOUND("200002", "tenantId不能为空！"),
    USERNAME_NOT_FOUND("200003", "username不能为空！"),
    REQUEST_ID_NOT_FOUND("200004", "requestId不能为空！"),
    QUERY_PARAM_NOT_FOUND("200005", "查询参数不能为空"),
    REQUEST_PARAM_NOT_FOUND("200006", "请求参数不能为空");

    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}