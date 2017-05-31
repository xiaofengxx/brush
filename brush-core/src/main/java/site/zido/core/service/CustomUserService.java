package site.zido.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import site.zido.core.common.config.security.SysUser;
import site.zido.entity.User;
import site.zido.mapper.user.UserMapper;

import javax.annotation.Resource;

/**
 * 用户认证服务
 * Date: 2017/3/22 0022
 * Time: 20:17
 *
 * @author <a href="http://zido.site">wuhongxu</a>.
 * @version 1.0.0
 */
public class CustomUserService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Cacheable("#s")
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.findUserByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("该账号不存在");
        return new SysUser(user);
    }
}
