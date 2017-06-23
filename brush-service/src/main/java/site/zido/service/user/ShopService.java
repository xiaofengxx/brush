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
    /**
     * 通过用户id搜索
     * @param id
     * @return
     */
    List<Shop> getByUserId(Long id);

    /**
     * 根据userid和shopid共同搜索
     * @param userid
     * @param shopid
     * @return
     */
    Shop getByUserIdShopId(Long userid,Long shopid);
}
