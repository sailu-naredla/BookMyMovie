package com.canvas.repository;

import com.canvas.model.MovieEntity;
import com.canvas.model.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Long> {
    @Query("SELECT c FROM ScreeningEntity c WHERE c.movie = :movie and c.date = :date")
    List<ScreeningEntity> findTheaters(@Param("movie") MovieEntity movie, @Param("date") LocalDate date);
}
