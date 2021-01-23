package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.rental.api.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;

@Mapper(componentModel = "spring")
public interface CarResponseDTOMapper {

	CarResponseDTO mapToCarResponseDTO(CarDO car);
}
