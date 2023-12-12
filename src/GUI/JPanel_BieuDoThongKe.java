package GUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import DAO.ChiTietDichVu_DAO;
import DAO.ChiTietHoaDon_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import Entity.ChiTietDichVu;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import GUI.JPanel_BaoCaoThongKe.RoundedTransparentBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class JPanel_BieuDoThongKe extends JPanel implements ActionListener {

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	private DefaultCategoryDataset dataset;
	private DefaultPieDataset datasetPie;
	private DefaultCategoryDataset dataset_DT;
	private JButton btn_thongKeTopDV;
	private JButton btn_resetTopDV;
	private JDateChooser Jdate_ngayBatDau;
	private JDateChooser Jdate_ngayKetThuc;
	private JComboBox cbox_topDV;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final DecimalFormat dcf = new DecimalFormat("#,##0 VND");
	private JLabel lbl_tongHD;
	private JLabel lbl_tongHang;
	private ArrayList<HoaDon> dsHD;
	private ArrayList<ChiTietHoaDon> dsCTHD;
	private ArrayList<ChiTietDichVu> dsCTDV;
	private JLabel lbl_tongDoanhThu;
	private double tongDoanhThu_HD;
	
	private NhanVien nv_Role;

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

	public JPanel_BieuDoThongKe(NhanVien nhVien) {
		
		nv_Role = nhVien;
		
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
		panel.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));

		add(panel);
		panel.setLayout(null);

		// Mainlayout
		JPanel panel_main = new JPanel();
		panel_main.setBackground(new Color(255, 255, 255));
		panel_main.setBounds(10, 10, 1265, 642);
		panel.add(panel_main);
		panel_main.setLayout(null);

		// Panel Chart bar top dich vu
		JPanel panel_container = new JPanel();
		panel_container.setBackground(new Color(255, 255, 255));
		panel_container.setBounds(10, 10, 1245, 629);
		panel_main.add(panel_container);
		panel_container.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(9, 77, 373, 105);
		panel_container.add(panel_1);

		JPanel panel_locBar = new JPanel();
		panel_locBar.setLayout(null);
		panel_locBar.setBackground(Color.WHITE);
		panel_locBar.setBounds(807, 10, 428, 54);
		panel_container.add(panel_locBar);

		JLabel lblNewLabel = new JLabel("Ngày bắt đầu");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 0, 81, 16);
		panel_locBar.add(lblNewLabel);

		JLabel lblTopDchV = new JLabel("Top dịch vụ:");
		lblTopDchV.setForeground(SystemColor.textHighlight);
		lblTopDchV.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTopDchV.setBounds(232, 0, 81, 16);
		panel_locBar.add(lblTopDchV);

		cbox_topDV = new JComboBox();
		cbox_topDV.setForeground(SystemColor.textHighlight);
		cbox_topDV.setBounds(232, 26, 81, 20);

		cbox_topDV.addItem("Top 1");
		cbox_topDV.addItem("Top 2");
		cbox_topDV.addItem("Top 3");
		cbox_topDV.addItem("Top 4");
		cbox_topDV.addItem("Top 5");
		cbox_topDV.addItem("Top 6");
		cbox_topDV.addItem("Top 7");
		cbox_topDV.addItem("Top 8");
		cbox_topDV.addItem("Top 9");
		cbox_topDV.addItem("Top 10");

		panel_locBar.add(cbox_topDV);

		btn_thongKeTopDV = new JButton("Thống kê");
		btn_thongKeTopDV.setForeground(Color.WHITE);
		btn_thongKeTopDV.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_thongKeTopDV.setBackground(new Color(75, 172, 77));
		btn_thongKeTopDV.setBounds(323, 0, 90, 25);
		panel_locBar.add(btn_thongKeTopDV);

		btn_resetTopDV = new JButton("Làm mới");
		btn_resetTopDV.setForeground(Color.WHITE);
		btn_resetTopDV.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_resetTopDV.setBackground(new Color(5, 74, 145));
		btn_resetTopDV.setBounds(323, 25, 90, 25);
		panel_locBar.add(btn_resetTopDV);

		// Date

		Jdate_ngayBatDau = new JDateChooser();
		Jdate_ngayBatDau.setBounds(91, 0, 124, 19);
		Jdate_ngayBatDau.setDateFormatString("yyyy-MM-dd");
		panel_locBar.add(Jdate_ngayBatDau);

		JLabel lblNgyKtThc = new JLabel("Ngày kết thúc");

		lblNgyKtThc.setForeground(SystemColor.textHighlight);
		lblNgyKtThc.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNgyKtThc.setBounds(0, 29, 81, 16);
		panel_locBar.add(lblNgyKtThc);

		Jdate_ngayKetThuc = new JDateChooser();
		Jdate_ngayKetThuc.setDateFormatString("yyyy-MM-dd");
		Jdate_ngayKetThuc.setBounds(91, 29, 124, 19);
		panel_locBar.add(Jdate_ngayKetThuc);

		// Date end
		cbox_topDV.setSelectedIndex(4);
		renderDefaultDate();

		// ------ Xu ly DAO ---------------------------------------------------
		JLabel lblNewLabel_1 = new JLabel("Số lượng hóa đơn thanh toán");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(26, 17, 241, 23);
		panel_1.add(lblNewLabel_1);

		lbl_tongHD = new JLabel("");
		lbl_tongHD.setForeground(new Color(255, 255, 255));
		lbl_tongHD.setFont(new Font("Tahoma", Font.BOLD, 27));
		lbl_tongHD.setBounds(26, 50, 176, 45);
		panel_1.add(lbl_tongHD);

		ImageIcon imgHoaDon = new ImageIcon(JFrame_DangNhap.class.getResource("/icon/hoaDon.png"));

		Image scaled_imgHoaDon = imgHoaDon.getImage().getScaledInstance(72, 66, Image.SCALE_SMOOTH);
		imgHoaDon = new ImageIcon(scaled_imgHoaDon);

		JLabel lbl_icon = new JLabel("");

		lbl_icon.setBounds(277, 17, 72, 66);
		lbl_icon.setIcon(imgHoaDon);
		panel_1.add(lbl_icon);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(106, 90, 205));
		panel_1_1.setBounds(422, 77, 383, 105);
		panel_container.add(panel_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng doanh thu");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(26, 17, 147, 23);
		panel_1_1.add(lblNewLabel_1_1);

		lbl_tongDoanhThu = new JLabel("3000");
		lbl_tongDoanhThu.setForeground(new Color(255, 255, 255));
		lbl_tongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbl_tongDoanhThu.setBounds(26, 50, 266, 45);
		panel_1_1.add(lbl_tongDoanhThu);

		ImageIcon imgDoanhThu = new ImageIcon(JFrame_DangNhap.class.getResource("/icon/doanhThu.png"));

		Image scaled_imgDoanhThu = imgDoanhThu.getImage().getScaledInstance(72, 66, Image.SCALE_SMOOTH);
		imgDoanhThu = new ImageIcon(scaled_imgDoanhThu);
		JLabel lbl_icon2 = new JLabel("");

		lbl_icon2.setBounds(270, 17, 72, 66);
		lbl_icon2.setIcon(imgDoanhThu);
		panel_1_1.add(lbl_icon2);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(34, 139, 34));
		panel_1_2.setBounds(839, 77, 396, 105);
		panel_container.add(panel_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("Số lượng hàng bán được");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(26, 17, 192, 23);
		panel_1_2.add(lblNewLabel_1_2);

		lbl_tongHang = new JLabel("3000");
		lbl_tongHang.setForeground(new Color(255, 255, 255));
		lbl_tongHang.setFont(new Font("Tahoma", Font.BOLD, 27));
		lbl_tongHang.setBackground(new Color(255, 140, 0));
		lbl_tongHang.setBounds(26, 50, 192, 45);
		panel_1_2.add(lbl_tongHang);

		ImageIcon imgSanPham = new ImageIcon(JFrame_DangNhap.class.getResource("/icon/sanPham.png"));

		Image scaled_imgSanPham = imgSanPham.getImage().getScaledInstance(72, 66, Image.SCALE_SMOOTH);
		imgSanPham = new ImageIcon(scaled_imgSanPham);
		JLabel lbl_icon3 = new JLabel("");
		lbl_icon3.setBounds(301, 17, 72, 66);

		lbl_icon3.setIcon(imgSanPham);
		panel_1_2.add(lbl_icon3);

		JLabel lblNewLabel_3 = new JLabel("Trực quan hóa thống kê Karaoke SingUrSong");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblNewLabel_3.setBounds(9, 10, 456, 37);
		panel_container.add(lblNewLabel_3);

		// ---------Chart--------------------------
		dataset = new DefaultCategoryDataset();

		JFreeChart chartBar_thongKeTopDV = ChartFactory.createBarChart("Danh sách Top mặt hàng bán chạy nhất",
				"Tên mặt hàng", "Số lượng", dataset, PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot plot = chartBar_thongKeTopDV.getCategoryPlot();
		plot.setRangeGridlinePaint(Color.BLACK);

		// render cot chart
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setMaximumBarWidth(.10);
		renderer.setSeriesPaint(0, Color.decode(hexColor_Green));

		// Gap: khoang cach cac cot
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryMargin(0.2);

		// Set font and color
		Font labelFont = new Font("Segoe UI", Font.PLAIN, 10);

		plot.getDomainAxis().setLabelFont(labelFont);
		plot.getRangeAxis().setLabelFont(labelFont);

		// Trục x
		plot.getDomainAxis().setTickLabelFont(labelFont);

		// nhãn trục x
		plot.getRangeAxis().setTickLabelFont(new Font("Segoe UI", Font.PLAIN, 10));

		chartBar_thongKeTopDV.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 14));
		chartBar_thongKeTopDV.setBackgroundPaint(Color.WHITE);

		ChartPanel chartPanel = new ChartPanel(chartBar_thongKeTopDV);
		chartPanel.setBounds(0, 222, 395, 385);
		chartPanel.setPreferredSize(new Dimension(500, 300));
		chartPanel.setMinimumDrawWidth(100);
		chartPanel.setForeground(SystemColor.textHighlight);
		chartPanel.setBackground(Color.WHITE);
		panel_container.add(chartPanel);

		// END chart bar top dich vu

		// Panel Chart bar top dich vu

		dataset_DT = new DefaultCategoryDataset();

		JFreeChart chartBar_thongKeTopDT = ChartFactory.createBarChart(
				"Danh sách Top các mặt hàng đem lại doanh thu cao nhất", "Tên mặt hàng", "VNĐ", dataset_DT,
				PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot plot2 = chartBar_thongKeTopDT.getCategoryPlot();
		plot2.setRangeGridlinePaint(Color.BLACK);

		// render cot chart
		BarRenderer renderer2 = (BarRenderer) plot2.getRenderer();
		renderer2.setMaximumBarWidth(.10);
		renderer2.setSeriesPaint(0, Color.decode(hexColor_Red));

		// Gap: khoang cach cac cot
		CategoryAxis domainAxis2 = plot.getDomainAxis();
		domainAxis2.setCategoryMargin(0.2);

		// Set font and color
		Font labelFont2 = new Font("Segoe UI", Font.PLAIN, 10);

		plot2.getDomainAxis().setLabelFont(labelFont2);
		plot2.getRangeAxis().setLabelFont(labelFont2);

		// Trục x
		plot2.getDomainAxis().setTickLabelFont(labelFont2);

		// nhãn trục x
		plot2.getRangeAxis().setTickLabelFont(new Font("Segoe UI", Font.PLAIN, 10));

		chartBar_thongKeTopDT.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 12));
		chartBar_thongKeTopDT.setBackgroundPaint(Color.WHITE);

		ChartPanel chartPanelDV_DT = new ChartPanel(chartBar_thongKeTopDT);
		chartPanelDV_DT.setBounds(405, 222, 400, 385);
		chartPanelDV_DT.setPreferredSize(new Dimension(500, 300));
		chartPanelDV_DT.setMinimumDrawWidth(100);
		chartPanelDV_DT.setForeground(SystemColor.textHighlight);
		chartPanelDV_DT.setBackground(Color.WHITE);
		panel_container.add(chartPanelDV_DT);
		chartPanelDV_DT.setLayout(null);

		// END chart bar top dich vu

		/// Chart Pie
		datasetPie = new DefaultPieDataset();

		JFreeChart chartPieThongKeDV = ChartFactory
				.createPieChart("Biểu đồ tròn biểu diễn khách đặt phòng tại SingUrSong", datasetPie, true, true, false);

		// Edit chu thich
		chartPieThongKeDV.getLegend().setBackgroundPaint(Color.WHITE);
		chartPieThongKeDV.getLegend().setItemFont(labelFont);
		PiePlot pieplot = (PiePlot) chartPieThongKeDV.getPlot();

		pieplot.setSectionPaint(1, Color.decode(hexColor_Blue2));
		pieplot.setSectionPaint(2, Color.decode(hexColor_Orange));

		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));
		pieplot.setLabelBackgroundPaint(Color.GRAY);

		pieplot.setOutlinePaint(Color.WHITE);
		pieplot.setLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
		pieplot.setLabelPaint(Color.WHITE);

		chartPieThongKeDV.getTitle().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chartPieThongKeDV.setBackgroundPaint(Color.WHITE);

		ChartPanel chartPanelPie = new ChartPanel(chartPieThongKeDV);
		chartPanelPie.setBounds(840, 222, 395, 385);
		panel_container.add(chartPanelPie);
		chartPanelPie.setPreferredSize(new Dimension(300, 300));
		chartPanelPie.setMinimumDrawWidth(100);
		chartPanelPie.setForeground(SystemColor.textHighlight);
		chartPanelPie.setBackground(Color.WHITE);
		panel_container.add(chartPanelPie);

		renderChartBarDV();
		renderChartPieDV();
		renderChartBarDV_DT();
		renderTongHD_SoLuongHang_DoanhThu();

		btn_resetTopDV.addActionListener(this);
		btn_thongKeTopDV.addActionListener(this);
		
		if(!nv_Role.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			Jdate_ngayBatDau.setEnabled(false);
			Jdate_ngayKetThuc.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_resetTopDV)) {
			clearForm();
			renderChartBarDV();
			renderChartPieDV();
			renderChartBarDV_DT();
			renderTongHD_SoLuongHang_DoanhThu();

		}
		if (o.equals(btn_thongKeTopDV)) {
			Date ngayBD = Jdate_ngayBatDau.getDate();
			Date ngayKT = Jdate_ngayKetThuc.getDate();
			String top = cbox_topDV.getSelectedItem().toString().trim();
			dataset.clear();
			dataset_DT.clear();
			renderChartBarDV();
			renderChartPieDV();
			renderChartBarDV_DT();
			renderTongHD_SoLuongHang_DoanhThu();
		}

	}

	public void clearForm() {
		cbox_topDV.setSelectedIndex(4);
		renderDefaultDate();
		dataset.clear();
		dataset_DT.clear();

	}

	public void renderTongHD_SoLuongHang_DoanhThu() {
		String ngayBD = "";
		String ngayKT = "";
		
		if(!nv_Role.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			LocalDate currentDate = LocalDate.now();
			LocalDate tomorrowDate = currentDate.plusDays(1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			ngayBD = currentDate.format(formatter);
	        ngayKT = tomorrowDate.format(formatter);
		} else {
			ngayBD = dateFormat.format(Jdate_ngayBatDau.getDate());
			ngayKT = dateFormat.format(Jdate_ngayKetThuc.getDate());
		}
		try {
			HoaDon_DAO DAO_HD = new HoaDon_DAO();
			lbl_tongHD.setText(String.valueOf(DAO_HD.tinhTongHoaDonTT_theoKhoangTime(ngayBD, ngayKT)));
			lbl_tongHang.setText(String.valueOf(DAO_HD.tinhTongMatHangTT_theoKhoangTime(ngayBD, ngayKT)));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		try {
			tongDoanhThu_HD =0;
			HoaDon_DAO DAO_HD = new HoaDon_DAO();
			ChiTietDichVu_DAO DAO_CTDV = new ChiTietDichVu_DAO();
			KhachHang_DAO DAO_KH = new KhachHang_DAO();
			NhanVien_DAO DAO_NV = new NhanVien_DAO();
			ChiTietHoaDon_DAO DAO_CTHD = new ChiTietHoaDon_DAO();
			dsHD = DAO_HD.layDSHoaDon_daThanhToan_theoKhoangTime(ngayBD, ngayKT);
		
			if (dsHD != null) {
				dsHD.forEach(hd -> {
					dsCTHD = DAO_CTHD.timCTHoaDon_TheoMaHoaDon(hd.getMaHoaDon());
					dsCTDV = DAO_CTDV.layDanhSachChiTietDichVu_TheoMaHoaDon(hd.getMaHoaDon());
					KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
					NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
					double tongTien = hd.tinhTongTien(dsCTHD, dsCTDV);
					tongDoanhThu_HD = tongDoanhThu_HD + tongTien;
					

				});
			}
			lbl_tongDoanhThu.setText(dcf.format(tongDoanhThu_HD));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void renderDefaultDate() {
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		Date sevenDaysAgo = calendar.getTime();

		
		if(!nv_Role.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			Jdate_ngayBatDau.setDate(currentDate);
			Jdate_ngayKetThuc.setDate(currentDate);
		} else {
			Jdate_ngayBatDau.setDate(sevenDaysAgo);
			Jdate_ngayKetThuc.setDate(currentDate);
		}
	};

	public void renderChartBarDV() {
				
		String ngayBD = "";
		String ngayKT = "";
		
		if(!nv_Role.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			LocalDate currentDate = LocalDate.now();
			LocalDate tomorrowDate = currentDate.plusDays(1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			ngayBD = currentDate.format(formatter);
	        ngayKT = tomorrowDate.format(formatter);
		} else {
			ngayBD = dateFormat.format(Jdate_ngayBatDau.getDate());
			ngayKT = dateFormat.format(Jdate_ngayKetThuc.getDate());
		}
		String top = cbox_topDV.getSelectedItem().toString().trim();
		try {
			HoaDon_DAO DAO_HD = new HoaDon_DAO();
			HashMap<String, String> hash_dv = DAO_HD.thongKe_dichVuNangCao("Thống kê theo Số lượng", top, ngayBD,
					ngayKT);
			for (String key : hash_dv.keySet()) {
				dataset.setValue(Double.parseDouble(hash_dv.get(key)), "Số lượng", key);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void renderChartBarDV_DT() {
		
		String ngayBD = "";
		String ngayKT = "";
		
		if(!nv_Role.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			LocalDate currentDate = LocalDate.now();
			LocalDate tomorrowDate = currentDate.plusDays(1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			ngayBD = currentDate.format(formatter);
	        ngayKT = tomorrowDate.format(formatter);
		} else {
			ngayBD = dateFormat.format(Jdate_ngayBatDau.getDate());
			ngayKT = dateFormat.format(Jdate_ngayKetThuc.getDate());
		}
		String top = cbox_topDV.getSelectedItem().toString().trim();
		try {
			HoaDon_DAO DAO_HD = new HoaDon_DAO();
			HashMap<String, String> hash_dv = DAO_HD.thongKe_dichVuNangCao("Thống kê theo Doanh thu", top, ngayBD,
					ngayKT);
			for (String key : hash_dv.keySet()) {
				dataset_DT.setValue(Double.parseDouble(hash_dv.get(key)), "Số lượng", key);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void renderChartPieDV() {
		
		String ngayBD = "";
		String ngayKT = "";
		
		if(!nv_Role.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			LocalDate currentDate = LocalDate.now();
			LocalDate tomorrowDate = currentDate.plusDays(1);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			ngayBD = currentDate.format(formatter);
	        ngayKT = tomorrowDate.format(formatter);
		} else {
			ngayBD = dateFormat.format(Jdate_ngayBatDau.getDate());
			ngayKT = dateFormat.format(Jdate_ngayKetThuc.getDate());
		}
		try {
			HoaDon_DAO DAO_HD = new HoaDon_DAO();
			HashMap<String, String> hash_dv = DAO_HD.thongKe_loaiPhongNangCao(ngayBD, ngayKT);
			for (String key : hash_dv.keySet()) {
				System.out.println("key: " + key + " value: " + hash_dv.get(key));
				datasetPie.setValue(key, Double.parseDouble(hash_dv.get(key)));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
