package com.mary.naWarstatWeb.controler;

import com.mary.naWarstatWeb.dto.CarDTO;
import com.mary.naWarstatWeb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
            return "saveNewCar";
        }
    }

    @GetMapping("cars-for-repair")
    public String showCarsForRepair(Model model){
        model.addAttribute("carDTO", carService.showCarsForRepair());
        return "carForRepair";
    }

}
