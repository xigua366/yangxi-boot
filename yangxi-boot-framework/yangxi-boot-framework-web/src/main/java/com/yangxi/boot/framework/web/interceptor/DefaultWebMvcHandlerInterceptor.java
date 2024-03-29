package com.yangxi.boot.framework.web.interceptor;

import com.yangxi.boot.framework.web.constant.TenantContextConstant;
import com.yangxi.boot.framework.web.context.TenantContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认的Spring mvc拦截器组件
 *
 * @author yangxi
 * @version 1.0
 */
public class DefaultWebMvcHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantId = request.getHeader(TenantContextConstant.TENANT_ID);
        if(tenantId == null || "".equals(tenantId)) {
            tenantId = request.getParameter(TenantContextConstant.TENANT_ID);
        }

        if(tenantId != null && !"".equals(tenantId)) {
            TenantContext.setTenantId(tenantId);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TenantContext.clear();
    }
}
