package calend;

import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import appoint.*;

public class CalendarDay extends JComponent implements MouseListener { 
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	private int day;
	private int month;
	private int year;
	private boolean draww = false;
	private boolean today = false; //If today create a new brder or something special to indicate so.
	private JButton addButton = new JButton("+");
	
	public CalendarDay(boolean b, int d, int m, int y, boolean t) {
		setPreferredSize(new Dimension(160, 120));
		setLayout(new BorderLayout());
		day = d;
		month = m;
		year = y;
		draww = b;
		today = t;
	}
	
	public void paintComponent(Graphics g) {
		String appoDesc = "";
		addButton.setBounds(2, 2, 150, 28);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailsFrame df = new detailsFrame(day, month, year);
			}
		});
		add(addButton, BorderLayout.PAGE_START);
		
		JTextArea texAre = new JTextArea();
		texAre.setEditable(false);
		texAre.setText(appoText());
		JScrollPane scrolPan = new JScrollPane(texAre);
		scrolPan.setPreferredSize(new Dimension(160, 90));
		add(scrolPan, BorderLayout.CENTER);
	}
	
	public void resetValues(boolean b, int d, int m, int y, boolean t) {
		day = d;
		month = m;
		year = y;
		draww = b;
		today = t;
	}
	
	
	public void addAppointment(Appointment appo) {
		appointments.add(appo);
	}
	
	public String appoText() {
		String appoDesc = "";
		for(int i = 0; i < appointments.size(); i++) {
			appoDesc = appoDesc + appointments.get(i).toString() + "\n";
		}
		return appoDesc;
	}
	
	public int[] getDate() {
		int[] d = new int[] {day, month, year};
		return d;
	}
	
	public ArrayList<Appointment> getAppos() {
		return appointments;
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}
