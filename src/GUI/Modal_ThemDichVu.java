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

public class Modal_ThemDichVu extends JFrame {

	private JPanel contentPane;
	private JTextField txt_MaDichVu;
	private JTextField txt_TenDichVu;
	private JTextField txt_DonGia;
	private JTextField txt_DonViTinh;
	private JTextField txt_SoLuong;
	private JTextField txt_TrangThai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Modal_ThemDichVu app;

			public void run() {
				try {
					Modal_ThemDichVu frame = new Modal_ThemDichVu();
					FlatLightLaf.setup();
					app = new Modal_ThemDichVu();
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
	public Modal_ThemDichVu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnl_TieuDe = new JPanel();
		pnl_TieuDe.setBackground(Color.WHITE);
		pnl_TieuDe.setBounds(80, 37, 237, 35);
		contentPane.add(pnl_TieuDe);
		pnl_TieuDe.setLayout(null);

		JLabel lbl_Title = new JLabel("Thêm dịch vụ mới");
		lbl_Title.setBounds(0, 10, 237, 20);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pnl_TieuDe.add(lbl_Title);

		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setBackground(Color.WHITE);
		pnl_ThongTin.setBounds(80, 102, 765, 150);
		contentPane.add(pnl_ThongTin);
		pnl_ThongTin.setLayout(null);

		JPanel pnl_MaDichVu = new JPanel();
		pnl_MaDichVu.setBackground(Color.WHITE);
		pnl_MaDichVu.setBounds(10, 5, 350, 25);
		pnl_ThongTin.add(pnl_MaDichVu);
		pnl_MaDichVu.setLayout(null);

		JLabel lbl_MaNhanVien = new JLabel("Mã dịch vụ");
		lbl_MaNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MaNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MaNhanVien.setBounds(0, 0, 110, 25);
		pnl_MaDichVu.add(lbl_MaNhanVien);

		txt_MaDichVu = new JTextField();
		txt_MaDichVu.setEditable(false);
		txt_MaDichVu.setBounds(125, 0, 225, 25);
		pnl_MaDichVu.add(txt_MaDichVu);
		txt_MaDichVu.setColumns(10);

		JPanel pnl_TenDichVu = new JPanel();
		pnl_TenDichVu.setBackground(Color.WHITE);
		pnl_TenDichVu.setLayout(null);
		pnl_TenDichVu.setBounds(10, 50, 350, 25);
		pnl_ThongTin.add(pnl_TenDichVu);

		JLabel lbl_TenDichVu = new JLabel("Tên dịch vụ");
		lbl_TenDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenDichVu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TenDichVu.setBounds(0, 0, 110, 25);
		pnl_TenDichVu.add(lbl_TenDichVu);

		txt_TenDichVu = new JTextField();
		txt_TenDichVu.setColumns(10);
		txt_TenDichVu.setBounds(125, 0, 225, 25);
		pnl_TenDichVu.add(txt_TenDichVu);

		JPanel pnl_DonGia = new JPanel();
		pnl_DonGia.setBackground(Color.WHITE);
		pnl_DonGia.setLayout(null);
		pnl_DonGia.setBounds(405, 5, 350, 25);
		pnl_ThongTin.add(pnl_DonGia);

		JLabel lbl_DonGia = new JLabel("Đơn giá");
		lbl_DonGia.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DonGia.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_DonGia.setBounds(0, 0, 110, 25);
		pnl_DonGia.add(lbl_DonGia);

		txt_DonGia = new JTextField();
		txt_DonGia.setColumns(10);
		txt_DonGia.setBounds(125, 0, 225, 25);
		pnl_DonGia.add(txt_DonGia);

		JPanel pnl_DonViTinh = new JPanel();
		pnl_DonViTinh.setBackground(Color.WHITE);
		pnl_DonViTinh.setLayout(null);
		pnl_DonViTinh.setBounds(405, 50, 350, 25);
		pnl_ThongTin.add(pnl_DonViTinh);

		JLabel lbl_DonViTinh = new JLabel("Đơn vị tính");
		lbl_DonViTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DonViTinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_DonViTinh.setBounds(0, 0, 110, 25);
		pnl_DonViTinh.add(lbl_DonViTinh);

		txt_DonViTinh = new JTextField();
		txt_DonViTinh.setColumns(10);
		txt_DonViTinh.setBounds(125, 0, 225, 25);
		pnl_DonViTinh.add(txt_DonViTinh);

		JPanel pnl_SoLuong = new JPanel();
		pnl_SoLuong.setBackground(Color.WHITE);
		pnl_SoLuong.setLayout(null);
		pnl_SoLuong.setBounds(405, 95, 350, 25);
		pnl_ThongTin.add(pnl_SoLuong);

		JLabel lbl_SoLuong = new JLabel("Số lượng");
		lbl_SoLuong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoLuong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoLuong.setBounds(0, 0, 110, 25);
		pnl_SoLuong.add(lbl_SoLuong);

		txt_SoLuong = new JTextField();
		txt_SoLuong.setColumns(10);
		txt_SoLuong.setBounds(125, 0, 225, 25);
		pnl_SoLuong.add(txt_SoLuong);

		JPanel pnl_TrangThai = new JPanel();
		pnl_TrangThai.setLayout(null);
		pnl_TrangThai.setBackground(Color.WHITE);
		pnl_TrangThai.setBounds(10, 95, 350, 25);
		pnl_ThongTin.add(pnl_TrangThai);

		JLabel lbl_TrangThai = new JLabel("Trạng thái");
		lbl_TrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TrangThai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TrangThai.setBounds(0, 0, 110, 25);
		pnl_TrangThai.add(lbl_TrangThai);

		txt_TrangThai = new JTextField();
		txt_TrangThai.setColumns(10);
		txt_TrangThai.setBounds(125, 0, 225, 25);
		pnl_TrangThai.add(txt_TrangThai);

		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setBounds(616, 288, 95, 30);
		contentPane.add(btn_Luu);

		JButton btn_BoQua = new JButton("Bỏ qua");
		btn_BoQua.setBounds(721, 288, 95, 30);
		contentPane.add(btn_BoQua);
	}
}