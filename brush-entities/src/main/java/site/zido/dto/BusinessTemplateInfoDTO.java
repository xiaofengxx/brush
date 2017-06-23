package site.zido.dto;

import site.zido.entity.*;

/**
 * 展示模板信息类
 * Created by FZC on 2017/6/20.
 */
public class BusinessTemplateInfoDTO {

    private User user;

    private BusinessTemplate businessTemplate;

    private BusinessUser businessUser;

    private Platforms platforms;

    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public BusinessTemplateInfoDTO setShop(Shop shop) {
        this.shop = shop;
        return this;
    }

    public Platforms getPlatforms() {
        return platforms;
    }

    public BusinessTemplateInfoDTO setPlatforms(Platforms platforms) {
        this.platforms = platforms;
        return this;
    }

    public BusinessTemplate getBusinessTemplate() {
        return businessTemplate;
    }

    public BusinessTemplateInfoDTO setBusinessTemplate(BusinessTemplate businessTemplate) {
        this.businessTemplate = businessTemplate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public BusinessTemplateInfoDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public BusinessUser getBusinessUser() {
        return businessUser;
    }

    public BusinessTemplateInfoDTO setBusinessUser(BusinessUser businessUser) {
        this.businessUser = businessUser;
        return this;
    }
}
