package GUI;

import java.awt.EventQueue;

import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EtchedBorder;

import com.formdev.flatlaf.FlatLightLaf;

import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import Entity.NhanVien;
import Entity.TaiKhoan;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.desktop.PrintFilesEvent;

import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * JFrame_DangNhap NguyenNga ThienTu
 */
public class JFrame_DangNhap extends JFrame implements ActionListener, KeyListener, MouseListener, ItemListener {

	private JPanel contentPane;

	/**
	 * Rounded JPanel
	 */
	public class RoundedTransparentBorder extends AbstractBorder {
		private int cornerRadius;
		private Color borderColor;
		private Color backgroundColor;
		private float alpha;

		public RoundedTransparentBorder(int cornerRadius, Color borderColor, Color backgroundColor, float alpha) {
			this.cornerRadius = cornerRadius;
			this.borderColor = borderColor;
			this.backgroundColor = backgroundColor;
			this.alpha = alpha;
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
		}

		@Override
		public Insets getBorderInsets(Component c, Insets insets) {
			insets.left = insets.top = insets.right = insets.bottom = cornerRadius;
			return insets;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			if (width <= 0 || height <= 0) {
				return;
			}

			Graphics2D g2d = (Graphics2D) g.create();

			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

			RoundRectangle2D.Float roundRect = new RoundRectangle2D.Float(x, y, width - 1, height - 1, cornerRadius,
					cornerRadius);

			g2d.setColor(backgroundColor);
			g2d.fill(roundRect);
			g2d.setColor(borderColor);
			g2d.draw(roundRect);

			g2d.dispose();
		}

	}

	/**
	 * Color
	 */

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	/**
	 * Component
	 */
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JPanel panelLogin;
	private JButton btnLogin;
	private JButton btnExit;
	private NhanVien_DAO NV_DAO;
	private TaiKhoan taiKhoanDangNhap;
	private TaiKhoan_DAO TK_DAO;
	private JFrame_ThuNgan thuNgan;
	private JLabel lblForgotPass;
	private JCheckBox CBHienMatKhau;

	/**
	 * Create the frame.
	 */
	public JFrame_DangNhap() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode(hexColor_Blue1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		/**
		 * Create JPanel for login (right).
		 */
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.decode(hexColor_Blue1));
		panelLogin.setBounds(452, 31, 377, 466);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lblTitleLogin = new JLabel("ĐĂNG NHẬP");
		lblTitleLogin.setForeground(Color.decode(hexColor_Blue1));
		lblTitleLogin.setBackground(new Color(255, 255, 255));
		lblTitleLogin.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLogin.setBounds(10, 22, 357, 49);

		panelLogin.add(lblTitleLogin);

		JLabel lblUsername = new JLabel("Mã nhân viên");
		lblUsername.setForeground(Color.decode(hexColor_Blue1));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsername.setBounds(25, 115, 111, 25);
		panelLogin.add(lblUsername);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.decode(hexColor_Blue1));
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword.setBounds(25, 160, 111, 25);
		panelLogin.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(133, 160, 219, 25);
		txtPassword.setColumns(10);
		txtPassword.setText("123456");
		panelLogin.add(txtPassword);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(133, 115, 219, 25);
		txtUsername.setText("NV56920002");
		panelLogin.add(txtUsername);

		btnLogin = new JButton("Đăng nhập");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.decode(hexColor_Blue1));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLogin.setBounds(25, 264, 327, 35);
		panelLogin.add(btnLogin);

		btnExit = new JButton("Thoát");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.decode(hexColor_Red));
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnExit.setBounds(25, 320, 327, 35);
		panelLogin.add(btnExit);
		panelLogin.setBorder(new RoundedTransparentBorder(25, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));

		CBHienMatKhau = new JCheckBox("Hiện mật khẩu");
		CBHienMatKhau.setBackground(new Color(255, 255, 255));
		CBHienMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		CBHienMatKhau.setBounds(133, 198, 111, 21);
		panelLogin.add(CBHienMatKhau);

		lblForgotPass = new JLabel("Quên mật khẩu");
		lblForgotPass.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblForgotPass.setForeground(Color.decode(hexColor_Red));
		lblForgotPass.setBounds(141, 443, 100, 13);
		lblForgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelLogin.add(lblForgotPass);

		/**
		 * Create JPanel for Logo (left).
		 */

		JPanel panelLogo = new JPanel();
		panelLogo.setBorder(UIManager.getBorder("RadioButtonMenuItem.border"));
		panelLogo.setBackground(Color.decode(hexColor_Blue1));
		panelLogo.setBounds(10, 20, 400, 450);
		contentPane.add(panelLogo);

		// Import image logo

		ImageIcon imageLogo = new ImageIcon(JFrame_DangNhap.class.getResource("/icon/Logo_Blue.png"));

		Image scaled_imageLogo = imageLogo.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
		imageLogo = new ImageIcon(scaled_imageLogo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(imageLogo);
		lblLogo.setBounds(-20, 10, 468, 472);
		panelLogo.add(lblLogo);

		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		lblForgotPass.addMouseListener(this);
		CBHienMatKhau.addItemListener(this);
		txtUsername.addKeyListener(this);
		txtPassword.addKeyListener(this);
	}

	/**
	 * Event Button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// SUBMIT
		if (o.equals(btnLogin)) {

			if (validateTaiKhoan()) {

				Login();
			}
		}
		// BUTTON EXIT
		if (o.equals(btnExit)) {
			dispose();
		}
	}

	/**
	 * @return validateTaiKhoan
	 */
	public boolean validateTaiKhoan() {
		String tenDangNhap = txtUsername.getText();
		String matKhau = txtPassword.getText();

		// Kt tên
		if (matKhau.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không để trống !");
			txtPassword.requestFocus();
			txtPassword.selectAll();
			return false;
		}

		// Kt SĐT
		if (tenDangNhap.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tài khoản không được để trống !");
			txtUsername.requestFocus();
			txtUsername.selectAll();
			return false;
		} else {
			if (false) {
				JOptionPane.showMessageDialog(null, "Tài khoản không thỏa mãn");
				txtUsername.requestFocus();
				txtUsername.selectAll();
				return false;
			}
		}
		return true;
	}
	
	public void Login() {
		String username = txtUsername.getText();
		String password = txtPassword.getText();

		TK_DAO = new TaiKhoan_DAO();
		NV_DAO = new NhanVien_DAO();

		// Search TK in DB
		taiKhoanDangNhap = TK_DAO.timKiemTaiKhoan(username);

		NhanVien nhanVienDangNhap = new NhanVien();

		if (taiKhoanDangNhap == null) {
			JOptionPane.showMessageDialog(null, "Tài Khoản không tồn tại!");
		} else if (!taiKhoanDangNhap.getMatKhau().trim().equals(password)) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không đúng! ");
		} else {
			nhanVienDangNhap = NV_DAO
					.timNhanVien_TheoMaNhanVien(taiKhoanDangNhap.getNhanVien().getMaNhanVien());
			String role = nhanVienDangNhap.getloaiNhanVien().getMaLoaiNhanVien();
			if (taiKhoanDangNhap.isTrangThai()) {
				thuNgan = new JFrame_ThuNgan(nhanVienDangNhap);
				thuNgan.setVisible(true);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Bạn đã nghĩ làm!");
			}
//			dispose();

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (validateTaiKhoan()) {
				Login();
			}
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

//	--------------mouse event

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JFrame_QuenMatKhau quenmk = new JFrame_QuenMatKhau();
		quenmk.setVisible(true);
		setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			txtPassword.setEchoChar(CBHienMatKhau.isSelected() ? '\u0000' : '*');
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			char echoChar = CBHienMatKhau.isSelected() ? '\u0000' : '*';
			txtPassword.setEchoChar(echoChar);
		}
	}
}