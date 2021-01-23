package ro.agilehub.javacourse.car.hire.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;

import ro.agilehub.javacourse.car.hire.rental.boot.security.ServerSecurityConfig;
import ro.agilehub.javacourse.car.hire.rental.client.core.configuration.FeignConfiguration;

@ComponentScan(basePackages = "ro.agilehub.javacourse.car.hire.rental",
	excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
	value = { FeignConfiguration.class, ServerSecurityConfig.class }))
@SpringBootApplication
@Profile("integrationtest")
public class TestRentalConfiguration {

	public static void main(final String[] args) {
		System.out.println(">>>>>>>>>>>>>>> TestRentalConfiguration");
		SpringApplication.run(TestRentalConfiguration.class, args);
	}
}
