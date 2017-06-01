package site.zido.center.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CDDC on 2017/6/1.
 */
@RestController
@RequestMapping(value = "api/business")
public class BusinessController {
    /**
     * 商家信息录入
     */
    @PostMapping(value = "/add")
    public void AddBusiness(){

    }
}
