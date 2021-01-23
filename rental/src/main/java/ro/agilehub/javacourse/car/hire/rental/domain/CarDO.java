package ro.agilehub.javacourse.car.hire.rental.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class CarDO {

	private String id;

	private String makeCar;

	private String model;

	private Integer year;

	private Integer mileage;

	private String fuel;

	private CarClazzDOEnum clazzCode;

	private CarDOStatusEnum status;

	private String registrationNo;
}
