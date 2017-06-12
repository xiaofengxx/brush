package site.zido.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.zido.entity.User;

/**
 * 加密服务
 *
 * @author zido
 * @since 2017/6/12 0012
 */
public class CipherService {
    private Logger logger = LoggerFactory.getLogger(CipherService.class);
    /**
     * user对象加密
     * @param user 用户对象
     */
    public void encodingUser(User user){
        logger.info("用户对象加密");
    }

    public void encodingString(String s){
        logger.info("字符串加密");
    }
}
