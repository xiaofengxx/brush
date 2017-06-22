package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.EntityUtils;
import site.zido.entity.Platforms;
import org.springframework.stereotype.Service;
import site.zido.entity.User;
import site.zido.mapper.user.PlatformsMapper;
import site.zido.service.user.IPlatformsService;

import javax.annotation.Resource;

/**
 * <p>
 * 平台表 服务实现类
 * </p>
 *
 * @author zido
 * @since 2017-06-20
 */
@Service
public class PlatformsServiceImpl extends ServiceImpl<PlatformsMapper, Platforms> implements IPlatformsService {

    @Resource
    private PlatformsMapper platformsMapper;

    @Override
    @Transactional
    public boolean userDelete(User user, String id) {

        boolean delete = delete(new EntityWrapper<Platforms>().where("id = {0}", id));

        return delete;
    }


    @Override
    @Transactional
    public boolean userUpdata(User user, Platforms platforms) {

        boolean update = update(platforms, new EntityWrapper<Platforms>().where("id = {0}", platforms.getId()));

        return update;
    }


    @Override
    public boolean userInsert(User user, Platforms platforms) {

        platforms.setId(EntityUtils.generatorId());

        boolean insert = insert(platforms);

        return insert;
    }

    @Override
    public boolean userDelete(String id) {

        return userDelete(null,id);
    }


    @Override
    public boolean userUpdata(Platforms platforms) {
        return userUpdata(null,platforms);
    }


    @Override
    public boolean userInsert(Platforms platforms) {
        return userInsert(null,platforms);
    }

    @Override
    public Platforms selectByname(String name) {

        Object o = selectObj(new EntityWrapper<Platforms>().where("platform_name = {0}", name));

        return (Platforms) o;
    }
}
