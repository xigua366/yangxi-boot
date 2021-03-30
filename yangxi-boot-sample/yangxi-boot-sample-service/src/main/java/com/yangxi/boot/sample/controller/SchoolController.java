package com.yangxi.boot.sample.controller;

import com.yangxi.boot.common.core.JsonData;
import com.yangxi.boot.common.core.PageResult;
import com.yangxi.boot.sample.domain.dto.PageSchoolDTO;
import com.yangxi.boot.sample.domain.dto.SchoolDTO;
import com.yangxi.boot.sample.domain.query.PageSchoolQuery;
import com.yangxi.boot.sample.service.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangxi
 * @version 1.0
 */
@Api(tags = "学校管理模块")
@RestController
@RequestMapping("/api/v1/pri/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    /**
     * 分页查询某个学校列表1（用于演示mybatis plus BaseMapper内置API实现单表分页功能）
     * @param pageSchoolQuery
     * @return
     */
    @ApiOperation("分页查询某个学校列表1")
    @GetMapping("/page-school")
    public JsonData pageSchool(PageSchoolQuery pageSchoolQuery) {
        PageResult<SchoolDTO> pageResult = schoolService.pageSchool(pageSchoolQuery);
        return JsonData.buildSuccess(pageResult);
    }

    /**
     * 分页查询某个学校列表2（用于演示在Mapper.xml文件中写自定义SQL实现分页功能）
     * @param pageSchoolQuery
     * @return
     */
    @ApiOperation("分页查询某个学校列表2")
    @GetMapping("/page-school2")
    public JsonData pageSchool2(PageSchoolQuery pageSchoolQuery) {
        PageResult<PageSchoolDTO> pageResult = schoolService.pageSchool2(pageSchoolQuery);
        return JsonData.buildSuccess(pageResult);
    }


}