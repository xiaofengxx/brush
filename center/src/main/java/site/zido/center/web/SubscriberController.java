package site.zido.center.web;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import site.zido.brush.utils.EntityUtils;
import site.zido.brush.utils.StringUtils;
import site.zido.brush.utils.ValiDateUtils;
import site.zido.core.LangConstants;
import site.zido.core.constants.BrushConstants;
import site.zido.dto.SubscriberCondition;
import site.zido.dto.SubscriberUserInfoDTO;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.*;
import site.zido.service.user.SubscriberService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private BrushConstants constants;

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
        subscriberUser.setCreatTime(new Date());
        subscriberUser.setUserId(user.getId());

        List<BankCard> bankCards = dto.getBankCards();

        //银行卡处理
        if(!CollectionUtils.isEmpty(bankCards)){
            // 赋值银行卡 所属人
            for(BankCard bankCard : bankCards){
                bankCard.setUserId(user.getId());
            }
        }


        //职业处理
        List<Career> careers = dto.getCareer();

        List<UserCareer> userCareers = new ArrayList<>();

        //职业处理
        if(!CollectionUtils.isEmpty(careers)){
            //处理
            for(Career career : careers){
                userCareers.add(new UserCareer().setUserId(user.getId()).setCareerId(career.getId()));
            }
        }


        //查找已有的刷手登录账号
        User subUser = userService.getUserByUserName(subscriberUser.getPhoneNumber());


        //支付宝不能为空
        if(StringUtils.isEmpty(subscriberUser.getAliPay())){
            return fail(LangConstants.USER_ALIPAY_CAN_NOT_BE_EMPTY);
        }
        //旺旺不能为空
        if(StringUtils.isEmpty(subscriberUser.getAliTm())){
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
        if(StringUtils.isEmpty(subscriberUser.getCareerId()+"")){
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
        if(StringUtils.isEmpty(subscriberUser.getIdCardFrontUrl())){
            return fail(LangConstants.IDCARDFRONTURL_CAN_NOT_BE_EMPTY);
        }
        //身份证背面不能为空
        if(StringUtils.isEmpty(subscriberUser.getIdCardBehindUrl())){
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
        //是否电话号码或者重复
        if(ValiDateUtils.isPhone(subscriberUser.getPhoneNumber())){
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);
        }else if(subUser != null) {
            return fail(LangConstants.PHONENUMBER_REPEAT);
        }
        //昵称不能为空
       if(StringUtils.isEmpty(dto.getSubscriberUser().getNickname())){
            return fail(LangConstants.USER_NICKNAME_CAN_NOT_BE_EMPTY);
        }
        //身份证不能为空
        if (StringUtils.isEmpty(subscriberUser.getIdCard())){
            return fail(LangConstants.IDCARD_CAN_NOT_BE_EMPTY);
        }

        if(isAdd){
            subscriberUser.setId(EntityUtils.generatorId());
            subscriberUser.setState(0);
            user.setUsername(subscriberUser.getPhoneNumber());
        }

        if(isAdd){
            subscriberService.addSubscriber(user,subscriberUser,bankCards);
        }else{
            subscriberService.updateSubscriber(user,subscriberUser,bankCards);
        }

        return success(LangConstants.OPERATE_SUCCESS);
    }
    /**
     * 刷手通过审核自动创建登录用户名和密码
     */
    @PostMapping(value = "/pass")
    @ApiOperation("刷手审核通过")
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

    /**
     * 判断手机号是否已注册
     * @param phoneNumber
     * @return
     */
    @PostMapping(value = "/userNameIsRegist")
    @ApiOperation(value = "判断手机号注册,返回true/false")
    public AjaxResult userNameIsRegist(@ApiParam("用户名") @RequestParam(defaultValue = "") String phoneNumber){

        User user = userService.getUserByUserName(phoneNumber);

        if(user == null){
            return successData(true);
        }else{
            return successData(false);
        }
    }

    @PostMapping(value = "searchSubScriberList")
    @ApiOperation(value = "多条件搜索")
    public AjaxResult searchSubScriberList(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "0") Integer level,@RequestBody SubscriberCondition condition){
        if(condition == null){
            condition = new SubscriberCondition().setSort(0).setDESC(true);
        }

        Page<SubscriberUserInfoDTO> subscriberUserInfoDTOPage = subscriberService.searchSubscriberList(currentPage, constants.getPageSize(level), condition);

        return successData(subscriberUserInfoDTOPage);
    }
}
