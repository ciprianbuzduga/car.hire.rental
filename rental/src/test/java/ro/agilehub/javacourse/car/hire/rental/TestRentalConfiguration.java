package ro.agilehub.javacourse.car.hire.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ro.agilehub.javacourse.car.hire.rental")
@SpringBootApplication
public class TestRentalConfiguration {

	public static void main(final String[] args) {
		SpringApplication.run(TestRentalConfiguration.class, args);
	}
}
