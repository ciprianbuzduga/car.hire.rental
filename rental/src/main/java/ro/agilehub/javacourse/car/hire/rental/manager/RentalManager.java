package ro.agilehub.javacourse.car.hire.rental.manager;

import java.util.List;
import java.util.Optional;

import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;

public interface RentalManager {

	Optional<RentalDO> findById(String id);

	void delete(RentalDO rental);

	String save(RentalDO rental);

	int countRentals(String userId, String carId, String status);

	List<RentalDO> listRentalDO(Integer page, Integer size, String userId,
			String carId, String status);
}
