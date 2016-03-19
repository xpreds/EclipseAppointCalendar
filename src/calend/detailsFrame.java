package calend;

import javax.swing.JFrame;
import javax.swing.JComboBox; //To choose type of Appointment: Onetime, Daily, Monthly
import javax.swing.JTextArea; //To enter description of appointment
import javax.swing.JSpinner; //To enter date
import javax.swing.JButton; //For the "Add Appointment" button
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class detailsFrame extends JFrame implements ActionListener {
	public detailsFrame() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e) {}

}
