package site.zido.service.user;

import site.zido.entity.Announcement;
import com.baomidou.mybatisplus.service.IService;

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
     * 添加商家广告
     * @param announcement
     */
    void insertBusiness(Announcement announcement);

    /**
     * 查看所有广告
     * @return
     */
    List<Announcement> findAllAnnouncement();

}
