package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.User;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**商家,刷手,管理员的登录情况
 * Created by CDDC on 2017/6/23.
 */
@RestController
@RequestMapping(value = "/pubbase")
public class PubUserController extends BaseController {

    @Resource
    private UserService userService;
    /**
     * 登录
     */
    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public AjaxResult login(@RequestBody User user, HttpServletRequest request){
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || password == null){
            return fail(LangConstants.USERORPWD_IS_WRONG);
        }
        User loguser = userService.findLoguserByNameAndPwd(username,password);
        if (loguser == null){
            return fail(LangConstants.USER_NOT_FOUNT);
        }

        return null;
    }
    /**
     * 用户退出
     */
    @PostMapping(value = "/logout")
    @ApiOperation("用户退出")
    public AjaxResult logout(){

        return null;
    }

    /**
     * 管理员修改密码
     */
    @PostMapping(value = "/updatePwd")
    @ApiOperation("用户密码修改")
    public AjaxResult updatePwd(String id,String password){
        User user = userService.selectById(id);
        if (user == null){
            return fail(LangConstants.USER_NOT_FOUNT);
        }
        user.setPassword(password);
        userService.updatePwd(user);
        return successData(user);
    }

}
