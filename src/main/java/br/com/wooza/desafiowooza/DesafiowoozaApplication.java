package br.com.wooza.desafiowooza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class DesafiowoozaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiowoozaApplication.class, args);
	}

}
