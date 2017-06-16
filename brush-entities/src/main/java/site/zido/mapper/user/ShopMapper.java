package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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

    void deleteNotRange(@Param("shops") List<Shop> shops);
}
