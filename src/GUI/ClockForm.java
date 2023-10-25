package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.SystemColor;

public class ClockForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblClock;
	private JLabel lblDay;
	private int hour, min,sec;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ClockForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 100, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClock = new JLabel("00:00:00");
		lblClock.setBackground(new Color(255, 255, 255));
		lblClock.setForeground(SystemColor.textHighlight);
		lblClock.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setBounds(10, 91, 220, 79);
		contentPane.add(lblClock);
		
		lblDay = new JLabel("00/00/0000");
		lblDay.setForeground(SystemColor.textInactiveText);
		lblDay.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(10, 10, 159, 45);
		contentPane.add(lblDay);
		Clock();
	}
	
	private void Clock() {
		new Thread() {
			public void run() {
				while(true) {
					Calendar ca = new GregorianCalendar();
					hour = ca.get(Calendar.HOUR);
					min = ca.get(Calendar.MINUTE);
					sec = ca.get(Calendar.SECOND);
					int AM_PM = ca.get(Calendar.AM_PM);

					int day = ca.get(Calendar.DAY_OF_MONTH);
					int month = ca.get(Calendar.MONTH);
					int year = ca.get(Calendar.YEAR);
					
					if(AM_PM == 1) {
						hour = hour + 12;
						if(hour == 24) {
							hour = 0;
						}
					}
					lblDay.setText(day + "/" + month + "/" + year);
					lblClock.setText(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec)  );
				}
			}
		}.start();
	}
}
