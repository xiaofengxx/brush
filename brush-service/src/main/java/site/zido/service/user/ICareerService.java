package site.zido.service.user;

import site.zido.entity.Career;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 职业信息表 服务类
 * </p>
 *
 * @author zido
 * @since 2017-06-26
 */
public interface ICareerService extends IService<Career> {

    /**
     * 得到职业列表
     * @return
     */
    List<Career> getAllList();

    /**
     * 通过用户ID得到列表
     * @param userid
     * @return
     */
    List<Career> selectByUserId(Long userid);
	
}
