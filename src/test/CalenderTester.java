package test;

import javax.swing.JFrame;
import calend.Calendar;
import calend.CalendarDay;

public class CalenderTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame("The Kaan Calendar");
		Calendar myCal = new Calendar();
		//CalendarDay cald = new CalendarDay(true, 01, 01, 01);
		frame.add(myCal);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
