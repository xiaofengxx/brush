package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

/**
 * Created by CDDC on 2017/6/21.
 */
@RestController
@RequestMapping(value = "/api/pub")
public class IntroUserController extends BaseController {

    @PostMapping(value = "/introUser")
    @ApiOperation(value = "介绍人选择")
    public AjaxResult introUser(){

        return null;
    }

}
