package site.zido.service.user.impl;

import org.springframework.stereotype.Service;
import site.zido.entity.User;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.UserService;
import springfox.documentation.annotations.Cacheable;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/29 0029
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    @Cacheable("getAllUser")
    public List<User> getAllUser(String id) {
        return userMapper.searchById();
    }
}
