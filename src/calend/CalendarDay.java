package calend;

import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import appoint.*;

public class CalendarDay extends JComponent implements ActionListener { 
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	private int day;
	private int month;
	private int year;
	private boolean draww = false;
	private boolean today = false; //If today create a new brder or something special to indicate so.
	
	public CalendarDay(boolean b, int d, int m, int y, boolean t) {
		setPreferredSize(new Dimension(120, 120));
		day = d;
		month = m;
		year = y;
		draww = b;
		today = t;
	}
	
	private void createMe() {
		if(draww) {
			add(new JButton());
		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("How are you", 100, 100);
	}
	
	public void resetValues(boolean b, int d, int m, int y, boolean t) {
		day = d;
		month = m;
		year = y;
		draww = b;
		today = t;
	}
	
	public void addAppointment(int d, int m, int y, int t) {
		if(t == 0) {
			appointments.add(new OneTime(d, m, y));
		} else if(t == 1) {
			appointments.add(new Monthly(d, m, y));
		} else if(t == 2) {
			appointments.add(new Daily(d, m, y));
		}
	}
	public void addAppointment(Appointment appo) {
		appointments.add(appo);
	}
	
	public int[] getDate() {
		int[] d = new int[] {day, month, year};
		return d;
	}
	
	public void actionPerformed(ActionEvent e) {}
	
	public ArrayList<Appointment> getAppos() {
		return appointments;
	}

}
