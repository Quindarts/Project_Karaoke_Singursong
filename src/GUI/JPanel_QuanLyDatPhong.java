package GUI;

import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import javax.swing.border.AbstractBorder;
import javax.swing.border.CompoundBorder;

import GUI.JFrame_ThuNgan.RoundedTransparentBorder;
import OtherFunction.HelpDate;
import OtherFunction.HelpRamDomMa;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;

import org.apache.poi.util.SystemOutLogger;

import com.ctc.wstx.shaded.msv_core.verifier.identity.Matcher;
import com.itextpdf.text.List;

import DAO.ChiTietDichVu_DAO;
import DAO.ChiTietHoaDon_DAO;
import DAO.DichVu_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiNhanVien_DAO;
import DAO.LoaiPhong_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.ChiTietHoaDon;
import Entity.DichVu;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.KhuyenMai;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;
import Entity.TrangThaiPhong;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class JPanel_QuanLyDatPhong extends JPanel implements ActionListener {

	/**
	 * Color
	 */

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Green = "#4BAC4D";

	private JTabbedPane tabbedPane;
	private JPanel panel_PDP;
	private JPanel panel_PhongBan;
	private JPanel panel_ThucDon;
	private JPanel panel_Phong;
	private JPanel panel_DanhSachThucDon;
	private JPanel panel_TraCuuPhong;
	private JLabel lblThongTinPhongHat;
	private JLabel lblTenKhachHang;
	private JLabel lblSDT;
	private JLabel lblSLKhach;
	private JLabel lblLoiPhng;
	private JLabel lblTnPhng;

	private JTable table_DanhSachPhong;

	private Phong_DAO phongDao;
	private JTextField txtTenNhanVienDat;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txt_maPhongTK;

	private JComboBox cbo_loaiPhong;

	// panigation
	private JLabel lblNewLabelDichVu;
	private JButton btnTrangTruocDichVu;
	private JButton btnTrangCuoiDichVu;
	private JButton btnTrangDauDichVu;
	private JButton btnTrangSauDichVu;
	private JTextField txt_TongTrangDichVu;
	private JTextField txtTrangDichVu;
	// panigation
	private JLabel lblNewLabel;
	private JButton btnXacNhanDatPhong;
	private JButton btnTrangDauPhong;
	private JButton btnTrangSauPhong;
	private JButton btnTrangTruocPhong;
	private JButton btnTrangCuoiPhong;
	private JTextField txtTrang;
	private JTextField txt_TongTrang;

	private JSpinner spnThoiGianNhanPhong;
	private JSpinner spnThoiGianDatPhong;

	private DichVu_DAO DAO_DV;
	private ArrayList<Phong> dsPhong;
	private ArrayList<Phong> dsPhongDangDat = new ArrayList<Phong>();
	private DefaultTableModel model_TableDSPhong;

	private JButton btnLamMoiDanhSachPhong;
	private ArrayList<LoaiPhong> dsLoaiPhong;
	private ArrayList<TrangThaiPhong> dsTrangThai;
	private JComboBox cbo_trangThai;
	private JTextField txt_soDienThoaiTK;
	private JPanel panel_2;
	private JPanel panel_boxSLDaDat;
	private JLabel lblNewLabel_2;
	private JPanel panel_4;
	private JPanel panel_boxSLDangDung;
	private JLabel lblNewLabel_3;
	private JPanel panel_6;
	private JPanel panel_boxSLKhongPhucVu;
	private JLabel lblNewLabel_4;

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	private NhanVien nhanVien;
	private JButton btn_timKiem;
	private JButton btn_lamMoi;
	private JScrollPane scroll_Phong;
	private JTextField txt_tenKhachHangTK;
	private JButton btn_lamMoiThongTin;
	private HelpRamDomMa help;
	private JTextField txt_ngayLap;
	private JTextField txt_maHoaDon;

	/**
	 * Rounded JPanel
	 */
	public class RoundedTransparentBorder extends AbstractBorder {
		private int cornerRadius;
		private Color borderColor;
		private Color backgroundColor;
		private float alpha;

		public RoundedTransparentBorder(int cornerRadius, Color borderColor, Color backgroundColor, float alpha) {
			this.cornerRadius = cornerRadius;
			this.borderColor = borderColor;
			this.backgroundColor = backgroundColor;
			this.alpha = alpha;
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
		}

		@Override
		public Insets getBorderInsets(Component c, Insets insets) {
			insets.left = insets.top = insets.right = insets.bottom = cornerRadius;
			return insets;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			if (width <= 0 || height <= 0) {
				return;
			}

			Graphics2D g2d = (Graphics2D) g.create();

			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

			RoundRectangle2D.Float roundRect = new RoundRectangle2D.Float(x, y, width - 1, height - 1, cornerRadius,
					cornerRadius);

			g2d.setColor(backgroundColor);
			g2d.fill(roundRect);
			g2d.setColor(borderColor);
			g2d.draw(roundRect);

			g2d.dispose();
		}

	}

	public JPanel_QuanLyDatPhong(NhanVien nhanVien) {

		setNhanVien(nhanVien);
		Phong_DAO DAO_P = new Phong_DAO();

		// GUI
		setBackground(Color.decode(hexColor_Blue1));
		setBounds(0, 0, 1296, 672);
		setLayout(null);

		panel_PDP = new JPanel();
		panel_PDP.setBorder(null);
		panel_PDP.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_PDP.setBackground(Color.decode(hexColor_Blue1));
		panel_PDP.setBounds(868, 0, 428, 672);
		add(panel_PDP);
		panel_PDP.setLayout(null);

		String maHD = help.taoMa("HoaDon", "maHoaDon", "HD");

		lblThongTinPhongHat = new JLabel("THÔNG TIN ĐẶT PHÒNG");
		lblThongTinPhongHat.setForeground(Color.decode(hexColor_Blue1));

		lblThongTinPhongHat.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinPhongHat.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblThongTinPhongHat.setBounds(10, 10, 418, 34);
		panel_PDP.add(lblThongTinPhongHat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 306, 408, 281);

		panel_PDP.add(scrollPane);

		// Table Danh Sach Phong start
		table_DanhSachPhong = new JTable();

		model_TableDSPhong = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã Phòng", "Tên Phòng", "Giá Phòng", "" });
		table_DanhSachPhong.setModel(model_TableDSPhong);
		scrollPane.setViewportView(table_DanhSachPhong);

		TableColumn col_stt = table_DanhSachPhong.getColumnModel().getColumn(0);
		col_stt.setPreferredWidth(10);

		TableColumn btn__CapNhatTableDichVu = table_DanhSachPhong.getColumnModel().getColumn(4);
		btn__CapNhatTableDichVu.setPreferredWidth(25);

		btn__CapNhatTableDichVu.setCellRenderer(new ButtonCellRendererEditor(model_TableDSPhong, table_DanhSachPhong));
		btn__CapNhatTableDichVu.setCellEditor(new ButtonCellRendererEditor(model_TableDSPhong, table_DanhSachPhong));
		// Table Danh Sach Phong end

		JPanel panel_TTKH = new JPanel();
		panel_TTKH.setBackground(Color.decode(hexColor_Blue4));
		panel_TTKH.setBounds(10, 54, 408, 202);
		panel_PDP.add(panel_TTKH);
		panel_TTKH.setLayout(null);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(157, 11, 241, 25);
		panel_TTKH.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(18, 11, 115, 25);
		panel_TTKH.add(lblSDT);

		lblSDT.setForeground(Color.decode(hexColor_Blue1));
		lblSDT.setFont(new Font("Segoe UI", Font.BOLD, 13));

		txtTenKhachHang = new JTextField();

		txtTenKhachHang.setEnabled(false);
		txtTenKhachHang.setBounds(157, 47, 241, 25);
		panel_TTKH.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setBounds(18, 47, 115, 25);
		panel_TTKH.add(lblTenKhachHang);
		lblTenKhachHang.setForeground(Color.decode(hexColor_Blue1));
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 13));

		lblSLKhach = new JLabel("Tên nhân viên lập");
		lblSLKhach.setForeground(new Color(5, 74, 145));
		lblSLKhach.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSLKhach.setBounds(18, 83, 138, 25);
		panel_TTKH.add(lblSLKhach);

		txtTenNhanVienDat = new JTextField();
		txtTenNhanVienDat.setColumns(10);
		txtTenNhanVienDat.setEditable(false);
		txtTenNhanVienDat.setText(nhanVien.getHoTen());
		txtTenNhanVienDat.setBounds(157, 83, 241, 25);
		panel_TTKH.add(txtTenNhanVienDat);

		JLabel lblMaPhong = new JLabel("Mã hóa đơn");
		lblMaPhong.setForeground(new Color(5, 74, 145));
		lblMaPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPhong.setBounds(18, 118, 106, 21);
		panel_TTKH.add(lblMaPhong);

		JLabel lblNgyLpHa = new JLabel("Ngày lập hóa đơn");
		lblNgyLpHa.setForeground(new Color(5, 74, 145));
		lblNgyLpHa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNgyLpHa.setBounds(18, 158, 111, 21);
		panel_TTKH.add(lblNgyLpHa);

		txt_ngayLap = new JTextField();
		txt_ngayLap.setText("22-11-2023");
		txt_ngayLap.setEnabled(false);
		txt_ngayLap.setEditable(false);
		txt_ngayLap.setColumns(10);
		txt_ngayLap.setBounds(157, 157, 241, 25);
		panel_TTKH.add(txt_ngayLap);

		help = new HelpRamDomMa();
		txt_maHoaDon = new JTextField(help.taoMa("HoaDon", "maHoaDon", "HD"));
		txt_maHoaDon.setEnabled(false);
		txt_maHoaDon.setEditable(false);
		txt_maHoaDon.setColumns(10);
		txt_maHoaDon.setBounds(157, 120, 241, 25);
		panel_TTKH.add(txt_maHoaDon);
		Calendar ca = new GregorianCalendar();
		int day = ca.get(Calendar.DAY_OF_MONTH);
		int month = ca.get(Calendar.MONTH);
		int year = ca.get(Calendar.YEAR);

		btnXacNhanDatPhong = new JButton("Đặt phòng ngay");
		btnXacNhanDatPhong.setBounds(55, 609, 155, 35);

		btnLamMoiDanhSachPhong = new JButton("Làm mới danh sách");
		btnLamMoiDanhSachPhong.setSize(140, 20);
		btnLamMoiDanhSachPhong.setLocation(284, 390);

		panel_PDP.add(btnXacNhanDatPhong);
//		panel_PDP.add(btnLamMoiDanhSachPhong);

		btnXacNhanDatPhong.setBackground(Color.decode(hexColor_Green));
		btnXacNhanDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnXacNhanDatPhong.setForeground(Color.white);

		btn_lamMoiThongTin = new JButton("Làm mới thông tin");
		btn_lamMoiThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_lamMoiThongTin.setForeground(Color.WHITE);
		btn_lamMoiThongTin.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_lamMoiThongTin.setBackground(new Color(255, 153, 51));
		btn_lamMoiThongTin.setBounds(233, 609, 155, 35);
		panel_PDP.add(btn_lamMoiThongTin);

		JLabel lbl_dsPhongDat = new JLabel("DANH SÁCH PHÒNG ĐẶT");
		lbl_dsPhongDat.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dsPhongDat.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbl_dsPhongDat.setForeground(Color.decode(hexColor_Blue1));
		lbl_dsPhongDat.setBackground(Color.WHITE);
		lbl_dsPhongDat.setBounds(10, 276, 408, 25);
		panel_PDP.add(lbl_dsPhongDat);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.decode(hexColor_Blue1));
		tabbedPane.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 12));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.putClientProperty("TabbedPane.showTabSeparators", true);
		tabbedPane.setBounds(0, 0, 868, 672);
		add(tabbedPane);

		// CONNECT DAO_DV
		DAO_DV = new DichVu_DAO();
		int soLuong = DAO_DV.soLuongDichVu() / 8;

		if (DAO_DV.soLuongDichVu() % 8 > 0) {

			soLuong = DAO_DV.soLuongDichVu() / 8 + 1;
		}

		SpinnerDateModel dateModel1 = new SpinnerDateModel();
		dateModel1.setCalendarField(Calendar.MINUTE);

		spnThoiGianNhanPhong = new JSpinner(dateModel1);
		JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spnThoiGianNhanPhong, "HH:mm");
		spnThoiGianNhanPhong.setEditor(editor1);
		spnThoiGianNhanPhong.setBounds(218, 39, 65, 19);

//		panel_TraCuuPhong.add(spnThoiGianNhanPhong);

		SpinnerDateModel dateModel2 = new SpinnerDateModel();
		dateModel2.setCalendarField(Calendar.MINUTE);
		spnThoiGianDatPhong = new JSpinner(dateModel2);
		spnThoiGianDatPhong.setEnabled(false);
		JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spnThoiGianDatPhong, "HH:mm");
		spnThoiGianDatPhong.setEditor(editor2);
		spnThoiGianDatPhong.setBounds(513, 39, 65, 19);
//		panel_TraCuuPhong.add(spnThoiGianDatPhong);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 77, 843, 515);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		Phong_DAO DAO_P1 = new Phong_DAO();
		int soLuongPhong = DAO_P.soLuongPhong() / 15;

		if (DAO_P.soLuongPhong() % 15 > 0) {

			soLuongPhong = DAO_P.soLuongPhong() / 15 + 1;
		}
		panel_ThucDon = new JPanel();
		panel_ThucDon.setBackground(Color.white);

		// DANH SACH THUC DON

		// panigation DICH VU

		// btnTrangDauPhong
		btnTrangDauDichVu = new JButton("");
		btnTrangDauDichVu.setForeground(new Color(255, 255, 255));
		btnTrangDauDichVu.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/skip_to_start_20px.png")));
		btnTrangDauDichVu.setFocusPainted(false);
		btnTrangDauDichVu.setBorder(null);
		btnTrangDauDichVu.setBackground(Color.decode(hexColor_Blue3));
		btnTrangDauDichVu.setBounds(70, 5, 20, 20);

		// btnTrangSauPhong
		btnTrangSauDichVu = new JButton("");
		btnTrangSauDichVu.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/rewind_20px.png")));
		btnTrangSauDichVu.setFocusPainted(false);
		btnTrangSauDichVu.setBorder(null);
		btnTrangSauDichVu.setBackground(Color.decode(hexColor_Blue3));
		btnTrangSauDichVu.setBounds(95, 5, 20, 20);

		// btnTrang Hientai
		txtTrangDichVu = new JTextField();
		txtTrangDichVu.setEditable(false);
		txtTrangDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangDichVu.setColumns(5);
		txtTrangDichVu.setBounds(120, 5, 51, 19);

		// btnTrangTruocPhong
		btnTrangTruocDichVu = new JButton("");
		btnTrangTruocDichVu
				.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/fast_forward_20px.png")));
		btnTrangTruocDichVu.setFocusPainted(false);
		btnTrangTruocDichVu.setBorder(null);
		btnTrangTruocDichVu.setBackground(Color.decode(hexColor_Blue3));
		btnTrangTruocDichVu.setBounds(241, 5, 20, 20);

		// btnTrangCuoiPhong
		btnTrangCuoiDichVu = new JButton("");
		btnTrangCuoiDichVu.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/end_20px.png")));
		btnTrangCuoiDichVu.setFocusPainted(false);
		btnTrangCuoiDichVu.setBorder(null);
		btnTrangCuoiDichVu.setBackground(Color.decode(hexColor_Blue3));
		btnTrangCuoiDichVu.setBounds(266, 5, 20, 20);
		JPanel panel_panigationPhongDichVu = new JPanel();
		panel_panigationPhongDichVu.setBackground(new Color(255, 255, 255));
		panel_panigationPhongDichVu.setBounds(220, 564, 356, 31);
		panel_panigationPhongDichVu.setLayout(null);

		panel_panigationPhongDichVu.add(btnTrangDauDichVu);
		panel_panigationPhongDichVu.add(btnTrangSauDichVu);
		panel_panigationPhongDichVu.add(txtTrangDichVu);

		lblNewLabelDichVu = new JLabel("/");
		lblNewLabelDichVu.setBounds(176, 8, 4, 13);
		panel_panigationPhongDichVu.add(lblNewLabelDichVu);

		txt_TongTrangDichVu = new JTextField();
		txt_TongTrangDichVu.setBounds(185, 5, 51, 19);
		txt_TongTrangDichVu.setEditable(false);
		panel_panigationPhongDichVu.add(txt_TongTrangDichVu);
		txt_TongTrangDichVu.setColumns(5);

		txt_TongTrangDichVu.setText(Integer.toString(soLuong));
		panel_panigationPhongDichVu.add(btnTrangTruocDichVu);
		panel_panigationPhongDichVu.add(btnTrangCuoiDichVu);
		panel_ThucDon.add(panel_panigationPhongDichVu);

		panel_PhongBan = new JPanel();
		panel_PhongBan.setBackground(Color.WHITE);

		tabbedPane.addTab("PHÒNG HÁT", new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/door-open.png")),
				panel_PhongBan, null);
		panel_PhongBan.setLayout(null);

		tabbedPane.addTab("THỰC ĐƠN", new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/food-service.png")),
				panel_ThucDon, null);
		panel_ThucDon.setLayout(null);
		panel_DanhSachThucDon = new JPanel();
		panel_DanhSachThucDon.setBackground(new Color(255, 255, 255));
		panel_DanhSachThucDon.setBounds(0, 44, 806, 510);
		panel_ThucDon.add(panel_DanhSachThucDon);
		panel_DanhSachThucDon.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		panel_TraCuuPhong = new JPanel();
		panel_TraCuuPhong.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_TraCuuPhong.setBackground(new Color(255, 255, 255));
		panel_TraCuuPhong.setBounds(8, 2, 833, 70);
		panel_PhongBan.add(panel_TraCuuPhong);
		panel_TraCuuPhong.setLayout(null);

		cbo_loaiPhong = new JComboBox();
		cbo_loaiPhong.setBounds(127, 12, 120, 22);
		panel_TraCuuPhong.add(cbo_loaiPhong);
		cbo_loaiPhong.addItem("Tất cả");

		txt_maPhongTK = new JTextField();
		txt_maPhongTK.setBounds(638, 14, 63, 20);
		panel_TraCuuPhong.add(txt_maPhongTK);
		txt_maPhongTK.setText("");
		txt_maPhongTK.setColumns(10);

		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btn_timKiem.setBounds(711, 12, 89, 23);
		btn_timKiem.setForeground(Color.white);
		btn_timKiem.setBackground(Color.decode(hexColor_Green));
		panel_TraCuuPhong.add(btn_timKiem);

		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btn_lamMoi.setBounds(711, 44, 89, 23);
		btn_lamMoi.setForeground(Color.white);
		btn_lamMoi.setBackground(Color.decode(hexColor_Blue1));
		panel_TraCuuPhong.add(btn_lamMoi);

		lblLoiPhng = new JLabel("Loại phòng");
		lblLoiPhng.setForeground(new Color(5, 74, 145));
		lblLoiPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoiPhng.setBounds(10, 12, 90, 21);
		panel_TraCuuPhong.add(lblLoiPhng);

		lblTnPhng = new JLabel("Mã phòng");
		lblTnPhng.setForeground(new Color(5, 74, 145));
		lblTnPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTnPhng.setBounds(558, 12, 90, 21);
		panel_TraCuuPhong.add(lblTnPhng);

		JLabel lblTrngThiPhng = new JLabel("Trạng thái phòng");
		lblTrngThiPhng.setForeground(new Color(5, 74, 145));
		lblTrngThiPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTrngThiPhng.setBounds(10, 44, 112, 21);
		panel_TraCuuPhong.add(lblTrngThiPhng);

		cbo_trangThai = new JComboBox();
		cbo_trangThai.setBounds(127, 45, 120, 21);
		panel_TraCuuPhong.add(cbo_trangThai);

		txt_soDienThoaiTK = new JTextField();
		txt_soDienThoaiTK.setBounds(391, 13, 157, 19);
		panel_TraCuuPhong.add(txt_soDienThoaiTK);
		txt_soDienThoaiTK.setColumns(10);

		JLabel lblSGiHt = new JLabel("Số điện thoại");
		lblSGiHt.setForeground(new Color(5, 74, 145));
		lblSGiHt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSGiHt.setBounds(265, 12, 116, 21);
		panel_TraCuuPhong.add(lblSGiHt);

		// scroll_Phong = new JScrollPane(panel_Phong);
		// scroll_Phong.setSize(806, 490);
		// scroll_Phong.setLocation(0, 84);
		//
		// scroll_Phong.add(panel_Phong);
		// scroll_Phong.setViewportView(panel_Phong);
		// panel_Phong.setLayout(new GridLayout(5, 0, 10, 10));
		// scroll_Phong.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// scroll_Phong.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// panel_PhongBan.add(scroll_Phong);
		// panigation PHONG

		// btnTrangDauPhong
		btnTrangDauPhong = new JButton("");
		btnTrangDauPhong.setForeground(new Color(255, 255, 255));
		btnTrangDauPhong.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/skip_to_start_20px.png")));
		btnTrangDauPhong.setFocusPainted(false);
		btnTrangDauPhong.setBorder(null);
		btnTrangDauPhong.setBackground(Color.decode(hexColor_Blue3));
		btnTrangDauPhong.setBounds(403, 585, 30, 25);

		// btnTrangSauPhong
		btnTrangSauPhong = new JButton("");
		btnTrangSauPhong.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/rewind_20px.png")));
		btnTrangSauPhong.setFocusPainted(false);
		btnTrangSauPhong.setBorder(null);
		btnTrangSauPhong.setBackground(Color.decode(hexColor_Blue3));
		btnTrangSauPhong.setBounds(440, 585, 30, 25);

		// btnTrang Hientai
		txtTrang = new JTextField();
		txtTrang.setEditable(false);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setColumns(2);
		txtTrang.setBounds(482, 585, 30, 25);

		// btnTrangTruocPhong
		btnTrangTruocPhong = new JButton("");
		btnTrangTruocPhong.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/fast_forward_20px.png")));
		btnTrangTruocPhong.setFocusPainted(false);
		btnTrangTruocPhong.setBorder(null);
		btnTrangTruocPhong.setBackground(Color.decode(hexColor_Blue3));
		btnTrangTruocPhong.setBounds(522, 585, 30, 25);

		// btnTrangCuoiPhong
		btnTrangCuoiPhong = new JButton("");
		btnTrangCuoiPhong.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/end_20px.png")));
		btnTrangCuoiPhong.setFocusPainted(false);
		btnTrangCuoiPhong.setBorder(null);
		btnTrangCuoiPhong.setBackground(Color.decode(hexColor_Blue3));
		// btnTrangCuoiPhong.setBackground(Color.WHITE);
		btnTrangCuoiPhong.setBounds(559, 585, 30, 25);
		JPanel panel_panigationPhong = new JPanel();
		panel_panigationPhong.setBackground(new Color(255, 255, 255));
		panel_panigationPhong.setBounds(33, 573, 300, 31);

		panel_panigationPhong.add(btnTrangDauPhong);
		panel_panigationPhong.add(btnTrangSauPhong);
		panel_panigationPhong.add(txtTrang);

		lblNewLabel = new JLabel("/");
		panel_panigationPhong.add(lblNewLabel);

		txt_TongTrang = new JTextField();
		txt_TongTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txt_TongTrang.setEditable(false);
		panel_panigationPhong.add(txt_TongTrang);
		txt_TongTrang.setColumns(2);

		txt_TongTrang.setText(Integer.toString(soLuongPhong));
		panel_panigationPhong.add(btnTrangTruocPhong);
		panel_panigationPhong.add(btnTrangCuoiPhong);

		// Ban Dau
		panel_Phong = new JPanel();
		FlowLayout fl_panel_Phong = new FlowLayout(FlowLayout.LEFT);
		fl_panel_Phong.setVgap(10);
		fl_panel_Phong.setHgap(10);
		panel_Phong.setLayout(fl_panel_Phong);
		panel_Phong.setBackground(new Color(255, 255, 255));
		panel_Phong.setSize(843, 485);
		panel_Phong.setLocation(10, 78);
		panel_PhongBan.add(panel_Phong);
		panel_PhongBan.add(panel_panigationPhong);
		// Ban Dau

		txt_soDienThoaiTK.setEditable(false);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setForeground(new Color(5, 74, 145));
		lblTnKhchHng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTnKhchHng.setBounds(265, 44, 112, 21);
		panel_TraCuuPhong.add(lblTnKhchHng);

		txt_tenKhachHangTK = new JTextField();
		txt_tenKhachHangTK.setBounds(391, 46, 157, 19);
		panel_TraCuuPhong.add(txt_tenKhachHangTK);
		txt_tenKhachHangTK.setColumns(10);
		txt_tenKhachHangTK.setEditable(false);

		JPanel panel = new JPanel();
		panel.setBounds(343, 573, 100, 25);
		panel_PhongBan.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JPanel panel_boxSLTrong = new JPanel();
		panel_boxSLTrong.setBackground(new Color(255, 255, 255));
		panel_boxSLTrong.setBounds(10, 2, 31, 20);
		panel.add(panel_boxSLTrong);
		panel_boxSLTrong.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Trống");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(51, 5, 45, 13);
		panel.add(lblNewLabel_1);

		panel_boxSLTrong.setBackground(Color.decode("#00a65a"));

		panel_2 = new JPanel();
		panel_2.setBounds(441, 573, 100, 25);
		panel_PhongBan.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);

		panel_boxSLDaDat = new JPanel();
		panel_boxSLDaDat.setLayout(null);
		panel_boxSLDaDat.setBackground(Color.WHITE);
		panel_boxSLDaDat.setBounds(10, 2, 31, 20);
		panel_2.add(panel_boxSLDaDat);

		lblNewLabel_2 = new JLabel("Đã đặt");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_2.setBounds(51, 5, 45, 13);
		panel_2.add(lblNewLabel_2);

		panel_boxSLDaDat.setBackground(Color.decode("#3c8dbc"));

		panel_4 = new JPanel();
		panel_4.setBounds(536, 573, 133, 25);
		panel_PhongBan.add(panel_4);
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);

		panel_boxSLDangDung = new JPanel();
		panel_boxSLDangDung.setLayout(null);
		panel_boxSLDangDung.setBackground(Color.WHITE);
		panel_boxSLDangDung.setBounds(10, 2, 31, 20);
		panel_4.add(panel_boxSLDangDung);

		lblNewLabel_3 = new JLabel("Đang dùng");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_3.setBounds(51, 5, 72, 13);
		panel_4.add(lblNewLabel_3);
		panel_boxSLDangDung.setBackground(Color.decode("#ff6868"));

		panel_6 = new JPanel();
		panel_6.setBounds(666, 573, 136, 25);
		panel_PhongBan.add(panel_6);
		panel_6.setBackground(Color.WHITE);
		panel_6.setLayout(null);

		panel_boxSLKhongPhucVu = new JPanel();
		panel_boxSLKhongPhucVu.setLayout(null);
		panel_boxSLKhongPhucVu.setBackground(Color.WHITE);
		panel_boxSLKhongPhucVu.setBounds(10, 2, 31, 20);
		panel_6.add(panel_boxSLKhongPhucVu);

		lblNewLabel_4 = new JLabel("Khộng phục vụ");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_4.setBounds(51, 5, 91, 13);
		panel_6.add(lblNewLabel_4);
		panel_boxSLKhongPhucVu.setBackground(Color.decode("#b0bec5"));

		// Event panigation
		btnTrangCuoiPhong.addActionListener(this);
		btnTrangDauPhong.addActionListener(this);
		btnTrangSauPhong.addActionListener(this);
		btnTrangTruocPhong.addActionListener(this);

		btn_timKiem.addActionListener(this);
		btn_lamMoi.addActionListener(this);
		btn_lamMoiThongTin.addActionListener(this);
		// Event panigation

		cbo_trangThai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Xử lý khi một mục được chọn
				if (cbo_trangThai.getSelectedItem().toString().trim().equals("Đang sử dụng")
						|| cbo_trangThai.getSelectedItem().toString().trim().equals("Đã đặt")) {
					txt_soDienThoaiTK.setEditable(true);
					txt_tenKhachHangTK.setEditable(true);
				}
				if (cbo_trangThai.getSelectedItem().toString().trim().equals("Trống")
						|| cbo_trangThai.getSelectedItem().toString().trim().equals("Không phục vụ")) {
					txt_soDienThoaiTK.setEditable(false);
					txt_tenKhachHangTK.setEditable(false);
				}
			}
		});

//		capNhatTrangThaiPhongTrong();
		denTrangDauPhong();

		denTrangDauDichVu();

		try {
			LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();
			TrangThaiPhong_DAO DAO_TTP = new TrangThaiPhong_DAO();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {

			LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();
			TrangThaiPhong_DAO DAO_TTTP = new TrangThaiPhong_DAO();
			dsLoaiPhong = DAO_LP.layTatCaLoaiPhong();
			dsTrangThai = DAO_TTTP.layTatCaTrangThaiPhong();

			dsTrangThai.forEach(ttp -> {
				cbo_trangThai.addItem(ttp.getTenTrangThai());

			});

			dsLoaiPhong.forEach(lp -> {
				cbo_loaiPhong.addItem(lp.getTenLoaiPhong());
			});

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		btnTrangCuoiDichVu.addActionListener(this);
		btnTrangDauDichVu.addActionListener(this);
		btnTrangSauDichVu.addActionListener(this);
		btnTrangTruocDichVu.addActionListener(this);

		btnLamMoiDanhSachPhong.addActionListener(this);
		btnXacNhanDatPhong.addActionListener(this);

		// EVENT DAT PHONG
		btnXacNhanDatPhong.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String regexHoTen = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*";
				Pattern patternHoTen = Pattern.compile(regexHoTen);
				java.util.regex.Matcher matcher = patternHoTen.matcher(txtTenKhachHang.getText().trim());

				if (matcher.matches()) {
					datPhongTaiQuay();
				} else {
					JOptionPane.showMessageDialog(null, "Tên Khách hàng không hợp lệ, vui lòng thử lại.",
							"Không thành công", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		// Check sdt
		txtSoDienThoai.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					txtTenKhachHang.setText("");
					String regexSDT = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
					Pattern patternSDT = Pattern.compile(regexSDT);

					java.util.regex.Matcher matcher = patternSDT.matcher(txtSoDienThoai.getText().trim());

					if (!matcher.matches()) {
						JOptionPane.showMessageDialog(null,
								"Số điện thoại bạn nhập vào không tồn tại, vui lòng thêm khách hàng mới",
								"Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
					} else {
						txtTenKhachHang.setEnabled(true);
					}

					if (txtSoDienThoai.getText().trim() == "") {
						JOptionPane.showMessageDialog(null, "Số điện thoại nhập vào không được trống", "Thông báo lỗi",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (txtSoDienThoai.getText().trim() != "" && matcher.matches()) {
						KhachHang_DAO KH_DAO = new KhachHang_DAO();
						KhachHang kh = new KhachHang();

						if (KH_DAO.layKhachHang_TheoSDT(txtSoDienThoai.getText().trim()) != null) {
							kh = KH_DAO.layKhachHang_TheoSDT(txtSoDienThoai.getText().trim());
							txtTenKhachHang.setText(kh.getHoTen());
							txtTenKhachHang.setEnabled(false);
						} else {
							txtTenKhachHang.setEnabled(true);
							JOptionPane.showMessageDialog(null,
									"Số điện thoại bạn nhập vào không tồn tại, vui lòng thêm khách hàng mới",
									"Thông báo lỗi", JOptionPane.INFORMATION_MESSAGE);
							JDialog_ThemKhachHang modal_ThemKhachHang = new JDialog_ThemKhachHang();
							modal_ThemKhachHang.setVisible(true);
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_lamMoiThongTin)) {
			clearForm();
			clearTablePhongDaDat();
		}
		if (o.equals(btn_lamMoi)) {
			clearFormTimKiem();
			clearTablePhongDaDat();
			try {
				Phong_DAO DAO_P = new Phong_DAO();
				ArrayList<Phong> dsP = new ArrayList<>();
				if (DAO_P.capNhatTatCaPhong_TrangThaiPhongMoiNhat()) {
					System.out.println("Connect đến danh sách phòng mới thành công");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				// TODO: handle exception
			}
			denTrangDauPhong();
		}

		if (o.equals(btn_timKiem)) {
			timKiemTongHopPhong();
		}
		// Event panigation
		if (o.equals(btnTrangSauPhong)) {
			denTrangSauPhong();
		}
		if (o.equals(btnTrangTruocPhong)) {
			denTrangTruocPhong();
		}
		if (o.equals(btnTrangDauPhong)) {
			denTrangDauPhong();
		}
		if (o.equals(btnTrangCuoiPhong)) {
			denTrangCuoiPhong();
		}
		// Event panigation
		if (o.equals(btnTrangSauDichVu)) {
			denTrangSauDichVu();
		}
		if (o.equals(btnTrangTruocDichVu)) {
			denTrangTruocDichVu();
		}
		if (o.equals(btnTrangDauDichVu)) {
			denTrangDauDichVu();
		}
		if (o.equals(btnTrangCuoiDichVu)) {
			denTrangCuoiDichVu();
		}
		if (o.equals(btnLamMoiDanhSachPhong)) {
			if (dsPhongDangDat != null) {
				dsPhongDangDat.forEach(ph -> {

					LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();
					LoaiPhong lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(ph.getLoaiPhong().getMaLoaiPhong());
					model_TableDSPhong.addRow(new Object[] { 1, ph.getMaPhong().toString(), ph.getTenPhong().toString(),
							Double.toString(lp.getGiaTien()) });
				});
			}
		}
	}

	public void clearFormTimKiem() {
		txt_soDienThoaiTK.setText("");
		txt_maPhongTK.setText("");
		cbo_loaiPhong.setSelectedIndex(0);
		cbo_trangThai.setSelectedIndex(0);

	}

	public void clearTablePhongDaDat() {

		model_TableDSPhong.getDataVector().removeAllElements();
		model_TableDSPhong.fireTableDataChanged();
	}

	public void clearForm() {
		txtSoDienThoai.setText("");
		txtTenKhachHang.setText("");
		String maHD = help.taoMa("HoaDon", "maHoaDon", "HD");
		txt_maHoaDon.setText(maHD);
	}

	public void xoaDLPhong() {
		panel_Phong.removeAll();
		panel_Phong.revalidate();
		panel_Phong.repaint();
	}

	public void xoaDLDichVu() {
		panel_DanhSachThucDon.removeAll();
		panel_DanhSachThucDon.revalidate();
		panel_DanhSachThucDon.repaint();
	}

	public void DocDLDichVu(int fn, int ln) {
		DAO_DV = new DichVu_DAO();

		ArrayList<DichVu> dsDichVu = DAO_DV.phanTrangDichVu(fn, ln);
		if (dsDichVu != null) {
			dsDichVu.forEach(dv -> {

				JPanel_CardDichVu cardDV = new JPanel_CardDichVu(dv);
				panel_DanhSachThucDon.add(cardDV);
			});
		}
	}

	public void DocDLPhong(int fn, int ln) {
		phongDao = new Phong_DAO();
		dsPhong = phongDao.phanTrangPhong(fn, ln);
		if (dsPhong != null) {
			dsPhong.forEach(ph -> {
				JPanel_CardPhong cardPhong = new JPanel_CardPhong(ph, model_TableDSPhong, table_DanhSachPhong);
				panel_Phong.add(cardPhong);

				cardPhong.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {

//						if (e.getButton() == MouseEvent.BUTTON1) {
//							txtSoDienThoai.setText("");
//							txtTenKhachHang.setText("");
//							txtGioNhanPhong.setText("");
//
//							HelpDate hDate = new HelpDate();
//							txtMaPhong.setText(cardPhong.getPhong().getMaPhong());
//							PhieuDatPhong pdp = null;
//							PhieuDatPhong_DAO PDP_DAO = new PhieuDatPhong_DAO();
//							LoaiPhong_DAO LP_DAO = new LoaiPhong_DAO();
//							LoaiPhong loaiPhong = null;
//							if (!txtMaPhong.getText().trim().equals("")) {
//
//								pdp = PDP_DAO.layPhieuDatPhong_TheoMaPhong(txtMaPhong.getText());
//
//								if (pdp == null) {
//									clearForm();
//								}
//								KhachHang kh = new KhachHang();
//								KhachHang_DAO DAO_KH = new KhachHang_DAO();
//								try {
//
//									kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());
//									System.out
//											.println(cardPhong.getPhong().getTrangThaiPhong().getMaTrangThai().trim());
//									if (cardPhong.getPhong().getTrangThaiPhong().getMaTrangThai().trim().equals("OCP")
//											|| cardPhong.getPhong().getTrangThaiPhong().getMaTrangThai().trim()
//													.equals("OC")) {
//
//										txtTenKhachHang.setText(kh.getHoTen());
//										txtSoDienThoai.setText(kh.getSoDienThoai());
//
////										txtGioNhanPhong
////												.setText(hDate.chuyenDateThanhString(pdp.getThoiGianNhanPhong()));
//
//									}
//								} catch (Exception e2) {
//									// TODO: handle exception
//								}
//								try {
//									loaiPhong = LP_DAO.layLoaiPhong_TheoMaLoaiPhong(
//											cardPhong.getPhong().getLoaiPhong().getMaLoaiPhong());
//									txtTenPhong.setText(cardPhong.getPhong().getTenPhong());
//									txtLoaiPhong.setText(loaiPhong.getTenLoaiPhong());
//									txtGiaPhong.setText(String.valueOf(loaiPhong.getGiaTien()));
//								} catch (Exception e2) {
//									// TODO: handle exception
//									e2.printStackTrace();
//								}
//
//							}
//						}
					}
				});
			});
		}

	}

	public void datPhongTaiQuay() {

		Phong_DAO DAO_P = new Phong_DAO();
		HoaDon_DAO DAO_HD = new HoaDon_DAO();
		KhachHang_DAO DAO_KH = new KhachHang_DAO();
		KhachHang kh = new KhachHang();
		ChiTietHoaDon_DAO DAO_CTHD = new ChiTietHoaDon_DAO();
		Double tienCoc = 0.0;
		HelpRamDomMa help = new HelpRamDomMa();
		String maPDP = null;
		String maHD = null;
		try {
			maHD = help.taoMa("HoaDon", "maHoaDon", "HD");
		} catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}

		String maKhuyenMai = null;

		String maNhanVien = getNhanVien().getMaNhanVien();
		Date layNgayHienTai = new Date();
		Timestamp timestampNhanPhong = new Timestamp(layNgayHienTai.getTime());
		Timestamp timestampDatPhong = new Timestamp(layNgayHienTai.getTime());
		kh = DAO_KH.layKhachHang_TheoSDT(txtSoDienThoai.getText().toString().trim());
		HoaDon hd = new HoaDon(maHD, kh, nhanVien, null, new KhuyenMai(), timestampDatPhong, "Đang chờ thanh toán",
				null);

		if (DAO_HD.taoHoaDon(hd)) {
			int soLuongPhong = table_DanhSachPhong.getRowCount();
			int bienDem = 0;
			for (int i = 0; i < soLuongPhong; i++) {

				String maPhong = table_DanhSachPhong.getValueAt(i, 1).toString();
				Phong ph = DAO_P.timPhong_TheoMaPhong(maPhong);

				ChiTietHoaDon cthd = new ChiTietHoaDon(hd, ph);
				DAO_CTHD.taoCTHoaDon(cthd);
				DAO_P.capNhat_TranThaiPhong(maPhong, "OC");
				bienDem++;
			}

			if (bienDem == soLuongPhong && bienDem != 0) {
				JOptionPane.showMessageDialog(null, "Đặt phòng thành công");
				clearForm();
				clearFormTimKiem();
				clearTablePhongDaDat();
				xoaDLPhong();
				denTrangDauPhong();

			}
		}

	};

	public void denTrangTruocDichVu() {

		int soLuong = DAO_DV.soLuongDichVu();
		int soTrang = Integer.parseInt(txtTrangDichVu.getText());

		int trangLonNhat;
		if (soLuong % 8 == 0) {
			trangLonNhat = soLuong / 8;
		} else {
			trangLonNhat = soLuong / 8 + 1;
		}
		if (soTrang < trangLonNhat) {
			xoaDLDichVu();
			txtTrangDichVu.setText(String.valueOf(soTrang + 1));
			int fn = 8 * soTrang + 1;
			int ln = fn + 7;

			DocDLDichVu(fn, ln);

		}
	}

	public void denTrangSauDichVu() {

		int trang = Integer.parseInt(txtTrangDichVu.getText());
		if (trang > 1) {
			xoaDLDichVu();
			txtTrangDichVu.setText(String.valueOf(trang - 1));
			int fn = 8 * (trang - 2) + 1;
			int ln = fn + 7;

			DocDLDichVu(fn, ln);
		}

	}

	public void denTrangDauDichVu() {
		xoaDLDichVu();
		DocDLDichVu(1, 8);
		txtTrangDichVu.setText(String.valueOf(1));

	}

	public void denTrangCuoiDichVu() {
		xoaDLDichVu();
		int soLuong = DAO_DV.soLuongDichVu();
		int trangCuoi;
		if (soLuong % 8 == 0) {
			trangCuoi = soLuong / 8;
		} else {
			trangCuoi = soLuong / 8 + 1;
		}
		int fn = (trangCuoi - 1) * 8 + 1;
		int ln = fn + 7;

		DocDLDichVu(fn, ln);
		txtTrangDichVu.setText(String.valueOf(trangCuoi));

	}

	public void trangHienTaiDichVu() {
		xoaDLDichVu();
		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang * 8;
		int fn = ln - 7;

		DocDLDichVu(fn, ln);

	}

	// Event panigation phong
	public void denTrangDauPhong() {
		xoaDLPhong();
		DocDLPhong(1, 15);
		txtTrang.setText(String.valueOf(1));

	}

	public void denTrangCuoiPhong() {
		xoaDLPhong();
		int soLuong = phongDao.soLuongPhong();
		int trangCuoi;
		if (soLuong % 15 == 0) {
			trangCuoi = soLuong / 15;
		} else {
			trangCuoi = soLuong / 15 + 1;
		}
		int fn = (trangCuoi - 1) * 15 + 1;
		int ln = fn + 14;

		DocDLPhong(fn, ln);
		txtTrang.setText(String.valueOf(trangCuoi));

	}

	public void trangHienTaiPhong() {
		xoaDLPhong();
		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang * 15;
		int fn = ln - 14;

		DocDLPhong(fn, ln);

	}

	public void denTrangTruocPhong() {

		int soLuong = phongDao.soLuongPhong();
		int soTrang = Integer.parseInt(txtTrang.getText());

		int trangLonNhat;
		if (soLuong % 15 == 0) {
			trangLonNhat = soLuong / 15;
		} else {
			trangLonNhat = soLuong / 15 + 1;
		}
		if (soTrang < trangLonNhat) {
			xoaDLPhong();
			txtTrang.setText(String.valueOf(soTrang + 1));
			int fn = 15 * soTrang + 1;
			int ln = fn + 14;

			DocDLPhong(fn, ln);

		}
	}

	public void denTrangSauPhong() {

		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			xoaDLPhong();
			txtTrang.setText(String.valueOf(trang - 1));
			int fn = 15 * (trang - 2) + 1;
			int ln = fn + 14;

			DocDLPhong(fn, ln);
		}

	}

	public boolean kiemTraTrungMaPhongTrongDSPhong(String code, JTable table) {

		for (int row = 0; row < table.getRowCount(); row++) {
			String roomCode = table.getValueAt(row, 1).toString();

			if (roomCode.trim().equals(code)) {
				return false;
			}
		}
		return true;
	}

	public void timKiemTongHopPhong() {

		try {

			Phong_DAO dao = new Phong_DAO();

			String tenLP = cbo_loaiPhong.getSelectedItem().toString();
			String tenTTP = cbo_trangThai.getSelectedItem().toString();
			String maP = txt_maPhongTK.getText().toString().trim();
			String tenKH = txt_tenKhachHangTK.getText().toString().trim();
			String sdt = txt_soDienThoaiTK.getText().toString().trim();

			ArrayList<Phong> dsph2 = dao.timPhong_TheoTongHop(tenLP, tenKH, sdt, tenTTP, maP);

			dsph2.forEach(ph -> {
				System.out.println(ph.toString());
			});
			xoaDLPhong();
			if (dsph2 != null) {
				dsph2.forEach(ph -> {
					JPanel_CardPhong cardPhong = new JPanel_CardPhong(ph, model_TableDSPhong, table_DanhSachPhong);
					panel_Phong.add(cardPhong);
				});
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
