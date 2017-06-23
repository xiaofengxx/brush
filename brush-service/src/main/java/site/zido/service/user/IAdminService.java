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

    List<Admin> findAdminById(String id);
}