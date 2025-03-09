package repository;

import Entity.Passenger;

import java.util.Optional;

public interface PassengerRepository {
    Passenger save(Passenger passenger);

    Optional<Passenger> findById(String cardId);

    void clearRepository();
}
