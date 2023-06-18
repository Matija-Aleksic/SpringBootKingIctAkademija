package com.example.demo.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.example.demo.dto.FlightsSearchResultDto;
import com.example.demo.mapper.FlightOfferSearchFlightSearchResultMapper;
import com.example.demo.mapper.FlightSearchResultDtoFlightSearchResultEntityMapper;
import com.example.demo.model.FlightSearchEntity2;
import com.example.demo.repository.FlightSearchEntityRepo;
import com.example.demo.repository.FlightSearchResultEntityRepo;
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
    @Autowired
    private FlightSearchEntityRepo flightSearchEntityRepo;
    Logger logger = LoggerFactory.getLogger(AmadeusService.class);
    @Autowired
    private FlightOfferSearchFlightSearchResultMapper flightOfferSearchFlightSearchResultMapper = new FlightOfferSearchFlightSearchResultMapper();
    @Autowired
    private Amadeus amadeus;
    @Autowired
    private FlightSearchResultEntityRepo flightSearchResultEntityRepo;
    @Autowired
    private FlightSearchResultDtoFlightSearchResultEntityMapper flightSearchResultDtoFlightSearchResultEntityMapper;


    public List<Location> searchAiports(String keyword) {
        try {

            Params params = Params.with("subType", Locations.AIRPORT)
                    .and("keyword", keyword);
            return Arrays.asList(amadeus.referenceData.locations
                    .get(params));
        } catch (ResponseException e) {
            logger.error("error with airport search", e);
            return Collections.emptyList();
        }
    }

    public List<FlightsSearchResultDto> searchFlights(String originLocationCode, String destinationLocationCode, LocalDate departureDate, LocalDate returnDate, Integer adults) {
        try {

            FlightSearchEntity2 flightSearchEntity2 = new FlightSearchEntity2();
            flightSearchEntity2.setOriginLocationCode(originLocationCode);
            flightSearchEntity2.setDestinationLocationCode(destinationLocationCode);
            flightSearchEntity2.setDepartureDate(departureDate);
            flightSearchEntity2.setReturnDate(returnDate);
            flightSearchEntity2.setAdults(adults);

            flightSearchEntity2.setDateCreated(LocalDate.now());
            flightSearchEntity2.setUserCreated("Ivan");

            flightSearchEntityRepo.save(flightSearchEntity2);


            Params params = Params
                    .with("originLocationCode", originLocationCode)
                    .and("destinationLocationCode", destinationLocationCode)
                    .and("departureDate", departureDate.toString())
                    .and("returnDate", returnDate)
                    .and("adults", adults)
                    .and("nonStop", true)
                    .and("max", 5);

            if (returnDate != null) {
                params.and("returnDate", returnDate.toString());
            }

            List<FlightOfferSearch> flightOfferSearches = Arrays.asList(amadeus.shopping.flightOffersSearch.get(params));
            List<FlightsSearchResultDto> flightsSearchResultDtos = flightOfferSearches.stream()
                    .map(flightOfferSearch -> flightOfferSearchFlightSearchResultMapper
                            .map(flightOfferSearch)).toList();

            flightsSearchResultDtos.stream()
                    .map(flightsSearchResultDto -> flightSearchResultDtoFlightSearchResultEntityMapper.map(flightsSearchResultDto))
                            .forEach(flightSearchResultEntity ->
                            {
                                flightSearchResultEntity.setFlightSearchEntity2(flightSearchEntity2);
                                flightSearchResultEntityRepo.save(flightSearchResultEntity);
                            });


            return flightsSearchResultDtos;
        } catch (Exception e) {
            logger.error("Search flight error", e);
            return Collections.emptyList();
        }

    }
}
