package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import site.zido.dto.BusinessUserInfoDTO;
import site.zido.entity.User;

import java.util.List;

/**
 * 用户mapper
 *
 * @author zido
 * @since 2017/5/29 0029
 */
public interface UserMapper extends BaseMapper<User> {

    User findUserByUsername(String s);

    void updateUser(User user1);

    /**
     * 获取当前最大用户名
     * @return
     */
    String selectMaxUserName();

    //通过用户id修改密码
     void updatePwdById(User user);

    User selectBySubUsername(String username);

    User findLonuserBynameAndPwd(String username, String password);
}
