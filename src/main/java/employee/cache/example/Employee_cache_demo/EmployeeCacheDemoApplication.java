package employee.cache.example.Employee_cache_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
public class EmployeeCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCacheDemoApplication.class, args);
	}

}
