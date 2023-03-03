//package com.desafio.chavepix.configuration;
//
//import org.apache.catalina.security.SecurityConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2WebMvc
//@EnableSwagger2WebFlux
//public class SwaggerConfig {
//
//    // Outras versões utilizadas:
//    // 	implementation "io.springfox:springfox-swagger2:2.7.0"
//    //	implementation "io.springfox:springfox-swagger-ui:2.7.0"
//    // 2.9.2 também
//
//    @Bean
//    public Docket docket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.desafio.chavepix"))
//                .paths(regex("/accounts"))
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Vendas API")
//                .description("Api do projeto de vendas")
//                .version("1.0")
//                .contact(contact())
//                .build();
//    }
//
//    private Contact contact() {
//        return new Contact("Marcus",
//                "http://github.com/marcusmarchiori",
//                "marcus@gmail.com");
//    }
//
//}
