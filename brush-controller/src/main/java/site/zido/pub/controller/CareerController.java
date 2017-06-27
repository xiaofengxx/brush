package site.zido.pub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.Career;
import site.zido.service.user.ICareerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FZC on 2017/6/27.
 */
@Controller
@RequestMapping("/api/pub")
public class CareerController extends BaseController {

    @Resource
    private ICareerService careerService;


    @PostMapping("/career/list")
    public AjaxResult getCareerList(){
        List<Career> allList = careerService.getAllList();
        return successData(allList);
    }

}
