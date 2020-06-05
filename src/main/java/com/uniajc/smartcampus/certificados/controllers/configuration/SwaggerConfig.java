package com.uniajc.smartcampus.certificados.controllers.configuration;

import com.uniajc.smartcampus.certificados.controllers.CertificadosApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CertificadosApplication.class.getPackage().getName() + ".controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata())
                .tags(new Tag("Type Certicate Rest API", "Defines endpoints that do CRUD operations about Certicates types. It's secured by default (Not implemented yet)."));
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Certificados ")
                .description("funcionalidades de certificado")
                .version("1.0-SNAPSHOT")
                .termsOfServiceUrl("http://smartcampus.uniajc.edu.co/").license("Smart Campus License")
                .contact(new Contact("Smart Campus", "http://smartcampus.uniajc.edu.co/", "pruebasmartcampus@gmail.com"))
                .build();
    }

}
