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

	public boolean occursOn(int day, int month, int year) {
		return (day == this.day) && (month == this.month) && (year == this.year);
	}
	
	public int[] getDate() {
		int[] daDate = new int[] {day, month, year};
		return daDate;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}

}
