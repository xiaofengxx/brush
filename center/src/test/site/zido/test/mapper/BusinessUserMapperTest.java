package site.zido.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.zido.dto.BusinessCondition;
import site.zido.dto.BusinessUserInfoDTO;
import site.zido.mapper.user.BusinessUserMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/6 0006
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessUserMapperTest {
    @Resource
    private BusinessUserMapper businessUserMapper;

    @Test
    public void testSelectList(){
        BusinessCondition con = new BusinessCondition().setDesc(false).setKey("string");
        List<BusinessUserInfoDTO> businessUserInfoDTOS = businessUserMapper.selectBusinessList(con);
        System.out.println(businessUserInfoDTOS);
    }
}
