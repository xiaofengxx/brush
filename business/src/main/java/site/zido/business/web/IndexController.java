package site.zido.business.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import site.zido.business.BusMessage;
import site.zido.entity.User;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 示例controller
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/23
 */
@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "用户相关操作")
public class IndexController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "这是首页", notes = "获取所有的用户信息")
    @PostMapping(value = "/index")
    public BusMessage index(@RequestBody @ApiParam(value = "提供一个消息", required = true) BusMessage message) {
        return message;
    }

    @ApiOperation(value = "这不是首页", notes = "还是可以获取所有的用户信息")
    @PostMapping(value = "/users")
    public List<User> index() {
        return userService.getAllUser("qweyhuo");
    }
}
