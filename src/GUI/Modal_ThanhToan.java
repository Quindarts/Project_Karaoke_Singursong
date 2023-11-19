package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.ctc.wstx.shaded.msv_core.verifier.identity.Matcher;
import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.ConnectDB;
import DAO.ChiTietDichVu_DAO;
import DAO.ChiTietHoaDon_DAO;
import DAO.DichVu_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.KhuyenMai_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import DAO.ThongTinDichVu_DAO;
import Entity.ChiTietDichVu;
import Entity.ChiTietHoaDon;
import Entity.DichVu;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.KhuyenMai;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;
import Entity.ThongTinDichVu;
import GUI.JPanel_QuanLyKhachHang.RoundedTransparentBorder;
import OtherFunction.HelpDate;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Modal_ThanhToan extends JFrame implements ActionListener {

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private JPanel contentPane;
	private JTextField txt__tienCoc;
	private JTextField txt__chietKhau;
	private JTextField txt__tongHoaDon;
	private JTextField txt__tienKhachDua;
	private JTextField txt__tienThoiLai;
	private JTextField txt_ngayLap;
	private JTextField txt__thoiGianTraPhong;
	private JTextField txt__soGioHat;
	private JTextField txt__giaPhong;
	private JTextField txt__tienPhong;
	private JTextField txt_khachHang;
	private JTextField txt__soDienThoai;
	private JTextField txt__giamGia;
	private JTextField txt__tienDichVu;

	private JButton btn__exit;
	private JButton btn__thanhToan;

	private JTable table_DichVu;
	private JTable table_Phong;

	private DefaultTableModel modal_Phong;
	private DefaultTableModel modal_Dv;

	private Phong_DAO DAO_P;
	private LoaiPhong_DAO DAO_LP;
	private ChiTietHoaDon_DAO DAO_CTHD;
	private HoaDon_DAO DAO_HD;
	private PhieuDatPhong_DAO DAO_PhieuDat;
	private KhachHang_DAO DAO_KH;
	private ChiTietDichVu_DAO DAO_chiTietDV;

	// Entity
	private ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<>();
	private ArrayList<ChiTietDichVu> dschiTietDV = new ArrayList<>();

	public ArrayList<ChiTietDichVu> getDschiTietDV() {
		return dschiTietDV;
	}

	public void setDschiTietDV(ArrayList<ChiTietDichVu> dschiTietDV) {
		this.dschiTietDV = dschiTietDV;
	}

	private HoaDon hoaDon;
	private KhachHang khachHangTT;
	private LoaiPhong loaiPhongTT;
	private Phong phongTT;
	private PhieuDatPhong phieuDat_maPhong;
	//
	private HelpDate hDate;

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private final DecimalFormat dcf = new DecimalFormat("#,##0 VND");
	private DefaultTableModel modelPhong;

	private BigDecimal tienKhach;
	private BigDecimal tienTongP;
	private ChiTietDichVu_DAO DAO_CTDV;
	private JDialog_ThongTinHoaDon dialog_TTHD;

	public ArrayList<ChiTietHoaDon> getDsCTHD() {
		return dsCTHD;
	}

	public void setDsCTHD(ArrayList<ChiTietHoaDon> dsCTHD) {
		this.dsCTHD = dsCTHD;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	/**
	 * Create the frame.
	 */

	public KhachHang getKhachHangTT() {
		return khachHangTT;
	}

	public void setKhachHangTT(KhachHang khachHang) {
		this.khachHangTT = khachHang;
	}

	public LoaiPhong getLoaiPhongTT() {
		return loaiPhongTT;
	}

	public void setLoaiPhongTT(LoaiPhong loaiPhong) {
		this.loaiPhongTT = loaiPhong;
	}

	public Phong getPhongTT() {
		return phongTT;
	}

	public void setPhongTT(Phong phongTT) {
		this.phongTT = phongTT;
	}

	/**
	 * @param hoaDon
	 * @param phong
	 * @param loaiPhong
	 * @param khachHang maPhong, loaiPhong, GiaPhong tenKhachHang, soDienThoai
	 *                  thoiGianNhanPhong, thoiGianTraPhong soGioHat tien phong =
	 *                  soGioHat x giaPhong tienDichVu tienCoc Giamgia chietKhau
	 *                  tongHoaDon = tienKhachDua tienThua
	 * 
	 */
	public Modal_ThanhToan(HoaDon hoaDon, Phong phong, LoaiPhong loaiPhong, KhachHang khachHang) {
		setHoaDon(hoaDon);
		setLoaiPhongTT(loaiPhong);
		setPhongTT(phong);
		setKhachHangTT(khachHang);
		System.out.println(getKhachHangTT());
		layDanhSachCTHD();
		layDanhSachCTDV();

		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Modal_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setBounds(100, 100, 1200, 725);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("THANH TOÁN");
		lblNewLabel.setForeground(Color.decode(hexColor_Blue1));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, -1, 1166, 46);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(599, 411, 555, 218);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(0, 0, 255, 47);
		panel.add(panel_1_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Đã cọc");
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(0, 11, 80, 23);
		panel_1_1_1.add(lblNewLabel_1_2_1);

		txt__tienCoc = new JTextField();
		txt__tienCoc.setColumns(10);
		txt__tienCoc.setBounds(80, 10, 175, 28);
		txt__tienCoc.setEnabled(false);
		panel_1_1_1.add(txt__tienCoc);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(new Color(255, 255, 255));
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(0, 56, 255, 77);
		panel.add(panel_1_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Chiết khấu");
		lblNewLabel_1_2_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(0, 11, 80, 23);
		panel_1_1_2.add(lblNewLabel_1_2_2);

		txt__chietKhau = new JTextField();
		txt__chietKhau.setColumns(10);
		txt__chietKhau.setBounds(0, 38, 255, 28);
		txt__chietKhau.setEnabled(false);
		panel_1_1_2.add(txt__chietKhau);

		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setBackground(new Color(255, 255, 255));
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBounds(290, 56, 255, 67);
		panel.add(panel_1_1_3);

		JLabel lblNewLabel_1_2_3 = new JLabel("Tổng hóa đơn");
		lblNewLabel_1_2_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(0, 11, 107, 23);
		panel_1_1_3.add(lblNewLabel_1_2_3);

		txt__tongHoaDon = new JTextField();
		txt__tongHoaDon.setColumns(10);
		txt__tongHoaDon.setBounds(0, 39, 255, 28);
		txt__tongHoaDon.setEnabled(false);
		panel_1_1_3.add(txt__tongHoaDon);

		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setBackground(new Color(255, 255, 255));
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setBounds(0, 143, 255, 67);
		panel.add(panel_1_1_4);

		JLabel lblNewLabel_1_2_4 = new JLabel("Tiền khách đưa");
		lblNewLabel_1_2_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_4.setBounds(0, 11, 129, 23);
		panel_1_1_4.add(lblNewLabel_1_2_4);

		txt__tienKhachDua = new JTextField();
		txt__tienKhachDua.setColumns(10);
		txt__tienKhachDua.setBounds(0, 39, 255, 28);
		panel_1_1_4.add(txt__tienKhachDua);

		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setBackground(new Color(255, 255, 255));
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setBounds(290, 143, 255, 67);
		panel.add(panel_1_1_5);

		JLabel lblNewLabel_1_2_5 = new JLabel("Thối lại");
		lblNewLabel_1_2_5.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_5.setBounds(0, 11, 80, 23);
		panel_1_1_5.add(lblNewLabel_1_2_5);

		txt__tienThoiLai = new JTextField();
		txt__tienThoiLai.setColumns(10);
		txt__tienThoiLai.setBounds(0, 39, 255, 28);
		txt__tienThoiLai.setEnabled(false);
		panel_1_1_5.add(txt__tienThoiLai);

		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBackground(Color.WHITE);
		panel_1_1_1_2.setBounds(290, 0, 255, 47);
		panel.add(panel_1_1_1_2);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Giảm giá (%)");
		lblNewLabel_1_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_1_2.setBounds(0, 11, 80, 23);
		panel_1_1_1_2.add(lblNewLabel_1_2_1_2);

		txt__giamGia = new JTextField();
		txt__giamGia.setColumns(10);
		txt__giamGia.setBounds(105, 10, 150, 28);
		txt__giamGia.setEnabled(false);
		panel_1_1_1_2.add(txt__giamGia);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(599, 157, 577, 218);
		contentPane.add(panel_2);

		JPanel panel_1_1_6 = new JPanel();
		panel_1_1_6.setBackground(new Color(255, 255, 255));
		panel_1_1_6.setLayout(null);
		panel_1_1_6.setBounds(0, 10, 255, 67);
		panel_2.add(panel_1_1_6);

		JLabel lblNewLabel_1_2_6 = new JLabel("Thời gian nhận phòng");
		lblNewLabel_1_2_6.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_6.setBounds(0, 0, 211, 23);
		panel_1_1_6.add(lblNewLabel_1_2_6);

		txt_ngayLap = new JTextField();
		txt_ngayLap.setColumns(10);
		txt_ngayLap.setBounds(0, 29, 255, 28);
		txt_ngayLap.setEnabled(false);
		panel_1_1_6.add(txt_ngayLap);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBounds(290, 10, 255, 67);
		panel_2.add(panel_1_1_1_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Thời gian trả phòng");
		lblNewLabel_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_1_1.setBounds(0, 0, 255, 28);
		panel_1_1_1_1.add(lblNewLabel_1_2_1_1);

		txt__thoiGianTraPhong = new JTextField();
		txt__thoiGianTraPhong.setColumns(10);
		txt__thoiGianTraPhong.setBounds(0, 29, 255, 28);
		txt__thoiGianTraPhong.setEnabled(false);
		panel_1_1_1_1.add(txt__thoiGianTraPhong);

		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setBackground(new Color(255, 255, 255));
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBounds(0, 74, 255, 67);
		panel_2.add(panel_1_1_2_1);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Số giờ hát");
		lblNewLabel_1_2_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_2_1.setBounds(0, 11, 80, 23);
		panel_1_1_2_1.add(lblNewLabel_1_2_2_1);

		txt__soGioHat = new JTextField();
		txt__soGioHat.setColumns(10);
		txt__soGioHat.setBounds(0, 39, 255, 28);
		txt__soGioHat.setEnabled(false);
		panel_1_1_2_1.add(txt__soGioHat);

		JPanel panel_1_1_3_1 = new JPanel();
		panel_1_1_3_1.setBackground(new Color(255, 255, 255));
		panel_1_1_3_1.setLayout(null);
		panel_1_1_3_1.setBounds(290, 74, 255, 67);
		panel_2.add(panel_1_1_3_1);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Giá phòng");
		lblNewLabel_1_2_3_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_3_1.setBounds(0, 11, 80, 23);
		panel_1_1_3_1.add(lblNewLabel_1_2_3_1);

		txt__giaPhong = new JTextField();
		txt__giaPhong.setColumns(10);
		txt__giaPhong.setBounds(0, 39, 255, 28);
		txt__giaPhong.setEnabled(false);
		panel_1_1_3_1.add(txt__giaPhong);

		JPanel panel_1_1_4_1 = new JPanel();
		panel_1_1_4_1.setBackground(new Color(255, 255, 255));
		panel_1_1_4_1.setLayout(null);
		panel_1_1_4_1.setBounds(0, 143, 255, 67);
		panel_2.add(panel_1_1_4_1);

		JLabel lblNewLabel_1_2_4_1 = new JLabel("Tiền phòng");
		lblNewLabel_1_2_4_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_4_1.setBounds(0, 10, 80, 23);
		panel_1_1_4_1.add(lblNewLabel_1_2_4_1);

		txt__tienPhong = new JTextField();
		txt__tienPhong.setColumns(10);
		txt__tienPhong.setBounds(0, 39, 255, 28);
		txt__tienPhong.setEnabled(false);
		panel_1_1_4_1.add(txt__tienPhong);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(290, 142, 255, 68);
		panel_2.add(panel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tiền dịch vụ");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(0, 11, 80, 23);
		panel_1_1.add(lblNewLabel_1_2);

		txt__tienDichVu = new JTextField();
		txt__tienDichVu.setColumns(10);
		txt__tienDichVu.setBounds(0, 40, 255, 28);
		txt__tienDichVu.setEnabled(false);
		panel_1_1.add(txt__tienDichVu);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(599, 56, 577, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_1_1_7 = new JPanel();
		panel_1_1_7.setBackground(new Color(255, 255, 255));
		panel_1_1_7.setBounds(0, 0, 255, 67);
		panel_1.add(panel_1_1_7);
		panel_1_1_7.setLayout(null);

		JLabel lblNewLabel_1_2_7 = new JLabel("Tên khách hàng");
		lblNewLabel_1_2_7.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_7.setBounds(0, 6, 128, 23);
		panel_1_1_7.add(lblNewLabel_1_2_7);

		txt_khachHang = new JTextField();
		txt_khachHang.setColumns(10);
		txt_khachHang.setBounds(0, 39, 255, 28);
		txt_khachHang.setEnabled(false);
		panel_1_1_7.add(txt_khachHang);

		JPanel panel_1_1_8_1 = new JPanel();
		panel_1_1_8_1.setBackground(new Color(255, 255, 255));
		panel_1_1_8_1.setBounds(290, 0, 255, 67);
		panel_1.add(panel_1_1_8_1);
		panel_1_1_8_1.setLayout(null);

		JLabel lblNewLabel_1_2_8_1 = new JLabel("Số điện thoại khách hàng");
		lblNewLabel_1_2_8_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_8_1.setBounds(0, 10, 174, 23);
		panel_1_1_8_1.add(lblNewLabel_1_2_8_1);

		txt__soDienThoai = new JTextField();
		txt__soDienThoai.setColumns(10);
		txt__soDienThoai.setBounds(0, 39, 255, 28);
		txt__soDienThoai.setEnabled(false);
		panel_1_1_8_1.add(txt__soDienThoai);

		JPanel panel_Table_dichVu = new JPanel();
		panel_Table_dichVu.setBounds(28, 56, 534, 261);
		contentPane.add(panel_Table_dichVu);

		// Table thong dich vu
		panel_Table_dichVu.setBackground(Color.decode(hexColor_Blue1));
		panel_Table_dichVu.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Danh sách dịch vụ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 0, 535, 46);
		panel_Table_dichVu.add(lblNewLabel_1);

		table_DichVu = new JTable();
		table_DichVu.setFillsViewportHeight(true);
		table_DichVu.setBackground(Color.WHITE);
		table_DichVu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mặt hàng", "Đơn giá", "Số lượng", "Thành tiền" }));

		table_DichVu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 45, 534, 216);
		panel_Table_dichVu.add(scrollPane);
		scrollPane.add(table_DichVu);
		scrollPane.setViewportView(table_DichVu);

		// Table thong tin dich vu

		JPanel panel_Table_Phong = new JPanel();
		panel_Table_Phong.setLayout(null);
		panel_Table_Phong.setBackground(new Color(5, 74, 145));
		panel_Table_Phong.setBounds(28, 329, 534, 288);
		contentPane.add(panel_Table_Phong);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 45, 534, 243);
		panel_Table_Phong.add(scrollPane_1);

		table_Phong = new JTable();
		table_Phong.setFillsViewportHeight(true);
		table_Phong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table_Phong.setBackground(Color.WHITE);
		table_Phong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Tên loại phòng", "Tên phòng", "Số giờ hát", "Tiền phòng", "Thành tiền" }));

		scrollPane_1.setViewportView(table_Phong);
		
				JLabel lblNewLabel_1_1 = new JLabel("Danh sách phòng");
				lblNewLabel_1_1.setBounds(0, 0, 535, 46);
				panel_Table_Phong.add(lblNewLabel_1_1);
				lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1_1.setForeground(Color.WHITE);
				lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));

		btn__exit = new JButton("Quay lại");
		btn__exit.setBounds(880, 630, 120, 35);
		contentPane.add(btn__exit);
		btn__exit.setBackground(Color.decode(hexColor_Blue2));
		btn__exit.setIcon(new ImageIcon(Modal_ThanhToan.class.getResource("/icon/return.png")));
		btn__exit.setForeground(new Color(255, 255, 255));
		btn__exit.setFont(new Font("Segoe UI", Font.BOLD, 13));

		btn__thanhToan = new JButton("Thanh toán");
		btn__thanhToan.setBounds(1010, 630, 135, 35);
		contentPane.add(btn__thanhToan);
		btn__thanhToan.setForeground(new Color(255, 255, 255));
		btn__thanhToan.setBackground(Color.decode(hexColor_Orange));
		btn__thanhToan.setIcon(new ImageIcon(Modal_ThanhToan.class.getResource("/icon/confirm.png")));
		btn__thanhToan.setFont(new Font("Segoe UI", Font.BOLD, 13));

		btn__thanhToan.setEnabled(false);
		btn__thanhToan.addActionListener(this);
		btn__exit.addActionListener(this);

		// Cập nhật form
		clearForm();
		renderTablePhong();
		renderTableDichVu(getDschiTietDV());
		capNhatForm();
//		table_Phong.addMouseListener((MouseListener) this);
		txt__tienKhachDua.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();
		if (o.equals(btn__exit)) {
			this.setVisible(false);
		}

		if (o.equals(btn__thanhToan)) {

			long currentTimeMillis = System.currentTimeMillis();
			Timestamp thoiGianHienTai = new Timestamp(currentTimeMillis);
			if (capNhatTienThoiLaiKhach()) {
				getHoaDon().setThoiGianKetThuc(thoiGianHienTai);
				getHoaDon().setTrangThai("Đã thanh toán");
				boolean hdtt = DAO_HD.capNhatHoaDon(getHoaDon());

				if (hdtt == true) {

					JOptionPane.showMessageDialog(null, "Thanh toán thành công!!");

					getDsCTHD().forEach(cthd -> {
						DAO_P.capNhat_TranThaiPhong(cthd.getPhong().getMaPhong(), "VC");
					});
					getDschiTietDV().forEach(ctdv -> {
						ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
						DichVu_DAO DAO_DV = new DichVu_DAO();
						ThongTinDichVu ttdichvu = DAO_TTDV
								.timThongTinDichVu_TheoMaDichVu(ctdv.getDichVu().getMaDichVu());
						ttdichvu.setSoLuongDaSuDung(ttdichvu.getSoLuong() - ctdv.getSoLuong());

						DAO_TTDV.capNhatThongTinDichVu(ttdichvu);

					});
					dialog_TTHD = new JDialog_ThongTinHoaDon();

					this.setVisible(false);
					dialog_TTHD.setVisible(true);
					dialog_TTHD.HienThongTinTheoMaHD(getHoaDon().getMaHoaDon());
				} else {
					JOptionPane.showMessageDialog(null, "Thanh toán thất bại, vui lòng kiểm tra lại thông tin");
				}
			}

		}
		if (o.equals(txt__tienKhachDua)) {

			String regex = "^[0-9]+(\\.[0-9]+)?$";
			Pattern pattern = Pattern.compile(regex);
			java.util.regex.Matcher matcher = pattern.matcher(txt__tienKhachDua.getText());

			if (!txt__tienKhachDua.equals("")) {
				if (matcher.matches()) {
					btn__thanhToan.setEnabled(true);
					capNhatTienThoiLaiKhach();
				} else {
					JOptionPane.showMessageDialog(null, "Số tiền nhập vào phải là số!");
				}
			}

		}
	}

	public void clearForm() {
		// Event

		txt__chietKhau.setText("");
		txt__soDienThoai.setText("");
		txt__soGioHat.setText("");
		txt_ngayLap.setText("");
		txt__thoiGianTraPhong.setText("");
		txt__tienCoc.setText("");
		txt__tienPhong.setText("");
		txt__tongHoaDon.setText("");
		txt_khachHang.setText("");

	}

	public void capNhatForm() {
		// Event

		long currentTimeMillis = System.currentTimeMillis();

		// Tạo đối tượng Timestamp từ thời gian hiện tại
		Timestamp thoiGianHienTai = new Timestamp(currentTimeMillis);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ChiTietHoaDon_DAO DAO_CTHD = new ChiTietHoaDon_DAO();

		ChiTietHoaDon cthdSelected = DAO_CTHD.timCTHoaDon_TheoMaHoaDon_MaPhong(getPhongTT().getMaPhong(),
				getHoaDon().getMaHoaDon());

		txt__chietKhau.setText("5%");
		txt__soDienThoai.setText(getKhachHangTT().getSoDienThoai());
		txt_khachHang.setText(getKhachHangTT().getHoTen());
		txt__giamGia.setText("0%");

		System.out.println(getLoaiPhongTT().getGiaTien());
		txt__giaPhong.setText(String.valueOf(getLoaiPhongTT().getGiaTien()));

		txt_ngayLap.setText(sdf.format(getHoaDon().getNgayLap()));

		txt__thoiGianTraPhong.setText(sdf.format(thoiGianHienTai));

		txt__soGioHat.setText(String.valueOf(getHoaDon().tinhGioHat()));

		txt__tienDichVu.setText(String.valueOf(getHoaDon().tinhTienDichVu(dschiTietDV)));

		txt__tienCoc.setText(dcf.format(getHoaDon().getPhieuDatPhong().getTienCoc()));
		txt__tienPhong.setText(dcf.format(getHoaDon().tinhTienPhong(dsCTHD)));
		txt__tongHoaDon.setText(dcf.format(getHoaDon().tinhTongTien(dsCTHD, dschiTietDV)));

	}

	public boolean capNhatTienThoiLaiKhach() {
		if (!txt__tienKhachDua.getText().toString().trim().equals("")) {
			Double tienKhach = Double.parseDouble(txt__tienKhachDua.getText().toString());
			Double result = getHoaDon().tinhTongTien(getDsCTHD(), getDschiTietDV()) - tienKhach;
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Khách đưa thiếu: " + dcf.format(result));
				return false;
			} else {
				txt__tienThoiLai.setText(dcf.format(Math.abs(result)));
			}
		}
		return true;
	}

	public void layDanhSachCTHD() {

		DAO_CTHD = new ChiTietHoaDon_DAO();
		DAO_P = new Phong_DAO();
		DAO_HD = new HoaDon_DAO();
		DAO_LP = new LoaiPhong_DAO();
		dsCTHD = DAO_CTHD.timCTHoaDon_TheoMaHoaDon(getHoaDon().getMaHoaDon());
		setDsCTHD(dsCTHD);
	}

	public void layDanhSachCTDV() {
		DAO_CTDV = new ChiTietDichVu_DAO();

		ArrayList<ChiTietDichVu> dschiTietDV = DAO_CTDV
				.layDanhSachChiTietDichVu_TheoMaHoaDon(getHoaDon().getMaHoaDon());

		setDschiTietDV(dschiTietDV);
	}

	public void renderTablePhong() {
		modelPhong = (DefaultTableModel) table_Phong.getModel();

		if (getDsCTHD() != null) {
			int sttCTHD = 1;
			for (ChiTietHoaDon cthd : dsCTHD) {
				Phong p = DAO_P.timPhong_TheoMaPhong(cthd.getPhong().getMaPhong());
				LoaiPhong lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
				HoaDon hd = DAO_HD.layHoaDon_TheoMaHoaDon(hoaDon.getMaHoaDon());

				Object[] rowData = { sttCTHD++, lp.getTenLoaiPhong(), p.getTenPhong(), hd.tinhGioHat(), lp.getGiaTien(),
						cthd.thanhTien(hd.tinhGioHat()) };
				modelPhong.addRow(rowData);
			}
		}
	}

	public void renderTableDichVu(ArrayList<ChiTietDichVu> dschiTietDV) {
		modal_Dv = (DefaultTableModel) table_DichVu.getModel();
		int iii = 1;
		for (ChiTietDichVu chiTietDV : dschiTietDV) {
			Object[] rowData = { iii++, chiTietDV.getDichVu().getTenDichVu(), chiTietDV.getDichVu().getDonGia(),
					chiTietDV.getDichVu().getSoLuong(), chiTietDV.thanhTien() };
			iii++;
			modal_Dv.addRow(rowData);
		}
		;

	}

	public void XoaDuLieuTrenTableDV() {
		modal_Dv = (DefaultTableModel) table_DichVu.getModel();
		modal_Dv.getDataVector().removeAllElements();
	}

}