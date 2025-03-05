package com.example.geektrust;

import domain.BalanceCommand;
import domain.CheckInCommand;
import domain.Command;
import domain.PrintCommand;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Command balanceCommand = new BalanceCommand();
        Command checkInCommand = new CheckInCommand();
        Command printCommand = new PrintCommand();

        try {

            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] token = line.split(" ");

                if("BALANCE".equals(token[0]))
                    balanceCommand.execute(token);

                else if("CHECK_IN".equals(token[0]))
                    checkInCommand.execute(token);

                else if("PRINT_SUMMARY".equals(token[0]))
                    printCommand.execute(token);
                else
                    System.out.println("Invalid command");
            }
            sc.close();
        } catch (IOException e) {

            System.out.println("Error reading file");
        }

    }
}