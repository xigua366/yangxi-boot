package ${package}.domain.query;

import com.deepexi.util.domain.query.BaseQuery;
import lombok.Data;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
public class StudentQuery extends BaseQuery {

    private static final long serialVersionUID = 1L;

    /**
     * 根据学生姓名模糊查询学生信息
     */
    private String name;
}