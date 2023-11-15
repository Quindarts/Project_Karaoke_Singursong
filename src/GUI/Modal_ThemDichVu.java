package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.ConnectDB;
import DAO.DichVu_DAO;
import DAO.LoaiPhong_DAO;
import DAO.ThongTinDichVu_DAO;
import Entity.DichVu;
import Entity.LoaiPhong;
import Entity.ThongTinDichVu;
import OtherFunction.HelpRamDomMa;
import OtherFunction.HelpValidate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.Color;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import com.toedter.calendar.JDateChooser;

public class Modal_ThemDichVu extends JFrame {

	private JPanel contentPane;
	private JTextField txt_maDichVu;
	private JTextField txt_tenDichVu;
	private JTextField txt_SoLuong;
	private JTextField txt_GiaTien;
	private JTextArea txtA_moTa;
	private JLabel img_show_panel;
	private String pathImg = "";
	private HelpValidate valiDate;
	private JTextField txt_soLuongDaSuDung;
	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private JDateChooser dateChooser_ngayHetHan;
	private JDateChooser dateChooser_ngayNhap;
	private Date ngayNhap;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Modal_ThemDichVu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnl_TieuDe = new JPanel();
		pnl_TieuDe.setBackground(Color.WHITE);
		pnl_TieuDe.setBounds(26, 25, 230, 25);
		contentPane.add(pnl_TieuDe);
		pnl_TieuDe.setLayout(null);

		JLabel lbl_Title = new JLabel("Thêm dịch vụ mới");
		lbl_Title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Title.setBounds(0, 0, 237, 25);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pnl_TieuDe.add(lbl_Title);

		JPanel pnl_Anh = new JPanel();
		pnl_Anh.setBorder(new LineBorder(new Color(0, 0, 255)));
		pnl_Anh.setBackground(new Color(255, 255, 255));
		pnl_Anh.setBounds(26, 95, 179, 198);
		contentPane.add(pnl_Anh);
		pnl_Anh.setLayout(null);

		img_show_panel = new JLabel();
		img_show_panel.setBounds(10, 10, 159, 176);
		pnl_Anh.add(img_show_panel);

		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setBackground(Color.WHITE);
		pnl_ThongTin.setBounds(224, 95, 765, 286);
		contentPane.add(pnl_ThongTin);
		pnl_ThongTin.setLayout(null);

		JPanel pnl_MaLoaiPhong = new JPanel();
		pnl_MaLoaiPhong.setBackground(Color.WHITE);
		pnl_MaLoaiPhong.setBounds(10, 5, 350, 25);
		pnl_ThongTin.add(pnl_MaLoaiPhong);
		pnl_MaLoaiPhong.setLayout(null);

		JLabel lbl_MaDichVu = new JLabel("Mã dịch vụ");
		lbl_MaDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MaDichVu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MaDichVu.setBounds(0, 0, 110, 25);
		pnl_MaLoaiPhong.add(lbl_MaDichVu);

		txt_maDichVu = new JTextField();
		txt_maDichVu.setBounds(125, 0, 225, 25);
		pnl_MaLoaiPhong.add(txt_maDichVu);
		txt_maDichVu.setColumns(10);

		JPanel pnl_TenLoaiPhong = new JPanel();
		pnl_TenLoaiPhong.setBackground(Color.WHITE);
		pnl_TenLoaiPhong.setLayout(null);
		pnl_TenLoaiPhong.setBounds(10, 50, 350, 25);
		pnl_ThongTin.add(pnl_TenLoaiPhong);

		JLabel lbl_TenDichVu = new JLabel("Tên dịch vụ");
		lbl_TenDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenDichVu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TenDichVu.setBounds(0, 0, 110, 25);
		pnl_TenLoaiPhong.add(lbl_TenDichVu);

		txt_tenDichVu = new JTextField();
		txt_tenDichVu.setColumns(10);
		txt_tenDichVu.setBounds(125, 0, 225, 25);
		pnl_TenLoaiPhong.add(txt_tenDichVu);

		JPanel pnl_SoLuongKhachToiDa = new JPanel();
		pnl_SoLuongKhachToiDa.setBackground(Color.WHITE);
		pnl_SoLuongKhachToiDa.setLayout(null);
		pnl_SoLuongKhachToiDa.setBounds(405, 5, 350, 25);
		pnl_ThongTin.add(pnl_SoLuongKhachToiDa);

		JLabel lbl_SoLuong = new JLabel("Số lượng");
		lbl_SoLuong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoLuong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoLuong.setBounds(0, 0, 143, 25);
		pnl_SoLuongKhachToiDa.add(lbl_SoLuong);

		txt_SoLuong = new JTextField();
		txt_SoLuong.setColumns(10);
		txt_SoLuong.setBounds(153, 0, 197, 25);
		pnl_SoLuongKhachToiDa.add(txt_SoLuong);

		JPanel pnl_GiaTien = new JPanel();
		pnl_GiaTien.setLayout(null);
		pnl_GiaTien.setBackground(Color.WHITE);
		pnl_GiaTien.setBounds(10, 95, 350, 25);
		pnl_ThongTin.add(pnl_GiaTien);

		JLabel lbl_GiaiTien = new JLabel("Giá tiền");
		lbl_GiaiTien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_GiaiTien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_GiaiTien.setBounds(0, 0, 110, 25);
		pnl_GiaTien.add(lbl_GiaiTien);

		txt_GiaTien = new JTextField();
		txt_GiaTien.setColumns(10);
		txt_GiaTien.setBounds(125, 0, 225, 25);
		pnl_GiaTien.add(txt_GiaTien);

		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setBounds(552, 246, 90, 30);
		pnl_ThongTin.add(btn_Luu);
		btn_Luu.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JButton btn_BoQua = new JButton("Bỏ qua");
		btn_BoQua.setBounds(665, 246, 90, 30);
		pnl_ThongTin.add(btn_BoQua);
		btn_BoQua.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JPanel pnl_GiaTien_1 = new JPanel();
		pnl_GiaTien_1.setLayout(null);
		pnl_GiaTien_1.setBackground(Color.WHITE);
		pnl_GiaTien_1.setBounds(10, 139, 350, 25);
		pnl_ThongTin.add(pnl_GiaTien_1);

		JLabel lbl_TrangThai = new JLabel("Trạng thái");
		lbl_TrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TrangThai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TrangThai.setBounds(0, 0, 110, 25);
		pnl_GiaTien_1.add(lbl_TrangThai);

		JComboBox cbox_trangThai = new JComboBox();

		cbox_trangThai.addItem("Còn hàng");
		cbox_trangThai.addItem("Hết hàng");

		cbox_trangThai.setBounds(126, 3, 224, 21);
		pnl_GiaTien_1.add(cbox_trangThai);

		JPanel pnl_GiaTien_2 = new JPanel();
		pnl_GiaTien_2.setLayout(null);
		pnl_GiaTien_2.setBackground(Color.WHITE);
		pnl_GiaTien_2.setBounds(405, 95, 350, 25);
		pnl_ThongTin.add(pnl_GiaTien_2);

		JLabel lbl_NgayNhap = new JLabel("Ngày nhập");
		lbl_NgayNhap.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_NgayNhap.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_NgayNhap.setBounds(0, 0, 110, 25);
		pnl_GiaTien_2.add(lbl_NgayNhap);

		dateChooser_ngayNhap = new JDateChooser();
		dateChooser_ngayNhap.setBounds(155, 0, 195, 25);
		pnl_GiaTien_2.add(dateChooser_ngayNhap);

		JPanel pnl_GiaTien_2_1 = new JPanel();
		pnl_GiaTien_2_1.setLayout(null);
		pnl_GiaTien_2_1.setBackground(Color.WHITE);
		pnl_GiaTien_2_1.setBounds(405, 139, 350, 25);
		pnl_ThongTin.add(pnl_GiaTien_2_1);

		JLabel lbl_NgayHetHan = new JLabel("Ngày hết hạn");
		lbl_NgayHetHan.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_NgayHetHan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_NgayHetHan.setBounds(0, 0, 110, 25);
		pnl_GiaTien_2_1.add(lbl_NgayHetHan);

		dateChooser_ngayHetHan = new JDateChooser();
		dateChooser_ngayHetHan.setBounds(155, 0, 195, 25);
		pnl_GiaTien_2_1.add(dateChooser_ngayHetHan);

		JPanel pnl_GiaTien_2_2 = new JPanel();
		pnl_GiaTien_2_2.setLayout(null);
		pnl_GiaTien_2_2.setBackground(Color.WHITE);
		pnl_GiaTien_2_2.setBounds(405, 50, 350, 25);
		pnl_ThongTin.add(pnl_GiaTien_2_2);

		JLabel lbl_SoLuongDaSuDung = new JLabel("Số lượng đã sử dụng");
		lbl_SoLuongDaSuDung.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoLuongDaSuDung.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoLuongDaSuDung.setBounds(0, 0, 143, 25);
		pnl_GiaTien_2_2.add(lbl_SoLuongDaSuDung);

		txt_soLuongDaSuDung = new JTextField();
		txt_soLuongDaSuDung.setColumns(10);
		txt_soLuongDaSuDung.setBounds(153, 1, 197, 25);
		pnl_GiaTien_2_2.add(txt_soLuongDaSuDung);

		JPanel pnl_GiaTien_1_1 = new JPanel();
		pnl_GiaTien_1_1.setLayout(null);
		pnl_GiaTien_1_1.setBackground(Color.WHITE);
		pnl_GiaTien_1_1.setBounds(10, 188, 350, 88);
		pnl_ThongTin.add(pnl_GiaTien_1_1);

		JLabel lbl_moTa = new JLabel("Mô Tả");
		lbl_moTa.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_moTa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_moTa.setBounds(0, 0, 110, 25);
		pnl_GiaTien_1_1.add(lbl_moTa);

		txtA_moTa = new JTextArea();
		txtA_moTa.setBounds(127, 1, 223, 87);
		pnl_GiaTien_1_1.add(txtA_moTa);
		
				JButton btn_ChonAnh = new JButton("Chọn ảnh");
				btn_ChonAnh.setBounds(26, 303, 179, 32);
				contentPane.add(btn_ChonAnh);
				btn_ChonAnh.setFont(new Font("Segoe UI", Font.BOLD, 13));
				btn_ChonAnh.setForeground(new Color(255, 255, 255));
				
						btn_ChonAnh.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								img_show_panel.setIcon(ResizeImage(chooseFileEvent("image")));
							}
				
							public ImageIcon ResizeImage(String ImagePath) {
								ImageIcon MyImage = new ImageIcon(ImagePath);
								Image img = MyImage.getImage();
								Image newImg = img.getScaledInstance(img_show_panel.getWidth(), img_show_panel.getHeight(),
										Image.SCALE_SMOOTH);
								ImageIcon image = new ImageIcon(newImg);
								return image;
							}
						});
						btn_ChonAnh.setBackground(new Color(0, 128, 255));

		btn_BoQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		btn_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Table Dich vu

				String tenDichVu = txt_tenDichVu.getText();
				int soLuong = Integer.parseInt(txt_SoLuong.getText());
				String donViTinh = "VND";

				boolean trangThai = cbox_trangThai.getSelectedItem().toString().trim().equals("Còn hàng");
				double giaTien = Double.parseDouble(txt_GiaTien.getText());

				// Table Thong tin dich vu
				HelpRamDomMa helpMa = new HelpRamDomMa();
				String maDichVu = helpMa.taoMa("DichVu", "maDichVu", "DV");
				String maThongTinDichVu = helpMa.taoMa("ThongTinDichVu", "maThongTinDichVu", "TTDV");

				txt_maDichVu.setText(maDichVu);
				// maDichvu
				// soLuong
				int soLuongDaSuDung = Integer.parseInt(txt_soLuongDaSuDung.getText());
				Date ngayNhap = new Date((dateChooser_ngayNhap).getDate().getTime());
				Date ngayHetHan = new Date((dateChooser_ngayHetHan).getDate().getTime());
				
				File file = new File(pathImg);
		        String fileName = file.getName();
		        String relativePath = "/img" + File.separator + fileName;
		        relativePath = relativePath.replace(File.separator, "/");
		        String hinhA = relativePath;
		        
				String moTa = txtA_moTa.getText();

				DichVu dv = new DichVu(maDichVu, tenDichVu, soLuong, donViTinh, giaTien, trangThai);
				ThongTinDichVu ttdv = new ThongTinDichVu(maThongTinDichVu, dv, soLuong, soLuongDaSuDung, ngayNhap,
						ngayHetHan, moTa, hinhA);

				try {

					DichVu_DAO DAO_DV = new DichVu_DAO();
					ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();

					if (DAO_DV.taoDichVu(dv) && DAO_TTDV.taoThongTinDichVu(ttdv)) {
						JOptionPane.showMessageDialog(null, "Tạo dịch vụ thành công.");
					} else {
						JOptionPane.showMessageDialog(null, "Tạo dịch vụ thất bại, vui lòng thử lại.");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Tạo dịch vụ thất bại, vui lòng thử lại.");

				}

			}
		});
	}

	public void setModal_ThemDichVu(String maDichVu, String tenDichVu, String soLuong, String donViTinh, String donGia,
			String trangThai) {
		ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
		ThongTinDichVu ttdv = DAO_TTDV.timThongTinDichVu_TheoMaDichVu(maDichVu);

		dateChooser_ngayNhap.setDate(ttdv.getNgayNhap());
		dateChooser_ngayHetHan.setDate(ttdv.getNgayHetHan());
		txt_maDichVu.setText(maDichVu);
		txt_GiaTien.setText(donGia);
		txt_SoLuong.setText(soLuong);
		txt_soLuongDaSuDung.setText(soLuong);
		txt_tenDichVu.setText(tenDichVu);
		txtA_moTa.setText(ttdv.getMoTa());

//		txtA_moTa;

	}

	public String chooseFileEvent(String typeFile) {
		JFileChooser file = new JFileChooser();
		String path = "";
		file.setCurrentDirectory(new File(System.getProperty("user.home")));

		FileNameExtensionFilter filterImage = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png", "xlsx",
				"xls");
		FileNameExtensionFilter filterExcel = new FileNameExtensionFilter("xlsx", "xls");

		// Doc path image
		if (typeFile.equals("image")) {
			file.addChoosableFileFilter(filterImage);
		}
		// Doc path excel
		else if (typeFile.equals("excel")) {
			file.addChoosableFileFilter(filterExcel);
		}

		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {

			File selectedFile = file.getSelectedFile();
			path = selectedFile.getAbsolutePath();
			pathImg += path;
			return path;
		}

		else if (result == JFileChooser.CANCEL_OPTION) {

			JOptionPane.showMessageDialog(null, "Không tìm thấy file tải lên");
		}
		return path;
	}
}
