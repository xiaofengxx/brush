package site.zido.center.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.Admin;
import site.zido.entity.User;
import site.zido.service.user.IAdminService;
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
    /**
     * 管理员修改密码
     */
    @PostMapping(value = "/updatePwd")
    @ApiOperation("管理员密码修改")
    public AjaxResult updatePwd(String id,String password){
        User user = userService.selectById(id);
        if (user == null){
            return fail(LangConstants.USER_NOT_FOUNT);
        }
        user.setPassword(password);
        userService.updatePwd(user);
        return successData(user);
    }
    /**
     * 管理员退出
     */
    @PostMapping(value = "/logout")
    @ApiOperation("管理员退出")
    public AjaxResult logout(){
        return null;
    }
    /**
     * 管理员作废
     */
    @PostMapping(value = "/cancelAdmin")
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
        List<Admin> list = adminService.findAdminById(id);
        if (list == null){
            return fail(LangConstants.USER_NOT_FOUNT);
        }
        return successData(list);
    }
}
