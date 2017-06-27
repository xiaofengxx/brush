package site.zido.mapper.user;

import site.zido.entity.Admin;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zido
 * @since 2017-06-22
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin findAdminById(String id);

    void updateState(String id);

    List<Admin> findAllAdmin();

}