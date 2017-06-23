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

/**
 * Created by CDDC on 2017/6/23.
 */
@RestController
@RequestMapping(value = "/pubbase")
public class PubBaseController extends BaseController {

    @Resource
    private UserService userService;
    /**
     * 登录
     */
    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public AjaxResult login(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || password == null){
            return fail(LangConstants.USERORPWD_IS_WRONG);
        }

        return null;
    }
}
