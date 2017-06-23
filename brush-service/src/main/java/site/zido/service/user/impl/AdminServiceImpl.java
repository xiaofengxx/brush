package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import site.zido.entity.Admin;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.zido.mapper.user.AdminMapper;
import site.zido.service.user.IAdminService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zido
 * @since 2017-06-22
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAdminById(String id) {
        return adminMapper.selectList(new EntityWrapper<Admin>().where("id = {0}", id));
    }
}
