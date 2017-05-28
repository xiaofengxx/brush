package site.zido.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import site.zido.business.BusMessage;
import site.zido.business.web.IndexController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/26 0026
 */
@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class IndexControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndex() throws Exception {
        BusMessage message = new BusMessage();
        message.setName("wang");
        message.setPassword("123456");
        String jsonString = JSON.toJSONString(message);
        mvc.perform(post("/api/index")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(status().isOk());
    }
}
