package Entity;

import utils.enums.PassengerType;
import java.util.ArrayList;
import java.util.List;

public class Station {

    private final String name;
    private int totalCollections;
    private int totalDiscount;
    private final List<PassengerType> passengersTypes; // [ ADULT, KID, SENIOR_CITIZEN ]

    public Station(String name) {
        this.name = name;
        this.passengersTypes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCollections() {
        return totalCollections;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public List<PassengerType> getPassengers() {
        return new ArrayList<>(passengersTypes);
    }

    public void addPassenger(PassengerType passengerType) {

        if(passengerType == null) {
            throw new IllegalArgumentException("Passenger type cannot be null");
        }

        passengersTypes.add(passengerType);
    }


    public void addTotalCollections(int amount) {

        if(amount < 0) {
            throw new IllegalArgumentException("Total collections cannot be less than zero");
        }

        totalCollections += amount;
    }

    public void addDiscount(int amount) {

        if(amount < 0) {
            throw new IllegalArgumentException("Discount cannot be less than zero, discount: " + amount);
        }

        totalDiscount += amount;
    }

}

