package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Phong;
import Entity.TrangThaiPhong;


/**
 * DEMO Component
 * 
 * - CardPhong
 * - ModalChuyenPhong
 */
public class Components extends JFrame {

	private JPanel contentPane;

	public Components() {
		setTitle("Demo các component và chức năng tại đây");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBackground(Color.red);
		
		// Demo card phong;
		ArrayList<Phong> dsPhongDemo = new ArrayList<Phong>();
//		dsPhongDemo.add(new Phong("P101", "Phong Thường 1", new TrangThaiPhong("111", "Còn Trống"),
//				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
//		dsPhongDemo.add(new Phong("VIP102", "Phong VIP 1", new TrangThaiPhong("222", "Đang hát"),
//				"Tầng 1,bên trái từ phải sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
//		dsPhongDemo.add(new Phong("P103", "Phong Thường 3", new TrangThaiPhong("333", "Đặt trước"),
//				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
//		dsPhongDemo.add(new Phong("P104", "Phong Thường 4", new TrangThaiPhong("111", "Còn Trống"),
//				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
//		dsPhongDemo.add(new Phong("P105", "Phong Thường 5", new TrangThaiPhong("444", "Dọn Dẹp"),
//				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));

		dsPhongDemo.forEach(ph -> {
			CardPhong cardPhong = new CardPhong(ph);
			add(cardPhong);
		});
		
		setContentPane(contentPane);
	}

}
