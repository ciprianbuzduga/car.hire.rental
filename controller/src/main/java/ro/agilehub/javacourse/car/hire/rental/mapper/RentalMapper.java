package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;

import ro.agilehub.javacourse.car.hire.rental.api.model.RentalRequestDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;

@Mapper(uses = {RentalDateMapper.class, UserResponseDTOMapper.class, CarResponseDTOMapper.class},
	componentModel = "spring")
public interface RentalMapper {

	RentalDO mapToRentalDO(RentalRequestDTO rentalDTO);

	RentalResponseDTO mapToRentalResponseDTO(RentalDO rentalDO);
}
