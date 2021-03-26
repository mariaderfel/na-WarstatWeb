package com.mary.naWarstatWeb.service;

import com.mary.naWarstatWeb.dto.CarDTO;
import com.mary.naWarstatWeb.entity.Car;
import com.mary.naWarstatWeb.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.mary.naWarstatWeb.function.CarFunction.carDTOToCar;

@Component
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void saveCar(CarDTO carDTO){
        Car exampleCar = new Car();
        exampleCar.setRegistrationNumber("EL 160CN");
        exampleCar.setName("WV Golf");
        exampleCar.setColor("Black");
        exampleCar.setProductionYear(2008);
        exampleCar.setFixOrderDate(LocalDate.now());
        carRepository.save(exampleCar);

        Car car = carDTOToCar.apply(carDTO);
        carRepository.save(car);

    }

}