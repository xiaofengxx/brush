package site.zido.mapper.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import site.zido.entity.BankCard;

import java.util.List;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/1 0001
 */
public interface BankCardMapper extends BaseMapper<BankCard> {
    Integer insertBatch(@Param("bankCards") List<BankCard> bankCards);

    void deleteNotRange(@Param("bankCards") List<BankCard> bankCards, @Param("userId") Long userId);
}
