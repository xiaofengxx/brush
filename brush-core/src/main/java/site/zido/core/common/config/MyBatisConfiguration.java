package site.zido.core.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;

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
