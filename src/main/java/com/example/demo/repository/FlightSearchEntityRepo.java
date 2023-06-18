package com.example.demo.repository;

import com.example.demo.model.FlightSearchEntity2;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightSearchEntityRepo extends JpaRepository<FlightSearchEntity2,Integer> {
}
