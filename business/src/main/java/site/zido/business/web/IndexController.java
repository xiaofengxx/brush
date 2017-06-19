package site.zido.business.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
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
public class IndexController extends BaseController {

    @ApiOperation(value = "这是首页", notes = "获取所有的用户信息")
    @RequestMapping(value = "/index")
    public AjaxResult index() {
        return success();
    }
}
