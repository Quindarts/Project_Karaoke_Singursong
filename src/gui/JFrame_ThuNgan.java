package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import dao.DichVu_DAO;
import dao.NhanVien_DAO;
import dao.Phong_DAO;
import entity.NhanVien;
import entity.Phong;
import gui.JFrame_DangNhap.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
import javax.swing.JTextField;
import java.awt.SystemColor;

public class JFrame_ThuNgan extends JFrame {

	private static final DichVu_DAO DAO_DV = null;
	/**
	 * Khai báo JPanel
	 */
	private JPanel_QuanLyDatPhong Panel_QLDP;
	private JPanel_QuanLyKhachHang Panel_QLKH;
	private JPanel_QuanLyHoaDon Panel_QLHD;
	private JPanel_QuanLyPhieuDatPhong Panel_QLPDP;
	private JPanel_QuanLyDichVu Panel_QLDV;
	private JPanel_QuanLyKhuyenMai Panel_QLKM;
	private JPanel_QuanLyLoaiPhong Panel_QLLP;
	private JPanel_QuanLyPhong Panel_QLP;
	private JPanel_QuanLyNhanVien Panel_QLNV;
	private JPanel_BaoCaoThongKe Panel_BCTK;

	/**
	 * Color
	 */

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Yellow = "#fcbf08";

	private JPanel contentPane;
	private JPanel panel_Menu;
	private JPanel panelMenu_QLDatPhong;
	private JPanel panelMenu_QLKhachHang;
	private JPanel panel_Function;
	private JLabel lblMenu_QLKhachHang;
	private JButton btnNewButton;
	private JPanel panelMenu_QLPhieuDatPhong;
	private JLabel lblMenu_PhieuDatPhong;
	private JPanel panelMenu_QLHoaDon;
	private JLabel lblMenu_HoaDon;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblDay;

	private JLabel lblClock;
	private int hour, min, sec;
	private JPanel panel_DateTime;
	private NhanVien nhanVien;
	private JTextField txt_TongTrang;
	private JLabel lblNewLabel;
	private JButton btnTrangTruoc;
	private JButton btnTrangCuoi;
	private JButton btnTrangSau;
	private JButton btnTrangDau;
	private JTextField txtTrang;

	private NhanVien_DAO NV_DAO;
	private MouseListener menuClickListener;
	private JPanel panelMenu_QLKhuyenMai;
	private JPanel panelMenu_QLNhanVien;
	private JPanel panelMenu_QLLoaiPhong;
	private JPanel panelMenu_QLPhong;
	private JPanel panelMenu_QLDichVu;
	private JPanel panelMenu_BaoCaoThongKe;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel txt_tenNhanVien;

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

	/**
	 * Create the frame.
	 * 
	 * 
	 */

	public JFrame_ThuNgan(NhanVien nhanVien) {
//		this.nhanVien = nhanVien;

		try {
			Phong_DAO DAO_P = new Phong_DAO();
			ArrayList<Phong> dsP = new ArrayList<>();
			if (DAO_P.capNhatTatCaPhong_TrangThaiPhongMoiNhat()) {
				System.out.println("Connect đến danh sách phòng mới thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
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
		Panel_BCTK = new JPanel_BaoCaoThongKe(nhanVien);
		Panel_BCTK.setBounds(0, 0, 1296, 672);
		Panel_QLDV = new JPanel_QuanLyDichVu();
		Panel_QLDV.setBounds(0, 0, 1296, 672);
		Panel_QLPDP = new JPanel_QuanLyPhieuDatPhong(nhanVien);
		Panel_QLPDP.setBounds(0, 0, 1296, 672);
		Panel_QLHD = new JPanel_QuanLyHoaDon();
		Panel_QLHD.setBounds(0, 0, 1296, 672);
		Panel_QLKM = new JPanel_QuanLyKhuyenMai();
		Panel_QLKM.setBounds(0, 0, 1296, 672);
		Panel_QLLP = new JPanel_QuanLyLoaiPhong(nhanVien);
		Panel_QLLP.setBounds(0, 0, 1296, 672);
		Panel_QLP = new JPanel_QuanLyPhong(nhanVien);
		Panel_QLP.setBounds(0, 0, 1296, 672);
		Panel_QLNV = new JPanel_QuanLyNhanVien();
		Panel_QLNV.setBounds(0, 0, 1296, 672);

		panel_Menu = new JPanel();
		panel_Menu.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_Menu.setBackground(Color.decode(hexColor_Blue1));
//		panel_Menu.setBackground(Color.WHITE);
		panel_Menu.setBounds(10, 60, 197, 672);
		contentPane.add(panel_Menu);
		panel_Menu.setLayout(null);

		panelMenu_QLDatPhong = new JPanel();
		panelMenu_QLDatPhong.addMouseListener(new PanelButtonMouseAdapter(panelMenu_QLDatPhong) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(Panel_QLDP);
			}
		});
		panelMenu_QLDatPhong.setBounds(2, 105, 192, 45);
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

		panelMenu_QLKhachHang.setBounds(2, 151, 192, 45);

		panel_Menu.add(panelMenu_QLKhachHang);
		panelMenu_QLKhachHang.setLayout(null);

		lblMenu_QLKhachHang = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblMenu_QLKhachHang.setForeground(Color.white);
		lblMenu_QLKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLKhachHang.setBounds(10, 10, 166, 20);
		panelMenu_QLKhachHang.add(lblMenu_QLKhachHang);

		panelMenu_QLPhieuDatPhong = new JPanel();
		panelMenu_QLPhieuDatPhong.setLayout(null);
		panelMenu_QLPhieuDatPhong.setBackground(new Color(5, 74, 145));
		panelMenu_QLPhieuDatPhong.setBounds(2, 197, 192, 45);
		panel_Menu.add(panelMenu_QLPhieuDatPhong);

		lblMenu_PhieuDatPhong = new JLabel("PHIẾU ĐẶT PHÒNG");
		lblMenu_PhieuDatPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_PhieuDatPhong.setForeground(Color.WHITE);
		lblMenu_PhieuDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_PhieuDatPhong.setBounds(10, 10, 166, 20);
		panelMenu_QLPhieuDatPhong.add(lblMenu_PhieuDatPhong);

		panelMenu_QLHoaDon = new JPanel();
		panelMenu_QLHoaDon.setLayout(null);
		panelMenu_QLHoaDon.setBackground(new Color(5, 74, 145));
		panelMenu_QLHoaDon.setBounds(2, 243, 192, 45);
		panel_Menu.add(panelMenu_QLHoaDon);

		lblMenu_HoaDon = new JLabel("HÓA ĐƠN");
		lblMenu_HoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_HoaDon.setForeground(Color.WHITE);
		lblMenu_HoaDon.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_HoaDon.setBounds(10, 10, 166, 20);
		panelMenu_QLHoaDon.add(lblMenu_HoaDon);

		panel_DateTime = new JPanel();
		panel_DateTime.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_DateTime.setBounds(8, 11, 180, 65);
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

		panelMenu_QLNhanVien = new JPanel();
		panelMenu_QLNhanVien.setLayout(null);
		panelMenu_QLNhanVien.setBackground(new Color(5, 74, 145));
		panelMenu_QLNhanVien.setBounds(2, 289, 192, 45);
		panel_Menu.add(panelMenu_QLNhanVien);

		JLabel lblMenu_QLNhanVien = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblMenu_QLNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLNhanVien.setForeground(Color.WHITE);
		lblMenu_QLNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLNhanVien.setBounds(10, 10, 166, 20);
		panelMenu_QLNhanVien.add(lblMenu_QLNhanVien);

		panelMenu_QLLoaiPhong = new JPanel();
		panelMenu_QLLoaiPhong.setLayout(null);
		panelMenu_QLLoaiPhong.setBackground(new Color(5, 74, 145));
		panelMenu_QLLoaiPhong.setBounds(2, 335, 192, 45);
		panel_Menu.add(panelMenu_QLLoaiPhong);

		JLabel lblMenu_QLLoaiPhong = new JLabel("QUẢN LÝ LOẠI PHÒNG");
		lblMenu_QLLoaiPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLLoaiPhong.setForeground(Color.WHITE);
		lblMenu_QLLoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLLoaiPhong.setBounds(10, 10, 166, 20);
		panelMenu_QLLoaiPhong.add(lblMenu_QLLoaiPhong);

		panelMenu_QLPhong = new JPanel();
		panelMenu_QLPhong.setLayout(null);
		panelMenu_QLPhong.setBackground(new Color(5, 74, 145));
		panelMenu_QLPhong.setBounds(2, 381, 192, 45);
		panel_Menu.add(panelMenu_QLPhong);

		JLabel lblMenu_QLPhong = new JLabel("QUẢN LÝ PHÒNG");
		lblMenu_QLPhong.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLPhong.setForeground(Color.WHITE);
		lblMenu_QLPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLPhong.setBounds(10, 10, 166, 20);
		panelMenu_QLPhong.add(lblMenu_QLPhong);

		panelMenu_QLDichVu = new JPanel();
		panelMenu_QLDichVu.setLayout(null);
		panelMenu_QLDichVu.setBackground(new Color(5, 74, 145));
		panelMenu_QLDichVu.setBounds(2, 427, 192, 45);
		panel_Menu.add(panelMenu_QLDichVu);

		JLabel lblMenu_QLDichVu = new JLabel("QUẢN LÝ DỊCH VỤ");
		lblMenu_QLDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLDichVu.setForeground(Color.WHITE);
		lblMenu_QLDichVu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLDichVu.setBounds(10, 10, 166, 20);
		panelMenu_QLDichVu.add(lblMenu_QLDichVu);

		panelMenu_QLKhuyenMai = new JPanel();
		panelMenu_QLKhuyenMai.setLayout(null);
		panelMenu_QLKhuyenMai.setBackground(new Color(5, 74, 145));
		panelMenu_QLKhuyenMai.setBounds(2, 473, 192, 45);
		panel_Menu.add(panelMenu_QLKhuyenMai);

		JLabel lblMenu_QLKhuyenMai = new JLabel("QUẢN LÝ KHUYẾN MÃI");
		lblMenu_QLKhuyenMai.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_QLKhuyenMai.setForeground(Color.WHITE);
		lblMenu_QLKhuyenMai.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_QLKhuyenMai.setBounds(10, 10, 166, 20);
		panelMenu_QLKhuyenMai.add(lblMenu_QLKhuyenMai);

		panelMenu_BaoCaoThongKe = new JPanel();
		panelMenu_BaoCaoThongKe.setLayout(null);
		panelMenu_BaoCaoThongKe.setBackground(new Color(5, 74, 145));
		panelMenu_BaoCaoThongKe.setBounds(2, 519, 192, 45);
		panel_Menu.add(panelMenu_BaoCaoThongKe);

		JLabel lblMenu_BaoCaoThongKe = new JLabel("BÁO CÁO THỐNG KÊ");
		lblMenu_BaoCaoThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu_BaoCaoThongKe.setForeground(Color.WHITE);
		lblMenu_BaoCaoThongKe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMenu_BaoCaoThongKe.setBounds(10, 10, 166, 20);
		panelMenu_BaoCaoThongKe.add(lblMenu_BaoCaoThongKe);

		panel_Function = new JPanel();
		panel_Function.setBackground(Color.decode(hexColor_Blue1));
		panel_Function.setBounds(210, 60, 1296, 675);
		contentPane.add(panel_Function);
		panel_Function.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(33, 75, 109, 23);
		Panel_QLDP.add(rdbtnNewRadioButton);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.decode(hexColor_Blue1));
		menuBar.setBounds(1405, 9, 90, 45);
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

		Clock();
		panel_Function.add(Panel_QLDP);

		/**
		 * addMouseListener
		 **/

		addMenuClickListener(panelMenu_QLKhachHang, Panel_QLKH);
		addMenuClickListener(panelMenu_QLPhieuDatPhong, Panel_QLPDP);
		addMenuClickListener(panelMenu_QLHoaDon, Panel_QLHD);
		addMenuClickListener(panelMenu_QLDichVu, Panel_QLDV);
		addMenuClickListener(panelMenu_QLKhuyenMai, Panel_QLKM);
		addMenuClickListener(panelMenu_QLLoaiPhong, Panel_QLLP);

		addMenuClickListener(panelMenu_QLPhong, Panel_QLP);
		addMenuClickListener(panelMenu_QLDatPhong, Panel_QLDP);
		addMenuClickListener(panelMenu_BaoCaoThongKe, Panel_BCTK);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(5, 74, 145));
		panel_1.setBounds(1160, 20, 250, 25);
		contentPane.add(panel_1);

		lblNewLabel_1 = new JLabel("Xin chào,");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(0, 0, 63, 25);
		panel_1.add(lblNewLabel_1);

		txt_tenNhanVien = new JLabel(nhanVien.getHoTen());
		txt_tenNhanVien.setForeground(Color.WHITE);
		txt_tenNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txt_tenNhanVien.setBounds(67, 0, 158, 25);
		panel_1.add(txt_tenNhanVien);

		if (nhanVien.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			addMenuClickListener(panelMenu_QLNhanVien, Panel_QLNV);
			System.out.println("nay la quan ly");
		} else {
			panelMenu_QLNhanVien.setForeground(Color.WHITE);
			panelMenu_QLNhanVien.setBackground(Color.LIGHT_GRAY);
			System.out.println("Không phải quản lý nhân viên");
		}

		mntmNewMenuItem_2.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(nhanVien.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000"));
				setVisible(false);
				JFrame_DangNhap dangnhap = new JFrame_DangNhap();
				dangnhap.setVisible(true);

			}
		});

		mntmNewMenuItem.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog_TrangCaNhan canhan = new JDialog_TrangCaNhan(nhanVien);
				canhan.setVisible(true);

			}
		});

	}

	public void menuClicked(JPanel panel) {
		panel_Function.removeAll();
		panel_Function.revalidate();
		panel_Function.repaint();
		panel_Function.add(panel);
	}

	private void addMenuClickListener(JPanel panelMenu, JPanel targetPanel) {
		panelMenu.addMouseListener(new PanelButtonMouseAdapter(panelMenu) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(targetPanel);
			}
		});
	}

	/**
	 * Đồng hồ
	 */

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

					lblDay.setText(String.format("%02d", day) + " / " + String.format("%02d", month + 1) + " / "
							+ String.format("%04d", year));
					lblClock.setText(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":"
							+ String.format("%02d", sec));

				}
			}
		}.start();
	}

	/**
	 * 
	 * */

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.decode(hexColor_Orange));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.decode(hexColor_Blue1));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.decode(hexColor_Orange));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.decode(hexColor_Blue1));
		}

	}
}