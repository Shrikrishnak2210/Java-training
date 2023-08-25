package demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement

public class EurekaClientCourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientCourseServiceApplication.class, args);
	}

}
