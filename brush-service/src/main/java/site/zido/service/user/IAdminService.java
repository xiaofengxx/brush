package site.zido.service.user;

import site.zido.entity.Admin;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zido
 * @since 2017-06-22
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 通过ID找用户
     * @param id
     * @return
     */
    Admin findAdminById(String id);

    /**
     * 添加管理员
     * @param admin
     */
    void insertAdmin(Admin admin);

    /**
     * 通过id找用户
     * @param id
     * @return
     *//*
    List<Admin> findAllAdminById(String id);*/

    /**
     * 通过id修改用户状态
     * @param id
     */
    void updateState(String id);

    List<Admin> findAllAdmin();
}
