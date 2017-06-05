package site.zido.center.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.zido.brush.utils.BankCardUtils;
import site.zido.brush.utils.EntityUtils;
import site.zido.brush.utils.ValiDateUtils;
import site.zido.center.LangConstants;
import site.zido.center.dto.BusinessUserInfoDTO;
import site.zido.core.common.base.BaseController;
import site.zido.core.dto.AjaxResult;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.Shop;
import site.zido.entity.User;
import site.zido.service.user.BusinessUserService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商家控制器
 *
 * @author zido
 * @since 2017/6/2 0002
 */
@RestController
@RequestMapping(value = "/api/business")
public class BusinessController extends BaseController {
    @Resource
    private BusinessUserService businessUserService;
    @Resource
    private UserService userService;

    /**
     * 添加商家
     * @param dto 商家信息，包含商家基本信息，店铺信息，其他信息
     * @return 操作结果
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加商家")
    public AjaxResult addBusiness(@RequestBody BusinessUserInfoDTO dto) {
        List<BankCard> bankCards = dto.getBankCards();
        BusinessUser businessUser = dto.getBusinessUser();
        List<Shop> shops = dto.getShops();
        if(businessUser == null)
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);

        User user = new User();
        user.setId(EntityUtils.generatorId());
        user.setEnabled(0);
        user.setUsername("");
        user.setId(EntityUtils.generatorId());

        //校验输入商家
        if (ValiDateUtils.isEmpty(businessUser.getIntroduceId()))
            return fail(LangConstants.INTRODUCER_CAN_NOT_BE_EMPTY);
        if (ValiDateUtils.isEmpty(businessUser.getPhoneNumber()))
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);
        if (ValiDateUtils.isEmpty(businessUser.getNickname()))
            return fail(LangConstants.BUSINESS_NAME_CAN_NOT_BE_EMPTY);

        //校验银行卡
        if (ValiDateUtils.isEmpty(bankCards))
            return fail(LangConstants.BANK_CARD_MUST_MORE_THAN_ONE);
        for (BankCard bankCard : bankCards) {
            if (!BankCardUtils.checkBankCard(bankCard.getBankCardNumber()))
                return fail(LangConstants.BANK_CARD_IS_INCORRECT);
            bankCard.setId(EntityUtils.generatorId());
            bankCard.setUserId(user.getId());
        }
        //校验店铺
        if (ValiDateUtils.isEmpty(shops))
            return fail(LangConstants.SHOP_MUST_MORE_THAN_ONE);
        for (Shop shop : shops) {
            if(ValiDateUtils.isEmpty(shop.getPlatformId()))
                return fail(LangConstants.PLATFORM_CAN_NOT_BE_EMPTY);
            if(ValiDateUtils.isEmpty(shop.getShopName()))
                return fail(LangConstants.SHOP_NAME_CAN_NOT_BE_EMPTY);
            if(ValiDateUtils.isEmpty(shop.getShopUrl()))
                return fail(LangConstants.SHOP_URL_CAN_NOT_BE_EMPTY);
            if(ValiDateUtils.isEmpty(shop.getShopType()))
                return fail(LangConstants.SHOP_TYPE_CAN_NOT_BE_EMPTY);
            shop.setId(EntityUtils.generatorId());
            shop.setUserId(user.getId());
        }

        //初始化
        businessUser.setState(0);
        businessUser.setCreateTime(new Date());
        businessUser.setUserId(user.getId());
        businessUserService.save(user,businessUser,bankCards,shops);
        return success("操作成功");
    }

    /**
     * 获取当前页商家数据
     * @param currentPage 当前页数
     * @return 操作结果
     */
    public AjaxResult getBusinessList(Integer currentPage){
        return success();
    }

    /**
     * 审核通过自动生成商家ID和密码
     */
    @PostMapping(value = "/pass")
    public AjaxResult autoCreateIdAndPwd() {
        User user = new User();
        user.setPassword("123456");
        user.setEnabled(1);
        businessUserService.autoCreateIdAndPws(user);
        return successData(user);
    }
    /**
     * 商家不通过审核
     */
    @PostMapping(value = "/nopass")
    public AjaxResult createFail(Integer id){
        User user = userService.findAll(id);
        if (user != null){
            return fail(LangConstants.OPERATE_SUCCESS);
        }
        userService.updateFail(user);
        return successData(user);
    }

}
