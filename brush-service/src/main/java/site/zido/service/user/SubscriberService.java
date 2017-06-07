package site.zido.service.user;

import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.Career;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;

/**
 * Created by CDDC on 2017/6/2.
 */
public interface SubscriberService extends IService<SubscriberUser> {

    //录入刷手信息
    void addSubscriber(User user, SubscriberUser subscriberUser, Career career);
    //通过审核创建刷手用户名和密码
    void autoCreateIdAndPwd(User user);
}
