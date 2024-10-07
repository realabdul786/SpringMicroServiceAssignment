
package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient 
public class ApiGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		System.out.println("API gate way UP and running ......");
		System.out.println("Visit http://localhost:/8080 ");
	}

	@Bean
	public RouteLocator myLocator(RouteLocatorBuilder builder) {
		
		return builder.routes().route(ugateway -> ugateway.path("/user/**").and().method("GET","POST").uri("http://localhost:9191"))
				.route(pgateway -> pgateway.path("/product/**").and().method("GET","POST").uri("http://localhost:9292"))
				.route(ogateway->ogateway.path("/order/**").and().method("GET","POST").uri("http://localhost:9393"))
				.build();
		
	}
	
}
