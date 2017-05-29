package site.zido.business.web;

import org.springframework.stereotype.Service;
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
public class IndexController {
    @Resource
    private UserService userService;
    @PostMapping(value = "/index")
    public BusMessage index(@RequestBody BusMessage message){
        List<User> users = userService.getAllUser("asdw");
        System.out.println(users.size());
        return message;
    }

    @PostMapping(value = "/users")
    public List<User> index(){
        List<User> users = userService.getAllUser("qweyhuo");
        return users;
    }
}
