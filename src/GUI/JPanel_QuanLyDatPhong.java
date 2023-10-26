package GUI;

import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Arrays;

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

import org.apache.poi.util.SystemOutLogger;

import com.itextpdf.text.List;

import DAO.KhachHang_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.KhachHang;
import Entity.PhieuDatPhong;
import Entity.Phong;
import Entity.TrangThaiPhong;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;

public class JPanel_QuanLyDatPhong extends JPanel {

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
	
	private JPanel panel_PDP;
	private JTabbedPane tabbedPane;
	private JPanel panel_DatPhong;
	private JPanel panel_1;
	private JPanel panel_DichVu;
	private JPanel panel_PhongBan;
	private JComponent panel_ThucDon;
	private JTextField txtMaPhong;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
<<<<<<< HEAD
=======
	private JTextField txtGioDatPhong;
>>>>>>> dev
	private JLabel lblMaPhong;
	private JLabel lblThongTinPhongHat;
	private JLabel lblTenKhachHang;
	private JLabel lblSDT;
<<<<<<< HEAD
	private JLabel lblTenPhong;
	private JPanel panel_TraCuuPhong;
	private JTable table_MatHang;
=======
	private JLabel lblGioDatPhong;
	private JLabel lblThucDon;
	private JPanel panel_ThanhToan;
	private JPanel panel_2;
	private JTable table;
>>>>>>> dev
	private Object objPhong;

	private Phong_DAO phongDao;
	private TrangThaiPhong_DAO trangThaiPhongDao;
<<<<<<< HEAD
	private JTextField txtLoaiPhong;
	private JLabel lblThoiGianNhan;
	private JTextField txtThoiGianNhan;
	private JLabel lblMatHang;
	private JLabel lblSLKhach;
	private JTextField txtSLKhach;
	private JTextField txtGiaPhong;
	private JLabel lblGiaPhong;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField textField;
	private JLabel lblLoiPhng;
	private JLabel lblMaPhong_2;
	private JLabel lblTnPhng;
=======
	private JTextField txtGioNhanPhong;
	private ArrayList<Phong> dsPhong;
>>>>>>> dev

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
	public JPanel_QuanLyDatPhong() {
//		setBorder(new RoundedTransparentBorder(25, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		setBackground(Color.decode(hexColor_Blue1));
		setBounds(0, 0, 1296, 672);
		setLayout(null);

		phongDao = new Phong_DAO();
		trangThaiPhongDao = new TrangThaiPhong_DAO();
		try {
			dsPhong = phongDao.layTatCaPhong();
			if (dsPhong != null) {
				dsPhong.forEach(ph -> {
					System.out.println(ph.toString());
				});

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		panel_PDP = new JPanel();
		panel_PDP.setBorder(null);
		panel_PDP.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_PDP.setBackground(Color.decode(hexColor_Blue1));
//		panel_PDP.setBackground(Color.WHITE);
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

<<<<<<< HEAD
		table_MatHang = new JTable();
		table_MatHang.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Tên mặt hàng",
				"Số lượng", "Đơn giá", "" }));
		scrollPane.setViewportView(table_MatHang);

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
=======
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "T\u00EAn s\u1EA3n ph\u1EA9m",
				"S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1" }));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBounds(10, 98, 418, 95);
		panel_PDP.add(panel);
		panel.setLayout(null);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(143, 58, 255, 25);
		panel.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(18, 58, 115, 25);
		panel.add(lblSDT);
>>>>>>> dev
		lblSDT.setForeground(Color.decode(hexColor_Blue1));
		lblSDT.setFont(new Font("Segoe UI", Font.BOLD, 13));

		txtTenKhachHang = new JTextField();
<<<<<<< HEAD
		txtTenKhachHang.setEnabled(false);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(157, 47, 241, 25);
		panel_TTKH.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setBounds(18, 47, 115, 25);
		panel_TTKH.add(lblTenKhachHang);
		lblTenKhachHang.setForeground(Color.decode(hexColor_Blue1));
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		lblSLKhach = new JLabel("Số lượng người hát");
		lblSLKhach.setForeground(new Color(5, 74, 145));
		lblSLKhach.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSLKhach.setBounds(18, 83, 138, 25);
		panel_TTKH.add(lblSLKhach);
		
		txtSLKhach = new JTextField();
		txtSLKhach.setColumns(10);
		txtSLKhach.setBounds(157, 83, 241, 25);
		panel_TTKH.add(txtSLKhach);

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

		JTextField txtTenPhong = new JTextField();
		txtTenPhong.setEditable(false);
		txtTenPhong.setEnabled(false);
		txtTenPhong.setBounds(158, 12, 240, 25);
		panel_TTPhong.add(txtTenPhong);
		txtTenPhong.setColumns(10);

		JLabel lblLoaiPhong = new JLabel("Loại phòng");
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
		
		txtThoiGianNhan = new JTextField();
		txtThoiGianNhan.setEnabled(false);
		txtThoiGianNhan.setEditable(false);
		txtThoiGianNhan.setColumns(10);
		txtThoiGianNhan.setBounds(202, 87, 146, 19);
		panel_PDP.add(txtThoiGianNhan);
		
				JButton btnXacNhanDatPhong = new JButton("XÁC NHẬN");
				btnXacNhanDatPhong.setBounds(141, 630, 155, 35);
				panel_PDP.add(btnXacNhanDatPhong);
				btnXacNhanDatPhong.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
//				btnXacNhanDatPhong.setIcon(new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/usd-circle.png")));
				btnXacNhanDatPhong.setBackground(Color.decode(hexColor_Green));
				btnXacNhanDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
				btnXacNhanDatPhong.setForeground(Color.white);
				
				lblMatHang = new JLabel("Mặt hàng");
				lblMatHang.setForeground(new Color(5, 74, 145));
				lblMatHang.setFont(new Font("Segoe UI", Font.BOLD, 13));
				lblMatHang.setBounds(10, 389, 115, 25);
				panel_PDP.add(lblMatHang);
=======
		txtTenKhachHang.setBounds(143, 12, 255, 25);
		panel.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setBounds(18, 11, 115, 25);
		panel.add(lblTenKhachHang);
		lblTenKhachHang.setForeground(Color.decode(hexColor_Blue1));
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 200, 418, 124);
		panel_PDP.add(panel_3);
		panel_3.setLayout(null);

		lblGioDatPhong = new JLabel("Giờ đặt phòng");
		lblGioDatPhong.setBounds(20, 11, 115, 25);
		panel_3.add(lblGioDatPhong);
		lblGioDatPhong.setForeground(Color.decode(hexColor_Blue1));
		lblGioDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));

		txtGioDatPhong = new JTextField();
		txtGioDatPhong.setBounds(143, 12, 255, 25);
		panel_3.add(txtGioDatPhong);
		txtGioDatPhong.setColumns(10);

		JLabel lblGioNhanPhong_1 = new JLabel("Giờ nhận phòng");
		lblGioNhanPhong_1.setForeground(new Color(5, 74, 145));
		lblGioNhanPhong_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblGioNhanPhong_1.setBounds(20, 55, 115, 25);
		panel_3.add(lblGioNhanPhong_1);

		txtGioNhanPhong = new JTextField();
		txtGioNhanPhong.setColumns(10);
		txtGioNhanPhong.setBounds(143, 58, 255, 25);
		panel_3.add(txtGioNhanPhong);
>>>>>>> dev

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.decode(hexColor_Blue1));
		tabbedPane.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 12));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.putClientProperty("TabbedPane.showTabSeparators", true);
		tabbedPane.setBounds(0, 0, 858, 672);
		add(tabbedPane);

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
		scrollPane_1.setBounds(0, 94, 843, 498);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_PhongBan.add(scrollPane_1);

		JPanel panel_Phong = new JPanel();
		panel_Phong.setBackground(new Color(255, 255, 255));
		scrollPane_1.setRowHeaderView(panel_Phong);
		panel_Phong.setLayout(new GridLayout(3, 5, 6, 6));
		/**
		 * 
		 * **/
		if (dsPhong != null) {
			dsPhong.forEach(ph -> {
				CardPhong cardPhong = new CardPhong(ph);
				panel_Phong.add(cardPhong);
				System.out.println(cardPhong.getPhong().getMaPhong());

<<<<<<< HEAD
		dsPhongDemo.forEach(ph -> {
			CardPhong cardPhong = new CardPhong(ph);
			panel_Phong.add(cardPhong);
		});
=======
				cardPhong.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						if (e.getButton() == MouseEvent.BUTTON1) {

							HelpDate hDate = new HelpDate();
							txtMaPhong.setText(cardPhong.getPhong().getMaPhong());
							PhieuDatPhong pdp = null;
							PhieuDatPhong_DAO PDP_DAO = new PhieuDatPhong_DAO();

							if (!txtMaPhong.getText().trim().equals("")) {

								pdp = PDP_DAO.layPhieuDatPhong_TheoMaPhong(txtMaPhong.getText());

								System.out.println(pdp);
								if (pdp == null) {
									clearForm();
								}
								KhachHang kh = new KhachHang();
								KhachHang_DAO DAO_KH = new KhachHang_DAO();
								try {
									kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());

									if (kh != null) {

										System.out.println(kh);
										txtTenKhachHang.setText(kh.getHoTen());
										txtSoDienThoai.setText(kh.getSoDienThoai());

									}
								} catch (Exception e2) {
									// TODO: handle exception
								}

								txtGioNhanPhong.setText(hDate.chuyenDateThanhString(pdp.getThoiGianNhanPhong()));
								txtGioDatPhong.setText(hDate.chuyenDateThanhString(pdp.getThoiGianDatPhong()));
							}
						}
					}
				});
			});
		}
>>>>>>> dev

		panel_ThucDon = new JPanel();

		panel_ThucDon.setBackground(Color.white);
		tabbedPane.addTab("THỰC ĐƠN", new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/food-service.png")),
				panel_ThucDon, null);

		panel_ThucDon.setLayout(null);
	}

	/**
	 * dsPhong loadTrangThaiPhong
	 **/

<<<<<<< HEAD
=======
	public void clearForm() {
		txtSoDienThoai.setText("");
		txtGioDatPhong.setText("");
		txtGioNhanPhong.setText("");
//		txtMaPhong.setText("");
		txtTenKhachHang.setText("");
	}

>>>>>>> dev
	private void loadTrangThaiPhong() {
//		int pt = phongDao.laySoLuongPhongTheoTrangThai(1);
//		int pc = phongDao.laySoLuongPhongTheoTrangThai(2);
//		int pb = phongDao.laySoLuongPhongTheoTrangThai(4);
//		int pta = phongDao.laySoLuongPhongTheoTrangThai(3);
//
//		lbPhongTrong.setText("Phòng trống (" + pt + ")");
//		lbPhongCho.setText("Phòng chờ (" + pc + ")");
//		lbphongBan.setText("Phòng đang sử dụng (" + pb + ")");
//		lbTam.setText("Phòng tạm (" + pta + ")");

	}
<<<<<<< HEAD
=======

>>>>>>> dev
}
