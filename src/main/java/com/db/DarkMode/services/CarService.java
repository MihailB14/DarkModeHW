package com.db.DarkMode.services;

import com.db.DarkMode.dto.CarDTO;
import com.db.DarkMode.models.Car;
import com.db.DarkMode.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDTO> result = new ArrayList<>();
        for (var c : cars) {
            result.add(new CarDTO(c.getName(), c.getModel()));
        }

        return result;
    }


}


