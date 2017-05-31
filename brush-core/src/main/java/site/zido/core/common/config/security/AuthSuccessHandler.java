package site.zido.core.common.config.security;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import site.zido.core.dto.AjaxResult;
import site.zido.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证成功处理器
 * <p>
 * Date:17-5-3 上午12:42
 *
 * @author <a href="zido.site">zido</a>
 * @version 1.0.0
 */
@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthSuccessHandler.class);


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);

        User user = (User) authentication.getPrincipal();
        LOGGER.info(user.getUsername() + " got is connected ");
        // 在servlet中输出中文，如果采用PrintWriter方式，
        // 需要在调用getPrintWriter()之前调用setContentType 或者 setCharacterEncoding；
        // 采用ServletOutputStream方式，不受此限。
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        //登录成功
        JSON.writeJSONString(writer,new AjaxResult(true,"登录成功"));
        writer.flush();
    }
}