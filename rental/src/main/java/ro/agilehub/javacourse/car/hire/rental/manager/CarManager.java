package ro.agilehub.javacourse.car.hire.rental.manager;

import java.util.Optional;

import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;

public interface CarManager {

	Optional<CarDO> getCarById(String id);

}
