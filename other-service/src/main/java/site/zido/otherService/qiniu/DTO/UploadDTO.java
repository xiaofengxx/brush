package site.zido.otherService.qiniu.DTO;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/27 0027
 */
public class UploadDTO {
    private String key;
    private String token;

    public String getKey() {
        return key;
    }

    public UploadDTO setKey(String key) {
        this.key = key;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UploadDTO setToken(String token) {
        this.token = token;
        return this;
    }
}
