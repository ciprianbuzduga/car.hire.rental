package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;

import ro.agilehub.javacourse.car.hire.rental.client.core.specification.CarApi;

@FeignClient(name = "carApiClient", url = "${car.url:http://localhost:8080}")
public interface CarApiClient extends CarApi {

}
