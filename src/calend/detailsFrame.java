package calend;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox; //To choose type of Appointment: Onetime, Daily, Monthly
import javax.swing.JTextArea; //To enter description of appointment
import javax.swing.SpinnerListModel;
import javax.swing.JSpinner; //To enter date
import javax.swing.JButton; //For the "Add Appointment" button
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import appoint.Daily;
import appoint.Monthly;
import appoint.OneTime;
import appoint.Appointment;

public class detailsFrame extends JFrame {
	private boolean clicked = false;
	public int day;
	public int month;
	public int year;
	public int type;
	public String desc = "";
	private Appointment appoint;
	public detailsFrame(int d, int m, int y) {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setup(d, monthConv(m), y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setup(int d, String m, int y) {
		JButton addButton = new JButton("Add Appointment");
		addButton.setBounds(0, 350, 400, 50);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel type = new JLabel("Type");
		type.setBounds(5, 5, 195, 40);
		JComboBox types = new JComboBox();
		
		Integer[] days = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 ,18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		JLabel dayLab = new JLabel("Day");
		dayLab.setBounds(5, 88, 195, 40);
		JComboBox dayBox = new JComboBox(days);
		dayBox.setBounds(5, 128, 195, 40);
		dayBox.setSelectedIndex(d-1);
		
		String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		JLabel monthLab = new JLabel("Month");
		monthLab.setBounds(5, 191, 195, 40);
		SpinnerListModel monthModel = new SpinnerListModel(months);
		JSpinner monthSpin = new JSpinner(monthModel);
		monthSpin.setBounds(5, 231, 195, 40);
		monthSpin.setValue(m);
		
		Integer[] years = new Integer[] {2016, 2017, 2018, 2019, 2020};
		JLabel yearLab = new JLabel("Year");
		yearLab.setBounds(5, 274, 195, 40);
		JComboBox yearBox = new JComboBox(years);
		yearBox.setBounds(5, 314, 195, 40);
		yearBox.setSelectedIndex(0);
		
		add(addButton);
		add(dayLab);
		add(monthLab);
		add(yearLab);
		add(types);
		add(dayBox);
		add(monthSpin);
		add(yearBox);
	}
	
	
	
	public String monthConv(int m) {
		switch (m) {
			case 1: return "January";
			case 2: return "February";
			case 3: return "March";
			case 4: return "April";
			case 5: return "May";
			case 6: return "June";
			case 7: return "July";
			case 8: return "August";
			case 9: return "September";
			case 10: return "October";
			case 11: return "November";
			case 12: return "December";
			default: return Integer.toString(m);
		}
	}
	
	public boolean isClicked() {
		return clicked;
	}
	
	public Appointment getAppo() {
		return appoint;
	}
}
