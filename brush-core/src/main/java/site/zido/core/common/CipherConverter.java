package site.zido.core.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import site.zido.brush.utils.CipherUtils;
import site.zido.brush.utils.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 传输加密解密转换器
 *
 * @author zido
 * @since 2017/5/26 0026
 */
public class CipherConverter extends FastJsonHttpMessageConverter4 {

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String s = StringUtils.toString(inputMessage.getBody());
        String jsonString = CipherUtils.AESDecode(s, "123456");
//        InputStream in = StringUtils.toInputStream(s);
        return JSON.parseObject(jsonString,type);
//        return JSON.parseObject(in, getFastJsonConfig().getCharset(), clazz, getFastJsonConfig().getFeatures());
    }
}
