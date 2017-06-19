package site.zido.dto;

import site.zido.entity.BankCard;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;

import java.util.List;

/**
 * Created by FZC on 2017/6/18.
 */
public class SubscriberUserInfoDTO {

    private User user;
    private SubscriberUser subscriberUser;
    private List<BankCard> bankCards;

    private String career;
    private String nickName;

    public User getUser() {
        return user;
    }

    public SubscriberUserInfoDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public SubscriberUser getSubscriberUser() {
        return subscriberUser;
    }

    public SubscriberUserInfoDTO setSubscriberUser(SubscriberUser subscriberUser) {
        this.subscriberUser = subscriberUser;
        return this;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public SubscriberUserInfoDTO setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
        return this;
    }

    public String getCareer() {
        return career;
    }

    public SubscriberUserInfoDTO setCareer(String career) {
        this.career = career;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
