package appoint;

public class Appointment {
	private int year;
	private int month;
	private int day;
	
	public Appointment(int day, int month, int year) {
		day = this.day;
		month = this.month;
		year = this.year;
	}
	
	public int[] getDate() {
		int[] daDate = new int[] {day, month, year};
		return daDate;
	}
	
	public boolean occursOn(int d, int m, int y) {
		return day == d && month == m && year == y;
	}

}
