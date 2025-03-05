package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] token = line.split(" ");

                Solution.solve(token);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}