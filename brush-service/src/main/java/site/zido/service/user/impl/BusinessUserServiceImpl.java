package site.zido.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.EntityUtils;
import site.zido.core.exception.ServiceException;
import site.zido.core.service.CustomUserService;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.User;
import site.zido.mapper.user.BankCardMapper;
import site.zido.mapper.user.BusinessUserMapper;
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
    @Override
    public Integer getMaxSort() {
        return businessUserMapper.selectMaxSort();
    }

    @Override
    public String getMaxUserName() {
        return businessUserMapper.selectMaxUserName();
    }

    @Override
    @Transactional
    public synchronized void save(User user, BusinessUser businessUser, List<BankCard> bankCards){
        String maxUserName = businessUserService.getMaxUserName();
        if(maxUserName == null)
            maxUserName = "10003";
        Long aLong = Long.valueOf(maxUserName);
        aLong++;
        user.setId(EntityUtils.generatorId());
        user.setUsername(aLong+"");
        userMapper.insert(user);

        Integer maxSort = businessUserService.getMaxSort();
        if(maxSort == null)
            maxSort = 1000;
        maxSort++;
        businessUser.setSort(maxSort);
        businessUser.setUserId(user.getId());
        businessUserMapper.insert(businessUser);

        bankCardMapper.insertBatch(bankCards);


    }
}
