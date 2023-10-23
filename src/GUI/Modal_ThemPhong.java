package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.Choice;
import javax.swing.JScrollBar;
import com.toedter.components.JSpinField;


public class Modal_ThemPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txt__MaPhong;
	private JTextField txt__TenKhachHang;
	private JLabel lbl__TenPhong;
	private ButtonGroup btngr__gioiTinh;
	private Object dateNgaySinh;
	
    private final SimpleDateFormat ngaySinh = new SimpleDateFormat("yyyy-MM-dd");

	public Modal_ThemPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(22, 0, 926, 358);
		contentPane.add(panel_1);

		/****/
		btngr__gioiTinh = new ButtonGroup();
						panel_1.setLayout(null);
						//
						JLabel lbl__LoaiPhong = new JLabel("Loại Phòng");
						lbl__LoaiPhong.setBounds(43, 159, 96, 27);
						lbl__LoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
						panel_1.add(lbl__LoaiPhong);
						
								lbl__TenPhong = new JLabel("Tên phòng");
								lbl__TenPhong.setBounds(43, 111, 119, 25);
								lbl__TenPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
								panel_1.add(lbl__TenPhong);
				
						txt__MaPhong = new JTextField();
						txt__MaPhong.setEditable(false);
						txt__MaPhong.setBounds(172, 65, 255, 25);
						panel_1.add(txt__MaPhong);
						txt__MaPhong.setColumns(10);
		
				txt__TenKhachHang = new JTextField();
				txt__TenKhachHang.setBounds(172, 110, 255, 25);
				panel_1.add(txt__TenKhachHang);
				txt__TenKhachHang.setColumns(50);
		
				JLabel lbl__MaPhong = new JLabel("Mã phòng");
				lbl__MaPhong.setBounds(43, 61, 119, 35);
				lbl__MaPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
				panel_1.add(lbl__MaPhong);
								
								JButton btn__exit = new JButton("Bỏ qua");
								btn__exit.setBounds(763, 304, 96, 30);
								panel_1.add(btn__exit);
						
								JLabel lbl__GhiChu = new JLabel("Ghi Chú");
								lbl__GhiChu.setBounds(493, 155, 60, 37);
								lbl__GhiChu.setFont(new Font("Segoe UI", Font.BOLD, 13));
								panel_1.add(lbl__GhiChu);
						
						JButton btn__Save = new JButton("Lưu");
						btn__Save.setBounds(642, 304, 96, 30);
						panel_1.add(btn__Save);
				
						JLabel lbl_NgayTaoPhong = new JLabel("Ngày tạo phòng");
						lbl_NgayTaoPhong.setBounds(493, 115, 105, 25);
						lbl_NgayTaoPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
						panel_1.add(lbl_NgayTaoPhong);
		
				JLabel lbl_ViTriPhong = new JLabel("Vị trí phòng");
				lbl_ViTriPhong.setBounds(489, 67, 109, 30);
				lbl_ViTriPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
				panel_1.add(lbl_ViTriPhong);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(641, 42, 0, 0);
		panel_1.add(verticalBox_1);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_4);
		

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_6);

		JTextArea txtA__GhiChu = new JTextArea();
		txtA__GhiChu.setBounds(604, 161, 255, 72);
		txtA__GhiChu.setBackground(new Color(255, 255, 255));
		txtA__GhiChu.setLineWrap(true);
		panel_1.add(txtA__GhiChu);
						
								JLabel lbl__tieuDe = new JLabel("Thêm phòng mới");
								lbl__tieuDe.setBounds(43, 10, 849, 39);
								panel_1.add(lbl__tieuDe);
								lbl__tieuDe.setFont(new Font("Segoe UI", Font.BOLD, 16));
								
								Choice choice_LoaiPhong = new Choice();
								choice_LoaiPhong.setBounds(172, 155, 255, 18);
								panel_1.add(choice_LoaiPhong);
								
								JDateChooser dateChooser = new JDateChooser();
								dateChooser.setBounds(642, 117, 217, 19);
								panel_1.add(dateChooser);
								
								Choice choice_ViThiPhong = new Choice();
								choice_ViThiPhong.setBounds(642, 72, 217, 25);
								panel_1.add(choice_ViThiPhong);
	}
}
