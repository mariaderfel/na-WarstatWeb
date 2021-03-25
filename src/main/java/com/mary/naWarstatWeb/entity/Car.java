package com.mary.naWarstatWeb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String registrationNumber;
    private String name;
    private String color;
    private int productionYear;
    private LocalDate fixOrderDate;
    private boolean isFixed;
    private LocalDate fixedDate;

    public Car() {
    }

    public Car(Long id, String registrationNumber, String name, String color, int productionYear, LocalDate fixOrderDate, boolean isFixed, LocalDate fixedDate) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.color = color;
        this.productionYear = productionYear;
        this.fixOrderDate = fixOrderDate;
        this.isFixed = isFixed;
        this.fixedDate = fixedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
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
