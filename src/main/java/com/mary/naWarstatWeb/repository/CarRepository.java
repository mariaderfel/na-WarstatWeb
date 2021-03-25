package com.mary.naWarstatWeb.repository;

import com.mary.naWarstatWeb.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
