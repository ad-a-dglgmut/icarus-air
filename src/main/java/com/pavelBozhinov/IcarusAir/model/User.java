package com.pavelBozhinov.IcarusAir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class User {
    @Id
    private String id;
    private String userName;
    private String password;

    private FlightExtended[] flights;



    public String getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FlightExtended[] getFlights() {
        return this.flights;
    }

    public void setFlights(FlightExtended[] flights) {
        this.flights= flights;
    }
}
