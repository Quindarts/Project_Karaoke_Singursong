
package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class Modal_ThemLoaiPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txt_MaLoaiPhong;
	private JTextField txt_TenLoaiPhong;
	private JTextField txt_SoLuongKhachToiDa;
	private JTextField txt_MoTa;
	private JTextField txt_GiaTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Modal_ThemLoaiPhong app;
			public void run() {
				try {
					Modal_ThemLoaiPhong frame = new Modal_ThemLoaiPhong();
					FlatLightLaf.setup();
					app = new Modal_ThemLoaiPhong();
					app.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Modal_ThemLoaiPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_TieuDe = new JPanel();
		pnl_TieuDe.setBackground(Color.WHITE);
		pnl_TieuDe.setBounds(26, 25, 237, 35);
		contentPane.add(pnl_TieuDe);
		pnl_TieuDe.setLayout(null);
		
		JLabel lbl_Title = new JLabel("Thêm loại phòng mới");
		lbl_Title.setBounds(0, 10, 237, 20);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pnl_TieuDe.add(lbl_Title);
		
		JPanel pnl_Anh = new JPanel();
		pnl_Anh.setBackground(Color.WHITE);
		pnl_Anh.setBounds(26, 95, 179, 234);
		contentPane.add(pnl_Anh);
		pnl_Anh.setLayout(null);
		
		JPanel Anh = new JPanel();
		Anh.setBackground(new Color(192, 192, 192));
		Anh.setBounds(0, 0, 179, 192);
		pnl_Anh.add(Anh);
		
		JButton btn_ChonAnh = new JButton("Chọn ảnh");
		btn_ChonAnh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_ChonAnh.setForeground(new Color(255, 255, 255));
		btn_ChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ChonAnh.setBackground(new Color(0, 128, 255));
		btn_ChonAnh.setBounds(0, 202, 179, 32);
		pnl_Anh.add(btn_ChonAnh);
		
		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setBackground(Color.WHITE);
		pnl_ThongTin.setBounds(224, 95, 765, 234);
		contentPane.add(pnl_ThongTin);
		pnl_ThongTin.setLayout(null);
		
		JPanel pnl_MaLoaiPhong = new JPanel();
		pnl_MaLoaiPhong.setBackground(Color.WHITE);
		pnl_MaLoaiPhong.setBounds(10, 5, 350, 25);
		pnl_ThongTin.add(pnl_MaLoaiPhong);
		pnl_MaLoaiPhong.setLayout(null);
		
		JLabel lbl_MaLoaiPhong = new JLabel("Mã loại phòng");
		lbl_MaLoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MaLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MaLoaiPhong.setBounds(0, 0, 110, 25);
		pnl_MaLoaiPhong.add(lbl_MaLoaiPhong);
		
		txt_MaLoaiPhong = new JTextField();
		txt_MaLoaiPhong.setEditable(false);
		txt_MaLoaiPhong.setBounds(125, 0, 225, 25);
		pnl_MaLoaiPhong.add(txt_MaLoaiPhong);
		txt_MaLoaiPhong.setColumns(10);
		
		JPanel pnl_TenLoaiPhong = new JPanel();
		pnl_TenLoaiPhong.setBackground(Color.WHITE);
		pnl_TenLoaiPhong.setLayout(null);
		pnl_TenLoaiPhong.setBounds(10, 50, 350, 25);
		pnl_ThongTin.add(pnl_TenLoaiPhong);
		
		JLabel lbl_TenLoaiPhong = new JLabel("Tên loại phòng");
		lbl_TenLoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TenLoaiPhong.setBounds(0, 0, 110, 25);
		pnl_TenLoaiPhong.add(lbl_TenLoaiPhong);
		
		txt_TenLoaiPhong = new JTextField();
		txt_TenLoaiPhong.setColumns(10);
		txt_TenLoaiPhong.setBounds(125, 0, 225, 25);
		pnl_TenLoaiPhong.add(txt_TenLoaiPhong);
		
		JPanel pnl_SoLuongKhachToiDa = new JPanel();
		pnl_SoLuongKhachToiDa.setBackground(Color.WHITE);
		pnl_SoLuongKhachToiDa.setLayout(null);
		pnl_SoLuongKhachToiDa.setBounds(405, 5, 350, 25);
		pnl_ThongTin.add(pnl_SoLuongKhachToiDa);
		
		JLabel lbl_SoLuongKhachToiDa = new JLabel("Số lượng khách tối đa");
		lbl_SoLuongKhachToiDa.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoLuongKhachToiDa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoLuongKhachToiDa.setBounds(0, 0, 143, 25);
		pnl_SoLuongKhachToiDa.add(lbl_SoLuongKhachToiDa);
		
		txt_SoLuongKhachToiDa = new JTextField();
		txt_SoLuongKhachToiDa.setColumns(10);
		txt_SoLuongKhachToiDa.setBounds(153, 0, 197, 25);
		pnl_SoLuongKhachToiDa.add(txt_SoLuongKhachToiDa);
		
		JPanel pnl_MoTa = new JPanel();
		pnl_MoTa.setBackground(Color.WHITE);
		pnl_MoTa.setLayout(null);
		pnl_MoTa.setBounds(405, 50, 350, 25);
		pnl_ThongTin.add(pnl_MoTa);
		
		JLabel lbl_MoTa = new JLabel("Mô tả");
		lbl_MoTa.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MoTa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MoTa.setBounds(0, 0, 110, 25);
		pnl_MoTa.add(lbl_MoTa);
		
		txt_MoTa = new JTextField();
		txt_MoTa.setColumns(10);
		txt_MoTa.setBounds(125, 0, 225, 25);
		pnl_MoTa.add(txt_MoTa);
		
		JPanel pnl_GiaTien = new JPanel();
		pnl_GiaTien.setLayout(null);
		pnl_GiaTien.setBackground(Color.WHITE);
		pnl_GiaTien.setBounds(10, 95, 350, 25);
		pnl_ThongTin.add(pnl_GiaTien);
		
		JLabel lbl_GiaiTien = new JLabel("Giá tiền");
		lbl_GiaiTien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_GiaiTien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_GiaiTien.setBounds(0, 0, 110, 25);
		pnl_GiaTien.add(lbl_GiaiTien);
		
		txt_GiaTien = new JTextField();
		txt_GiaTien.setColumns(10);
		txt_GiaTien.setBounds(125, 0, 225, 25);
		pnl_GiaTien.add(txt_GiaTien);
		
		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Luu.setBounds(733, 351, 90, 30);
		contentPane.add(btn_Luu);
		
		JButton btn_BoQua = new JButton("Bỏ qua");
		btn_BoQua.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_BoQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_BoQua.setBounds(836, 351, 90, 30);
		contentPane.add(btn_BoQua);
	}
}
