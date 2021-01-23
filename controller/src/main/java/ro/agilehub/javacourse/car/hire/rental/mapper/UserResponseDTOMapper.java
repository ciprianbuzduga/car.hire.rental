package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.rental.api.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.UserDO;

@Mapper(componentModel = "spring")
public interface UserResponseDTOMapper {

	UserResponseDTO mapToUserResponseDTO(UserDO user);
}
