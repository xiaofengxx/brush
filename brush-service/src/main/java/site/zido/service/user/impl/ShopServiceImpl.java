package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.zido.entity.Shop;
import site.zido.mapper.user.ShopMapper;
import site.zido.service.user.ShopService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺服务
 *
 * @author zido
 * @since 2017/6/6 0006
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper,Shop> implements ShopService {
    @Resource
    private ShopMapper shopMapper;
    @Override
    public List<Shop> getByUserId(Long id) {
        return shopMapper.selectList(new EntityWrapper<Shop>().where("user_id = {0}",id));
    }
}
