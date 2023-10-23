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
import com.toedter.calendar.JDateChooser;

public class Modal_ThemNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txt_MaNhanVien;
	private JTextField txt_TenNhanVien;
	private JTextField txt_SoDienThoai;
	private JTextField txt_DiaChi;
	private JTextField txt_CCCD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Modal_ThemNhanVien app;
			public void run() {
				try {
					Modal_ThemNhanVien frame = new Modal_ThemNhanVien();
					FlatLightLaf.setup();
					app = new Modal_ThemNhanVien();
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
	public Modal_ThemNhanVien() {
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
		
		JLabel lbl_Title = new JLabel("Thêm nhân viên mới");
		lbl_Title.setBounds(0, 10, 237, 20);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pnl_TieuDe.add(lbl_Title);
		
		JPanel pnl_Anh = new JPanel();
		pnl_Anh.setBackground(Color.WHITE);
		pnl_Anh.setBounds(26, 70, 179, 234);
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
		pnl_ThongTin.setBounds(224, 70, 765, 234);
		contentPane.add(pnl_ThongTin);
		pnl_ThongTin.setLayout(null);
		
		JPanel pnl_MaNhanVien = new JPanel();
		pnl_MaNhanVien.setBackground(Color.WHITE);
		pnl_MaNhanVien.setBounds(10, 5, 350, 25);
		pnl_ThongTin.add(pnl_MaNhanVien);
		pnl_MaNhanVien.setLayout(null);
		
		JLabel lbl_MaNhanVien = new JLabel("Mã nhân viên");
		lbl_MaNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MaNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MaNhanVien.setBounds(0, 0, 110, 25);
		pnl_MaNhanVien.add(lbl_MaNhanVien);
		
		txt_MaNhanVien = new JTextField();
		txt_MaNhanVien.setEditable(false);
		txt_MaNhanVien.setBounds(125, 0, 225, 25);
		pnl_MaNhanVien.add(txt_MaNhanVien);
		txt_MaNhanVien.setColumns(10);
		
		JPanel pnl_ChucVu = new JPanel();
		pnl_ChucVu.setBackground(Color.WHITE);
		pnl_ChucVu.setLayout(null);
		pnl_ChucVu.setBounds(405, 5, 350, 25);
		pnl_ThongTin.add(pnl_ChucVu);
		
		JLabel lbl_ChucVu = new JLabel("Chức vụ");
		lbl_ChucVu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ChucVu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_ChucVu.setBounds(0, 0, 110, 25);
		pnl_ChucVu.add(lbl_ChucVu);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(125, 0, 225, 25);
		pnl_ChucVu.add(comboBox_1);
		
		JPanel pnl_TenNhanVien = new JPanel();
		pnl_TenNhanVien.setBackground(Color.WHITE);
		pnl_TenNhanVien.setLayout(null);
		pnl_TenNhanVien.setBounds(10, 50, 350, 25);
		pnl_ThongTin.add(pnl_TenNhanVien);
		
		JLabel lbl_TenNhanVien = new JLabel("Tên nhân viên");
		lbl_TenNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TenNhanVien.setBounds(0, 0, 110, 25);
		pnl_TenNhanVien.add(lbl_TenNhanVien);
		
		txt_TenNhanVien = new JTextField();
		txt_TenNhanVien.setColumns(10);
		txt_TenNhanVien.setBounds(125, 0, 225, 25);
		pnl_TenNhanVien.add(txt_TenNhanVien);
		
		JPanel pnl_NgaySinh = new JPanel();
		pnl_NgaySinh.setBackground(Color.WHITE);
		pnl_NgaySinh.setLayout(null);
		pnl_NgaySinh.setBounds(10, 95, 350, 25);
		pnl_ThongTin.add(pnl_NgaySinh);
		
		JLabel lbl_NgaySinh = new JLabel("Ngày sinh");
		lbl_NgaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_NgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_NgaySinh.setBounds(0, 0, 110, 25);
		pnl_NgaySinh.add(lbl_NgaySinh);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(125, 0, 225, 25);
		pnl_NgaySinh.add(dateChooser);
		
		JPanel pnl_GioiTinh = new JPanel();
		pnl_GioiTinh.setBackground(Color.WHITE);
		pnl_GioiTinh.setLayout(null);
		pnl_GioiTinh.setBounds(10, 140, 350, 25);
		pnl_ThongTin.add(pnl_GioiTinh);
		
		JLabel lbl_GioiTinh = new JLabel("Giới tính");
		lbl_GioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_GioiTinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_GioiTinh.setBounds(0, 0, 110, 25);
		pnl_GioiTinh.add(lbl_GioiTinh);
		
		JRadioButton rdbtn_Nam = new JRadioButton("Nam");
		rdbtn_Nam.setBackground(Color.WHITE);
		rdbtn_Nam.setBounds(125, 0, 50, 25);
		pnl_GioiTinh.add(rdbtn_Nam);
		
		JRadioButton rdbtn_Nu = new JRadioButton("Nữ");
		rdbtn_Nu.setBackground(Color.WHITE);
		rdbtn_Nu.setBounds(190, 0, 50, 25);
		pnl_GioiTinh.add(rdbtn_Nu);
		
		JPanel pnl_TrangThai = new JPanel();
		pnl_TrangThai.setBackground(Color.WHITE);
		pnl_TrangThai.setLayout(null);
		pnl_TrangThai.setBounds(10, 185, 350, 25);
		pnl_ThongTin.add(pnl_TrangThai);
		
		JLabel lbl_TrangThai = new JLabel("Trạng thái");
		lbl_TrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TrangThai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TrangThai.setBounds(0, 0, 110, 25);
		pnl_TrangThai.add(lbl_TrangThai);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(125, 0, 225, 25);
		pnl_TrangThai.add(comboBox);
		
		JPanel pnl_SoDienThoai = new JPanel();
		pnl_SoDienThoai.setBackground(Color.WHITE);
		pnl_SoDienThoai.setLayout(null);
		pnl_SoDienThoai.setBounds(405, 50, 350, 25);
		pnl_ThongTin.add(pnl_SoDienThoai);
		
		JLabel lbl_SoDienThoai = new JLabel("Số điện thoại");
		lbl_SoDienThoai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoDienThoai.setBounds(0, 0, 110, 25);
		pnl_SoDienThoai.add(lbl_SoDienThoai);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setColumns(10);
		txt_SoDienThoai.setBounds(125, 0, 225, 25);
		pnl_SoDienThoai.add(txt_SoDienThoai);
		
		JPanel pnl_DiaChi = new JPanel();
		pnl_DiaChi.setBackground(Color.WHITE);
		pnl_DiaChi.setLayout(null);
		pnl_DiaChi.setBounds(405, 95, 350, 25);
		pnl_ThongTin.add(pnl_DiaChi);
		
		JLabel lbl_DiaChi = new JLabel("Địa chỉ");
		lbl_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_DiaChi.setBounds(0, 0, 110, 25);
		pnl_DiaChi.add(lbl_DiaChi);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setColumns(10);
		txt_DiaChi.setBounds(125, 0, 225, 25);
		pnl_DiaChi.add(txt_DiaChi);
		
		JPanel pnl_CCCD = new JPanel();
		pnl_CCCD.setBackground(Color.WHITE);
		pnl_CCCD.setLayout(null);
		pnl_CCCD.setBounds(405, 140, 350, 25);
		pnl_ThongTin.add(pnl_CCCD);
		
		JLabel lbl_CCCD = new JLabel("Số CCCD");
		lbl_CCCD.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CCCD.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_CCCD.setBounds(0, 0, 110, 25);
		pnl_CCCD.add(lbl_CCCD);
		
		txt_CCCD = new JTextField();
		txt_CCCD.setColumns(10);
		txt_CCCD.setBounds(125, 0, 225, 25);
		pnl_CCCD.add(txt_CCCD);
		
		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setBounds(749, 346, 95, 25);
		contentPane.add(btn_Luu);
		
		JButton btn_BoQua = new JButton("Bỏ qua");
		btn_BoQua.setBounds(867, 346, 95, 25);
		contentPane.add(btn_BoQua);
	}
}