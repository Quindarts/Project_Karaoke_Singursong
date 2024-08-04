package gui;

import java.awt.EventQueue;

import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EtchedBorder;

import com.formdev.flatlaf.FlatLightLaf;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import other.HelpForgotPwd;

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
public class JFrame_DoiMatKhau extends JFrame implements KeyListener, ItemListener {

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
	private JPanel panelLogin;
	private JButton btnSave;
	private JButton btnExit;
	private NhanVien_DAO NV_DAO;
	private TaiKhoan taiKhoanDangNhap;
	private TaiKhoan_DAO TK_DAO;
	private JPasswordField txt_newPwd;
	private JPasswordField txt_repeatNewPwd;
	private TaiKhoan tk;
	private JCheckBox CBHienMatKhau;
	private JLabel lblPassword_1;
	private JLabel lblPassword;
	private JLabel lblPassword_2;
	private JPasswordField txt_Pwd;

	/**
	 * Create the frame.
	 */
	public JFrame_DoiMatKhau(TaiKhoan taiKhoan) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 370);
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
		panelLogin.setBackground(new Color(255, 255, 255));
		panelLogin.setBounds(0, 0, 431, 337);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lblTitleLogin = new JLabel("ĐỔI MẬT KHẨU");
		lblTitleLogin.setForeground(Color.decode(hexColor_Blue1));
		lblTitleLogin.setBackground(new Color(255, 255, 255));
		lblTitleLogin.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLogin.setBounds(34, 21, 357, 49);

		panelLogin.add(lblTitleLogin);

		btnSave = new JButton("Xác nhận");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.decode(hexColor_Green));
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSave.setBounds(34, 295, 156, 35);
		panelLogin.add(btnSave);

		btnExit = new JButton("Thoát");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.decode(hexColor_Red));
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnExit.setBounds(208, 295, 144, 35);
		panelLogin.add(btnExit);
		panelLogin.setBorder(new RoundedTransparentBorder(25, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));

		CBHienMatKhau = new JCheckBox("Hiện mật khẩu");
		CBHienMatKhau.setBackground(new Color(255, 255, 255));
		CBHienMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		CBHienMatKhau.setBounds(241, 250, 111, 21);
		panelLogin.add(CBHienMatKhau);

		txt_newPwd = new JPasswordField();
		txt_newPwd.setColumns(10);
		txt_newPwd.setBounds(178, 175, 174, 25);
		panelLogin.add(txt_newPwd);

		txt_repeatNewPwd = new JPasswordField();
		txt_repeatNewPwd.setColumns(10);
		txt_repeatNewPwd.setBounds(178, 210, 174, 25);
		panelLogin.add(txt_repeatNewPwd);

		lblPassword_1 = new JLabel("Mật khẩu");
		lblPassword_1.setForeground(new Color(5, 74, 145));
		lblPassword_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword_1.setBounds(24, 126, 99, 25);
		panelLogin.add(lblPassword_1);

		lblPassword = new JLabel("Mật khẩu mới");
		lblPassword.setForeground(new Color(5, 74, 145));
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword.setBounds(24, 173, 99, 25);
		panelLogin.add(lblPassword);

		lblPassword_2 = new JLabel("Lập lại mật khẩu mới");
		lblPassword_2.setForeground(new Color(5, 74, 145));
		lblPassword_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword_2.setBounds(24, 210, 142, 25);
		panelLogin.add(lblPassword_2);

		txt_Pwd = new JPasswordField();
		txt_Pwd.setColumns(10);
		txt_Pwd.setBounds(178, 126, 174, 25);
		panelLogin.add(txt_Pwd);

		// Import image logo

		ImageIcon imageLogo = new ImageIcon(JFrame_DangNhap.class.getResource("/icon/Logo_Blue.png"));

		Image scaled_imageLogo = imageLogo.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
		imageLogo = new ImageIcon(scaled_imageLogo);

		CBHienMatKhau.addItemListener(this);

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] passwordChars = txt_Pwd.getPassword();
				char[] passwordCharsNew = txt_newPwd.getPassword();
				char[] passwordRepeatChars = txt_repeatNewPwd.getPassword();

				// Chuyển mảng ký tự thành chuỗi (nếu cần)
				String password = new String(passwordChars);
				String passwordNew = new String(passwordCharsNew);
				String passwordRepeat = new String(passwordRepeatChars);
				if (password.trim().equals(taiKhoan.getMatKhau().trim())) {
					if (!passwordNew.trim().equals("") || !passwordRepeat.trim().equals("")) {
						if ((password.trim().length() >= 8 && password.trim().matches("\\d+"))
								&& (passwordRepeat.trim().length() >= 8 && passwordRepeat.trim().matches("\\d+"))) {
							if (passwordNew.trim().equals(passwordRepeat.trim())) {
								TK_DAO = new TaiKhoan_DAO();
								TK_DAO.capNhatTaiKhoan_TheoTenDangNhap(taiKhoan.gettenDangNhap(), passwordNew.trim());
								JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "Mật khẩu không khớp");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Mật khẩu phải lơn hơn 8 ký tự và gồm số");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Mật khẩu mới không được rỗng");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không đúng");
				}
			}
		});

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Xử lý khi nút được nhấn
				setVisible(false);
			}
		});
	}

	/**
	 * Event Button
	 */

	/**
	 * @return validateTaiKhoan
	 */

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
			txt_newPwd.setEchoChar(CBHienMatKhau.isSelected() ? '\u0000' : '*');
			txt_repeatNewPwd.setEchoChar(CBHienMatKhau.isSelected() ? '\u0000' : '*');
			txt_Pwd.setEchoChar(CBHienMatKhau.isSelected() ? '\u0000' : '*');
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			char echoChar = CBHienMatKhau.isSelected() ? '\u0000' : '*';
			txt_newPwd.setEchoChar(echoChar);
			txt_repeatNewPwd.setEchoChar(echoChar);
			txt_Pwd.setEchoChar(echoChar);
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		
//		if(o.equals(btnSave)) {
//			TK_DAO.capNhatTaiKhoan_TheoTenDangNhap("sdfsaf", txt_newPwd.getText().trim());
//		}
//		
//		if(o.equals(btnExit)) {
//			setVisible(false);
//		}
//	}
}