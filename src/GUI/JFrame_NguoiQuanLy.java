package GUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

//import GUI.JFrame_ThuNgan.PanelButtonMouseAdapter;
import GUI.JFrame_ThuNgan.RoundedTransparentBorder;

public class JFrame_NguoiQuanLy extends JFrame {

	private JPanel contentPane;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";

	private JPanel panel_Menu;
	private JPanel panelMenu_QLDatPhong;
	private JPanel panelMenu_QLKhachHang;
	private JPanel panel_Function;
	private JLabel lblMenu_QLKhachHang;
	private JButton btnNewButton;

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
	 * Create the frame.
	 */
	public JFrame_NguoiQuanLy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode(hexColor_Blue1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
//				menuClicked(Panel_QLDP);
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
//				menuClicked(Panel_QLKH);
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

		panel_Function = new JPanel();
		panel_Function.setBackground(Color.WHITE);
		panel_Function.setBounds(210, 64, 1296, 672);
		contentPane.add(panel_Function);
		panel_Function.setLayout(null);

//		panel_Function.add(Panel_QLDP);
//		panel_Function.add(Panel_QLKH);

	}

	public void menuClicked(JPanel panel) {
//		Panel_QLDP.setVisible(false);
//		Panel_QLKH.setVisible(false);
		panel.setVisible(true);
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
