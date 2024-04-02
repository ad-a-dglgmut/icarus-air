package com.pavelBozhinov.IcarusAir.controller;

import com.pavelBozhinov.IcarusAir.model.*;
import com.pavelBozhinov.IcarusAir.repositories.DataRepository;
import com.pavelBozhinov.IcarusAir.services.FlightFindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class RESTController {
    private final DataRepository dataRepository;
    private final FlightFindingService flightFindingService;
    public RESTController(DataRepository dataRepository, FlightFindingService flightFindingService)
    {
        this.dataRepository = dataRepository;
        this.flightFindingService = flightFindingService;
    }
    @CrossOrigin("*")
    @PostMapping("/users/register")
    public String register(@RequestBody User user) {
        if(dataRepository.findUserByUserName(user.getUsername()) == null) {
            dataRepository.setUsers(user);
            return "Successfully created user " + user.getUsername();
        }
        else {
            return "User with username " + user.getUsername() + " already exists";
        }

    }
    @CrossOrigin("*")
    @PostMapping("/users/login")
    public String login(@RequestBody User user) {
        if(dataRepository.findUserByUserName(user.getUsername()) != null && Objects.equals(dataRepository.findUserByUserName(user.getUsername()).getPassword(), user.getPassword())) {
            return "Login successful";
        } else {
            return "Login unsuccessful";
        }
    }

    @CrossOrigin("*")
    @PostMapping("/flights/")
    public FlightExtended getFlights(@RequestBody FlightBooking flightBooking) {
        FlightExtended flight = new FlightExtended();

        Flight simpleFlight = dataRepository.findFlight(flightBooking.getStart(), flightBooking.getDestination());
        if(simpleFlight != null){
            if(Objects.equals(flightBooking.getIsReturning(), "false")){
                flight.setId(UUID.randomUUID().toString());
                flight.setStart(simpleFlight.getStart());
                flight.setDestination(simpleFlight.getDestination());
                flight.setStart_short(simpleFlight.getStart_short());
                flight.setDestination_short(simpleFlight.getDestination_short());
                flight.setReturning(flightBooking.getIsReturning());
                flight.setArrivalTime(simpleFlight.getArrival_time());
                flight.setDepartureTime(simpleFlight.getDeparture_time());
                flight.setDirect(true);
                flight.setPrice(simpleFlight.getPrice());
                flight.setAirplane(new String[]{simpleFlight.getAirplane()});
                flight.setFlightLength(simpleFlight.getFlight_length());
                flight.setDepartureDate(flightBooking.getDepartureDate());
            }else {
                Flight simpleFlightReturn = dataRepository.findFlight(flightBooking.getDestination(), flightBooking.getStart());
                flight.setId(UUID.randomUUID().toString());
                flight.setStart(simpleFlight.getStart());
                flight.setDestination(simpleFlight.getDestination());
                flight.setStart_short(simpleFlight.getStart_short());
                flight.setDestination_short(simpleFlight.getDestination_short());
                flight.setReturning(flightBooking.getIsReturning());
                flight.setArrivalTime(simpleFlight.getArrival_time());
                flight.setAirplane(new String[]{simpleFlight.getAirplane()});
                flight.setDepartureTime(simpleFlight.getDeparture_time());
                flight.setFlightLength(simpleFlight.getFlight_length());
                flight.setReturningDepartureTime(simpleFlightReturn.getDeparture_time());
                flight.setPrice(simpleFlight.getPrice() + simpleFlightReturn.getPrice());
                flight.setReturningArrivalTime(simpleFlightReturn.getArrival_time());
                flight.setReturningFlightLength(simpleFlightReturn.getFlight_length());
                flight.setDirect(true);
                flight.setReturnDate(flightBooking.getReturnDate());
                flight.setDepartureDate(flightBooking.getDepartureDate());
            }
        }else {
            Flight[] flights = flightFindingService.findFlightConnection(flightBooking.getStart(), flightBooking.getDestination());
            if(flights != null){
                if(Objects.equals(flightBooking.getIsReturning(), "false")){
                    flight.setId(UUID.randomUUID().toString());
                    flight.setStart(flights[0].getStart());
                    flight.setDestination(flights[1].getDestination());
                    flight.setStart_short(flights[0].getStart_short());
                    flight.setDestination_short(flights[1].getDestination_short());
                    flight.setReturning(flightBooking.getIsReturning());
                    flight.setDirect(false);
                    flight.setArrivalTime(flights[1].getArrival_time());
                    flight.setDepartureTime(flights[0].getDeparture_time());
                    flight.setAirplane(new String[]{flights[0].getAirplane(), flights[1].getAirplane()});
                    flight.setPrice(flights[0].getPrice() + flights[1].getPrice());
                    flight.setFlightLength(flightFindingService.findFlightLength(flights));
                    flight.setStops(flights);
                    flight.setTransferLength(flightFindingService.findTransferLength(flights));

                    flight.setDepartureDate(flightBooking.getDepartureDate());
                }else{
                   Flight[] flightsReturn = flightFindingService.findFlightConnection(flightBooking.getDestination(), flightBooking.getStart());
                    flight.setId(UUID.randomUUID().toString());
                    flight.setStart(flights[0].getStart());
                    flight.setDestination(flights[1].getDestination());
                    flight.setStart_short(flights[0].getStart_short());
                    flight.setDestination_short(flights[1].getDestination_short());
                    flight.setReturning(flightBooking.getIsReturning());
                    flight.setDirect(false);
                    flight.setAirplane(new String[]{flights[0].getAirplane(), flights[1].getAirplane()});
                    flight.setArrivalTime(flights[1].getArrival_time());
                    flight.setDepartureTime(flights[0].getDeparture_time());
                    flight.setFlightLength(flightFindingService.findFlightLength(flights));
                    flight.setPrice(flights[0].getPrice() + flights[1].getPrice() + flightsReturn[0].getPrice() + flightsReturn[1].getPrice());
                    flight.setStops(flights);
                    flight.setReturningFlightLength(flightFindingService.findFlightLength(flightsReturn));
                    flight.setReturningArrivalTime(flightsReturn[1].getArrival_time());
                    flight.setReturningDepartureTime(flightsReturn[0].getDeparture_time());
                    flight.setReturningStops(flightsReturn);
                    flight.setReturningTransferTime(flightFindingService.findTransferLength(flightsReturn));
                    flight.setTransferLength(flightFindingService.findTransferLength(flights));

                    flight.setReturnDate(flightBooking.getReturnDate());
                    flight.setDepartureDate(flightBooking.getDepartureDate());
                }
            }else {
                return new FlightExtended();
            }

        }


        return flight;
    }

    @CrossOrigin("*")
    @PostMapping("/flights/bookflight/{userName}")
    public String bookFlight(@RequestBody FlightExtended bookingInfo, @PathVariable String userName) {
        return dataRepository.bookFLight(bookingInfo, userName);
    }

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return dataRepository.findAll();
    }
    @CrossOrigin("*")
    @GetMapping("/users/{userName}/details")
    public User getUserDetails(@PathVariable String userName){
       return dataRepository.findUserByUserName(userName);
    }

    @CrossOrigin("*")
    @GetMapping("/airports")
    public Airport[] getAirports() {
        return dataRepository.getAirports();
    }

}
