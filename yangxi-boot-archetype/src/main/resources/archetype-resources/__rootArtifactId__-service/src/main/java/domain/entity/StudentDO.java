package ${package}.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxi.boot.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
@TableName("t_student")
public class StudentDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long schoolId;

    private String name;

    private Integer age;

    private Integer sex;
}