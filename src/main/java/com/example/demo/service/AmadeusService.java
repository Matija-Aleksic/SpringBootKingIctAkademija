package com.example.demo.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AmadeusService {
    Logger logger = LoggerFactory.getLogger(AmadeusService.class);
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
}
