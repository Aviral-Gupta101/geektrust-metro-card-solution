package domain;

import service.MetroCardService;

public class BalanceCommand implements Command {

    private static final MetroCardService service = new MetroCardService();

    @Override
    public void execute(String[] args) {
        String id = args[1];
        int balance = Integer.parseInt(args[2]);

        service.createMetroCard(id, balance);
    }
}
