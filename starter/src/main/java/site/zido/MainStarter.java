package site.zido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/28 0028
 */
@SpringBootApplication
@EnableSwagger2
public class MainStarter {
    public static void main(String[] args) {

        SpringApplication.run(MainStarter.class);
    }
}
