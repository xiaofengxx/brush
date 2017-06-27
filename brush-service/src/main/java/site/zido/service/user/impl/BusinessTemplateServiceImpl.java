package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import site.zido.brush.utils.EntityUtils;
import site.zido.dto.BusinessTemplateCondition;
import site.zido.dto.BusinessTemplateInfoDTO;
import site.zido.entity.BusinessTemplate;
import org.springframework.stereotype.Service;
import site.zido.entity.BusinessUser;
import site.zido.entity.User;
import site.zido.mapper.user.BusinessTemplateMapper;
import site.zido.service.user.BusinessUserService;
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

    @Resource
    BusinessUserService businessUserService;


    @Override
    @Transactional
    public synchronized boolean userAddTemplate(User user, BusinessTemplate businessTemplate) {
        if(user != null){
            businessTemplate.setUserId(user.getId());
        }else{
            //设置用户id
            businessTemplate.setUserId(user.getId());
            //设置商家id
            BusinessUser businessUser = businessUserService.selectByUserId(user.getId());
            businessTemplate.setBusinessId(businessUser.getId());
        }

        //生成id
        businessTemplate.setId(EntityUtils.generatorId());

        // 生成 sort编号
        Long selectmaxsort = businessTemplateMapper.selectmaxsort();
        if(selectmaxsort == null || selectmaxsort < 1000){
            selectmaxsort = 10003L;
        }
        selectmaxsort++;
        businessTemplate.setSort(selectmaxsort);

        return insert(businessTemplate);
    }

    @Override
    public boolean userAddTemplate(BusinessTemplate businessTemplate) {
        return userAddTemplate(null,businessTemplate);
    }

    @Override
    public boolean updateStateById(String templateid, Long sate) {
        return updateStateById(null,templateid,sate);
    }

    @Override
    public boolean updateStateById(User user, String templateid, Long sate) {
        return  update(new BusinessTemplate().setState(sate),
                new EntityWrapper<BusinessTemplate>().where("id={0}",templateid));
    }

    @Override
    public List<BusinessTemplate> getListByUserid(String userid) {
        return selectList(new EntityWrapper<BusinessTemplate>().where("user_id={0}",userid));
    }

    @Override
    public Page<BusinessTemplateInfoDTO> getBusinessTemplateList(Integer currentPage, Integer pagesize, BusinessTemplateCondition condition) {
        Page<BusinessTemplateInfoDTO> resultpage = new Page<>(currentPage,pagesize);
        resultpage.setRecords(businessTemplateMapper.searchBusinessTemplateList(condition));
        return resultpage;
    }

    @Override
    public boolean updata(User user, BusinessTemplate template) {
        //关键信息赋值,防止被修改
        template.setSort(null);
        template.setUserId(null);
        template.setBusinessId(null);

        boolean update = update(template, new EntityWrapper<BusinessTemplate>().where("id = {0}", template.getId()));

        return update;
    }

    @Override
    public BusinessTemplateInfoDTO getBusinessTemplateInfoDTOone(Long templateid) {

        Page<BusinessTemplateInfoDTO> businessTemplateList = getBusinessTemplateList(1,
                1,new BusinessTemplateCondition().setTemplateid(templateid));

        //判断结果集
        if(CollectionUtils.isEmpty(businessTemplateList.getRecords())){
            return null;
        }

        return businessTemplateList.getRecords().get(0);
    }

    @Override
    public boolean deleteById(String templateid) {
        return deleteById(null,templateid);
    }

    @Override
    public boolean deleteById(User user, String templateid) {
        return delete(new EntityWrapper<BusinessTemplate>().where("id = {0}",templateid));
    }


}
