package com.yangxi.boot.sample.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
public class PageResult<T> {

    /**
     * 总记录数
     */
    @JsonProperty("total_record")
    private long totalRecord;

    /**
     * 总页数
     */
    @JsonProperty("total_page")
    private long totalPage;

    /**
     * 当前页的记录
     */
    @JsonProperty("current_data")
    private List<T> currentData;

    public PageResult(IPage<T> page) {
        this.totalRecord = page.getTotal();
        this.totalPage = page.getPages();
        this.currentData = page.getRecords();
    }

}