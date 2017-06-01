package site.zido.brush.utils;

import com.baomidou.mybatisplus.toolkit.IdWorker;

/**
 * 实体工具类
 *
 * @author zido
 * @since 2017/6/1 0001
 */
public class EntityUtils {
    public static Long generatorId(){
        return IdWorker.getId();
    }
}
