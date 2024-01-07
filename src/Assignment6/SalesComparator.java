package Assignment6;

import java.util.Comparator;

public class SalesComparator implements Comparator<TeslaSalesData> {

		@Override
		public int compare(TeslaSalesData value1, TeslaSalesData value2) {
			return value2.getSales().compareTo(value1.getSales()); // swap value1 and value2 to reverse order
		}
}
