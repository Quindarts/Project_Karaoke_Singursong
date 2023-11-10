package GUI;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import GUI.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Phong;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class JPanel_BaoCaoThongKe extends JPanel implements ActionListener, ItemListener, PropertyChangeListener {

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

	private JTable table_HoaDon;

	private KhachHang_DAO DAO_KH;
	private ArrayList<KhachHang> dsKH;
	private HoaDon_DAO DAO_HoaDon;
	private ArrayList<HoaDon> dsHoaDon;
	private NhanVien_DAO DAO_NhanVien;
	private JDateChooser date_ThongKetTuNgay;
	private JDateChooser date_ThongKetDenNgay;
	private JComboBox cb_LocTheo;
	private JComboBox cb_LocNam;
	private JComboBox cb_LocPhong;

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
	public JPanel_BaoCaoThongKe() {
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
//		panel.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		add(panel);
		panel.setLayout(null);

		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_Table.setBackground(Color.decode(hexColor_Blue1));
//		panel_Table.setBackground(Color.WHITE);
		panel_Table.setBounds(0, 37, 1296, 635);
		panel.add(panel_Table);
		panel_Table.setLayout(null);

		table_HoaDon = new JTable();
		table_HoaDon.setBackground(Color.WHITE);
		table_HoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 h\u00F3a h\u01A1n", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n",
						"Kh\u00E1ch h\u00E0ng", "Nh\u00E2n vi\u00EAn", "T\u1ED5ng h\u00F3a \u0111\u01A1n" }));
		table_HoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_HoaDon);
		scrollPane.setViewportView(table_HoaDon);

		panel_Table.add(scrollPane);

		DAO_HoaDon = new HoaDon_DAO();
		DAO_NhanVien = new NhanVien_DAO();
		DAO_KH = new KhachHang_DAO();
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
		try {
			dsHoaDon = DAO_HoaDon.layTatCaHoaDon();
			System.out.println(dsHoaDon);
			if (dsHoaDon != null) {
				dsHoaDon.forEach(hd -> {
					KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
					NhanVien nv = DAO_NhanVien.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
					Object[] rowData = { hd.getMaHoaDon(), hd.getThoiGianKetThuc(), kh.getHoTen(), nv.getHoTen(), "" };
					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		table_HoaDon.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_HoaDon.getSelectedRow();
				String maHoaDon = model.getValueAt(row, 0).toString();
				String ngayXuatHoaDon = model.getValueAt(row, 1).toString();
				String nhanVien = model.getValueAt(row, 2).toString();
				String khachHang = model.getValueAt(row, 3).toString();
				String tongHoaDon = model.getValueAt(row, 4).toString();
//				System.out.println("Hóa đơn: " + maHoaDon + ngayXuatHoaDon + nhanVien + khachHang + tongHoaDon);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		JPanel pnl_Loc = new JPanel();
		pnl_Loc.setBackground(Color.WHITE);
		pnl_Loc.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Loc.setBounds(1031, 10, 255, 615);
		panel_Table.add(pnl_Loc);
		pnl_Loc.setLayout(null);
		
		JLabel lbl_TieuDe_Loc = new JLabel("Tra cứu thống kê");
		lbl_TieuDe_Loc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe_Loc.setBounds(73, 10, 120, 20);
		lbl_TieuDe_Loc.setFont(new Font("Segoe UI", Font.BOLD, 13));
		pnl_Loc.add(lbl_TieuDe_Loc);
		
		JPanel pnl_Loc_TheoTuoi = new JPanel();
		pnl_Loc_TheoTuoi.setLayout(null);
		pnl_Loc_TheoTuoi.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoTuoi.setBackground(Color.WHITE);
		pnl_Loc_TheoTuoi.setBounds(10, 40, 235, 100);
		pnl_Loc.add(pnl_Loc_TheoTuoi);
		
		JLabel lbl_KhoangThoiGian = new JLabel("Khoảng thời gian");
		lbl_KhoangThoiGian.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_KhoangThoiGian.setBounds(10, 10, 155, 18);
		pnl_Loc_TheoTuoi.add(lbl_KhoangThoiGian);
		
		JLabel lbl_TuoiBatDau = new JLabel("Từ :");
		lbl_TuoiBatDau.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TuoiBatDau.setBounds(10, 40, 45, 13);
		pnl_Loc_TheoTuoi.add(lbl_TuoiBatDau);
		
		JLabel lbl_TuoiKetThuc = new JLabel("Đến :");
		lbl_TuoiKetThuc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TuoiKetThuc.setBounds(10, 77, 45, 13);
		pnl_Loc_TheoTuoi.add(lbl_TuoiKetThuc);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(45, 38, 155, 19);
		pnl_Loc_TheoTuoi.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(45, 71, 155, 19);
		pnl_Loc_TheoTuoi.add(dateChooser_1);
		
		JPanel pnl_Loc_TheoThang = new JPanel();
		pnl_Loc_TheoThang.setLayout(null);
		pnl_Loc_TheoThang.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoThang.setBackground(Color.WHITE);
		pnl_Loc_TheoThang.setBounds(10, 150, 235, 136);
		pnl_Loc.add(pnl_Loc_TheoThang);
		
		JLabel lbl_LocThang = new JLabel("Khoảng thời gian");
		lbl_LocThang.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_LocThang.setBounds(10, 10, 155, 18);
		pnl_Loc_TheoThang.add(lbl_LocThang);
		
		JLabel lbl_TuoiBatDau_1 = new JLabel("Từ :");
		lbl_TuoiBatDau_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TuoiBatDau_1.setBounds(10, 40, 45, 13);
		pnl_Loc_TheoThang.add(lbl_TuoiBatDau_1);
		
		JLabel lbl_TuoiKetThuc_1 = new JLabel("Đến :");
		lbl_TuoiKetThuc_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TuoiKetThuc_1.setBounds(113, 38, 45, 13);
		pnl_Loc_TheoThang.add(lbl_TuoiKetThuc_1);
		
		JComboBox cb_LocTheo_1 = new JComboBox();
		cb_LocTheo_1.setBounds(45, 37, 58, 20);
		pnl_Loc_TheoThang.add(cb_LocTheo_1);
		
		JComboBox cb_LocTheo_1_1 = new JComboBox();
		cb_LocTheo_1_1.setBounds(154, 35, 58, 20);
		pnl_Loc_TheoThang.add(cb_LocTheo_1_1);

		JPanel pnl_BoLoc = new JPanel();
		pnl_BoLoc.setBackground(new Color(255, 255, 255));
		pnl_BoLoc.setBounds(10, 10, 1016, 25);
		panel.add(pnl_BoLoc);
		pnl_BoLoc.setLayout(null);

		date_ThongKetTuNgay = new JDateChooser();
		date_ThongKetTuNgay.setBounds(10, 3, 165, 20);
		pnl_BoLoc.add(date_ThongKetTuNgay);

		date_ThongKetDenNgay = new JDateChooser();
		date_ThongKetDenNgay.setBounds(230, 3, 165, 20);
		pnl_BoLoc.add(date_ThongKetDenNgay);

		JLabel lbl_ = new JLabel("Thống kê theo");
		lbl_.setBounds(419, 3, 105, 20);
		pnl_BoLoc.add(lbl_);

		cb_LocTheo = new JComboBox();
		cb_LocTheo.setBounds(504, 3, 105, 20);
		pnl_BoLoc.add(cb_LocTheo);

		JLabel lbl_Nam = new JLabel("Năm");
		lbl_Nam.setBounds(661, 3, 105, 20);
		pnl_BoLoc.add(lbl_Nam);

		cb_LocNam = new JComboBox();
		cb_LocNam.setBounds(702, 3, 105, 20);
		pnl_BoLoc.add(cb_LocNam);

		JLabel lbl_Phong = new JLabel("Phòng");
		lbl_Phong.setBounds(848, 3, 105, 20);
		pnl_BoLoc.add(lbl_Phong);

		cb_LocPhong = new JComboBox();
		cb_LocPhong.setBounds(886, 3, 105, 20);
		pnl_BoLoc.add(cb_LocPhong);

		JLabel lbl_Den = new JLabel("Đến");
		lbl_Den.setBounds(190, 3, 40, 20);
		pnl_BoLoc.add(lbl_Den);

		
		
		cb_LocNam.addItemListener(this);
		cb_LocPhong.addItemListener(this);
		cb_LocTheo.addItemListener(this);
		date_ThongKetTuNgay.addPropertyChangeListener(this);
		date_ThongKetDenNgay.addPropertyChangeListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
//		if (o.equals(btnThemKhachHang)) {
//			Modal_ThemKhachHang modalTKH = new Modal_ThemKhachHang();
//			modalTKH.setVisible(true);
//		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(cb_LocNam)) {

		}
		if (o.equals(cb_LocPhong)) {

		}
		if (o.equals(cb_LocTheo)) {

		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		Object o = evt.getSource();
		if ("date".equals(evt.getPropertyName())) {

		}
		if ("date".equals(evt.getPropertyName())) {

		}
	}
	
	public void timHoaDon_TheoNam () {
		
	}
}
