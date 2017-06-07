package site.zido.core.constants;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置属性
 *
 * @author zido
 * @since 2017/6/6 0006
 */
@ConfigurationProperties("brush")
@Component
public class BrushConstants {
    private Integer[] pageDefaults;


    public Integer[] getPageDefaults() {
        return pageDefaults;
    }

    public BrushConstants setPageDefaults(Integer[] pageDefaults) {
        this.pageDefaults = pageDefaults;
        return this;
    }

    public Integer getPageSize(Integer level){
        if(level == null || level < 0 || level >= pageDefaults.length)
            return pageDefaults[0];
        return pageDefaults[level];
    }
}
