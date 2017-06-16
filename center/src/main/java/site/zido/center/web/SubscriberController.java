package site.zido.center.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.brush.utils.StringUtils;
import site.zido.center.LangConstants;
import site.zido.center.dto.UserWithInfoDTO;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
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

    @Resource
    private UserService userService;
    @Resource
    private SubscriberService subscriberService;
    @PostMapping("/print")
    public AjaxResult print(){
        return success();
    }

    /**
     * 添加刷手
     */
    @PostMapping(value = "/add")
    public AjaxResult addSubscriberUser(@RequestBody UserWithInfoDTO userWithInfoDTO) throws Exception {
        User user = new User();
        SubscriberUser subscriberUser = new SubscriberUser();
        Career career = new Career();
        //查找已有的刷手登录账号
        User subUser = userService.findLoginUser(subscriberUser.getPhoneNumber());
        //支付宝不能为空
        if(StringUtils.isEmpty(subscriberUser.getAliPay())){
            return fail(LangConstants.USER_ALIPAY_CAN_NOT_BE_EMPTY);
        }
        //旺旺不能为空
        if(StringUtils.isEmpty(subscriberUser.getAliTM())){
            return fail(LangConstants.USER_ALITM_CAN_NOT_BE_EMPTY);
        }
        //微信号不能为空
        if(StringUtils.isEmpty(subscriberUser.getWechat())){
            return fail(LangConstants.WECHAT_CAN_NOT_BE_EMPTY);
        }
        //淘宝星级不能为空
        if(subscriberUser.getTaobaoStar() == null){
            return fail(LangConstants.TAOBAOSTAR_CAN_NOT_BE_EMPTY);
        }
        //职业不能为空
        if(StringUtils.isEmpty(userWithInfoDTO.getCareerName())){
            return fail(LangConstants.CAREER_CAN_NOT_BE_EMPTY);
        }
        //性别不能为空
        if(subscriberUser.getSex() == null){
            return fail(LangConstants.SEX_CAN_NOT_BE_EMPTY);
        }
        //QQ不能为空
        if(StringUtils.isEmpty(subscriberUser.getQq())){
            return fail(LangConstants.QQ_CAN_NOT_BE_EMPTY);
        }
        //身份证正面不能为空
        if(StringUtils.isEmpty(subscriberUser.getIDCardFrontUrl())){
            return fail(LangConstants.IDCARDFRONTURL_CAN_NOT_BE_EMPTY);
        }
        //身份证背面不能为空
        if(StringUtils.isEmpty(subscriberUser.getIDCardBehindUrl())){
            return fail(LangConstants.IDCARDBEHINDURL_CAN_NOT_BE_EMPTY);
        }
        //淘宝星级图片不能为空
        if(StringUtils.isEmpty(subscriberUser.getStarScreenShotUrl())){
            return fail(LangConstants.STARPICTURE_CAN_NOT_BE_EMPTY);
        }
        //支付宝图片不能为空
        if(StringUtils.isEmpty(subscriberUser.getPhoneNumber())){
            return fail(LangConstants.ALIPAYPICTURE_CAN_NOT_BE_EMPTY);
        }
        //真实姓名不能为空
        if(StringUtils.isEmpty(subscriberUser.getRealName())){
            return fail(LangConstants.USER_REALNAME_CAN_NOT_BE_EMPTY);
        }
        //电话不能为空或者重复
        if(StringUtils.isEmpty(subscriberUser.getPhoneNumber())){
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);
        }else if(subUser.equals(subscriberUser.getPhoneNumber())) {
            return fail(LangConstants.PHONENUMBER_REPEAT);
        }
        //昵称不能为空
       if(StringUtils.isEmpty(userWithInfoDTO.getNickname())){
            return fail(LangConstants.USER_NICKNAME_CAN_NOT_BE_EMPTY);
        }
        //身份证不能为空
        if (StringUtils.isEmpty(subscriberUser.getIDCard())){
            return fail(LangConstants.IDCARD_CAN_NOT_BE_EMPTY);
        }
        subscriberUser.setState(0);
        subscriberService.addSubscriber(user,subscriberUser,career);

        return successData(user);
    }
    /**
     * 刷手通过审核自动创建登录用户名和密码
     */
    @PostMapping(value = "/pass")
    public AjaxResult autoCreateIdAndPwd(@RequestBody SubscriberUser subscriberUser){
        User user = new User();
        user.setUsername(subscriberUser.getPhoneNumber());
        user.setPassword("123456");
        user.setEnabled(1);
        subscriberService.autoCreateIdAndPwd(user);
        return successData(user);
    }
    /**
     * 刷手审核不通过
     */
    @PostMapping(value = "/nopass")
    public AjaxResult createFail(Integer id){

        User user = userService.selectById(id);
        if (user != null){
            return fail(LangConstants.OPERATE_SUCCESS);
        }
        userService.updateFail(user);
        return successData(user);
    }
}
