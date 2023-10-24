package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class Modal_ThemNhanVien extends JFrame implements ActionListener, KeyListener, PropertyChangeListener {

	private JPanel contentPane;

	private JTextField txt_MaNhanVien;
	private JTextField txt_TenNhanVien;
	private JTextField txt_SoDienThoai;
	private JTextField txt_DiaChi;
	private JTextField txt_CCCD;

	private JButton btn_Them;

	private JDateChooser dateChooser;

	private JRadioButton rdbtn_Nam;

	private JRadioButton rdbtn_Nu;

	private JComboBox comboBox;

	private JLabel lblTen;

	private JLabel lblNgaySinh;

	private JLabel lblSDT;

	private JLabel lblDiaChi;

	private JLabel lblCCCD;

	private JComboBox comboBox_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			private Modal_ThemNhanVien app;
	        
			public void run() {
				try {
					Modal_ThemNhanVien frame = new Modal_ThemNhanVien();
					FlatLightLaf.setup();
					app = new Modal_ThemNhanVien();
					app.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Modal_ThemNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 450);
		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel pnl_TieuDe = new JPanel();
		pnl_TieuDe.setBackground(Color.WHITE);
		pnl_TieuDe.setBounds(26, 25, 237, 35);
		contentPane.add(pnl_TieuDe);
		pnl_TieuDe.setLayout(null);

		
		JLabel lbl_Title = new JLabel("Thêm nhân viên mới");
		lbl_Title.setBounds(0, 10, 237, 20);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 18));

		pnl_TieuDe.add(lbl_Title);
		
		JPanel pnl_Anh = new JPanel();
		pnl_Anh.setBackground(Color.WHITE);
		pnl_Anh.setBounds(26, 70, 179, 234);
		contentPane.add(pnl_Anh);
		pnl_Anh.setLayout(null);
		
		JPanel Anh = new JPanel();
		Anh.setBackground(new Color(192, 192, 192));
		Anh.setBounds(0, 0, 179, 192);
		pnl_Anh.add(Anh);
		
		JButton btn_ChonAnh = new JButton("Chọn ảnh");
		btn_ChonAnh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_ChonAnh.setForeground(new Color(255, 255, 255));
		btn_ChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ChonAnh.setBackground(new Color(0, 128, 255));
		btn_ChonAnh.setBounds(0, 202, 179, 32);
		pnl_Anh.add(btn_ChonAnh);
		
		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setBackground(Color.WHITE);
		pnl_ThongTin.setBounds(224, 70, 765, 234);
		contentPane.add(pnl_ThongTin);
		pnl_ThongTin.setLayout(null);
		
		JPanel pnl_MaNhanVien = new JPanel();
		pnl_MaNhanVien.setBackground(Color.WHITE);
		pnl_MaNhanVien.setBounds(10, 5, 350, 25);
		pnl_ThongTin.add(pnl_MaNhanVien);
		pnl_MaNhanVien.setLayout(null);
		
		JLabel lbl_MaNhanVien = new JLabel("Mã nhân viên");
		lbl_MaNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MaNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MaNhanVien.setBounds(0, 0, 110, 25);
		pnl_MaNhanVien.add(lbl_MaNhanVien);
		
		txt_MaNhanVien = new JTextField();
		txt_MaNhanVien.setEditable(false);
		txt_MaNhanVien.setBounds(125, 0, 225, 25);
		pnl_MaNhanVien.add(txt_MaNhanVien);
		txt_MaNhanVien.setColumns(10);
		
		JPanel pnl_ChucVu = new JPanel();
		pnl_ChucVu.setBackground(Color.WHITE);
		pnl_ChucVu.setLayout(null);
		pnl_ChucVu.setBounds(405, 5, 350, 25);
		pnl_ThongTin.add(pnl_ChucVu);
		
		JLabel lbl_ChucVu = new JLabel("Chức vụ");
		lbl_ChucVu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ChucVu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_ChucVu.setBounds(0, 0, 110, 25);
		pnl_ChucVu.add(lbl_ChucVu);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(125, 0, 225, 25);
		String[] option_ChucVu= {"Quản lý", "Nhân viên thu ngân"};
		comboBox_1.setModel(new DefaultComboBoxModel<>(option_ChucVu));
		pnl_ChucVu.add(comboBox_1);
		
		JPanel pnl_TenNhanVien = new JPanel();
		pnl_TenNhanVien.setBackground(Color.WHITE);
		pnl_TenNhanVien.setLayout(null); 
		pnl_TenNhanVien.setBounds(10, 50, 350, 25);
		pnl_ThongTin.add(pnl_TenNhanVien);
		
		JLabel lbl_TenNhanVien = new JLabel("Tên nhân viên");
		lbl_TenNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TenNhanVien.setBounds(0, 0, 110, 25);
		pnl_TenNhanVien.add(lbl_TenNhanVien);
		
		txt_TenNhanVien = new JTextField();
		txt_TenNhanVien.setColumns(10);
		txt_TenNhanVien.setBounds(125, 0, 225, 25);
		pnl_TenNhanVien.add(txt_TenNhanVien);
		
		JPanel pnl_NgaySinh = new JPanel();
		pnl_NgaySinh.setBackground(Color.WHITE);
		pnl_NgaySinh.setLayout(null);
		pnl_NgaySinh.setBounds(10, 95, 350, 25);
		pnl_ThongTin.add(pnl_NgaySinh);
		
		JLabel lbl_NgaySinh = new JLabel("Ngày sinh");
		lbl_NgaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_NgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_NgaySinh.setBounds(0, 0, 110, 25);
		pnl_NgaySinh.add(lbl_NgaySinh);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(126, 0, 224, 25);
		pnl_NgaySinh.add(dateChooser);
		
		
		
		JPanel pnl_GioiTinh = new JPanel();
		pnl_GioiTinh.setBackground(Color.WHITE);
		pnl_GioiTinh.setLayout(null);
		pnl_GioiTinh.setBounds(10, 140, 350, 25);
		pnl_ThongTin.add(pnl_GioiTinh);
		
		JLabel lbl_GioiTinh = new JLabel("Giới tính");
		lbl_GioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_GioiTinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_GioiTinh.setBounds(0, 0, 110, 25);
		pnl_GioiTinh.add(lbl_GioiTinh);
		
		rdbtn_Nam = new JRadioButton("Nam");
		rdbtn_Nam.setBackground(Color.WHITE);
		rdbtn_Nam.setBounds(125, 0, 50, 25);
		rdbtn_Nam.setSelected(true);
		pnl_GioiTinh.add(rdbtn_Nam);
		
		rdbtn_Nu = new JRadioButton("Nữ");
		rdbtn_Nu.setBackground(Color.WHITE);
		rdbtn_Nu.setBounds(190, 0, 50, 25);
		pnl_GioiTinh.add(rdbtn_Nu);
		
		JPanel pnl_TrangThai = new JPanel();
		pnl_TrangThai.setBackground(Color.WHITE);
		pnl_TrangThai.setLayout(null);
		pnl_TrangThai.setBounds(10, 185, 350, 25);
		pnl_ThongTin.add(pnl_TrangThai);
		
		JLabel lbl_TrangThai = new JLabel("Trạng thái");
		lbl_TrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TrangThai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TrangThai.setBounds(0, 0, 110, 25);
		pnl_TrangThai.add(lbl_TrangThai);
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(125, 0, 225, 25);
		pnl_TrangThai.add(comboBox);
		String[] option_TrangThai = {"Còn làm", "Nghỉ việc", "Nghỉ phép"};
		comboBox.setModel(new DefaultComboBoxModel<>(option_TrangThai));
		
		JPanel pnl_SoDienThoai = new JPanel();
		pnl_SoDienThoai.setBackground(Color.WHITE);
		pnl_SoDienThoai.setLayout(null);
		pnl_SoDienThoai.setBounds(405, 50, 350, 25);
		pnl_ThongTin.add(pnl_SoDienThoai);
		
		JLabel lbl_SoDienThoai = new JLabel("Số điện thoại");
		lbl_SoDienThoai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoDienThoai.setBounds(0, 0, 110, 25);
		pnl_SoDienThoai.add(lbl_SoDienThoai);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setColumns(10);
		txt_SoDienThoai.setBounds(125, 0, 225, 25);
		pnl_SoDienThoai.add(txt_SoDienThoai);
		
		JPanel pnl_DiaChi = new JPanel();
		pnl_DiaChi.setBackground(Color.WHITE);
		pnl_DiaChi.setLayout(null);
		pnl_DiaChi.setBounds(405, 95, 350, 25);
		pnl_ThongTin.add(pnl_DiaChi);
		
		JLabel lbl_DiaChi = new JLabel("Địa chỉ");
		lbl_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_DiaChi.setBounds(0, 0, 110, 25);
		pnl_DiaChi.add(lbl_DiaChi);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setColumns(10);
		txt_DiaChi.setBounds(125, 0, 225, 25);
		pnl_DiaChi.add(txt_DiaChi);
		
		JPanel pnl_CCCD = new JPanel();
		pnl_CCCD.setBackground(Color.WHITE);
		pnl_CCCD.setLayout(null);
		pnl_CCCD.setBounds(405, 140, 350, 25);
		pnl_ThongTin.add(pnl_CCCD);
		
		JLabel lbl_CCCD = new JLabel("Số CCCD");
		lbl_CCCD.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CCCD.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_CCCD.setBounds(0, 0, 110, 25);
		pnl_CCCD.add(lbl_CCCD);
		
		txt_CCCD = new JTextField();
		txt_CCCD.setColumns(10);
		txt_CCCD.setBounds(125, 0, 225, 25);
		pnl_CCCD.add(txt_CCCD);
		
		lblTen = new JLabel("*Buộc phải nhập");
		lblTen.setBackground(new Color(240, 240, 240));
		lblTen.setBounds(137, 72, 117, 13);
		pnl_ThongTin.add(lblTen);
		
		lblNgaySinh = new JLabel("*Buộc phải nhập");
		lblNgaySinh.setBackground(SystemColor.menu);
		lblNgaySinh.setBounds(137, 117, 117, 13);
		pnl_ThongTin.add(lblNgaySinh);
		
		
		lblSDT = new JLabel("*Buộc phải nhập");
		lblSDT.setBackground(SystemColor.menu);
		lblSDT.setBounds(532, 72, 117, 13);
		pnl_ThongTin.add(lblSDT);
		
		lblDiaChi = new JLabel("*Buộc phải nhập");
		lblDiaChi.setBackground(SystemColor.menu);
		lblDiaChi.setBounds(532, 117, 117, 13);
		pnl_ThongTin.add(lblDiaChi);
		
		lblCCCD = new JLabel("*Buộc phải nhập");
		lblCCCD.setBackground(SystemColor.menu);
		lblCCCD.setBounds(532, 175, 117, 13);
		pnl_ThongTin.add(lblCCCD);
		
		btn_Them = new JButton("Thêm Nhân Viên");
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_Them.setBackground(new Color(0, 128, 255));
		btn_Them.setBounds(795, 314, 179, 32);
		contentPane.add(btn_Them);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 70, 179, 234);
		contentPane.add(panel);
		
		btn_Them.addActionListener(this);
		rdbtn_Nam.addActionListener(this);
		rdbtn_Nu.addActionListener(this);
		
		dateChooser.addPropertyChangeListener( this);
		
		txt_TenNhanVien.addKeyListener(this);
		txt_SoDienThoai.addKeyListener(this);
		txt_DiaChi.addKeyListener(this);
		txt_CCCD.addKeyListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn_Them)) {
			if(validateThemNhanVien()) {
				String ten = txt_TenNhanVien.getText();
				Date ngaySinh = dateChooser.getDate();
//				String ghiChu = txtA__GhiChu.getText();
//				boolean gioiTinh = rdbtn_Nam.getSelection().getActionCommand().equals("Nam");
				boolean gioiTinh = rdbtn_Nam.isSelected() ? true : false;
				String trangThai = (String) comboBox.getSelectedItem();
				
				System.out.println(trangThai);
			}
		}
		
		if(o.equals(rdbtn_Nam)) {
			rdbtn_Nam.setSelected(true);
			rdbtn_Nu.setSelected(false);
		}
		if(o.equals(rdbtn_Nu)) {
			rdbtn_Nu.setSelected(true);
			rdbtn_Nam.setSelected(false);
		}		
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if(dateChooser.getDate() != null) {
			lblNgaySinh.setVisible(false);
		}
	}
	
	public boolean validateThemNhanVien() {
		return true;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object o = e.getSource();
		
		
		String ten = txt_TenNhanVien.getText();
		String sdt = txt_SoDienThoai.getText();
		String cccd = txt_CCCD.getText();
		
		String regexTen = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*";
		String regexSDT = "(0|0[3|5|7|8|9])+([0-9]{9})\\b";
		String regexCCCD = "(^\\w{3}[0-9]{6}$)|(^\\w{1,2}[0-9]{7}$)|(^\\d{9}$)|(^\\d{12}$)";
		
		
		Pattern patternTen = Pattern.compile(regexTen);
		Matcher matcherTen = patternTen.matcher(ten);
		
		Pattern patternSDT = Pattern.compile(regexSDT);
		Matcher matcherSDT = patternSDT.matcher(sdt);
		
		Pattern patternCCCD = Pattern.compile(regexCCCD);
		Matcher matcherCCCD = patternCCCD.matcher(cccd);
		
		if(o.equals(txt_TenNhanVien)) {
			if(matcherTen.find()) {
				lblTen.setVisible(false);
			} else {
				lblTen.setVisible(true);
			}
		}
		
		if(o.equals(txt_SoDienThoai)) {
			if(matcherSDT.find()) {
				lblSDT.setVisible(false);
			} else {
				lblSDT.setVisible(true);
			}
		}
		
		if(o.equals(txt_DiaChi)) {
			if(txt_DiaChi.getText() != "") {
				lblDiaChi.setVisible(false);
			} else {
				lblDiaChi.setVisible(true);
			}
		}
		
		if(o.equals(txt_CCCD)) {
			System.out.println(12);
			if(matcherCCCD.find()) {
				lblCCCD.setVisible(false);  
			} else {
				lblCCCD.setVisible(true);
			}
		}
	}
}
