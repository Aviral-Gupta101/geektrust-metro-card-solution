package pojo;

import utils.enums.PassengerType;

public class PassengerCount {

    private final PassengerType passengerType;
    private final int count;

    public PassengerCount(PassengerType passengerType, int count) {
        this.passengerType = passengerType;
        this.count = count;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public int getCount() {
        return count;
    }
}
