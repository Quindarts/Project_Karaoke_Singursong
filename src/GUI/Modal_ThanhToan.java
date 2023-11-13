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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Modal_ThanhToan extends JFrame implements ActionListener, MouseListener {

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
	private JTextField txt__thoiGianNhanPhong;
	private JTextField txt__thoiGianTraPhong;
	private JTextField txt__soGioHat;
	private JTextField txt__giaPhong;
	private JTextField txt__tienPhong;
	private JTextField txt_khachHang;
	private JTextField txt__maPhong;
	private JTextField txt__soDienThoai;
	private JButton btn__exit;
	private JButton btn__thanhToan;
	private DefaultTableModel modal_Phong;
	private DefaultTableModel modal_Dv;

	// Entity
	private HoaDon hoaDon;
	private KhachHang khachHang;
	private LoaiPhong loaiPhong;
	private Phong phong;
	//
	private HelpDate hDate;

	private JTable table_DichVu;
	private JTable table_Phong;

	private PhieuDatPhong phieuDat_maPhong;
	private JTextField txt__tienhoadonPhong;
	private Phong_DAO DAO_Phong;
	private LoaiPhong_DAO DAO_LP;
	private PhieuDatPhong_DAO DAO_PhieuDat;
	private JTextField txt__loaiPhong;
	private KhachHang_DAO DAO_KH;
	private ChiTietDichVu chiTietDV;
	private ChiTietDichVu_DAO DAO_chiTietDV;
	private JTextField txt__tienDichVu;
	private BigDecimal tienKhach;
	private BigDecimal tienTongP;

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private final DecimalFormat dcf = new DecimalFormat("#,##0 VND");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//
//		EventQueue.invokeLater(new Runnable() {
//			private HelpDate hDate;
//			private Phong_DAO DAO_P;
//
//			public void run() {
//				try {
//
//					try {
//						ConnectDB.getInstance().connect();
//						System.out.println("Connected!!!!");
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//					FlatLightLaf.setup();
//					DAO_P = new Phong_DAO();
//					Phong phong = DAO_P.timPhong_TheoMaPhong("P101");
//					LoaiPhong loaiPhong = new LoaiPhong(phong.getLoaiPhong().getMaLoaiPhong());
//					hDate = new HelpDate();
//					KhachHang kh = new KhachHang();
//					HoaDon hd = new HoaDon("HD310102122", kh, new NhanVien(), new PhieuDatPhong(), new KhuyenMai(),
//							hDate.chuyenStringThanhDate("2023-10-31"), "Đang thanh toán",
//							hDate.chuyenStringThanhDate("2023-10-31"));
//					Modal_ThanhToan frame = new Modal_ThanhToan(hd, phong, loaiPhong, kh);
//
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//	}

	/**
	 * Create the frame.
	 */

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

		this.hoaDon = hoaDon;
		this.khachHang = khachHang;
		this.phong = phong;
		this.loaiPhong = loaiPhong;

//		System.out.println(hoaDon.toString());
//		System.out.println(khachHang.toString());
//		System.out.println(loaiPhong.toString());
//		System.out.println(phong.toString());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("THANH TOÁN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 1200, 46);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(599, 433, 555, 243);
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
		panel_1_1_2.setBounds(0, 56, 91, 77);
		panel.add(panel_1_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Chiết khấu");
		lblNewLabel_1_2_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(0, 11, 80, 23);
		panel_1_1_2.add(lblNewLabel_1_2_2);

		txt__chietKhau = new JTextField();
		txt__chietKhau.setColumns(10);
		txt__chietKhau.setBounds(0, 38, 91, 28);
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
		panel_1_1_4.setBounds(0, 143, 255, 95);
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

		JTextField txt__giamGia = new JTextField();
		txt__giamGia.setColumns(10);
		txt__giamGia.setBounds(80, 10, 175, 28);
		txt__giamGia.setEnabled(false);
		panel_1_1_1_2.add(txt__giamGia);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(599, 205, 577, 218);
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

		txt__thoiGianNhanPhong = new JTextField();
		txt__thoiGianNhanPhong.setColumns(10);
		txt__thoiGianNhanPhong.setBounds(0, 29, 255, 28);
		txt__thoiGianNhanPhong.setEnabled(false);
		panel_1_1_6.add(txt__thoiGianNhanPhong);

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
		panel_1.setBounds(599, 56, 577, 139);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_1_1_8 = new JPanel();
		panel_1_1_8.setBackground(new Color(255, 255, 255));
		panel_1_1_8.setBounds(0, 0, 255, 67);
		panel_1.add(panel_1_1_8);
		panel_1_1_8.setLayout(null);

		JLabel lblNewLabel_1_2_8 = new JLabel("Mã phòng");
		lblNewLabel_1_2_8.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_8.setBounds(0, 0, 80, 23);
		panel_1_1_8.add(lblNewLabel_1_2_8);

		txt__maPhong = new JTextField();
		txt__maPhong.setColumns(10);
		txt__maPhong.setBounds(0, 33, 255, 28);
		txt__maPhong.setEnabled(false);
		panel_1_1_8.add(txt__maPhong);

		JPanel panel_1_1_8_2 = new JPanel();
		panel_1_1_8_2.setBackground(new Color(255, 255, 255));
		panel_1_1_8_2.setBounds(290, 0, 255, 67);
		panel_1.add(panel_1_1_8_2);
		panel_1_1_8_2.setLayout(null);

		JLabel lblNewLabel_1_2_8_2 = new JLabel("Loại phòng");
		lblNewLabel_1_2_8_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_8_2.setBounds(0, 0, 80, 23);
		panel_1_1_8_2.add(lblNewLabel_1_2_8_2);

		txt__loaiPhong = new JTextField();
		txt__loaiPhong.setColumns(10);
		txt__loaiPhong.setBounds(0, 33, 255, 28);
		txt__loaiPhong.setEnabled(false);
		panel_1_1_8_2.add(txt__loaiPhong);

		JPanel panel_1_1_7 = new JPanel();
		panel_1_1_7.setBackground(new Color(255, 255, 255));
		panel_1_1_7.setBounds(0, 63, 255, 67);
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
		panel_1_1_8_1.setBounds(290, 63, 255, 67);
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

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(885, 675, 258, 36);
		contentPane.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);

		btn__exit = new JButton("Quay lại");
		btn__exit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn__exit.setBounds(0, 0, 112, 36);
		panel_3.add(btn__exit);

		btn__thanhToan = new JButton("Thanh toán");
		btn__thanhToan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__thanhToan.setBounds(146, 0, 112, 36);
		panel_3.add(btn__thanhToan);

		JPanel panel_Table_dichVu = new JPanel();
		panel_Table_dichVu.setBounds(28, 56, 534, 319);
		contentPane.add(panel_Table_dichVu);

		// Table thong dich vu
		panel_Table_dichVu.setBackground(Color.decode(hexColor_Blue1));
		panel_Table_dichVu.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Danh sách dịch vụ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 535, 35);
		panel_Table_dichVu.add(lblNewLabel_1);

		table_DichVu = new JTable();
		table_DichVu.setBackground(Color.WHITE);
		table_DichVu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "T\u00EAn m\u1EB7t h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1",
						"Th\u00E0nh ti\u1EC1n", "C\u1EADp nh\u1EADt" }));

		table_DichVu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 45, 534, 273);
		panel_Table_dichVu.add(scrollPane);
		scrollPane.add(table_DichVu);
		scrollPane.setViewportView(table_DichVu);

		ChiTietDichVu ctdv = new ChiTietDichVu(hoaDon, null, 30);

//		btn__CapNhatTableDichVu.setCellRenderer(new ButtonCellRendererEditor(ctdv));
//		btn__CapNhatTableDichVu.setCellEditor(new ButtonCellRendererEditor(ctdv));

		// Table thong dich vu

		JPanel panel_Table_Phong = new JPanel();
		panel_Table_Phong.setLayout(null);
		panel_Table_Phong.setBackground(new Color(5, 74, 145));
		panel_Table_Phong.setBounds(28, 412, 534, 286);
		contentPane.add(panel_Table_Phong);

		JLabel lblNewLabel_1_1 = new JLabel("Danh sách phòng");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(0, 0, 535, 35);
		panel_Table_Phong.add(lblNewLabel_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 45, 534, 241);
		panel_Table_Phong.add(scrollPane_1);

		table_Phong = new JTable(modal_Phong);
		table_Phong.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 ph\u00F2ng",
				"M\u00E3 kh\u00E1ch h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "gi\u00E1 ti\u1EC1n", "action" }) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Xác định loại dữ liệu của cột "Action" là Boolean.class (checkbox)
				if (columnIndex == 4) {
					return Boolean.class;
				}
				// Các cột khác sẽ sử dụng loại dữ liệu mặc định (Object)
				return Object.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// Ngăn chặn sự kiện chỉnh sửa trên 3 cột đầu tiên (index 0, 1, 2)
				return column >= 4;
			}
		});

		table_Phong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table_Phong.setBackground(Color.WHITE);

		modal_Phong = (DefaultTableModel) table_Phong.getModel();
		modal_Dv = (DefaultTableModel) table_DichVu.getModel();
		scrollPane_1.setViewportView(table_Phong);

		// Event

		txt__chietKhau.setText("5%");
		txt__maPhong.setText(phong.getMaPhong());
		txt__soDienThoai.setText(khachHang.getSoDienThoai());
		txt__soGioHat.setText("5");
//		txt__thoiGianNhanPhong.setText(hDate.chuyenDateThanhString(hoaDon.getNgayLap()));
//		txt__thoiGianTraPhong.setText(hDate.chuyenDateThanhString(hoaDon.getThoiGianKetThuc()));
		txt__tienCoc.setText("0");
		txt__tienPhong.setText("400000");
		txt__tongHoaDon.setText("500000");

		JPanel panel_1_1_3_2 = new JPanel();
		panel_1_1_3_2.setLayout(null);
		panel_1_1_3_2.setBackground(Color.WHITE);
		panel_1_1_3_2.setBounds(101, 57, 157, 76);
		panel.add(panel_1_1_3_2);

		JLabel lblNewLabel_1_2_3_2 = new JLabel("Tổng hóa đơn của phòng");
		lblNewLabel_1_2_3_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_3_2.setBounds(0, 11, 157, 23);
		panel_1_1_3_2.add(lblNewLabel_1_2_3_2);

//		txt__tienhoadonPhong = new JTextField();
//		txt__tienhoadonPhong.setText("500000");
//		txt__tienhoadonPhong.setEnabled(false);
//		txt__tienhoadonPhong.setColumns(10);
//		txt__tienhoadonPhong.setBounds(0, 38, 157, 28);
//		panel_1_1_3_2.add(txt__tienhoadonPhong);
//		txt_khachHang.setText(khachHang.getHoTen());
//		txt__giaPhong.setText(Double.toString(loaiPhong.getGiaTien()));

		btn__thanhToan.setEnabled(false);
		btn__exit.addActionListener(this);
		btn__thanhToan.addActionListener(this);
		table_Phong.addMouseListener((MouseListener) this);
		txt__tienKhachDua.addActionListener(this);

		renderTablePhong();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn__exit)) {
			this.setVisible(false);
		}
		if (o.equals(btn__thanhToan)) {

			for (int row = 0; row < modal_Phong.getRowCount(); row++) {
				Boolean checked = (Boolean) modal_Phong.getValueAt(row, 4);
				if (checked) {
					String maPhong = (String) modal_Phong.getValueAt(row, 0);
					String maKhachHang = (String) modal_Phong.getValueAt(row, 1);
					int soLuong = (int) modal_Phong.getValueAt(row, 2);
					double giaTien = (double) modal_Phong.getValueAt(row, 3);

					// Xử lý dữ liệu của các hàng được chọn ở đây
					System.out.println("Mã phòng: " + maPhong);
					System.out.println("Mã khách hàng: " + maKhachHang);
					System.out.println("Số lượng: " + soLuong);
					System.out.println("Giá tiền: " + giaTien);
				}
			}
			JOptionPane.showMessageDialog(null, "Thanh toán thành công!");

			// Xử lý cập nhật hóa đơn
			ChiTietHoaDon CTDV = new ChiTietHoaDon();
			ChiTietHoaDon_DAO DAO_CTDV = new ChiTietHoaDon_DAO();

			CTDV = DAO_CTDV.timCTHoaDon_TheoMaPhong(phong.getMaPhong());

			HoaDon HD = new HoaDon();
			HoaDon_DAO DAO_HD = new HoaDon_DAO();
			HD = DAO_HD.layHoaDon_TheoMaHoaDon(CTDV.getHoaDon().getMaHoaDon());

			KhachHang KH = new KhachHang();
			KhachHang_DAO DAO_KH = new KhachHang_DAO();
			KH = DAO_KH.layKhachHang_TheoMaKhachHang(HD.getKhachHang().getMaKhachHang());

			NhanVien NV = new NhanVien();
			NhanVien_DAO DAO_NV = new NhanVien_DAO();
			NV = DAO_NV.timNhanVien_TheoMaNhanVien(HD.getNhanVien().getMaNhanVien());

			KhuyenMai KM = new KhuyenMai();
			KhuyenMai_DAO DAO_KM = new KhuyenMai_DAO();
			KM = DAO_KM.layKhuyenMai_TheoMaKhuyenMai(HD.getKhuyenMai().getMaKhuyenMai());

			PhieuDatPhong PD = new PhieuDatPhong();
			PhieuDatPhong_DAO DAO_PD = new PhieuDatPhong_DAO();
			PD = DAO_PD.layPhieuDatPhong_TheoMaPhieuDat(HD.getPhieuDatPhong().getMaPhieuDat());

			HD = new HoaDon(CTDV.getHoaDon().getMaHoaDon(), KH, NV, PD, KM, HD.getNgayLap(), "Đã thanh toán",
					HD.getNgayLap());
			DAO_HD.capNhatHoaDon(HD);
		}
		if (o.equals(txt__tienKhachDua)) {

			String regex = "^[0-9]+(\\.[0-9]+)?$";
			Pattern pattern = Pattern.compile(regex);
			java.util.regex.Matcher matcher = pattern.matcher(txt__tienKhachDua.getText());

			if (!txt__tienKhachDua.equals("")) {
				if (matcher.matches()) {
					btn__thanhToan.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Số tiền nhập vào phải là số!");
				}
			}

			tienKhach = new BigDecimal(txt__tienKhachDua.getText());
			tienTongP = new BigDecimal(txt__tienhoadonPhong.getText());

			BigDecimal tienTong = tienKhach.subtract(tienTongP);

			int comparison = tienTong.compareTo(BigDecimal.ZERO);
			// dcf.format()
			if (comparison < 0) {
				txt__tienThoiLai.setText(tienTong.toString());
			} 
			else {
				// Nhân kết quả cho 5%
				BigDecimal percentage = new BigDecimal("0.05");
				BigDecimal finalTongTien = tienTong.multiply(percentage);
				
				txt__tienThoiLai.setText(dcf.format(finalTongTien));
			}
		}
	}

	public void renderTablePhong() {
		DAO_PhieuDat = new PhieuDatPhong_DAO();
		DAO_Phong = new Phong_DAO();
		DAO_LP = new LoaiPhong_DAO();

		phieuDat_maPhong = new PhieuDatPhong();

		ArrayList<PhieuDatPhong> listPhieuDat = new ArrayList<>();

		phieuDat_maPhong = DAO_PhieuDat.layPhieuDatPhong_TheoMaPhong(phong.getMaPhong());
		listPhieuDat = DAO_PhieuDat.layTatCaPhieuDatPhong();

		for (PhieuDatPhong value : listPhieuDat) {
			if (phieuDat_maPhong.getKhachHang().getMaKhachHang().equals(value.getKhachHang().getMaKhachHang())) {
				phong = DAO_Phong.timPhong_TheoMaPhong(value.getPhong().getMaPhong());
				loaiPhong = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(phong.getLoaiPhong().getMaLoaiPhong());

				Object[] rowData = { value.getPhong().getMaPhong(), value.getKhachHang().getMaKhachHang(),
						loaiPhong.getSoLuongToiDa(), loaiPhong.getGiaTien(), true };

				modal_Phong.addRow(rowData);

			}
		}

	}

	public void renderTableDichVu(String maP) {
		XoaDuLieuTrenTable();
		System.out.println(maP);

		ChiTietHoaDon chiTietHD = new ChiTietHoaDon();
		ChiTietHoaDon_DAO DAO_chiTietHD = new ChiTietHoaDon_DAO();
		chiTietHD = DAO_chiTietHD.timCTHoaDon_TheoMaPhong(maP);

//		System.out.println("CTHD?:::" + chiTietHD.toString());
		if (chiTietHD != null) {
			chiTietDV = new ChiTietDichVu();
			DAO_chiTietDV = new ChiTietDichVu_DAO();
			chiTietDV = DAO_chiTietDV.timCTDichVu_TheoMaHoaDon(chiTietHD.getHoaDon().getMaHoaDon());

			DichVu dv = new DichVu();
			DichVu_DAO DAO_DV = new DichVu_DAO();

			dv = DAO_DV.layDichVu_TheoMaDichVu(chiTietDV.getDichVu().getMaDichVu());

			Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(), dv.getSoLuong(), dv.getDonGia(),
					dv.getSoLuong() * dv.getDonGia(), "cap nhat" };

			modal_Dv.addRow(rowData);

		} else {
			System.out.println("Phong nay ko co dich vu");
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table_Phong.getSelectedRow();

		String maPhong = modal_Phong.getValueAt(row, 0).toString();
		String maKhachHang = modal_Phong.getValueAt(row, 1).toString();
		String soLuong = modal_Phong.getValueAt(row, 2).toString();
		String giaPhong = modal_Phong.getValueAt(row, 3).toString();

		renderTableDichVu(maPhong);

		phong = DAO_Phong.timPhong_TheoMaPhong(maPhong);
		loaiPhong = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(phong.getLoaiPhong().getMaLoaiPhong());

		DAO_KH = new KhachHang_DAO();
		khachHang = DAO_KH.layKhachHang_TheoMaKhachHang(maKhachHang);

		phieuDat_maPhong = DAO_PhieuDat.layPhieuDatPhong_TheoMaPhong(maPhong);

		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		String timeNhanPhong = sdf.format(phieuDat_maPhong.getThoiGianNhanPhong());
		String curentTime = sdf.format(currentDate);

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(currentDate);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(phieuDat_maPhong.getThoiGianNhanPhong());

		long millisecondsDiff = calendar1.getTimeInMillis() - calendar2.getTimeInMillis();
		long hourDiff = millisecondsDiff / (60 * 60 * 1000);
		long remainingMilliseconds = millisecondsDiff % (60 * 60 * 1000);
		long minDiff = remainingMilliseconds / (60 * 1000);

		DecimalFormat df = new DecimalFormat("#.#");

		int rowCount = table_DichVu.getRowCount();
		int sum = 0;

		for (int i = 0; i < rowCount; i++) {
			// Lấy giá trị ở hàng i, cột columnIndex
			Object value = table_DichVu.getValueAt(i, 4);

			// Kiểm tra giá trị có phải là số hay không trước khi thêm vào tổng
			if (value instanceof Number) {
				sum += ((Number) value).intValue();
			}
		}

		txt__maPhong.setText(maPhong);
		txt__loaiPhong.setText(loaiPhong.getTenLoaiPhong());
		txt_khachHang.setText(khachHang.getHoTen());
		txt__soDienThoai.setText(khachHang.getSoDienThoai());
		txt__thoiGianNhanPhong.setText(timeNhanPhong);
		txt__thoiGianTraPhong.setText(curentTime);
		txt__soGioHat.setText(String.valueOf(hourDiff) + ":" + String.valueOf(minDiff));
		txt__giaPhong.setText(String.valueOf(loaiPhong.getGiaTien()));
		txt__tienPhong.setText(df.format(loaiPhong.getGiaTien() * hourDiff + (minDiff * loaiPhong.getGiaTien() / 60)));
		txt__tienCoc.setText(String.valueOf(phieuDat_maPhong.getTienCoc()));
		txt__tienDichVu.setText(String.valueOf(sum));
		txt__tienhoadonPhong
				.setText(df.format(loaiPhong.getGiaTien() * hourDiff + (minDiff * loaiPhong.getGiaTien() / 60) + sum));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void XoaDuLieuTrenTable() {
		modal_Dv = (DefaultTableModel) table_DichVu.getModel();
		modal_Dv.getDataVector().removeAllElements();
	}
}