package appoint;

public class Daily extends Appointment { 
	public Daily(int day, int month, int year) {
		super(day, month, year);
	}
	public boolean occursOn(int day, int month, int year) {
		if(year > getYear()) {
			return true;
		}
		if(year == getYear()) {
			if(month > getMonth()) {
				return true;
			}
			if(month == getMonth()) {
				if(day >= getDay()) {
					return true;
				}
			}
		}
		return false;
	}

}
