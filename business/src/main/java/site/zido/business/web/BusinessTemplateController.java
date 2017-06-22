package site.zido.business.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.BusinessTemplate;
import site.zido.entity.User;
import site.zido.service.user.IBusinessTemplateService;

import javax.annotation.Resource;

/**
 *
 * Created by FZC on 2017/6/22.
 */
@RestController
@RequestMapping(value = "/api/business")
public class BusinessTemplateController extends BaseController{

    @Resource
    private IBusinessTemplateService businessTemplateService;

    @PostMapping(value = "/insert")
    @ApiOperation(value = "添加模板")
    public AjaxResult insert(@RequestBody BusinessTemplate template){
        User currentUser = getCurrentUser();


        template.setUserId(currentUser.getId());
        template.setState(0L);
        //数据正确验证
















        //验证完毕


        boolean insert = businessTemplateService.insert(template);
        if(insert){
            return success(LangConstants.OPERATE_SUCCESS);
        }else{
            return fail(LangConstants.OPERATE_FAIL);
        }
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "根据id删除")
    public AjaxResult deletetempalte(@RequestParam(defaultValue = "-1") String tempalteId){

        User currentUser = getCurrentUser();

        BusinessTemplate businessTemplate = businessTemplateService.selectById(tempalteId);

        //判断

        if(businessTemplate == null){
            return fail(LangConstants.TMEPLATE_IS_NOT_EXIST);
        }

        if(businessTemplate.getUserId() != currentUser.getId()){
            return fail(LangConstants.TMEPLATE_IS_NOT_EXIST);
        }
        //大于1时 说明已经提交审核
        if(businessTemplate.getState() > 1){
            return fail(LangConstants.TMEPLATE_CAN_NOT_OPERATE);
        }

        boolean b = businessTemplateService.deleteById(tempalteId);


        if(b){
            return success(LangConstants.OPERATE_SUCCESS);
        }else{
            return fail(LangConstants.OPERATE_FAIL);
        }
    }

}
