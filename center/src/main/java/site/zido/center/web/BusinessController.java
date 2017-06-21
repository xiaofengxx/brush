package site.zido.center.web;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import site.zido.brush.utils.BankCardUtils;
import site.zido.brush.utils.EntityUtils;
import site.zido.brush.utils.StringUtils;
import site.zido.brush.utils.ValiDateUtils;
import site.zido.core.LangConstants;
import site.zido.dto.BusinessUserInfoDTO;
import site.zido.core.common.base.BaseController;
import site.zido.core.constants.BrushConstants;
import site.zido.dto.AjaxResult;
import site.zido.entity.BankCard;
import site.zido.entity.BusinessUser;
import site.zido.entity.Shop;
import site.zido.entity.User;
import site.zido.dto.BusinessCondition;
import site.zido.service.user.BankCardService;
import site.zido.service.user.BusinessUserService;
import site.zido.service.user.ShopService;
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
@RequestMapping(value = "/api/center/business")
public class BusinessController extends BaseController {
    @Resource
    private BusinessUserService businessUserService;
    @Resource
    private UserService userService;
    @Resource
    private BankCardService bankCardService;
    @Resource
    private ShopService shopService;
    @Resource
    private BrushConstants constants;

    /**
     * 添加商家
     *
     * @param dto 商家信息，包含商家基本信息，店铺信息，其他信息
     * @return 操作结果
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加/修改商家")
    public AjaxResult addBusiness(@RequestBody BusinessUserInfoDTO dto) {
        List<BankCard> bankCards = dto.getBankCards();
        BusinessUser businessUser = dto.getBusinessUser();
        List<Shop> shops = dto.getShops();
        if (businessUser == null)
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);
        boolean isAdd = true;
        User user = dto.getUser();
        if (user != null) {
            isAdd = false;
        } else {
            user = new User();
            user.setId(EntityUtils.generatorId());
            user.setEnabled(0);
            user.setUsername("");
        }
        //校验输入商家
        if (!ValiDateUtils.isEmpty(businessUser.getIntroduceName())){
            BusinessUser introducer = businessUserService.selectByNickname(businessUser.getIntroduceName());
            if (null == introducer)
                return fail(LangConstants.INTRODUCE_IS_INCORRECT);
            businessUser.setIntroduceId(introducer.getUserId());
        }
        if (ValiDateUtils.isEmpty(businessUser.getPhoneNumber()))
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);
        if (ValiDateUtils.isEmpty(businessUser.getNickname()))
            return fail(LangConstants.BUSINESS_NAME_CAN_NOT_BE_EMPTY);

        //校验银行卡
        if (ValiDateUtils.isEmpty(bankCards))
            return fail(LangConstants.BANK_CARD_MUST_MORE_THAN_ONE);
        for (BankCard bankCard : bankCards) {
            bankCard.setBankCardNumber(StringUtils.replaceBlank(bankCard.getBankCardNumber()));
            if (!BankCardUtils.checkBankCard(bankCard.getBankCardNumber()))
                return fail(LangConstants.BANK_CARD_IS_INCORRECT);
            bankCard.setUserId(user.getId());
        }
        //校验店铺
        if (ValiDateUtils.isEmpty(shops))
            return fail(LangConstants.SHOP_MUST_MORE_THAN_ONE);
        for (Shop shop : shops) {
            if (ValiDateUtils.isEmpty(shop.getPlatformId()))
                return fail(LangConstants.PLATFORM_CAN_NOT_BE_EMPTY);
            if (ValiDateUtils.isEmpty(shop.getShopName()))
                return fail(LangConstants.SHOP_NAME_CAN_NOT_BE_EMPTY);
            if (ValiDateUtils.isEmpty(shop.getShopUrl()))
                return fail(LangConstants.SHOP_URL_CAN_NOT_BE_EMPTY);
            if (ValiDateUtils.isEmpty(shop.getShopType()))
                return fail(LangConstants.SHOP_TYPE_CAN_NOT_BE_EMPTY);
            shop.setUserId(user.getId());
        }

        //初始化
        if (isAdd) {
            businessUser.setId(EntityUtils.generatorId());
            businessUser.setState(0);
        }
        businessUser.setCreateTime(new Date());
        businessUser.setUserId(user.getId());
        if (isAdd)
            businessUserService.save(user, businessUser, bankCards, shops);
        else
            businessUserService.updateBusiness(user, businessUser, bankCards, shops);
        return success(LangConstants.OPERATE_SUCCESS);
    }

    /**
     * 获取当前页商家数据
     *
     * @param currentPage 当前页数
     * @param level       分页大小（0,1,2...）
     * @return 操作结果
     */
    @PostMapping("/get/list")
    public AjaxResult getBusinessList(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "0") Integer level, @RequestBody BusinessCondition condition) {
        if (condition == null) {
            condition = new BusinessCondition().setSort(0).setDesc(true);
        }
        Page<BusinessUserInfoDTO> page = businessUserService.selectBusinessList(currentPage, constants.getPageSize(level), condition);
        return successData(page);
    }

    /**
     * 根据商家id获取商家信息
     *
     * @param id id号
     * @return 商家信息
     */
    @PostMapping("/get/info")
    public AjaxResult getBusinessUserInfoByBusinessId(String id) {
        BusinessUser businessUser = businessUserService.selectById(id);
        if(businessUser == null)
            return fail(LangConstants.USER_NOT_FOUNT);
        User user = userService.selectById(businessUser.getUserId());
        if (businessUser.getIntroduceId() != null)
            businessUser.setIntroduceName(businessUserService.selectByUserId(businessUser.getIntroduceId()).getNickname());
        List<BankCard> bankCards = bankCardService.getByUserId(user.getId());
        List<Shop> shops = shopService.getByUserId(user.getId());
        return successData(new BusinessUserInfoDTO()
                .setBankCards(bankCards).setUser(user)
                .setBusinessUser(businessUser)
                .setShops(shops));
    }

    /**
     * 根据用户id获取商家信息
     *
     * @param id 用户id
     * @return 商家信息
     */
    @PostMapping("/get/infoByUser")
    public AjaxResult getBusinessUserInfoByUserId(String id) {
        User user = userService.selectById(id);
        BusinessUser businessUser = businessUserService.selectByUserId(user.getId());
        List<BankCard> bankCards = bankCardService.getByUserId(user.getId());
        List<Shop> shops = shopService.getByUserId(user.getId());
        return successData(new BusinessUserInfoDTO()
                .setBankCards(bankCards).setUser(user)
                .setBusinessUser(businessUser)
                .setShops(shops));
    }

    /**
     * 审核通过自动生成商家账号和密码以及序列号
     */
    @PostMapping(value = "/pass")
    public AjaxResult autoCreateIdAndPwd(String id, Boolean pass) {
        User user = userService.selectById(id);
        if (user == null)
            return fail(LangConstants.USER_NOT_FOUNT);
        if (pass) {
            userService.autoCreateIdAndPws(user);
            businessUserService.updateStateByUserId(user.getId(), 1);
        } else
            businessUserService.updateStateByUserId(user.getId(), 2);
        return success(LangConstants.OPERATE_SUCCESS);
    }

    /**
     * 通过关键字获取商家名称集合
     * @param key 关键字
     */
    @PostMapping("/introduce/list")
    @ApiOperation("通过关键字获取商家名称集合")
    public AjaxResult getIntroduces(@ApiParam("关键字") @RequestParam(defaultValue = "") String key) {
        List<BusinessUser> users = businessUserService.selectByKey(key, 20);
        return successData(users);
    }

    @PostMapping("/delete")
    public AjaxResult deleteUser(@RequestParam Long id) {
        if (id == null)
            return fail(LangConstants.USER_NOT_FOUNT);
        if (businessUserService.deleteBusinessUser(id))
            return success(LangConstants.OPERATE_SUCCESS);
        return fail(LangConstants.USER_NOT_FOUNT);
    }
}
