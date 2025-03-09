package repository;

import Entity.Station;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class StationRepositoryImpl implements StationRepository {

    private static final Map<String, Station> stationMap = new HashMap<>();

    @Override
    public void saveStation(Station station) {
        stationMap.put(station.getName(), station);
    }

    @Override
    public Optional<Station> findByName(String stationName) {
        Station result = stationMap.get(stationName);

        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(result);
    }

    public void clearRepository() {
        stationMap.clear();
    }

}
