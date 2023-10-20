package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.ConnectDB;
import Entity.Phong;
import Entity.TrangThaiPhong;
import OtherFunction.HelpXLSX;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private JFrame_DangNhap app;

			public void run() {
				try {
					FlatLightLaf.setup();
					UploadImg upload = new UploadImg();
					main frame = new main();
					app = new JFrame_DangNhap();
					app.setVisible(true);
					// Demo card phong;
					ArrayList<Phong> dsPhongDemo = new ArrayList<Phong>();
					dsPhongDemo.add(new Phong("P101", "Phong Thường 1", new TrangThaiPhong("111", "Còn Trống"),
							"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
					dsPhongDemo.add(new Phong("VIP102", "Phong VIP 1", new TrangThaiPhong("222", "Đang hát"),
							"Tầng 1,bên trái từ phải sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
					dsPhongDemo.add(new Phong("P103", "Phong Thường 3", new TrangThaiPhong("333", "Đặt trước"),
							"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
					dsPhongDemo.add(new Phong("P104", "Phong Thường 4", new TrangThaiPhong("111", "Còn Trống"),
							"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
					dsPhongDemo.add(new Phong("P105", "Phong Thường 5", new TrangThaiPhong("444", "Dọn Dẹp"),
							"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));

					dsPhongDemo.forEach(ph -> {
						CardPhong cardPhong = new CardPhong(ph);
						
						frame.add(cardPhong);
					});
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
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBackground(Color.red);

		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
