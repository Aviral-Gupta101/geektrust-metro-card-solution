package com.example.geektrust;

import org.apache.maven.surefire.shade.org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.*;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private static Main main;
    private static MetroCardRepository metroCardRepository;
    private static PassengerRepository passengerRepository;
    private static StationRepository stationRepository;


    @BeforeAll
    public static void setUp() {
        main = new Main();

        metroCardRepository = new MetroCardRepositoryImpl();
        passengerRepository = new PassengerRepositoryIml();
        stationRepository = new StationRepositoryImpl();
    }

    @BeforeEach
    public void resetDatabase(){
        metroCardRepository.clearRepository();
        passengerRepository.clearRepository();
        stationRepository.clearRepository();
    }

    @Test
    @DisplayName("Test input file 1")
    public void test1(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expected = "TOTAL_COLLECTION CENTRAL 300 0\nPASSENGER_TYPE_SUMMARY\nADULT 1\nSENIOR_CITIZEN 1\nTOTAL_COLLECTION AIRPORT 403 100\nPASSENGER_TYPE_SUMMARY\nADULT 2\nKID 2\n";
        String inputFile = "sample_input/input1.txt";

        main.main(new String[]{inputFile});


        // Assert: Verify output
        assertEquals(expected, outContent.toString());

    }

    @Test
    @DisplayName("Test input file 2")
    public void test2(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expected = "TOTAL_COLLECTION CENTRAL 457 50\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 2\n" +
                "SENIOR_CITIZEN 1\n" +
                "TOTAL_COLLECTION AIRPORT 252 100\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" +
                "KID 1\n" +
                "SENIOR_CITIZEN 1\n";

        String inputFile = "sample_input/input2.txt";

        main.main(new String[]{inputFile});


        // Assert: Verify output
        assertEquals(expected, outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test input file 3")
    public void test3(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expected = "TOTAL_COLLECTION CENTRAL 300 50\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" +
                "KID 1\n" +
                "SENIOR_CITIZEN 1\n" +
                "TOTAL_COLLECTION AIRPORT 225 125\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" +
                "KID 1\n" +
                "SENIOR_CITIZEN 1\n";

        String inputFile = "sample_input/input3.txt";

        main.main(new String[]{inputFile});


        // Assert: Verify output
        assertEquals(expected, outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test input file 4")
    public void test4(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String expected = "TOTAL_COLLECTION CENTRAL 457 50\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 2\n" +
                "SENIOR_CITIZEN 1\n" +
                "TOTAL_COLLECTION AIRPORT 252 100\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" +
                "KID 1\n" +
                "SENIOR_CITIZEN 1\n";

        String inputFile = "sample_input/input4.txt";

        main.main(new String[]{inputFile});


        // Assert: Verify output
        assertEquals(expected, outContent.toString());

        // Reset System.out
        System.setOut(System.out);
    }
}