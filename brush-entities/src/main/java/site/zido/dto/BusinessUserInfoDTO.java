package site.zido.dto;

import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.Shop;
import site.zido.entity.User;

import java.util.List;

/**
 * 商家用户传输对象
 *
 * @author zido
 * @since 2017/6/5 0005
 */
public class BusinessUserInfoDTO {
    private User user;
    private BusinessUser businessUser;
    private List<BankCard> bankCards;
    private List<Shop> shops;

    public User getUser() {
        return user;
    }

    public BusinessUserInfoDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public BusinessUser getBusinessUser() {
        return businessUser;
    }

    public BusinessUserInfoDTO setBusinessUser(BusinessUser businessUser) {
        this.businessUser = businessUser;
        return this;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public BusinessUserInfoDTO setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
        return this;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public BusinessUserInfoDTO setShops(List<Shop> shops) {
        this.shops = shops;
        return this;
    }
}
