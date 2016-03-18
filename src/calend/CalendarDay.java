package calend;

import javax.swing.JPanel;
import java.util.ArrayList;
import appoint.Appointment;

public class CalendarDay extends JPanel { 
	ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	private int day;
	private int month;
	private int year;
	
	public CalendarDay(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	

}
