package site.zido.core.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * mybatis配置
 * <p>配置mybatis plus，连接数据库</p>
 *
 * @author zido
 * @since 2017/5/25
 */
@Configuration
public class MyBatisConfiguration {
    @Resource
    private SqlSessionFactory factory;
    @Value("${spring.profiles.active}")
    private String profile;
    private static Logger logger = LoggerFactory.getLogger(MyBatisConfiguration.class);

    /**
     * 配置分页插件
     * @return 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        paginationInterceptor.setOptimizeType("aliDruid");

        return paginationInterceptor;
    }

    /**
     * 配置xml文件自动刷新(仅开发环境有效)
     * @return 自动刷新
     */
    @Bean
    public MybatisMapperRefresh refresh(){
        MybatisMapperRefresh refresh = null;
        try {
            refresh = new MybatisMapperRefresh(factory,profile.equals("dev"));
        } catch (Exception e) {
            logger.error("开启自动xml自动刷新失败");
            e.printStackTrace();
        }
        return refresh;
    }
}
