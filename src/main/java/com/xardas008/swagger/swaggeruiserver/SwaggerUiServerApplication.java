package com.xardas008.swagger.swaggeruiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerUiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerUiServerApplication.class, args);
	}

	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration(
				"validatorUrl",// url
				"full",       // docExpansion          => none | list
				"alpha",      // apiSorter             => alpha
				"model",     // defaultModelRendering => schema
				UiConfiguration.Constants.NO_SUBMIT_METHODS,
				false,        // enableJsonEditor      => true | false
				true,         // showRequestHeaders    => true | false
				60000L);      // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
	}
}
