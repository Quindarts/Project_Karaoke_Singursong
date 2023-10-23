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


public class Modal_ThemKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txt__MaKH;
	private JTextField txt__TenKH;
	private JTextField txt__DiaChi;
	private JLabel lbl__TenKH;
	private ButtonGroup btngr__gioiTinh;
	private JTextField txt__SDT;
	private Object dateNgaySinh;
	
    private final SimpleDateFormat ngaySinh = new SimpleDateFormat("yyyy-MM-dd");

	public Modal_ThemKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(5, 0, 926, 358);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/****/
		btngr__gioiTinh = new ButtonGroup();
						//
						JLabel lbl__NgaySinh = new JLabel("Ngày Sinh");
						lbl__NgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
						lbl__NgaySinh.setBounds(43, 159, 96, 27);
						panel_1.add(lbl__NgaySinh);
						
								JLabel lbl__gioiTinh = new JLabel("Giới Tính");
								lbl__gioiTinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
								lbl__gioiTinh.setBounds(43, 206, 70, 27);
								panel_1.add(lbl__gioiTinh);
						
								lbl__TenKH = new JLabel("Tên Khách Hàng");
								lbl__TenKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
								lbl__TenKH.setBounds(43, 111, 119, 25);
								panel_1.add(lbl__TenKH);
				
						txt__MaKH = new JTextField();
						txt__MaKH.setBounds(172, 67, 255, 25);
						panel_1.add(txt__MaKH);
						txt__MaKH.setColumns(10);
		
				txt__TenKH = new JTextField();
				txt__TenKH.setBounds(172, 112, 255, 25);
				panel_1.add(txt__TenKH);
				txt__TenKH.setColumns(50);
		
				JLabel lbl__MaKH = new JLabel("Mã Khách Hàng");
				lbl__MaKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
				lbl__MaKH.setBounds(43, 61, 119, 35);
				panel_1.add(lbl__MaKH);
								
										txt__SDT = new JTextField();
										txt__SDT.setBounds(604, 116, 255, 25);
										panel_1.add(txt__SDT);
								
										txt__DiaChi = new JTextField();
										txt__DiaChi.setBounds(604, 70, 255, 25);
										panel_1.add(txt__DiaChi);
										txt__DiaChi.setColumns(10);
								
								JButton btn__exit = new JButton("Thoát");
								btn__exit.setBounds(763, 304, 96, 30);
								panel_1.add(btn__exit);
						
								JLabel lbl__GhiChu = new JLabel("Ghi Chú");
								lbl__GhiChu.setFont(new Font("Segoe UI", Font.BOLD, 13));
								lbl__GhiChu.setBounds(493, 155, 60, 37);
								panel_1.add(lbl__GhiChu);
						
						JButton btn__Save = new JButton("Lưu");
						btn__Save.setBounds(642, 304, 96, 30);
						panel_1.add(btn__Save);
				
						JLabel lbl__DiaChi = new JLabel("Địa Chỉ");
						lbl__DiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
						lbl__DiaChi.setBounds(493, 115, 49, 25);
						panel_1.add(lbl__DiaChi);
		
				JLabel lbl__SDT = new JLabel("Số Điện Thoại");
				lbl__SDT.setFont(new Font("Segoe UI", Font.BOLD, 13));
				lbl__SDT.setBounds(489, 67, 109, 30);
				panel_1.add(lbl__SDT);

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
		panel_1.add(txtA__GhiChu);
		
				JRadioButton rdbt__nu = new JRadioButton("Nữ");
				rdbt__nu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rdbt__nu.setBounds(290, 209, 70, 21);
				panel_1.add(rdbt__nu);
				btngr__gioiTinh.add(rdbt__nu);
				JRadioButton rdbt__nam = new JRadioButton("Nam");
				rdbt__nam.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rdbt__nam.setBounds(172, 209, 78, 21);
				panel_1.add(rdbt__nam);
				
						btngr__gioiTinh.add(rdbt__nam);
						
								JLabel lbl__tieuDe = new JLabel("Thêm Khách Hàng Mới");
								lbl__tieuDe.setBounds(43, 10, 849, 39);
								panel_1.add(lbl__tieuDe);
								lbl__tieuDe.setFont(new Font("Segoe UI", Font.BOLD, 16));
								
								JDateChooser dateChooser = new JDateChooser();
								dateChooser.setBounds(172, 159, 255, 25);
								panel_1.add(dateChooser);
	}
}
