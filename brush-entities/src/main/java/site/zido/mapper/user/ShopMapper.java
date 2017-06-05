package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import site.zido.entity.Shop;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/5 0005
 */
public interface ShopMapper extends BaseMapper<Shop> {
    void insertBatch(List<Shop> shops);
}
