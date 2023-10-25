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

import com.itextpdf.text.List;

import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.Phong;
import Entity.TrangThaiPhong;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField txtGioNhanPhong;
	private JLabel lblMaPhong;
	private JLabel lblThongTinPhongHat;
	private JLabel lblTenKhachHang;
	private JLabel lblSDT;
	private JLabel lblGioNhanPhong;
	private JLabel lblThucDon;
	private JPanel panel_ThanhToan;
	private JPanel panel_2;
	private JTable table;
	private Object objPhong;
	
	private Phong_DAO phongDao;
	private TrangThaiPhong_DAO trangThaiPhongDao;
	private JTextField textField;

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

		panel_PDP = new JPanel();
		panel_PDP.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_PDP.setBackground(Color.WHITE);
		panel_PDP.setBounds(862, 0, 434, 585);
		add(panel_PDP);
		panel_PDP.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setForeground(Color.decode(hexColor_Blue1));
		lblMaPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPhong.setBounds(127, 66, 68, 21);
		panel_PDP.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(201, 68, 96, 19);
		panel_PDP.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblThongTinPhongHat = new JLabel("THÔNG TIN PHÒNG HÁT");
		lblThongTinPhongHat.setForeground(Color.decode(hexColor_Blue1));

		lblThongTinPhongHat.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinPhongHat.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblThongTinPhongHat.setBounds(10, 10, 408, 34);
		panel_PDP.add(lblThongTinPhongHat);

		lblThucDon = new JLabel("THỰC ĐƠN");
		lblThucDon.setForeground(Color.decode(hexColor_Blue1));
		lblThucDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblThucDon.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblThucDon.setBounds(10, 335, 408, 34);
		panel_PDP.add(lblThucDon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 380, 418, 194);
		panel_PDP.add(scrollPane);

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
						lblSDT.setForeground(Color.decode(hexColor_Blue1));
						lblSDT.setFont(new Font("Segoe UI", Font.BOLD, 13));
						
								txtTenKhachHang = new JTextField();
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
		
				lblGioNhanPhong = new JLabel("Giờ nhận phòng");
				lblGioNhanPhong.setBounds(20, 11, 115, 25);
				panel_3.add(lblGioNhanPhong);
				lblGioNhanPhong.setForeground(Color.decode(hexColor_Blue1));
				lblGioNhanPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
				
						txtGioNhanPhong = new JTextField();
						txtGioNhanPhong.setBounds(143, 12, 255, 25);
						panel_3.add(txtGioNhanPhong);
						txtGioNhanPhong.setColumns(10);
						
						JLabel lblGioNhanPhong_1 = new JLabel("Giờ nhận phòng");
						lblGioNhanPhong_1.setForeground(new Color(5, 74, 145));
						lblGioNhanPhong_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
						lblGioNhanPhong_1.setBounds(20, 55, 115, 25);
						panel_3.add(lblGioNhanPhong_1);
						
						textField = new JTextField();
						textField.setColumns(10);
						textField.setBounds(143, 58, 255, 25);
						panel_3.add(textField);

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

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 10, 843, 60);
		panel_PhongBan.add(panel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 81, 833, 500);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_PhongBan.add(scrollPane_1);

		JPanel panel_Phong = new JPanel();
		panel_Phong.setBackground(new Color(255, 255, 255));
		scrollPane_1.setRowHeaderView(panel_Phong);
		panel_Phong.setLayout(new GridLayout(3,5,6,6));
		/**
		 * 
		 * **/
		ArrayList<Phong> dsPhongDemo = new ArrayList<Phong>();
		dsPhongDemo.add(new Phong("P101", "Phong Thường 1", new TrangThaiPhong("111", "Còn Trống"),
				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("VIP102", "Phong VIP 1", new TrangThaiPhong("222", "Đang hát"),
				"Tầng 1,bên trái từ phải sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P103", "Phong Thường 3", new TrangThaiPhong("333", "Đặt trước"),
				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P104", "Phong Thường 4", new TrangThaiPhong("111", "Còn Trống"),
				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P105", "Phong Thường 5", new TrangThaiPhong("444", "Dọn Dẹp"),
				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P101", "Phong Thường 1", new TrangThaiPhong("111", "Còn Trống"),
				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("VIP102", "Phong VIP 1", new TrangThaiPhong("222", "Đang hát"),
				"Tầng 1,bên trái từ phải sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P103", "Phong Thường 3", new TrangThaiPhong("333", "Đặt trước"),
				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P104", "Phong Thường 4", new TrangThaiPhong("111", "Còn Trống"),
				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P105", "Phong Thường 5", new TrangThaiPhong("444", "Dọn Dẹp"),
				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P101", "Phong Thường 1", new TrangThaiPhong("111", "Còn Trống"),
				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("VIP102", "Phong VIP 1", new TrangThaiPhong("222", "Đang hát"),
				"Tầng 1,bên trái từ phải sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P103", "Phong Thường 3", new TrangThaiPhong("333", "Đặt trước"),
				"Tầng 1,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P104", "Phong Thường 4", new TrangThaiPhong("111", "Còn Trống"),
				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));
		dsPhongDemo.add(new Phong("P105", "Phong Thường 5", new TrangThaiPhong("444", "Dọn Dẹp"),
				"Tầng 2,bên phải từ trái sang", "đường hẹp, đi cẩn thận", "đang sử dụng"));

		dsPhongDemo.forEach(ph -> {
			CardPhong cardPhong = new CardPhong(ph);
			panel_Phong.add(cardPhong);
		});
		
		
		

		panel_ThucDon = new JPanel();

		panel_ThucDon.setBackground(Color.white);
		tabbedPane.addTab("THỰC ĐƠN", new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/food-service.png")),
				panel_ThucDon, null);

		panel_ThucDon.setLayout(null);

		panel_ThanhToan = new JPanel();
		panel_ThanhToan.setBounds(862, 590, 434, 82);
		panel_ThanhToan.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_ThanhToan.setBackground(Color.decode(hexColor_Blue1));
		add(panel_ThanhToan);
		panel_ThanhToan.setLayout(null);

		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setIcon(new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/usd-circle.png")));
		btnThanhToan.setBackground(Color.decode(hexColor_Orange));
		btnThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThanhToan.setForeground(Color.white);
		btnThanhToan.setBounds(138, 36, 155, 35);
		panel_ThanhToan.add(btnThanhToan);
	}
	/**
	 * Demo loadTrangThaiPhong
	 **/
	
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
	

}
