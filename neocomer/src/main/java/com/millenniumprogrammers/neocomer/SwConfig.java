package com.millenniumprogrammers.neocomer;

import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwConfig {

	
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "NeoComer User", 
	       "Control de Usuarios", 
	       "Versiión 1.0", 
	       "Terminos del servicio", 
	       new Contact("cpinedo428@gmail.com", "https://www.pinterest.com/cesarspinedooli/", "cpinedo428gmail.com"), 
	       "License of API", "API license URL", Collections.emptyList());  
	}
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.millenniumprogrammers.neocomer.restcontroller"))
	      .paths(PathSelectors.any())         
	      .build()
	      .apiInfo(apiInfo());
	}
}
