package ${package}.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger ui 3.0版本的配置
 * @author yangxi
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * openapi接口文档
     *
     * @return
     */
    @Bean
    public Docket openapiApiDoc() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .pathMapping("/")
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yangxi"))
                //正则匹配请求路径，并分配到当前项目组
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .globalOperationParameters(globalOperationParameters());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("yang-boot基础开发平台")
                .description("xx系统接口文档")
                .contact(new Contact("admin", "https://www.xigua366.cn", "xigua366@163.com"))
                .version("v1.0")
                .build();
    }

    /**
     * 配置全局通用参数
     *
     * @return
     */
    private List<Parameter> globalOperationParameters() {

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("token")
                .description("令牌")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false)
                .build());

        return parameters;

    }

}