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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class JPanel_BaoCaoThongKe extends JPanel implements ActionListener {

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
	private HoaDon_DAO DAO_HD;
	private NhanVien_DAO DAO_NV;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<HoaDon> dsHD;
	private ArrayList<NhanVien> dsNV;
	private JTextField txt_TongDoanhThu;
	private JTextField txt_TongSoHoaDon;
	private int tongSoHD;
	private JTextField txt_TongTien_DichVu;
	private JTextField txt_TongSo_DichVu;
	private JTable table_DichVu;

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
	public JPanel_BaoCaoThongKe(NhanVien nhVien) {
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
//		panel.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1296, 672);
		panel.add(tabbedPane);

		JPanel pnl_HoaDon = new JPanel();
		tabbedPane.addTab("HÓA ĐƠN", null, pnl_HoaDon, null);
		pnl_HoaDon.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		pnl_HoaDon.setBackground(Color.decode(hexColor_Blue1));
		pnl_HoaDon.setLayout(null);

		table_HoaDon = new JTable();
		table_HoaDon.setBackground(Color.WHITE);
		table_HoaDon.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 h\u00F3a \u0111\u01A1n",
				"Ng\u00E0y l\u1EADp", "Kh\u00E1ch h\u00E0ng", "Nh\u00E2n vi\u00EAn", "T\u1ED5ng ti\u1EC1n" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_HoaDon.getColumnModel().getColumn(0).setResizable(false);
		table_HoaDon.getColumnModel().getColumn(1).setResizable(false);
		table_HoaDon.getColumnModel().getColumn(2).setResizable(false);
		table_HoaDon.getColumnModel().getColumn(3).setResizable(false);
		table_HoaDon.getColumnModel().getColumn(4).setResizable(false);
		table_HoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane_HoaDon = new JScrollPane();
		scrollPane_HoaDon.setBounds(10, 10, 1019, 549);
		scrollPane_HoaDon.add(table_HoaDon);
		scrollPane_HoaDon.setViewportView(table_HoaDon);

		pnl_HoaDon.add(scrollPane_HoaDon);
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();

		table_HoaDon.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_HoaDon.getSelectedRow();
				// txtDiaDiem.setText(model.getValueAt(row, 2).toString());
				// date_KH.setDate((Date) model.getValueAt(row, 3));
				// String maKhachHang = model.getValueAt(row, 0).toString();
				// String hoTen = model.getValueAt(row, 1).toString();
				// String gioiTinh = model.getValueAt(row, 2).toString();
				// String ngaySinh = model.getValueAt(row, 3).toString();
				// String diaChi = model.getValueAt(row, 4).toString();
				// String sdt = model.getValueAt(row, 5).toString();
				// String diemThuong = model.getValueAt(row, 6).toString();
				// String ghiChu = model.getValueAt(row, 7).toString();
				// System.out.println(maKhachHang + "," + hoTen + "," + gioiTinh + "," +
				// ngaySinh + "," + diaChi + "," + sdt + "," + diemThuong + "," + ghiChu );
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

		JPanel panel_Loc_HoaDon = new JPanel();
		panel_Loc_HoaDon.setBackground(Color.WHITE);
		panel_Loc_HoaDon.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Loc_HoaDon.setBounds(1030, 10, 255, 615);
		pnl_HoaDon.add(panel_Loc_HoaDon);
		panel_Loc_HoaDon.setLayout(null);

		JLabel lbl_Loc = new JLabel("LỌC");
		lbl_Loc.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_Loc.setBounds(126, 10, 55, 13);
		panel_Loc_HoaDon.add(lbl_Loc);

		JPanel pnl_Loc_TheoThoiGian = new JPanel();
		pnl_Loc_TheoThoiGian.setBackground(new Color(255, 255, 255));
		pnl_Loc_TheoThoiGian.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Theo kho\u1EA3ng th\u1EDDi gian", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_Loc_TheoThoiGian.setBounds(10, 33, 235, 180);
		panel_Loc_HoaDon.add(pnl_Loc_TheoThoiGian);
		pnl_Loc_TheoThoiGian.setLayout(null);

		JDateChooser dateCh_TuNgay = new JDateChooser();
		dateCh_TuNgay.setBounds(60, 23, 165, 19);
		pnl_Loc_TheoThoiGian.add(dateCh_TuNgay);

		JDateChooser dateCh_DenNgay = new JDateChooser();
		dateCh_DenNgay.setBounds(60, 47, 165, 19);
		pnl_Loc_TheoThoiGian.add(dateCh_DenNgay);

		JLabel lblNewLabel_1 = new JLabel("Đến");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(20, 53, 45, 13);
		pnl_Loc_TheoThoiGian.add(lblNewLabel_1);

		JPanel pnl_LocThang = new JPanel();
		pnl_LocThang.setBackground(new Color(255, 255, 255));
		pnl_LocThang.setBounds(10, 76, 215, 25);
		pnl_Loc_TheoThoiGian.add(pnl_LocThang);
		pnl_LocThang.setLayout(null);

		JCheckBox chkbx_Loc_TheoThang = new JCheckBox("Tháng");
		chkbx_Loc_TheoThang.setBackground(new Color(255, 255, 255));
		chkbx_Loc_TheoThang.setBounds(10, 0, 61, 27);
		chkbx_Loc_TheoThang.setHorizontalAlignment(SwingConstants.LEFT);
		chkbx_Loc_TheoThang.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		pnl_LocThang.add(chkbx_Loc_TheoThang);

		JComboBox cbx_LocThang = new JComboBox();
		cbx_LocThang.setBounds(90, 2, 100, 20);
		pnl_LocThang.add(cbx_LocThang);

		JPanel pnl_LocNam = new JPanel();
		pnl_LocNam.setLayout(null);
		pnl_LocNam.setBackground(Color.WHITE);
		pnl_LocNam.setBounds(10, 111, 215, 25);
		pnl_Loc_TheoThoiGian.add(pnl_LocNam);

		JCheckBox chkbx_Loc_TheoNam = new JCheckBox("Năm");
		chkbx_Loc_TheoNam.setHorizontalAlignment(SwingConstants.LEFT);
		chkbx_Loc_TheoNam.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		chkbx_Loc_TheoNam.setBackground(Color.WHITE);
		chkbx_Loc_TheoNam.setBounds(10, 0, 61, 27);
		pnl_LocNam.add(chkbx_Loc_TheoNam);

		JComboBox cbx_LocNam = new JComboBox();
		cbx_LocNam.setBounds(90, 2, 100, 20);
		pnl_LocNam.add(cbx_LocNam);

		JPanel pnl_LocQuy = new JPanel();
		pnl_LocQuy.setLayout(null);
		pnl_LocQuy.setBackground(Color.WHITE);
		pnl_LocQuy.setBounds(10, 146, 215, 25);
		pnl_Loc_TheoThoiGian.add(pnl_LocQuy);

		JCheckBox chkbx_Loc_TheoQuy = new JCheckBox("Quý");
		chkbx_Loc_TheoQuy.setHorizontalAlignment(SwingConstants.LEFT);
		chkbx_Loc_TheoQuy.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		chkbx_Loc_TheoQuy.setBackground(Color.WHITE);
		chkbx_Loc_TheoQuy.setBounds(10, 0, 61, 27);
		pnl_LocQuy.add(chkbx_Loc_TheoQuy);

		JComboBox cbx_LocQuy = new JComboBox();
		cbx_LocQuy.setBounds(90, 2, 100, 20);
		pnl_LocQuy.add(cbx_LocQuy);

		JLabel lblNewLabel_1_1 = new JLabel("Từ");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(20, 23, 45, 13);
		pnl_Loc_TheoThoiGian.add(lblNewLabel_1_1);

		JPanel pnl_Loc_TheoTongTien = new JPanel();
		pnl_Loc_TheoTongTien.setBorder(new TitledBorder(null, "Theo t\u1ED5ng h\u00F3a \u0111\u01A1n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Loc_TheoTongTien.setBackground(new Color(255, 255, 255));
		pnl_Loc_TheoTongTien.setBounds(10, 223, 235, 50);
		panel_Loc_HoaDon.add(pnl_Loc_TheoTongTien);
		pnl_Loc_TheoTongTien.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 20, 215, 21);
		pnl_Loc_TheoTongTien.add(comboBox);

		JPanel panel_TongTien_HoaDon = new JPanel();
		panel_TongTien_HoaDon.setBackground(new Color(255, 255, 255));
		panel_TongTien_HoaDon.setBounds(10, 561, 1019, 64);
		pnl_HoaDon.add(panel_TongTien_HoaDon);
		panel_TongTien_HoaDon.setLayout(null);

		JPanel pnl_PhanTrang = new JPanel();
		pnl_PhanTrang.setBounds(32, 15, 223, 30);
		panel_TongTien_HoaDon.add(pnl_PhanTrang);

		JPanel pnl_TongDoanhThu = new JPanel();
		pnl_TongDoanhThu.setBackground(new Color(255, 255, 255));
		pnl_TongDoanhThu.setBounds(675, 15, 335, 25);
		panel_TongTien_HoaDon.add(pnl_TongDoanhThu);
		pnl_TongDoanhThu.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tổng doanh thu: ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 3, 116, 18);
		pnl_TongDoanhThu.add(lblNewLabel);

		txt_TongDoanhThu = new JTextField();
		txt_TongDoanhThu.setEnabled(false);
		txt_TongDoanhThu.setBounds(130, 4, 199, 18);
		pnl_TongDoanhThu.add(txt_TongDoanhThu);
		txt_TongDoanhThu.setColumns(10);

		JPanel pnl_TongSoHoaDon = new JPanel();
		pnl_TongSoHoaDon.setLayout(null);
		pnl_TongSoHoaDon.setBackground(Color.WHITE);
		pnl_TongSoHoaDon.setBounds(494, 15, 171, 25);
		panel_TongTien_HoaDon.add(pnl_TongSoHoaDon);

		JLabel lblTngSHa = new JLabel("Tổng số hóa đơn:");
		lblTngSHa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTngSHa.setBounds(10, 3, 116, 18);
		pnl_TongSoHoaDon.add(lblTngSHa);

		txt_TongSoHoaDon = new JTextField();
		txt_TongSoHoaDon.setEnabled(false);
		txt_TongSoHoaDon.setText(tongSoHD + "");
		txt_TongSoHoaDon.setColumns(10);
		txt_TongSoHoaDon.setBounds(130, 4, 36, 18);
		pnl_TongSoHoaDon.add(txt_TongSoHoaDon);

		JPanel pnl_DichVu = new JPanel();
		tabbedPane.addTab("DỊCH VỤ", null, pnl_DichVu, null);
		pnl_DichVu.setLayout(null);
		pnl_DichVu.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		pnl_DichVu.setBackground(new Color(5, 74, 145));
		pnl_DichVu.setBounds(0, 10, 806, 64);

		JScrollPane scrollPane_DichVu = new JScrollPane();
		scrollPane_DichVu.setBounds(10, 10, 1019, 549);
		pnl_DichVu.add(scrollPane_DichVu);

		table_DichVu = new JTable();
		table_DichVu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "T\u00EAn d\u1ECBch v\u1EE5", "S\u1ED1 l\u01B0\u1EE3ng nh\u1EADp",
						"S\u1ED1 l\u01B0\u1EE3ng b\u00E1n", "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n",
						"T\u1ED5ng ti\u1EC1n b\u00E1n" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_DichVu.getColumnModel().getColumn(0).setResizable(false);
		table_DichVu.getColumnModel().getColumn(1).setResizable(false);
		table_DichVu.getColumnModel().getColumn(2).setResizable(false);
		table_DichVu.getColumnModel().getColumn(3).setResizable(false);
		table_DichVu.getColumnModel().getColumn(4).setResizable(false);
		scrollPane_DichVu.add(table_DichVu);
		scrollPane_DichVu.setViewportView(table_DichVu);

		JPanel panel_Loc_DichVu = new JPanel();
		panel_Loc_DichVu.setLayout(null);
		panel_Loc_DichVu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Loc_DichVu.setBackground(Color.WHITE);
		panel_Loc_DichVu.setBounds(1030, 10, 255, 615);
		pnl_DichVu.add(panel_Loc_DichVu);

		JLabel lbl_Loc_1 = new JLabel("LỌC");
		lbl_Loc_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_Loc_1.setBounds(126, 10, 55, 13);
		panel_Loc_DichVu.add(lbl_Loc_1);

		JPanel pnl_Loc_TheoThoiGian_1 = new JPanel();
		pnl_Loc_TheoThoiGian_1.setLayout(null);
		pnl_Loc_TheoThoiGian_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Theo kho\u1EA3ng th\u1EDDi gian", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_Loc_TheoThoiGian_1.setBackground(Color.WHITE);
		pnl_Loc_TheoThoiGian_1.setBounds(10, 33, 235, 180);
		panel_Loc_DichVu.add(pnl_Loc_TheoThoiGian_1);

		JDateChooser dateCh_DV_TuNgay = new JDateChooser();
		dateCh_DV_TuNgay.setBounds(60, 23, 165, 19);
		pnl_Loc_TheoThoiGian_1.add(dateCh_DV_TuNgay);

		JDateChooser dateCh_DV_DenNgay = new JDateChooser();
		dateCh_DV_DenNgay.setBounds(60, 47, 165, 19);
		pnl_Loc_TheoThoiGian_1.add(dateCh_DV_DenNgay);

		JLabel lblNewLabel_1_2 = new JLabel("Đến");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_1_2.setBounds(20, 53, 45, 13);
		pnl_Loc_TheoThoiGian_1.add(lblNewLabel_1_2);

		JPanel pnl_LocThang_1 = new JPanel();
		pnl_LocThang_1.setLayout(null);
		pnl_LocThang_1.setBackground(Color.WHITE);
		pnl_LocThang_1.setBounds(10, 76, 215, 25);
		pnl_Loc_TheoThoiGian_1.add(pnl_LocThang_1);

		JCheckBox chkbx_DV_Loc_TheoThang = new JCheckBox("Tháng");
		chkbx_DV_Loc_TheoThang.setHorizontalAlignment(SwingConstants.LEFT);
		chkbx_DV_Loc_TheoThang.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		chkbx_DV_Loc_TheoThang.setBackground(Color.WHITE);
		chkbx_DV_Loc_TheoThang.setBounds(10, 0, 61, 27);
		pnl_LocThang_1.add(chkbx_DV_Loc_TheoThang);

		JComboBox cbx_DV_LocThang = new JComboBox();
		cbx_DV_LocThang.setBounds(90, 2, 100, 20);
		pnl_LocThang_1.add(cbx_DV_LocThang);

		JPanel pnl_LocNam_1 = new JPanel();
		pnl_LocNam_1.setLayout(null);
		pnl_LocNam_1.setBackground(Color.WHITE);
		pnl_LocNam_1.setBounds(10, 111, 215, 25);
		pnl_Loc_TheoThoiGian_1.add(pnl_LocNam_1);

		JCheckBox chkbx_DV_Loc_TheoNam = new JCheckBox("Năm");
		chkbx_DV_Loc_TheoNam.setHorizontalAlignment(SwingConstants.LEFT);
		chkbx_DV_Loc_TheoNam.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		chkbx_DV_Loc_TheoNam.setBackground(Color.WHITE);
		chkbx_DV_Loc_TheoNam.setBounds(10, 0, 61, 27);
		pnl_LocNam_1.add(chkbx_DV_Loc_TheoNam);

		JComboBox cbx_DV_LocNam = new JComboBox();
		cbx_DV_LocNam.setBounds(90, 2, 100, 20);
		pnl_LocNam_1.add(cbx_DV_LocNam);

		JPanel pnl_LocQuy_1 = new JPanel();
		pnl_LocQuy_1.setLayout(null);
		pnl_LocQuy_1.setBackground(Color.WHITE);
		pnl_LocQuy_1.setBounds(10, 146, 215, 25);
		pnl_Loc_TheoThoiGian_1.add(pnl_LocQuy_1);

		JCheckBox chkbx_DV_Loc_TheoQuy = new JCheckBox("Quý");
		chkbx_DV_Loc_TheoQuy.setHorizontalAlignment(SwingConstants.LEFT);
		chkbx_DV_Loc_TheoQuy.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		chkbx_DV_Loc_TheoQuy.setBackground(Color.WHITE);
		chkbx_DV_Loc_TheoQuy.setBounds(10, 0, 61, 27);
		pnl_LocQuy_1.add(chkbx_DV_Loc_TheoQuy);

		JComboBox cbx_DV_LocQuy = new JComboBox();
		cbx_DV_LocQuy.setBounds(90, 2, 100, 20);
		pnl_LocQuy_1.add(cbx_DV_LocQuy);

		JLabel lblNewLabel_1_1_1 = new JLabel("Từ");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_1_1_1.setBounds(20, 23, 45, 13);
		pnl_Loc_TheoThoiGian_1.add(lblNewLabel_1_1_1);

		JPanel pnl_Loc_TheoTongTien_1 = new JPanel();
		pnl_Loc_TheoTongTien_1.setLayout(null);
		pnl_Loc_TheoTongTien_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Theo t\u1ED5ng gi\u00E1 ti\u1EC1n b\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnl_Loc_TheoTongTien_1.setBackground(Color.WHITE);
		pnl_Loc_TheoTongTien_1.setBounds(10, 223, 235, 50);
		panel_Loc_DichVu.add(pnl_Loc_TheoTongTien_1);

		JComboBox cbx_DV_TongGiaBan = new JComboBox();
		cbx_DV_TongGiaBan.setBounds(10, 20, 215, 21);
		pnl_Loc_TheoTongTien_1.add(cbx_DV_TongGiaBan);

		JPanel panel_TongTien_DichVu = new JPanel();
		panel_TongTien_DichVu.setLayout(null);
		panel_TongTien_DichVu.setBackground(Color.WHITE);
		panel_TongTien_DichVu.setBounds(10, 561, 1019, 64);
		pnl_DichVu.add(panel_TongTien_DichVu);

		JPanel pnl_PhanTrang_1 = new JPanel();
		pnl_PhanTrang_1.setBounds(32, 15, 223, 30);
		panel_TongTien_DichVu.add(pnl_PhanTrang_1);

		JPanel pnl_TongDoanhThu_1 = new JPanel();
		pnl_TongDoanhThu_1.setLayout(null);
		pnl_TongDoanhThu_1.setBackground(Color.WHITE);
		pnl_TongDoanhThu_1.setBounds(675, 15, 335, 25);
		panel_TongTien_DichVu.add(pnl_TongDoanhThu_1);

		JLabel lblNewLabel_2 = new JLabel("Tổng doanh thu: ");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 3, 116, 18);
		pnl_TongDoanhThu_1.add(lblNewLabel_2);

		txt_TongTien_DichVu = new JTextField();
		txt_TongTien_DichVu.setEnabled(false);
		txt_TongTien_DichVu.setColumns(10);
		txt_TongTien_DichVu.setBounds(130, 4, 199, 18);
		pnl_TongDoanhThu_1.add(txt_TongTien_DichVu);

		JPanel pnl_TongSoHoaDon_1 = new JPanel();
		pnl_TongSoHoaDon_1.setLayout(null);
		pnl_TongSoHoaDon_1.setBackground(Color.WHITE);
		pnl_TongSoHoaDon_1.setBounds(494, 15, 171, 25);
		panel_TongTien_DichVu.add(pnl_TongSoHoaDon_1);

		JLabel lblTngSHa_1 = new JLabel("Tổng số hóa đơn:");
		lblTngSHa_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTngSHa_1.setBounds(10, 3, 116, 18);
		pnl_TongSoHoaDon_1.add(lblTngSHa_1);

		txt_TongSo_DichVu = new JTextField();
		txt_TongSo_DichVu.setHorizontalAlignment(SwingConstants.CENTER);
		txt_TongSo_DichVu.setText("0");
		txt_TongSo_DichVu.setEnabled(false);
		txt_TongSo_DichVu.setColumns(10);
		txt_TongSo_DichVu.setBounds(130, 4, 36, 18);
		pnl_TongSoHoaDon_1.add(txt_TongSo_DichVu);

		DAO_HD = new HoaDon_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_KH = new KhachHang_DAO();
		tongSoHD = 0;

		// TODO: Lấy tất cả hóa đơn của nhân viên đang đăng nhập
//		try {
//			dsHD = DAO_HD.layTatCaHoaDon();
//			System.out.println(dsHD);
//			if (dsHD != null) {
//				dsHD.forEach(hd -> {
//					KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
//					NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
//					
//					//Kiểm tra nhân viên thanh toán hóa đơn có phải là nhân viên đang đăng nhập hay không
//					if(nv.getMaNhanVien().equals(nhVien.getMaNhanVien())) {
//					Object[] rowData = { hd.getMaHoaDon(), hd.getThoiGianKetThuc(), kh.getHoTen(), nv.getHoTen(), "" };
//					model.addRow(rowData); 
//					tongSoHD++;}
//				});
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

		// Lấy tất cả hóa đơn của tất cả nhân viên
		try {
			dsHD = DAO_HD.layTatCaHoaDon();
			System.out.println(dsHD);
			if (dsHD != null) {
				dsHD.forEach(hd -> {
					KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
					NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
					Object[] rowData = { hd.getMaHoaDon(), hd.getThoiGianKetThuc(), kh.getHoTen(), nv.getHoTen(), "" };
					model.addRow(rowData);
					tongSoHD++;
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

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
}