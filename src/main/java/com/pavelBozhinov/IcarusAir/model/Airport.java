package com.pavelBozhinov.IcarusAir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Airports")
public class Airport {
    @Id
    private String id;

    private String name;

    private String name_short;

    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_short() {
        return name_short;
    }

    public void setName_short(String name_short) {
        this.name_short = name_short;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
