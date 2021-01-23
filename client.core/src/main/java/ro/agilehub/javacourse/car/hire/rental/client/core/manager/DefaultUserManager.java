package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.UserDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.manager.UserManager;

@Component
@RequiredArgsConstructor
public class DefaultUserManager implements UserManager {

	private final UserApi userApi;
	private final UserDOMapper userMapper;

	@Override
	public Optional<UserDO> getUserById(String userId) {
		ResponseEntity<UserResponseDTO> userResponse = userApi.getUser(userId);
		if(userResponse.hasBody())
			return Optional.of(userMapper.mapToUserDO(userResponse.getBody()));
		return Optional.empty();
	}

}
