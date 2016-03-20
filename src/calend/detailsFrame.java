package calend;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox; //To choose type of Appointment: Onetime, Daily, Monthly
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea; //To enter description of appointment
import javax.swing.SpinnerListModel;
import javax.swing.JSpinner; //To enter date
import javax.swing.JButton; //For the "Add Appointment" button
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import appoint.Daily;
import appoint.Monthly;
import appoint.OneTime;
import appoint.Appointment;

public class detailsFrame extends JFrame {
	public int day;
	public int month;
	public int year;
	public String type;
	public String desc = "";
	private Appointment appoint;
	public detailsFrame(int d, int m, int y) {
		setSize(400, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		add(new daContainer(d, m));
		repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	class daContainer extends JComponent {
		int d;
		int m;
		public daContainer(int d, int m) {
			this.d = d;
			this.m = m;
		}
		public void paintComponent(Graphics g) {
			JLabel typeLab = new JLabel("Type");
			typeLab.setBounds(5, 5, 180, 40);
			JLabel dayLab = new JLabel("Day");
			dayLab.setBounds(5, 88, 180, 40);
			JLabel monthLab = new JLabel("Month");
			monthLab.setBounds(5, 191, 180, 40);
			JLabel yearLab = new JLabel("Year");
			yearLab.setBounds(5, 274, 180, 40);
			JLabel descLab = new JLabel("Description");
			descLab.setBounds(190, 5, 195, 40);
			
			
			String[] typeList = new String[] {"One Time", "Monthly", "Daily"};
			JComboBox typeBox = new JComboBox(typeList);
			typeBox.setBounds(5, 45, 180, 40);
			JTextArea descArea = new JTextArea();
			descArea.setBounds(190, 45, 195, 315);
			Integer[] days = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 ,18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
			JComboBox dayBox = new JComboBox(days);
			dayBox.setBounds(5, 128, 180, 40);
			dayBox.setSelectedIndex(d-1);
			String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			SpinnerListModel monthModel = new SpinnerListModel(months);
			JSpinner monthSpin = new JSpinner(monthModel);
			monthSpin.setBounds(5, 231, 180, 40);
			((JSpinner.DefaultEditor) monthSpin.getEditor()).getTextField().setEditable(false);
			monthSpin.setValue(monthConv(m));
			Integer[] years = new Integer[] {2016, 2017, 2018, 2019, 2020};
			JComboBox yearBox = new JComboBox(years);
			yearBox.setBounds(5, 314, 180, 40);
			yearBox.setSelectedIndex(0);
			
			JButton addButton = new JButton("Add Appointment");
			addButton.setBounds(0, 360, 300, 50);
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					day = (int)dayBox.getSelectedItem();
					month = monthConv((String)monthSpin.getValue());
					year = (int)yearBox.getSelectedItem();
					type = (String)typeBox.getSelectedItem();
					desc = (String)descArea.getText();
					addAppointment(day, month, year, desc, type);
					System.out.println("detailsFrame addButton actionListener run");
				}
			});
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(300, 360, 100, 50);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			add(typeBox);
			add(dayBox);
			add(monthSpin);
			add(yearBox);
			add(descArea);
			add(addButton);
			add(cancelButton);
			add(typeLab);
			add(dayLab);
			add(monthLab);
			add(yearLab);
			add(descLab);
		}
	}
	
	public void addAppointment(int d, int m, int y, String desc, String t) {
		System.out.println(t + " type used in addappointmetn");
		if(t.equals("One Time")) {
			Calendar.oneTimes.add(new OneTime(d, m, y, desc));
		} else if(t.equals("Monthly")) {
			Calendar.monthlies.add(new Monthly(d, m, y, desc));
		} else if(t.equals("Daily")) {
			Calendar.dailies.add(new Daily(d, m, y, desc));
		}
		Calendar.updateLists();
		System.out.println(Calendar.oneTimes.size() + "onetimes size");
		Calendar.fileWrite();
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
	public int monthConv(String m) {
		switch(m) { 
			case "January": return 1;
			case "February": return 2;
			case "March": return 3;
			case "April": return 4;
			case "May": return 5;
			case "June": return 6;
			case "July":return 7;
			case "August": return 8;
			case "September": return 9;
			case "October": return 10;
			case "November": return 11;
			case "December": return 12;
			default: return 1;
		}
	}
}
