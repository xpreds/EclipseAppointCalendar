package appoint;

public class Monthly extends Appointment { 
	public Monthly(int day, int month, int year) {
		super(day, month, year);
	}

	public boolean occursOn(int day, int month, int year) {
		if (year < getYear()) {
			return false;
		}
		if (month < getMonth() && year == getYear()) {
			return false;
		}
		return day == getDay();
	}
}

