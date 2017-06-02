package site.zido.center.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.brush.utils.StringUtils;
import site.zido.center.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.core.dto.AjaxResult;
import site.zido.dto.UserWithInfoDTO;
import site.zido.entity.BankCard;
import site.zido.entity.Career;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;
import site.zido.service.user.SubscriberService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;

/**
 * Created by CDDC on 2017/6/2.
 */
@RestController
@RequestMapping(value = "/api/subscriber")
public class SubscriberController extends BaseController {
    User user = new User();

    @Resource
    private SubscriberService subscriberService;
    /**
     * 添加刷手
     */
    @PostMapping(value = "/add")
    public AjaxResult addSubscriberUser(@RequestBody UserWithInfoDTO userWithInfoDTO) throws Exception {

        SubscriberUser subscriberUser = new SubscriberUser();
        Career career = new Career();

        if(StringUtils.isEmpty(subscriberUser.getAliPay())){
            //支付宝不能为空
            return fail(LangConstants.USER_ALIPAY_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getAliTM())){
            //旺旺不能为空
            return fail(LangConstants.USER_ALITM_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getWechat())){
            //微信号不能为空
            return fail(LangConstants.WECHAT_CAN_NOT_BE_EMPTY);
        }
        if(subscriberUser.getTaobaoStar() == null){
            //淘宝星级不能为空
            return fail(LangConstants.TAOBAOSTAR_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(userWithInfoDTO.getCareerName())){
            //职业不能为空
            return fail(LangConstants.CAREER_CAN_NOT_BE_EMPTY);
        }
        if(subscriberUser.getSex() == null){
            //性别不能为空
            return fail(LangConstants.SEX_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getQq())){
            //QQ不能为空
            return fail(LangConstants.QQ_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getIDCardFrontUrl())){
            //身份证正面不能为空
            return fail(LangConstants.IDCARDFRONTURL_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getIDCardBehindUrl())){
            //身份证背面不能为空
            return fail(LangConstants.IDCARDBEHINDURL_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getStarScreenShotUrl())){
            //淘宝星级图片不能为空
            return fail(LangConstants.STARPICTURE_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getPhoneNumber())){
            //支付宝图片不能为空
            return fail(LangConstants.ALIPAYPICTURE_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getRealName())){
            //真实姓名不能为空
            return fail(LangConstants.USER_REALNAME_CAN_NOT_BE_EMPTY);
        }
        if(StringUtils.isEmpty(subscriberUser.getPhoneNumber())){
            //电话PHONENUMBER_CAN_NOT_BE_EMPTY姓名不能为空
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);
        }
       if(StringUtils.isEmpty(userWithInfoDTO.getNickname())){
            return fail(LangConstants.USER_NICKNAME_CAN_NOT_BE_EMPTY);
        }

        subscriberService.addSubscriber(user,subscriberUser,career);

        return successData(user);
    }
    /**
     * 刷手通过审核自动创建登录用户名和密码
     */
    @PostMapping(value = "/pass")
    public void autoCreateIdAndPwd(@RequestBody SubscriberUser subscriberUser){

        user.setUsername(subscriberUser.getPhoneNumber());
        user.setPassword("123456");
        subscriberService.autoCreateIdAndPwd(user);
    }
}
