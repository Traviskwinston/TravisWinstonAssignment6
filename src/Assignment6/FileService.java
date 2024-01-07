package Assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {
	
	public ArrayList<TeslaSalesData> addInfoFromFile(String fileName) {
		String line; //Used to read the line the fileReaders are on.
		BufferedReader fileReader = null;
		ArrayList<TeslaSalesData> fileData = new ArrayList<>();
		//Store the Master List into an Array
		try {
			//Assign each line from the fileName.csv file into an ArrayList<ofThisType>.
			fileReader = new BufferedReader(new FileReader(fileName));
			fileReader.readLine(); // use this to skip that pesky first line.
			while ((line = fileReader.readLine()) != null){
				String[] lineInfo = line.split(",");
				//Date (MMM-yy,Sales)
				fileData.add(new TeslaSalesData(lineInfo[0],lineInfo[1]));
				}
		} catch (FileNotFoundException e) {
			System.out.println("No " + fileName + " file found");
		} catch (IOException e) {
			System.out.println("There is I/O Exception");
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return fileData;
	}
}
