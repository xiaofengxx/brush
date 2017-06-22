package site.zido.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import site.zido.dto.BusinessTemplateCondition;
import site.zido.dto.BusinessTemplateInfoDTO;
import site.zido.dto.SubscriberUserInfoDTO;
import site.zido.entity.BusinessTemplate;
import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.User;

import java.util.List;

/**
 * <p>
 * 商家模板表 服务类
 * </p>
 *
 * @author fzc
 * @since 2017-06-20
 */
public interface IBusinessTemplateService extends IService<BusinessTemplate> {


    /**
     * 添加模板 (指定添加用户)
     * @param user  操作人信息
     * @param businessTemplate
     */
    boolean userAddTemplate(User user, BusinessTemplate businessTemplate);


    /**
     * 添加模板
     * @param businessTemplate
     * @return
     */
    boolean userAddTemplate(BusinessTemplate businessTemplate);

    /**
     * 修改模板的状态
     * @param templateid 模板id
     * @param sate 模板状态: 1.未提交审批，2.提交审批，3.审批通过，4.审批未通过（提示修改）
     */
    boolean updateStateById(String templateid,Long sate);

    /**
     * 通过userid得到列表
     * @param userid
     * @return
     */
    List<BusinessTemplate> getListByUserid(String userid);


    /**
     *  按条件查询结果
     * @param currentPage 当前页
     * @param pagesize 页大小
     * @param condition 条件类
     * @return
     */
    Page<BusinessTemplateInfoDTO> getBusinessTemplateList(Integer currentPage, Integer pagesize, BusinessTemplateCondition condition);

    /**
     * 根据id删除
     * @param templateid
     * @return
     */
    boolean deleteById(String templateid);



}
