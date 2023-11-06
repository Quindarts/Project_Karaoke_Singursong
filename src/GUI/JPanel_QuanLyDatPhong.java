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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import javax.swing.border.AbstractBorder;
import javax.swing.border.CompoundBorder;

import GUI.JFrame_ThuNgan.RoundedTransparentBorder;
import OtherFunction.HelpDate;

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
import DAO.DichVu_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiNhanVien_DAO;
import DAO.LoaiPhong_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.DichVu;
import Entity.KhachHang;
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

public class JPanel_QuanLyDatPhong extends JPanel implements ActionListener {

	/**
	 * Color
	 */

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private JTabbedPane tabbedPane;
	private JPanel panel_PDP;
	private JPanel panel_DatPhong;
	private JPanel panel_1;
	private JPanel panel_DichVu;
	private JPanel panel_PhongBan;
	private JPanel panel_ThucDon;
	private JPanel panel_Phong;
	private JPanel panel_DanhSachThucDon;
	private JPanel panel_TraCuuPhong;

	private JLabel lblMaPhong;
	private JLabel lblThongTinPhongHat;
	private JLabel lblTenKhachHang;
	private JLabel lblSDT;
	private JLabel lblTenPhong;
	private JLabel lblThoiGianNhan;
	private JLabel lblDanhSachPhong;
	private JLabel lblSLKhach;
	private JLabel lblGiaPhong;
	private JLabel lblLoiPhng;
	private JLabel lblMaPhong_2;
	private JLabel lblTnPhng;
	private JLabel lblLoaiPhong;

	private JTable table_DanhSachPhong;

	private Phong_DAO phongDao;
	private TrangThaiPhong_DAO trangThaiPhongDao;

	private JTextField txtLoaiPhong;
	private JTextField txtTenNhanVienDat;
	private JTextField txtGiaPhong;
	private JTextField txtMaPhong;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtGioNhanPhong;
	private JTextField txtTenPhong;
	private JTextField textField;

	private JComboBox comboBox;
	private JComboBox comboBox_1;

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

	private DichVu_DAO DAO_DV;
	private NhanVien nhanVien;
	private ArrayList<Phong> dsPhong;
	private ArrayList<Phong> dsPhongDangDat;
	private ArrayList<DichVu> dsDichVu;
	private DefaultTableModel model_TableDSPhong;
	private JButton btnLamMoiDanhSachPhong;

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
	public JPanel_QuanLyDatPhong(NhanVien nhanVien) {

		// Entity
		this.nhanVien = nhanVien;

		setBackground(Color.decode(hexColor_Blue1));
		setBounds(0, 0, 1296, 672);
		setLayout(null);

		panel_PDP = new JPanel();
		panel_PDP.setBorder(null);
		panel_PDP.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_PDP.setBackground(Color.decode(hexColor_Blue1));
		panel_PDP.setBounds(862, 0, 434, 672);
		add(panel_PDP);
		panel_PDP.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setForeground(Color.decode(hexColor_Blue1));
		lblMaPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPhong.setBounds(128, 55, 68, 21);
		panel_PDP.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setEnabled(false);
		txtMaPhong.setEditable(false);
		txtMaPhong.setBounds(202, 57, 146, 19);
		panel_PDP.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblThongTinPhongHat = new JLabel("THÔNG TIN ĐẶT PHÒNG");
		lblThongTinPhongHat.setForeground(Color.decode(hexColor_Blue1));

		lblThongTinPhongHat.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinPhongHat.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblThongTinPhongHat.setBounds(10, 10, 418, 34);
		panel_PDP.add(lblThongTinPhongHat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 415, 418, 211);
		panel_PDP.add(scrollPane);

		table_DanhSachPhong = new JTable();

		model_TableDSPhong = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Mã Phòng", "Tên Phòng", "Giá Phòng", "" });

		table_DanhSachPhong.setModel(model_TableDSPhong);
		scrollPane.setViewportView(table_DanhSachPhong);
		TableColumn btn__CapNhatTableDichVu = table_DanhSachPhong.getColumnModel().getColumn(4);

		btn__CapNhatTableDichVu.setCellRenderer(new ButtonCellRendererEditor(model_TableDSPhong, table_DanhSachPhong));
		btn__CapNhatTableDichVu.setCellEditor(new ButtonCellRendererEditor(model_TableDSPhong, table_DanhSachPhong));

		JPanel panel_TTKH = new JPanel();
		panel_TTKH.setBackground(Color.decode(hexColor_Blue4));
		panel_TTKH.setBounds(10, 119, 418, 120);
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

		lblSLKhach = new JLabel("Tên nhân viên");
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

		JPanel panel_TTPhong = new JPanel();
		panel_TTPhong.setBackground(Color.decode(hexColor_Blue4));
		panel_TTPhong.setBounds(10, 250, 418, 126);
		panel_PDP.add(panel_TTPhong);
		panel_TTPhong.setLayout(null);

		lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setBounds(20, 10, 115, 25);
		panel_TTPhong.add(lblTenPhong);
		lblTenPhong.setForeground(Color.decode(hexColor_Blue1));
		lblTenPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));

		txtTenPhong = new JTextField();
		txtTenPhong.setEditable(false);
		txtTenPhong.setEnabled(false);
		txtTenPhong.setBounds(158, 12, 240, 25);
		panel_TTPhong.add(txtTenPhong);
		txtTenPhong.setColumns(10);

		lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setForeground(new Color(5, 74, 145));
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong.setBounds(20, 46, 105, 25);
		panel_TTPhong.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEnabled(false);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(158, 48, 240, 25);
		panel_TTPhong.add(txtLoaiPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEnabled(false);
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(158, 84, 240, 25);
		panel_TTPhong.add(txtGiaPhong);

		lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setForeground(new Color(5, 74, 145));
		lblGiaPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblGiaPhong.setBounds(20, 83, 115, 25);
		panel_TTPhong.add(lblGiaPhong);

		lblThoiGianNhan = new JLabel("Thời gian nhận phòng");
		lblThoiGianNhan.setForeground(new Color(5, 74, 145));
		lblThoiGianNhan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblThoiGianNhan.setBounds(55, 87, 146, 21);
		panel_PDP.add(lblThoiGianNhan);

		txtGioNhanPhong = new JTextField();
		Calendar ca = new GregorianCalendar();
		int day = ca.get(Calendar.DAY_OF_MONTH);
		int month = ca.get(Calendar.MONTH);
		int year = ca.get(Calendar.YEAR);

		txtGioNhanPhong.setText(String.format("%02d", day) + "-" + String.format("%02d", month + 1) + "-"
				+ String.format("%04d", year));
		txtGioNhanPhong.setEnabled(false);
		txtGioNhanPhong.setEditable(false);
		txtGioNhanPhong.setColumns(10);
		txtGioNhanPhong.setBounds(202, 87, 146, 19);
		panel_PDP.add(txtGioNhanPhong);

		btnXacNhanDatPhong = new JButton("XÁC NHẬN");
		btnXacNhanDatPhong.setBounds(141, 627, 155, 35);

		btnLamMoiDanhSachPhong = new JButton("Làm mới danh sách");
		btnLamMoiDanhSachPhong.setSize(140, 20);
		btnLamMoiDanhSachPhong.setLocation(284, 390);
		panel_PDP.add(btnXacNhanDatPhong);
		panel_PDP.add(btnLamMoiDanhSachPhong);
		// EVENT DAT PHONG
		btnXacNhanDatPhong.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String regexHoTen = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*";
				Pattern patternHoTen = Pattern.compile(regexHoTen);
				java.util.regex.Matcher matcher = patternHoTen.matcher(txtTenKhachHang.getText().trim());
				if (matcher.matches()) {
					Phong_DAO phong_DAO = new Phong_DAO();
					Phong ph = new Phong();
					ph = phong_DAO.timPhong_TheoMaPhong(txtMaPhong.getText().trim());
					ph.setTrangThaiPhong(new TrangThaiPhong("OCP", "Đã đặt"));

					if (phong_DAO.capNhatPhong(ph)) {
						denTrangDauPhong();
						JOptionPane.showMessageDialog(null, "Đặt phòng thành công!", "Thành công",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Đặt phòng không thành công!", "Không thành công",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tên không đúng", "Không thành công",
							JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Số điện thoại bạn nhập vào không đúng", "Thông báo lỗi",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						txtTenKhachHang.setEnabled(true);
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
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		btnXacNhanDatPhong.setBackground(Color.decode(hexColor_Green));
		btnXacNhanDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnXacNhanDatPhong.setForeground(Color.white);

		lblDanhSachPhong = new JLabel("Danh sách phòng đặt");
		lblDanhSachPhong.setForeground(new Color(5, 74, 145));
		lblDanhSachPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblDanhSachPhong.setBounds(10, 389, 200, 25);
		panel_PDP.add(lblDanhSachPhong);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.decode(hexColor_Blue1));
		tabbedPane.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 12));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.putClientProperty("TabbedPane.showTabSeparators", true);
		tabbedPane.setBounds(0, 0, 858, 672);
		add(tabbedPane);
		panel_ThucDon = new JPanel();
		panel_ThucDon.setBackground(Color.white);

		// DANH SACH THUC DON
		tabbedPane.addTab("THỰC ĐƠN", new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/food-service.png")),
				panel_ThucDon, null);
		panel_ThucDon.setLayout(null);
		panel_DanhSachThucDon = new JPanel();
		panel_DanhSachThucDon.setBackground(new Color(255, 255, 255));
		panel_DanhSachThucDon.setBounds(0, 44, 806, 510);
		panel_ThucDon.add(panel_DanhSachThucDon);
		panel_DanhSachThucDon.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

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
		JPanel panel_panigationDichVu = new JPanel();
		panel_panigationDichVu.setBackground(new Color(255, 255, 255));
		panel_panigationDichVu.setBounds(220, 564, 356, 31);
		panel_panigationDichVu.setLayout(null);

		panel_panigationDichVu.add(btnTrangDauDichVu);
		panel_panigationDichVu.add(btnTrangSauDichVu);
		panel_panigationDichVu.add(txtTrangDichVu);

		lblNewLabelDichVu = new JLabel("/");
		lblNewLabelDichVu.setBounds(176, 8, 4, 13);
		panel_panigationDichVu.add(lblNewLabelDichVu);

		txt_TongTrangDichVu = new JTextField();
		txt_TongTrangDichVu.setBounds(185, 5, 51, 19);
		txt_TongTrangDichVu.setEditable(false);
		panel_panigationDichVu.add(txt_TongTrangDichVu);
		txt_TongTrangDichVu.setColumns(5);

		// CONNECT DAO_DV
		DAO_DV = new DichVu_DAO();
		int soLuong = DAO_DV.soLuongDichVu() / 8;

		if (DAO_DV.soLuongDichVu() % 8 > 0) {

			soLuong = DAO_DV.soLuongDichVu() / 8 + 1;
		}

		txt_TongTrangDichVu.setText(Integer.toString(soLuong));
		panel_panigationDichVu.add(btnTrangTruocDichVu);
		panel_panigationDichVu.add(btnTrangCuoiDichVu);
		panel_ThucDon.add(panel_panigationDichVu);

		panel_PhongBan = new JPanel();
		panel_PhongBan.setBackground(Color.WHITE);

		tabbedPane.addTab("PHÒNG HÁT", new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/door-open.png")),
				panel_PhongBan, null);
		panel_PhongBan.setLayout(null);

		panel_TraCuuPhong = new JPanel();
		panel_TraCuuPhong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_TraCuuPhong.setBackground(new Color(255, 255, 255));
		panel_TraCuuPhong.setBounds(0, 10, 806, 64);
		panel_PhongBan.add(panel_TraCuuPhong);
		panel_TraCuuPhong.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setBounds(234, 11, 149, 22);
		panel_TraCuuPhong.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(234, 35, 149, 22);
		panel_TraCuuPhong.add(comboBox_1);

		textField = new JTextField();
		textField.setBounds(498, 12, 149, 20);
		panel_TraCuuPhong.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBounds(707, 11, 89, 23);
		panel_TraCuuPhong.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setBounds(707, 35, 89, 23);
		panel_TraCuuPhong.add(btnNewButton_1);

		lblLoiPhng = new JLabel("Loại phòng");
		lblLoiPhng.setForeground(new Color(5, 74, 145));
		lblLoiPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoiPhng.setBounds(137, 11, 90, 21);
		panel_TraCuuPhong.add(lblLoiPhng);

		lblMaPhong_2 = new JLabel("Số người hát");
		lblMaPhong_2.setForeground(new Color(5, 74, 145));
		lblMaPhong_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPhong_2.setBounds(137, 35, 89, 21);
		panel_TraCuuPhong.add(lblMaPhong_2);

		lblTnPhng = new JLabel("Tên phòng");
		lblTnPhng.setForeground(new Color(5, 74, 145));
		lblTnPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTnPhng.setBounds(414, 11, 90, 21);
		panel_TraCuuPhong.add(lblTnPhng);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 77, 843, 515);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		panel_Phong = new JPanel();
		panel_Phong.setBackground(new Color(255, 255, 255));
		panel_Phong.setSize(806, 490);
		panel_Phong.setLocation(0, 77);
		panel_PhongBan.add(panel_Phong);
		panel_Phong.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

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
		txtTrang.setColumns(5);
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
		btnTrangCuoiPhong.setBounds(559, 585, 30, 25);
		JPanel panel_panigation = new JPanel();
		panel_panigation.setBackground(new Color(255, 255, 255));
		panel_panigation.setBounds(220, 565, 356, 31);

		panel_panigation.add(btnTrangDauPhong);
		panel_panigation.add(btnTrangSauPhong);
		panel_panigation.add(txtTrang);

		lblNewLabel = new JLabel("/");
		panel_panigation.add(lblNewLabel);

		txt_TongTrang = new JTextField();
		txt_TongTrang.setEditable(false);
		panel_panigation.add(txt_TongTrang);
		txt_TongTrang.setColumns(5);

		Phong_DAO DAO_P = new Phong_DAO();
		int soLuongPhong = DAO_P.soLuongPhong() / 15;

		if (DAO_P.soLuongPhong() % 15 > 0) {

			soLuongPhong = DAO_P.soLuongPhong() / 15 + 1;
		}

		txt_TongTrang.setText(Integer.toString(soLuongPhong));
		panel_panigation.add(btnTrangTruocPhong);
		panel_panigation.add(btnTrangCuoiPhong);
		panel_PhongBan.add(panel_panigation);

		denTrangDauPhong();
		denTrangDauDichVu();

		btnLamMoiDanhSachPhong.addActionListener(this);
		// Event panigation
		btnTrangCuoiPhong.addActionListener(this);
		btnTrangDauPhong.addActionListener(this);
		btnTrangSauPhong.addActionListener(this);
		btnTrangTruocPhong.addActionListener(this);
		btnXacNhanDatPhong.addActionListener(this);

		btnTrangCuoiDichVu.addActionListener(this);
		btnTrangDauDichVu.addActionListener(this);
		btnTrangSauDichVu.addActionListener(this);
		btnTrangTruocDichVu.addActionListener(this);

		// Event panigation

		// end panigation

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

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
					System.out.print(ph.toString());
				});
			}
		}
	}

	public void clearForm() {
		txtSoDienThoai.setText("");
		txtGioNhanPhong.setText("");
		txtTenPhong.setText("");
		txtLoaiPhong.setText("");
		txtTenKhachHang.setText("");
		txtGiaPhong.setText("");
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

				CardDichVu cardDV = new CardDichVu(dv);
				panel_DanhSachThucDon.add(cardDV);
			});
		}
	}

	public void DocDLPhong(int fn, int ln) {
		phongDao = new Phong_DAO();
		dsPhong = phongDao.phanTrangPhong(fn, ln);
		if (dsPhong != null) {
			dsPhong.forEach(ph -> {
				CardPhong cardPhong = new CardPhong(ph);
				panel_Phong.add(cardPhong);

				cardPhong.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {

						if (e.getButton() == MouseEvent.BUTTON1) {

							HelpDate hDate = new HelpDate();
							txtMaPhong.setText(cardPhong.getPhong().getMaPhong());
							PhieuDatPhong pdp = null;
							PhieuDatPhong_DAO PDP_DAO = new PhieuDatPhong_DAO();
							LoaiPhong_DAO LP_DAO = new LoaiPhong_DAO();
							LoaiPhong loaiPhong = null;
							if (!txtMaPhong.getText().trim().equals("")) {

								pdp = PDP_DAO.layPhieuDatPhong_TheoMaPhong(txtMaPhong.getText());

								if (pdp == null) {
									clearForm();
								}
								KhachHang kh = new KhachHang();
								KhachHang_DAO DAO_KH = new KhachHang_DAO();
								try {
									kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());

									if (kh != null) {

										txtTenKhachHang.setText(kh.getHoTen());
										txtSoDienThoai.setText(kh.getSoDienThoai());
										txtGioNhanPhong
												.setText(hDate.chuyenDateThanhString(pdp.getThoiGianNhanPhong()));

									}
								} catch (Exception e2) {
									// TODO: handle exception
								}
								try {
									loaiPhong = LP_DAO.layLoaiPhong_TheoMaLoaiPhong(
											cardPhong.getPhong().getLoaiPhong().getMaLoaiPhong());
									txtTenPhong.setText(cardPhong.getPhong().getTenPhong());
									txtLoaiPhong.setText(loaiPhong.getTenLoaiPhong());
									txtGiaPhong.setText(String.valueOf(loaiPhong.getGiaTien()));

									if (cardPhong.isSelectDatPhong() == true && kiemTraTrungMaPhongTrongDSPhong(
											cardPhong.getPhong().getMaPhong().toString().trim(),
											table_DanhSachPhong) == true) {
											
										System.out.print(cardPhong.getPhong().toString());
										int count = table_DanhSachPhong.getRowCount() + 1;

										System.out.println(count);
										model_TableDSPhong.addRow(
												new Object[] { count, cardPhong.getPhong().getMaPhong().toString(),
														cardPhong.getPhong().getTenPhong().toString(),
														Double.toString(loaiPhong.getGiaTien()) });
									}
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}

							}
						}
					}
				});
			});
		}

	}

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
		System.out.println("code::::" + code);
		for (int row = 0; row < table.getRowCount(); row++) {
			String roomCode = table.getValueAt(row, 1).toString();
			System.out.println("rodd::::" + roomCode);
			if (roomCode.trim().equals(code)) {
				return false;
			}
		}
		return true;
	}

}
