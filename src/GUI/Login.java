package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

public class Login extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtPass;
	private JButton btnLogin;
	private JLabel lblTextHelpLogin;
	private JLabel lblTextHelpPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	    if(o.equals(btnLogin)) {
	        String username = txtLogin.getText();
	        String password = txtPass.getText();
	        
	        if (username.isEmpty() || password.isEmpty()) {
				if(username.isEmpty()) {
					lblTextHelpLogin.setVisible(true);
					lblTextHelpLogin.setText("Không được để trống!");
					lblTextHelpLogin.setForeground(Color.RED);
				} 
				if(password.isEmpty()) {
					lblTextHelpPass.setVisible(true);
					lblTextHelpPass.setText("Không được để trống!");
					lblTextHelpPass.setForeground(Color.RED);
				}
	        }  
	        if(!username.trim().equals("0935019843") && username.length() <= 10) {
	        	System.out.println("Tên đăng nhập không hợp lệ");
	        	lblTextHelpLogin.setVisible(true);
				lblTextHelpLogin.setText("Tài khoản không đúng!");
				lblTextHelpLogin.setForeground(Color.RED);
	        } 
	        
	        if(!password.trim().equals("NhanVien_1")){
	        	System.out.println("Mật khẩu không hợp lệ");
	        	lblTextHelpPass.setVisible(true);
	        	lblTextHelpPass.setText("Mật khẩu không đúng!");
	        	lblTextHelpPass.setForeground(Color.RED);
	        } 
	         
	        if(password.trim().equals("NhanVien_1")) {
	        	lblTextHelpPass.setVisible(false);
	        }
	        
	        if(username.trim().equals("0935019843") && password.trim().equals("NhanVien_1")) {
	        	System.out.println("Đăng nhập thành công");
	        	lblTextHelpPass.setVisible(false);
	        	lblTextHelpLogin.setVisible(false);
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
		String username = txtLogin.getText();
        String password = txtPass.getText();
		if(username.length() >= 10) {
			System.out.println("hiện" + username.length());
			lblTextHelpLogin.setText("mật khẩu quá 10 ký tự!");
			lblTextHelpLogin.setVisible(true);
			lblTextHelpLogin.setForeground(Color.RED);
		} else if(username.length() <= 12 && !containsSpecialCharacters(username)) {
			System.out.println("ẩn" + username.length());
			lblTextHelpLogin.setVisible(false);
		} else if(containsSpecialCharacters(username)) {
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
	
}
