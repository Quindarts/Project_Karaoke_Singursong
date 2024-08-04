package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class JFrame_Loading extends JFrame {

	private JPanel contentPane;
	protected JProgressBar progressBar;

	/**
	 * Color
	 */

	private String hexColor_Blue1 = "#054A91";

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JFrame_Loading() {

		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(hexColor_Blue1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_ImgLoading = new JLabel("");
		lbl_ImgLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ImgLoading.setIcon(new ImageIcon(JFrame_Loading.class.getResource("/icon/Logo_Blue.png")));
		lbl_ImgLoading.setBounds(10, 11, 854, 504);
		contentPane.add(lbl_ImgLoading);

		progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.decode(hexColor_Blue2));
		progressBar.setBackground(Color.decode(hexColor_Blue1));
		progressBar.setBounds(0, 537, 874, 23);
		progressBar.setBorder(null);
		contentPane.add(progressBar);

		JLabel lblNewLabel = new JLabel("12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, TP.HCM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 393, 854, 42);
		contentPane.add(lblNewLabel);
	}

	public void updateProgress(int value) {
		progressBar.setValue(value);
	}
}
