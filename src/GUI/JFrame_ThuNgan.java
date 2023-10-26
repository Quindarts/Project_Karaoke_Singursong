package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import Entity.NhanVien;
import GUI.JFrame_DangNhap.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;

public class JFrame_ThuNgan extends JFrame {

	private JPanel_QuanLyDatPhong Panel_QLDP;
	private JPanel_QuanLyKhachHang Panel_QLKH;

	/**
	 * Color
	 */

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";

	private JPanel contentPane;
	private JPanel panel_Menu;
	private JPanel panelMenu_QLDatPhong;
	private JPanel panelMenu_QLKhachHang;
	private JPanel panel_Function;
	private JLabel lblMenu_QLKhachHang;
	private JButton btnNewButton;
	private JPanel panelMenu_QLKhachHang_1;
	private JLabel lblMenu_PhieuDatPhong;
	private JPanel panelMenu_QLKhachHang_2;
	private JLabel lblMenu_PhieuDatPhong_1;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblDay;

	private JLabel lblClock;
	private int hour, min, sec;
	private JPanel panel_DateTime;
	private NhanVien nhanVien;
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
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame_ThuNgan frame = new JFrame_ThuNgan();
//					// Setup my app
//					FlatLightLaf.setup();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * 
	 */
	
	public JFrame_ThuNgan(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(hexColor_Blue1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel_QLDP = new JPanel_QuanLyDatPhong(nhanVien);
		Panel_QLKH = new JPanel_QuanLyKhachHang();
		Panel_QLKH.setBounds(0, 0, 1296, 672);

		panel_Menu = new JPanel();
		panel_Menu.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_Menu.setBackground(Color.decode(hexColor_Blue1));
//		panel_Menu.setBackground(Color.WHITE);
		panel_Menu.setBounds(10, 64, 197, 672);
		contentPane.add(panel_Menu);
		panel_Menu.setLayout(null);

		panelMenu_QLDatPhong = new JPanel();
		panelMenu_QLDatPhong.addMouseListener(new PanelButtonMouseAdapter(panelMenu_QLDatPhong) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(Panel_QLDP);
			}
		});
		panelMenu_QLDatPhong.setBounds(2, 103, 192, 45);
		panelMenu_QLDatPhong.setBackground(Color.decode(hexColor_Blue1));
		panel_Menu.add(panelMenu_QLDatPhong);
		panelMenu_QLDatPhong.setLayout(null);

		JLabel lblMenu_QLDatPhong = new JLabel("QUẢN LÝ ĐẶT PHÒNG");
		lblMenu_QLDatPhong.setForeground(Color.WHITE);
		lblMenu_QLDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLDatPhong.setBounds(10, 10, 166, 20);
		panelMenu_QLDatPhong.add(lblMenu_QLDatPhong);

		panelMenu_QLKhachHang = new JPanel();
		panelMenu_QLKhachHang.setBackground(Color.decode(hexColor_Blue1));
		panelMenu_QLKhachHang.addMouseListener(new PanelButtonMouseAdapter(panelMenu_QLKhachHang) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(Panel_QLKH);
			}
		});
		panelMenu_QLKhachHang.setBounds(2, 149, 192, 45);
		panel_Menu.add(panelMenu_QLKhachHang);
		panelMenu_QLKhachHang.setLayout(null);

		lblMenu_QLKhachHang = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblMenu_QLKhachHang.setForeground(Color.white);
		lblMenu_QLKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLKhachHang.setBounds(10, 10, 166, 20);
		panelMenu_QLKhachHang.add(lblMenu_QLKhachHang);

		panelMenu_QLKhachHang_1 = new JPanel();
		panelMenu_QLKhachHang_1.setLayout(null);
		panelMenu_QLKhachHang_1.setBackground(new Color(5, 74, 145));
		panelMenu_QLKhachHang_1.setBounds(2, 195, 192, 45);
		panel_Menu.add(panelMenu_QLKhachHang_1);

		lblMenu_PhieuDatPhong = new JLabel("PHIẾU ĐẶT PHÒNG");
		lblMenu_PhieuDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_PhieuDatPhong.setForeground(Color.WHITE);
		lblMenu_PhieuDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_PhieuDatPhong.setBounds(10, 10, 166, 20);
		panelMenu_QLKhachHang_1.add(lblMenu_PhieuDatPhong);

		panelMenu_QLKhachHang_2 = new JPanel();
		panelMenu_QLKhachHang_2.setLayout(null);
		panelMenu_QLKhachHang_2.setBackground(new Color(5, 74, 145));
		panelMenu_QLKhachHang_2.setBounds(2, 241, 192, 45);
		panel_Menu.add(panelMenu_QLKhachHang_2);

		lblMenu_PhieuDatPhong_1 = new JLabel("HÓA ĐƠN");
		lblMenu_PhieuDatPhong_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_PhieuDatPhong_1.setForeground(Color.WHITE);
		lblMenu_PhieuDatPhong_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_PhieuDatPhong_1.setBounds(10, 10, 166, 20);
		panelMenu_QLKhachHang_2.add(lblMenu_PhieuDatPhong_1);

		panel_DateTime = new JPanel();
		panel_DateTime.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_DateTime.setBounds(10, 11, 177, 65);
		panel_Menu.add(panel_DateTime);
		panel_DateTime.setLayout(null);

		lblClock = new JLabel("00:00:00");
		lblClock.setBounds(10, 11, 157, 24);
		panel_DateTime.add(lblClock);
		panel_DateTime.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		lblClock.setFont(new Font("Arial", Font.BOLD, 16));
		lblClock.setForeground(Color.decode(hexColor_Blue1));
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);

		lblDay = new JLabel("00/00/0000");
		lblDay.setBounds(10, 33, 157, 24);
		panel_DateTime.add(lblDay);
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);

		lblDay.setForeground(Color.decode(hexColor_Blue1));
		lblDay.setFont(new Font("Arial", Font.BOLD, 16));
	


		panel_Function = new JPanel();
		panel_Function.setBackground(Color.decode(hexColor_Blue1));
		panel_Function.setBounds(210, 64, 1296, 672);
		contentPane.add(panel_Function);
		panel_Function.setLayout(null);

		panel_Function.add(Panel_QLDP);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(33, 75, 109, 23);
		Panel_QLDP.add(rdbtnNewRadioButton);
		panel_Function.add(Panel_QLKH);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.decode(hexColor_Blue1));
		menuBar.setBounds(1405, 10, 90, 45);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.setBackground(Color.decode(hexColor_Blue1));
		mnNewMenu.setIcon(new ImageIcon(JFrame_ThuNgan.class.getResource("/icon/user.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Tài khoản");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Trợ giúp");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JLabel lbl__userName = new JLabel(nhanVien.getHoTen());
		lbl__userName.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__userName.setForeground(new Color(255, 255, 255));
		lbl__userName.setBounds(1198, 22, 176, 31);
		
		contentPane.add(lbl__userName);

		Clock();

	}
	

	public void menuClicked(JPanel panel) {
		Panel_QLDP.setVisible(false);
		Panel_QLKH.setVisible(false);
		panel.setVisible(true);
	}

	private void Clock() {
		new Thread() {
			public void run() {
				while (true) {
					Calendar ca = new GregorianCalendar();
					hour = ca.get(Calendar.HOUR);
					min = ca.get(Calendar.MINUTE);
					sec = ca.get(Calendar.SECOND);
					int AM_PM = ca.get(Calendar.AM_PM);

					int day = ca.get(Calendar.DAY_OF_MONTH);
					int month = ca.get(Calendar.MONTH);
					int year = ca.get(Calendar.YEAR);

					if (AM_PM == 1) {
						hour = hour + 12;
						if (hour == 24) {
							hour = 0;
						}
					}

					lblDay.setText(String.format("%02d", day) + " / " + String.format("%02d", month+1)  + " / " +  String.format("%04d", year));
					lblClock.setText(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec)  );


				}
			}
		}.start();
	}

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
//			panel.setBackground(Color.decode(hexColor_Blue2));
		}

		@Override
		public void mouseExited(MouseEvent e) {
//			panel.setBackground(Color.white);
		}

		@Override
		public void mousePressed(MouseEvent e) {
//			panel.setBackground(Color.decode(hexColor_Blue2));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
//			panel.setBackground(Color.decode(hexColor_Blue1));
		}

	}
}
