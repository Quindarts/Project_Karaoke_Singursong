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

public class ClockForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockForm frame = new ClockForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClockForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClock = new JLabel("00:00:00");
		lblClock.setForeground(new Color(0, 0, 255));
		lblClock.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setBounds(117, 92, 220, 45);
		contentPane.add(lblClock);
		Clock();
	}
	
	private void Clock() {
		new Thread() {
			public void run() {
				while(true) {
					Calendar ca = new GregorianCalendar();
					int hour = ca.get(Calendar.HOUR);
					int min = ca.get(Calendar.MINUTE);
					int sec = ca.get(Calendar.SECOND);
					int AM_PM = ca.get(Calendar.AM_PM);
					
					if(AM_PM == 1) {
						hour = hour + 12;
						if(hour == 24) {
							hour = 0;
						}
					}
					lblClock.setText(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec)  );
				}
			}
		}.start();
	}
}
