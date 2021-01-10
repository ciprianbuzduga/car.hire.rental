package ro.agilehub.javacourse.car.hire.rental.service.definition;

import java.util.List;

import ro.agilehub.javacourse.car.hire.rental.api.model.PageRentals;
import ro.agilehub.javacourse.car.hire.rental.api.model.PatchDocument;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalRequestDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponseDTO;

public interface RentalService {

	boolean deleteRental(String id);

	String createRental(RentalRequestDTO rentalDTO);

	RentalResponseDTO getRental(String id);

	PageRentals findAll(Integer page, Integer size, String sort, String userId,
			String carId, String status);

	boolean updateRental(String id, List<PatchDocument> patchDocuments);

}
