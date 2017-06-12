package site.zido.core.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.baomidou.mybatisplus.activerecord.Model;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import site.zido.brush.utils.CipherUtils;
import site.zido.brush.utils.StringUtils;
import site.zido.dto.AjaxResult;

import java.io.IOException;
import java.lang.reflect.Type;

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
    @Profile("prod")
    public HttpMessageConverters getCipherConverter() {
        FastJsonHttpMessageConverter4 fastConverter = new CipherConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
    }

    @Profile("dev")
    @Bean
    public HttpMessageConverters getConverter() {
        FastJsonHttpMessageConverter4 fastConverter = new FastJsonHttpMessageConverter4();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //将属性为id的long类型
        ValueFilter filter = (object, name, value) -> ((value instanceof Long) && value.toString().length() > 15) ? value.toString(): value;
        fastJsonConfig.setSerializeFilters(filter);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter<?>) fastConverter);
    }

    /**
     * 传输加密解密转换器
     *
     * @author zido
     * @since 2017/5/26 0026
     */
    private class CipherConverter extends FastJsonHttpMessageConverter4 {
        @Override
        public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
            String s = StringUtils.toString(inputMessage.getBody());
            String jsonString = CipherUtils.AESDecode(s, "123456");
            return JSON.parseObject(jsonString, type);
        }
    }
}
