package Entity;

import utils.enums.PassengerType;
import java.util.ArrayList;

public class Passenger {

    private final String cardId;
    private final PassengerType type;
    private final ArrayList<String> journey;

    public Passenger(String cardId, PassengerType passengerType) {
        this.cardId = cardId;
        this.type = passengerType;
        this.journey = new ArrayList<>();
    }

    public String getCardId() {
        return cardId;
    }

    public PassengerType getType() {
        return type;
    }

    public void addJourney(String station) {
        this.journey.add(station);
    }

    public ArrayList<String> getJourney() {
        return journey;
    }

    public boolean isRoundTrip(String station) {

        int n = journey.size();

        // If first time travelling or last travel == current travel
        if(n == 0 || journey.get(n-1).equals(station))
            return false;

        if(n == 1)
            return !journey.get(0).equals(station);


        boolean result = false;

        for(int i = 0; i < n-1; i++) {

            if(journey.get(i).equals(journey.get(i+1))) {
                result = false;

            } else {
                result = true;
                i++;
            }
        }

        return !result;

    }
}
