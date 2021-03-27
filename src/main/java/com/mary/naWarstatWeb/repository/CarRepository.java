package com.mary.naWarstatWeb.repository;

import com.mary.naWarstatWeb.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAll();

    List<Car> findByIsFixedIsFalseOrderByFixOrderDate();

    List<Car> findByIsFixedIsTrueOrderByFixedDateDesc();

    @Modifying
    @Transactional
    @Query("update Car c set c.isFixed=true, c.fixedDate=current_date where c.id =:carId")
    void updateIsFixed(@Param("carId") Long carId);



}
