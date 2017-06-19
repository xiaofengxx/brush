package site.zido;

import org.junit.Assert;
import org.junit.Test;
import site.zido.core.LangConstants;

/**
 * 语言测试
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/2 0002
 */
public class LangTest {
    @Test
    public void testGetMessage(){
        String lang = LangConstants.USER_NICKNAME_CAN_NOT_BE_EMPTY;
        System.out.println(lang);
        Assert.assertTrue("语言测试失败","用户昵称不能为空！".equals(lang));
    }

    @Test
    public void testGetMessage1(){
        String lang;
        lang = LangConstants.USER_REALNAME_CAN_NOT_BE_EMPTY;
        System.out.println(lang);
        Assert.assertTrue("语言测试失败","刷手真实姓名不能为空".equals(lang));
    }
}
