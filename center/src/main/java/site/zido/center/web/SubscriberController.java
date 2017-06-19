package site.zido.center.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import site.zido.brush.utils.EntityUtils;
import site.zido.brush.utils.StringUtils;
import site.zido.center.LangConstants;
import site.zido.dto.SubscriberUserInfoDTO;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.*;
import site.zido.service.user.SubscriberService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    /**
     * 添加刷手
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增/修改")
    public AjaxResult addSubscriberUser(@RequestBody SubscriberUserInfoDTO dto) throws Exception {

        User user = dto.getUser();

        //新增标记
        boolean isAdd = false;

        if (user == null) {
            isAdd = true;
            user = new User();
            user.setId(EntityUtils.generatorId());
            user.setEnabled(0);
            user.setUsername("");
        }

        //处理得到的参数,填充可能缺失的值

        SubscriberUser subscriberUser = dto.getSubscriberUser();

        //刷手信息,填充所属人
        subscriberUser.setCreate_time(new Date());
        subscriberUser.setUserId(user.getId());

        List<BankCard> bankCards = dto.getBankCards();

        // 赋值银行卡 所属人
        for(BankCard bankCard : bankCards){
            bankCard.setUserId(user.getId());
        }

        //构造职业实例
        String strcareer = dto.getCareer();

        Career career = new Career();

        career.setId(user.getId());
        career.setName(strcareer);



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
        if(StringUtils.isEmpty(dto.getCareer())){
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
       if(StringUtils.isEmpty(dto.getNickName())){
            return fail(LangConstants.USER_NICKNAME_CAN_NOT_BE_EMPTY);
        }
        //身份证不能为空
        if (StringUtils.isEmpty(subscriberUser.getIDCard())){
            return fail(LangConstants.IDCARD_CAN_NOT_BE_EMPTY);
        }

        if(isAdd){
            subscriberUser.setId(EntityUtils.generatorId());
            subscriberUser.setState(0);
        }

        if(isAdd){
            subscriberService.addSubscriber(user,subscriberUser,bankCards,career);
        }else{
            subscriberService.updataSubscriber(user,subscriberUser,bankCards,career);
        }

        return success("操作成功");
    }
    /**
     * 刷手通过审核自动创建登录用户名和密码
     */
    @PostMapping(value = "/pass")
    @ApiOperation("刷手审核")
    public AjaxResult autoCreateIdAndPwd(String id,Boolean pass){
        User user = userService.selectById(id);
        if(pass){
            userService.autoCreateIdAndPws(user);
            subscriberService.updataStateByUserId(user.getId(),1);
            return successData(user);
        }else{
            subscriberService.updataStateByUserId(user.getId(),2);
        }
        return  success(LangConstants.OPERATE_SUCCESS);
    }

    /**
     * 搜索提示列表
     * @param key
     * @return
     */
    @PostMapping(value = "/introduce/list")
    @ApiOperation("关键字获取列表")
    public AjaxResult getIntroduces(@ApiParam("关键字") @RequestParam(defaultValue = "") String key){
        List<SubscriberUser> subscriberUsers = subscriberService.selectByKey(key, 20);
        return successData(subscriberUsers);
    }

}
