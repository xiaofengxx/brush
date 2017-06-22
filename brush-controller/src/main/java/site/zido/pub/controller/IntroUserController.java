package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.User;
import site.zido.service.user.UserService;

import javax.annotation.Resource;

/**
 * Created by CDDC on 2017/6/21.
 */
@RestController
@RequestMapping(value = "/api/pub")
public class IntroUserController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/introUser")
    @ApiOperation(value = "刷手介绍人选择")
    public AjaxResult introUser(String username){
        if (username != null){
            User user = userService.selectBySubUsername(username);
            if (user != null){
                return successData(user);
            }
        }
        return fail(LangConstants.USER_NOT_FOUNT);
    }

}
