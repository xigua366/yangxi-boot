package ${package}.extension;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认的Spring mvc拦截器组件
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-30 10:57
 */
public class DefaultSpringMvcInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantId = request.getHeader("tenantId");
        if(StringUtils.isEmpty(tenantId)) {
            tenantId = request.getParameter("tenantId");
        }

        String appId = request.getHeader("appId");
        if(StringUtils.isEmpty(appId)) {
            appId = request.getParameter("appId");
        }

        String userId = request.getHeader("userId");
        if(StringUtils.isEmpty(appId)) {
            userId = request.getParameter("userId");
        }

        String userName = request.getHeader("userName");
        if(StringUtils.isEmpty(appId)) {
            userId = request.getParameter("userName");
        }

        String traceId = request.getHeader("traceId");
        if(StringUtils.isEmpty(appId)) {
            traceId = request.getParameter("traceId");
        }

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }

        // 先清空上下文
        AppRuntimeEnv.clear();

        AppRuntimeEnv.setTenantId(tenantId);
        if(appId != null) {
            AppRuntimeEnv.setAppId(new Long(appId));
        } else {
            AppRuntimeEnv.setAppId(0L);
        }
        if(userId != null) {
            AppRuntimeEnv.setUserId(new Long(userId));
        } else {
            AppRuntimeEnv.setUserId(0L);
        }
        AppRuntimeEnv.setUsername(userName);
        AppRuntimeEnv.setTraceId(traceId);

        return true;
    }
}