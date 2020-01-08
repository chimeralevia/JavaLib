package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	public List<String[]> loadCsvToList(String filePath, String seperator) {
		List<String[]> csvData = new ArrayList<>();

		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath));) {

			while ((line = br.readLine()) != null) {

				String[] rowCells = line.split(seperator);

				if (rowCells[0].equals("#")) {
					continue;
				}

				csvData.add(rowCells);
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException("File could not be found");
		} catch (IOException e) {
			throw new RuntimeException("IOException");
		}

		return csvData;
	}
}
