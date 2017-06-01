package site.zido.service.user;

import site.zido.core.exception.ServiceException;
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
public interface BusinessUserService {
    /**
     * 获取最大的商铺序列号
     * @return 序列号
     */
    public Integer getMaxSort();

    public String getMaxUserName();

    void save(User user, BusinessUser businessUser, List<BankCard> bankCards);
}
