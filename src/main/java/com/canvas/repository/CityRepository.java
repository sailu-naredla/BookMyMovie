package com.canvas.repository;

import com.canvas.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    @Query("SELECT c FROM CityEntity c WHERE c.zip = :zip")
    CityEntity findByCityZip(@Param("zip") String zip);
}
