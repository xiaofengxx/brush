package site.zido.service.user;

import site.zido.entity.BusinessRecharge;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商家充值管理 服务类
 * </p>
 *
 * @author zido
 * @since 2017-06-28
 */
public interface IBusinessRechargeService extends IService<BusinessRecharge> {
    /**
     * 商家充值提交
     * @param businessRecharge
     */
    void inserBusinessRecharge(BusinessRecharge businessRecharge);
}
