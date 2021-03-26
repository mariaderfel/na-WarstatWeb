package com.mary.naWarstatWeb.function;

import com.mary.naWarstatWeb.dto.CarDTO;
import com.mary.naWarstatWeb.entity.Car;

import java.util.function.Function;

public class CarFunction {
    public static final Function<Car, CarDTO> carToCarDTO = car -> new CarDTO(
            car.getId(),
            car.getRegistrationNumber(),
            car.getName(),
            car.getColor(),
            car.getProductionYear(),
            car.getFixOrderDate(),
            car.isFixed(),
            car.getFixedDate()
    );

    public static final Function<CarDTO, Car> carDTOToCar = carDTO -> new Car(
            carDTO.getRegistrationNumber(),
            carDTO.getName(),
            carDTO.getColor(),
            carDTO.getProductionYear(),
            carDTO.getFixOrderDate(),
            carDTO.isFixed(),
            carDTO.getFixedDate()
    );
}
