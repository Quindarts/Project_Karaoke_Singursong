package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDB.ConnectDB;
import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import Entity.NhanVien;
import Entity.TaiKhoan;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

public class Login extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtPass;
	private JButton btnLogin;
	private JLabel lblTextHelpLogin;
	private JLabel lblTextHelpPass;
	private String username;
	private String password;
	private NhanVien_DAO testNV;
	private TaiKhoan Quang;
	private TaiKhoan_DAO testAcc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					ConnectDB.getInstance().connect();
					System.out.println("Connected!!!!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLogin = new JTextField();
		txtLogin.setBounds(207, 94, 239, 37);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(207, 169, 245, 37);
		contentPane.add(txtPass);
		txtPass.setColumns(10);

		btnLogin = new JButton("Login");
//		btnLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnLogin.setBounds(378, 244, 119, 45);
		contentPane.add(btnLogin);

		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(117, 100, 72, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("mật khẩu");
		lblNewLabel_1.setBounds(117, 175, 81, 25);
		contentPane.add(lblNewLabel_1);

		lblTextHelpLogin = new JLabel("helptext");
		lblTextHelpLogin.setBounds(207, 141, 375, 13);
		contentPane.add(lblTextHelpLogin);
		lblTextHelpLogin.setVisible(false);

		lblTextHelpPass = new JLabel("helptext");
		lblTextHelpPass.setBounds(207, 216, 375, 13);
		contentPane.add(lblTextHelpPass);
		lblTextHelpPass.setVisible(false);

		btnLogin.addActionListener(this);
		txtLogin.addKeyListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogin)) {
			if (validateTaiKhoan()) {
				String username = txtLogin.getText();
				String password = txtPass.getText();
				testAcc = new TaiKhoan_DAO();
				System.out.println(password);
				Quang = testAcc.timKiemTaiKhoan(username, password);
				testNV = new NhanVien_DAO();
				NhanVien NVQuang;
				if (Quang == null) {
					JOptionPane.showMessageDialog(null, "Tài Khoản không tồn tại !");
				} else {
					System.out.println(Quang.toString());
					System.out.println("Đăng nhập thành công");
					NVQuang = testNV.timNhanVienTheoMa(Quang.getMaNhanVien());
					System.out.println(NVQuang.toString());
					String role = NVQuang.getloaiNhanVien().getMaLoaiNhanVien();
					System.out.println("Đăng nhập vào màn hình" + role);
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		username = txtLogin.getText();
		password = txtPass.getText();
		if (username.length() >= 10) {
			System.out.println("hiện" + username.length());
			lblTextHelpLogin.setText("mật khẩu quá 10 ký tự!");
			lblTextHelpLogin.setVisible(true);
			lblTextHelpLogin.setForeground(Color.RED);
		} else if (username.length() <= 12 && !containsSpecialCharacters(username)) {
			System.out.println("ẩn" + username.length());
			lblTextHelpLogin.setVisible(false);
		} else if (containsSpecialCharacters(username)) {
			System.out.println("Không có kí tự đặt biệt!");
			lblTextHelpLogin.setText("Không có kí tự đặt biệt!");
			lblTextHelpLogin.setVisible(true);
			lblTextHelpLogin.setForeground(Color.RED);
		}

	}

	public static boolean containsSpecialCharacters(String input) {
		for (char c : input.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean validateTaiKhoan() {
		String tenDangNhap = txtLogin.getText();
		String matKhau = txtPass.getText();
		// Kt tên
		if (matKhau.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống !");
			txtPass.requestFocus();
			txtPass.selectAll();
			return false;
		}
		// Kt SĐT
		if (tenDangNhap.length() == 0) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống !");
			txtLogin.requestFocus();
			txtLogin.selectAll();
			return false;
		} else {
			if (!tenDangNhap.matches("[0-9]{10}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là chữ số và gồm 10 số !");
				txtLogin.requestFocus();
				txtLogin.selectAll();
				return false;
			}
		}

		return true;
	}

}