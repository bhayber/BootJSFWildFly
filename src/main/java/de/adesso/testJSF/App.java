package de.adesso.testJSF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "de.adesso.testJSF" })
@EntityScan(basePackages = { "de.adesso.testJSF.model" })
@ComponentScan(basePackages = { "de.adesso.testJSF", "de.adesso.testJSF.service" })
public class App {
    public static void main(String[] args) {
	SpringApplication.run(App.class, args);
    }
}
