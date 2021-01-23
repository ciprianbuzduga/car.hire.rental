package ro.agilehub.javacourse.car.hire.rental.service.definition;

import java.util.List;

import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;

public interface RentalService {

	boolean deleteRental(String id);

	String createRental(RentalDO rentalDO);

	RentalDO getRentalDO(String id);

	int countRentals(String userId, String carId, String status);

	List<RentalDO> listRentalDO(Integer page, Integer size, String userId,
			String carId, String status);

	//boolean updateRental(String id, List<PatchDocument> patchDocuments);

}
