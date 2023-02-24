package com.bridgelabz.indianstatecensus;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StateCensusAnalyserTest {
    List<CSVStateCensus> expectedList;
    List<CSVStateCensus> actualList;
    @org.junit.jupiter.api.Test
    void readCSV() throws IOException, CsvException {
        File actualFile = new File("D:\\BridgelabzClassWork\\Assignment-243\\Day29-Indian-State-Census\\src\\main\\java\\com\\bridgelabz\\indianstatecensus\\statecensus.csv\"");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        actualList = stateCensusAnalyser.readCSV(actualFile);
        int actual = actualList.size();
        int expected = 0;
        Assertions.assertEquals(actual, expected);
    }
}