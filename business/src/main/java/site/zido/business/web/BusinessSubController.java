package site.zido.business.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.dto.BusinessRechargeDTO;
import site.zido.entity.BusinessRecharge;
import site.zido.service.user.IBusinessRechargeService;

import javax.annotation.Resource;

/**商家充值提交的管理
 * Created by CDDC on 2017/6/27.
 */
@RestController
@RequestMapping(value = "/submitInfo")
public class BusinessSubController extends BaseController {

    @Resource
    private IBusinessRechargeService businessRechargeService;

    @PostMapping(value = "/busiChargePicture")
    @ApiOperation(value = "商家提交充值的截图")
    public AjaxResult busiChargePicture(@RequestBody BusinessRechargeDTO brdto){
        BusinessRecharge businessRecharge = brdto.getBusinessRecharge();
        //小写金额不能为空
        if (businessRecharge.getRechargeMoney() == null){
            return fail(LangConstants.RECHARGEMONEY_CAN_NOT_BE_EMPTY);
        }
        //转账图片上传不能为空
        if (businessRecharge.getRechargeUrl().isEmpty()){
            return fail(LangConstants.RECHARGEPICTUREURL_CAN_NOT_BE_EMPTY);
        }
        //转账姓名不能为空
        if (businessRecharge.getRechargeName().isEmpty()){
            return fail(LangConstants.RECHARGENAME_CAN_NOT_BE_EMPTY);
        }
        //中文大写不能为空
        if (businessRecharge.getRechargeChinese().isEmpty()){
            return fail(LangConstants.RECHAEGECHINESE_CAN_NOT_BE_EMPTY);
        }
        businessRechargeService.inserBusinessRecharge(businessRecharge);
        return successData(businessRecharge);
    }
}
