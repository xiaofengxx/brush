package site.zido.core.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import site.zido.brush.utils.CipherUtils;
import site.zido.brush.utils.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 传输加密解密转换器
 *
 * @author zido
 * @since 2017/5/26 0026
 */
public class CipherConverter extends FastJsonHttpMessageConverter4 {
    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String s = StringUtils.toString(inputMessage.getBody());
        CipherUtils.AESDecode(s, "123456");
        InputStream in = StringUtils.toInputStream(s);
        return JSON.parseObject(in, getFastJsonConfig().getCharset(), clazz, getFastJsonConfig().getFeatures());
    }
}
