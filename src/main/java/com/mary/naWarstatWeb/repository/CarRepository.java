package com.mary.naWarstatWeb.repository;

import com.mary.naWarstatWeb.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAll();

    List<Car> findByIsFixedIsFalse();
}
