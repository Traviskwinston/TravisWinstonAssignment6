package Assignment6;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class YearlySalesReport {

	public static void main(String[] args) throws ParseException {

		runReport("Model 3", "model3.csv");

		runReport("Model S", "modelS.csv");

		runReport("Model X", "modelX.csv");
		
	}
	
	public static void runReport(String model, String fileName) {
		FileService fileService = new FileService();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM-yy");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		ArrayList<TeslaSalesData> fileData = fileService.addInfoFromFile(fileName);
		
		
		System.out.println(model +" Yearly Sales Report");
		System.out.println("---------------------------");
		// How to turn this For loop into STREAMS?
		for (int i = 2016; i <2020;i++) { // LOOP 2016, 2017, 2018, 2019, 2020
			int sales = 0; //Each loop will restart sales to 0
			for (TeslaSalesData eachLine : fileData) { //for each object in TeslaSalesData
				//get Sales $ total, add to Year List
				YearMonth date = YearMonth.parse(eachLine.getDate(),dateFormatter);//Turn the String Date, into a date format and check the year
				if (date.getYear()==i) {//if the year Matches i, then add the sales from that year to the total sales
					sales=eachLine.getSales();
				}
			}
			if (sales > 0) { //This is to not display any year with no sales
				System.out.println(i +" -> " + currencyFormatter.format(sales));
			}
		}
		
		Collections.sort(fileData, new SalesComparator());//Sort the data so the highest sales is first index, and lowest sales is last index.
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yy");
		try {
			Date varDate1 = dateFormat.parse(fileData.get(0).toString());//Date of highest sales
			Date varDate2 = dateFormat.parse(fileData.get(fileData.size() -1).toString());//Date of lowest Sales
			dateFormat = new SimpleDateFormat("yyyy-MM");
			System.out.println("\nThe best month for " + model + " was: " + dateFormat.format(varDate1));
			System.out.println("The worst month for " + model + " was: " + dateFormat.format(varDate2) + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
