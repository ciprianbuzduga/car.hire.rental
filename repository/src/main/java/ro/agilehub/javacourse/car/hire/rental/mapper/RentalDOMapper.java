package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ro.agilehub.javacourse.car.hire.rental.document.RentalDoc;
import ro.agilehub.javacourse.car.hire.rental.domain.RentalDO;

@Mapper(componentModel = "spring")
public interface RentalDOMapper {

	@Mapping(target = "id", source = "_id")
	/*@Mapping(target = "status",
			expression = "java(ro.agilehub.javacourse.car.hire.rental.domain.RentalDOStatusEnum.ACTIVE)")*/
	RentalDO mapToRentalDO(RentalDoc rentalDoc);

	RentalDoc mapToRentalDoc(RentalDO rental);
}
