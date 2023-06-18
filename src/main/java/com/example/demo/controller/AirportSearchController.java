package com.example.demo.controller;

import com.amadeus.resources.Location;
import com.example.demo.dto.FlightsSearchResultDto;
import com.example.demo.dto.LocationDto;
import com.example.demo.form.FlightSearchForm;
import com.example.demo.mapper.LocationLocationDtoMapper;
import com.example.demo.service.AmadeusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/flightSearch")
public class AirportSearchController {
    @Autowired
    private LocationLocationDtoMapper locationLocationDtoMapper;
    @Autowired
    private AmadeusService amadeusService;
    @GetMapping(value = "/airports/{keyword}")
    public ResponseEntity<List<LocationDto>>  searchAirports(@PathVariable String keyword){
        List<Location> locationList= amadeusService.searchAiports(keyword);
        List<LocationDto> locationDtos = locationList.stream()
                .map(location -> locationLocationDtoMapper.map(location))
                .toList();
        return ResponseEntity.ok().body(locationDtos);
        //il sve strpat u jedan return
    }
    @PostMapping(value = "/Flights")
    public ResponseEntity<List<FlightsSearchResultDto>> searchFlighs(@RequestBody @Valid FlightSearchForm form){
        List<FlightsSearchResultDto> flightsSearchResultDtoList =
        amadeusService.searchFlights(form.getOriginLocationCode(),
                form.getDestinationLocationCode(),
                form.getDepartureDate(),
                form.getReturnDate(),
                form.getAdults());
        return ResponseEntity.ok().body(flightsSearchResultDtoList);

    }
}
