package ro.agilehub.javacourse.car.hire.rental.document;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(value = RentalDoc.COLLECTION_NAME)
@Data
@EqualsAndHashCode(of = "_id")
public class RentalDoc {
	public static final String COLLECTION_NAME = "rental";

	@Id
	private String _id;

	private String userId;

	private String carId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private RentalStatusEnum status;

	@CreatedBy
	private String createdBy;

	@LastModifiedBy
	private String lastModifiedBy;

	@CreatedDate
	private Date createdDate;

	@LastModifiedDate
	private Date lastModifiedDate;

}
