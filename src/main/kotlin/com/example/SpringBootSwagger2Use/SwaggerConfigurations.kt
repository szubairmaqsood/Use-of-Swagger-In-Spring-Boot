package com.example.SpringBootSwagger2Use


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


//Configuration  as it provides configurations beans of our programmer
@Configuration
@EnableSwagger2
//@EnableWebMvc
class SwaggerConfigurations {
    //Purpose of this method is to return a bean of Docker
    //We define on which package documentation will be done
    @Bean
    fun productApi():Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.SpringBootSwagger2Use.controllers"))
                .paths(regex("/Product.*"))
                .build()

    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Spring Boot2.X Kotlin Use in Swagger2 structure RESTFul APIs")
                .description("In this application a basic Swagger 2 Api is made")
                .termsOfServiceUrl("Do not copy it")
                .contact(Contact("Muhammad Zubair", "followz.com", "szubair1833@gmail.com"))
                .version("1.0.0")
                .build()
    }





}