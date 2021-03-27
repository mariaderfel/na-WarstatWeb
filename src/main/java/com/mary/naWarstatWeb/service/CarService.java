package com.mary.naWarstatWeb.service;

import com.mary.naWarstatWeb.dto.CarDTO;
import com.mary.naWarstatWeb.entity.Car;
import com.mary.naWarstatWeb.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mary.naWarstatWeb.function.CarFunction.carDTOToCar;
import static com.mary.naWarstatWeb.function.CarFunction.carToCarDTO;

@Component
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void saveCar(CarDTO carDTO){
        Car car = carDTOToCar.apply(carDTO);
        car.setFixOrderDate(LocalDate.now());
        carRepository.save(car);
    }

    public List<CarDTO> showCarsForRepair(){
        List<Car> carForRepair = carRepository.findByIsFixedIsFalseOrderByFixOrderDate();
        return carForRepair.stream()
                .map(car -> carToCarDTO.apply(car))
                .collect(Collectors.toList());
    }

    public List<CarDTO> showRepairedCars(){
        List<Car> repairedCars = carRepository.findByIsFixedIsTrueOrderByFixedDateDesc();
        return  repairedCars.stream()
                .map(car ->carToCarDTO.apply(car))
                .collect(Collectors.toList());
    }

    public void fixCar(Long id){
        carRepository.updateIsFixed(id);
    }
}