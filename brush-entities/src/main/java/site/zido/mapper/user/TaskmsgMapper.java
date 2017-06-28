package site.zido.mapper.user;

import site.zido.entity.Taskmsg;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 任务详情列表 Mapper 接口
 * </p>
 *
 * @author zido
 * @since 2017-06-28
 */
public interface TaskmsgMapper extends BaseMapper<Taskmsg> {

    /**
     * 获取当前最大的sort
     * @return
     */
    Long getMaxTaskSort();

}