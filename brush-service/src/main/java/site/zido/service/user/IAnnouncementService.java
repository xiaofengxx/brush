package site.zido.service.user;

import site.zido.dto.AnnouncementDTO;
import site.zido.entity.Announcement;
import com.baomidou.mybatisplus.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商家和刷手的公告 服务类
 * </p>
 *
 * @author zido
 * @since 2017-06-26
 */
public interface IAnnouncementService extends IService<Announcement> {
    /**
     * 添加商家公告
     * @param announcement
     */
    void insertBusiness(Announcement announcement);

    /**
     * 查看所有公告
     * @return
     */
    List<Announcement> findAllAnnouncement();

    /**
     * 根据类型查找公告
     * @param i
     * @return
     */
    List<Announcement> selectAnnouncementByType(int i);

    /**
     * 根据开始时间和结束时间查找公告
     * @return
     */
    List<Announcement> selectAnounceByTime(AnnouncementDTO adto);
}
