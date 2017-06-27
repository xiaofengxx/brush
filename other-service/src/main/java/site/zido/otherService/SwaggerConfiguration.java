package site.zido.otherService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/27 0027
 */
@Configuration("otherService")
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("第三方服务接口")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("site.zido.otherService"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("other api")
                .description("第三方服务对接接口")
                .termsOfServiceUrl("http://zido.site")
                .contact(new Contact("zido", "http://zido.site", "wuhongxu@1208@gmail.com"))
                .version("0.0.1")
                .build();
    }
}
