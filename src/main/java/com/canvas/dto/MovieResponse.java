package com.canvas.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieResponse {
    private List<Movie> movies;
}
