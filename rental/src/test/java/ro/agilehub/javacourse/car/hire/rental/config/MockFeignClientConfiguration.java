package ro.agilehub.javacourse.car.hire.rental.config;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;

import ro.agilehub.javacourse.car.hire.rental.client.core.impl.UserApiClient;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarRequestDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.PageCars;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.PageUsers;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.PatchDocument;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserRequestDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;

@Configuration
@Profile("integrationtest")
public class MockFeignClientConfiguration {

	@Bean
	public CarApi carApi() {
		return new CarApi() {

			@Override
			public ResponseEntity<Void> updateCar(String id, @Valid List<PatchDocument> patchDocument) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ResponseEntity<PageCars> getCars(@Min(0) @Valid Integer page, @Min(1) @Valid Integer size,
					@Valid String sort, @Valid String status) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ResponseEntity<CarResponseDTO> getCar(String id) {
				return ResponseEntity.ok(new CarResponseDTO());
			}

			@Override
			public ResponseEntity<Void> deleteCar(String id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ResponseEntity<Void> addCar(@Valid CarRequestDTO carRequestDTO) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	@Bean
	public UserApiClient userApi() {
		return new UserApiClient() {
			
			@Override
			public ResponseEntity<Void> updateUser(String id, @Valid List<PatchDocument> patchDocument) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<PageUsers> getUsers(@Min(0) @Valid Integer page, @Min(1) @Valid Integer size,
					@Valid String sort) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<Void> deleteUser(String id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<Void> createUser(@Valid UserRequestDTO userRequestDTO) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<UserResponseDTO> getUser(String id) {
				return ResponseEntity.ok(new UserResponseDTO());
			}
		};
	}
}
