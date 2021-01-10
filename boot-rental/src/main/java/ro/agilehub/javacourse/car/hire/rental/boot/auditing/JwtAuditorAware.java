package ro.agilehub.javacourse.car.hire.rental.boot.auditing;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class JwtAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.
				getContext().getAuthentication())
				.map(Authentication::getPrincipal)
				.map(Jwt.class::cast)
				.map(Jwt::getClaims)
				.flatMap(claims -> Optional.ofNullable(claims.get("user_name")))
				.map(Object::toString);
	}

}
