package com.canvas.service.impl;

import com.canvas.dto.City;
import com.canvas.dto.CityResponse;
import com.canvas.exception.DataNotFoundException;
import com.canvas.model.CityEntity;
import com.canvas.repository.CityRepository;
import com.canvas.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    @Override
    public CityResponse getAllCities() {
        CityResponse cityResponse = new CityResponse();
        List<CityEntity> cityEntities = cityRepository.findAll();
        if(null != cityEntities && !cityEntities.isEmpty()){
            List<City> cities = cityEntities.stream()
                    .map(db -> {
                        City city = new City(db.getId(),db.getName(),db.getCountry(),db.getZip());
                        return city;
                    }).collect(Collectors.toList());
            cityResponse.setCities(cities);
        }else{
            throw new DataNotFoundException("No Records Found");
        }
        return cityResponse;
    }
}
