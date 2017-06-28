package site.zido.service.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import site.zido.entity.BusinessUser;
import site.zido.entity.Taskmsg;
import org.springframework.stereotype.Service;
import site.zido.entity.User;
import site.zido.mapper.user.TaskmsgMapper;
import site.zido.service.user.BusinessUserService;
import site.zido.service.user.TaskmsgService;
import site.zido.service.user.UserService;

import javax.annotation.Resource;


/**
 * <p>
 * 任务详情列表 服务实现类
 * </p>
 *
 * @author zido
 * @since 2017-06-28
 */
@Service
public class TaskmsgServiceImpl extends ServiceImpl<TaskmsgMapper, Taskmsg> implements TaskmsgService {

    @Resource
    private UserService userService;
    @Resource
    private BusinessUserService businessUserService;
    @Resource
    private TaskmsgMapper taskmsgMapper;


    @Override
    public boolean addUserTask(String userid,Taskmsg taskmsg) {

        User user = userService.selectById(userid);
        if(user == null){
            return false;
        }

        return addUserTask(user,taskmsg);
    }

    @Override
    public boolean addUserTask(User user,Taskmsg taskmsg) {

        BusinessUser businessUser = businessUserService.selectByUserId(user.getId());

        if(businessUser == null){
            return false;
        }

        return addUserTask(businessUser,taskmsg);
    }

    @Override
    @Transactional
    public synchronized boolean addUserTask(BusinessUser businessUser,Taskmsg taskmsg) {

        //设置状态为 1.未提交审批，2.提交审批，3.审批通过，4.审批未通过（提示修改）
        taskmsg.setState("1");
        //设置任务完成数量为0
        taskmsg.setTaskCompleteNum(0L);

        Long maxTaskSort = taskmsgMapper.getMaxTaskSort();
        if(maxTaskSort == null){
            maxTaskSort = 10005L;
        }
        taskmsg.setTaskSrot(++maxTaskSort);


        taskmsg.setUserId(businessUser.getUserId());
        taskmsg.setBusinessId(businessUser.getId());

        /**
         * 待完成
         */
        //计算任务价格


        taskmsg.setTaskPrice(2.2);



        //
        taskmsg.setTaskPriceCount(taskmsg.getTaskPrice()*taskmsg.getTaskNum());

        taskmsg.setProductPriceCount(Double.valueOf(taskmsg.getProductPresentPrice()) * taskmsg.getTaskNum());


        boolean insert = insert(taskmsg);

        return insert;
    }

    @Override
    public boolean deleteTask(String taskmsgid) {

        Taskmsg taskmsg = selectById(taskmsgid);

        if(taskmsg == null){
            return false;
        }
        //任务审核 状态: 1.未提交审批，2.提交审批，3.审批通过，4.审批未通过（提示修改）
        /**
         * 提交审批和审批通过的任务不能删除
         */
        if("2".equals(taskmsg.getState())|| "3".equals(taskmsg.getState())){

        }
        return deleteById(taskmsgid);
    }
}
