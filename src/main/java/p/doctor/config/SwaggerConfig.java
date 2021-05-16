package p.doctor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
//@ComponentScan(basePackages = {"p.doctor.controller"}) //这个和下面那个basePackage二选一即可
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        /*
         * 所有注解：.apis(RequestHandlerSelectors.any())
         * 指定部分注解： .apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
         * 指定包路径：  .apis(RequestHandlerSelectors.basePackage("这里填写需要的路径"))
         *               .paths()是包路径下的路径.可使用参数PathSelectors.any()表示包下所有路径
         * */
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("p.doctor.controller"))
                //.paths(AppUtility.isProd() ? PathSelectors.none() : PathSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    /*apiInfo()增加API的相关信息。
     *   .contact()是增加作者信息
     * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试swagger")
                .description("展示swagger界面")
//                .termsOfServiceUrl("http://localhost:9633/ep5_SSH_war_exploded/swagger-ui.html")
//                .contact(new Contact("开发人员", " http://localhost:9633/ep5_SSH_war_exploded/swagger-ui.html", "111@qq.com"))
                //是用来显示Swagger页面的帮助信息。就是首页的中间导航。
                .termsOfServiceUrl("http://localhost:4000/swagger-ui.html")
                .contact(new Contact("kriw", " http://localhost:4000/swagger-ui.html", "824230105@qq.com"))
                .version("1.0")
                .build();
    }
}