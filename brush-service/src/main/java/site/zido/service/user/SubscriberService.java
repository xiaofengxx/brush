package site.zido.service.user;

import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.BankCard;
import site.zido.entity.Career;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;

import java.util.List;

/**
 * Created by CDDC on 2017/6/2.
 */
public interface SubscriberService extends IService<SubscriberUser> {

    /**
     * 添加刷手
     * @param user 基础用户信息 (id,enable)
     * @param subscriberUser 刷手信息
     * @param bankCards 银行卡列表
     * @param career 职业
     */
    void addSubscriber(User user, SubscriberUser subscriberUser,List<BankCard> bankCards, Career career);

    /**
     * 修改刷手
     * @param user 基础用户信息 (id,enable)
     * @param subscriberUser 刷手信息
     * @param bankCards 银行卡列表
     * @param career 职业
     */
    void updataSubscriber(User user, SubscriberUser subscriberUser,List<BankCard> bankCards, Career career);

    /**
     * 通过userid查询
     * @param userId
     * @return
     */
    SubscriberUser selectByUserId(String userId);

    /**
     * 通过userid 修改刷手state
     * @param userId
     * @param state
     * @return
     */
    boolean updataStateByUserId(Long userId,Integer state);

    /**
     * 通过关键字搜索
     * @param key
     * @param max
     * @return
     */
    List<SubscriberUser> selectByKey(String key,Integer max);
}
