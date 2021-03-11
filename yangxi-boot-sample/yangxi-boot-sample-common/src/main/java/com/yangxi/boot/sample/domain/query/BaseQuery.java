package com.yangxi.boot.sample.domain.query;

import com.yangxi.boot.sample.utils.AbstractObject;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author yangxi
 * @version 1.0
 */
public abstract class BaseQuery extends AbstractObject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分页参数  第几页
     */
    @ApiModelProperty("第几页")
    private long page = 1;

    /**
     * 分页参数 每页显示多少条记录
     */
    @ApiModelProperty("每页显示多少条记录")
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