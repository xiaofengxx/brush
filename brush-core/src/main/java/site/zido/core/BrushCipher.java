package site.zido.core;

import site.zido.brush.utils.CipherUtils;
import site.zido.core.exception.ServiceException;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * brush 加解密对象
 * <p>
 *
 * </p>
 *
 * @author zido
 * @since 2017/5/26 0026
 */
public class BrushCipher implements Serializable{

    private static final long serialVersionUID = 1738399846398814044L;

    private String publicKeyExponent;
    private String publicKeyModulus;
    /**
     * 私钥，禁止序列化传输
     */
    private transient RSAPrivateKey privateKey;

    public BrushCipher() throws ServiceException {
        Map<String, Object> map;
        try {
            map = CipherUtils.getKeys();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ServiceException("获取加密认证时发生错误");
        }
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get(CipherUtils.PUBLIC_KEY);

        publicKeyModulus = publicKey.getModulus().toString();
        publicKeyExponent = publicKey.getPublicExponent().toString();
        privateKey = (RSAPrivateKey) map.get(CipherUtils.PRIVATE_KEY);
    }

    public String getPublicKeyExponent() {
        return publicKeyExponent;
    }

    public void setPublicKeyExponent(String publicKeyExponent) {
        this.publicKeyExponent = publicKeyExponent;
    }

    public String getPublicKeyModulus() {
        return publicKeyModulus;
    }

    public void setPublicKeyModulus(String publicKeyModulus) {
        this.publicKeyModulus = publicKeyModulus;
    }

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
