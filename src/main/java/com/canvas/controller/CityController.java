package com.canvas.controller;

import com.canvas.dto.CityResponse;
import com.canvas.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/api/v1/city")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCity() {
        CityResponse cityResponse = cityService.getAllCities();
        ResponseEntity<Object> response =  new ResponseEntity<>(cityResponse, HttpStatus.OK);
        return response;
    }
}
