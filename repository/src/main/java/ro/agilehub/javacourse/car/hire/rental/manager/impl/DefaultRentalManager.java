package ro.agilehub.javacourse.car.hire.rental.manager.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.document.RentalDoc;
import ro.agilehub.javacourse.car.hire.rental.document.RentalStatusEnum;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.mapper.RentalDOMapper;
import ro.agilehub.javacourse.car.hire.rental.repository.RentalRepository;

@Component
@RequiredArgsConstructor
public class DefaultRentalManager implements RentalManager {

	private final RentalRepository repository;
	private final RentalDOMapper rentalMapper;

	@Override
	public Optional<RentalDO> findById(String id) {
		Optional<RentalDoc> optRentalDoc = repository.findById(id);
		if(optRentalDoc.isEmpty())
			return Optional.empty();
		return Optional.of(rentalMapper.mapToRentalDO(optRentalDoc.get()));
	}

	@Override
	public void delete(RentalDO rental) {
		repository.deleteById(rental.getId());
	}

	@Override
	public String save(RentalDO rental) {
		RentalDoc rentalDoc = rentalMapper.mapToRentalDoc(rental);
		repository.save(rentalDoc);
		return rentalDoc.get_id();
	}

	@Override
	public int countRentals(String userId, String carId, String status) {
		RentalStatusEnum rentStatus = RentalStatusEnum.fromValue(status);
		return repository.countByUserIdAndCarIdAndStatus(userId, carId, rentStatus);
	}

	@Override
	public List<RentalDO> listRentalDO(Integer page, Integer size, String userId,
			String carId, String status) {
		Pageable pageable = PageRequest.of(page, size);
		Page<RentalDoc> pageRentDocs = repository
				.findAllByUserIdAndCarIdAndStatus(userId, carId, status, pageable);
		if(pageRentDocs.hasContent())
			return pageRentDocs.getContent().stream()
					.map(rentalMapper::mapToRentalDO)
					.collect(Collectors.toList());
		return Collections.emptyList();
	}

}
