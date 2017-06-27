package site.zido.mapper.user;

import org.apache.ibatis.annotations.Param;
import site.zido.dto.AnnouncementDTO;
import site.zido.entity.Announcement;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * <p>
  * 商家和刷手的公告 Mapper 接口
 * </p>
 *
 * @author zido
 * @since 2017-06-26
 */
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    List<Announcement> selectAnounceByTime(@Param(value = "adto") AnnouncementDTO adto);
}