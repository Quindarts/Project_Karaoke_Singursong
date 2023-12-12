
package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ctc.wstx.shaded.msv_core.verifier.identity.Matcher;
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
import java.awt.Toolkit;
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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.border.EtchedBorder;

public class JDialog_ThemLoaiPhong extends JFrame implements ActionListener {

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
	
	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	private JButton btn_ChonAnh;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JDialog_ThemLoaiPhong() {
		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JDialog_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setBounds(100, 100, 1024, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnl_TieuDe = new JPanel();
		pnl_TieuDe.setBackground(Color.WHITE);
		pnl_TieuDe.setBounds(22, 11, 230, 25);
		contentPane.add(pnl_TieuDe);
		pnl_TieuDe.setLayout(null);

		JLabel lbl_Title = new JLabel("THÔNG TIN LOẠI PHÒNG");
		lbl_Title.setForeground(Color.decode(hexColor_Blue1));
		lbl_Title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Title.setBounds(0, 0, 237, 25);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 17));
		pnl_TieuDe.add(lbl_Title);

		JPanel pnl_Anh = new JPanel();
		pnl_Anh.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnl_Anh.setBackground(Color.WHITE);
		pnl_Anh.setBounds(26, 50, 179, 171);
		contentPane.add(pnl_Anh);
		pnl_Anh.setLayout(null);

		img_show_panel = new JLabel();
		img_show_panel.setBounds(10, 10, 159, 150);
		pnl_Anh.add(img_show_panel);

		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setBackground(Color.WHITE);
		pnl_ThongTin.setBounds(224, 50, 765, 234);
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
		txt_MaLoaiPhong.setToolTipText("ORD1, ORD2, VIP1, VIP2, ...");
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
		btn_Luu.setBackground(Color.decode(hexColor_Orange));
		btn_Luu.setIcon(new ImageIcon(JDialog_ThemLoaiPhong.class.getResource("/icon/save_16px.png")));
		btn_Luu.setForeground(new Color(255, 255, 255));
		btn_Luu.setBounds(535, 204, 110, 30);
		pnl_ThongTin.add(btn_Luu);
		btn_Luu.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JButton btn_BoQua = new JButton("Thoát");
		btn_BoQua.setBackground(Color.decode(hexColor_Blue2));
		btn_BoQua.setIcon(new ImageIcon(JDialog_ThemLoaiPhong.class.getResource("/icon/exit_16px.png")));
		btn_BoQua.setForeground(new Color(255, 255, 255));
		btn_BoQua.setBounds(655, 204, 110, 30);
		pnl_ThongTin.add(btn_BoQua);
		btn_BoQua.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
				btn_ChonAnh = new JButton("Chọn ảnh");
				btn_ChonAnh.setIcon(new ImageIcon(JDialog_ThemLoaiPhong.class.getResource("/icon/upload.png")));
				btn_ChonAnh.setBounds(26, 252, 179, 32);
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
						btn_ChonAnh.setBackground(Color.decode(hexColor_Green));

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
		file.setCurrentDirectory(new File("src/img"));

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
		
		LoaiPhong lp = new LoaiPhong();
		LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();
		lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(maLP);
		
		ImageIcon originalIcon = new ImageIcon(JPanel_CardDichVu.class.getResource("/img/" + lp.getHinhAnh()));
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);	
		img_show_panel.setIcon(resizedIcon);
		
		txt_MaLoaiPhong.setEditable(false);
		txt_GiaTien.setEditable(false);
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
		File file = new File(pathImg);
		String hinhA = file.getName();
		System.out.println("HÌNH ẢNH: " + hinhA);
		String moTa = txtA_Mota.getText();
		int soLuongToiDa = 0;
		double giaTien = 0;

		
		try {
			LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();
			if(!maLoaiPhong.equals("") && !tenLoaiPong.equals("") && !txt_SoLuongKhachToiDa.getText().equals("") && !txt_GiaTien.getText().equals("")) {
				if (DAO_LP.layLoaiPhong_TheoMaLoaiPhong(maLoaiPhong) == null) {
					if(txt_SoLuongKhachToiDa.getText().matches("\\d+") && txt_GiaTien.getText().matches("\\d+")) {
						soLuongToiDa = Integer.parseInt(txt_SoLuongKhachToiDa.getText());
						giaTien = Double.parseDouble(txt_GiaTien.getText());
						if(isValidString(maLoaiPhong)) {
							LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong.toUpperCase(), tenLoaiPong, soLuongToiDa, giaTien, hinhA, moTa);
							if (DAO_LP.taoLoaiPhong(loaiPhong) == false) {
								JOptionPane.showMessageDialog(this, "Tạo loại phòng thất bại, vui lòng thử lại.");
								return;
							} else {
								JOptionPane.showMessageDialog(this, "Tạo loại phòng thành công.");
								setVisible(false);
							}
						} else {
							JOptionPane.showMessageDialog(this, "Mã nhập vào không hợp lệ!");
						}
					} else {
						JOptionPane.showMessageDialog(this, "Số lượng và giá tiền chỉ nhập số nguyên!");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Loại phòng này đã tồn tại, vui lòng thêm loại phòng khác");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ thông tin!");
			}

		} catch (Exception e2) {

		}
	}
	
	public static boolean isValidString(String s) {
        String regex = "^(?:ORD|VIP|ord|vip).*\\d$";
        Pattern pattern = Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }

	public void capNhatLoaiPhong() {
		String maLoaiPhong = txt_MaLoaiPhong.getText();
		String tenLoaiPong = txt_TenLoaiPhong.getText();
		int soLuongToiDa = Integer.parseInt(txt_SoLuongKhachToiDa.getText());
//		File file = new File(pathImg);
//		String hinhA = file.getName();
		
		String hinhA;
		if(pathImg != null) {
			File file = new File(pathImg);
	        String fileName = file.getName();
	        hinhA = fileName;
		} else {
			hinhA = "noImage.jpg";
		}
		
		double giaTien = Double.parseDouble(txt_GiaTien.getText());
		String moTa = txtA_Mota.getText();

		
		

		try {
			LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();

//			if (DAO_LP.layLoaiPhong_TheoMaLoaiPhong(maLoaiPhong) != null) {
//				JOptionPane.showMessageDialog(null, "Loại phòng này đã tồn tại, vui lòng thêm loại phòng khác");
//				return ;
//			}

			LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPong, soLuongToiDa, giaTien, hinhA, moTa);
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
			themLoaiPhong(); 
		}

	}
}