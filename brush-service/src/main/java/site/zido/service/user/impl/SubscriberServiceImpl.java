package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.AgeUtils;
import site.zido.entity.*;
import site.zido.mapper.user.BankCardMapper;
import site.zido.mapper.user.CareerMapper;
import site.zido.mapper.user.SubscriberUserMapper;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.BankCardService;
import site.zido.service.user.SubscriberService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * Created by CDDC on 2017/6/2.
 */
@Service
public class SubscriberServiceImpl extends ServiceImpl<SubscriberUserMapper,SubscriberUser> implements SubscriberService{
    @Resource
    private SubscriberUserMapper subscriberUserMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CareerMapper careerMapper;
    @Resource
    private BankCardMapper bankCardMapper;
    @Resource
    private BankCardService bankCardService;
    @Resource
    private SubscriberService subscriberService;
    @Resource
    private UserService userService;

    @Override
    @Transactional
    public synchronized void addSubscriber(User user, SubscriberUser subscriberUser, List<BankCard> bankCards, Career career) {
        int subAge = 0;
        try {
            subAge = AgeUtils.getAgeByIDCard(subscriberUser.getIDCard());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        subscriberUser.setSubAge(subAge);
        userMapper.insert(user);
        careerMapper.insert(career);
        bankCardService.insertBatch(bankCards);
        subscriberUserMapper.insert(subscriberUser);
    }


    @Override
    @Transactional
    public synchronized void updataSubscriber(User user, SubscriberUser subscriberUser, List<BankCard> bankCards, Career career) {

        userService.updateById(user);
        subscriberUserMapper.updateById(subscriberUser);
        bankCardMapper.deleteNotRange(bankCards);
        if(bankCards.size()  >  0) {
            bankCardService.insertOrUpdateBatch(bankCards);
        }
    }

    @Override
    public SubscriberUser selectByUserId(String userId) {
        subscriberService.selectOne(new EntityWrapper<SubscriberUser>().where("user_id = {0}",userId));
        return null;
    }

    @Override
    public boolean updataStateByUserId(Long userId, Integer state) {
        return subscriberService.update(
                new SubscriberUser().setState(state),
                new EntityWrapper<SubscriberUser>().where("user_id = {0}", userId));
    }

    @Override
    public List<SubscriberUser> selectByKey(String key, Integer max) {

        List<SubscriberUser> subscriberUsers = subscriberUserMapper.selectByKey(key, 1, max);

        return subscriberUsers;
    }

}
