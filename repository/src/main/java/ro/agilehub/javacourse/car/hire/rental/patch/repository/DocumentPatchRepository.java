package ro.agilehub.javacourse.car.hire.rental.patch.repository;

import java.util.Map;

public interface DocumentPatchRepository<T, ID> {

	boolean updateDoc(Class<T> docClass, ID idValue, Map<String, Object> fieldValues);
}
