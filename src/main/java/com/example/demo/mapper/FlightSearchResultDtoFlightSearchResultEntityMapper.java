package com.example.demo.mapper;

import com.example.demo.dto.FlightsSearchResultDto;
import com.example.demo.model.FlightSearchResultEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightSearchResultDtoFlightSearchResultEntityMapper {
    public FlightSearchResultEntity map(FlightsSearchResultDto flightsSearchResultDto){
        if (flightsSearchResultDto==null){
            return  null;
        }
        FlightSearchResultEntity flightSearchResultEntity= new FlightSearchResultEntity();
        ModelMapper modelMapper= new ModelMapper();
        modelMapper.map(flightsSearchResultDto,flightSearchResultEntity);

        return flightSearchResultEntity;
    }
}
