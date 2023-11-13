
package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.ConnectDB;
import DAO.LoaiPhong_DAO;
import Entity.LoaiPhong;
import OtherFunction.HelpValidate;
import io.jsonwebtoken.io.IOException;

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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;

public class Modal_ThemLoaiPhong extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_MaLoaiPhong;
	private JTextField txt_TenLoaiPhong;
	private JTextField txt_SoLuongKhachToiDa;
	private JTextField txt_GiaTien;
	private JTextArea txtA_Mota;
	private JLabel img_show_panel;
	private String pathImg = "";
	private HelpValidate valiDate;
	private JButton btn_Luu;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Modal_ThemLoaiPhong() {
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

		JLabel lbl_Title = new JLabel("Thêm loại phòng mới");
		lbl_Title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Title.setBounds(0, 0, 237, 25);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pnl_TieuDe.add(lbl_Title);

		JPanel pnl_Anh = new JPanel();
		pnl_Anh.setBorder(new LineBorder(new Color(0, 0, 255)));
		pnl_Anh.setBackground(Color.WHITE);
		pnl_Anh.setBounds(26, 95, 179, 197);
		contentPane.add(pnl_Anh);
		pnl_Anh.setLayout(null);

		img_show_panel = new JLabel();
		img_show_panel.setBounds(10, 10, 159, 178);
		pnl_Anh.add(img_show_panel);

		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setBackground(Color.WHITE);
		pnl_ThongTin.setBounds(224, 95, 765, 234);
		contentPane.add(pnl_ThongTin);
		pnl_ThongTin.setLayout(null);

		JPanel pnl_MaLoaiPhong = new JPanel();
		pnl_MaLoaiPhong.setBackground(Color.WHITE);
		pnl_MaLoaiPhong.setBounds(10, 5, 350, 25);
		pnl_ThongTin.add(pnl_MaLoaiPhong);
		pnl_MaLoaiPhong.setLayout(null);

		JLabel lbl_MaLoaiPhong = new JLabel("Mã loại phòng");
		lbl_MaLoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MaLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MaLoaiPhong.setBounds(0, 0, 110, 25);
		pnl_MaLoaiPhong.add(lbl_MaLoaiPhong);

		txt_MaLoaiPhong = new JTextField();
		txt_MaLoaiPhong.setBounds(125, 0, 225, 25);
		pnl_MaLoaiPhong.add(txt_MaLoaiPhong);
		txt_MaLoaiPhong.setColumns(10);

		JPanel pnl_TenLoaiPhong = new JPanel();
		pnl_TenLoaiPhong.setBackground(Color.WHITE);
		pnl_TenLoaiPhong.setLayout(null);
		pnl_TenLoaiPhong.setBounds(10, 50, 350, 25);
		pnl_ThongTin.add(pnl_TenLoaiPhong);

		JLabel lbl_TenLoaiPhong = new JLabel("Tên loại phòng");
		lbl_TenLoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TenLoaiPhong.setBounds(0, 0, 110, 25);
		pnl_TenLoaiPhong.add(lbl_TenLoaiPhong);

		txt_TenLoaiPhong = new JTextField();
		txt_TenLoaiPhong.setColumns(10);
		txt_TenLoaiPhong.setBounds(125, 0, 225, 25);
		pnl_TenLoaiPhong.add(txt_TenLoaiPhong);

		JPanel pnl_SoLuongKhachToiDa = new JPanel();
		pnl_SoLuongKhachToiDa.setBackground(Color.WHITE);
		pnl_SoLuongKhachToiDa.setLayout(null);
		pnl_SoLuongKhachToiDa.setBounds(405, 5, 350, 25);
		pnl_ThongTin.add(pnl_SoLuongKhachToiDa);

		JLabel lbl_SoLuongKhachToiDa = new JLabel("Số lượng khách tối đa");
		lbl_SoLuongKhachToiDa.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoLuongKhachToiDa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoLuongKhachToiDa.setBounds(0, 0, 143, 25);
		pnl_SoLuongKhachToiDa.add(lbl_SoLuongKhachToiDa);

		txt_SoLuongKhachToiDa = new JTextField();
		txt_SoLuongKhachToiDa.setColumns(10);
		txt_SoLuongKhachToiDa.setBounds(153, 0, 197, 25);
		pnl_SoLuongKhachToiDa.add(txt_SoLuongKhachToiDa);

		JPanel pnl_MoTa = new JPanel();
		pnl_MoTa.setBackground(new Color(255, 255, 255));
		pnl_MoTa.setBounds(405, 50, 350, 70);
		pnl_ThongTin.add(pnl_MoTa);
		pnl_MoTa.setLayout(null);

		JLabel lbl_MoTa = new JLabel("Mô tả");
		lbl_MoTa.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MoTa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MoTa.setBounds(0, 0, 143, 25);
		pnl_MoTa.add(lbl_MoTa);

		JPanel pnl_txtA_MoTa = new JPanel();
		pnl_txtA_MoTa.setBounds(90, 0, 260, 70);
		pnl_MoTa.add(pnl_txtA_MoTa);
		pnl_txtA_MoTa.setLayout(null);
		pnl_txtA_MoTa.setBackground(Color.WHITE);

		txtA_Mota = new JTextArea();
		txtA_Mota.setBounds(2, 2, 255, 65);
		pnl_txtA_MoTa.add(txtA_Mota);
		pnl_txtA_MoTa.setBorder(new LineBorder(new Color(192, 192, 192)));

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

		btn_Luu = new JButton("Lưu");
		btn_Luu.setBounds(562, 204, 90, 30);
		pnl_ThongTin.add(btn_Luu);
		btn_Luu.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JButton btn_BoQua = new JButton("Thoát");
		btn_BoQua.setBounds(665, 204, 90, 30);
		pnl_ThongTin.add(btn_BoQua);
		btn_BoQua.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
				JButton btn_ChonAnh = new JButton("Chọn ảnh");
				btn_ChonAnh.setBounds(26, 297, 179, 32);
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
				dispose(); // Dựa vào Frame chứ nó nó để fix
//				TrangChu tc = new TrangChu();
//				tc.setVisible(true);
//				setVisible(false);
			}
		});

		btn_Luu.addActionListener(this);
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
			System.out.println("Không tìm thấy file tải lên");
			JOptionPane.showMessageDialog(null, "Không tìm thấy file tải lên");
		}
		return path;
	}

	public void setModalThemLoaiPhong(String maLP, String tenLP, String giaTien, String soLuong, String hinhAnh,
			String moTa) {
		txt_MaLoaiPhong.setText(maLP.trim());
		txt_TenLoaiPhong.setText(tenLP);
		txt_GiaTien.setText(giaTien);
		txt_SoLuongKhachToiDa.setText(soLuong);
		txtA_Mota.setText(moTa);
//		img_show_panel.setIcon(ResizeImage(ttdv.getHinhAnh()));	
		if(!hinhAnh.equals("")) {
			docAnh(hinhAnh);
		} else {
			docAnh("D:\\Hk1-3\\PTUD\\sourecode\\KaraokeSingUrSong\\src\\img\\noImage.jpg");
		}
		
	}

	public void docAnh(String hinhAnh) {	
		ImageIcon imageIcon = new ImageIcon(hinhAnh);

		int originalWidth = imageIcon.getIconWidth();
		int originalHeight = imageIcon.getIconHeight();

		int newWidth = 159;
		int newHeight = 178;

		BufferedImage originalImage = null;
		
		try {
			originalImage = ImageIO.read(new File(hinhAnh));
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		img_show_panel.setIcon(scaledIcon);
	}

	public void themLoaiPhong() {
		String maLoaiPhong = txt_MaLoaiPhong.getText();
		String tenLoaiPong = txt_TenLoaiPhong.getText();
		int soLuongToiDa = Integer.parseInt(txt_SoLuongKhachToiDa.getText());
		String hinhA = pathImg;
		double giaTien = Double.parseDouble(txt_GiaTien.getText());
		String moTa = txtA_Mota.getText();

		try {
			LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();

			if (DAO_LP.layLoaiPhong_TheoMaLoaiPhong(maLoaiPhong) != null) {
				JOptionPane.showMessageDialog(null, "Loại phòng này đã tồn tại, vui lòng thêm loại phòng khác");
				return;
			}

			LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPong, soLuongToiDa, giaTien, hinhA, moTa);
			System.out.println(loaiPhong);
			if (DAO_LP.taoLoaiPhong(loaiPhong) == false) {
				JOptionPane.showMessageDialog(null, "Tạo loại phòng thất bại, vui lòng thử lại.");
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Tạo loại phòng thành công.");
			}

		} catch (Exception e2) {

		}
	}

	public void capNhatLoaiPhong() {
		String maLoaiPhong = txt_MaLoaiPhong.getText();
		String tenLoaiPong = txt_TenLoaiPhong.getText();
		int soLuongToiDa = Integer.parseInt(txt_SoLuongKhachToiDa.getText());
		String hinhA = pathImg;
		double giaTien = Double.parseDouble(txt_GiaTien.getText());
		String moTa = txtA_Mota.getText();

		try {
			LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();

//			if (DAO_LP.layLoaiPhong_TheoMaLoaiPhong(maLoaiPhong) != null) {
//				JOptionPane.showMessageDialog(null, "Loại phòng này đã tồn tại, vui lòng thêm loại phòng khác");
//				return ;
//			}

			LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPong, soLuongToiDa, giaTien, hinhA, moTa);
			System.out.println(loaiPhong);
			if (DAO_LP.capNhatLoaiPhong(loaiPhong) == false) {
				JOptionPane.showMessageDialog(null, "Cập nhất loại phòng này thất bại, vui lòng thử lại.");
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Cập nhật loại phòng này thành công.");
			}

		} catch (Exception e2) {

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_Luu)) {
			if (txt_MaLoaiPhong.getText().equals("")) {
				themLoaiPhong();
			} else {
				capNhatLoaiPhong();
			}
		}

	}
}