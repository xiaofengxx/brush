package site.zido.core.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import site.zido.brush.utils.CipherUtils;

import javax.annotation.PostConstruct;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/26 0026
 */
@Configuration
@ConfigurationProperties("brush")
public class InitialConfiguration {
    private Boolean encryption;


    @PostConstruct
    public void initEncryption(){
        if(encryption != null)
            CipherUtils.init(encryption);
    }

    public Boolean getEncryption() {
        return encryption;
    }

    public void setEncryption(Boolean encryption) {
        this.encryption = encryption;
    }
}
