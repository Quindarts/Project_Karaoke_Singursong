package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import ConnectDB.ConnectDB;
import DAO.LoaiPhong_DAO;
import DAO.Phong_DAO;
import DAO.TaiKhoan_DAO;
import Entity.LoaiPhong;
import Entity.Phong;
import Entity.TaiKhoan;
import OtherFunction.HelpForgotPwd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ForgotPwd extends JFrame {

	private JPanel contentPane;
	private JTextField txt_tk;
	private JTextField txt_maSN;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JTextField txt_newPwd;
	private JTextField txt_repeatPwd;
	private JButton btn_changePwd;
	private int flag = 0;
	private JButton btn_confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPwd frame = new ForgotPwd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					ConnectDB.getInstance().connect();
//					System.out.println("Connected!!!!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForgotPwd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quên mật khẩu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(252, 36, 202, 39);
		contentPane.add(lblNewLabel);

		txt_tk = new JTextField();
		txt_tk.setBounds(164, 85, 209, 32);
		contentPane.add(txt_tk);
		txt_tk.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tài khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(66, 89, 84, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ma xác nhận");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(34, 158, 116, 19);
		contentPane.add(lblNewLabel_1_1);

		txt_maSN = new JTextField();
		txt_maSN.setColumns(10);
		txt_maSN.setBounds(164, 154, 209, 32);
		contentPane.add(txt_maSN);

		lblNewLabel_1_2 = new JLabel("password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(66, 224, 84, 19);
		contentPane.add(lblNewLabel_1_2);

		lblNewLabel_1_3 = new JLabel("new password");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(34, 281, 116, 19);
		contentPane.add(lblNewLabel_1_3);

		txt_newPwd = new JTextField();
		txt_newPwd.setColumns(10);
		txt_newPwd.setBounds(164, 220, 209, 32);
		contentPane.add(txt_newPwd);
		txt_newPwd.setEditable(false);
		
		txt_repeatPwd = new JTextField();
		txt_repeatPwd.setColumns(10);
		txt_repeatPwd.setBounds(164, 277, 209, 32);
		txt_repeatPwd.setEditable(false);
		contentPane.add(txt_repeatPwd);
		
		
		btn_changePwd = new JButton("Đổi mật khẩu");
		btn_changePwd.setBounds(463, 282, 125, 39);
		contentPane.add(btn_changePwd);
		btn_changePwd.setEnabled(false);
		
		btn_confirm = new JButton("Xác nhận");
		btn_confirm.setBounds(463, 233, 125, 39);
		btn_confirm.setEnabled(true);
		contentPane.add(btn_confirm);

		btn_confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String sdt = txt_tk.getText();
				String confirm_code = txt_maSN.getText();
				String newPass = txt_newPwd.getText();
				String repeatPwd = txt_repeatPwd.getText();

				TaiKhoan tk = new TaiKhoan();
				TaiKhoan_DAO DAO_TK = new TaiKhoan_DAO();
				tk = DAO_TK.timTaiKhoan_TheoTKNhanVien(sdt);
				
				if(!sdt.equals("") && tk.gettenDangNhap().equals(sdt)) {
					HelpForgotPwd.updatePwd(sdt);
					txt_newPwd.setEditable(true);
					txt_repeatPwd.setEditable(true);
				}	
				btn_changePwd.setEnabled(true);
				btn_confirm.setEnabled(false);
			}
		});
		
		btn_changePwd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String sdt = txt_tk.getText();
				String confirm_code = txt_maSN.getText();
				String newPass = txt_newPwd.getText();
				String repeatPwd = txt_repeatPwd.getText();

				TaiKhoan tk = new TaiKhoan();
				TaiKhoan_DAO DAO_TK = new TaiKhoan_DAO();
				tk = DAO_TK.timTaiKhoan_TheoTKNhanVien(sdt);
				System.out.println(tk.gettenDangNhap());
				
				
				if(repeatPwd.equals(newPass) && !newPass.equals("")) {
					DAO_TK.capNhatTaiKhoan_TheoTenDangNhap(sdt, newPass);
				}		
			}
		});
	}
}
