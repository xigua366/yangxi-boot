package ${package}.domain.dto;

import com.yangxi.boot.framework.domain.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
@ApiModel
public class StudentDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("学校ID")
    private Long schoolId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty(value = "年龄", example = "20")
    private Integer age;

    @ApiModelProperty(value = "性别", example = "1")
    private Integer sex;

}