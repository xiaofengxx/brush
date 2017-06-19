package site.zido.pub.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.zido.brush.utils.BankCardUtils;
import site.zido.brush.utils.ValiDateUtils;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

/**
 * Created by FZC on 2017/6/19.
 */
@RestController
public class BankCardController extends BaseController {

    @PostMapping("/bankCardCheck")
    public AjaxResult check(@RequestParam String cardNumber) {

        if (!BankCardUtils.checkBankCard(cardNumber))
            return fail(LangConstants.BANK_CARD_IS_INCORRECT);
        String name = BankCardUtils.getNameOfBank(cardNumber);
        if (ValiDateUtils.isEmpty(name))
            return fail(LangConstants.BANK_CARD_IS_INCORRECT);
        return successData(name);
    }
}
