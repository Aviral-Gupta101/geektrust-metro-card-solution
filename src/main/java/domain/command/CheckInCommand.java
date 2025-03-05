package domain.command;

import service.TicketService;
import utils.enums.PassengerType;

public class CheckInCommand implements Command {

    private static final TicketService service = new TicketService();

    @Override
    public void execute(String[] args) {

        // CHECK_IN MC1 ADULT CENTRAL

        String cardId = args[1];
        PassengerType passengerType = PassengerType.valueOf(args[2]);
        String station = args[3];

        service.checkIn(cardId, passengerType, station);
    }
}
