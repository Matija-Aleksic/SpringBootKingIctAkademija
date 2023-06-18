package com.example.demo.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.example.demo.dto.FlightsSearchResultDto;
import com.example.demo.mapper.FlightOfferSearchFlightSearchResultMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AmadeusService {
    Logger logger = LoggerFactory.getLogger(AmadeusService.class);
    @Autowired
    private FlightOfferSearchFlightSearchResultMapper flightOfferSearchFlightSearchResultMapper= new FlightOfferSearchFlightSearchResultMapper();
    @Autowired
    private Amadeus amadeus;
    public List<Location> searchAiports(String keyword) {
        try {
            Params params = Params.with("subType", Locations.AIRPORT)
                    .and("keyword",keyword);
            return Arrays.asList(amadeus.referenceData.locations
                         .get(params));
        } catch (ResponseException e) {
            logger.error("error with airport search", e);
            return Collections.emptyList();
        }
    }
    public List<FlightsSearchResultDto> searchFlights(String originLocationCode, String destinationLocationCode, LocalDate departureDate, LocalDate returnDate, Integer adults ){
        try {
            Params params = Params
                    .with("originLocationCode", originLocationCode)
                    .and("destinationLocationCode", destinationLocationCode)
                    .and("departureDate", departureDate.toString())
                    .and("returnDate", returnDate)
                    .and("adults", adults);
            if (returnDate!=null){
                params.and("returnDate",returnDate.toString());
            }

            List<FlightOfferSearch>flightOfferSearches= Arrays.asList(amadeus.shopping.flightOffersSearch.get(params));
            List<FlightsSearchResultDto> flightsSearchResultDtos=flightOfferSearches.stream()
                    .map(flightOfferSearch -> flightOfferSearchFlightSearchResultMapper
                            .map(flightOfferSearch)).toList();
            return flightsSearchResultDtos;
        }catch (Exception e){
            logger.error("Search flight error", e);
            return Collections.emptyList(); }
    }
}
