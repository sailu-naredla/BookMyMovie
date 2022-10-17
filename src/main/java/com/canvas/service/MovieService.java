package com.canvas.service;

import com.canvas.dto.MovieResponse;

public interface MovieService {
    public MovieResponse getMovies(String cityId);

}
