package site.zido.service.user.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import site.zido.entity.User;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.UserService;

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
    @Cacheable(value = "democache", key = "'allUser' + #id")
    public List<User> getAllUser(String id) {
        System.out.println("write write");
        return null;
    }

    @Override
    public User findLoginUser(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }

    @Override
    public User findAll(Integer id) {
        return userMapper.findAll(id);
    }

    @Override
    public void updateFail(User user) {
        userMapper.updateUser(user);
    }
}
