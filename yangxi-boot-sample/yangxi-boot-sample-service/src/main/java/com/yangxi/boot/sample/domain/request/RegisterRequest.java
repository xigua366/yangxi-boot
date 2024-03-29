package com.yangxi.boot.sample.domain.request;

import com.yangxi.boot.framework.domain.request.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户注册 request
 * @author yangxi
 * @version 1.0
 */
@Data
@ApiModel
public class RegisterRequest extends BaseRequest {

    /**
     * 昵称
     */
    @ApiModelProperty(value = "用户昵称", example = "韦小宝")
    private String name;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机号码", example = "13812345543")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", example = "123456")
    private String pwd;
}