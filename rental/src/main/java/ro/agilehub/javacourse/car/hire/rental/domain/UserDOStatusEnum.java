package ro.agilehub.javacourse.car.hire.rental.domain;

public enum UserDOStatusEnum {

	ACTIVE("ACTIVE"),

	DELETED("DELETED");

	private String value;

	UserDOStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static UserDOStatusEnum fromValue(String value) {
		for (UserDOStatusEnum b : UserDOStatusEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
}
