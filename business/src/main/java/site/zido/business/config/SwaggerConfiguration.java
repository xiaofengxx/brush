package site.zido.business.config;

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
 * 配置swagger api配置
 *
 * @author zido
 * @since 2017/5/24
 */
@Configuration("business")
public class SwaggerConfiguration {
    @Bean("business api")
    public Docket createRestApi3() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("商家接口")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("site.zido.business.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("business api")
                .description("商家用后台api接口")
                .termsOfServiceUrl("http://zido.site")
                .contact(new Contact("zido", "http://zido.site", "wuhongxu@1208@gmail.com"))
                .version("0.0.1")
                .build();
    }
}