package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.CarDO;

@Mapper(componentModel = "spring")
public interface CarDOMapper {

	CarDO mapToCarDO(CarResponseDTO carDTO);

}
