package com.yangxi.boot.sample.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
@ApiModel
public class PageSchoolQuery extends BaseQuery {

    private static final long serialVersionUID = 1L;

    /**
     * 根据学校名称模糊查询
     */
    @ApiModelProperty("学校名称")
    private String schoolName;
}