package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.rental.api.model.CarResponseDTO;

@Mapper(componentModel = "spring")
public interface CarResponseDTOMapper {

	CarResponseDTO mapToCarResponseDTO(
			ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO car);
}
