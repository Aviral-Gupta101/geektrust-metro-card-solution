package service;

import Entity.Passenger;
import repository.PassengerRepository;
import repository.PassengerRepositoryIml;

import java.util.List;

public class PassengerService {

    public static final PassengerRepository repo = new PassengerRepositoryIml();

    public Passenger createPassenger(Passenger passenger) {
        return repo.save(passenger);
    }

    public Passenger getPassengerById(String id) {
        return repo.findById(id).orElse(null);
    }

    public void addJourney(String id, String journey){

        Passenger passenger = getPassengerById(id);

        if(passenger == null){
            throw new IllegalArgumentException("Passenger not found");
        }

        passenger.addJourney(journey);
    }

    public List<String> getJourneys(String id) {
        Passenger passenger = getPassengerById(id);

        if(passenger == null){
            throw new IllegalArgumentException("Passenger not found");
        }

        return passenger.getJourney();
    }

}
