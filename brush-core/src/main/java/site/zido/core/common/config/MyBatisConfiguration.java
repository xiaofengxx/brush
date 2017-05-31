package site.zido.core.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置
 * <p>配置mybatis plus，连接数据库</p>
 *
 * @author zido
 * @since 2017/5/25
 */
@Configuration
@MapperScan(basePackages = "site.zido.mapper*")
public class MyBatisConfiguration {

    /**
     * 配置分页插件
     *
     * @return 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        paginationInterceptor.setOptimizeType("aliDruid");

        return paginationInterceptor;
    }
}
