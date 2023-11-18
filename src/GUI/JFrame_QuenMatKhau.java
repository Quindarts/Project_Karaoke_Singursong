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
import OtherFunction.HelpForgotPwd;

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
public class JFrame_QuenMatKhau extends JFrame implements ActionListener, KeyListener, ItemListener {

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
	private String hexColor_Green = "#4BAC4D";

	
	private JTextField txtUsername;
	private JPanel panelLogin;
	private JButton btnSave;
	private JButton btnExit;
	private NhanVien_DAO NV_DAO;
	private TaiKhoan taiKhoanDangNhap;
	private TaiKhoan_DAO TK_DAO;
	private JFrame_ThuNgan thuNgan;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordRepeat;
	private JTextField txtAccess;
	private TaiKhoan tk;
	private JCheckBox CBHienMatKhau;

	/**
	 * Create the frame.
	 */
	public JFrame_QuenMatKhau() {

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

		JLabel lblTitleLogin = new JLabel("QUÊN MẬT KHẨU");
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

		JLabel lblAccess = new JLabel("Mã xác nhận");
		lblAccess.setForeground(Color.decode(hexColor_Blue1));
		lblAccess.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAccess.setBounds(25, 175, 111, 25);
		panelLogin.add(lblAccess);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(133, 115, 219, 25);
		panelLogin.add(txtUsername);

		btnSave = new JButton("Gửi mã xác nhận");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.decode(hexColor_Green));
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSave.setBounds(25, 363, 327, 35);
		panelLogin.add(btnSave);

		btnExit = new JButton("Thoát");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.decode(hexColor_Red));
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnExit.setBounds(25, 408, 327, 35);
		panelLogin.add(btnExit);
		panelLogin.setBorder(new RoundedTransparentBorder(25, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(new Color(5, 74, 145));
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword.setBounds(25, 235, 111, 25);
		panelLogin.add(lblPassword);
		
		CBHienMatKhau = new JCheckBox("Hiện mật khẩu");
		CBHienMatKhau.setBackground(new Color(255, 255, 255));
		CBHienMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		CBHienMatKhau.setBounds(133, 324, 111, 21);
		panelLogin.add(CBHienMatKhau);

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(133, 235, 219, 25);
		txtPassword.setEnabled(false);
		panelLogin.add(txtPassword);

		JLabel lblPasswordRepeat = new JLabel("Mật khẩu mới");
		lblPasswordRepeat.setForeground(new Color(5, 74, 145));
		lblPasswordRepeat.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPasswordRepeat.setBounds(25, 291, 111, 25);
		panelLogin.add(lblPasswordRepeat);

		txtPasswordRepeat = new JPasswordField();
		txtPasswordRepeat.setColumns(10);
		txtPasswordRepeat.setBounds(133, 293, 219, 25);
		txtPasswordRepeat.setEnabled(false);
		panelLogin.add(txtPasswordRepeat);

		txtAccess = new JTextField();
		txtAccess.setColumns(10);
		txtAccess.setBounds(133, 177, 219, 25);
		txtAccess.setEnabled(false);
		panelLogin.add(txtAccess);

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

		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
		CBHienMatKhau.addItemListener(this);
	}

	/**
	 * Event Button
	 */
	public void actionPerformed(ActionEvent e) {
		String btnText = btnSave.getText();
		tk = new TaiKhoan();
		TK_DAO = new TaiKhoan_DAO();
		String tenTK = txtUsername.getText();
		tk = TK_DAO.timTaiKhoan_TheoTenDangNhap(tenTK);

		// SUBMIT
		if ("Gửi mã xác nhận".equals(btnText) && tk != null) {
			HelpForgotPwd.updatePwd(tk.gettenDangNhap());
			txtAccess.setEnabled(true);
			btnSave.setText("Xác nhận mã");
		}

		if ("Xác nhận mã".equals(btnText)) {
			if (txtAccess.getText().trim().equals(tk.getMatKhau().trim())) {
				txtPassword.setEnabled(true);
				txtPasswordRepeat.setEnabled(true);
				btnSave.setText("Đổi mật khẩu");
			}
		}

		if ("Đổi mật khẩu".equals(btnText)) {
			char[] passwordChars = txtPassword.getPassword();
			char[] passwordRepeatChars = txtPasswordRepeat.getPassword();

			// Chuyển mảng ký tự thành chuỗi (nếu cần)
			String password = new String(passwordChars);
			String passwordRepeat = new String(passwordRepeatChars);

			if (password.equals(passwordRepeat) && (!password.equals("") && !passwordRepeat.equals(""))) {
//				System.out.println("đã đổi");
//				System.out.println(tk.gettenDangNhap());
//				System.out.println(tk.getNhanVien().getMaNhanVien());
//				System.out.println(password);
				TK_DAO.capNhatTaiKhoan_TheoTenDangNhap(tk.gettenDangNhap(), password);
//				System.out.println(TK_DAO.capNhatTaiKhoan_TheoTenDangNhap(tk.gettenDangNhap(), password));
				if (!TK_DAO.capNhatTaiKhoan_TheoTenDangNhap(tk.gettenDangNhap(), password)) {
					JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
					setVisible(false);
					JFrame_DangNhap dangNhap = new JFrame_DangNhap();
					dangNhap.setVisible(true);
				}

			}
		}
		
		Object o = e.getSource();
		if (o.equals(btnExit)) {
			JFrame_DangNhap dangNhap = new JFrame_DangNhap();
			dangNhap.setVisible(true);
			setVisible(false);
		}
	}

	/**
	 * @return validateTaiKhoan
	 */
	public boolean validateTaiKhoan() {
		String tenDangNhap = txtUsername.getText();
		String matKhau = txtAccess.getText();

		// Kt tên
		if (matKhau.length() == 0) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không để trống !");
			txtAccess.requestFocus();
			txtAccess.selectAll();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {            
            txtPassword.setEchoChar(CBHienMatKhau.isSelected() ? '\u0000' : '*');
            txtPasswordRepeat.setEchoChar(CBHienMatKhau.isSelected() ? '\u0000' : '*');
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
        	char echoChar = CBHienMatKhau.isSelected() ? '\u0000' : '*';
            txtPassword.setEchoChar(echoChar);
            txtPasswordRepeat.setEchoChar(echoChar);
        }
	}
}