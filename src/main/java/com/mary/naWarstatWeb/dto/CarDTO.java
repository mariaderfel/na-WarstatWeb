package com.mary.naWarstatWeb.dto;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CarDTO {

    private Long id;
    @NotBlank(message = "registration number is mandatory")
    private String registrationNumber;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "color is mandatory")
    private String color;
    @NotNull(message = "production year is mandatory")
    @Min(1999)
    @Max(2021)
    private int productionYear;
    private LocalDate fixOrderDate;
    private boolean isFixed;
    private LocalDate fixedDate;

    public CarDTO() {
    }

    public CarDTO(Long id, @NotBlank(message = "registration number is mandatory") String registrationNumber, @NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "color is mandatory") String color, @NotNull(message = "production year is mandatory") @Min(1999) @Max(2021) int productionYear, LocalDate fixOrderDate, boolean isFixed, LocalDate fixedDate) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.color = color;
        this.productionYear = productionYear;
        this.fixOrderDate = fixOrderDate;
        this.isFixed = isFixed;
        this.fixedDate = fixedDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public LocalDate getFixOrderDate() {
        return fixOrderDate;
    }

    public void setFixOrderDate(LocalDate fixOrderDate) {
        this.fixOrderDate = fixOrderDate;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public LocalDate getFixedDate() {
        return fixedDate;
    }

    public void setFixedDate(LocalDate fixedDate) {
        this.fixedDate = fixedDate;
    }
}
