package site.zido.mapper.user;

import org.apache.ibatis.annotations.Param;
import site.zido.entity.UserCareer;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 用户与职业关联表 Mapper 接口
 * </p>
 *
 * @author zido
 * @since 2017-06-26
 */
public interface UserCareerMapper extends BaseMapper<UserCareer> {

    /**
     * 删除不存在的
     * @param userid
     * @param careers
     */
    void deleteNotRange(@Param("userid") String userid, @Param(value = "careers") List<UserCareer> careers);

}