
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

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

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JDialog_ThongTinHoaDon extends JDialog {

	/**
	 * Color
	 */

	private NhanVien nhanVien;
	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaHD;
	private JTextField date_NgayLap;
	private JTextField txtTenKH;
	private JTextField txtSoDienThoai;
	private JTextField txtTongTienHD;
	private JTextField txtTongTienDV;
	private JTextField txtChietKhau;
	private JTextField txtNVLap;
	private PhieuDatPhong_DAO DAO_PDP;
	private KhachHang_DAO DAO_KH;
	private NhanVien_DAO DAO_NV;
	private Phong_DAO DAO_P;
	private LoaiPhong_DAO DAO_LP;
	private KhachHang kh;
	private NhanVien nv;
	private Phong p;
	private LoaiPhong lp;
	private PhieuDatPhong pdp;
	private int xacNhan;
	private JButton btnXuatPDF;
	private JButton btnThoat;
	private JTextField txtMaKH;
	private JPanel panel_button;
	private JTable table_DichVu;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThua;
	private HoaDon_DAO DAO_HD;
	private HoaDon hd;
	private KhuyenMai_DAO DAO_KM;
	private KhuyenMai km;
	private DefaultTableModel model;
	private ChiTietDichVu_DAO DAO_CTDV;
	private DichVu_DAO DAO_DV;
	private String ma;
	private ChiTietDichVu ctdv;
	private ChiTietHoaDon_DAO DAO_CTHD;
	private JTable table_PhongDat;
	private DefaultTableModel modelPhong;
	private DefaultTableModel modelDichVu;
	private JTextField txtTienCoc;
	private ChiTietHoaDon cthd;

	private final DecimalFormat dcf = new DecimalFormat("#,##0 VND");

	public JDialog_ThongTinHoaDon() {

		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JDialog_ThongTinHoaDon.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 550, 776);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.decode(hexColor_Blue1));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel_Info = new JPanel();
		panel_Info.setBounds(178, 0, 346, 111);
		panel_Info.setBackground(new Color(255, 255, 255));
		contentPanel.add(panel_Info);
		panel_Info.setLayout(null);

		JLabel lblDiaChi = new JLabel("12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, TP.HCM");
		lblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDiaChi.setVerticalAlignment(SwingConstants.TOP);
		lblDiaChi.setBounds(10, 52, 326, 29);
		panel_Info.add(lblDiaChi);

		JLabel lblLienHe = new JLabel("Tel : 077 6466 132");
		lblLienHe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblLienHe.setVerticalAlignment(SwingConstants.TOP);
		lblLienHe.setBounds(10, 81, 326, 21);
		panel_Info.add(lblLienHe);

		JLabel lblTenQuan = new JLabel("KARAOKE SING UR SONG");
		lblTenQuan.setForeground(Color.decode(hexColor_Red));
		lblTenQuan.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTenQuan.setBackground(SystemColor.menu);
		lblTenQuan.setBounds(10, 11, 326, 29);
		panel_Info.add(lblTenQuan);

		JPanel panel_Logo = new JPanel();
		panel_Logo.setBounds(10, 0, 168, 111);
		panel_Logo.setBackground(new Color(255, 255, 255));
		contentPanel.add(panel_Logo);
		panel_Logo.setLayout(null);

		JLabel logo_IMG = new JLabel("New label");
		logo_IMG.setIcon(new ImageIcon(JDialog_ThongTinHoaDon.class.getResource("/img/SingurSong_Logo_Header.png")));
		logo_IMG.setBounds(-19, 11, 231, 102);
		panel_Logo.add(logo_IMG);

		JPanel panel_Detail = new JPanel();
		panel_Detail.setBounds(10, 115, 514, 138);
		panel_Detail.setBackground(new Color(255, 255, 255));
		contentPanel.add(panel_Detail);
		panel_Detail.setLayout(null);

		JLabel lblMPhiu = new JLabel("Mã hóa đơn :");
		lblMPhiu.setBounds(10, 40, 97, 21);
		panel_Detail.add(lblMPhiu);
		lblMPhiu.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtMaHD = new JTextField();
		txtMaHD.setBorder(null);
		txtMaHD.setBounds(105, 40, 130, 20);
		panel_Detail.add(txtMaHD);
		txtMaHD.setColumns(10);

		JLabel lblPDP = new JLabel("HÓA ĐƠN");
		lblPDP.setHorizontalAlignment(SwingConstants.CENTER);
		lblPDP.setBounds(10, 0, 494, 29);
		panel_Detail.add(lblPDP);
		lblPDP.setForeground(Color.decode(hexColor_Blue1));
		lblPDP.setBackground(new Color(240, 240, 240));
		lblPDP.setFont(new Font("Segoe UI", Font.BOLD, 21));

		date_NgayLap = new JTextField();
		date_NgayLap.setBorder(null);
		date_NgayLap.setColumns(10);
		date_NgayLap.setBounds(105, 71, 130, 20);
		panel_Detail.add(date_NgayLap);

		JLabel lblMPhiu_1 = new JLabel("Ngày lập :");
		lblMPhiu_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMPhiu_1.setBounds(10, 71, 118, 21);
		panel_Detail.add(lblMPhiu_1);

		JLabel lblMPhiu_1_1 = new JLabel("Nhân viên lập");
		lblMPhiu_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMPhiu_1_1.setBounds(10, 103, 118, 21);
		panel_Detail.add(lblMPhiu_1_1);

		txtNVLap = new JTextField();
		txtNVLap.setBorder(null);
		txtNVLap.setColumns(10);
		txtNVLap.setBounds(105, 103, 130, 20);
		panel_Detail.add(txtNVLap);

		JLabel lblMKhch = new JLabel("Mã khách :");
		lblMKhch.setBounds(268, 40, 86, 22);
		panel_Detail.add(lblMKhch);
		lblMKhch.setForeground(new Color(0, 0, 0));
		lblMKhch.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtMaKH = new JTextField();
		txtMaKH.setBounds(356, 40, 148, 22);
		panel_Detail.add(txtMaKH);
		txtMaKH.setColumns(10);
		txtMaKH.setBorder(null);

		JLabel lblTnKhchHng = new JLabel("Tên khách :");
		lblTnKhchHng.setBounds(268, 70, 86, 22);
		panel_Detail.add(lblTnKhchHng);
		lblTnKhchHng.setForeground(new Color(0, 0, 0));
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtTenKH = new JTextField();
		txtTenKH.setBounds(356, 70, 148, 22);
		panel_Detail.add(txtTenKH);
		txtTenKH.setBorder(null);
		txtTenKH.setColumns(10);

		JLabel lblSinThoi = new JLabel("SDT :");
		lblSinThoi.setBounds(268, 100, 86, 22);
		panel_Detail.add(lblSinThoi);
		lblSinThoi.setForeground(new Color(0, 0, 0));
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(356, 100, 148, 22);
		panel_Detail.add(txtSoDienThoai);
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setColumns(10);

		JLabel lblMPhiu_1_1_1 = new JLabel("Tổng tiền mặt hàng :");
		lblMPhiu_1_1_1.setForeground(Color.decode(hexColor_Blue1));
		lblMPhiu_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMPhiu_1_1_1.setBounds(265, 604, 145, 22);
		contentPanel.add(lblMPhiu_1_1_1);

		txtTongTienDV = new JTextField();
		txtTongTienDV.setBorder(null);
		txtTongTienDV.setColumns(10);
		txtTongTienDV.setBounds(389, 604, 135, 22);
		contentPanel.add(txtTongTienDV);

		JLabel lblNhnVinLp_1 = new JLabel("Chiếu khấu :");
		lblNhnVinLp_1.setForeground(Color.decode(hexColor_Blue1));
		lblNhnVinLp_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhnVinLp_1.setBounds(265, 631, 101, 22);
		contentPanel.add(lblNhnVinLp_1);

		txtChietKhau = new JTextField();
		txtChietKhau.setBorder(null);
		txtChietKhau.setColumns(10);
		txtChietKhau.setBounds(389, 631, 135, 22);
		contentPanel.add(txtChietKhau);

		JLabel lblTinCc = new JLabel("Tổng hóa đơn :");
		lblTinCc.setBounds(265, 658, 114, 22);
		contentPanel.add(lblTinCc);
		lblTinCc.setForeground(Color.decode(hexColor_Blue1));
		lblTinCc.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtTongTienHD = new JTextField();
		txtTongTienHD.setBorder(null);
		txtTongTienHD.setBounds(389, 658, 135, 22);
		contentPanel.add(txtTongTienHD);
		txtTongTienHD.setColumns(10);
		{

			panel_button = new JPanel();
			panel_button.setBackground(Color.decode(hexColor_Blue4));
			panel_button.setBounds(0, 690, 534, 56);
			contentPanel.add(panel_button);
			panel_button.setLayout(null);
			{
				btnXuatPDF = new JButton("Xuất PDF");
				btnXuatPDF.setBounds(275, 10, 120, 35);
				panel_button.add(btnXuatPDF);
				btnXuatPDF.setIcon(new ImageIcon(JDialog_ThongTinHoaDon.class.getResource("/icon/pdf.png")));
				btnXuatPDF.setForeground(new Color(255, 255, 255));
				btnXuatPDF.setBackground(Color.decode(hexColor_Green));
				btnXuatPDF.setFont(new Font("Segoe UI", Font.BOLD, 13));
				btnXuatPDF
						.setSelectedIcon(new ImageIcon(JDialog_ThongTinHoaDon.class.getResource("/icon/printer.png")));
				btnXuatPDF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						xacNhan = JOptionPane.showConfirmDialog(null, "Bạn có muốn xem file", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						xuatFile();
						setVisible(false);
						return;
					}
				});
				getRootPane().setDefaultButton(btnXuatPDF);
			}
			btnThoat = new JButton("Thoát");
			btnThoat.setBounds(405, 10, 120, 35);
			panel_button.add(btnThoat);
			btnThoat.setIcon(new ImageIcon(JDialog_ThongTinHoaDon.class.getResource("/icon/reject.png")));
			btnThoat.setForeground(new Color(255, 255, 255));
			btnThoat.setBackground(Color.decode(hexColor_Red));
			btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setBounds(10, 417, 514, 177);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(0, 0, 514, 175);
			panel_2.add(scrollPane_1);

			table_DichVu = new JTable();
			table_DichVu.setModel(modelDichVu = new DefaultTableModel(new Object[][] {},
					new String[] { "STT", "Mặt hàng", "Đơn giá", "Số lượng", "Thành tiền" }));
			scrollPane_1.setViewportView(table_DichVu);
		}

		JLabel lblMPhiu_1_1_1_1 = new JLabel("Tiền khách đưa  :");
		lblMPhiu_1_1_1_1.setForeground(new Color(5, 74, 145));
		lblMPhiu_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMPhiu_1_1_1_1.setBounds(25, 631, 130, 22);
		contentPanel.add(lblMPhiu_1_1_1_1);

		JLabel lblNhnVinLp_1_1 = new JLabel("Tiền thừa : ");
		lblNhnVinLp_1_1.setForeground(new Color(5, 74, 145));
		lblNhnVinLp_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhnVinLp_1_1.setBounds(25, 658, 101, 22);
		contentPanel.add(lblNhnVinLp_1_1);

		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBorder(null);
		txtTienKhachDua.setBounds(149, 631, 145, 22);
		contentPanel.add(txtTienKhachDua);

		txtTienThua = new JTextField();
		txtTienThua.setColumns(10);
		txtTienThua.setBorder(null);
		txtTienThua.setBounds(149, 658, 145, 22);
		contentPanel.add(txtTienThua);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 264, 514, 142);
		contentPanel.add(scrollPane);

		table_PhongDat = new JTable();
		table_PhongDat.setModel(modelPhong = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Loại phòng", "Tên phòng", "Số giờ hát", "Giá phòng", "Thành tiền" }));
		scrollPane.setViewportView(table_PhongDat);

		JLabel lblMPhiu_1_1_1_1_1 = new JLabel("Tiền cọc (Nếu có) :");
		lblMPhiu_1_1_1_1_1.setForeground(new Color(5, 74, 145));
		lblMPhiu_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMPhiu_1_1_1_1_1.setBounds(25, 604, 130, 22);
		contentPanel.add(lblMPhiu_1_1_1_1_1);

		txtTienCoc = new JTextField();
		txtTienCoc.setColumns(10);
		txtTienCoc.setBorder(null);
		txtTienCoc.setBounds(149, 604, 145, 22);
		contentPanel.add(txtTienCoc);
	}

	public void HienThongTinTheoMaHD(String ma) {
		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_KH = new KhachHang_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_P = new Phong_DAO();
		DAO_LP = new LoaiPhong_DAO();
		DAO_HD = new HoaDon_DAO();
		DAO_KM = new KhuyenMai_DAO();
		DAO_CTDV = new ChiTietDichVu_DAO();
		DAO_CTHD = new ChiTietHoaDon_DAO();

		kh = new KhachHang();
		nv = new NhanVien();
		p = new Phong();
		lp = new LoaiPhong();
		hd = new HoaDon();
		km = new KhuyenMai();
		pdp = new PhieuDatPhong();
		ctdv = new ChiTietDichVu();
		cthd = new ChiTietHoaDon();

		hd = DAO_HD.layHoaDon_TheoMaHoaDon(ma);
		kh = DAO_KH.layKhachHang_TheoMaKhachHang(hd.getKhachHang().getMaKhachHang());
		nv = DAO_NV.timNhanVien_TheoMaNhanVien(hd.getNhanVien().getMaNhanVien());
		pdp = DAO_PDP.layPhieuDatPhong_TheoMaPhieuDat(hd.getPhieuDatPhong().getMaPhieuDat());

		km = DAO_KM.layKhuyenMai_TheoMaKhuyenMai(hd.getKhuyenMai().getMaKhuyenMai());

		txtMaHD.setText(hd.getMaHoaDon());
		date_NgayLap.setText(hd.getNgayLap().toString());
		txtNVLap.setText(nv.getHoTen());

		// Lấy thông tin phòng và loại phòng
		int sttCTHD = 1;
		ArrayList<ChiTietHoaDon> dsCTHD = DAO_CTHD.timCTHoaDon_TheoMaHoaDon(ma);
		System.out.println(dsCTHD);
		if (dsCTHD != null) {
			for (ChiTietHoaDon cthd : dsCTHD) {
				Phong p = DAO_P.timPhong_TheoMaPhong(cthd.getPhong().getMaPhong());
				LoaiPhong lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
				HoaDon hd = DAO_HD.layHoaDon_TheoMaHoaDon(ma);
				System.out.println(hd);
				Object[] rowData = { sttCTHD++, lp.getTenLoaiPhong(), p.getTenPhong(), hd.tinhGioHat(),
						dcf.format(lp.getGiaTien()), dcf.format(cthd.thanhTien(hd.tinhGioHat())) };
				modelPhong.addRow(rowData);
			}
		}

//		txtTienCoc.setText(Double.toString(cthd.tinhTongTienPhong()));

		// Lấy thông tin khách hàng:
		txtMaKH.setText(kh.getMaKhachHang());
		txtTenKH.setText(kh.getHoTen());
		txtSoDienThoai.setText(kh.getSoDienThoai());

		// Lấy thông tin dịch vụ
		int sttCTDV = 1;
		ArrayList<ChiTietDichVu> dsCTDV = DAO_CTDV.layDanhSachChiTietDichVu_TheoMaHoaDon(ma);
		if (dsCTDV != null) {
			for (ChiTietDichVu ctdv : dsCTDV) {
				Object[] rowData = { sttCTDV++, ctdv.getDichVu().getTenDichVu(),
						dcf.format(ctdv.getDichVu().getDonGia()), ctdv.getSoLuong(), dcf.format(ctdv.thanhTien()) };
				modelDichVu.addRow(rowData);

			}
		}

		txtTienCoc.setText(dcf.format(hd.tinhTienPhong(dsCTHD)));
		txtTongTienDV.setText(dcf.format(hd.tinhTienDichVu(dsCTDV)));
		txtTongTienHD.setText(dcf.format(hd.tinhTongTien(dsCTHD, dsCTDV)));

	}

	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table_DichVu.getModel();
		model.setRowCount(0);
	}

	/**
	 * Xuất file PDF phiếu đặt phòng
	 * 
	 **/

	public void xuatFile() {
		btnXuatPDF.setVisible(false);
		btnThoat.setVisible(false);
		panel_button.setVisible(false);
		String path = "xuatPDF\\" + "pdp.pdf";
//		if (!path.matches("(.)+(\\.pdf)$")) {
//			path += ".pdf";
//		}
		Container content = this.getContentPane();
		int height = content.getHeight();
		int width = content.getHeight();
		BufferedImage img = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		content.printAll(g2d);
		g2d.dispose();
		try {
			Document d = new Document();
			PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(path));
			d.open();

			PdfContentByte contentByte = writer.getDirectContent();
			Image image = Image.getInstance(contentByte, scaleImage(595, height, img), 1);

			PdfTemplate template = contentByte.createTemplate(width, height);
			image.setAbsolutePosition(0, 0);
			template.addImage(image);
			contentByte.addTemplate(template, 0, 100);
			d.close();

			if (xacNhan == JOptionPane.YES_OPTION)
				Desktop.getDesktop().open(new File(path));
			else {
				JOptionPane.showMessageDialog(this, "Xuất phiếu đặt phòng thành công");
			}
		} catch (IOException | DocumentException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Không thành công");
		}
		btnXuatPDF.setVisible(true);
		btnThoat.setVisible(true);
		panel_button.setVisible(true);
		setVisible(false);
		dispose();
	}

	public BufferedImage scaleImage(int WIDTH, int HEIGHT, BufferedImage img) {
		BufferedImage bi = null;
		try {
			ImageIcon ii = new ImageIcon(img);
			bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = (Graphics2D) bi.createGraphics();
			g2d.addRenderingHints(
					new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
			g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bi;
	}
}
