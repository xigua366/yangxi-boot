package com.yangxi.boot.framework.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yangxi
 * @version 1.0
 */
@ApiModel
public abstract class BasePageQuery extends BaseQuery {

    private static final long serialVersionUID = 1L;

    /**
     * 分页参数  第几页
     */
    @ApiModelProperty(value = "第几页", example = "1")
    private long page = 1;

    /**
     * 分页参数 每页显示多少条记录
     */
    @ApiModelProperty(value = "每页显示多少条记录", example = "10")
    private long size = 10;

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}