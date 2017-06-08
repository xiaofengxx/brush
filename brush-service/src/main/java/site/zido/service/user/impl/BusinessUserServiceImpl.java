package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.EntityUtils;
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

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
        businessUserMapper.insert(businessUser);
        bankCardMapper.insertBatch(bankCards);
        shopMapper.insertBatch(shops);
    }


    @Override
    @Transactional
    public synchronized void autoCreateIdAndPws(User user) {
        String maxUserName = businessUserService.getMaxUserName();
        if (maxUserName == null)
            maxUserName = "10003";
        Long aLong = Long.valueOf(maxUserName);
        aLong++;
        user.setId(EntityUtils.generatorId());
        user.setUsername(aLong + "");
        userMapper.insert(user);
    }

    @Override
    public BusinessUser selectByUserId(String id) {
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

        List<BankCard> updateBankCards = bankCards.stream().filter(bankCard -> bankCard.getId() != null).collect(Collectors.toList());
        if (!updateBankCards.isEmpty())
            bankCardService.updateBatchById(updateBankCards);
        List<BankCard> addBankCards = bankCards.stream().filter(bankCard -> bankCard.getId() == null).collect(Collectors.toList());
        if (!addBankCards.isEmpty())
            bankCardService.insertBatch(addBankCards);

        List<Shop> updateShops = shops.stream().filter(shop -> shop.getId() != null).collect(Collectors.toList());
        if (!updateShops.isEmpty())
            shopService.updateBatchById(updateShops);
        List<Shop> addShops = shops.stream().filter(shop -> shop.getId() == null).collect(Collectors.toList());
        if (!addShops.isEmpty())
            shopService.insertBatch(addShops);
    }
}
