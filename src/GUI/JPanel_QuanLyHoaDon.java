package GUI;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import GUI.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.json.ParseException;
import com.toedter.calendar.JDateChooser;

import DAO.DichVu_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class JPanel_QuanLyHoaDon extends JPanel implements ActionListener, MouseListener, KeyListener {

	/**
	 * Color
	 */

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private JTable table_HoaDon;

	private JDateChooser dateTuNgay;
	private JDateChooser dateDenNgay;
	private JTextField txtHD;
	private JTextField txtKH;
	private JTextField txtNV;

	private HoaDon_DAO hd_DAO;
	private NhanVien_DAO nv_DAO;
	private KhachHang_DAO kh_DAO;

	private DefaultTableModel model;
	private JButton btnLamMoi;

	private JDialog_ThongTinHoaDon dialog_TTHD;
	private JButton btnTimKiem;
	private JTextField txtPhieuDatPhong;

	private JButton btnTrangDau;

	private JButton btnTrangSau;

	private JTextField txtTrang;

	private JButton btnTrangTruoc;

	private JButton btnTrangCuoi;

	private JTextField txt_TongTrang;

	private JRadioButton rdbTatCa;

	private JRadioButton rdbChoThanhToan;

	private JRadioButton rdbDaThanhToan;

	private JRadioButton rdbDaHuy;

	private ButtonGroup searchGroup;

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

	/**
	 * Create the panel.
	 */
	public JPanel_QuanLyHoaDon() {
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
		add(panel);
		panel.setLayout(null);

		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_Table.setBackground(Color.decode(hexColor_Blue1));
		panel_Table.setBounds(0, 0, 1296, 672);
		panel.add(panel_Table);
		panel_Table.setLayout(null);

		table_HoaDon = new JTable();
		table_HoaDon.setBackground(Color.WHITE);
		table_HoaDon.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã hóa đơn", "Tên khách hàng",
				"Tên nhân viên", "Mã phiếu đặt", "Mã khuyến mãi", "Ngày lập", "Trạng thái", "Thời gian trả phòng" }) {

			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			}
		});
		table_HoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 1019, 615);
		scrollPane.add(table_HoaDon);
		scrollPane.setViewportView(table_HoaDon);
		panel_Table.add(scrollPane);

		model = (DefaultTableModel) table_HoaDon.getModel();
		DocDuLieuTrenSQL();

		JPanel panel_RDB = new JPanel();
		panel_RDB.setBackground(Color.WHITE);
		panel_RDB.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_RDB.setBounds(1031, 36, 255, 615);
		panel_Table.add(panel_RDB);
		panel_RDB.setLayout(null);

		JPanel panel_TKTheoTG = new JPanel();
		panel_TKTheoTG.setBounds(10, 11, 235, 114);
		dateTuNgay = new JDateChooser();
		dateTuNgay.setDateFormatString("yyyy-MM-dd");
		dateTuNgay.setBounds(46, 28, 179, 20);
		dateDenNgay = new JDateChooser();
		dateDenNgay.setDateFormatString("yyyy-MM-dd");
		dateDenNgay.setBounds(46, 59, 179, 20);
		panel_TKTheoTG.setBackground(new Color(255, 255, 255));
		panel_TKTheoTG.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tìm kiếm theo thời gian", TitledBorder.LEADING, TitledBorder.TOP, null, Color.decode(hexColor_Blue1)));
		panel_TKTheoTG.setLayout(null);
		panel_TKTheoTG.add(dateTuNgay);
		panel_TKTheoTG.add(dateDenNgay);
		panel_RDB.add(panel_TKTheoTG);

		JLabel lblNewLabel = new JLabel("Từ :");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 28, 46, 20);
		panel_TKTheoTG.add(lblNewLabel);

		JLabel lbln = new JLabel("Đến :");
		lbln.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbln.setBounds(10, 59, 46, 20);
		panel_TKTheoTG.add(lbln);

		JPanel panel_TKCuThe = new JPanel();
		panel_TKCuThe.setBounds(10, 143, 235, 146);
		dateTuNgay = new JDateChooser();
		dateDenNgay = new JDateChooser();
		panel_TKCuThe.setBackground(new Color(255, 255, 255));
		panel_TKCuThe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00ECm ki\u1EBFm c\u1EE5 th\u1EC3", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.decode(hexColor_Blue1)));
		panel_RDB.add(panel_TKCuThe);
		panel_TKCuThe.setLayout(null);

		txtHD = new JTextField();
		txtHD.setBounds(84, 26, 141, 20);
		panel_TKCuThe.add(txtHD);
		txtHD.setColumns(10);

		txtKH = new JTextField();
		txtKH.setColumns(10);
		txtKH.setBounds(84, 86, 141, 20);
		panel_TKCuThe.add(txtKH);

		txtNV = new JTextField();
		txtNV.setColumns(10);
		txtNV.setBounds(84, 116, 141, 20);
		panel_TKCuThe.add(txtNV);

		JLabel lblHan = new JLabel("Hóa đơn :");
		lblHan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHan.setBounds(10, 25, 64, 20);
		panel_TKCuThe.add(lblHan);

		JLabel lblKhchHng = new JLabel("Khách hàng :");
		lblKhchHng.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblKhchHng.setBounds(10, 86, 77, 20);
		panel_TKCuThe.add(lblKhchHng);

		JLabel lblNhnVin = new JLabel("Nhân viên :");
		lblNhnVin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNhnVin.setBounds(10, 116, 77, 20);
		panel_TKCuThe.add(lblNhnVin);

		JLabel lblPhiutPhng = new JLabel("Phiếu đặt :");
		lblPhiutPhng.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPhiutPhng.setBounds(10, 55, 93, 20);
		panel_TKCuThe.add(lblPhiutPhng);

		txtPhieuDatPhong = new JTextField();
		txtPhieuDatPhong.setColumns(10);
		txtPhieuDatPhong.setBounds(84, 56, 141, 20);
		panel_TKCuThe.add(txtPhieuDatPhong);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(72, 314, 123, 35);
		panel_RDB.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyHoaDon.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setBounds(72, 359, 125, 35);
		panel_RDB.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyHoaDon.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);

		rdbTatCa = new JRadioButton("Tất cả");
		rdbTatCa.setBackground(new Color(255, 255, 255));
		rdbTatCa.setBounds(10, 6, 76, 21);
		panel_Table.add(rdbTatCa);

		rdbChoThanhToan = new JRadioButton("Chờ thanh toán");
		rdbChoThanhToan.setBackground(Color.WHITE);
		rdbChoThanhToan.setBounds(88, 6, 110, 21);
		panel_Table.add(rdbChoThanhToan);

		rdbDaThanhToan = new JRadioButton("Đã thanh toán");
		rdbDaThanhToan.setBackground(Color.WHITE);
		rdbDaThanhToan.setBounds(200, 6, 103, 21);
		panel_Table.add(rdbDaThanhToan);

		rdbDaHuy = new JRadioButton("Đã hủy");
		rdbDaHuy.setBackground(Color.WHITE);
		rdbDaHuy.setBounds(305, 6, 103, 21);
		panel_Table.add(rdbDaHuy);

		searchGroup = new ButtonGroup();
		searchGroup.add(rdbDaThanhToan);
		searchGroup.add(rdbChoThanhToan);
		searchGroup.add(rdbDaHuy);
		searchGroup.add(rdbTatCa);

		btnLamMoi.addMouseListener(this);
		table_HoaDon.addMouseListener(this);
		btnTimKiem.addMouseListener(this);

		txtPhieuDatPhong.addKeyListener(this);
		txtHD.addKeyListener(this);
		txtNV.addKeyListener(this);
		txtKH.addKeyListener(this);

		rdbChoThanhToan.addActionListener(this);
		rdbDaHuy.addActionListener(this);
		rdbDaThanhToan.addActionListener(this);
		rdbTatCa.addActionListener(this);

	}

	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
		model.setRowCount(0);
	}
	
	private void XoaRong() {
		txtHD.setText("");
		txtKH.setText("");
		txtNV.setText("");
		txtPhieuDatPhong.setText("");
	}

	private void DocDuLieuTrenSQL() {
		clearTable();
		hd_DAO = new HoaDon_DAO();
		kh_DAO = new KhachHang_DAO();
		nv_DAO = new NhanVien_DAO();
		ArrayList<HoaDon> dsHD = hd_DAO.layTatCaHoaDon();

		if (dsHD != null) {
			for (HoaDon hd : dsHD) {
				KhachHang kh = kh_DAO.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
				NhanVien nv = nv_DAO.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
				if (hd.getPhieuDatPhong() != null) {
					Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(),
							hd.getPhieuDatPhong().getMaPhieuDat(), hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(),
							hd.getTrangThai(), hd.getThoiGianKetThuc() };
					model.addRow(rowData);
				} else {
					Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(), null,
							hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(), hd.getTrangThai(),
							hd.getThoiGianKetThuc() };
					model.addRow(rowData);
				}

			}
		}
	}

	// Tìm kiếm theo mã khách hàng / họ tên / số điện thoại
	public void TimKiemTheoKH() {
		String khach = txtKH.getText();
		ArrayList<HoaDon> dsHD = hd_DAO.layHoaDon_TheoKhachHang(khach);

		if (dsHD != null) {
			for (HoaDon hd : dsHD) {
				KhachHang kh = kh_DAO.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
				NhanVien nv = nv_DAO.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
				Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(),
						hd.getPhieuDatPhong().getMaPhieuDat(), hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(),
						hd.getTrangThai(), hd.getThoiGianKetThuc() };
				model.addRow(rowData);

			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tồn tại hóa đơn !");
		}
	}

	// Tìm kiếm theo mã nhân viên / họ tên / số điện thoại

	public void TimKiemTheoNV() {
		String nhanVien = txtNV.getText();
		ArrayList<HoaDon> dsHD = hd_DAO.layHoaDon_TheoNhanVien(nhanVien);

		if (dsHD != null) {
			for (HoaDon hd : dsHD) {
				KhachHang kh = kh_DAO.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
				NhanVien nv = nv_DAO.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
				Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(),
						hd.getPhieuDatPhong().getMaPhieuDat(), hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(),
						hd.getTrangThai(), hd.getThoiGianKetThuc() };
				model.addRow(rowData);

			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tồn tại hóa đơn !");
		}
	}

	// Tìm kiếm theo mã phiếu đặt phòng

	public void TimKiemTheoPhieuDatPhong() {
		String pdp = txtPhieuDatPhong.getText();
		ArrayList<HoaDon> dsHD = hd_DAO.layHoaDon_TheoPhieuDatPhong(pdp);

		if (dsHD != null) {
			for (HoaDon hd : dsHD) {
				KhachHang kh = kh_DAO.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
				NhanVien nv = nv_DAO.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
				Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(),
						hd.getPhieuDatPhong().getMaPhieuDat(), hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(),
						hd.getTrangThai(), hd.getThoiGianKetThuc() };
				model.addRow(rowData);

			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tồn tại hóa đơn !");
		}
	}

	// Tìm kiếm tương đối theo mã hóa đơn (có thể tìm theo ngày lập hóa đơn)
	public void TimKiemTheoHD() {
		String hdon = txtHD.getText();
		HoaDon hd = hd_DAO.layHoaDon_TheoMaHoaDon(hdon);

		if (hd != null) {

			KhachHang kh = kh_DAO.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
			NhanVien nv = nv_DAO.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
			Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(), hd.getPhieuDatPhong().getMaPhieuDat(),
					hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(), hd.getTrangThai(), hd.getThoiGianKetThuc() };
			model.addRow(rowData);

		} else {

			JOptionPane.showMessageDialog(null, "Không tồn tại hóa đơn !");
		}
	}

	// Tìm kiếm hóa đơn theo khoảng ngày
	public void TimKiemTheoKhoangNgay() throws java.text.ParseException {
		java.sql.Date sqlDate_TuNgay = new java.sql.Date(dateTuNgay.getDate().getTime());
		java.sql.Date sqlDate_DenNgay = new java.sql.Date(dateDenNgay.getDate().getTime());
		ArrayList<HoaDon> dsHD = hd_DAO.layHoaDon_TheoKhoangNgay(sqlDate_TuNgay, sqlDate_DenNgay);

		if (dsHD != null) {
			for (HoaDon hd : dsHD) {
				KhachHang kh = kh_DAO.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
				NhanVien nv = nv_DAO.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
				Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(),
						hd.getPhieuDatPhong().getMaPhieuDat(), hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(),
						hd.getTrangThai(), hd.getThoiGianKetThuc() };
				model.addRow(rowData);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tồn tại hóa đơn !");
		}
	}

	// Tìm kiếm theo trạng thái
	public void TimKiemTheoTrangThai() {
		hd_DAO = new HoaDon_DAO();
		boolean choThanhToan = rdbChoThanhToan.isSelected();
		boolean daThanhToan = rdbDaThanhToan.isSelected();
		boolean daHuy = rdbDaHuy.isSelected();
		boolean tatCa = rdbTatCa.isSelected();
		// Tạo danh sách dsPDP để lưu kết quả
		List<HoaDon> dsHD = new ArrayList<>();
		// Lấy danh sách phiếu đặt phòng dựa trên trạng thái được chọn
		if (choThanhToan) {
			dsHD.addAll(hd_DAO.layHoaDon_TheoTrangThai("Chờ thanh toán"));
		}
		if (daThanhToan) {
			dsHD.addAll(hd_DAO.layHoaDon_TheoTrangThai("Đã thanh toán"));
		}
		if (daHuy) {
			dsHD.addAll(hd_DAO.layHoaDon_TheoTrangThai("Đã hủy"));
		}

		if (!dsHD.isEmpty()) {
			clearTable();
			for (HoaDon hd : dsHD) {
				KhachHang kh = kh_DAO.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
				NhanVien nv = nv_DAO.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
				Object[] rowData = { hd.getMaHoaDon(), kh.getHoTen(), nv.getHoTen(),
						hd.getPhieuDatPhong().getMaPhieuDat(), hd.getKhuyenMai().getMaKhuyenMai(), hd.getNgayLap(),
						hd.getTrangThai(), hd.getThoiGianKetThuc() };
				model.addRow(rowData);
			}
		} else {
			clearTable();
		}

		if (tatCa) {
			DocDuLieuTrenSQL();
		}
	}

	/**
	 * Event
	 **/

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(rdbChoThanhToan) || o.equals(rdbDaHuy) || o.equals(rdbDaThanhToan) || o.equals(rdbTatCa)) {
			TimKiemTheoTrangThai();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			XoaRong();
			clearTable();
			DocDuLieuTrenSQL();
		}

		else if (o.equals(table_HoaDon)) {
			if (e.getClickCount() == 2) {
				int row = table_HoaDon.getSelectedRow();
				String maHD = model.getValueAt(row, 0).toString();
				dialog_TTHD = new JDialog_ThongTinHoaDon();
				dialog_TTHD.setVisible(true);
				dialog_TTHD.HienThongTinTheoMaHD(maHD);

			}
		}

		else if (o.equals(btnTimKiem)) {
			clearTable();
		}
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();

		if (o.equals(txtHD) && e.getKeyCode() == KeyEvent.VK_ENTER) {
			clearTable();
			TimKiemTheoHD();
		} else if (o.equals(txtKH) && e.getKeyCode() == KeyEvent.VK_ENTER) {
			clearTable();
			TimKiemTheoKH();
		} else if (o.equals(txtNV) && e.getKeyCode() == KeyEvent.VK_ENTER) {
			clearTable();
			TimKiemTheoNV();
		} else if (o.equals(txtPhieuDatPhong) && e.getKeyCode() == KeyEvent.VK_ENTER) {
			clearTable();
			TimKiemTheoPhieuDatPhong();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
