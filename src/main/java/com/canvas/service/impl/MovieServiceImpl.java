package com.canvas.service.impl;

import com.canvas.dto.Movie;
import com.canvas.dto.MovieResponse;
import com.canvas.dto.Theater;
import com.canvas.exception.DataNotFoundException;
import com.canvas.model.MovieEntity;
import com.canvas.repository.MovieRepository;
import com.canvas.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public MovieResponse getMovies(String cityId) {
        MovieResponse movieResponse = new MovieResponse();
        List<MovieEntity> movieEntityList = movieRepository.findByCity(cityId);
        if(null != movieEntityList && !movieEntityList.isEmpty()){
            List<Movie> movies = movieEntityList.stream()
                    .map(db -> {
                        Movie movie = new Movie(db.getId(),db.getName());
                        return movie;
                    }).collect(Collectors.toList());
            movieResponse.setMovies(movies);
        }else{
            throw new DataNotFoundException("No Records Found");
        }
        return movieResponse;
    }
}
