package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;
import site.zido.service.user.SubscriberService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CDDC on 2017/6/21.
 */
@RestController
@RequestMapping(value = "/api/pub")
public class IntroUserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private SubscriberService subscriberService;

    @PostMapping(value = "/introUser")
    @ApiOperation(value = "确认刷手介绍人")
    public AjaxResult introUser(String username){
        if (username != null){
            User user = userService.selectBySubUsername(username);
            if (user != null){
                return successData(user);
            }
        }
        return fail(LangConstants.USER_NOT_FOUNT);
    }

    @PostMapping(value = "/findSubUser")
    @ApiOperation(value = "模糊查询刷手")
    public AjaxResult findSubUser(String paramKey){
            List<SubscriberUser> list = subscriberService.findSubUserByCondition(paramKey);
        return successData(list);
    }

}
