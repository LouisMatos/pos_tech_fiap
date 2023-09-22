package br.com.postechfiap.jlapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = { "br.com.postechfiap.jlapp" })
public class JlappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JlappApplication.class, args);
	}

}
