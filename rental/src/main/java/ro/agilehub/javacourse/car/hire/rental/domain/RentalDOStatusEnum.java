package ro.agilehub.javacourse.car.hire.rental.domain;

public enum RentalDOStatusEnum {

	ACTIVE("ACTIVE"),

	CANCELLED("CANCELLED");

	private String value;

	RentalDOStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static RentalDOStatusEnum fromValue(String value) {
		for (RentalDOStatusEnum b : RentalDOStatusEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
}
