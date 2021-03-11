package ${package}.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.deepexi.util.domain.entity.BaseEntity;
import lombok.Data;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
@TableName("t_school")
public class SchoolDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String address;

}