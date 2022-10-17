package com.canvas.service.impl;

import com.canvas.dto.Theater;
import com.canvas.dto.TheaterResponse;
import com.canvas.exception.DataNotFoundException;
import com.canvas.model.MovieEntity;
import com.canvas.model.ScreeningEntity;
import com.canvas.model.TheaterEntity;
import com.canvas.repository.MovieRepository;
import com.canvas.repository.ScreeningRepository;
import com.canvas.repository.TheaterRepository;
import com.canvas.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public TheaterResponse getTheaters(String cityId) {
        TheaterResponse theaterResponse = new TheaterResponse();
        List<TheaterEntity> theaterEntityList =  theaterRepository.findByCity(cityId);
        if(null != theaterEntityList && !theaterEntityList.isEmpty()){
            List<Theater> theaters = theaterEntityList.stream()
                    .map(db -> {
                        Theater theater = new Theater(db.getId(),db.getName());
                        return theater;
                    }).collect(Collectors.toList());
            theaterResponse.setTheaters(theaters);
        }else{
            throw new DataNotFoundException("No Records Found");
        }
        return theaterResponse;
    }

    @Override
    public TheaterResponse getTheaters(String cityId, String movieId, String showDate) {
        TheaterResponse theaterResponse = new TheaterResponse();
        Optional<MovieEntity> movieEntity = movieRepository.findById(Integer.parseInt(movieId));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(showDate, formatter);
        List<TheaterEntity> theaterEntityList =  theaterRepository.findByCity(cityId);
        List<ScreeningEntity> screeningEntities = screeningRepository.findTheaters(movieEntity.get(),localDate);
        if(null != screeningEntities && !screeningEntities.isEmpty()){
            List<Theater> theaters = screeningEntities.stream()
                    .map(db -> {
                        Theater theater = new Theater(db.getTheater().getId(),db.getTheater().getName());
                        return theater;
                    }).collect(Collectors.toList());
            theaterResponse.setTheaters(theaters);
        }else{
            throw new DataNotFoundException("No Records Found");
        }
        return theaterResponse;
    }
}
