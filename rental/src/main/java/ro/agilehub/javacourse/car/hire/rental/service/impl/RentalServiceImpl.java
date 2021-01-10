package ro.agilehub.javacourse.car.hire.rental.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.api.common.PatchMapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.PageRentals;
import ro.agilehub.javacourse.car.hire.rental.api.model.PatchDocument;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalRequestDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.document.RentalDoc;
import ro.agilehub.javacourse.car.hire.rental.mapper.CarResponseDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.mapper.UserResponseDTOMapper;
import ro.agilehub.javacourse.car.hire.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.service.definition.RentalService;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

	private final UserApi userApi;
	private final CarApi carApi;
	private final RentalRepository rentalRepository;
	private final RentalMapper rentalMapper;
	private final UserResponseDTOMapper userResponseMapper;
	private final CarResponseDTOMapper carResponseMapper;

	@Override
	public boolean deleteRental(String id) {
		RentalDoc rental = getRentalDoc(id);
		try {
			rentalRepository.delete(rental);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private RentalDoc getRentalDoc(String id) {
		return rentalRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("No rental found with id " + id));
	}

	@Override
	public String createRental(RentalRequestDTO rentalDTO) {
		RentalDoc rent = rentalMapper.mapToRentalDoc(rentalDTO);
		String carId = rentalDTO.getCarId();
		ResponseEntity<CarResponseDTO> car = carApi.getCar(carId);
		if(car.getStatusCodeValue() != HttpStatus.OK.value())
			throw new NoSuchElementException("No car found with id " + carId);
		rent.setCarId(carId);

		String userId = rentalDTO.getUserId();
		ResponseEntity<UserResponseDTO> user = userApi.getUser(userId);
		if(user.getStatusCodeValue() != HttpStatus.OK.value())
			throw new NoSuchElementException("No user found with id " + userId);
		rent.setUserId(userId);
		try {
			rent = rentalRepository.save(rent);
			return rent.get_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RentalResponseDTO getRental(String id) {
		RentalDoc rentDoc = getRentalDoc(id);
		RentalResponseDTO rentalResponse = rentalMapper.mapToRentalResponseDTO(rentDoc);

		String userId = rentDoc.getUserId();
		ResponseEntity<UserResponseDTO> userResp = userApi.getUser(userId);
		if(userResp.getStatusCodeValue() == HttpStatus.OK.value()) {
			ro.agilehub.javacourse.car.hire.rental.api.model.UserResponseDTO user
				= userResponseMapper.mapToUserResponseDTO(userResp.getBody());
			rentalResponse.setUser(user);
		}

		String carId = rentDoc.getCarId();
		ResponseEntity<CarResponseDTO> carResp = carApi.getCar(carId);
		if(carResp.getStatusCodeValue() == HttpStatus.OK.value()) {
			ro.agilehub.javacourse.car.hire.rental.api.model.CarResponseDTO car
				= carResponseMapper.mapToCarResponseDTO(carResp.getBody());
			rentalResponse.setCar(car);
		}
		return rentalResponse;
	}

	@Override
	public PageRentals findAll(Integer page, Integer size, String sort,
			String userId, String carId, String status) {
		Pageable pageable = PageRequest.of(page, size);
		Page<RentalDoc> pageRentDocs = rentalRepository
				.findAllByUserIdAndCarIdAndStatus(userId, carId, status, pageable);
		PageRentals pageRentals = new PageRentals();
		pageRentals.currentPage(page)
			.pageSize(pageRentDocs.getNumberOfElements())
			.totalNoRecords((int) pageRentDocs.getTotalElements())
			.totalPages(pageRentDocs.getTotalPages());
		if(pageRentDocs.hasContent())
			pageRentDocs.forEach(rent -> pageRentals.addRentalsItem(
							rentalMapper.mapToRentalResponseDTO(rent)));
		return pageRentals;
	}

	@Override
	public boolean updateRental(String id, List<PatchDocument> patchDocuments) {
		PatchMapper patchMapper = PatchMapper.getPatchMapper(patchDocuments, RentalDoc.class);
		return rentalRepository.updateDoc(RentalDoc.class, id, patchMapper.getFieldValues());
	}

}
