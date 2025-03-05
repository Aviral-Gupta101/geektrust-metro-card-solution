package service;

import Entity.Station;
import pojo.PassengerCount;
import utils.enums.PassengerType;

import java.util.*;


public class PrintService {

    private static final StationService service = new StationService();

    public void printCollectionAndPassengerSummary(String station){

        Station foundStation = service.getStation(station);

        if(foundStation == null)
            throw new RuntimeException("Station not found");

        List<PassengerType> passengerTypeList = foundStation.getPassengers();

        printCollection(foundStation);
        printPassengerSummary(passengerTypeList);
    }

    private void printCollection(Station station){

        int totalCollection = station.getTotalCollections();
        int discount = station.getTotalDiscount();

        System.out.println("TOTAL_COLLECTION " + station.getName() + " " + totalCollection + " " + discount);
    }

    private void printPassengerSummary(List<PassengerType> passengerTypeList){

        Map<String, Integer> map = new HashMap<>();
        List<PassengerCount> passengerCountList = new ArrayList<>();

        for(PassengerType passengerType : passengerTypeList){

            int freq = map.getOrDefault(passengerType.toString(), 0);
            map.put(passengerType.toString(), freq + 1);
        }

        map.forEach( (k,v) -> passengerCountList.add(new PassengerCount(PassengerType.valueOf(k), v)));

        passengerCountList.sort((first, second) -> {

            if(first.getCount() != second.getCount())
                return Integer.compare(first.getCount(), second.getCount()) * -1;

            return first.getPassengerType().toString().compareTo(second.getPassengerType().toString());
        });

        System.out.println("PASSENGER_TYPE_SUMMARY");
        passengerCountList.forEach(passengerCount -> {
            System.out.println(passengerCount.getPassengerType().toString() + " " + passengerCount.getCount());
        });

    }

}
