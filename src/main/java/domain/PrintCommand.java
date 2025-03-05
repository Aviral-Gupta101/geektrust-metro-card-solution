package domain;

import service.PrintService;

public class PrintCommand implements Command {

    private static final PrintService service = new PrintService();

    @Override
    public void execute(String[] args) {

        service.printCollectionAndPassengerSummary("CENTRAL");
        service.printCollectionAndPassengerSummary("AIRPORT");
    }
}
