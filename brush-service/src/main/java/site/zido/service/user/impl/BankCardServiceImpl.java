package site.zido.service.user.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.zido.entity.BankCard;
import site.zido.mapper.user.BankCardMapper;
import site.zido.service.user.BankCardService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 银行卡service
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/6 0006
 */
@Service
public class BankCardServiceImpl extends ServiceImpl<BankCardMapper,BankCard> implements BankCardService{
    @Resource
    private BankCardMapper bankCardMapper;
    @Override
    public List<BankCard> getByUserId(String id) {
        return bankCardMapper.selectList(new EntityWrapper<BankCard>().where("user_id = {0}", id));
    }
}
