package com.example.demo.mapper;


import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.shopping.FlightOffersSearch;
import com.example.demo.dto.FlightsSearchResultDto;
import org.springframework.stereotype.Component;

@Component
public class FlightOfferSearchFlightSearchResultMapper {
    public FlightsSearchResultDto map(FlightOfferSearch flightOfferSearch){
        if (flightOfferSearch == null){
            return null;
        }
        FlightsSearchResultDto flightsSearchResultDto= new FlightsSearchResultDto();

        FlightOfferSearch.Itinerary outboundItinerary = flightOfferSearch.getItineraries()[0];
        FlightOfferSearch.Itinerary inboundItinerary =flightOfferSearch.getItineraries()[1];
        FlightOfferSearch.SearchSegment firstOutboundSegment = outboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment lastOutboundSegment = outboundItinerary
                .getSegments()[outboundItinerary.getSegments().length - 1];
        FlightOfferSearch.SearchSegment firstInboundSegment = inboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment lastInboundSegment = inboundItinerary.getSegments()[inboundItinerary
                .getSegments().length - 1];

        flightsSearchResultDto.setOutboundDepartureAirport(firstOutboundSegment.getDeparture().getIataCode());
        flightsSearchResultDto.setOutboundArrivalAirport(firstOutboundSegment.getArrival().getIataCode());
        flightsSearchResultDto.setOutboundDepartureDate(firstOutboundSegment.getDeparture().getAt());
        flightsSearchResultDto.setOutboundArrivalDate(firstOutboundSegment.getArrival().getAt());
        flightsSearchResultDto.setInboundDepartureAirport(firstInboundSegment.getDeparture().getIataCode());
        flightsSearchResultDto.setInboundArrivalAirport(lastInboundSegment.getArrival().getIataCode());
        flightsSearchResultDto.setInboundDepartureDate(firstInboundSegment.getDeparture().getAt());
        flightsSearchResultDto.setInboundArrivalDate(lastInboundSegment.getArrival().getAt());
        flightsSearchResultDto.setCarrier(firstOutboundSegment.getCarrierCode());
        flightsSearchResultDto.setPrice(flightOfferSearch.getPrice().getTotal());
        return flightsSearchResultDto;

    }
}
