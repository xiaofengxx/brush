package site.zido.business.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.zido.business.BusMessage;

/**
 * description:
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/23
 */
@RestController
@RequestMapping(value = "",method = RequestMethod.POST)
public class IndexController {
    @RequestMapping("/")
    public void index(@RequestBody BusMessage message){
        System.out.println(message.getName());
    }
}
