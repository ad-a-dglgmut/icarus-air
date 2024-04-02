package com.pavelBozhinov.IcarusAir.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class FlightExtended {

    public FlightExtended(){}

    @Id
    private String id;
    private String start;
    private String destination;
    private String start_short;
    private String destination_short;
    private String isReturning;
    private boolean isDirect;
    private int transferLength;
    private String departureTime;
    private String arrivalTime;
    private int flightLength;
    private String returningDepartureTime;
    private String returningArrivalTime;
    private int returningFlightLength;
    private int returningTransferLength;
    private Date departureDate;
    private Date returnDate;
    private int price;

    private Flight[] stops;
    private Flight[] returningStops;

    private String[] airplane;
    private PassengerInfo[] passengerInfo;


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

    public String isReturning() {
        return isReturning;
    }

    public void setReturning(String returning) {
        isReturning = returning;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getFlightLength() {
        return flightLength;
    }

    public void setFlightLength(int flightLength) {
        this.flightLength = flightLength;
    }

    public String getReturningDepartureTime() {
        return returningDepartureTime;
    }

    public void setReturningDepartureTime(String returningDepartureTime) {
        this.returningDepartureTime = returningDepartureTime;
    }

    public String getReturningArrivalTime() {
        return returningArrivalTime;
    }

    public void setReturningArrivalTime(String returningArrivalTime) {
        this.returningArrivalTime = returningArrivalTime;
    }

    public int getReturningFlightLength() {
        return returningFlightLength;
    }

    public void setReturningFlightLength(int returningFlightLength) {
        this.returningFlightLength = returningFlightLength;
    }

    public Flight[] getStops() {
        return stops;
    }

    public void setStops(Flight[] stops) {
        this.stops = stops;
    }

    public boolean isDirect() {
        return isDirect;
    }

    public void setDirect(boolean direct) {
        isDirect = direct;
    }

    public int getTransferLength() {
        return transferLength;
    }

    public void setTransferLength(int transferLength) {
        this.transferLength = transferLength;
    }

    public Flight[] getReturningStops() {
        return returningStops;
    }

    public void setReturningStops(Flight[] returningStops) {
        this.returningStops = returningStops;
    }

    public int getReturningTransferTime() {
        return returningTransferLength;
    }

    public void setReturningTransferTime(int returningTransferLength) {
        this.returningTransferLength = returningTransferLength;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String[] getAirplane() {
        return airplane;
    }

    public void setAirplane(String[] airplane) {
        this.airplane = airplane;
    }

    public PassengerInfo[] getPassengerInfo() {
        return passengerInfo;
    }

    public void setPassengerInfo(PassengerInfo[] passengerInfo) {
        this.passengerInfo = passengerInfo;
    }
}
