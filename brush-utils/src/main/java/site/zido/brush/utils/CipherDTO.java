package site.zido.brush.utils;

import java.io.Serializable;
import java.security.interfaces.RSAPrivateKey;

/**
 * 密码实体类
 * <p>此类已经过封装，可序列化传输，传输后，可获得rsa公钥，和aes加密密码，前端需通过</p>
 *
 * @author zido
 * @since 2017/5/28 0028
 */
public class CipherDTO implements Serializable {
    private static final long serialVersionUID = 1738399846398814044L;
    /**
     * rsa 公钥指数
     */
    private String publicKeyExponent;
    /**
     * rsa 模
     */
    private String modulus;
    /**
     * 私钥，禁止序列化
     */
    private transient RSAPrivateKey privateKey;
}
