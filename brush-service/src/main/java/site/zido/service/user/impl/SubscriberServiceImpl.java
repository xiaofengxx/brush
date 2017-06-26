package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.IDCardToAgeUtils;
import site.zido.dto.SubscriberCondition;
import site.zido.dto.SubscriberUserInfoDTO;
import site.zido.entity.*;
import site.zido.mapper.user.BankCardMapper;
import site.zido.mapper.user.CareerMapper;
import site.zido.mapper.user.SubscriberUserMapper;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.*;

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
    private BankCardMapper bankCardMapper;
    @Resource
    private UserService userService;
    @Resource
    private BankCardService bankCardService;
    @Resource
    private UserCareerService userCareerService;

    @Resource
    private ICareerService careerService;

    @Override
    @Transactional
    public synchronized void addSubscriber(User user, SubscriberUser subscriberUser, List<BankCard> bankCards, List<UserCareer> careers) {

        userCareerService.insertBatch(careers);
        userMapper.insert(user);
        bankCardService.insertBatch(bankCards);
        subscriberUserMapper.insert(subscriberUser);
    }


    @Override
    @Transactional
    public synchronized void updateSubscriber(User user, SubscriberUser subscriberUser, List<BankCard> bankCards, List<UserCareer> careers) {

        userService.updateById(user);
        subscriberUserMapper.updateById(subscriberUser);
        bankCardMapper.deleteNotRange(bankCards,user.getId());
        if(bankCards.size()  >  0) {
            bankCardService.insertOrUpdateBatch(bankCards);
        }
        userCareerService.deleteNotRange(user.getId()+"",careers);
        if(careers.size() > 0){
            userCareerService.insertOrUpdateBatch(careers);
        }
    }

    @Override
    public SubscriberUser selectByUserId(String userId) {
        return selectOne(new EntityWrapper<SubscriberUser>().where("user_id = {0}",userId));
    }

    @Override
    public boolean updataStateByUserId(Long userId, Integer state) {
        return update(
                new SubscriberUser().setState(state),
                new EntityWrapper<SubscriberUser>().where("user_id = {0}", userId));
    }

    @Override
    public List<SubscriberUser> selectByKey(String key, Integer max) {

        return subscriberUserMapper.selectByKey(key, 1, max);
    }

    @Override
    public Page<SubscriberUserInfoDTO> searchSubscriberList(Integer current, Integer pagesize, SubscriberCondition condition) {
        Page<SubscriberUserInfoDTO> resultPage = new Page<>(current,pagesize);
        resultPage.setRecords(subscriberUserMapper.searchSubscriberList(condition));

        List<SubscriberUserInfoDTO> records = resultPage.getRecords();


        for(SubscriberUserInfoDTO infoDTO : records){

            Long userId = infoDTO.getSubscriberUser().getUserId();

            //查询银行卡
            List<BankCard> bankCards = bankCardService.getByUserId(userId);

            infoDTO.setBankCards(bankCards);

            //获取职业列表
            List<Career> careers = careerService.selectByUserId(userId);
            infoDTO.getSubscriberUser().setCareer(careers);

        }




        return resultPage;
    }

    @Override
    public List<SubscriberUser> findSubUserByCondition(String introUser) {
        return subscriberUserMapper.findSubUserByCondition(introUser);
    }

    @Override
    public String findSubUserByNumber(String adPhoneNumber) {
        return subscriberUserMapper.findSubUserByNumber(adPhoneNumber);
    }

}
