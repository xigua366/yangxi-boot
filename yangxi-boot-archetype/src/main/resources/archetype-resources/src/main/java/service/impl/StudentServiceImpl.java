package ${package}.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package}.dao.StudentDAO;
import ${package}.domain.dto.PageStudentDTO;
import ${package}.domain.dto.StudentDTO;
import ${package}.domain.entity.StudentDO;
import ${package}.domain.query.StudentQuery;
import ${package}.domain.request.AddStudentRequest;
import ${package}.domain.request.UpdateStudentRequest;
import ${package}.extension.AppRuntimeEnv;
import ${package}.service.StudentService;
import com.deepexi.util.pageHelper.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangxi
 * @version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    /**
     * 根据ID查询学生信息
     * @param id 学生ID
     * @return
     */
    @Override
    public StudentDTO getStudentById(Long id) {
        StudentDO studentDO = studentDAO.getById(id);
        if(studentDO == null) {
            return null;
        }
        return studentDO.clone(StudentDTO.class);
    }

    /**
     * 新增学生信息
     * @param addStudentRequest
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addStudent(AddStudentRequest addStudentRequest) {
        StudentDO studentDO = addStudentRequest.clone(StudentDO.class);
        Long appId = AppRuntimeEnv.getAppId();
        studentDO.setAppId(appId);
        return studentDAO.save(studentDO);
    }

    /**
     * 更新学生信息
     * @param updateStudentRequest
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateStudent(UpdateStudentRequest updateStudentRequest) {
        StudentDO studentDO = updateStudentRequest.clone(StudentDO.class);
        return studentDAO.updateById(studentDO);
    }

    /**
     * 删除学生信息
     * @param id 学生ID
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteStudent(Long id) {
        return studentDAO.removeById(id);
    }

    /**
     * 根据条件分页查询学生的基本信息（包含学校信息）
     * @param studentQuery
     * @return
     */
    @Override
    public PageBean<PageStudentDTO> pageStudent(StudentQuery studentQuery) {
        IPage<PageStudentDTO> studentPage = studentDAO.pageStudent(studentQuery.getPage(), studentQuery.getSize(), studentQuery.getName());
        return new PageBean<>(studentPage);
    }
}