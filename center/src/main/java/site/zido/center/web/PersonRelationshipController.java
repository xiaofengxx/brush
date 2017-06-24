package site.zido.center.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

/**
 * Created by CDDC on 2017/6/24.
 */
@RestController
@RequestMapping(value = "/api/center")
public class PersonRelationshipController extends BaseController {
    /**
     * 商家人际关系
     */
    @PostMapping(value = "/businessModule")
    @ApiOperation("商家人际关系模块")
    public AjaxResult businessModule(){

        return null;
    }
}
