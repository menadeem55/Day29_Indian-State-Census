package com.bridgelabz.indianstatecensus;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyser {
	File file = new File(
			"D:\\BridgelabzClassWork\\Assignment-243\\Day29-Indian-State-Census\\src\\main\\java\\com\\bridgelabz\\indianstatecensus\\statecensus.csv");
	CSVStateCensus census;
	List<CSVStateCensus> censuses = new ArrayList<>();

	public List<CSVStateCensus> readCSV(File actualFile) throws IOException, CsvException, CustomException {
		try {
			if (file.exists()) {
				FileReader fileReader = new FileReader(file);
				CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
				List<String[]> allData = csvReader.readAll();
				for (String[] row : allData) {
					int sNo = Integer.parseInt(row[0]);
					String state = row[1];
					long population = Long.parseLong(row[2]);
					double increase = Double.parseDouble(row[3]);
					long area = Long.parseLong(row[4]);
					int density = Integer.parseInt(row[5]);
					int sexRatio = Integer.parseInt(row[6]);
					double literacy = Double.parseDouble(row[7]);
					census = new CSVStateCensus(sNo, state, population, increase, area, density, sexRatio, literacy);
					censuses.add(census);
				}
			} else {
				throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND,
						"Oops!, it seems the file doesn't exist");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return censuses;
	}
}