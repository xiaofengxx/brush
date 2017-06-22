package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import site.zido.dto.SubscriberCondition;
import site.zido.dto.SubscriberUserInfoDTO;
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

    /**
     * 根据条件搜索
     * @param condition 条件类
     * @return
     */
    List<SubscriberUserInfoDTO> searchSubscriberList(@Param("condition")SubscriberCondition condition);

    List<SubscriberUser> findSubUserByCondition(String introUser);
}
