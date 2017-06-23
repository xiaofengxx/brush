package site.zido.service.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.zido.entity.User;
import site.zido.mapper.user.UserMapper;
import site.zido.service.user.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/29 0029
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "democache", key = "'allUser' + #id")
    public List<User> getAllUser(String id) {
        System.out.println("write write");
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.findUserByUsername(username);
    }


    @Override
    public void updateFail(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public Long getnewusername() {

        Long result = getmaxusername();

        // 用户名最小值为10003
        if(result < 1){
            result = 10002l;
        }

        return ++result;
    }

    @Override
    public Long getmaxusername() {
        String strmaxnum = userMapper.selectMaxUserName();

        if(StringUtils.isBlank(strmaxnum)){
            strmaxnum = "0";
        }
        Integer integer = Integer.valueOf(strmaxnum);

        return integer.longValue();
    }


    @Override
    @Transactional
    public synchronized void autoCreateIdAndPws(User user) {
        //区别,商家用户名自动生成.刷手用户名为手机号
        if(StringUtils.isBlank(user.getUsername())){
            Long aLong = getnewusername();
            user.setUsername(aLong + "");
        }
        user.setPassword("123456");
        user.setEnabled(1);
        userMapper.updateById(user);
    }

    @Override
    public void updatePwd(User user) {
        //通过用户id修改密码
        userMapper.updatePwdById(user);
    }

    @Override
    public void cancelUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User selectBySubUsername(String username) {
        return userMapper.selectBySubUsername(username);
    }

    @Override
    public User findLoguserByNameAndPwd(String username, String password) {
        return userMapper.findLonuserBynameAndPwd(username,password);
    }
}
