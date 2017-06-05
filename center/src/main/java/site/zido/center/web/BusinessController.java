package site.zido.center.web;

import org.springframework.web.bind.annotation.*;
import site.zido.brush.utils.BankCardUtils;
import site.zido.brush.utils.StringUtils;
import site.zido.center.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.core.dto.AjaxResult;
import site.zido.core.exception.ServiceException;
import site.zido.dto.UserWithInfoDTO;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.User;
import site.zido.service.user.BusinessUserService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by CDDC on 2017/6/1.
 */
@RestController
@RequestMapping(value = "/api/center")
public class BusinessController extends BaseController{
    @Resource
    private BusinessUserService businessUserService;
    @Resource
    private UserService userService;
    /**
     * 商家信息录入
     */
    @PostMapping(value = "/business/add")
    public AjaxResult addBusiness(@RequestBody UserWithInfoDTO uwid) throws ServiceException {
        User user = new User();
        if(StringUtils.isEmpty(uwid.getNickname())){
            return fail(LangConstants.USER_NICKNAME_CAN_NOT_BE_EMPTY);
        }
        user.setNickname(uwid.getNickname());
        //默认不可用，审核通过后可用
        user.setEnabled(0);

        BusinessUser businessUser = new BusinessUser();
        businessUser.setCreateTime(new Date());
        businessUser.setState(0);
        List<BankCard> bankCards = uwid.getBankCards();
        if(bankCards == null)
            return fail("必须填写一个银行卡信息");
        for (BankCard bankCard : bankCards) {
            boolean b = BankCardUtils.checkBankCard(bankCard.getBindCard());
            if(!b)
                return fail("请输入正确的银行卡号");
        }
        businessUserService.save(user,businessUser,bankCards);
        return successData(user);
    }
    /**
     * 审核通过自动生成商家ID和密码
     */
    @PostMapping(value = "/pass")
    public AjaxResult autoCreateIdAndPwd(){
        User user = new User();
        user.setPassword("123456");
        user.setEnabled(1);
        businessUserService.autoCreateIdAndPws(user);
        return successData(user);
    }

}
