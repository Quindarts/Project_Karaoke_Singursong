package gui;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import dao.ChiTietDichVu_DAO;
import dao.ChiTietHoaDon_DAO;
import dao.DichVu_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiPhong_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import dao.ThongTinDichVu_DAO;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.ThongTinDichVu;
import gui.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;

public class JPanel_BaoCaoThongKe extends JPanel implements ActionListener, PropertyChangeListener {

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

	private KhachHang_DAO DAO_KH;
	private HoaDon_DAO DAO_HD;
	private NhanVien_DAO DAO_NV;
	private ChiTietHoaDon_DAO DAO_CTHD;
	private ChiTietDichVu_DAO DAO_CTDV;
	private ArrayList<HoaDon> dsHD;
	private int tongSoHD;
	private JTextField txt_DV_TongDoanhThu;
	private JTextField txt_DV_TongSoLuong;
	private JTextField txt_HD_TongDoanhThu;
	private JTextField txt_HD_TongSoLuong;
	private DefaultTableModel model_HoaDon;
	private JTable table_HoaDon;
	private JTable table_DichVu;
	private DefaultTableModel model_DichVu;
	private DichVu_DAO DAO_DV;
	private int tongSoDV;
	private ArrayList<DichVu> dsDV;
	private ThongTinDichVu thongTinDV;
	private ThongTinDichVu_DAO DAO_TTDV;
	private JDateChooser dateCh_HD_TuNgay;
	private JDateChooser dateCh_HD_DenNgay;
	private JComboBox<String> cbx_HD_LocThang;
	private JComboBox<String> cbx_HD_LocNam;
	private JComboBox<String> cbx_HD_LocQuy;
	private JComboBox<String> cbx_HD_Loc_TongTien;
	private JDateChooser dateCh_DV_TuNgay;
	private JDateChooser dateCh_DV_DenNgay;
	private JComboBox<String> cbx_DV_LocThang;
	private JComboBox<String> cbx_DV_LocNam;
	private JComboBox<String> cbx_DV_LocQuy;
	private JComboBox<String> cbx_DV_Loc_TongTien;
	private JButton btn_HD_LamMoi;
	private JButton btn_DV_LamMoi;
	private double tongDoanhThu_DV;
	private double tongDoanhThu_HD;
	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat dateFormat_HM = new SimpleDateFormat("HH:mm");
	private SimpleDateFormat dateFormat_YMDHMS = new SimpleDateFormat("dd-M-yyyy hh:mm");
	private DecimalFormat dcf = new DecimalFormat("#,##0 VND");
	private Calendar calendar = Calendar.getInstance();
	private int dv_Nam_Loc;
	private int dv_Thang_Loc;
	private int dv_Quy_Loc;
	private int hd_Nam_Loc;
	private int hd_Thang_Loc;
	private int hd_Quy_Loc;
	private ArrayList<ChiTietHoaDon> dsCTHD;
	private ArrayList<ChiTietDichVu> dsCTDV;
	private ArrayList<HoaDon> dsHD_DaThanhToan;
	private JLabel lbl_HD_ThongBao;
	private JLabel lbl_DV_ThongBao;
	private Date ngayKetThuc;
	private Date ngayBatDau;
	private String ngBatDau;
	private String ngKetThuc;
	
	private NhanVien nv;

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

		DAO_HD = new HoaDon_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_KH = new KhachHang_DAO();
		DAO_DV = new DichVu_DAO();
		DAO_TTDV = new ThongTinDichVu_DAO();
		tongSoHD = 0;
		tongSoDV = 0;
		tongDoanhThu_DV = 0;
		tongDoanhThu_HD = 0;

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 128, 255));
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 17));
		tabbedPane.setBounds(0, 0, 1296, 672);
		panel.add(tabbedPane);

		/**
		 * Tạo Panel Hóa đơn
		 */
		JPanel pnl_HoaDon = new JPanel();
		pnl_HoaDon.setLayout(null);
		pnl_HoaDon.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		pnl_HoaDon.setBackground(new Color(5, 74, 145));
		tabbedPane.addTab("Hóa đơn", null, pnl_HoaDon, null);

		JScrollPane scrollPane_HoaDon = new JScrollPane();
		scrollPane_HoaDon.setBounds(10, 10, 1019, 549);
		model_HoaDon = new DefaultTableModel();
		table_HoaDon = new JTable();
		table_HoaDon.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "STT", "M\u00E3 h\u00F3a \u0111\u01A1n",
						"Ngày thanh toán", "Kh\u00E1ch h\u00E0ng", "Nh\u00E2n vi\u00EAn", "T\u1ED5ng ti\u1EC1n" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

		table_HoaDon.getColumnModel().getColumn(0).setResizable(false);
		table_HoaDon.getColumnModel().getColumn(0).setPreferredWidth(51);
		table_HoaDon.getColumnModel().getColumn(0).setMaxWidth(50);
		scrollPane_HoaDon.add(table_HoaDon);
		scrollPane_HoaDon.setViewportView(table_HoaDon);
		pnl_HoaDon.add(scrollPane_HoaDon);

		JPanel panel_Loc = new JPanel();
		panel_Loc.setLayout(null);
		panel_Loc.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Loc.setBackground(Color.WHITE);
		panel_Loc.setBounds(1031, 10, 255, 615);
		pnl_HoaDon.add(panel_Loc);

		JLabel lbl_Loc = new JLabel("LỌC");
		lbl_Loc.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_Loc.setBounds(126, 10, 55, 13);
		panel_Loc.add(lbl_Loc);

		JPanel pnl_Loc_TheoThoiGian = new JPanel();
		pnl_Loc_TheoThoiGian.setLayout(null);
		pnl_Loc_TheoThoiGian.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Theo kho\u1EA3ng th\u1EDDi gian", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_Loc_TheoThoiGian.setBackground(Color.WHITE);
		pnl_Loc_TheoThoiGian.setBounds(10, 33, 235, 180);
		panel_Loc.add(pnl_Loc_TheoThoiGian);

		dateCh_HD_TuNgay = new JDateChooser();
		dateCh_HD_TuNgay.setBounds(60, 23, 165, 19);
		dateCh_HD_TuNgay.setDateFormatString("yyyy-MM-dd");
		pnl_Loc_TheoThoiGian.add(dateCh_HD_TuNgay);

		dateCh_HD_DenNgay = new JDateChooser();
		dateCh_HD_DenNgay.setBounds(60, 47, 165, 19);
		dateCh_HD_DenNgay.setDateFormatString("yyyy-MM-dd");
		pnl_Loc_TheoThoiGian.add(dateCh_HD_DenNgay);

		JLabel lblNewLabel_1 = new JLabel("Đến");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(20, 53, 45, 13);
		pnl_Loc_TheoThoiGian.add(lblNewLabel_1);

		JPanel pnl_LocThang = new JPanel();
		pnl_LocThang.setLayout(null);
		pnl_LocThang.setBackground(Color.WHITE);
		pnl_LocThang.setBounds(10, 76, 215, 25);
		pnl_Loc_TheoThoiGian.add(pnl_LocThang);

		cbx_HD_LocThang = new JComboBox<String>();
		cbx_HD_LocThang.setBounds(70, 2, 100, 20);
		cbx_HD_LocThang.addItem("Chọn tháng");
		for (int i = 1; i <= 12; i++) {
			cbx_HD_LocThang.addItem(i + "");
		}
		cbx_HD_LocThang.setMaximumRowCount(6);
		pnl_LocThang.add(cbx_HD_LocThang);

		JLabel lblNewLabel_3 = new JLabel("Tháng");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 2, 70, 20);
		pnl_LocThang.add(lblNewLabel_3);

		JPanel pnl_LocNam = new JPanel();
		pnl_LocNam.setLayout(null);
		pnl_LocNam.setBackground(Color.WHITE);
		pnl_LocNam.setBounds(10, 111, 215, 25);
		pnl_Loc_TheoThoiGian.add(pnl_LocNam);

		cbx_HD_LocNam = new JComboBox<String>();
		cbx_HD_LocNam.setBounds(70, 2, 100, 20);
		cbx_HD_LocNam.addItem("Chọn năm");
		for (int i = LocalDate.now().getYear(); i >= 2000; i--) {
			cbx_HD_LocNam.addItem(i + "");
		}
		cbx_HD_LocNam.setMaximumRowCount(6);
		pnl_LocNam.add(cbx_HD_LocNam);

		JLabel lblNewLabel_3_1 = new JLabel("Năm");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_3_1.setBounds(10, 2, 70, 20);
		pnl_LocNam.add(lblNewLabel_3_1);

		JPanel pnl_LocQuy = new JPanel();
		pnl_LocQuy.setLayout(null);
		pnl_LocQuy.setBackground(Color.WHITE);
		pnl_LocQuy.setBounds(10, 146, 215, 25);
		pnl_Loc_TheoThoiGian.add(pnl_LocQuy);

		cbx_HD_LocQuy = new JComboBox<String>();
		cbx_HD_LocQuy.setBounds(70, 2, 100, 20);
		cbx_HD_LocQuy.addItem("Chọn quý");
		cbx_HD_LocQuy.addItem("1");
		cbx_HD_LocQuy.addItem("2");
		cbx_HD_LocQuy.addItem("3");
		cbx_HD_LocQuy.addItem("4");
		pnl_LocQuy.add(cbx_HD_LocQuy);

		JLabel lblNewLabel_3_1_1 = new JLabel("Quý");
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_3_1_1.setBounds(10, 2, 70, 20);
		pnl_LocQuy.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Từ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_1_1.setBounds(20, 23, 45, 13);
		pnl_Loc_TheoThoiGian.add(lblNewLabel_1_1);

		JPanel pnl_Loc_TheoTongTien = new JPanel();
		pnl_Loc_TheoTongTien.setLayout(null);
		pnl_Loc_TheoTongTien.setBorder(new TitledBorder(null, "Theo t\u1ED5ng h\u00F3a \u0111\u01A1n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Loc_TheoTongTien.setBackground(Color.WHITE);
		pnl_Loc_TheoTongTien.setBounds(10, 223, 235, 50);
		panel_Loc.add(pnl_Loc_TheoTongTien);

		cbx_HD_Loc_TongTien = new JComboBox<String>();
		cbx_HD_Loc_TongTien.setBounds(10, 20, 215, 21);
		cbx_HD_Loc_TongTien.addItem("Chọn tổng tiền");
		cbx_HD_Loc_TongTien.addItem("Dưới 500.000VNĐ");
		cbx_HD_Loc_TongTien.addItem("Từ 500.000VNĐ đến 2.000.000VNĐ");
		cbx_HD_Loc_TongTien.addItem("Từ 2.000.000VNĐ đến 5.000.000VNĐ");
		cbx_HD_Loc_TongTien.addItem("Từ 5.000.000VNĐ đến 10.000.000VNĐ");
		cbx_HD_Loc_TongTien.addItem("Trên 10.000.000VNĐ");
		pnl_Loc_TheoTongTien.add(cbx_HD_Loc_TongTien);

		btn_HD_LamMoi = new JButton("Làm mới");
		btn_HD_LamMoi.setForeground(new Color(255, 255, 255));
		btn_HD_LamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_HD_LamMoi.setBackground(new Color(0, 128, 255));
		btn_HD_LamMoi.setBounds(96, 313, 85, 21);
		btn_HD_LamMoi.addActionListener(this);
		panel_Loc.add(btn_HD_LamMoi);

		lbl_HD_ThongBao = new JLabel("");
		lbl_HD_ThongBao.setForeground(new Color(255, 0, 0));
		lbl_HD_ThongBao.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lbl_HD_ThongBao.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_HD_ThongBao.setBounds(10, 283, 235, 20);
		panel_Loc.add(lbl_HD_ThongBao);

		JPanel panel_TongTien = new JPanel();
		panel_TongTien.setLayout(null);
		panel_TongTien.setBackground(Color.WHITE);
		panel_TongTien.setBounds(10, 561, 1019, 64);
		pnl_HoaDon.add(panel_TongTien);

		JPanel pnl_TongDoanhThu = new JPanel();
		pnl_TongDoanhThu.setLayout(null);
		pnl_TongDoanhThu.setBackground(Color.WHITE);
		pnl_TongDoanhThu.setBounds(675, 15, 335, 25);
		panel_TongTien.add(pnl_TongDoanhThu);

		JLabel lblNewLabel = new JLabel("Tổng doanh thu: ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 3, 116, 18);
		pnl_TongDoanhThu.add(lblNewLabel);

		txt_HD_TongDoanhThu = new JTextField();
		txt_HD_TongDoanhThu.setEditable(false);
		txt_HD_TongDoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
		txt_HD_TongDoanhThu.setColumns(10);
		txt_HD_TongDoanhThu.setBounds(130, 4, 199, 18);
		pnl_TongDoanhThu.add(txt_HD_TongDoanhThu);

		JPanel pnl_TongSoHoaDon = new JPanel();
		pnl_TongSoHoaDon.setLayout(null);
		pnl_TongSoHoaDon.setBackground(Color.WHITE);
		pnl_TongSoHoaDon.setBounds(494, 15, 171, 25);
		panel_TongTien.add(pnl_TongSoHoaDon);

		JLabel lblTngSHa = new JLabel("Tổng số hóa đơn:");
		lblTngSHa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTngSHa.setBounds(10, 3, 116, 18);
		pnl_TongSoHoaDon.add(lblTngSHa);

		txt_HD_TongSoLuong = new JTextField();
		txt_HD_TongSoLuong.setText("0");
		txt_HD_TongSoLuong.setEnabled(false);
		txt_HD_TongSoLuong.setColumns(10);
		txt_HD_TongSoLuong.setBounds(130, 4, 36, 18);
		pnl_TongSoHoaDon.add(txt_HD_TongSoLuong);

		/**
		 * Tạo Panel Dịch vụ
		 */
		JPanel pnl_DichVu = new JPanel();
		pnl_DichVu.setLayout(null);
		pnl_DichVu.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		pnl_DichVu.setBackground(new Color(5, 74, 145));
		tabbedPane.addTab("Dịch vụ", null, pnl_DichVu, null);

		// Bieu do thong ke
		JPanel pnl_bieuDo = new JPanel_BieuDoThongKe(nhVien);

		tabbedPane.addTab("Biểu đồ", null, pnl_bieuDo, null);

		JScrollPane scrollPane_DichVu = new JScrollPane();
		scrollPane_DichVu.setBounds(10, 10, 1019, 549);
		pnl_DichVu.add(scrollPane_DichVu);
		model_DichVu = new DefaultTableModel();
		table_DichVu = new JTable();
		table_DichVu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "M\u00E3 d\u1ECBch v\u1EE5", "T\u00EAn d\u1ECBch v\u1EE5", "Ng\u00E0y nh\u1EADp",
						"Số lượng bán", "T\u1ED5ng ti\u1EC1n b\u00E1n" }) {
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			}
		});
		table_DichVu.getColumnModel().getColumn(0).setResizable(false);
		table_DichVu.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_DichVu.getColumnModel().getColumn(0).setMaxWidth(50);
		scrollPane_DichVu.add(table_DichVu);
		scrollPane_DichVu.setViewportView(table_DichVu);

		JPanel panel_Loc_DichVu = new JPanel();
		panel_Loc_DichVu.setLayout(null);
		panel_Loc_DichVu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Loc_DichVu.setBackground(Color.WHITE);
		panel_Loc_DichVu.setBounds(1036, 10, 255, 615);
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

		dateCh_DV_TuNgay = new JDateChooser();
		dateCh_DV_TuNgay.setBounds(60, 23, 165, 19);
		dateCh_DV_TuNgay.setDateFormatString("yyyy-MM-dd");
		pnl_Loc_TheoThoiGian_1.add(dateCh_DV_TuNgay);

		dateCh_DV_DenNgay = new JDateChooser();
		dateCh_DV_DenNgay.setBounds(60, 47, 165, 19);
		dateCh_DV_DenNgay.setDateFormatString("yyyy-MM-dd");
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

		cbx_DV_LocThang = new JComboBox<String>();
		cbx_DV_LocThang.setBounds(70, 2, 100, 20);
		cbx_DV_LocThang.addItem("Chọn tháng");
		for (int i = 1; i <= 12; i++) {
			cbx_DV_LocThang.addItem(i + "");
		}
		cbx_DV_LocThang.setMaximumRowCount(6);
		pnl_LocThang_1.add(cbx_DV_LocThang);

		JLabel lblNewLabel_3_2 = new JLabel("Tháng");
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_3_2.setBounds(10, 2, 70, 20);
		pnl_LocThang_1.add(lblNewLabel_3_2);

		JPanel pnl_LocNam_1 = new JPanel();
		pnl_LocNam_1.setLayout(null);
		pnl_LocNam_1.setBackground(Color.WHITE);
		pnl_LocNam_1.setBounds(10, 111, 215, 25);
		pnl_Loc_TheoThoiGian_1.add(pnl_LocNam_1);

		cbx_DV_LocNam = new JComboBox<String>();
		cbx_DV_LocNam.setBounds(70, 2, 100, 20);
		cbx_DV_LocNam.addItem("Chọn năm");
		for (int i = LocalDate.now().getYear(); i >= 2000; i--) {
			cbx_DV_LocNam.addItem(i + "");
		}
		cbx_DV_LocNam.setMaximumRowCount(6);
		pnl_LocNam_1.add(cbx_DV_LocNam);

		JLabel lblNewLabel_3_2_1 = new JLabel("Năm");
		lblNewLabel_3_2_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_3_2_1.setBounds(10, 2, 70, 20);
		pnl_LocNam_1.add(lblNewLabel_3_2_1);

		JPanel pnl_DV_LocQuy = new JPanel();
		pnl_DV_LocQuy.setLayout(null);
		pnl_DV_LocQuy.setBackground(Color.WHITE);
		pnl_DV_LocQuy.setBounds(10, 146, 215, 25);
		pnl_Loc_TheoThoiGian_1.add(pnl_DV_LocQuy);

		cbx_DV_LocQuy = new JComboBox<String>();
		cbx_DV_LocQuy.setBounds(70, 2, 100, 20);
		cbx_DV_LocQuy.addItem("Chọn quý");
		cbx_DV_LocQuy.addItem("1");
		cbx_DV_LocQuy.addItem("2");
		cbx_DV_LocQuy.addItem("3");
		cbx_DV_LocQuy.addItem("4");
		pnl_DV_LocQuy.add(cbx_DV_LocQuy);

		JLabel lblNewLabel_3_2_1_1 = new JLabel("Quý");
		lblNewLabel_3_2_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblNewLabel_3_2_1_1.setBounds(10, 2, 70, 20);
		pnl_DV_LocQuy.add(lblNewLabel_3_2_1_1);

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

		cbx_DV_Loc_TongTien = new JComboBox<String>();
		cbx_DV_Loc_TongTien.setBounds(10, 20, 215, 21);
		cbx_DV_Loc_TongTien.addItem("Chọn tổng tiền");
		cbx_DV_Loc_TongTien.addItem("Dưới 500.000VNĐ");
		cbx_DV_Loc_TongTien.addItem("Từ 500.000VNĐ đến 2.000.000VNĐ");
		cbx_DV_Loc_TongTien.addItem("Từ 2.000.000VNĐ đến 5.000.000VNĐ");
		cbx_DV_Loc_TongTien.addItem("Từ 5.000.000VNĐ đến 10.000.000VNĐ");
		cbx_DV_Loc_TongTien.addItem("Trên 10.000.000VNĐ");
		pnl_Loc_TheoTongTien_1.add(cbx_DV_Loc_TongTien);

		btn_DV_LamMoi = new JButton("Làm mới");
		btn_DV_LamMoi.setBackground(new Color(0, 128, 255));
		btn_DV_LamMoi.setForeground(new Color(255, 255, 255));
		btn_DV_LamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_DV_LamMoi.setBounds(96, 313, 85, 21);
		btn_DV_LamMoi.addActionListener(this);
		panel_Loc_DichVu.add(btn_DV_LamMoi);

		lbl_DV_ThongBao = new JLabel("");
		lbl_DV_ThongBao.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DV_ThongBao.setForeground(Color.RED);
		lbl_DV_ThongBao.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lbl_DV_ThongBao.setBounds(10, 283, 235, 20);
		panel_Loc_DichVu.add(lbl_DV_ThongBao);

		JPanel panel_TongTien_DichVu = new JPanel();
		panel_TongTien_DichVu.setLayout(null);
		panel_TongTien_DichVu.setBackground(Color.WHITE);
		panel_TongTien_DichVu.setBounds(10, 561, 1019, 64);
		pnl_DichVu.add(panel_TongTien_DichVu);

		JPanel pnl_TongDoanhThu_1 = new JPanel();
		pnl_TongDoanhThu_1.setLayout(null);
		pnl_TongDoanhThu_1.setBackground(Color.WHITE);
		pnl_TongDoanhThu_1.setBounds(675, 15, 335, 25);
		panel_TongTien_DichVu.add(pnl_TongDoanhThu_1);

		JLabel lblNewLabel_2 = new JLabel("Tổng doanh thu: ");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 3, 116, 18);
		pnl_TongDoanhThu_1.add(lblNewLabel_2);

		txt_DV_TongDoanhThu = new JTextField();
		txt_DV_TongDoanhThu.setEditable(false);
		txt_DV_TongDoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
		txt_DV_TongDoanhThu.setColumns(10);
		txt_DV_TongDoanhThu.setBounds(130, 4, 199, 18);
		pnl_TongDoanhThu_1.add(txt_DV_TongDoanhThu);

		JPanel pnl_TongSoHoaDon_1 = new JPanel();
		pnl_TongSoHoaDon_1.setLayout(null);
		pnl_TongSoHoaDon_1.setBackground(Color.WHITE);
		pnl_TongSoHoaDon_1.setBounds(494, 15, 171, 25);
		panel_TongTien_DichVu.add(pnl_TongSoHoaDon_1);

		JLabel lblTngSHa_1 = new JLabel("Tổng số dịch vụ:");
		lblTngSHa_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTngSHa_1.setBounds(10, 3, 116, 18);
		pnl_TongSoHoaDon_1.add(lblTngSHa_1);

		txt_DV_TongSoLuong = new JTextField();
		txt_DV_TongSoLuong.setText("0");
		txt_DV_TongSoLuong.setHorizontalAlignment(SwingConstants.LEFT);
		txt_DV_TongSoLuong.setEnabled(false);
		txt_DV_TongSoLuong.setColumns(10);
		txt_DV_TongSoLuong.setBounds(130, 4, 36, 18);
		pnl_TongSoHoaDon_1.add(txt_DV_TongSoLuong);

		cbx_DV_Loc_TongTien.addActionListener(this);
		cbx_DV_LocNam.addActionListener(this);
		cbx_DV_LocQuy.addActionListener(this);
		cbx_DV_LocThang.addActionListener(this);
		cbx_HD_Loc_TongTien.addActionListener(this);
		cbx_HD_LocNam.addActionListener(this);
		cbx_HD_LocQuy.addActionListener(this);
		cbx_HD_LocThang.addActionListener(this);

		dateCh_DV_TuNgay.addPropertyChangeListener(this);
		dateCh_DV_DenNgay.addPropertyChangeListener(this);
		dateCh_HD_TuNgay.addPropertyChangeListener(this);
		dateCh_HD_DenNgay.addPropertyChangeListener(this);

		DocDuLieu_HD();
		DocDuLieu_DV();
		
		nv = nhVien;
		if(!nhVien.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			cbx_DV_LocNam.removeActionListener(this);
			cbx_DV_LocQuy.removeActionListener(this);
			cbx_DV_LocThang.removeActionListener(this);
			
			cbx_DV_LocNam.setEditable(false);
			cbx_DV_LocQuy.setEditable(false);
			cbx_DV_LocThang.setEditable(false);
			
			cbx_DV_LocNam.setEnabled(false);
			cbx_DV_LocQuy.setEnabled(false);
			cbx_DV_LocThang.setEnabled(false);
//			----------------------
			cbx_HD_LocNam.removeActionListener(this);
			cbx_HD_LocQuy.removeActionListener(this);
			cbx_HD_LocThang.removeActionListener(this);
			
			cbx_HD_LocNam.setEditable(false);
			cbx_HD_LocQuy.setEditable(false);
			cbx_HD_LocThang.setEditable(false);
			
			cbx_HD_LocNam.setEnabled(false);
			cbx_HD_LocQuy.setEnabled(false);
			cbx_HD_LocThang.setEnabled(false);
			
//			-----------------
			dateCh_DV_TuNgay.removePropertyChangeListener(this);
			dateCh_DV_DenNgay.removePropertyChangeListener(this);
			dateCh_HD_TuNgay.removePropertyChangeListener(this);
			dateCh_HD_DenNgay.removePropertyChangeListener(this);
			
			dateCh_DV_TuNgay.setEnabled(false);
			dateCh_DV_DenNgay.setEnabled(false);
			dateCh_HD_TuNgay.setEnabled(false);
			dateCh_HD_DenNgay.setEnabled(false);
			
//			-----------------
			LocDuLieu_HD();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_DV_LamMoi)) {
			LamMoiBoLoc_DV();
		}
		if (o.equals(btn_HD_LamMoi)) {
			LamMoiBoLoc_HD();
		}

		if (o.equals(cbx_HD_LocNam) || o.equals(cbx_HD_LocThang) || o.equals(cbx_HD_LocQuy)
				|| o.equals(cbx_HD_Loc_TongTien)) {
			dateCh_HD_TuNgay.setDate(null);
			dateCh_HD_DenNgay.setDate(null);
			LocDuLieu_HD();
		}

		if (o.equals(cbx_DV_LocNam) || o.equals(cbx_DV_LocThang) || o.equals(cbx_DV_LocQuy)
				|| o.equals(cbx_DV_Loc_TongTien)) {
			dateCh_DV_TuNgay.setDate(null);
			dateCh_DV_DenNgay.setDate(null);
			LocDuLieu_DV();
		}

	}

	public void propertyChange(PropertyChangeEvent evt) {
		Object o = evt.getSource();
		if (o.equals(dateCh_DV_TuNgay) || o.equals(dateCh_DV_DenNgay)) {
			LocDuLieu_DV();
		}
		if (o.equals(dateCh_HD_TuNgay) || o.equals(dateCh_HD_DenNgay)) {
			LocDuLieu_HD();
		}
	}

	public void LamMoiBoLoc_HD() {
		model_HoaDon.getDataVector().removeAllElements();
		DocDuLieu_HD();
		cbx_HD_Loc_TongTien.setSelectedIndex(0);
		cbx_HD_LocNam.setSelectedIndex(0);
		cbx_HD_LocQuy.setSelectedIndex(0);
		cbx_HD_LocThang.setSelectedIndex(0);
		dateCh_HD_TuNgay.setDate(null);
		dateCh_HD_DenNgay.setDate(null);
	}

	public void LamMoiBoLoc_DV() {
		model_DichVu.getDataVector().removeAllElements();
		DocDuLieu_DV();
		cbx_DV_Loc_TongTien.setSelectedIndex(0);
		cbx_DV_LocNam.setSelectedIndex(0);
		cbx_DV_LocQuy.setSelectedIndex(0);
		cbx_DV_LocThang.setSelectedIndex(0);
		dateCh_DV_TuNgay.setDate(null);
		dateCh_DV_DenNgay.setDate(null);
	}

	public void DocDuLieu_DV() {
		model_DichVu = (DefaultTableModel) table_DichVu.getModel();
		model_DichVu.getDataVector().removeAllElements();

		try {
			dsDV = DAO_DV.layTatCaDichVu();
			if (dsDV != null) {
				dsDV.forEach(dv -> {
					thongTinDV = new ThongTinDichVu();
					thongTinDV = DAO_TTDV
							.timThongTinDichVu_TheoMaThongTinDichVu(dv.getThongTinDichVu().getMaThongTinDichVu());
					tongDoanhThu_DV = tongDoanhThu_DV + thongTinDV.getSoLuongDaSuDung() * dv.getDonGia();
					double tienBan = thongTinDV.getSoLuongDaSuDung() * dv.getDonGia();
					Object[] rowData_DV = { tongSoDV + 1, dv.getMaDichVu(), dv.getTenDichVu(), thongTinDV.getNgayNhap(),
							thongTinDV.getSoLuongDaSuDung(), dcf.format(tienBan) };
					model_DichVu.addRow(rowData_DV);
					tongSoDV++;
					txt_DV_TongSoLuong.setText(tongSoDV + "");
					txt_DV_TongDoanhThu.setText(dcf.format(tongDoanhThu_DV));
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DocDuLieu_HD() {
		model_HoaDon = (DefaultTableModel) table_HoaDon.getModel();
		model_HoaDon.getDataVector().removeAllElements();
		DAO_CTHD = new ChiTietHoaDon_DAO();
		DAO_CTDV = new ChiTietDichVu_DAO();

//		// Lấy tất cả hóa đơn của tất cả nhân viên dsHD_DaThanhToan
		try {
			dsHD = DAO_HD.layTatCaHoaDon();
			if (dsHD != null) {
				dsHD.forEach(hd -> {
					dsCTHD = DAO_CTHD.timCTHoaDon_TheoMaHoaDon(hd.getMaHoaDon());
					dsCTDV = DAO_CTDV.layDanhSachChiTietDichVu_TheoMaHoaDon(hd.getMaHoaDon());
					KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
					NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
					double tongTien = hd.tinhTongTien(dsCTHD, dsCTDV);
					tongDoanhThu_HD = tongDoanhThu_HD + tongTien;
					if (hd.getThoiGianKetThuc() != null) {
						Object[] rowData_HD = { tongSoHD + 1, hd.getMaHoaDon(), hd.getThoiGianKetThuc(), kh.getHoTen(),
								nv.getHoTen(), dcf.format(tongTien) };
						model_HoaDon.addRow(rowData_HD);
						tongSoHD++;
						txt_HD_TongSoLuong.setText(tongSoHD + "");
						txt_HD_TongDoanhThu.setText(dcf.format(tongDoanhThu_HD));
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void LocDuLieu_HD() {
		model_HoaDon.getDataVector().removeAllElements();

		boolean ketQuaLoc = false;
		tongDoanhThu_HD = 0;
		tongSoHD = 0;
		txt_HD_TongDoanhThu.setText(tongDoanhThu_HD + "");
		txt_HD_TongSoLuong.setText(tongSoHD + "");

		hd_Nam_Loc = 0;
		hd_Thang_Loc = 0;
		hd_Quy_Loc = 0;

		if (cbx_HD_LocNam.getSelectedIndex() != 0) {
			hd_Nam_Loc = Integer.parseInt(cbx_HD_LocNam.getSelectedItem().toString());
		} else {
			hd_Nam_Loc = 0;
		}

		if (cbx_HD_LocThang.getSelectedIndex() != 0) {
			hd_Thang_Loc = Integer.parseInt(cbx_HD_LocThang.getSelectedItem().toString());
		} else {
			hd_Thang_Loc = 0;
		}

		if (cbx_HD_LocQuy.getSelectedIndex() != 0) {
			hd_Quy_Loc = Integer.parseInt(cbx_HD_LocQuy.getSelectedItem().toString());
		} else {
			hd_Quy_Loc = 0;
		}

		double hd_TongBan_Tu = 0;
		double hd_TongBan_Den = Integer.MAX_VALUE;
		if (cbx_HD_Loc_TongTien.getSelectedIndex() != 0) {
			if (cbx_HD_Loc_TongTien.getSelectedIndex() == 1) {
				hd_TongBan_Den = 500000 - 1;
			} else if (cbx_HD_Loc_TongTien.getSelectedIndex() == 2) {
				hd_TongBan_Tu = 500000;
				hd_TongBan_Den = 2000000;
			} else if (cbx_HD_Loc_TongTien.getSelectedIndex() == 3) {
				hd_TongBan_Tu = 2000000;
				hd_TongBan_Den = 5000000;
			} else if (cbx_HD_Loc_TongTien.getSelectedIndex() == 4) {
				hd_TongBan_Tu = 5000000;
				hd_TongBan_Den = 10000000;
			} else if (cbx_HD_Loc_TongTien.getSelectedIndex() == 5) {
				hd_TongBan_Tu = 10000000;
			}
		} else {
			hd_TongBan_Tu = 0;
			hd_TongBan_Den = Integer.MAX_VALUE;
		}

		Date ngayKetThuc = new Date();
		try {
			if(!nv.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
				Calendar calendar = Calendar.getInstance();
				
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				
		        calendar.set(Calendar.HOUR_OF_DAY, 0);     // Giờ
		        calendar.set(Calendar.MINUTE, 1);          // Phút
		        calendar.set(Calendar.SECOND, 0);          // Giây
		        calendar.set(Calendar.MILLISECOND, 0);    // Mili giây

		        ngayKetThuc = calendar.getTime();
			} else {
				ngayKetThuc = dateCh_HD_DenNgay.getDate();
			}
			if (ngayKetThuc == null) {
				ngayKetThuc = new java.util.Date();
			}
		} catch (Exception e) {
			ngayKetThuc = null;
		}

		
		Date ngayBatDau = new Date();
		try {
			if(!nv.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
				Calendar calendar = Calendar.getInstance();
		        calendar.set(Calendar.HOUR_OF_DAY, 0);      // Giờ
		        calendar.set(Calendar.MINUTE, 1);           // Phút
		        calendar.set(Calendar.SECOND, 0);           // Giây
		        calendar.set(Calendar.MILLISECOND, 0);      // Mili giây

		        ngayBatDau = calendar.getTime();
			} else {
				ngayBatDau = dateCh_HD_TuNgay.getDate();
			}
			if (ngayBatDau == null) {
				calendar.set(2000, Calendar.JANUARY, 01);
				ngayBatDau = calendar.getTime();
			}

		} catch (Exception e) {
			ngayBatDau = null;
		}

		if (ngayBatDau.after(ngayKetThuc)) {
			model_HoaDon.getDataVector().removeAllElements();
			lbl_HD_ThongBao.setText("Ngày kết thúc phải sau ngày bắt đầu!");
			return;
		} else {
			lbl_HD_ThongBao.setText("");
		}

		switch (hd_Quy_Loc) {
		case 4:
			if (hd_Thang_Loc < 10 && cbx_HD_LocThang.getSelectedIndex() != 0) {
				lbl_HD_ThongBao.setText("Quý " + hd_Quy_Loc + " không có tháng " + hd_Thang_Loc + "!");
			} else {
				lbl_HD_ThongBao.setText("");
			}
			break;
		case 3:
			if ((hd_Thang_Loc < 7 || hd_Thang_Loc > 10) && cbx_HD_LocThang.getSelectedIndex() != 0) {
				lbl_HD_ThongBao.setText("Quý " + hd_Quy_Loc + " không có tháng " + hd_Thang_Loc + "!");
			} else {
				lbl_HD_ThongBao.setText("");
			}
			break;
		case 2:
			if ((hd_Thang_Loc < 4 || hd_Thang_Loc > 6) && cbx_HD_LocThang.getSelectedIndex() != 0) {
				lbl_HD_ThongBao.setText("Quý " + hd_Quy_Loc + " không có tháng " + hd_Thang_Loc + "!");
			} else {
				lbl_HD_ThongBao.setText("");
			}
			break;
		case 1:
			if (hd_Thang_Loc > 3 && cbx_HD_LocThang.getSelectedIndex() != 0) {
				lbl_HD_ThongBao.setText("Quý " + hd_Quy_Loc + " không có tháng " + hd_Thang_Loc + "!");
			} else {
				lbl_HD_ThongBao.setText("");
			}
			break;

		default:
			break;
		}

		ArrayList<HoaDon> dsHD = DAO_HD.loc_TongHop(dateFormat_YMD.format(ngayBatDau),
				dateFormat_YMD.format(ngayKetThuc), hd_Thang_Loc, hd_Nam_Loc, hd_Quy_Loc);

		for (HoaDon hd : dsHD) {
			dsCTHD = DAO_CTHD.timCTHoaDon_TheoMaHoaDon(hd.getMaHoaDon());
			dsCTDV = DAO_CTDV.layDanhSachChiTietDichVu_TheoMaHoaDon(hd.getMaHoaDon());
			double tongTien = hd.tinhTongTien(dsCTHD, dsCTDV);

			boolean kiemTra = true;
			if (hd_TongBan_Tu > tongTien || hd_TongBan_Den < tongTien) {
				kiemTra = false;
			}
			if (kiemTra) {
				KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
				NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
				tongDoanhThu_HD = tongDoanhThu_HD + tongTien;
				Object[] rowData_HD = { tongSoHD + 1, hd.getMaHoaDon(), hd.getThoiGianKetThuc(), kh.getHoTen(),
						nv.getHoTen(), dcf.format(tongTien) };
				model_HoaDon.addRow(rowData_HD);
				tongSoHD++;
				txt_HD_TongSoLuong.setText(tongSoHD + "");
				txt_HD_TongDoanhThu.setText(dcf.format(tongDoanhThu_HD));
				ketQuaLoc = true;
			}
		}

		if (!ketQuaLoc) {
			model_HoaDon.fireTableDataChanged();
			lbl_HD_ThongBao.setText("Không có hóa đơn phù hợp với tiêu chí lọc!");
		}
	}

	private void LocDuLieu_DV() {
		model_DichVu.getDataVector().removeAllElements();
		boolean ketQuaLoc = false;
		tongDoanhThu_DV = 0;
		tongSoDV = 0;
		txt_DV_TongDoanhThu.setText(tongDoanhThu_DV + "");
		txt_DV_TongSoLuong.setText(tongSoDV + "");

		dv_Nam_Loc = 0;
		dv_Thang_Loc = 0;
		dv_Quy_Loc = 0;

		// Dữ liệu lấy từ bảng lọc
		Date ngayKetThuc = new Date();
		try {
			ngayKetThuc = dateCh_DV_DenNgay.getDate();
			if (ngayKetThuc == null) {
				ngayKetThuc = new java.util.Date();
			}
		} catch (Exception e) {
			ngayKetThuc = null;
		}

		Date ngayBatDau = new Date();
		try {
			ngayBatDau = dateCh_DV_TuNgay.getDate();
			if (ngayBatDau == null) {
				calendar.set(2000, Calendar.JANUARY, 01);
				ngayBatDau = calendar.getTime();
			}
		} catch (Exception e) {
			ngayBatDau = null;
		}

		if (ngayBatDau.after(ngayKetThuc)) {
			model_DichVu.getDataVector().removeAllElements();
			lbl_DV_ThongBao.setText("Ngày kết thúc phải sau ngày bắt đầu!");
			return;
		} else {
			lbl_DV_ThongBao.setText("");
		}

		if (cbx_DV_LocNam.getSelectedIndex() != 0) {
			dv_Nam_Loc = Integer.parseInt(cbx_DV_LocNam.getSelectedItem().toString());
		} else {
			dv_Nam_Loc = 0;
		}

		if (cbx_DV_LocThang.getSelectedIndex() != 0) {
			dv_Thang_Loc = Integer.parseInt(cbx_DV_LocThang.getSelectedItem().toString());
		} else {
			dv_Thang_Loc = 0;
		}

		if (cbx_DV_LocQuy.getSelectedIndex() != 0) {
			dv_Quy_Loc = Integer.parseInt(cbx_DV_LocQuy.getSelectedItem().toString());
		} else {
			dv_Quy_Loc = 0;
		}

		switch (dv_Quy_Loc) {
		case 4:
			if (dv_Thang_Loc < 10 && cbx_DV_LocThang.getSelectedIndex() != 0) {
				lbl_DV_ThongBao.setText("Quý " + dv_Quy_Loc + " không có tháng " + dv_Thang_Loc + "!");
			} else {
				lbl_DV_ThongBao.setText("");
			}
			break;
		case 3:
			if ((dv_Thang_Loc < 7 || dv_Thang_Loc > 10) && cbx_DV_LocThang.getSelectedIndex() != 0) {
				lbl_DV_ThongBao.setText("Quý " + dv_Quy_Loc + " không có tháng " + dv_Thang_Loc + "!");
			} else {
				lbl_DV_ThongBao.setText("");
			}
			break;
		case 2:
			if ((dv_Thang_Loc < 4 || dv_Thang_Loc > 6) && cbx_DV_LocThang.getSelectedIndex() != 0) {
				lbl_DV_ThongBao.setText("Quý " + dv_Quy_Loc + " không có tháng " + dv_Thang_Loc + "!");
			} else {
				lbl_DV_ThongBao.setText("");
			}
			break;
		case 1:
			if (dv_Thang_Loc > 3 && cbx_DV_LocThang.getSelectedIndex() != 0) {
				lbl_DV_ThongBao.setText("Quý " + dv_Quy_Loc + " không có tháng " + dv_Thang_Loc + "!");
			} else {
				lbl_HD_ThongBao.setText("");
			}
			break;

		default:
			break;
		}

		int dv_TongBan_Tu = 0;
		int dv_TongBan_Den = Integer.MAX_VALUE;
		if (cbx_DV_Loc_TongTien.getSelectedIndex() != 0) {
			if (cbx_DV_Loc_TongTien.getSelectedIndex() == 1) {
				dv_TongBan_Den = 500000 - 1;
			} else if (cbx_DV_Loc_TongTien.getSelectedIndex() == 2) {
				dv_TongBan_Tu = 500000;
				dv_TongBan_Den = 2000000;
			} else if (cbx_DV_Loc_TongTien.getSelectedIndex() == 3) {
				dv_TongBan_Tu = 2000000;
				dv_TongBan_Den = 5000000;
			} else if (cbx_DV_Loc_TongTien.getSelectedIndex() == 4) {
				dv_TongBan_Tu = 5000000;
				dv_TongBan_Den = 10000000;
			} else if (cbx_DV_Loc_TongTien.getSelectedIndex() == 5) {
				dv_TongBan_Tu = 10000000;
			}
		}

		dsDV = DAO_DV.loc_TongHop(dateFormat_YMD.format(ngayBatDau), dateFormat_YMD.format(ngayKetThuc), dv_Thang_Loc,
				dv_Nam_Loc, dv_Quy_Loc);

		for (DichVu dv : dsDV) {
			boolean kiemTra = true;
			if (dv_TongBan_Tu > thongTinDV.getSoLuongDaSuDung() * dv.getDonGia()
					|| dv_TongBan_Den < thongTinDV.getSoLuongDaSuDung() * dv.getDonGia())
				kiemTra = false;
			if (kiemTra) {
				thongTinDV = new ThongTinDichVu();
				thongTinDV = DAO_TTDV
						.timThongTinDichVu_TheoMaThongTinDichVu(dv.getThongTinDichVu().getMaThongTinDichVu());
				tongDoanhThu_DV = tongDoanhThu_DV + thongTinDV.getSoLuongDaSuDung() * dv.getDonGia();
				Object[] rowData_DV = { tongSoDV + 1, dv.getMaDichVu(), dv.getTenDichVu(), thongTinDV.getNgayNhap(),
						thongTinDV.getSoLuongDaSuDung(), dcf.format(thongTinDV.getSoLuongDaSuDung() * dv.getDonGia()) };
				model_DichVu.addRow(rowData_DV);
				tongSoDV++;
				txt_DV_TongSoLuong.setText(tongSoDV + "");
				txt_DV_TongDoanhThu.setText(dcf.format(tongDoanhThu_DV));
				ketQuaLoc = true;
			}
		}

		if (!ketQuaLoc) {
			model_DichVu.fireTableDataChanged();
			lbl_DV_ThongBao.setText("Không có kết quả phù hợp!");
			return;

		}
	}
}