package site.zido.pub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by FZC on 2017/6/19.
 */
@Configuration("pub")
public class SwaggerConfiguration {
    @Bean("brush api")
    public Docket createRestApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("公共接口")
                .apiInfo(new ApiInfoBuilder().title("pub api")
                        .description("公共接口")
                        .termsOfServiceUrl("http://zido.site")
                        .contact(new Contact("zido", "http://zido.site", "wuhongxu@1208@gmail.com"))
                        .version("0.0.1")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("site.zido.pub"))
                .paths(PathSelectors.any())
                .build();
    }
}
