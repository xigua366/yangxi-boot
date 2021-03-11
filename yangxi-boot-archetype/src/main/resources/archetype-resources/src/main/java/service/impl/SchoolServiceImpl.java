package ${package}.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package}.dao.SchoolDAO;
import ${package}.domain.dto.PageSchoolDTO;
import ${package}.domain.entity.SchoolDO;
import ${package}.domain.query.PageSchoolQuery;
import ${package}.domain.dto.SchoolDTO;
import ${package}.service.SchoolService;
import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.util.pojo.ObjectCloneUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangxi
 * @version 1.0
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDAO schoolDAO;

    /**
     * 根据ID查询学校信息
     * @param id
     * @return
     */
    @Override
    public SchoolDTO getSchoolById(Long id) {
        SchoolDO schoolDO = schoolDAO.getById(id);
        if(schoolDO == null) {
            return null;
        }
        return schoolDO.clone(SchoolDTO.class);
    }

    /**
     *
     * 主要演示直接使用BaseMapper的分页查询API进行单表分页查询，以及使用ObjectCloneUtils工具直接clone mybatis plus的IPage对象
     *
     * 分页查询学校列表
     * @param pageSchoolQuery
     * @return
     */
    @Override
    public PageBean<SchoolDTO> pageSchool(PageSchoolQuery pageSchoolQuery) {
        Page<SchoolDO> pageParam = new Page<SchoolDO>(pageSchoolQuery.getPage(), pageSchoolQuery.getSize());
        IPage<SchoolDO> page = schoolDAO.page(pageParam, new QueryWrapper<SchoolDO>().like("name", pageSchoolQuery.getSchoolName()));
        // 可以使用ObjectCloneUtils工具类直接clone IPage对象
        IPage<SchoolDTO> targetPage = ObjectCloneUtils.convertPage(page, SchoolDTO.class);
        // 上面的是浅拷贝操作，如果有深拷贝的需要，使用有cloneDirection参数的方法即可，如下
        // IPage<SchoolDTO> targetPage = ObjectCloneUtils.convertPage(page, SchoolDTO.class, CloneDirection.OPPOSITE);

        PageBean<SchoolDTO> pageBean = new PageBean<>(targetPage);
        return pageBean;
    }

    /**
     *
     * 分页查询可以直接在Mapper.xml文件中指定返回DTO对象。
     *
     * 根据名称模糊查询学校信息并分页
     *
     * @param pageSchoolQuery
     * @return
     */
    @Override
    public PageBean<PageSchoolDTO> pageSchool2(PageSchoolQuery pageSchoolQuery) {
        IPage<PageSchoolDTO> list = schoolDAO.pageSchool2(pageSchoolQuery.getPage(), pageSchoolQuery.getSize(), pageSchoolQuery.getSchoolName());
        return new PageBean<>(list);
    }
}