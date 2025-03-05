package domain.command;

import service.PrintService;

public class PrintCommand implements Command {

    private static final PrintService service = new PrintService();

    @Override
    public void execute(String[] args) {

        service.printCollectionAndPassengerSummary("CENTRAL"); // Default as per the requirement
        service.printCollectionAndPassengerSummary("AIRPORT"); // Default as per the requirement
    }
}
