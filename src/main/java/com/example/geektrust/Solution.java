package com.example.geektrust;

import domain.command.Command;
import domain.factory.CommandFactory;

public class Solution {

    public static void solve(String[] tokens){
        Command command = CommandFactory.getCommand(tokens[0]);
        command.execute(tokens);
    }
}
