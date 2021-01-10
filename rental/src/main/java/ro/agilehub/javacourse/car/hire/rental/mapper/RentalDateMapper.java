package ro.agilehub.javacourse.car.hire.rental.mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalDateMapper {

	default LocalDateTime toLocalDateTime(OffsetDateTime date) {
		if (date == null)
			return null;
		return date.toLocalDateTime();
	}

	default OffsetDateTime toOffsetDateTime(LocalDateTime date) {
		if (date == null)
			return null;
		return date.atZone(ZoneId.systemDefault()).toOffsetDateTime();
	}
}
