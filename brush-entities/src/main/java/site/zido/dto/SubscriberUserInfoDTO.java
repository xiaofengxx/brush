package site.zido.dto;

import site.zido.entity.BankCard;
import site.zido.entity.Career;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FZC on 2017/6/18.
 */
public class SubscriberUserInfoDTO {

    private User user;
    private SubscriberUser subscriberUser;
    private List<BankCard> bankCards;
    private List<Career> career;
    private List<Long> careers;



    public List<Long> getCareers() {
        return careers;
    }

    public SubscriberUserInfoDTO setCareers(List<Long> careers) {
        this.careers = careers;
        if(career ==null){
            career = new ArrayList<>();
        }
        for(Long id : careers){
            career.add(new Career().setId(id));
        }
        return this;
    }

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


    public List<Career> getCareer() {
        return career;
    }

    public SubscriberUserInfoDTO setCareer(List<Career> career) {
        this.career = career;
        subscriberUser.setCareer(career);
        return this;
    }




}
