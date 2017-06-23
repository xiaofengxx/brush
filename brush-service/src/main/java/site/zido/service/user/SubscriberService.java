package site.zido.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import site.zido.dto.SubscriberCondition;
import site.zido.dto.SubscriberUserInfoDTO;
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
     */
    void addSubscriber(User user, SubscriberUser subscriberUser,List<BankCard> bankCards);

    /**
     * 修改刷手
     * @param user 基础用户信息 (id,enable)
     * @param subscriberUser 刷手信息
     * @param bankCards 银行卡列表
     */
    void updateSubscriber(User user, SubscriberUser subscriberUser, List<BankCard> bankCards);

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

    /**
     * 多条件搜索
     * @param current 当前页
     * @param pagesize 页大小
     * @param condition 查询条件
     * @return
     */
    Page<SubscriberUserInfoDTO> searchSubscriberList(Integer current, Integer pagesize, SubscriberCondition condition);

    List<SubscriberUser> findSubUserByCondition(String paramKey);

    String findSubUserByNumber(String adPhonenumber);
}
