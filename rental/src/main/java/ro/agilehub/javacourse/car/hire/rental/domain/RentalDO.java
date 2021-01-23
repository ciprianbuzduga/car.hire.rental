package ro.agilehub.javacourse.car.hire.rental.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class RentalDO {

	private String id;

	private String userId;

	private UserDO user;

	private String carId;

	private CarDO car;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private RentalDOStatusEnum status;
}
