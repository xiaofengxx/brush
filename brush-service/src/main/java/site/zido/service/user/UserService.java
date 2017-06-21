package site.zido.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import site.zido.dto.BusinessUserInfoDTO;
import site.zido.entity.User;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/29 0029
 */
public interface UserService extends IService<User>{
    public List<User> getAllUser(String id);

    /**
     * 通过用户名得到用户, 刷手用户注册时判定重复
     * @param username
     * @return User
     */
    User getUserByUserName(String username);

    void updateFail(User user);


    /**
     *  得到一个新的用户名
     *  根据用户名递增取最大值
     * @return
     */
    Long getnewusername();

    /**
     *  得到最大的用户名
     * @return
     */
    Long getmaxusername();

    /**
     * 通过ID 为用户实例创建 用户和密码
     * @param user
     */
    void autoCreateIdAndPws(User user);

    /**
     * 通过id，用户，刷手或者平台管理员修改密码
     * @param user
     */
    void updatePwd(User user);

    /**
     * 作废刷手
     * @param user
     */
    void cancelUser(User user);
}
