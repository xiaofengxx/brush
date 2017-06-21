package site.zido.mapper.user;

import org.apache.ibatis.annotations.Param;
import site.zido.dto.BusinessTemplateCondition;
import site.zido.dto.BusinessTemplateInfoDTO;
import site.zido.entity.BusinessTemplate;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 商家模板表 Mapper 接口
 * </p>
 *
 * @author zido
 * @since 2017-06-20
 */
public interface BusinessTemplateMapper extends BaseMapper<BusinessTemplate> {


    /**
     * 获取最大的id
     * @return
     */
    String selectmaxid();

    /**
     * 那条件搜索结果
     * @param condition
     * @return
     */
    List<BusinessTemplateInfoDTO> searchBusinessTemplateList(@Param("condition") BusinessTemplateCondition condition);
}