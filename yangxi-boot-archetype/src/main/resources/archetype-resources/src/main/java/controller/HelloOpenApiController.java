package ${package}.controller;

import com.deepexi.util.config.Payload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello world示例
 * @author yangxi
 * @version 1.0
 */
@Api(tags = "Hello world示例模块")
@RestController
@RequestMapping("/open-api/v1/test")
public class HelloOpenApiController {

    @ApiOperation("hello world测试接口")
    @GetMapping("hello")
    public Payload<String> hello(String name) {
        String result = "hello," + name;
        return new Payload<>(result);
    }
}