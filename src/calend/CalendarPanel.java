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

public class CalendarPanel extends JPanel { 
	public static ArrayList<OneTime> oneTimes = new ArrayList<OneTime>();
	public static ArrayList<Monthly> monthlies = new ArrayList<Monthly>();
	public static ArrayList<Daily> dailies = new ArrayList<Daily>();
	public static ArrayList<CalendarDay> daDays = new ArrayList<CalendarDay>();
	
	public CalendarPanel() {
		setSize(1050, 720);
		setLayout(new GridLayout(7, 6));
		setup();
	}
	
	//In setup it should read the file and fill the Appointment lists with the info from the file
	public void setup() {
		for(int i = 0; i < 43; i++) {
			daDays.add(new CalendarDay(true, 01, 1, 2016, true));
			add(daDays.get(i));  //This line puts the CalendarDays on this JPanel
		}
		//This try catch block reads the appointmentsData.txt file, creates appointments according to the info
		//and fills up the ArrayLists in this class.
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
					String appoDesc = scan.nextLine();
					addAppointment(appoDay, appoMonth, appoYear, appoDesc, appoType);
				}
				System.out.println(oneTimes.size() + "onetimes.size()");
				System.out.println(monthlies.size() + "monthlies.size()");
				System.out.println(dailies.size() + " dailies.size()");
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateLists();
	}
	
	//This method takes the info from each ArrayList in this class and writes their data to the appointmentsData.txt file
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
	
	//This method creates new Appointments in the given type
	public void addAppointment(int d, int m, int y, String desc, String t) {
		if(t.equals("OneTime")) {
			oneTimes.add(new OneTime(d, m, y, desc));
		} else if(t.equals("Monthly")) {
			monthlies.add(new Monthly(d, m, y, desc));
		} else if(t.equals("Daily")) {
			dailies.add(new Daily(d, m, y, desc));
		}
		updateLists();
	}
	
	//This method updates the CalendarDays according to the info in the lists in this class
	public static void updateLists() {
		for(int i = 0; i < 43; i++) {
			int[] dayDate = daDays.get(i).getDate();
			for(int j = 0; j < oneTimes.size(); j++) {
				if(oneTimes.get(j).occursOn(dayDate[0], dayDate[1], dayDate[2])) {
					boolean didMatch = false;
					ArrayList<Appointment> tempAppos = daDays.get(i).getAppos();
					for(int k = 0; k < tempAppos.size(); k++) {
						didMatch = matchAppos(oneTimes.get(j), tempAppos.get(k));
					}
					if(!didMatch) {
						daDays.get(i).addAppointment(oneTimes.get(j));
					}
				}
			}
			for(int j = 0; j < monthlies.size(); j++) {
				if(monthlies.get(j).occursOn(dayDate[0], dayDate[1], dayDate[2])) {
					boolean didMatch = false;
					ArrayList<Appointment> tempAppos = daDays.get(i).getAppos();
					for(int k = 0; k < tempAppos.size(); k++) {
						didMatch = matchAppos(monthlies.get(j), tempAppos.get(k));
					}
					if(!didMatch) {
						daDays.get(i).addAppointment(monthlies.get(j));
					}
				}
			}
			for(int j = 0; j < dailies.size(); j++) {
				if(dailies.get(j).occursOn(dayDate[0], dayDate[1], dayDate[2])) {
					boolean didMatch = false;
					ArrayList<Appointment> tempAppos = daDays.get(i).getAppos();
					for(int k = 0; k < tempAppos.size(); k++) {
						didMatch = matchAppos(dailies.get(j), tempAppos.get(k));
					}
					if(!didMatch) {
						daDays.get(i).addAppointment(dailies.get(j));
					}
				}
			}
			daDays.get(i).appoText();
		}
	}
	
	//Reset the CalendarDay s according to GregorianCalendar values
	public void setCalDays() {
		for(int i = 0; i < 43; i++) {
			daDays.get(i).resetValues(true, 01, 01, 01, true);
		}
	}
	
	//Used to check if appointments on a CalendarDay match the ones in the lists
	public static boolean matchAppos(Appointment a, Appointment b) {
		int[] aDate = a.getDate();
		int[] bDate = b.getDate();
		if(a.toString().equals(b.toString()) && aDate == bDate) {
			return true;
		}
		return false;
	}
	
	//This one should call update and refill the CalendarDay list
	public static void nextMonth() {}
	
	//This one should call update and refill the CalendarDay list
	public static void prevMonth() {}

}
