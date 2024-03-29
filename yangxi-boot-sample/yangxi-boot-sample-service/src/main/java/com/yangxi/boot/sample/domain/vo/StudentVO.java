package com.yangxi.boot.sample.domain.vo;

import com.yangxi.boot.framework.domain.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 学生信息返回VO对象
 * @author yangxi
 * @version 1.0
 */
@Data
@ApiModel
public class StudentVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("学校名称")
    private String schoolName;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private Integer sex;

    /**
     * 其它字段1
     */
    @ApiModelProperty("其它字段1")
    private String other1;

    /**
     * 其它字段2
     */
    @ApiModelProperty("其它字段2")
    private String other2;

}