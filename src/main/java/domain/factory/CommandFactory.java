package domain.factory;

import domain.command.BalanceCommand;
import domain.command.CheckInCommand;
import domain.command.Command;
import domain.command.PrintCommand;

public class CommandFactory {

    public static Command getCommand(String command) {
        switch (command) {

            case "BALANCE":
                return new BalanceCommand();

            case "CHECK_IN":
                return new CheckInCommand();

            case "PRINT_SUMMARY":
                return new PrintCommand();

            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }
}
