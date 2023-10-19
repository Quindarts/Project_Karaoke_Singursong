package GUI;

import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.ConnectDB;
import OtherFunction.HelpXLSX;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Connect Theme Flat
					FlatLightLaf.setup();
					UploadImg	upload = new UploadImg();
					// Show frame
					main frame = new main();
					frame.setVisible(true);
					upload.setVisible(true);

					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
