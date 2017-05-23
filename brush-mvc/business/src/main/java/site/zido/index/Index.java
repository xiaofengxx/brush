package site.zido.index;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.OneService;

import javax.annotation.Resource;

/**
 * description:
 * <p>fill description</p>
 *
 * @author zido
 * @date 2017/5/23 0023 13:56
 */
@RestController
@RequestMapping("")
public class Index {
    @Resource
    private OneService oneService;
    @RequestMapping("/index")
    public String test(){
        String start = oneService.start();
        return "hello world " + start;
    }
}
