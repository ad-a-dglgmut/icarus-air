package com.pavelBozhinov.IcarusAir.model;

import java.util.Date;

public class FlightBooking {
    private String start;

    private String destination;

    private String isReturning;

    private Date departureDate;

    private Date returnDate;

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

    public String getIsReturning() {
        return isReturning;
    }

    public void setReturning(String returning) {
        isReturning = returning;
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


}
