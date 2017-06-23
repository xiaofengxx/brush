package site.zido.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import site.zido.dto.BusinessUserInfoDTO;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.Shop;
import site.zido.entity.User;
import site.zido.dto.BusinessCondition;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/1 0001
 */
public interface BusinessUserService extends IService<BusinessUser> {
    /**
     * 获取最大的商铺序列号
     * @return 序列号
     */
    public Integer getMaxSort();

    public String getMaxUserName();

    /**
     * 保存商家用户
     * @param user 用户对象
     * @param businessUser 商家对象
     * @param bankCards 银行卡集合
     * @param shops 店铺集合
     */
    void save(User user, BusinessUser businessUser, List<BankCard> bankCards, List<Shop> shops);

    void autoCreateIdAndPws(User user);

    BusinessUser selectByUserId(Long id);

    Page<BusinessUserInfoDTO> selectBusinessList(Integer currentPage, Integer pageSize, BusinessCondition condition);

    void updateBusiness(User user, BusinessUser businessUser, List<BankCard> bankCards, List<Shop> shops);

    boolean updateStateByUserId(Long id, Integer state);

    List<BusinessUser> selectByKey(String key,Integer max);

    BusinessUser selectByNickname(String introduceName);

    boolean deleteBusinessUser(Long id);

    String findBusinessNumber(String adPhoneNumber);
}
