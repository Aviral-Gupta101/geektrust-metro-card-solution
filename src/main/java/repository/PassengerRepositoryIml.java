package repository;

import Entity.Passenger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class PassengerRepositoryIml implements PassengerRepository {

    private static final Map<String, Passenger> passengerMap = new HashMap<>();

    @Override
    public Passenger save(Passenger passenger) {
        passengerMap.put(passenger.getCardId(), passenger);
        return passenger;
    }

    @Override
    public Optional<Passenger> findById(String cardId) {
        Passenger result = passengerMap.get(cardId);

        if(result == null) {
            return Optional.empty();
        }
        return Optional.of(result);
    }

}
