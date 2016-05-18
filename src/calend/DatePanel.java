package calend;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.GregorianCalendar;

public class DatePanel extends JPanel {
	int year = 0;
	int day = 0;
	int month = 0;
	int[] daDate = new int[3];
	JButton prevMonth = new JButton("Previous Month");
	JButton nextMonth = new JButton("Next Month");
	JLabel monthYear = new JLabel();
	
	public DatePanel() {
		setSize(new Dimension(1050, 120));
		setLayout(new BorderLayout());
		setup();
	}
	
	class daContainer extends JComponent {
		public daContainer() {
		}
		
		public void paintComponent(Graphics g) {
			containSet();
		}
		public void containSet() {
			prevMonth.setBounds(20, 20, 200, 80);
			nextMonth.setBounds(830, 20, 200, 80);
			prevMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CalendarPanel.prevMonth();
				}
			});
			nextMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CalendarPanel.nextMonth();
				}
			});
			monthYear.setBounds(400, 20, 200, 80);
			add(prevMonth, BorderLayout.CENTER);
			add(nextMonth, BorderLayout.CENTER);
			add(monthYear, BorderLayout.CENTER);
		}
		
	}
	
	//This method is for the setup of the graphics of this JPanel
	public void setup() {
		add(new daContainer());
	}
	
	//This method updates the date using the data from the GregorianCalendar, also updates the JLabel
	public void update() {
		
	}
	
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public int[] getDate() {
		return daDate;
	}

}
