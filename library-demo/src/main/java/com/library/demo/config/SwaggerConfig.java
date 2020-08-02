/**
 * @author Avanesh Sharma
 *
 */

package com.library.demo.config;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/*
	 * The select() method called on Docket bean returns an "ApiSelectorBuilder".
	 * This provides "apis()" and "paths()" methods to filter the controllers and
	 * methods being documented using string predicates.
	 */

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Online Library System")
				.description("Spring Boot REST API for Online Library System")
				.termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").version("2.0")
				.license("Apache License Version 2.0").build();
	}

}
