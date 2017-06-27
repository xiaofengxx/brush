package site.zido.otherService.qiniu;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.brush.utils.ValiDateUtils;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

import javax.annotation.Resource;

/**
 * 七牛云相关控制器
 *
 * @author zido
 * @since 2017/6/27 0027
 */
@RestController
@Api("七牛云控制器")
@RequestMapping("/api/user/qiniu")
public class QiniuController extends BaseController {
    @Resource
    private QiniuService qiniuService;
    @PostMapping("/getUploadToken")
    public AjaxResult getUploadToken(String filename){
        if(!ValiDateUtils.isPicture(filename))
            return fail("图片格式不正确，请确保为\".jpg\"、\".png\"格式的图片");
        return successData(qiniuService.createUpload(filename));
    }
}
