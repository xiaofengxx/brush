package site.zido.business.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

/**
 * Created by CDDC on 2017/6/27.
 */
@RequestMapping(value = "/submitInfo")
public class BusinessSubController extends BaseController {

    @PostMapping(value = "/busiChargePicture")
    @ApiOperation(value = "商家提交充值的截图")
    public AjaxResult busiChargePicture(){

        return null;
    }
}
