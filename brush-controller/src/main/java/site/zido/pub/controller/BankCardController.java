package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.zido.brush.utils.BankCardUtils;
import site.zido.brush.utils.ValiDateUtils;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.service.user.UserService;

import javax.annotation.Resource;

/**
 * Created by FZC on 2017/6/19.
 */
@RestController
@RequestMapping(value = "/api/pub")
public class BankCardController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping("/bankCardCheck")
    @ApiOperation("获取银行卡信息")
    public AjaxResult check(@RequestParam String cardNumber) {

        cardNumber = cardNumber.trim();

        if (!BankCardUtils.checkBankCard(cardNumber))
            return fail(LangConstants.BANK_CARD_IS_INCORRECT);
        String name = BankCardUtils.getNameOfBank(cardNumber);
        if (ValiDateUtils.isEmpty(name))
            return fail(LangConstants.BANK_CARD_IS_INCORRECT);
        return successData(name);
    }
}
