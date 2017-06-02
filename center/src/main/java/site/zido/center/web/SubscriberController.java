package site.zido.center.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.brush.utils.StringUtils;
import site.zido.core.exception.ServiceException;
import site.zido.dto.UserWithInfoDTO;
import site.zido.entity.SubscriberUser;
import site.zido.entity.User;
import site.zido.service.user.SubscriberService;

import javax.annotation.Resource;

/**
 * Created by CDDC on 2017/6/2.
 */
@RestController
@RequestMapping(value = "/api/subscriber")
public class SubscriberController {
    @Resource
    private SubscriberService subscriberService;
    /**
     * 添加刷手
     */
    @PostMapping(value = "/add")
    public void addSubscriberUser(@RequestBody SubscriberUser subscriberUser, UserWithInfoDTO userWithInfoDTO) throws Exception {
        User user = new User();
        user.setUsername(subscriberUser.getPhoneNumber());
        user.setPassword("123456");
        if(StringUtils.isEmpty(userWithInfoDTO.getNickname())){
            throw new Exception("用户昵称不能为空");
        }
    }
}
