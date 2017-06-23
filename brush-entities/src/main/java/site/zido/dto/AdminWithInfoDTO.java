package site.zido.dto;

import site.zido.entity.Admin;
import site.zido.entity.BusinessUser;
import site.zido.entity.SubscriberUser;

import java.util.List;

/**管理员数据
 * Created by CDDC on 2017/6/23.
 */
public class AdminWithInfoDTO {

    /**
     * 管理员基础信息
     */
    private Admin admin;
    private List<BusinessUser> businessUsers;
    private List<SubscriberUser> subscriberUsers;

    public List<BusinessUser> getBusinessUsers() {
        return businessUsers;
    }

    public void setBusinessUsers(List<BusinessUser> businessUsers) {
        this.businessUsers = businessUsers;
    }

    public List<SubscriberUser> getSubscriberUsers() {
        return subscriberUsers;
    }

    public void setSubscriberUsers(List<SubscriberUser> subscriberUsers) {
        this.subscriberUsers = subscriberUsers;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
