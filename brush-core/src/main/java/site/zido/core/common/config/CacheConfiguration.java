package site.zido.core.common.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 缓存配置类
 *
 * @author zido
 * @since 2017/5/28 0028
 */
@Configuration
@Profile("prod")
@EnableCaching
public class CacheConfiguration extends CachingConfigurerSupport {
    /**
     * 缓存管理器
     *
     * @param redisTemplate redis template
     * @return 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    /*@Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }*/

    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }
}
