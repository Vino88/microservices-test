package com.microservice.vino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.microservice.vino.service.ProdukService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class JavaMicroservicesProdukApplication implements CommandLineRunner {

	@Autowired
	private ProdukService produkService;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaMicroservicesProdukApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produkService.saveInitProduct();
	}
}
