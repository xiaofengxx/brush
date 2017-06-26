package site.zido.service.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import site.zido.entity.UserCareer;
import site.zido.mapper.user.UserCareerMapper;
import site.zido.service.user.UserCareerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FZC on 2017/6/26.
 */
@Service
public class UserCareerServiceImpl extends ServiceImpl<UserCareerMapper,UserCareer> implements UserCareerService{

    @Resource
    private UserCareerMapper userCareerMapper;


    @Override
    public void deleteNotRange(String userid,List<UserCareer> careers) {
        if(StringUtils.isBlank(userid)||CollectionUtils.isEmpty(careers)){
            return ;
        }
        userCareerMapper.deleteNotRange(userid,careers);
    }
}
