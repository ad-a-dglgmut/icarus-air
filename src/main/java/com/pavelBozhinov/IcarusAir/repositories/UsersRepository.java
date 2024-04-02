package com.pavelBozhinov.IcarusAir.repositories;

import com.pavelBozhinov.IcarusAir.model.FlightExtended;
import com.pavelBozhinov.IcarusAir.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface UsersRepository extends org.springframework.data.mongodb.repository.MongoRepository<User, String> {
   @Query("{id: '?0'}")
    User findUserById(String id);

    @Query("{userName: '?0'}")
    User findUserByUserName(String userName);

    @Query("{userName: '?0'}")
    @Update("{ '$push' : { 'flights' : ?1}}")
    void bookFlight(String userName, FlightExtended bookingInfo);

   @Query(value = "{_class : '?0'}", fields = "{'_id' : 1, 'userName' : 1, 'password' : 1, 'flights' : 1}")
    List<User> findAll(String _class);

   public long count();
}
