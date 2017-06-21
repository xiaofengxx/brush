package site.zido.service.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import site.zido.entity.Platforms;
import org.springframework.stereotype.Service;
import site.zido.mapper.user.PlatformsMapper;
import site.zido.service.user.IPlatformsService;

/**
 * <p>
 * 平台表 服务实现类
 * </p>
 *
 * @author zido
 * @since 2017-06-20
 */
@Service
public class PlatformsServiceImpl extends ServiceImpl<PlatformsMapper, Platforms> implements IPlatformsService {
	
}
