package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.rental.api.model.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserResponseDTOMapper {

	UserResponseDTO mapToUserResponseDTO(
			ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO user);
}
