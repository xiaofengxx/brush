package site.zido.service.user;

import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.Shop;

import java.util.List;

/**
 * 店铺服务
 *
 * @author zido
 * @since 2017/6/6 0006
 */
public interface ShopService extends IService<Shop> {
    List<Shop> getByUserId(Long id);
}
