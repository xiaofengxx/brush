package site.zido.center.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

/**
 * Created by CDDC on 2017/6/13.
 */
@RestController
@RequestMapping(value = "/api/center")
public class CenterController extends BaseController{
    /**
     * 管理员修改密码
     */
    @PostMapping(value = "/updatePwd")
    public AjaxResult updatePwd(){
        
        return null;
    }
}
