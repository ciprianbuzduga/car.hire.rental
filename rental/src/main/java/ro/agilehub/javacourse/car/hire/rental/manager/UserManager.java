package ro.agilehub.javacourse.car.hire.rental.manager;

import java.util.Optional;

import ro.agilehub.javacourse.car.hire.rental.domain.UserDO;

public interface UserManager {

	Optional<UserDO> getUserById(String userId);

}
