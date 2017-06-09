package site.zido.center.dto;

import site.zido.entity.BankCard;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/9 0009
 */
public class UserWithInfoDTO {
    private String nickname;
    private List<BankCard> bankCards;
    private String CareerName;

    public String getNickname() {
        return nickname;
    }

    public UserWithInfoDTO setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public UserWithInfoDTO setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
        return this;
    }

    public String getCareerName() {
        return CareerName;
    }

    public UserWithInfoDTO setCareerName(String careerName) {
        CareerName = careerName;
        return this;
    }
}
