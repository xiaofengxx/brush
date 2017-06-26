package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import site.zido.entity.Career;

import java.util.List;

/**
 * Created by CDDC on 2017/6/2.
 */
public interface CareerMapper extends BaseMapper<Career> {


    /**
     * 获取用户的职业表列
     * @param userid
     * @return
     */
    List<Career> selectByUserId(@Param(value = "userid") Long userid);
}
