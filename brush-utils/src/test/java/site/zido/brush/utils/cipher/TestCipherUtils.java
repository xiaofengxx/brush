package site.zido.brush.utils.cipher;

import org.testng.Assert;
import org.testng.annotations.Test;
import site.zido.brush.utils.CipherUtils;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

/**
 * description:
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/26 0026
 */
public class TestCipherUtils {
    @Test
    public void testRSA() throws Exception {
        HashMap<String, Object> map = CipherUtils.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get(CipherUtils.PUBLIC_KEY);
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get(CipherUtils.PRIVATE_KEY);

        //模
        String modulus = publicKey.getModulus().toString();
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        //明文
        String ming = "adawddfbsdgbdfghnghjkmghj,m";
        //使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = CipherUtils.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = CipherUtils.getPrivateKey(modulus, private_exponent);
        //加密后的密文
        String mi = CipherUtils.RSAEncode(ming, pubKey);
        System.out.println("密文：" + mi);
        System.out.println("密文长度：" + mi.length());
        //解密后的明文
        ming = CipherUtils.RSADecode(mi, priKey);
        System.out.println("明文：" + ming);
    }

    @Test
    public void testAES(){
        String start = "123456";
        System.out.println("明文：" + start);

        String s = CipherUtils.AESEncode(start, "123456");

        System.out.println("密文：" + s);

        String result = CipherUtils.AESDecode(s,"123456");

        System.out.println("解密后：" + result);

        Assert.assertTrue(start.equals(result),"加解密错误");

    }
}
