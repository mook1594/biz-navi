package com.mook1594.biznavi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.mook1594.biznavi")
@EnableMongoRepositories("com.mook1594.biznavi")
public class BizNaviApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BizNaviApiApplication.class, args);
	}

}
