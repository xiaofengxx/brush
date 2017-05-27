package site.zido.test.base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * mapper测试基类:
 * <p>
 *     使用{@link Transactional 注解，保证数据库操作回滚}
 *     使用时，注意加入{@link org.junit.Test}注解
 * </p>
 *
 * @author zido
 * @since 2017/5/25
 */
//用于dao测试
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional//保证事物回滚
public class BaseTestMapper {
}
