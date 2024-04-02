package com.pavelBozhinov.IcarusAir.repositories;

import com.pavelBozhinov.IcarusAir.model.Flight;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface FlightsRepository extends org.springframework.data.mongodb.repository.MongoRepository<Flight, String>{

    @Query(value ="{flightRoute:'?0'}", fields = "{'_id':1, 'start':1, 'destination':1, 'start_short':1, 'destination_short':1, 'flight_length':1, 'departure_time':1, 'arrival_time':1, 'is_direct':1, 'transfer_time':1, 'transfer_length':1, 'stops':1, 'price':1, 'airplane':1}")
    Flight findFlight(String flightRoute);
    @Query(value ="{start_short:'?0'}", fields = "{'_id':1, 'start':1, 'destination':1, 'start_short':1, 'destination_short':1, 'flight_length':1, 'departure_time':1, 'arrival_time':1, 'is_direct':1, 'transfer_time':1, 'transfer_length':1, 'stops':1, 'price':1, 'airplane':1}")
    List<Flight> findFlightByStart(String start_short);

    @Query(value = "{_class:'?0'}", fields = "{'_id':1, 'start':1, 'destination':1, 'start_short':1, 'destination_short':1, 'flight_length':1, 'departure_time':1, 'arrival_time':1, 'is_direct':1, 'transfer_time':1, 'transfer_length':1, 'stops':1, 'price':1, 'airplane':1}")
    List<Flight> findAll(String _class);

    public long count();
}
