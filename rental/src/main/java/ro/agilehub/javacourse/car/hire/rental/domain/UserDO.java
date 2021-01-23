package ro.agilehub.javacourse.car.hire.rental.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class UserDO {

	private String id;

	private String password;

	private String email;

	private String username;

	private String firstName;

	private String lastName;

	private String country;

	private String driverLicenseNo;

	private UserDOStatusEnum status;

	private String title;
}
