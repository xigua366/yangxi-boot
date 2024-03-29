package ${package}.config;

import com.yangxi.boot.framework.core.JsonData;
import com.yangxi.boot.framework.web.utils.CommonUtil;
import ${package}.exception.BizCodeEnum;
import ${package}.utils.JWTUtil;
import ${package}.domain.LoginUser;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangxi
 * 登录拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String accessToken = request.getHeader("token");
        if(accessToken == null) {
            accessToken = request.getParameter("token");
        }

        if(StringUtils.isNotBlank(accessToken)) {
            //不为空
            Claims claims = JWTUtil.checkJWT(accessToken);
            if(claims == null){
                //未登录
                CommonUtil.sendJsonMessage(response, JsonData.buildError(BizCodeEnum.ACCOUNT_UNLOGIN));
                return false;
            }

            Long userId = Long.parseLong(claims.get("id").toString());
            String headImg = (String)claims.get("head_img");
            String name = (String)claims.get("name");
            String mail = (String)claims.get("mail");
            String phone = (String)claims.get("phone");

            LoginUser loginUser = new LoginUser();
            loginUser.setName(name);
            loginUser.setHeadImg(headImg);
            loginUser.setId(userId);
            loginUser.setMail(mail);
            loginUser.setPhone(phone);

            threadLocal.set(loginUser);
            return true;
        }

        CommonUtil.sendJsonMessage(response, JsonData.buildError(BizCodeEnum.ACCOUNT_UNLOGIN));
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 每次请求完成后都清空一下
        threadLocal.remove();
    }
}