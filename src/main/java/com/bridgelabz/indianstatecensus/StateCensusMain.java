package com.bridgelabz.indianstatecensus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.exceptions.CsvException;

public class StateCensusMain {
	StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
    Scanner scanner = new Scanner(System.in);
    CSVStateCensus census;
    List<CSVStateCensus> censuses = new ArrayList<>();
    public void menu() throws CsvException, IOException {
        System.out.println("Menu 1. Read from CSV file and print 2. Print data from csv file 3. Exit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                censuses = stateCensusAnalyser.readCSV();
                menu();
                break;
            case 2:
                for(CSVStateCensus values : censuses) {
                    System.out.println(values);
                }
                menu();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid option");
                menu();
                break;
        }
    }
    public static void main(String[] args) throws CsvException, IOException {
        System.out.println("Welcome to Indian state census analyser program");
        StateCensusMain statecensusmain = new StateCensusMain();
        statecensusmain.menu();
    }
}
