package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class JDialog_XemThongDichVu extends JFrame {

	private JPanel contentPane;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	private final DecimalFormat dcf = new DecimalFormat("#,##0 VND");

	private JLabel lbl_DonGia;

	private JLabel lbl_TrangThai;

	private JTextArea txt_MoTa;

	private JLabel lbl_SoLuongTon;

	private JLabel lbl_DonViTinh;

	private JLabel lbl_TenDichVu;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JDialog_XemThongDichVu() {
		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JDialog_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setBounds(100, 100, 280, 294);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnl_TenPhong = new JPanel();
		pnl_TenPhong.setLayout(null);
		pnl_TenPhong.setBackground(Color.WHITE);
		pnl_TenPhong.setBounds(10, 50, 233, 20);
		contentPane.add(pnl_TenPhong);

		JLabel lbl_1 = new JLabel("Tên dịch vụ");
		lbl_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1.setBounds(0, 0, 100, 20);
		pnl_TenPhong.add(lbl_1);

		lbl_TenDichVu = new JLabel("");
		lbl_TenDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TenDichVu.setBackground(Color.WHITE);
		lbl_TenDichVu.setBounds(100, 0, 133, 20);
		pnl_TenPhong.add(lbl_TenDichVu);

		JPanel pnl_ViTri = new JPanel();
		pnl_ViTri.setLayout(null);
		pnl_ViTri.setBackground(Color.WHITE);
		pnl_ViTri.setBounds(10, 110, 233, 20);
		contentPane.add(pnl_ViTri);

		JLabel lbl_1_2 = new JLabel("Đơn giá");
		lbl_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_2.setBounds(0, 0, 100, 20);
		pnl_ViTri.add(lbl_1_2);

		lbl_DonGia = new JLabel("");
		lbl_DonGia.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DonGia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_DonGia.setBounds(100, 0, 133, 20);
		pnl_ViTri.add(lbl_DonGia);

		JPanel pnl_TrangThai = new JPanel();
		pnl_TrangThai.setLayout(null);
		pnl_TrangThai.setBackground(Color.WHITE);
		pnl_TrangThai.setBounds(10, 170, 233, 20);
		contentPane.add(pnl_TrangThai);

		JLabel lbl_1_1 = new JLabel("Trạng thái");
		lbl_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1.setBounds(0, 0, 100, 20);
		pnl_TrangThai.add(lbl_1_1);

		lbl_TrangThai = new JLabel("");
		lbl_TrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TrangThai.setBackground(Color.WHITE);
		lbl_TrangThai.setBounds(100, 0, 133, 20);
		pnl_TrangThai.add(lbl_TrangThai);

		JPanel pnl_TinhTrang = new JPanel();
		pnl_TinhTrang.setLayout(null);
		pnl_TinhTrang.setBackground(Color.WHITE);
		pnl_TinhTrang.setBounds(10, 200, 233, 47);
		contentPane.add(pnl_TinhTrang);

		JLabel lbl_1_1_1 = new JLabel("Miêu tả");
		lbl_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1_1.setBounds(0, 0, 100, 20);
		pnl_TinhTrang.add(lbl_1_1_1);

		txt_MoTa = new JTextArea();
		txt_MoTa.setEnabled(false);
		txt_MoTa.setBounds(100, 0, 133, 47);
		pnl_TinhTrang.add(txt_MoTa);

		JPanel pnl_GiaPhong = new JPanel();
		pnl_GiaPhong.setLayout(null);
		pnl_GiaPhong.setBackground(Color.WHITE);
		pnl_GiaPhong.setBounds(10, 140, 233, 20);
		contentPane.add(pnl_GiaPhong);

		JLabel lbl_1_1_1_1 = new JLabel("Số lượng tồn");
		lbl_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1_1_1.setBounds(0, 0, 100, 20);
		pnl_GiaPhong.add(lbl_1_1_1_1);

		lbl_SoLuongTon = new JLabel("");
		lbl_SoLuongTon.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoLuongTon.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_SoLuongTon.setBackground(Color.WHITE);
		lbl_SoLuongTon.setBounds(100, 0, 133, 20);
		pnl_GiaPhong.add(lbl_SoLuongTon);

		JPanel pnl_LoaiPhong = new JPanel();
		pnl_LoaiPhong.setLayout(null);
		pnl_LoaiPhong.setBackground(Color.WHITE);
		pnl_LoaiPhong.setBounds(10, 80, 233, 20);
		contentPane.add(pnl_LoaiPhong);

		JLabel lbl_1_1_1_1_1 = new JLabel("Đơn vị tính");
		lbl_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1_1_1_1.setBounds(0, 0, 100, 20);
		pnl_LoaiPhong.add(lbl_1_1_1_1_1);

		lbl_DonViTinh = new JLabel("");
		lbl_DonViTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DonViTinh.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_DonViTinh.setBackground(Color.WHITE);
		lbl_DonViTinh.setBounds(100, 0, 133, 20);
		pnl_LoaiPhong.add(lbl_DonViTinh);

		JLabel lbl_TieuDe = new JLabel("THÔNG TIN DỊCH VỤ");
		lbl_TieuDe.setForeground(new Color(5, 74, 145));
		lbl_TieuDe.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_TieuDe.setBounds(10, 10, 250, 24);
		contentPane.add(lbl_TieuDe);
	}

	public void SetModal_XemThongTinDichVu(String tenDichVu, String donViTinh, double donGia, double soLuongTon,
			String trangThai, String moaTa) {
		lbl_TenDichVu.setText(tenDichVu);
		lbl_DonViTinh.setText(donViTinh);
		lbl_DonGia.setText(dcf.format(donGia));
		lbl_SoLuongTon.setText(soLuongTon + "");
		lbl_TrangThai.setText(trangThai);
		txt_MoTa.setText(moaTa);
	}
}