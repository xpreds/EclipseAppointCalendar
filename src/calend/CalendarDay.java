package calend;

import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import appoint.*;

public class CalendarDay extends JComponent { 
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	private int day;
	private int month;
	private int year;
	private boolean draww = false;
	private boolean today = false; //If today create a new border or something special to indicate so.
	private JButton addButton = new JButton("+");
	private JTextArea texAre = new JTextArea();
	private JScrollPane scrolPan = null;
	
	public CalendarDay(boolean b, int d, int m, int y, boolean t) {
		setPreferredSize(new Dimension(160, 120));
		setLayout(new BorderLayout());
		day = d;
		month = m;
		year = y;
		draww = b;
		today = t;
		texAre.setEditable(false);
		appoText();
		setupComponent();
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	public void setupComponent() {
		addButton.setBounds(2, 2, 150, 28);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailsFrame df = new detailsFrame(day, month, year);
			}
		});
		add(addButton, BorderLayout.PAGE_START);
		appoText();
		scrolPan = new JScrollPane(texAre);
		scrolPan.setPreferredSize(new Dimension(160, 90));
		add(scrolPan, BorderLayout.CENTER);
	}
	
	public void resetValues(boolean b, int d, int m, int y, boolean t) {
		day = d;
		month = m;
		year = y;
		draww = b;
		today = t;
		appointments.clear();
	}
	
	
	public void addAppointment(Appointment appo) {
		appointments.add(appo);
	}
	
	public void appoText() {
		String appoDesc = "";
		for(int i = 0; i < appointments.size(); i++) {
			appoDesc = appoDesc + appointments.get(i).toString() + "\n";
		}
		//System.out.println(appointments.size() + " size of appoints in calendarday");
		//System.out.println(appoDesc + " calendarday appodesc");
		texAre.setText(appoDesc);
		/*scrolPan = new JScrollPane(texAre);
		scrolPan.setPreferredSize(new Dimension(160, 90));
		add(scrolPan, BorderLayout.CENTER);*/
	}
	
	public int[] getDate() {
		int[] d = new int[] {day, month, year};
		return d;
	}
	
	public ArrayList<Appointment> getAppos() {
		return appointments;
	}
}
