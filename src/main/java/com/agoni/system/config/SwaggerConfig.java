package com.agoni.system.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * Swagger配置
 * @author gyd
 */
@Configuration
@EnableOpenApi
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .securityContexts(securityContexts())
                .securitySchemes(apiKeys())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.agoni.dgy"))
                .paths(PathSelectors.any())
                .build();
    }


    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(SecurityContext.builder().securityReferences(defaultAuth()).build());
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    }

    private List<SecurityScheme> apiKeys() {
        return Collections.singletonList(new ApiKey("Authorization", "Authorization", "header"));
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学籍管理系统")
                .description("学籍管理系统-接口文档")
                .contact(new Contact("学籍管理系统", "https://www.dgy.com/", "407479757@qq.com"))
                .version("1.1.0")
                .build();
    }
}