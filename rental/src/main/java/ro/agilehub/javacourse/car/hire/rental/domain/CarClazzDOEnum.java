package ro.agilehub.javacourse.car.hire.rental.domain;

public enum CarClazzDOEnum {

	COMPACT_CAR("Compact Car"),

	SPORT_UTILITY_VEHICLE("Sport Utility vehicle"),

	SEDAN("Sedan"),

	SPORTS_CAR("Sports car"),

	TRUCK("Truck"),

	LUXURY_VEHICLE("Luxury vehicle"),

	VAN("Van"),

	MINIVAN("Minivan"),

	FULL_SIZE_CARE("Full-size care"),

	MIND_SIZE_CAR("Mind-size car"),

	CONVERTIBLE("Convertible"),

	HYBRID_VEHICLE("Hybrid vehicle"),

	HATCHBACK("Hatchback"),

	CROSSOVER("Crossover"),

	COUPE("Coupe");

	private String value;

	CarClazzDOEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public static CarClazzDOEnum fromValue(String value) {
		for (CarClazzDOEnum b : CarClazzDOEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
}
