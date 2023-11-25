package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.LoaiPhong_DAO;
import Entity.LoaiPhong;
import Entity.Phong;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class Modal_XemThongTinPhong extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_LoaiPhong;
	private JLabel lbl_GiaPhong;
	private JLabel lbl_TinhTrang;
	private JLabel lbl_TrangThai;
	private JLabel lbl_ViTriPhong;
	private JLabel lbl_TenPhong;
	private JLabel img_Phong;
	
	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	private Phong phong;
	private LoaiPhong loaiPh;
	private LoaiPhong_DAO DAO_LP;
	private JLabel img_show_panel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Modal_XemThongTinPhong(Phong phong) {
		this.phong = phong;
		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Modal_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setBounds(100, 100, 452, 294);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnl_TieuDe = new JPanel();
		pnl_TieuDe.setBackground(new Color(255, 255, 255));
		pnl_TieuDe.setBounds(10, 10, 416, 24);
		contentPane.add(pnl_TieuDe);
		pnl_TieuDe.setLayout(null);

		JLabel lbl_TieuDe = new JLabel("THÔNG TIN PHÒNG");
		lbl_TieuDe.setForeground(Color.decode(hexColor_Blue1));
		lbl_TieuDe.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lbl_TieuDe.setBounds(0, 0, 290, 24);
		pnl_TieuDe.add(lbl_TieuDe);

		img_Phong = new JLabel("");
		img_Phong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		img_Phong.setBackground(new Color(192, 192, 192));
		img_Phong.setBounds(10, 50, 179, 171);
		contentPane.add(img_Phong);

		JPanel pnl_TenPhong = new JPanel();
		pnl_TenPhong.setBackground(new Color(255, 255, 255));
		pnl_TenPhong.setBounds(200, 50, 220, 20);
		contentPane.add(pnl_TenPhong);
		pnl_TenPhong.setLayout(null);

		JLabel lbl_1 = new JLabel("Tên phòng");
		lbl_1.setBounds(0, 0, 100, 20);
		pnl_TenPhong.add(lbl_1);
		lbl_1.setFont(new Font("Segoe UI", Font.BOLD, 13));

		lbl_TenPhong = new JLabel("");
		lbl_TenPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenPhong.setBackground(new Color(255, 255, 255));
		lbl_TenPhong.setBounds(80, 0, 140, 20);
		pnl_TenPhong.add(lbl_TenPhong);
		lbl_TenPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		JPanel pnl_ViTri = new JPanel();
		pnl_ViTri.setBackground(new Color(255, 255, 255));
		pnl_ViTri.setLayout(null);
		pnl_ViTri.setBounds(200, 110, 220, 20);
		contentPane.add(pnl_ViTri);

		JLabel lbl_1_2 = new JLabel("Vị trí");
		lbl_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_2.setBounds(0, 0, 100, 20);
		pnl_ViTri.add(lbl_1_2);

		lbl_ViTriPhong = new JLabel("");
		lbl_ViTriPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ViTriPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_ViTriPhong.setBounds(80, 0, 140, 20);
		pnl_ViTri.add(lbl_ViTriPhong);

		JPanel pnl_TrangThai = new JPanel();
		pnl_TrangThai.setLayout(null);
		pnl_TrangThai.setBackground(Color.WHITE);
		pnl_TrangThai.setBounds(200, 170, 220, 20);
		contentPane.add(pnl_TrangThai);

		JLabel lbl_1_1 = new JLabel("Trạng thái");
		lbl_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1.setBounds(0, 0, 100, 20);
		pnl_TrangThai.add(lbl_1_1);

		lbl_TrangThai = new JLabel("");
		lbl_TrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TrangThai.setBackground(Color.WHITE);
		lbl_TrangThai.setBounds(80, 0, 140, 20);
		pnl_TrangThai.add(lbl_TrangThai);

		JPanel pnl_TinhTrang = new JPanel();
		pnl_TinhTrang.setLayout(null);
		pnl_TinhTrang.setBackground(Color.WHITE);
		pnl_TinhTrang.setBounds(200, 200, 220, 20);
		contentPane.add(pnl_TinhTrang);

		JLabel lbl_1_1_1 = new JLabel("Tình trạng");
		lbl_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1_1.setBounds(0, 0, 100, 20);
		pnl_TinhTrang.add(lbl_1_1_1);

		lbl_TinhTrang = new JLabel("");
		lbl_TinhTrang.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TinhTrang.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TinhTrang.setBackground(Color.WHITE);
		lbl_TinhTrang.setBounds(80, 0, 140, 20);
		pnl_TinhTrang.add(lbl_TinhTrang);

		JPanel pnl_GiaPhong = new JPanel();
		pnl_GiaPhong.setLayout(null);
		pnl_GiaPhong.setBackground(Color.WHITE);
		pnl_GiaPhong.setBounds(200, 140, 220, 20);
		contentPane.add(pnl_GiaPhong);

		JLabel lbl_1_1_1_1 = new JLabel("Giá phòng");
		lbl_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1_1_1.setBounds(0, 0, 100, 20);
		pnl_GiaPhong.add(lbl_1_1_1_1);

		lbl_GiaPhong = new JLabel("");
		lbl_GiaPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_GiaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_GiaPhong.setBackground(Color.WHITE);
		lbl_GiaPhong.setBounds(80, 0, 140, 20);
		pnl_GiaPhong.add(lbl_GiaPhong);

		JPanel pnl_LoaiPhong = new JPanel();
		pnl_LoaiPhong.setLayout(null);
		pnl_LoaiPhong.setBackground(Color.WHITE);
		pnl_LoaiPhong.setBounds(200, 80, 220, 20);
		contentPane.add(pnl_LoaiPhong);

		JLabel lbl_1_1_1_1_1 = new JLabel("Loại phòng");
		lbl_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_1_1_1_1_1.setBounds(0, 0, 100, 20);
		pnl_LoaiPhong.add(lbl_1_1_1_1_1);

		lbl_LoaiPhong = new JLabel("");
		lbl_LoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_LoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_LoaiPhong.setBackground(Color.WHITE);
		lbl_LoaiPhong.setBounds(80, 0, 140, 20);
		pnl_LoaiPhong.add(lbl_LoaiPhong);
		
		
		
	}

	public void SetModal_XemThongTinPhong(String anhPhong, String tenPhong ,String tenLoaiPhong, String viTriPhong, String giaPhong,
			String trangThai, String tinhTrang) {	
		img_Phong.setText(anhPhong);
		lbl_TenPhong.setText(tenPhong);
		lbl_LoaiPhong.setText(tenLoaiPhong);
		lbl_ViTriPhong.setText(viTriPhong);
		lbl_GiaPhong.setText(giaPhong);
		lbl_TrangThai.setText(trangThai);
		lbl_TinhTrang.setText(tinhTrang);
	}
}