package com.example.demo.mapper;


import com.amadeus.resources.Location;
import com.example.demo.dto.LocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationLocationDtoMapper {
    public LocationDto map(Location location){
        if(location==null){
            return null;
        }
        LocationDto locationDto = new LocationDto();
        locationDto.setName(location.getName().toString());
        locationDto.setIataCode(location.getIataCode());
        locationDto.setDetaleName(location.getDetailedName().toString());
        return locationDto;
    }
}
