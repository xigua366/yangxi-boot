package com.yangxi.boot.sample.service;

import com.yangxi.boot.common.core.PageResult;
import com.yangxi.boot.sample.domain.dto.PageSchoolDTO;
import com.yangxi.boot.sample.domain.dto.SchoolDTO;
import com.yangxi.boot.sample.domain.query.PageSchoolQuery;

/**
 * 学校信息Service组件
 * @author yangxi
 * @version 1.0
 */
public interface SchoolService {

    /**
     * 根据ID查询学校信息
     * @param id
     * @return
     */
    SchoolDTO getSchoolById(Long id);

    /**
     * 分页查询学校列表
     * @param pageSchoolQuery
     * @return
     */
    PageResult<SchoolDTO> pageSchool(PageSchoolQuery pageSchoolQuery);

    /**
     * 分页查询学校列表
     * @param pageSchoolQuery
     * @return
     */
    PageResult<PageSchoolDTO> pageSchool2(PageSchoolQuery pageSchoolQuery);
}