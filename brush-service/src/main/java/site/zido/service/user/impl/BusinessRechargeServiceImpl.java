package site.zido.service.user.impl;

import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.NumConvertUppercaseUtils;
import site.zido.entity.BusinessRecharge;
import site.zido.mapper.user.BusinessRechargeMapper;
import site.zido.service.user.IBusinessRechargeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 商家充值管理 服务实现类
 * </p>
 *
 * @author zido
 * @since 2017-06-28
 */
@Service
public class BusinessRechargeServiceImpl extends ServiceImpl<BusinessRechargeMapper, BusinessRecharge> implements IBusinessRechargeService {

    @Resource
    private BusinessRechargeMapper businessRechargeMapper;

    @Override
    @Transactional
    public void inserBusinessRecharge(BusinessRecharge businessRecharge) {
        businessRechargeMapper.insert(businessRecharge);
    }
}
