package com.canvas.repository;

import com.canvas.model.MovieEntity;
import com.canvas.model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
    @Query("SELECT c FROM TheaterEntity c WHERE c.locality = :locality")
    TheaterEntity findByLocality(@Param("locality") String locality);

    @Query("SELECT c FROM TheaterEntity c WHERE c.city = :city")
    List<TheaterEntity> findByCity(@Param("city") String city);
}
