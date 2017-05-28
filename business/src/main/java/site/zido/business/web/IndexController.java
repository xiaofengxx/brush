package site.zido.business.web;

import org.springframework.web.bind.annotation.*;
import site.zido.business.BusMessage;
import site.zido.core.Common;

/**
 * description:
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/23
 */
@RestController
@RequestMapping("/api")
public class IndexController {
    @PostMapping(value = "/index")
    public BusMessage index(@RequestBody BusMessage message){
        System.out.println(message.getName());
        return message;
    }
}
