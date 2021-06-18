package com.ros.documentHandler;

import com.ros.documentHandler.service.DocumentHandlerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
//@EnableResourceServer
@OpenAPIDefinition(info = @Info(title = "DocumentHandlingServiceAPI", version = "1.0", description = "API for DocumentHandling Service"))
public class DocumentHandlingServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DocumentHandlingServiceApplication.class, args);
	}

	@Autowired
	DocumentHandlerService documentHandlerService;

	@Override
	public void run(String... arg) throws Exception {
		documentHandlerService.init();
	}

}
