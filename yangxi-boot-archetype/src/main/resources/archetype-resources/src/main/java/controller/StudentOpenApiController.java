package ${package}.controller;

import ${package}.domain.dto.PageStudentDTO;
import ${package}.domain.dto.SchoolDTO;
import ${package}.domain.dto.StudentDTO;
import ${package}.domain.query.StudentQuery;
import ${package}.domain.request.AddStudentRequest;
import ${package}.domain.request.UpdateStudentRequest;
import ${package}.domain.vo.StudentVO;
import ${package}.service.SchoolService;
import ${package}.service.StudentService;
import com.deepexi.util.config.Payload;
import com.deepexi.util.pageHelper.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangxi
 * @version 1.0
 */
@Api(tags = "学生管理模块")
@RestController
@RequestMapping("/open-api/v1/student")
public class StudentOpenApiController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolService schoolService;

    /**
     *
     * 用于演示Controller层返回结果直接使用DTO类
     *
     * 根据ID查询学生基本信息（不返回学校信息）
     * @param studentId
     * @return
     */
    @ApiOperation("根据ID查询学生基本信息（不返回学校信息）")
    @GetMapping("{studentId}")
    public Payload<StudentDTO> getStudentById(@ApiParam(value = "学生id",required = true) @PathVariable("studentId") Long studentId) {
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        return new Payload<>(studentDTO);
    }

    /**
     * 用于演示Controller层调用多个Service接口，使用VO类组装多个DTO返回
     *
     * 根据ID查询学生详细信息（包含学校信息）
     * @param studentId
     * @return
     */
    @ApiOperation("根据ID查询学生详细信息（包含学校信息）")
    @GetMapping("detail/{studentId}")
    public Payload<StudentVO> detailStudentById(@ApiParam(value = "学生id",required = true) @PathVariable("studentId") Long studentId) {
        StudentDTO studentDTO = studentService.getStudentById(studentId);

        StudentVO studentVO = null;
        SchoolDTO schoolDTO = null;
        if(studentDTO != null) {
            schoolDTO = schoolService.getSchoolById(studentDTO.getSchoolId());
            studentVO = schoolDTO.clone(StudentVO.class);

            if(studentVO != null) {
                studentVO.setSchoolName(schoolDTO.getName());
            }
        }

        return new Payload<>(studentVO);
    }

    /**
     * 用于演示Controller层非查询请求，请求参数使用Request封装
     *
     * 新增学生
     * @param addStudentRequest
     * @return
     */
    @ApiOperation("新增学生")
    @PutMapping("add")
    public Payload<Boolean> addStudent(@ApiParam("新增学生信息对象") @RequestBody AddStudentRequest addStudentRequest) {
        Boolean result = studentService.addStudent(addStudentRequest);
        return new Payload<>(result);
    }

    /**
     * 用于演示Controller层非查询请求，请求参数使用Request封装
     *
     * 更新学生信息
     * @param updateStudentRequest
     * @return
     */
    @ApiOperation("更新学生信息")
    @PostMapping("update")
    public Payload<Boolean> updateStudent(@ApiParam("更新学生信息对象") @RequestBody UpdateStudentRequest updateStudentRequest) {
        Boolean result = studentService.updateStudent(updateStudentRequest);
        return new Payload<>(result);
    }

    /**
     * 基本数据类型，包装数据类型，字符串数据类型等对象直接返回即可，不需要用POJO类进行封装
     *
     * 删除学生信息
     * @param studentId
     * @return
     */
    @ApiOperation("删除学生信息")
    @DeleteMapping("delete/{studentId}")
    public Payload<Boolean> deleteStudent(@ApiParam(value = "学生id",required = true) @PathVariable("studentId") Long studentId) {
        Boolean result = studentService.deleteStudent(studentId);
        return new Payload<>(result);
    }

    /**
     * 用于演示Controller层查询请求，查询条件使用Query类封装
     * 同时对于一些多表关联查询的特殊请求，Service层与Mapper层也可以直接返回现有存在的VO组件
     *
     * 根据条件分页查询学生的基本信息（包含学校信息）
     *
     * 多表关联查询需在在Mapper.xml写自定义SQL语句
     *
     * @param studentQuery
     * @return
     */
    @ApiOperation("根据条件分页查询学生的基本信息（包含学校信息）")
    @GetMapping("page")
    public Payload<PageBean<PageStudentDTO>> pageStudent(StudentQuery studentQuery) {
        PageBean<PageStudentDTO> pageBean = studentService.pageStudent(studentQuery);
        return new Payload<>(pageBean);
    }
}