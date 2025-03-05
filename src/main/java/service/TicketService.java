package service;

import Entity.Passenger;
import Entity.Station;
import pojo.FareAndDiscount;
import utils.enums.PassengerType;


public class TicketService {

    private static final MetroCardService metroCardService = new MetroCardService();
    private static final PassengerService passengerService = new PassengerService();
    private static final StationService stationService = new StationService();

    private static final int transactionFeesPercent = 2; // 2 is for transaction fees on card recharge
    private static final float discountRate = 0.5f; // 0.5f is the discount rate

    public void checkIn(String cardId, PassengerType passengerType, String stationName) {

        Passenger foundPassenger = passengerService.getPassengerById(cardId);
        Station station = stationService.getStation(stationName);

        if(foundPassenger == null){
             foundPassenger = passengerService.createPassenger(new Passenger(cardId, passengerType));
        }

        FareAndDiscount fareAndDiscount = calculateFareAndDiscount(foundPassenger, stationName);

        int totalFare = fareAndDiscount.getFare();
        int discount = fareAndDiscount.getDiscount();

        if(station == null){
            station = stationService.createStation(new Station(stationName));
        }

        station.addTotalCollections(totalFare);
        station.addDiscount(discount);

        foundPassenger.addJourney(stationName);

        station.addPassenger(foundPassenger.getType());
    }

    private FareAndDiscount calculateFareAndDiscount(Passenger passenger, String stationName){

        String carId = passenger.getCardId();
        int passengerBalance = metroCardService.getBalance(carId);

        int fare = passenger.getType().getFare();
        int discount = 0;

        boolean isRoundTrip = passenger.isRoundTrip(stationName);

        if(isRoundTrip)
            discount = (int)(fare * discountRate);

        int totalFare = fare - discount;

        if(totalFare <= passengerBalance){
            metroCardService.withdraw(carId, totalFare);
        }
        else {
            metroCardService.resetBalance(carId);
            int negativeBalance = totalFare - passengerBalance;
            totalFare = totalFare + (transactionFeesPercent * negativeBalance)/100;
        }

//        System.out.println("TOTAL FARE: " + totalFare + " station : " + stationName);
        return new FareAndDiscount(totalFare, discount);
    }
}
