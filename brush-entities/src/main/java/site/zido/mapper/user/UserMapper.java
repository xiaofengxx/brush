package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import site.zido.entity.User;

import java.util.List;

/**
 * 用户mapper
 *
 * @author zido
 * @since 2017/5/29 0029
 */
public interface UserMapper extends BaseMapper<User> {
    public List<User> searchById();

    User findUserByUsername(String s);

}
