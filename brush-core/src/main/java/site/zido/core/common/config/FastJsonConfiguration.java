package site.zido.core.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import site.zido.core.common.CipherConverter;

/**
 * 配置fastJson代替jackson.
 * <p>配置json转换</p>
 *
 * @author zido
 * @since 2017/5/25 0025
 */
@Configuration
public class FastJsonConfiguration {
    @Bean
    public HttpMessageConverters getCipherConverter(){
        FastJsonHttpMessageConverter4 fastConverter = new CipherConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
    }
}
