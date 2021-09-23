package com.pangaea.config;


import com.google.common.base.Strings;


import io.swagger.annotations.ApiModel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.TypeNameProviderPlugin;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.common.SwaggerPluginSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableSwagger2
public class SwaggerConfig {



    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .tags(
                        new Tag("publisher-resource", "pub sub operations")
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pangaea"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Pangaea Assessment",
                "Pangaea Assessment",
                "1.0",
                "",
                new Contact("Babalola Owolabi", "", "babs.owolabi@gmail.com"), "License of API", "API license URL", Collections.emptyList());
    }


    @Component
    @Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
    public static class FullyQualifiedTypeNameProvider implements TypeNameProviderPlugin {

        @Override
        public String nameFor(Class<?> type) {
            return Optional.ofNullable(AnnotationUtils.findAnnotation(type, ApiModel.class))
                    .map(ApiModel::value)
                    .map(Strings::emptyToNull)
                    .orElseGet(type::getName);
        }

        @Override
        public boolean supports(DocumentationType delimiter) {
            return true;
        }

    }
}
