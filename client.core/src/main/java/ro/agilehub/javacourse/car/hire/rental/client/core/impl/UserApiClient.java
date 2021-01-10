package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import java.util.NoSuchElementException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;

@FeignClient(name = "${user.name:user}", url = "${user.url:http://localhost:8080}")
public interface UserApiClient extends UserApi {

	String CORE = "core";

	@Override
	@CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
	@RateLimiter(name = CORE)
	@GetMapping(value = "/user/{id}")
	ResponseEntity<UserResponseDTO> getUser(String id);

	default ResponseEntity<UserDTO> coreFallback(Integer id, CallNotPermittedException exception) {
		throw new NoSuchElementException();
	}

	default ResponseEntity<UserDTO> coreFallback(Integer id, Exception exception) {
		throw new RuntimeException();
	}

}
