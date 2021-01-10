package ro.agilehub.javacourse.car.hire.rental.boot.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import ro.agilehub.javacourse.car.hire.rental.boot.auditing.JwtAuditorAware;
import ro.agilehub.javacourse.car.hire.rental.convertor.RentalStatusConverter;

@Configuration
@EnableMongoAuditing
public class MongoConfiguration {

	@Bean
	public MongoCustomConversions customConversions() {
		return new MongoCustomConversions(List.of(RentalStatusConverter.INSTANCE));
	}

	@Bean
	public AuditorAware<String> mongoAuditingAware() {
		return new JwtAuditorAware();
	}

}
