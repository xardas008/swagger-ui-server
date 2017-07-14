package com.xardas008.swagger.swaggeruiserver;

import com.xardas008.swagger.swaggeruiserver.filter.CORSFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerUiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerUiServerApplication.class, args);
	}

	private CORSFilter corsFilter;

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

	@Bean
	public FilterRegistrationBean someFilterRegistrationBean() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(getCorsFilter());
		registration.setName("corsFilter");
		registration.setOrder(1);
		return registration;
	}

	@Autowired
	public CORSFilter getCorsFilter() {
		return corsFilter;
	}
}
