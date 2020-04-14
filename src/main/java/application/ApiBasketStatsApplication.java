package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import application.oauth.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ApiBasketStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBasketStatsApplication.class, args);
	}

}
