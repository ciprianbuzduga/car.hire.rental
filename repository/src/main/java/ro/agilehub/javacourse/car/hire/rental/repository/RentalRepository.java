package ro.agilehub.javacourse.car.hire.rental.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import ro.agilehub.javacourse.car.hire.rental.document.RentalDoc;
import ro.agilehub.javacourse.car.hire.rental.document.RentalStatusEnum;
import ro.agilehub.javacourse.car.hire.rental.patch.repository.DocumentPatchRepository;

public interface RentalRepository extends MongoRepository<RentalDoc, String>,
	DocumentPatchRepository<RentalDoc, String> {

	Page<RentalDoc> findAllByUserIdAndCarIdAndStatus(String userId, String carId,
			String status, Pageable pageable);

	int countByUserIdAndCarIdAndStatus(String userId, String carId,
			RentalStatusEnum rentStatus);

}
