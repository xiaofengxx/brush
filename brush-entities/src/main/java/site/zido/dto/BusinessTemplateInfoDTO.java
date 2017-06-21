package site.zido.dto;

import site.zido.entity.BusinessTemplate;
import site.zido.entity.BusinessUser;
import site.zido.entity.Platforms;
import site.zido.entity.Shop;

/**
 * 展示模板信息类
 * Created by FZC on 2017/6/20.
 */
public class BusinessTemplateInfoDTO {

    private BusinessTemplate businessTemplate;

    private Shop shop;

    private BusinessUser businessUser;

    private Platforms platforms;

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

    public Shop getShop() {
        return shop;
    }

    public BusinessTemplateInfoDTO setShop(Shop shop) {
        this.shop = shop;
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
