package ${package}.domain.dto;

import com.yangxi.boot.framework.domain.dto.BaseDTO;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
@ApiModel
public class PageSchoolDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("地址")
    private String address;
}