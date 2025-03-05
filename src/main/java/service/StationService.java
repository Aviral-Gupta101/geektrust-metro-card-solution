package service;

import Entity.Station;
import repository.StationRepository;
import repository.StationRepositoryImpl;

public class StationService {

    private static final StationRepository stationRepository = new StationRepositoryImpl();

    public Station createStation(Station station) {
        stationRepository.saveStation(station);
        return station;
    }

    public Station getStation(String stationName) {
        return stationRepository.findByName(stationName).orElse(null);
    }

}
