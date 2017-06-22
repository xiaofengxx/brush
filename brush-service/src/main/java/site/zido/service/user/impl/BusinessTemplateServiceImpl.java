package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import site.zido.dto.BusinessTemplateCondition;
import site.zido.dto.BusinessTemplateInfoDTO;
import site.zido.entity.BusinessTemplate;
import org.springframework.stereotype.Service;
import site.zido.entity.User;
import site.zido.mapper.user.BusinessTemplateMapper;
import site.zido.service.user.IBusinessTemplateService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商家模板表 服务实现类
 * </p>
 *
 * @author fzc
 * @since 2017-06-20
 */
@Service
public class BusinessTemplateServiceImpl extends ServiceImpl<BusinessTemplateMapper, BusinessTemplate> implements IBusinessTemplateService {

    @Resource
    private BusinessTemplateMapper businessTemplateMapper;


    @Override
    public boolean userAddTemplate(User user, BusinessTemplate businessTemplate) {
        if(user != null)
            businessTemplate.setUserId(user.getId());
        return insert(businessTemplate);
    }

    @Override
    public boolean userAddTemplate(BusinessTemplate businessTemplate) {
        return userAddTemplate(null,businessTemplate);
    }

    @Override
    public boolean updateStateById(String templateid, Long sate) {
        return  update(new BusinessTemplate().setState(sate),
                        new EntityWrapper<BusinessTemplate>().where("id={0}",templateid));
    }

    @Override
    public List<BusinessTemplate> getListByUserid(String userid) {
        return selectList(new EntityWrapper<BusinessTemplate>().where("id={0}",userid));
    }

    @Override
    public Page<BusinessTemplateInfoDTO> getBusinessTemplateList(Integer currentPage, Integer pagesize, BusinessTemplateCondition condition) {
        Page<BusinessTemplateInfoDTO> resultpage = new Page<>(currentPage,pagesize);
        resultpage.setRecords(businessTemplateMapper.searchBusinessTemplateList(condition));
        return resultpage;
    }

    @Override
    public boolean deleteById(String templateid) {
        return false;
    }

}
