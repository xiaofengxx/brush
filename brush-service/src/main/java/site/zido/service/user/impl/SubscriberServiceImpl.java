package site.zido.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.entity.Career;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;
import site.zido.mapper.user.CareerMapper;
import site.zido.mapper.user.SubscriberUserMapper;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.SubscriberService;

import javax.annotation.Resource;

/**
 * Created by CDDC on 2017/6/2.
 */
@Service
public class SubscriberServiceImpl implements SubscriberService{
    @Resource
    private SubscriberUserMapper subscriberUserMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CareerMapper careerMapper;
    @Override
    public synchronized void addSubscriber(User user, SubscriberUser subscriberUser, Career career) {
        userMapper.insert(user);
        careerMapper.insert(career);
        subscriberUserMapper.insert(subscriberUser);
    }

    @Override
    public synchronized void autoCreateIdAndPwd(User user) {
        userMapper.insert(user);
    }
}
