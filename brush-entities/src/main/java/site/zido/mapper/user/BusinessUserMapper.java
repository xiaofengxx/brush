package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import site.zido.dto.BusinessCondition;
import site.zido.dto.BusinessUserInfoDTO;
import site.zido.entity.BusinessUser;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/1 0001
 */
public interface BusinessUserMapper extends BaseMapper<BusinessUser> {
    public Integer selectMaxSort();

    String selectMaxUserName();

    List<BusinessUserInfoDTO> selectBusinessList(@Param("condition") BusinessCondition condition);

    /**
     * 通过关键字搜索模糊搜索
     * @param key 关键字
     * @param state 状态
     * @return 仅包含用户名/sort/用户id字段
     */
    List<BusinessUser> selectByKey(@Param("key") String key, @Param("state") Integer state, @Param("max") Integer max);

    void clearIntroduces(@Param("introduceId") Long introduceId);

    String findAllBusinessNumber(String adPhonenumber);
}
