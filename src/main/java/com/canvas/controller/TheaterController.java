package com.canvas.controller;

import com.canvas.dto.TheaterResponse;
import com.canvas.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/api/v1/theater")
@RestController
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping("/{city_id}/{movie_id}/{show_date}")
    public ResponseEntity<Object> get(@PathVariable("city_id") String cityId, @PathVariable("movie_id") String movieId, @PathVariable("show_date") String showDate) {
        TheaterResponse theaterResponse = theaterService.getTheaters(cityId,movieId,showDate);
        ResponseEntity<Object> response =  new ResponseEntity<>(theaterResponse, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{city_id}")
    public ResponseEntity<Object> get(@PathVariable("city_id") String cityId) {
        TheaterResponse theaterResponse = theaterService.getTheaters(cityId);
        ResponseEntity<Object> response =  new ResponseEntity<>(theaterResponse, HttpStatus.OK);
        return response;
    }
}
