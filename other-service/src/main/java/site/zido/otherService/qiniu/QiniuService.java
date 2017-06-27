package site.zido.otherService.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Service;
import site.zido.brush.utils.FileUtils;
import site.zido.otherService.qiniu.DTO.UploadDTO;

/**
 * 七牛云凭证构造器
 *
 * @author zido
 * @since 2017/6/27 0027
 */
@Service
public class QiniuService {
    /**
     * 创建上传凭证
     * @param filename 上传文件名
     * @return 上传凭证token
     */
    public UploadDTO createUpload(String filename){
        Auth auth = Auth.create(QiniuProperties.ACCESS_KEY, QiniuProperties.SECRET_KEY);
        StringMap putPolicy = new StringMap();

        //构造返回信息，给前端进行处理
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");

        //限定为新增语意。
        //如果设置为非 0 值，则无论 scope 设置为什么形式，仅能以新增模式上传文件。
        putPolicy.put("insertOnly",1);
        //最大上传大小为4mb
        putPolicy.put("fsizeLimit",4194304);
        long expireSeconds = 360000;
        String key = FileUtils.confuseFileName(filename);
        return new UploadDTO().setKey(key).setToken(auth.uploadToken(QiniuProperties.BUCKET, key,expireSeconds,putPolicy));
    }


}
