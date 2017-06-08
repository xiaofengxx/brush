package site.zido.service.user;

import com.baomidou.mybatisplus.service.IService;
import site.zido.entity.BankCard;

import java.util.List;

/**
 * 银行卡service
 *
 * @author zido
 * @since 2017/6/6 0006
 */
public interface BankCardService extends IService<BankCard> {
    List<BankCard> getByUserId(String id);
}
