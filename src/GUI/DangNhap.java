package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EtchedBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.desktop.PrintFilesEvent;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
   
    
	/**
	 * Radius
	 */
	public class DangNhap extends JFrame {
	
		private JPanel contentPane;
		
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
	
	            RoundRectangle2D.Float roundRect = new RoundRectangle2D.Float(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
	
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
	 * Field
	 */
	private JTextField txtPassword;
	private JTextField txtUsername;
	private JPanel panelLogin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatLightLaf.setup();
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {
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
//		setUndecorated(true);
//		panelLogin.setShape(new RoundRectangle2D.Double(0, 0, 500, 368, 30,30));
//		p.getRootPane().setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.getColor("#333")));

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
		
		JLabel lblUsername = new JLabel("Số điện thoại");
		lblUsername.setForeground(Color.decode(hexColor_Blue1));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsername.setBounds(25, 115, 111, 25);
		panelLogin.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.decode(hexColor_Blue1));
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword.setBounds(25, 175, 111, 25);
		panelLogin.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(133, 175, 219, 25);
		panelLogin.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(133, 115, 219, 25);
		panelLogin.add(txtUsername);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.decode(hexColor_Blue1));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLogin.setBounds(25, 263, 327, 35);
		panelLogin.add(btnLogin);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.decode(hexColor_Red));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnExit.setBounds(25, 318, 327, 35);
		panelLogin.add(btnExit);
		panelLogin.setBorder(new RoundedTransparentBorder(25, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		
		JCheckBox CBHienMatKhau = new JCheckBox("Hiện mật khẩu");
		CBHienMatKhau.setBackground(new Color(255, 255, 255));
		CBHienMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		CBHienMatKhau.setBounds(130, 205, 111, 21);
		panelLogin.add(CBHienMatKhau);
		
		/**
		 * Create JPanel for Logo (left).
		 */ 
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBorder(UIManager.getBorder("RadioButtonMenuItem.border"));
		panelLogo.setBackground(Color.decode(hexColor_Blue1));
		panelLogo.setBounds(10, 20, 400, 450);
		contentPane.add(panelLogo);
		
		//Import image logo
		ImageIcon imageLogo = new ImageIcon(DangNhap.class.getResource("/icon/Logo/Logo_Blue.png")) ;
            // Đọc hình ảnh từ tệp và tạo một JLabel để hiển thị nó
          	Image scaled_imageLogo = imageLogo.getImage().getScaledInstance(400, 450, Image.SCALE_SMOOTH);
            imageLogo = new ImageIcon(scaled_imageLogo);
            
            JLabel lblLogo = new JLabel("");
            lblLogo.setIcon(imageLogo);
            lblLogo.setBounds(-20, 10, 468, 472);
            panelLogo.add(lblLogo);
       
		
	}
}
