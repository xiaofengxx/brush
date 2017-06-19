package site.zido.pub.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/19 0019
 */
@RestController
@RequestMapping("/api/pub")
public class TestController extends BaseController {
    @PostMapping("/info")
    public AjaxResult getResult(){
        return success();
    }
}
