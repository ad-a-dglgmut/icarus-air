package com.pavelBozhinov.IcarusAir.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Flights")
public class Flight {
    @Id
    private String id;
    private String start;
    private String destination;
    private String start_short;
    private String destination_short;
    private int flight_length;
    private String departure_time;
    private int price;
    private String airplane;
    private String arrival_time;
    private boolean is_direct;
    private String transfer_time;
    private int transfer_length;

    private Flight[] stops;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStart_short() {
        return start_short;
    }

    public void setStart_short(String start_short) {
        this.start_short = start_short;
    }

    public String getDestination_short() {
        return destination_short;
    }

    public void setDestination_short(String destination_short) {
        this.destination_short = destination_short;
    }

    public int getFlight_length() {
        return flight_length;
    }

    public void setFlight_length(int flightLength) {
        this.flight_length= flightLength;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departureTime) {
        this.departure_time= departureTime;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrivalTime) {
        this.arrival_time= arrivalTime;
    }

    public boolean isDirect() {
        return is_direct;
    }

    public void setDirect(boolean direct) {
        is_direct = direct;
    }

    public String getTransfer_time() {
        return transfer_time;
    }

    public void setTransfer_time(String transferTime) {
        this.transfer_time = transferTime;
    }

    public Flight[] getStops() {
        return stops;
    }

    public void setStops(Flight[] stops) {
        this.stops = stops;
    }

    public int getTransfer_length() {
        return transfer_length;
    }

    public void setTransfer_length(int transferLength) {
        this.transfer_length = transferLength;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }
}
