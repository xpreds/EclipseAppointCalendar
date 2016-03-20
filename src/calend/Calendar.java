package calend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import appoint.*;

public class Calendar extends JPanel { 
	public static ArrayList<OneTime> oneTimes = new ArrayList<OneTime>();
	public static ArrayList<Monthly> monthlies = new ArrayList<Monthly>();
	public static ArrayList<Daily> dailies = new ArrayList<Daily>();
	public static ArrayList<CalendarDay> daDays = new ArrayList<CalendarDay>();
	
	public Calendar() {
		setSize(1050, 720);
		setLayout(new GridLayout(7, 6));
		setup();
	}
	
	//In setup it should read the file and fill the Appointment lists with the info from the file
	public void setup() {
		for(int i = 0; i < 43; i++) {
			daDays.add(new CalendarDay(true, 01, 01, 01, true));
			add(daDays.get(i));
		}
		try {
			Scanner scan = new Scanner(new FileReader("appointmentsData.txt"));
			if(scan.hasNext()) {
				int totalAppos = scan.nextInt();
				scan.nextLine();
				for(int i = 0; i < totalAppos; i++) {
					String appoType = scan.next();
					int appoDay = scan.nextInt();
					int appoMonth = scan.nextInt();
					int appoYear = scan.nextInt();
					String appoDesc = scan.next();
					addAppointment(appoDay, appoMonth, appoYear, appoDesc, appoType);
					scan.nextLine();
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileWrite() { 
		try {
			FileWriter outPut = new FileWriter("appointmentsData.txt");
			int totalAppos = oneTimes.size() + monthlies.size() + dailies.size();
			outPut.write(totalAppos + "\n");
			for(int i = 0; i < oneTimes.size(); i++) {
				OneTime temp = oneTimes.get(i);
				String appo = "OneTime " + temp.getDay() + " " + temp.getMonth() + " " + temp.getYear() + " " + temp.toString();
				outPut.write(appo + "\n");
			}
			for(int i = 0; i < monthlies.size(); i++) {
				Monthly temp = monthlies.get(i);
				String appo = "Monthly " + temp.getDay() + " " + temp.getMonth() + " " + temp.getYear() + " " + temp.toString();
				outPut.write(appo + "\n");
			}
			for(int i = 0; i < dailies.size(); i++) { 
				Daily temp = dailies.get(i);
				String appo = "Daily " + temp.getDay() + " " + temp.getMonth() + " " + temp.getYear() + " " + temp.toString();
				outPut.write(appo + "\n");
			}
			outPut.close();
		} catch(IOException e) {
			
		}
	}
	
	public void addAppointment(int d, int m, int y, String desc, String t) {
		if(t.equals("OneTime")) {
			oneTimes.add(new OneTime(d, m, y, desc));
		} else if(t.equals("Monthly")) {
			monthlies.add(new Monthly(d, m, y, desc));
		} else if(t.equals("Daily")) {
			dailies.add(new Daily(d, m, y, desc));
		}
		Calendar.updateLists();
	}
	
	//Each call of update should update the four lists and rewrite the file
	//Each time a new appointment is added to a CalendarDay, the Calendar gets the appointments of that CalendarDay
	//and check if an appointment on the CalendarDay object matches any from the three lists up above.
	//If matches it means it is not a new one and does nothing. If no match adds that appointment to the appropriate list.
	public static void updateLists() {
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
			daDays.get(i).repaint();
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
