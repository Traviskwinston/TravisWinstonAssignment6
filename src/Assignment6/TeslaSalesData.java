package Assignment6;

public class TeslaSalesData {
	
	private String date;
	private Integer sales;
	
	public TeslaSalesData(String date, String sales) {
		this.date = date;
		this.sales = Integer.parseInt(sales);
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return date;
	}

}
