package site.zido.pub.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.zido.core.LangConstants;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;
import site.zido.dto.AnnouncementDTO;
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

    @PostMapping(value = "/addAnnouncement")
    @ApiOperation(value = "添加商家或刷手公告")
    public AjaxResult addSub(@RequestBody Announcement announcement) {
        if (announcement == null){
            return fail(LangConstants.ANNOUNCEMENT_FAIL);
        }
       announcementService.insertBusiness(announcement);
        return success(LangConstants.OPERATE_SUCCESS);
    }

    @PostMapping(value = "/findAllAnnouncement")
    @ApiOperation("查看所有的公告")
    public AjaxResult findAllAnnouncement() {
        List<Announcement> list = announcementService.findAllAnnouncement();
        if (list.size() <= 0){
            return fail(LangConstants.ANNOUNCEMENT_CAN_NOT_BE_FIND);
        }
        return successData(list);
    }

    @PostMapping(value = "/selectSubOrBusi")
    @ApiOperation(value = "根据类型查找商家或者刷手公告")
    public AjaxResult selectAnnouncementByType(Integer i) {
        if (i == 1){
            List<Announcement> list = announcementService.selectAnnouncementByType(i);
            return successData(list);
        }else if (i == 2){
            List<Announcement> list = announcementService.selectAnnouncementByType(i);
            return successData(list);
        }else {
            return fail(LangConstants.ANNOUNCEMENT_CAN_NOT_BE_FIND);
        }
    }

    @PostMapping(value = "/selectAnnouncementByTime")
    @ApiOperation(value = "通过时间查找公告")
    public AjaxResult selectAnnounceByTime(@RequestBody AnnouncementDTO adto) {
        if (adto.getStartTime() == null && adto.getEndTime() == null){
            return fail(LangConstants.PLEASE_CHOICE_RIGHT_TIME);
        }
        List<Announcement> list = announcementService.selectAnounceByTime(adto);
        return successData(list);
    }
}
