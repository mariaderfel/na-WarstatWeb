package com.mary.naWarstatWeb.controler;

import com.mary.naWarstatWeb.dto.CarDTO;
import com.mary.naWarstatWeb.entity.Car;
import com.mary.naWarstatWeb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import static com.mary.naWarstatWeb.function.CarFunction.carToCarDTO;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("create-new-car")
    public String addNewCar(Model model) {
        model.addAttribute("newCar", new CarDTO());
        return "createNewCar";
    }

    @PostMapping("save-new-car")
    public String addNewCar(@Valid @ModelAttribute("newCar") CarDTO newCar, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "createNewCar";
        }
        else{
            carService.saveCar(newCar);
            model.addAttribute("carDTO", carService.showCarsForRepair());
            return "carForRepair";
        }
    }

    @GetMapping("/")
    public String showCarsForRepair(Model model){
        model.addAttribute("carDTO", carService.showCarsForRepair());
        return "carForRepair";
    }

    @GetMapping("fix")
    public String fix(Long id, Model model){
        carService.fixCar(id);
        model.addAttribute("carDTO", carService.showCarsForRepair());
        return "carForRepair";
    }

    @GetMapping("repaired-cars")
    public String showRepairedCars(Model model){
        model.addAttribute("carDTO", carService.showRepairedCars());
        return "repairedCars";
    }

    @GetMapping("get-registration-number")
    public String getRegistrationNumber(){
        return "findCarForRepair";
    }

    @GetMapping("find-car")
    public String findCar(String registrationNumber, Model model){
        Optional<Car> car = carService.findCar(registrationNumber);
        if(car.isEmpty()){
            return "carNotExist";
        }
        else if(car.get().isFixed()){
            return "carIsAlreadyFixed";
        }
        model.addAttribute("carDTO",carToCarDTO.apply(car.get()));
        return "carForRepair";
    }
}
