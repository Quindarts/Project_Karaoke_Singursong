package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Modal_CapNhatPhieuDatPhongTruoc extends JFrame {

	private JPanel contentPane;
	private JTextField txtGioDatPhong;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private JTextField txtMaPDP;
	private JTextField txtTenPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoDienThoai;

	private JTextField txtTenKH;
	private JTextField txtTienCoc;
	private JTextField txtNhanVien;
	private JTextField textField;

	private ArrayList<PhieuDatPhong> dsPDP;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<NhanVien> dsNV;
	private ArrayList<Phong> dsPhong;

	private PhieuDatPhong_DAO DAO_PDP;
	private KhachHang_DAO DAO_KH;
	private NhanVien_DAO DAO_NV;
	private Phong_DAO DAO_P;
	private PhieuDatPhong pdp;
	private KhachHang kh;
	private NhanVien nhanVien;
	private Phong p;
	private LoaiPhong_DAO DAO_LP;
	private LoaiPhong lp;
	private JDateChooser date_DatPhong;
	private JButton btnLuu;
	private JDateChooser date_NhanPhong;

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private JTextArea txtMoTa;

	/**
	 * Create the panel.
	 */
	public Modal_CapNhatPhieuDatPhongTruoc(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		System.out.println("");
		System.out.println(nhanVien.toString());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
//		contentPane.setBackground(Color.decode(hexColor_Blue1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_PDP = new JPanel();
		panel_PDP.setBackground(new Color(255, 255, 255));
		panel_PDP.setBounds(0, 0, 884, 473);
		contentPane.add(panel_PDP);
		panel_PDP.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(22, 142, 417, 155);
		panel_PDP.add(panel);
		panel.setLayout(null);

		JLabel lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setForeground(new Color(0, 0, 0));
		lblTenPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenPhong.setBounds(10, 25, 82, 27);
		panel.add(lblTenPhong);

		JLabel lblLoaiPhong_1_1 = new JLabel("Loại phòng");
		lblLoaiPhong_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1.setBounds(10, 65, 82, 27);
		panel.add(lblLoaiPhong_1_1);

		JLabel lblLoaiPhong_1_1_1 = new JLabel("Giá phòng");
		lblLoaiPhong_1_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_1.setBounds(10, 105, 82, 27);
		panel.add(lblLoaiPhong_1_1_1);

		txtTenPhong = new JTextField();
		txtTenPhong.setEnabled(false);
		txtTenPhong.setEditable(false);
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(102, 25, 294, 27);
		panel.add(txtTenPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEnabled(false);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(102, 65, 294, 27);
		panel.add(txtLoaiPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEnabled(false);
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(102, 105, 294, 27);
		panel.add(txtGiaPhong);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(449, 142, 413, 155);
		panel_PDP.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSoDienThoai.setBounds(10, 25, 85, 27);
		panel_1.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(120, 25, 276, 27);
		panel_1.add(txtSoDienThoai);

		JLabel lblLoaiPhong_1_1_2 = new JLabel("Tên khách hàng");
		lblLoaiPhong_1_1_2.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_2.setBounds(10, 65, 100, 27);
		panel_1.add(lblLoaiPhong_1_1_2);

		txtTenKH = new JTextField();
		txtTenKH.setEnabled(false);
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(120, 65, 276, 27);
		panel_1.add(txtTenKH);

		JLabel lblTienCoc = new JLabel("Tiền cọc");
		lblTienCoc.setForeground(Color.BLACK);
		lblTienCoc.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTienCoc.setBounds(10, 105, 82, 27);
		panel_1.add(lblTienCoc);

		txtTienCoc = new JTextField();
		txtTienCoc.setEnabled(false);
		txtTienCoc.setEditable(false);
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(120, 105, 276, 27);
		panel_1.add(txtTienCoc);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(22, 45, 840, 86);
		panel_PDP.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTGDatPhong = new JLabel("Thời gian đặt phòng");
		lblTGDatPhong.setForeground(new Color(0, 0, 0));
		lblTGDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTGDatPhong.setBounds(10, 11, 136, 27);
		panel_2.add(lblTGDatPhong);

		date_DatPhong = new JDateChooser();
		date_DatPhong.setBounds(167, 11, 157, 27);
		panel_2.add(date_DatPhong);

		txtGioDatPhong = new JTextField();
		txtGioDatPhong.setEnabled(false);
		txtGioDatPhong.setBounds(325, 12, 55, 27);
		panel_2.add(txtGioDatPhong);
		txtGioDatPhong.setColumns(10);

		JLabel lblNhanVien = new JLabel("Nhân viên");
		lblNhanVien.setForeground(new Color(0, 0, 0));
		lblNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNhanVien.setBounds(390, 10, 82, 27);
		panel_2.add(lblNhanVien);

		JLabel lblMaPDP = new JLabel("Mã phiếu ");
		lblMaPDP.setForeground(new Color(0, 0, 0));
		lblMaPDP.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPDP.setBounds(622, 11, 82, 27);
		panel_2.add(lblMaPDP);

		txtMaPDP = new JTextField();
		txtMaPDP.setEditable(false);
		txtMaPDP.setEnabled(false);
		txtMaPDP.setBounds(688, 11, 140, 27);
		panel_2.add(txtMaPDP);
		txtMaPDP.setColumns(10);

		txtNhanVien = new JTextField();
		txtNhanVien.setEnabled(false);
		txtNhanVien.setEditable(false);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(463, 11, 136, 27);
		panel_2.add(txtNhanVien);

		JLabel lblThiGianNhn = new JLabel("Thời gian nhận phòng");
		lblThiGianNhn.setForeground(Color.BLACK);
		lblThiGianNhn.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblThiGianNhn.setBounds(10, 49, 149, 27);
		panel_2.add(lblThiGianNhn);

		date_NhanPhong = new JDateChooser();
		date_NhanPhong.setBounds(167, 49, 157, 27);
		panel_2.add(date_NhanPhong);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(325, 50, 55, 27);
		panel_2.add(textField);

		btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhat();
			}
		});
		btnLuu.setBackground(Color.decode(hexColor_Green));
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLuu.setBounds(652, 432, 100, 30);
		panel_PDP.add(btnLuu);

		JButton btnHy = new JButton("Hủy");
		btnHy.setBackground(Color.decode(hexColor_Blue2));
		btnHy.setForeground(new Color(255, 255, 255));
		btnHy.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnHy.setBounds(762, 432, 100, 30);
		panel_PDP.add(btnHy);

		JLabel lblPhiutPhng = new JLabel("CẬP NHẬT PHIẾU ĐẶT PHÒNG TRƯỚC");
		lblPhiutPhng.setForeground(new Color(5, 74, 145));
		lblPhiutPhng.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPhiutPhng.setBounds(22, 11, 327, 27);
		panel_PDP.add(lblPhiutPhng);

		JLabel lblLoaiPhong_1_1_1_1 = new JLabel("Mô tả");
		lblLoaiPhong_1_1_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_1_1.setBounds(32, 301, 82, 27);
		panel_PDP.add(lblLoaiPhong_1_1_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(22, 329, 840, 68);
		panel_PDP.add(panel_3);
		panel_3.setLayout(null);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(10, 11, 820, 46);
		panel_3.add(txtMoTa);

	}

	public void capNhat() {
//		try {
//			if(Invalid()) {
//				String maPDP = txtMaPDP.getText();
//				
//				String tenPhong  = txtTenPhong.getText();
//				String tenNV =  txtNhanVien.getText();
//				String tenKH =  txtTenKH.getText();
//				Date tgDatPhong= date_DatPhong.getDate();
////				Date tgDatNhanPhong= date_DatPhong.getDate();
////				Double tienCoc = Double.parseDouble(txtTienCoc.getText());
////				String mota = txtMoTa.getText();
//
////				pdp = new PhieuDatPhong(maPDP, p, nv, kh, null, null, ABORT, null, mota);
////				try {
////					if(kh_bus.update(kh)) {
//////						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
////						lblthongbao.setText("Cập nhật thành công");
////						XoahetDuLieutrenTable();
////						DocDuLieutrenSQL();
////					}
////				} catch (Exception e) {
////					// TODO: handle exception
////				}
////			}
////			
////		} catch (Exception e) {
////			// TODO: handle exception
////			lblthongbao.setText("Chưa chọn dữ liệu cập nhật");
////		}

	}

	private boolean Invalid() {
		// TODO Auto-generated method stub
		return false;
	}

	public void HienThongTinTheoMaPDP(String ma) {
		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_KH = new KhachHang_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_P = new Phong_DAO();
		DAO_LP = new LoaiPhong_DAO();

		KhachHang kh = new KhachHang();
		NhanVien nv = new NhanVien();
		Phong p = new Phong();
		LoaiPhong lp = new LoaiPhong();

		pdp = DAO_PDP.layPhieuDatPhong_TheoMaPhieuDat(ma);
		p = DAO_P.timPhong_TheoMaPhong(pdp.getPhong().getMaPhong());
		kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());
		nv = DAO_NV.timNhanVien_TheoMaNhanVien(pdp.getNhanVien().getMaNhanVien());
		lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());

		txtMaPDP.setText(pdp.getMaPhieuDat());
		txtLoaiPhong.setText(p.getLoaiPhong().getMaLoaiPhong());
		txtNhanVien.setText(nv.getHoTen());
		txtTenKH.setText(kh.getHoTen());
		txtSoDienThoai.setText(kh.getSoDienThoai());
		txtGiaPhong.setText(Double.toString(lp.getGiaTien()));
		txtTenPhong.setText(p.getTenPhong());
		txtTienCoc.setText(Double.toString(pdp.getTienCoc()));
		date_DatPhong.setDate(pdp.getThoiGianDatPhong());
		date_NhanPhong.setDate(pdp.getThoiGianNhanPhong());
//		txtTinhTrangPhieu.setText(pdp.getTrangThai().getTrangThai());
		txtMoTa.setText(pdp.getMoTa());
//		txtMaKH.setText(kh.getMaKhachHang());
	}
}
