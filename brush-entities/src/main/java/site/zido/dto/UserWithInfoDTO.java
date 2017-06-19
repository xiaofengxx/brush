package site.zido.dto;

import site.zido.entity.BankCard;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/9 0009
 */
public class UserWithInfoDTO {
    private User user;


    public User getUser() {
        return user;
    }

    public UserWithInfoDTO setUser(User user) {
        this.user = user;
        return this;
    }

}
