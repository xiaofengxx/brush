package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.transaction.annotation.Transactional;
import site.zido.dto.AnnouncementDTO;
import site.zido.entity.Announcement;
import site.zido.mapper.user.AnnouncementMapper;
import site.zido.service.user.IAnnouncementService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商家和刷手的公告 服务实现类
 * </p>
 *
 * @author zido
 * @since 2017-06-26
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

    @Resource
    private AnnouncementMapper announcementMapper;

    @Override
    @Transactional
    public void insertBusiness(Announcement announcement) {
        announcementMapper.insert(announcement);
    }

    @Override
    public List<Announcement> findAllAnnouncement() {
        return announcementMapper.selectList(new EntityWrapper<Announcement>());
    }

    @Override
    public List<Announcement> selectAnnouncementByType(int i) {
        return announcementMapper.selectList(new EntityWrapper<Announcement>().where("pub_type = {0}",i));
    }

    @Override
    public List<Announcement> selectAnounceByTime(AnnouncementDTO adto) {
        return announcementMapper.selectAnounceByTime(adto);
    }
}
