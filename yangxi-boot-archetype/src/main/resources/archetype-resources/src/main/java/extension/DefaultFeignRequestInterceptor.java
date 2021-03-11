package ${package}.extension;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * 默认的openfeign拦截器组件
 *
 * @author yangxi
 */
@Component
public class DefaultFeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        // feign调用下游服务默认增加的header信息
        String tenantId = AppRuntimeEnv.getTenantId();
        Long appId = AppRuntimeEnv.getAppId();
        Long userId = AppRuntimeEnv.getUserId();
        String username = AppRuntimeEnv.getUsername();
        String traceId = AppRuntimeEnv.getTraceId();

        if(tenantId != null && !"".equals(tenantId)) {
            template.header("tenantId", tenantId);
        }
        if(appId != null) {
            template.header("appId", appId.toString());
        }
        if(userId != null) {
            template.header("userId", userId.toString());
        }
        if(username != null && !"".equals(username)) {
            template.header("username", username);
        }
        if(traceId != null && !"".equals(traceId)) {
            template.header("traceId", traceId);
        }
    }

}