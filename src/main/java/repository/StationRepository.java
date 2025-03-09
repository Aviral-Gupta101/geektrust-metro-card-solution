package repository;

import Entity.Station;

import java.util.Optional;

public interface StationRepository {
    void saveStation(Station station);

    Optional<Station> findByName(String stationName);

    void clearRepository();
}
