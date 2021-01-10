package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ro.agilehub.javacourse.car.hire.rental.api.model.RentalRequestDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.RentalResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.document.RentalDoc;

@Mapper(uses = RentalDateMapper.class, componentModel = "spring")
public interface RentalMapper {

	@Mapping(target = "status",
			expression = "java(ro.agilehub.javacourse.car.hire.rental.document.RentalStatusEnum.ACTIVE)")
	RentalDoc mapToRentalDoc(RentalRequestDTO rentalDTO);

	@Mapping(target = "id", source = "_id")
	RentalResponseDTO mapToRentalResponseDTO(RentalDoc rentalDoc);
}
