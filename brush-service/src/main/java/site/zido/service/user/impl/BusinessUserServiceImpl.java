package site.zido.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.EntityUtils;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.Shop;
import site.zido.entity.User;
import site.zido.mapper.user.BankCardMapper;
import site.zido.mapper.user.BusinessUserMapper;
import site.zido.mapper.user.ShopMapper;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.BusinessUserService;

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
public class BusinessUserServiceImpl implements BusinessUserService {
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
     * @param user 用户对象
     * @param businessUser 商家对象
     * @param bankCards 银行卡集合
     * @param shops 店铺集合
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
        if(maxUserName == null)
            maxUserName = "10003";
        Long aLong = Long.valueOf(maxUserName);
        aLong++;
        user.setId(EntityUtils.generatorId());
        user.setUsername(aLong+"");
        userMapper.insert(user);
    }
}
