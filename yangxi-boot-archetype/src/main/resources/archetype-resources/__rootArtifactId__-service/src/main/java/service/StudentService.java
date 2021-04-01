package ${package}.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package}.dao.StudentDAO;
import ${package}.domain.dto.PageStudentDTO;
import ${package}.domain.dto.StudentDTO;
import ${package}.domain.entity.StudentDO;
import ${package}.domain.query.StudentQuery;
import ${package}.domain.request.AddStudentRequest;
import ${package}.domain.request.UpdateStudentRequest;
import ${package}.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生信息Service组件
 * @author yangxi
 * @version 1.0
 */
public interface StudentService {

    /**
     * 根据ID查询学生信息
     * @param id
     * @return
     */
    StudentDTO getStudentById(Long id);

    /**
     * 新增学生信息
     * @param addStudentRequest
     * @return
     */
    Boolean addStudent(AddStudentRequest addStudentRequest);

    /**
     * 更新学生信息
     * @param updateStudentRequest
     * @return
     */
    Boolean updateStudent(UpdateStudentRequest updateStudentRequest);

    /**
     * 根据ID删除学生信息
     * @param id
     * @return
     */
    Boolean deleteStudent(Long id);

    /**
     * 根据条件分页查询学生的基本信息（包含学校信息）
     * @param studentQuery
     */
    IPage<PageStudentDTO> pageStudent(StudentQuery studentQuery);
}