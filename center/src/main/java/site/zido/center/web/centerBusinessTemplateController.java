package site.zido.center.web;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.zido.brush.utils.LangUtils;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.core.constants.BrushConstants;
import site.zido.dto.AjaxResult;
import site.zido.dto.BusinessTemplateCondition;
import site.zido.dto.BusinessTemplateInfoDTO;
import site.zido.entity.BusinessTemplate;
import site.zido.service.user.IBusinessTemplateService;

import javax.annotation.Resource;

/**
 *
 * Created by FZC on 2017/6/22.
 */
@RestController
@RequestMapping("/api/center/template")
public class centerBusinessTemplateController extends BaseController {

    @Resource
    private IBusinessTemplateService businessTemplateService;

    @Resource
    private BrushConstants constants;

    @PostMapping(value = "/searchList")
    @ApiOperation(value = "多条件搜索")
    public AjaxResult searchTemplateList(@RequestParam(defaultValue = "1") Integer currentPage,
                                         @RequestParam(defaultValue = "0") Integer level,
                                         @RequestBody BusinessTemplateCondition condition){

        Page<BusinessTemplateInfoDTO> businessTemplateList = businessTemplateService.
                getBusinessTemplateList(currentPage, constants.getPageSize(level), condition);

        return successData(businessTemplateList);
    }

    @PostMapping(value = "/pass")
    @ApiOperation(value = "审核模板")
    public AjaxResult Examine(@RequestParam boolean pass,@RequestParam String templateid){

        BusinessTemplate businessTemplate = businessTemplateService.selectById(templateid);

        if(businessTemplate == null){
            return fail(LangConstants.TMEPLATE_IS_NOT_EXIST);
        }

        if(businessTemplate.getState() != 2){
            return fail(LangConstants.TMEPLATE_CAN_NOT_OPERATE);
        }

        Long state = 2L;
        if(pass){
            state = 3L;
        }else{
            state = 4L;
        }

        boolean b = businessTemplateService.updateStateById(templateid, state);
        if(b)
            return success(LangConstants.OPERATE_SUCCESS);

        return fail(LangConstants.OPERATE_FAIL);
    }

}
