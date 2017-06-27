package site.zido.otherService.qiniu;

import site.zido.brush.utils.PropertiesUtils;

/**
 * 七牛云属性配置文件
 *
 * @author zido
 * @since 2017/6/27 0027
 */
public class QiniuProperties {
    /**
     * 构造函数私有化
     */
    private QiniuProperties(){}

    static {
        PropertiesUtils.use("other.properties");
        ACCESS_KEY = PropertiesUtils.value("qiniu.ACCESS_KEY");
        SECRET_KEY = PropertiesUtils.value("qiniu.SECRET_KEY");
        BUCKET = PropertiesUtils.value("qiniu.BUCKET");
    }

    public static final String ACCESS_KEY;
    public static final String SECRET_KEY;
    public static final String BUCKET;

}
