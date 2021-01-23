package ro.agilehub.javacourse.car.hire.rental.domain;

public enum CarDOStatusEnum {

	ACTIVE("ACTIVE"),

	DELETED("DELETED");

	private String value;

	CarDOStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static CarDOStatusEnum fromValue(String value) {
		for (CarDOStatusEnum b : CarDOStatusEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
}
