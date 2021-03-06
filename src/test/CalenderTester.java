/* Places that influenced me
 * http://stackoverflow.com/questions/8211053/how-to-detect-the-jframe-is-closed
 * http://stackoverflow.com/questions/2902101/how-to-set-jspinner-as-non-editable
 * https://docs.oracle.com/javase/tutorial/uiswing/events/changelistener.html
 * https://docs.oracle.com/javase/tutorial/uiswing/events/windowlistener.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/spinner.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/textarea.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html
 * https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
 */

package test;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import calend.*;

public class CalenderTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame("The Kaan Calendar");
		CalendarPanel myCal = new CalendarPanel();
		DatePanel myDate = new DatePanel();
		frame.getContentPane().add(myCal, BorderLayout.PAGE_END);
		//frame.getContentPane().add(myDate, BorderLayout.PAGE_START);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
