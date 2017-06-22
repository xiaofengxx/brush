package site.zido.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import site.zido.entity.Platforms;
import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.User;

/**
 * <p>
 * 平台表 服务类
 * </p>
 *
 * @author zido
 * @since 2017-06-20
 */
public interface IPlatformsService extends IService<Platforms> {

    /**
     * 指定用户删除平台
     * @param user
     * @param id
     * @return
     */
    boolean userDelete(User user, String id);

    /**
     * 删除平台
     * @param id
     * @return
     */
    boolean userDelete(String id);

    /**
     * 指定用户修改平台
     * @param user
     * @param platforms
     * @return
     */
	boolean userUpdata(User user, Platforms platforms);

    /**
     * 修改平台
     * @param platforms
     * @return
     */
    boolean userUpdata(Platforms platforms);

    /**
     * 指定用户添加平台
     * @param user
     * @param platforms
     * @return
     */
	boolean userInsert(User user,Platforms platforms);

    /**
     * 指定用户添加平台
     * @param platforms
     * @return
     */
    boolean userInsert(Platforms platforms);

    /**
     * 通过名称搜索
     * @param name
     * @return
     */
    Platforms selectByname(String name);


}
