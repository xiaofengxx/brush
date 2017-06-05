package site.zido.center.dto;

import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.Shop;

import java.util.List;

/**
 * 商家用户传输对象
 *
 * @author zido
 * @since 2017/6/5 0005
 */
public class BusinessUserInfoDTO {
    private BusinessUser businessUser;
    private List<BankCard> bankCards;
    private List<Shop> shops;

    public BusinessUser getBusinessUser() {
        return businessUser;
    }

    public void setBusinessUser(BusinessUser businessUser) {
        this.businessUser = businessUser;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
