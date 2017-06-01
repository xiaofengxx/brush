package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.User;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/1 0001
 */
public interface BusinessUserMapper extends BaseMapper<BusinessUser> {
    public Integer selectMaxSort();

    String selectMaxUserName();
}
