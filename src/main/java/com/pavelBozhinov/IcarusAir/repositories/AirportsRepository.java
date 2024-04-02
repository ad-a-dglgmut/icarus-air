package com.pavelBozhinov.IcarusAir.repositories;

import com.pavelBozhinov.IcarusAir.model.Airport;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AirportsRepository extends org.springframework.data.mongodb.repository.MongoRepository<Airport, String>{
    @Query(value = "{_class: '?0'}", fields = "{'_id':1, 'name':1, 'name_short':1, 'city':1}")
    List<Airport> findAirports(String _class);
}
