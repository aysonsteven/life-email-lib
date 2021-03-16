package com.mailer.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(getApiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.mailer.app.controller"))
					.paths(PathSelectors.any())
					.build();
	}
	
    private ApiInfo getApiInfo() {
    	Contact contact = new Contact("Mark Steven Nonato","", "MarkStevenA.Nonato@pccw.com");
    	return new ApiInfoBuilder()
    			.title("Simple Email Service") 
    			.description("Send Email, currently using free SMTP service")
    			.version("0.0.1-SNAPSHOT")
    			.license("Apache 2.0")
    			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
    			.contact(contact)
    			.build();
    }
}
