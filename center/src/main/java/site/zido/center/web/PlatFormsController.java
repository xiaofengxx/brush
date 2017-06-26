package site.zido.center.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.Platforms;
import site.zido.service.user.IPlatformsService;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by FZC on 2017/6/22.
 */
@RestController
@RequestMapping(value = "/api/center/platforms")
public class PlatFormsController extends BaseController{

    @Resource
    private IPlatformsService platformsService;


    @PostMapping(value = "/delete")
    @ApiOperation(value = "通过id删除平台")
    public AjaxResult deletePlat(@RequestParam String id){

        boolean id1 = platformsService.delete(new EntityWrapper<Platforms>().where("id"));

        if(id1){
            return success(LangConstants.OPERATE_SUCCESS);
        }else{
            return fail(LangConstants.OPERATE_FAIL);
        }
    }

    @PostMapping(value = "/insert")
    @ApiOperation(value = "添加平台")
    public AjaxResult insertPlat(@RequestBody Platforms platforms){

        Platforms temp = platformsService.selectByname(platforms.getPlatformName());

        if(temp != null){
            return fail(LangConstants.PLATFORM_IS_EXIST);
        }

        platformsService.insert(platforms);

        return success(LangConstants.OPERATE_SUCCESS);
    }


    @PostMapping("/getlist")
    @ApiOperation(value = "获取平台列表")
    public AjaxResult getPlatFomesList(){

        List<Platforms> platforms = platformsService.selectList(null);

        return successData(platforms);
    }

}




