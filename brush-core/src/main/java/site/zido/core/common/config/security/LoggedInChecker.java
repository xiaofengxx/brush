package site.zido.core.common.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import site.zido.entity.User;

/**
 * 用户检测工具
 * <p>
 * Date:17-5-3 上午2:15
 *
 * @author <a href="zido.site">zido</a>
 * @version 1.0.0
 */
@Component
public class LoggedInChecker {
    public User getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if(authentication != null){
            Object principal = authentication.getPrincipal();
            if(principal instanceof SysUser){
                user = ((SysUser) principal).getUser();
            }
        }
        return user;
    }
}
