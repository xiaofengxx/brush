package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.entity.Announcement;
import site.zido.service.user.IAnnouncementService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CDDC on 2017/6/26.
 */
@RestController
@RequestMapping(value = "/announcement")
public class AnnouncementController extends BaseController {

    @Resource
    private IAnnouncementService announcementService;

    @PostMapping(value = "/addSub")
    @ApiOperation(value = "添加商家或刷手广告")
    public AjaxResult addSub(@RequestBody Announcement announcement){
        if (announcement == null){
            return fail(LangConstants.ANNOUNCEMENT_FAIL);
        }
       announcementService.insertBusiness(announcement);
        return success(LangConstants.OPERATE_SUCCESS);
    }

    @PostMapping(value = "/findAllAnnouncement")
    @ApiOperation("查看所有的广告")
    public AjaxResult findAllAnnouncement(){
        List<Announcement> list = announcementService.findAllAnnouncement();
        if (list.size() <= 0){
            return fail(LangConstants.ANNOUNCEMENT_CAN_NOT_BE_FIND);
        }
        return successData(list);
    }
}
