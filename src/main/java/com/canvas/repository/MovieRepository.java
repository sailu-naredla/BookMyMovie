package com.canvas.repository;

import com.canvas.model.CustomerEntity;
import com.canvas.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    @Query("SELECT c FROM MovieEntity c WHERE c.city = :city")
    List<MovieEntity> findByCity(@Param("city") String city);
}
