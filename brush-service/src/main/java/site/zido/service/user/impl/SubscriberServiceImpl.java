package site.zido.service.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.AgeUtils;
import site.zido.entity.Career;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;
import site.zido.mapper.user.CareerMapper;
import site.zido.mapper.user.SubscriberUserMapper;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.SubscriberService;

import javax.annotation.Resource;
import java.text.ParseException;

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
    @Override
    @Transactional
    public synchronized void addSubscriber(User user, SubscriberUser subscriberUser, Career career) {
        int subAge = 0;
        try {
            subAge = AgeUtils.getAgeByIDCard(subscriberUser.getIDCard());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        subscriberUser.setSubAge(subAge);
        userMapper.insert(user);
        careerMapper.insert(career);
        subscriberUserMapper.insert(subscriberUser);
    }

    @Override
    public synchronized void autoCreateIdAndPwd(User user) {
        userMapper.insert(user);
    }
}
