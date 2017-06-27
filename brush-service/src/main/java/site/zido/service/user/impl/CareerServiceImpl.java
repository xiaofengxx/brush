package site.zido.service.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import site.zido.entity.Career;
import org.springframework.stereotype.Service;
import site.zido.mapper.user.CareerMapper;
import site.zido.service.user.ICareerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 职业信息表 服务实现类
 * </p>
 *
 * @author zido
 * @since 2017-06-26
 */
@Service
public class CareerServiceImpl extends ServiceImpl<CareerMapper, Career> implements ICareerService {

    @Resource
    private CareerMapper careerMapper;


    @Override
    public List<Career> getAllList() {
        return selectList(null);
    }

    @Override
    public List<Career> selectByUserId(Long userid) {

        List<Career> careers = careerMapper.selectByUserId(userid);

        return careers;
    }
}
