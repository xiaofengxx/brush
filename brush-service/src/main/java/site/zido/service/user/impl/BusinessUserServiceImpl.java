package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.dto.BusinessUserInfoDTO;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.Shop;
import site.zido.entity.User;
import site.zido.mapper.user.BankCardMapper;
import site.zido.mapper.user.BusinessUserMapper;
import site.zido.mapper.user.ShopMapper;
import site.zido.mapper.user.UserMapper;
import site.zido.dto.BusinessCondition;
import site.zido.service.user.BankCardService;
import site.zido.service.user.BusinessUserService;
import site.zido.service.user.ShopService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/1 0001
 */
@Service
public class BusinessUserServiceImpl extends ServiceImpl<BusinessUserMapper, BusinessUser> implements BusinessUserService {
    @Resource
    private BusinessUserMapper businessUserMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private BusinessUserService businessUserService;
    @Resource
    private BankCardMapper bankCardMapper;
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private BankCardService bankCardService;
    @Resource
    private ShopService shopService;
    @Resource
    private UserService userService;

    @Override
    public Integer getMaxSort() {
        return businessUserMapper.selectMaxSort();
    }

    @Override
    public String getMaxUserName() {
        return businessUserMapper.selectMaxUserName();
    }

    /**
     * 保存商家用户
     *
     * @param user         用户对象
     * @param businessUser 商家对象
     * @param bankCards    银行卡集合
     * @param shops        店铺集合
     */
    @Override
    @Transactional
    public synchronized void save(User user, BusinessUser businessUser, List<BankCard> bankCards, List<Shop> shops) {
        userMapper.insert(user);
        Integer maxSort = getMaxSort();
        businessUser.setSort(++maxSort);
        businessUserMapper.insert(businessUser);
        bankCardService.insertBatch(bankCards);
        shopService.insertBatch(shops);
    }


    @Override
    @Transactional
    public synchronized void autoCreateIdAndPws(User user) {
        String maxUserName = businessUserService.getMaxUserName();
        if (maxUserName == null)
            maxUserName = "10003";
        Long aLong = Long.valueOf(maxUserName);
        aLong++;
        user.setUsername(aLong + "");
        user.setPassword("123456");
        user.setEnabled(1);
        updateStateByUserId(user.getId(), 1);
        userMapper.updateById(user);
    }

    /**
     * 通过用户id更新商家审核状态
     *
     * @param userId 用户id
     * @param state  审核状态
     * @return 是否成功
     */
    public boolean updateStateByUserId(Long userId, Integer state) {
        return businessUserService.update(
                new BusinessUser().setState(state),
                new EntityWrapper<BusinessUser>().where("user_id = {0}", userId));
    }

    @Override
    public List<BusinessUser> selectByKey(String key, Integer max) {
        return businessUserMapper.selectByKey(key, 1, max);
    }

    @Override
    public BusinessUser selectByNickname(String introduceName) {
        return businessUserService.selectOne(new EntityWrapper<BusinessUser>().where("nickname = {0}", introduceName));
    }

    @Override
    @Transactional
    public boolean deleteBusinessUser(Long id) {
        BusinessUser businessUser = selectById(id);
        if (businessUser == null)
            return false;
        Long userId = businessUser.getUserId();
        deleteById(id);
        businessUserMapper.clearIntroduces(userId);
        userService.delete(new EntityWrapper<User>().where("id = {0}", userId));
        bankCardService.delete(new EntityWrapper<BankCard>().where("user_id = {0}", userId));
        shopService.delete(new EntityWrapper<Shop>().where("user_id = {0}", userId));
        return true;
    }

    @Override
    public BusinessUser selectByUserId(Long id) {
        return selectOne(new EntityWrapper<BusinessUser>().where("user_id = {0}", id));
    }

    @Override
    public Page<BusinessUserInfoDTO> selectBusinessList(Integer currentPage, Integer pageSize, BusinessCondition condition) {
        Page<BusinessUserInfoDTO> userPage = new Page<>(currentPage, pageSize);
        userPage.setRecords(businessUserMapper.selectBusinessList(condition));
        return userPage;
    }

    /**
     * 更新商家用户信息
     *
     * @param user         用户对象
     * @param businessUser 商家对象
     * @param bankCards    银行卡集合
     * @param shops        店铺集合
     */
    @Override
    @Transactional
    public synchronized void updateBusiness(User user, BusinessUser businessUser, List<BankCard> bankCards, List<Shop> shops) {
        userMapper.updateById(user);
        businessUserMapper.updateById(businessUser);
        bankCardMapper.deleteNotRange(bankCards);
        if (bankCards.size() > 0)
            bankCardService.insertOrUpdateBatch(bankCards);
        shopMapper.deleteNotRange(shops);
        if (shops.size() > 0)
            shopService.insertOrUpdateBatch(shops);
    }
}
