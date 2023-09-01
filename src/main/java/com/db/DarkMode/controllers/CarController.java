package com.db.DarkMode.controllers;

import com.db.DarkMode.dto.CarDTO;
import com.db.DarkMode.dto.DarkModeDTO;
import com.db.DarkMode.dto.ResponseDTO;
import com.db.DarkMode.services.CarService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    private boolean DarkModeON = false;
    @Autowired
    CarService carService;

    @GetMapping("/display_cars")
    List<CarDTO> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/cars")
    public ResponseDTO getCars(@CookieValue(value = "darkmode", defaultValue = "false") boolean darkModeCookie){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setDarkModeON(DarkModeON || darkModeCookie);
        List<CarDTO> cars = carService.getAllCars();
        responseDTO.setCars(cars);
        return responseDTO;
    }

    @PutMapping("/dark-mode")
    public DarkModeDTO setDarkMode(@RequestBody DarkModeDTO darkModeDTO_param, HttpServletResponse response){
        DarkModeON = darkModeDTO_param.isDarkMode();
        Cookie cookie = new Cookie("darkmode", String.valueOf(DarkModeON));
        cookie.setMaxAge(86400);
        cookie.setPath("/");
        response.addCookie(cookie);
        DarkModeDTO darkModeDTO = new DarkModeDTO();
        darkModeDTO.setDarkMode(DarkModeON);
        return darkModeDTO;
    }
}
