package com.pavelBozhinov.IcarusAir.services;

import com.pavelBozhinov.IcarusAir.model.Flight;
import com.pavelBozhinov.IcarusAir.repositories.DataRepository;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Math.abs;

@Service
public class FlightFindingService {
    private final DataRepository dataRepository;

    public FlightFindingService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Flight[] findFlightConnection (String start, String destination) {
        Map<Integer, List<Flight>> paths = new HashMap<Integer,List<Flight> >();
        for(int i = 0;i<dataRepository.findFlightByStart(start).size();i++) {
            for(int j = 0;j<dataRepository.findFlightByStart(dataRepository.findFlightByStart(start).get(i).getDestination_short()).size();j++){
               if(Objects.equals(dataRepository.findFlightByStart(dataRepository.findFlightByStart(start).get(i).getDestination_short()).get(j).getDestination_short(), destination)){
                    List<Flight> flightList = new ArrayList<Flight>();
                    flightList.add(dataRepository.findFlightByStart(start).get(i));
                    flightList.add(dataRepository.findFlightByStart(dataRepository.findFlightByStart(start).get(i).getDestination_short()).get(j));
                    paths.put(flightList.get(0).getFlight_length() + flightList.get(1).getFlight_length(), flightList);
                }
            }
        }

        Integer[] flightLength=  paths.keySet().toArray(new Integer[0]);
        Arrays.sort(flightLength);
        return paths.get(flightLength[0]).toArray(new Flight[0]);
    }

    public int findFlightLength(Flight[] flights) {
        int f1 = Integer.parseInt(flights[0].getArrival_time().substring(0, 2));
        int f2 = Integer.parseInt(flights[0].getArrival_time().substring(3));
        int s1 = Integer.parseInt(flights[1].getDeparture_time().substring(0,2));
        int s2 = Integer.parseInt(flights[1].getDeparture_time().substring(3));

        int transferLength;
        transferLength = abs(s2-f2);
        if(f2>s2) {
            s1-=1;
        }
        transferLength+=abs((s1-f1)*60);
        if(s1<f1) {
            transferLength+=24*60;
        }

        return transferLength + flights[0].getFlight_length() + flights[1].getFlight_length();
    }
    public int findTransferLength(Flight[] flights) {

        int f1 = Integer.parseInt(flights[0].getArrival_time().substring(0, 2));
        int f2 = Integer.parseInt(flights[0].getArrival_time().substring(3));
        int s1 = Integer.parseInt(flights[1].getDeparture_time().substring(0,2));
        int s2 = Integer.parseInt(flights[1].getDeparture_time().substring(3));

        int transferLength;
        transferLength = abs(s2-f2);
        if(f2>s2) {
            s1-=1;
        }
        transferLength+=abs((s1-f1)*60);
        if(s1<f1) {
            transferLength+=24*60;
        }

        return transferLength;
    }
}
