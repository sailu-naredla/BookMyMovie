package com.canvas.repository;

import com.canvas.model.CityEntity;
import com.canvas.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>  {
    @Query("SELECT c FROM CustomerEntity c WHERE c.email = :email")
    CustomerEntity findByEmail(@Param("email") String email);
}
