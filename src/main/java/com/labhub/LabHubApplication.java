package com.labhub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.labhub.fileservice.FileStorageProperties;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties({ FileStorageProperties.class })
public class LabHubApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LabHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Refreshed");
		
	}

}
