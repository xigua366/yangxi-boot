package ${package}.extension;

/**
 * 应用运行时上下文
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-09-02 14:42
 */
public class AppRuntimeEnv {

    /**
     * 租户ID
     * 支持父子线程之间的数据传递
     */
    private static final ThreadLocal<String> TENANT_ID = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        TENANT_ID.set(tenantId);
    }

    public static String getTenantId() {
        return TENANT_ID.get();
    }

    /**
     * 应用ID
     */
    private static final ThreadLocal<Long> APP_ID = new ThreadLocal<>();

    public static void setAppId(Long appId) {
        APP_ID.set(appId);
    }

    public static Long getAppId() {
        return APP_ID.get();
    }

    /**
     * 用户ID
     */
    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        USER_ID.set(userId);
    }

    public static Long getUserId() {
        return USER_ID.get();
    }

    /**
     * 用户名
     */
    private static final ThreadLocal<String> USERNAME = new ThreadLocal<>();

    public static void setUsername(String username) {
        USERNAME.set(username);
    }

    public static String getUsername() {
        return USERNAME.get();
    }

    /**
     * Skyalking traceId
     */
    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_ID.get();
    }

    /**
     * 清空上下文信息
     */
    public static void clear() {
        TENANT_ID.remove();
        APP_ID.remove();
        USER_ID.remove();
        USERNAME.remove();
        TRACE_ID.remove();
    }
}