package com.springapp.mvc.model.repository;

import com.springapp.mvc.model.business.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OleksandrSerediuk on 07.06.2017.
 */
public interface CarManufacturerRepository extends JpaRepository<CarManufacturer, Integer> {
}
