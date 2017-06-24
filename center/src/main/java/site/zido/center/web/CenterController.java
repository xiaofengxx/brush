package site.zido.center.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AdminWithInfoDTO;
import site.zido.dto.AjaxResult;
import site.zido.entity.Admin;
import site.zido.entity.User;
import site.zido.service.user.BusinessUserService;
import site.zido.service.user.IAdminService;
import site.zido.service.user.SubscriberService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CDDC on 2017/6/13.
 */
@RestController
@RequestMapping(value = "/api/center")
public class CenterController extends BaseController{

    @Resource
    private UserService userService;
    @Resource
    private IAdminService adminService;
    @Resource
    private BusinessUserService businessUserService;
    @Resource
    private SubscriberService subscriberService;

    /**
     * 管理员作废
     */
    @PostMapping(value = "/cancelUser")
    @ApiOperation("人员作废")
    public AjaxResult cancelAdmin(String id){
        User user = userService.selectById(id);
        if (user == null){
            return fail(LangConstants.USER_NOT_FOUNT);
        }
        user.setEnabled(0);
        userService.cancelUser(user);
        return successData(LangConstants.OPERATE_SUCCESS);
    }
    /**
     * 管理员信息（只有超级管理员能看到）
     */
    @PostMapping(value = "/adminDetail")
    @ApiOperation("管理员信息")
    public AjaxResult detail(String id){
        List<Admin> list = adminService.findAllAdminById(id);
        if (list == null){
            return fail(LangConstants.USER_NOT_FOUNT);
        }
        return successData(list);
    }
    /**
     * 管理员信息录入
     */
    @PostMapping(value = "/addAdmin")
    @ApiOperation("管理员信息录入")
    public AjaxResult addAdmin(@RequestBody AdminWithInfoDTO awi){
        Admin admin = awi.getAdmin();
        if (admin == null){
            return fail(LangConstants.OPERATE_FAIL);
        }
        String p1 = businessUserService.findBusinessNumber(admin.getAdPhoneNumber());
        String p2 = subscriberService.findSubUserByNumber(admin.getAdPhoneNumber());

        if(admin.getAdName().isEmpty()){
            return fail(LangConstants.USER_REALNAME_CAN_NOT_BE_EMPTY);
        }
        if(admin.getAdPname().isEmpty()){
            return fail(LangConstants.PNAME_CAN_NOT_BE_EMPTY);
        }
        if(admin.getAdIdCard().isEmpty()){
            return fail(LangConstants.IDCARD_CAN_NOT_BE_EMPTY);
        }
        if(admin.getAdCardFrontUrl().isEmpty()){
            return fail(LangConstants.IDCARDFRONTURL_CAN_NOT_BE_EMPTY);
        }
        if(admin.getAdCardBehindUrl().isEmpty()){
            return fail(LangConstants.IDCARDBEHINDURL_CAN_NOT_BE_EMPTY);
        }
        if (admin.getAdPhoneNumber().isEmpty()){
            return fail(LangConstants.PHONENUMBER_CAN_NOT_BE_EMPTY);
        }else if (p1.equals(admin.getAdPhoneNumber()) || p2.equals(admin.getAdPhoneNumber())){
            return fail(LangConstants.PHONENUMBER_REPEAT);
        }
        if (admin.getAdSex() == null){
            return fail(LangConstants.SEX_CAN_NOT_BE_EMPTY);
        }
        admin.setAdState(0);
        adminService.insertAdmin(admin);
        return successData(admin);
    }

    @PostMapping(value = "/adminPass")
    @ApiOperation("管理员信息通过")
    public AjaxResult adminPass(String id){
        Admin admin = adminService.findAdminById(id);
        if(admin != null){
            adminService.updateState(id);
        }
        return fail(LangConstants.USER_NOT_FOUNT);
    }
}
