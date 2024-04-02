package com.pavelBozhinov.IcarusAir.repositories;

import com.pavelBozhinov.IcarusAir.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DataRepository {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    FlightsRepository flightsRepository;

    @Autowired
    AirportsRepository airportsRepository;
    public void setUsers(User user) {
        user.setId(UUID.randomUUID().toString());
        usersRepository.save(user);
    }

    public User findUserByUserName(String userName) {
        return usersRepository.findUserByUserName(userName);
    }

    public Flight findFlight(String start_short, String destination_short){
        return flightsRepository.findFlight(start_short + "-" + destination_short);
    }

    public List<Flight> findAll() {
        return flightsRepository.findAll("com.pavelBozhinov.IcarusAir.model.Flights");
    }

    public List<Flight> findFlightByStart(String start_short){
        return flightsRepository.findFlightByStart(start_short);
    }

    public String bookFLight(FlightExtended bookingInfo, String userName){
        usersRepository.bookFlight(userName, bookingInfo);
        return "Flight Booked";
    }

    public User getUserDetails(String userName){
       return usersRepository.findUserByUserName(userName);
    }

    public Airport[] getAirports() {
        return airportsRepository.findAirports("com.pavelBozhinov.IcarusAir.model.Airports").toArray(new Airport[0]);
    }
}
