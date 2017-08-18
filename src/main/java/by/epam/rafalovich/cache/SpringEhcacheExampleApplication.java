package by.epam.rafalovich.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.techprimers.cache")
public class SpringEhcacheExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEhcacheExampleApplication.class, args);
	}
}
