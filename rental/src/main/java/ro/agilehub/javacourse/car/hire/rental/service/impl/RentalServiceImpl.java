package ro.agilehub.javacourse.car.hire.rental.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;
import ro.agilehub.javacourse.car.hire.rental.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.manager.UserManager;
import ro.agilehub.javacourse.car.hire.rental.service.definition.RentalService;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

	private final UserManager userManager;
	private final CarManager carManager;
	private final RentalManager rentalManager;

	@Override
	public boolean deleteRental(String id) {
		RentalDO rental = getRental(id);
		try {
			rentalManager.delete(rental);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public RentalDO getRentalDO(String id) {
		RentalDO rental = getRental(id);
		setUserAndCarDO(rental);
		return rental;
	}

	private void setUserAndCarDO(RentalDO rental) {
		rental.setUser(userManager.getUserById(rental.getUserId()).orElse(null));
		rental.setCar(carManager.getCarById(rental.getCarId()).orElse(null));
	}

	private RentalDO getRental(String id) {
		return rentalManager.findById(id).orElseThrow(
				() -> new NoSuchElementException("No rental found with id " + id));
	}

	@Override
	public String createRental(RentalDO rentalDO) {
		String userId = rentalDO.getUser().getId();
		userManager.getUserById(userId).orElseThrow(
				() -> new NoSuchElementException("No user found with id " + userId));
		String carId = rentalDO.getCar().getId();
		carManager.getCarById(carId).orElseThrow(
				() -> new NoSuchElementException("No car found with id " + carId));
		try {
			return rentalManager.save(rentalDO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countRentals(String userId, String carId, String status) {
		return rentalManager.countRentals(userId, carId, status);
	}

	@Override
	public List<RentalDO> listRentalDO(Integer page, Integer size, String userId,
			String carId, String status) {
		List<RentalDO> listRentalDO = rentalManager.listRentalDO(page, size,
				userId, carId, status);
		listRentalDO.forEach(rent -> setUserAndCarDO(rent));
		return listRentalDO;
	}

}
