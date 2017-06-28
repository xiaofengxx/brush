package site.zido.center.config;

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
@Configuration("center")
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("公司接口")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("site.zido.center"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("center api")
                .description("公司用后台api接口")
                .termsOfServiceUrl("http://zido.site")
                .contact(new Contact("zido", "http://zido.site", "wuhongxu@1208@gmail.com"))
                .version("0.0.1")
                .build();
    }
}
