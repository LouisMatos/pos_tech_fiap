package br.com.postechfiap.jlapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

@SpringBootApplication(scanBasePackages = { "br.com.postechfiap.jlapp" })
@EnableJpaRepositories(bootstrapMode = BootstrapMode.DEFAULT, basePackages = "br.com.postechfiap.jlapp.infrastructure.adapters.repository")
public class JlappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JlappApplication.class, args);
	}

}
