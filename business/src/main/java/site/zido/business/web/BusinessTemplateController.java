package site.zido.business.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.BusinessTemplate;
import site.zido.entity.Shop;
import site.zido.entity.User;
import site.zido.service.user.IBusinessTemplateService;
import site.zido.service.user.ShopService;

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

    @Resource
    private ShopService shopService;

    @PostMapping(value = "/addedit")
    @ApiOperation(value = "添加/修改-自己的-模板")
    public AjaxResult addedit(@RequestBody BusinessTemplate template){


        User currentUser = getCurrentUser();


        if(template == null){
            fail(LangConstants.TEMPLATE_MSG_IS_NULL);
        }

        boolean isadd = false;

        Long templateid = template.getId();

        //根据有无id判断是否为新增
        if(templateid == null){
            isadd = true;
        }else{
            //关键数据使用数据库中的数据 如 state ,userid ,businessid ,sort
            BusinessTemplate businessTemplate = businessTemplateService.selectById(templateid);

            //判断模板的所属人
            if(businessTemplate.getUserId() != currentUser.getId()){
                fail(LangConstants.TMEPLATE_IS_NOT_EXIST);
            }

            //判断模板所处的状态能否修改
            Long state = businessTemplate.getState();

            //模板状态: 1.未提交审批，2.提交审批，3.审批通过，4.审批未通过（提示修改）
            if(state == 2 || state == 3){
                return fail(LangConstants.TMEPLATE_CAN_NOT_OPERATE);
            }
        }

        //数据正确验证

        /**
         * 待完成 待确定必要参数
         */

        //判断店铺id是否正确 店铺所属人是否正确
        Shop byUserIdShopId = shopService.getByUserIdShopId(currentUser.getId(), template.getShopId());
        if(byUserIdShopId == null){
            return fail(LangConstants.SHOP_IS_EXIST);
        }
        
        //验证完毕

        //设置状态为未审核
        template.setState(0L);

        if(isadd){
            businessTemplateService.userAddTemplate(currentUser,template);
        }else{
            businessTemplateService.updata(currentUser,template);
        }

        return success(LangConstants.OPERATE_SUCCESS);
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

    @PostMapping(value = "/submittemplate")
    @ApiOperation(value = "模板提交审核")
    public AjaxResult SubmitTemplate(@RequestParam(defaultValue = "-1") String templateId){

        User currentUser = getCurrentUser();

        BusinessTemplate businessTemplate = businessTemplateService.selectById(templateId);

        //判断模板存在 所属人

        if(businessTemplate == null || !currentUser.getId().equals(businessTemplate.getUserId() )){
            fail(LangConstants.TMEPLATE_IS_NOT_EXIST);
        }

        //判断模板当前状态是否能够提交审核

        //模板状态: 1.未提交审批，2.提交审批，3.审批通过，4.审批未通过（提示修改）
        if(!"1".equals(businessTemplate.getState())){
            fail(LangConstants.TMEPLATE_CAN_NOT_OPERATE);
        }

        //提交审核(修改模板状态)
        boolean b = businessTemplateService.updateStateById(templateId, 2L);

        if(b) {
            return success(LangConstants.OPERATE_SUCCESS);
        }else{
            return fail(LangConstants.OPERATE_FAIL);
        }
    }

}
