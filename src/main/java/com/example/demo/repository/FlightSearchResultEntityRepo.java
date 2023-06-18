package com.example.demo.repository;

import com.example.demo.model.FlightSearchResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSearchResultEntityRepo extends JpaRepository<FlightSearchResultEntity,Integer> {
}
