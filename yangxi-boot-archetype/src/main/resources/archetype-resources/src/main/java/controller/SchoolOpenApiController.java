package ${package}.controller;

import ${package}.domain.dto.PageSchoolDTO;
import ${package}.domain.dto.SchoolDTO;
import ${package}.domain.query.PageSchoolQuery;
import ${package}.service.SchoolService;
import com.deepexi.util.config.Payload;
import com.deepexi.util.pageHelper.PageBean;
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
@RequestMapping("/open-api/v1/school")
public class SchoolOpenApiController {

    @Autowired
    private SchoolService schoolService;

    /**
     * 分页查询某个学校列表1（用于演示mybatis plus BaseMapper内置API实现单表分页功能）
     * @param pageSchoolQuery
     * @return
     */
    @ApiOperation("分页查询某个学校列表1")
    @GetMapping("/page-school")
    public Payload<PageBean<SchoolDTO>> pageSchool(PageSchoolQuery pageSchoolQuery) {
        PageBean<SchoolDTO> pageBean = schoolService.pageSchool(pageSchoolQuery);
        return new Payload<>(pageBean);
    }

    /**
     * 分页查询某个学校列表2（用于演示在Mapper.xml文件中写自定义SQL实现分页功能）
     * @param pageSchoolQuery
     * @return
     */
    @ApiOperation("分页查询某个学校列表2")
    @GetMapping("/page-school2")
    public Payload<PageBean<PageSchoolDTO>> pageSchool2(PageSchoolQuery pageSchoolQuery) {
        PageBean<PageSchoolDTO> pageBean = schoolService.pageSchool2(pageSchoolQuery);
        return new Payload<>(pageBean);
    }


}