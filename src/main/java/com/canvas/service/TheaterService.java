package com.canvas.service;

import com.canvas.dto.TheaterResponse;

public interface TheaterService {
    public TheaterResponse getTheaters(String cityId);
    public TheaterResponse getTheaters(String cityId, String movieId, String showDate);
}
