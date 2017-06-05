package site.zido.service.user;

import site.zido.entity.User;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/29 0029
 */
public interface UserService {
    public List<User> getAllUser(String id);

    User findLoginUser(String loginname);

    User findAll(Integer id);

    void updateFail(User user);
}
