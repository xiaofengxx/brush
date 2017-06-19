package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import site.zido.entity.SubscriberUser;

import java.util.List;

/**
 * Created by CDDC on 2017/6/2.
 */
public interface SubscriberUserMapper extends BaseMapper<SubscriberUser> {

    /**
     * 通过关键字获取搜索提示列表
     * @return
     */
    List<SubscriberUser> selectByKey(@Param("key") String key, @Param("state") Integer state, @Param("max") Integer max);
}
