package site.zido.service.user;

import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.UserCareer;

import java.util.List;

/**
 * 用户职业对应表
 * Created by FZC on 2017/6/26.
 */
public interface UserCareerService extends IService<UserCareer> {


    /**
     * 删除不存在的
     * @param careers
     */
    void deleteNotRange(String userid,List<UserCareer> careers);

    /**
     * 通过用户ID查询
     * @param userid
     * @return
     */
    List<UserCareer> selectByUserId(Long userid);
}
