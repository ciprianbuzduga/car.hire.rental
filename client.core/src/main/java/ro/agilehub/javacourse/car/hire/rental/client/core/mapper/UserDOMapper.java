package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.UserDO;

@Mapper(componentModel = "spring")
public interface UserDOMapper {

	UserDO mapToUserDO(UserResponseDTO userDTO);

}
