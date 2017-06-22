package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.Platforms;
import site.zido.service.user.IPlatformsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FZC on 2017/6/22.
 */
@RestController
@RequestMapping(value = "/api/pub")
public class PubPlatFormsController extends BaseController {

    @Resource
    private IPlatformsService platformsService;

    @PostMapping("/platfromslist")
    @ApiOperation(value = "获取平台列表")
    public AjaxResult getPlatFomesList(){

        List<Platforms> platforms = platformsService.selectList(null);

        return successData(platforms);
    }
}
