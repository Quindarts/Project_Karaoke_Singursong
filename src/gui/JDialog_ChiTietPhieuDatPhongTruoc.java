package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import dao.KhachHang_DAO;
import dao.LoaiPhong_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;

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
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class JDialog_ChiTietPhieuDatPhongTruoc extends JDialog {

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
	private JTextField txtMaPDP;
	private JTextField date_DatPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtTenPhong;
	private JTextField txtGiaPhong;
	private JTextField txtTenKH;
	private JTextField txtSoDienThoai;
	private JTextField txtTienCoc;
	private JTextField date_NhanPhong;
	private JTextField txtNhanVien;
	private JTextField txtTinhTrangPhieu;
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
	private JTextArea txtMoTa;
	private int xacNhan;
	private JButton btnXuatPDF;
	private JButton btnThoat;
	private JTextField txtMaKH;
	private JPanel panel_button;
	private JButton btnNhanPhong;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			JDialog_ChiTietPhieuDatPhongTruoc dialog = new JDialog_ChiTietPhieuDatPhongTruoc();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			FlatLightLaf.setup();
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public JDialog_ChiTietPhieuDatPhongTruoc() {
		setBounds(100, 100, 550, 690);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.decode(hexColor_Blue1));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

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
		lblTenQuan.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblTenQuan.setBackground(SystemColor.menu);
		lblTenQuan.setBounds(10, 11, 326, 29);
		panel_Info.add(lblTenQuan);

		JPanel panel_Logo = new JPanel();
		panel_Logo.setBounds(10, 0, 168, 111);
		panel_Logo.setBackground(new Color(255, 255, 255));
		contentPanel.add(panel_Logo);
		panel_Logo.setLayout(null);

		JLabel logo_IMG = new JLabel("New label");
		logo_IMG.setIcon(
				new ImageIcon(JDialog_ChiTietPhieuDatPhongTruoc.class.getResource("/img/SingurSong_Logo_Header.png")));
		logo_IMG.setBounds(-19, 11, 231, 102);
		panel_Logo.add(logo_IMG);

		JPanel panel_Detail = new JPanel();
		panel_Detail.setBounds(10, 115, 514, 138);
		panel_Detail.setBackground(new Color(255, 255, 255));
		contentPanel.add(panel_Detail);
		panel_Detail.setLayout(null);

		JLabel lblMPhiu = new JLabel("Mã phiếu :");
		lblMPhiu.setBounds(127, 43, 74, 21);
		panel_Detail.add(lblMPhiu);
		lblMPhiu.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));

		txtMaPDP = new JTextField();
		txtMaPDP.setBorder(null);
		txtMaPDP.setBounds(270, 44, 130, 20);
		panel_Detail.add(txtMaPDP);
		txtMaPDP.setColumns(10);

		JLabel lblPDP = new JLabel("PHIẾU ĐẶT PHÒNG");
		lblPDP.setHorizontalAlignment(SwingConstants.CENTER);
		lblPDP.setBounds(10, 0, 494, 29);
		panel_Detail.add(lblPDP);
		lblPDP.setForeground(Color.decode(hexColor_Blue1));
		lblPDP.setBackground(new Color(240, 240, 240));
		lblPDP.setFont(new Font("Segoe UI", Font.BOLD, 21));

		date_DatPhong = new JTextField();
		date_DatPhong.setBorder(null);
		date_DatPhong.setColumns(10);
		date_DatPhong.setBounds(270, 75, 130, 20);
		panel_Detail.add(date_DatPhong);

		JLabel lblMPhiu_1 = new JLabel("Ngày đặt phòng :");
		lblMPhiu_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblMPhiu_1.setBounds(127, 74, 118, 21);
		panel_Detail.add(lblMPhiu_1);

		JLabel lblMPhiu_1_1 = new JLabel("Tình trạng phiếu :");
		lblMPhiu_1_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblMPhiu_1_1.setBounds(127, 106, 118, 21);
		panel_Detail.add(lblMPhiu_1_1);

		txtTinhTrangPhieu = new JTextField();
		txtTinhTrangPhieu.setBorder(null);
		txtTinhTrangPhieu.setColumns(10);
		txtTinhTrangPhieu.setBounds(270, 107, 130, 20);
		panel_Detail.add(txtTinhTrangPhieu);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 264, 256, 104);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblLoiPhng = new JLabel("Loại phòng :");
		lblLoiPhng.setForeground(Color.decode(hexColor_Blue1));
		lblLoiPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoiPhng.setBounds(10, 10, 86, 22);
		panel.add(lblLoiPhng);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(98, 10, 148, 22);
		panel.add(txtLoaiPhong);

		txtTenPhong = new JTextField();
		txtTenPhong.setBorder(null);
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(98, 40, 148, 22);
		panel.add(txtTenPhong);

		JLabel lblTnPhng = new JLabel("Tên phòng :");
		lblTnPhng.setForeground(Color.decode(hexColor_Blue1));
		lblTnPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTnPhng.setBounds(10, 40, 86, 22);
		panel.add(lblTnPhng);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setBorder(null);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(98, 70, 148, 22);
		panel.add(txtGiaPhong);

		JLabel lblGiPhng = new JLabel("Giá phòng :");
		lblGiPhng.setForeground(Color.decode(hexColor_Blue1));
		lblGiPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblGiPhng.setBounds(10, 70, 86, 22);
		panel.add(lblGiPhng);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(268, 264, 256, 104);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTnKhchHng = new JLabel("Tên khách :");
		lblTnKhchHng.setForeground(Color.decode(hexColor_Blue1));
		lblTnKhchHng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTnKhchHng.setBounds(10, 40, 86, 22);
		panel_1.add(lblTnKhchHng);

		JLabel lblSinThoi = new JLabel("SDT :");
		lblSinThoi.setForeground(Color.decode(hexColor_Blue1));
		lblSinThoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSinThoi.setBounds(10, 70, 86, 22);
		panel_1.add(lblSinThoi);

		txtTenKH = new JTextField();
		txtTenKH.setBorder(null);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(98, 40, 148, 22);
		panel_1.add(txtTenKH);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(98, 70, 148, 22);
		panel_1.add(txtSoDienThoai);
		
		JLabel lblMKhch = new JLabel("Mã khách :");
		lblMKhch.setForeground(new Color(5, 74, 145));
		lblMKhch.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMKhch.setBounds(10, 10, 86, 22);
		panel_1.add(lblMKhch);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBorder(null);
		txtMaKH.setBounds(98, 10, 148, 22);
		panel_1.add(txtMaKH);

		JLabel lblMT = new JLabel("Mô tả :");
		lblMT.setForeground(Color.decode(hexColor_Blue1));
		lblMT.setBounds(20, 379, 86, 20);
		lblMT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPanel.add(lblMT);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 400, 514, 75);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(10, 11, 494, 57);
		panel_2.add(txtMoTa);

		JLabel lblMPhiu_1_1_1 = new JLabel("Ngày nhận phòng :");
		lblMPhiu_1_1_1.setForeground(Color.decode(hexColor_Blue1));
		lblMPhiu_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMPhiu_1_1_1.setBounds(255, 499, 130, 22);
		contentPanel.add(lblMPhiu_1_1_1);

		date_NhanPhong = new JTextField();
		date_NhanPhong.setBorder(null);
		date_NhanPhong.setColumns(10);
		date_NhanPhong.setBounds(379, 499, 145, 22);
		contentPanel.add(date_NhanPhong);

		JLabel lblNhnVinLp_1 = new JLabel("Nhân viên lập : ");
		lblNhnVinLp_1.setForeground(Color.decode(hexColor_Blue1));
		lblNhnVinLp_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNhnVinLp_1.setBounds(255, 526, 101, 22);
		contentPanel.add(lblNhnVinLp_1);

		txtNhanVien = new JTextField();
		txtNhanVien.setBorder(null);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(379, 526, 145, 22);
		contentPanel.add(txtNhanVien);

		JLabel lblTinCc = new JLabel("Tiền cọc :");
		lblTinCc.setBounds(255, 553, 86, 22);
		contentPanel.add(lblTinCc);
		lblTinCc.setForeground(Color.decode(hexColor_Blue1));
		lblTinCc.setFont(new Font("Segoe UI", Font.BOLD, 13));

		txtTienCoc = new JTextField();
		txtTienCoc.setBorder(null);
		txtTienCoc.setBounds(379, 553, 145, 22);
		contentPanel.add(txtTienCoc);
		txtTienCoc.setColumns(10);
		{
			btnThoat = new JButton("Thoát");
			btnThoat.setIcon(new ImageIcon(JDialog_ChiTietPhieuDatPhongTruoc.class.getResource("/icon/reject.png")));
			btnThoat.setForeground(new Color(255, 255, 255));
			btnThoat.setBackground(Color.decode(hexColor_Red));
			btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
			btnThoat.setBounds(404, 605, 120, 35);
			contentPanel.add(btnThoat);
			
			panel_button = new JPanel();
			panel_button.setBackground(Color.decode(hexColor_Blue4));
			panel_button.setBounds(0, 595, 534, 56);
			contentPanel.add(panel_button);
			panel_button.setLayout(null);
			
			btnNhanPhong = new JButton("Nhận phòng");
			btnNhanPhong.setSelectedIcon(new ImageIcon(JDialog_ChiTietPhieuDatPhongTruoc.class.getResource("/icon/login.png")));
			btnNhanPhong.setForeground(Color.WHITE);
			btnNhanPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
			btnNhanPhong.setBackground(Color.decode(hexColor_Orange));
			btnNhanPhong.setBounds(10, 10, 120, 35);
			panel_button.add(btnNhanPhong);
			{
				btnXuatPDF = new JButton("Xuất PDF");
				btnXuatPDF.setBounds(275, 10, 120, 35);
				panel_button.add(btnXuatPDF);
				btnXuatPDF.setIcon(new ImageIcon(JDialog_ChiTietPhieuDatPhongTruoc.class.getResource("/icon/pdf.png")));
				btnXuatPDF.setForeground(new Color(255, 255, 255));
				btnXuatPDF.setBackground(Color.decode(hexColor_Green));
				btnXuatPDF.setFont(new Font("Segoe UI", Font.BOLD, 13));
				btnXuatPDF.setSelectedIcon(new ImageIcon(JDialog_ChiTietPhieuDatPhongTruoc.class.getResource("/icon/printer.png")));
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
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
	}
	
	

	public void HienThongTinTheoMaPDP(String ma) {
		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_KH = new KhachHang_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_P = new Phong_DAO();
		DAO_LP = new LoaiPhong_DAO();

		kh = new KhachHang();
		nv = new NhanVien();
		p = new Phong();
		lp = new LoaiPhong();

		pdp = DAO_PDP.layPhieuDatPhong_TheoMaPhieuDat(ma);
		p = DAO_P.timPhong_TheoMaPhong(pdp.getPhong().getMaPhong());
		kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());
		nv = DAO_NV.timNhanVien_TheoMaNhanVien(pdp.getNhanVien().getMaNhanVien());
		lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());

		txtMaPDP.setText(pdp.getMaPhieuDat());
		txtLoaiPhong.setText(lp.getTenLoaiPhong());
		txtNhanVien.setText(nv.getHoTen());
		txtTenKH.setText(kh.getHoTen());
		txtSoDienThoai.setText(kh.getSoDienThoai());
		txtGiaPhong.setText(Double.toString(lp.getGiaTien()));
		txtTenPhong.setText(p.getTenPhong());
		txtTienCoc.setText(Double.toString(pdp.getTienCoc()));
		date_DatPhong.setText(pdp.getThoiGianDatPhong().toString());
		date_NhanPhong.setText(pdp.getThoiGianNhanPhong().toString());
		txtTinhTrangPhieu.setText(pdp.getTrangThai());
		txtMoTa.setText(pdp.getMoTa());
		txtMaKH.setText(kh.getMaKhachHang());
		
       
		if(!pdp.getTrangThai().equals("Chờ nhận phòng")) {
			btnNhanPhong.setVisible(false);
		}else {
			btnNhanPhong.setVisible(true);
		}
	}
	
	/**
	 *Xuất file PDF phiếu đặt phòng
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
