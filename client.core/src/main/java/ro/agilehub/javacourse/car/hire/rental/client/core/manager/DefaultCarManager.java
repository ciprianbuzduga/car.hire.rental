package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.CarDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.manager.CarManager;

@Component
@RequiredArgsConstructor
public class DefaultCarManager implements CarManager {

	private final CarApi carApi;
	private final CarDOMapper carMapper;

	@Override
	public Optional<CarDO> getCarById(String id) {
		ResponseEntity<CarResponseDTO> carResponse = carApi.getCar(id);
		if(carResponse.hasBody())
			return Optional.of(carMapper.mapToCarDO(carResponse.getBody()));
		return Optional.empty();
	}

}
