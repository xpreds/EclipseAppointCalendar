package calend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import appoint.*;

public class Calendar extends JPanel { 
	ArrayList<OneTime> oneTimes = new ArrayList<OneTime>();
	ArrayList<Monthly> monthlies = new ArrayList<Monthly>();
	ArrayList<Daily> dailies = new ArrayList<Daily>();
	ArrayList<CalendarDay> daDays = new ArrayList<CalendarDay>();
	
	public Calendar() {
		//setLocationRelativeTo(null);
		setSize(1050, 720);
		setLayout(new GridLayout(7, 6));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
		setup();
	}
	
	//In setup it should read the file and fill the Appointment lists with the info from the file
	public void setup() {
		for(int i = 0; i < 43; i++) {
			daDays.add(new CalendarDay(true, 01, 01, 01, true));
			add(daDays.get(i));
		}
		//While filereader is reading onetime fill the onetime list
		//While filereader reads monthly fill the monthly list
		//While filereader reads daily fill the daily list
	}
	
	//Each call of update should update the four lists and rewrite the file
	//Each time a new appointment is added to a CalendarDay, the Calendar gets the appointments of that CalendarDay
	//and check if an appointment on the CalendarDay object matches any from the three lists up above.
	//If matches it means it is not a new one and does nothing. If no match adds that appointment to the appropriate list.
	public void updateLists() {
		for(int i = 0; i < 43; i++) {
			int[] dayDate = daDays.get(i).getDate();
			for(int j = 0; j < oneTimes.size(); j++) {
				if(oneTimes.get(j).occursOn(dayDate[0], dayDate[1], dayDate[2])) {
					daDays.get(i).addAppointment(oneTimes.get(j));
				}
			}
			for(int j = 0; j < monthlies.size(); j++) {
				if(monthlies.get(j).occursOn(dayDate[0], dayDate[1], dayDate[2])) {
					daDays.get(i).addAppointment(monthlies.get(j));
				}
			}
			for(int j = 0; j < dailies.size(); j++) {
				if(dailies.get(j).occursOn(dayDate[0], dayDate[1], dayDate[2])) {
					daDays.get(i).addAppointment(dailies.get(j));
				}
			}
		}
	}
	
	//Reset the CalendarDay s according to GregorianCalendar values
	public void setCalDays() {
		for(int i = 0; i < 43; i++) {
			daDays.get(i).resetValues(true, 01, 01, 01, true);
		}
	}
	
	//Used to check if appointments on a CalendarDay match the ones in the lists
	public boolean matchAppos(Appointment a, Appointment b) {
		int[] aDate = a.getDate();
		int[] bDate = b.getDate();
		if(a.toString().equals(b.toString()) && aDate == bDate) {
			return true;
		}
		return false;
	}
	
	//This one should call update and refill the CalendarDay list
	public void nextMonth() {}
	
	//This one should call update and refill the CalendarDay list
	public void prevMonth() {}

}
