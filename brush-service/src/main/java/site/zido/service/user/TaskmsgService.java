package site.zido.service.user;

import site.zido.entity.BusinessTemplate;
import site.zido.entity.BusinessUser;
import site.zido.entity.Taskmsg;
import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.User;

/**
 * <p>
 * 任务详情列表 服务类
 * </p>
 *
 * @author zido
 * @since 2017-06-28
 */
public interface TaskmsgService extends IService<Taskmsg> {



    /**
     * 用户添加任务
     * @param userid
     * @param taskmsg
     * @return
     */
    boolean addUserTask(String userid,Taskmsg taskmsg);

    /**
     * 用户添加任务
     * @param user
     * @param taskmsg
     * @return
     */
    boolean addUserTask(User user,Taskmsg taskmsg);

    /**
     * 用户添加模板
     * @param businessUser
     * @param taskmsg
     * @return
     */
    boolean addUserTask(BusinessUser businessUser,Taskmsg taskmsg);

    /**
     * 任务id删除
     * @param taskmsgid
     * @return
     */
    boolean deleteTask(String taskmsgid);



}
