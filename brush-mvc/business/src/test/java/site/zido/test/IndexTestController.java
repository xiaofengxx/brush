package site.zido.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.annotations.Test;
import site.zido.brush.utils.CipherUtils;
import site.zido.business.BusMessage;
import site.zido.business.web.IndexController;
import site.zido.test.base.BaseTestController;

import javax.annotation.Resource;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/26 0026
 */
@SpringBootApplication
public class IndexTestController extends BaseTestController {
    @Resource
    private IndexController indexController;
    @Override
    public Object getController() {
        return indexController;
    }

    @Test
    public void testIndex(){
        BusMessage message = new BusMessage();
        message.setName("wang");
        message.setPassword("123456");
        String jsonString = JSON.toJSONString(message);
        String s = CipherUtils.AESEncode(jsonString, "123456");
        try {
            post("/", s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
