package site.zido.center.web;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import site.zido.dto.UserWithInfoDTO;
import site.zido.service.user.BusinessService;

import javax.annotation.Resource;

/**
 * Created by CDDC on 2017/6/1.
 */
@RestController
@RequestMapping(value = "api/business")
public class BusinessController {
    @Resource
    private BusinessService businessService;
    /**
     * 商家信息录入
     */
    @PostMapping(value = "/add")
    public void addBusiness(@RequestBody UserWithInfoDTO uwid){
        businessService.addBusiness(uwid);
    }
}
