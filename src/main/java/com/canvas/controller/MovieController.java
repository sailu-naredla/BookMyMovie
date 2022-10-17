package com.canvas.controller;

import com.canvas.dto.MovieResponse;
import com.canvas.service.MovieService;
import com.canvas.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/v1/movie")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{city_id}")
    public ResponseEntity<Object> get(@PathVariable("city_id") String cityId) {
        MovieResponse movieResponse = movieService.getMovies(cityId);
        ResponseEntity<Object> response =  new ResponseEntity<>(movieResponse, HttpStatus.OK);
        return response;
    }
}
