package site.zido.dto;

import site.zido.entity.BankCard;
import site.zido.entity.BusinessRecharge;
import site.zido.entity.BusinessUser;

/**商家充值管理
 * Created by CDDC on 2017/6/27.
 */
public class BusinessRechargeDTO {
    private BusinessRecharge businessRecharge;

    public BusinessRecharge getBusinessRecharge() {
        return businessRecharge;
    }

    public void setBusinessRecharge(BusinessRecharge businessRecharge) {
        this.businessRecharge = businessRecharge;
    }
}
