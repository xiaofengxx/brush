package site.zido.subscriber;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zido.core.common.base.BaseController;
import site.zido.dto.AjaxResult;

/**
 * Created by CDDC on 2017/6/26.
 */

@RestController
@RequestMapping(value = "/subscriber")
public class FileUploadAndDown extends BaseController {

    @PostMapping(value = "/upload")
    @ApiOperation(value = "刷客上传微信收款二维码")
    public AjaxResult uploadWechatPicture(){

        return null;
    }
}
