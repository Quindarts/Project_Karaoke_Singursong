package GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.AbstractBorder;

import GUI.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import Entity.KhachHang;
import Entity.Phong;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

public class JPanel_QuanLyKhachHang extends JPanel {

	private Modal_ThemKhachHang modal_ThemKhachHang;

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
	private JTable table_KhachHang;
	private JTextField txt_TimKiem;
	private KhachHang_DAO DAO_KH;
	private ArrayList<KhachHang> dsKH;
	private DefaultTableModel model;
	private JRadioButton rdBtn_TimTheoMaKH;
	private JRadioButton rdBtn_TimTheoSoDT;
	private JTextField txt_DiemThuongTu;
	private JTextField txt_DiemThuongDen;
	private JTextField txt_TuoiDen;
	private JTextField txt_TuoiTu;
	private JCheckBox chcbx_Nam;
	private JCheckBox chcbx_Nu;
	private JCheckBox chcbx_TatCa;
	private ButtonGroup btnGr_LocTheoGioiTinh;


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
	 * Create the panel.
	 */
	public JPanel_QuanLyKhachHang() {
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		modal_ThemKhachHang = new Modal_ThemKhachHang();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
//		panel.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		add(panel);
		panel.setLayout(null);

		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_Table.setBackground(Color.decode(hexColor_Blue1));
//		panel_Table.setBackground(Color.WHITE);
		panel_Table.setBounds(0, 37, 1296, 635);
		panel.add(panel_Table);
		panel_Table.setLayout(null);

		Object[] rowData = new String[] { "M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh",
				"Ng\u00E0y sinh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i",
				"\u0110i\u1EC3m th\u01B0\u1EDFng", "Ghi ch\u00FA" };

		table_KhachHang = new JTable();
		table_KhachHang.setBackground(Color.WHITE);
		model = (DefaultTableModel) table_KhachHang.getModel();
		table_KhachHang.setModel(new DefaultTableModel(new Object[][] {}, rowData) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			}
		});

		table_KhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1019, 615);
		scrollPane.add(table_KhachHang);
		scrollPane.setViewportView(table_KhachHang);
		panel_Table.add(scrollPane);

		DAO_KH = new KhachHang_DAO();

		table_KhachHang.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table_KhachHang.getSelectedRow();
//	            	txtDiaDiem.setText(model.getValueAt(row, 2).toString());
//	        		date_KH.setDate((Date) model.getValueAt(row, 3));
					String maKhachHang = model.getValueAt(row, 0).toString();
					String hoTen = model.getValueAt(row, 1).toString();
					String gioiTinh = model.getValueAt(row, 2).toString();
					String ngaySinh = model.getValueAt(row, 3).toString();
					String diaChi = model.getValueAt(row, 4).toString();
					String sdt = model.getValueAt(row, 5).toString();
					String diemThuong = model.getValueAt(row, 6).toString();
					String ghiChu = model.getValueAt(row, 7).toString();
					modal_ThemKhachHang.setVisible(true);
					modal_ThemKhachHang.setModal_ThemKhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, sdt, diaChi,
							ghiChu);

				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		JPanel pnl_Loc = new JPanel();
		pnl_Loc.setBackground(Color.WHITE);
		pnl_Loc.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Loc.setBounds(1039, 20, 255, 615);
		panel_Table.add(pnl_Loc);
		pnl_Loc.setLayout(null);

		JPanel pnl_Loc_TheoGioiTinh = new JPanel();
		pnl_Loc_TheoGioiTinh.setBackground(new Color(255, 255, 255));
		pnl_Loc_TheoGioiTinh.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoGioiTinh.setBounds(10, 35, 235, 70);
		pnl_Loc.add(pnl_Loc_TheoGioiTinh);
		pnl_Loc_TheoGioiTinh.setLayout(null);

		JLabel lbl_Loc_GioTinh = new JLabel("Giới tính");
		lbl_Loc_GioTinh.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_Loc_GioTinh.setBounds(10, 10, 100, 16);
		pnl_Loc_TheoGioiTinh.add(lbl_Loc_GioTinh);

		chcbx_Nam = new JCheckBox("Nam");
		chcbx_Nam.setBackground(new Color(255, 255, 255));
		chcbx_Nam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_Nam.setBounds(6, 35, 64, 21);
		pnl_Loc_TheoGioiTinh.add(chcbx_Nam);
		chcbx_Nam.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Tìm những hành khách có giới tính là nam

			}
		});

		chcbx_Nu = new JCheckBox("Nữ");
		chcbx_Nu.setBackground(new Color(255, 255, 255));
		chcbx_Nu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_Nu.setBounds(72, 35, 64, 21);
		pnl_Loc_TheoGioiTinh.add(chcbx_Nu);
		chcbx_Nu.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Tìm những hành khách có giới tính là nữ

			}
		});

		chcbx_TatCa = new JCheckBox("Tất cả");
		chcbx_TatCa.setBackground(new Color(255, 255, 255));
		chcbx_TatCa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_TatCa.setBounds(138, 35, 64, 21);
		pnl_Loc_TheoGioiTinh.add(chcbx_TatCa);
		chcbx_TatCa.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Lấy toàn bộ khách hàng

			}
		});

		ButtonGroup btnGr_LocTheoGioiTinh = new ButtonGroup();
		btnGr_LocTheoGioiTinh.add(chcbx_Nam);
		btnGr_LocTheoGioiTinh.add(chcbx_Nu);
		btnGr_LocTheoGioiTinh.add(chcbx_TatCa);

		JLabel lbl_Loc = new JLabel("BỘ LỌC TÌM KIẾM");
		lbl_Loc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Loc.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbl_Loc.setBounds(10, 5, 235, 25);
		pnl_Loc.add(lbl_Loc);

		JPanel pnl_Loc_TheoDiemThuong = new JPanel();
		pnl_Loc_TheoDiemThuong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnl_Loc_TheoDiemThuong.setBackground(new Color(255, 255, 255));
		pnl_Loc_TheoDiemThuong.setLayout(null);
		pnl_Loc_TheoDiemThuong.setBounds(10, 195, 235, 70);
		pnl_Loc.add(pnl_Loc_TheoDiemThuong);

		JLabel lbl_Loc_DiemThuong = new JLabel("Điểm thưởng");
		lbl_Loc_DiemThuong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_Loc_DiemThuong.setBounds(10, 10, 100, 18);
		pnl_Loc_TheoDiemThuong.add(lbl_Loc_DiemThuong);

		JLabel lbl_DiemBatDau = new JLabel("Từ :");
		lbl_DiemBatDau.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_DiemBatDau.setBounds(10, 40, 45, 13);
		pnl_Loc_TheoDiemThuong.add(lbl_DiemBatDau);

		JLabel lbl_DiemKetThuc_1 = new JLabel("Đến :");
		lbl_DiemKetThuc_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_DiemKetThuc_1.setBounds(120, 40, 45, 13);
		pnl_Loc_TheoDiemThuong.add(lbl_DiemKetThuc_1);

		txt_DiemThuongDen = new JTextField();
		txt_DiemThuongDen.setColumns(10);
		txt_DiemThuongDen.setBounds(155, 38, 70, 19);
		pnl_Loc_TheoDiemThuong.add(txt_DiemThuongDen);

		txt_DiemThuongTu = new JTextField();
		txt_DiemThuongTu.setColumns(10);
		txt_DiemThuongTu.setBounds(40, 38, 70, 19);
		pnl_Loc_TheoDiemThuong.add(txt_DiemThuongTu);

		JPanel pnl_Loc_TheoTuoi = new JPanel();
		pnl_Loc_TheoTuoi.setLayout(null);
		pnl_Loc_TheoTuoi.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoTuoi.setBackground(Color.WHITE);
		pnl_Loc_TheoTuoi.setBounds(10, 115, 235, 70);
		pnl_Loc.add(pnl_Loc_TheoTuoi);

		JLabel lbl_Loc_Tuoi = new JLabel("Tuổi");
		lbl_Loc_Tuoi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_Loc_Tuoi.setBounds(10, 10, 100, 18);
		pnl_Loc_TheoTuoi.add(lbl_Loc_Tuoi);

		JLabel lbl_TuoiBatDau = new JLabel("Từ :");
		lbl_TuoiBatDau.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TuoiBatDau.setBounds(10, 40, 45, 13);
		pnl_Loc_TheoTuoi.add(lbl_TuoiBatDau);

		JLabel lbl_TuoiKetThuc = new JLabel("Đến :");
		lbl_TuoiKetThuc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_TuoiKetThuc.setBounds(120, 40, 45, 13);
		pnl_Loc_TheoTuoi.add(lbl_TuoiKetThuc);

		txt_TuoiDen = new JTextField();
		txt_TuoiDen.setColumns(10);
		txt_TuoiDen.setBounds(155, 38, 70, 19);
		pnl_Loc_TheoTuoi.add(txt_TuoiDen);

		txt_TuoiTu = new JTextField();
		txt_TuoiTu.setColumns(10);
		txt_TuoiTu.setBounds(40, 38, 70, 19);
		pnl_Loc_TheoTuoi.add(txt_TuoiTu);

		JButton btnLoc = new JButton("Lọc");
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLoc.setBackground(new Color(62, 124, 177));
		btnLoc.setBounds(73, 570, 123, 35);
		pnl_Loc.add(btnLoc);
		btnLoc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LocDuLieu();
			}
		});

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(JPanel_QuanLyKhachHang.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(Color.decode(hexColor_Green));
		btnThem.setBounds(10, 0, 125, 35);
		panel.add(btnThem);

		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modal_ThemKhachHang.setVisible(true);
			}
		});

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaKhachHang();
				DocDuLieu();
			}
		});
		btnXoa.setIcon(new ImageIcon(JPanel_QuanLyKhachHang.class.getResource("/icon/add.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnXoa.setBackground(Color.decode(hexColor_Red));
		btnXoa.setBounds(145, 0, 125, 35);
		panel.add(btnXoa);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyKhachHang.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setBounds(280, 0, 125, 35);
		panel.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DocDuLieu();
			}
		});

		txt_TimKiem = new JTextField();
		txt_TimKiem.setBounds(545, 1, 223, 34);
		panel.add(txt_TimKiem);
		txt_TimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(415, 1, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyKhachHang.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rdBtn_TimTheoMaKH.isSelected()) {
					TimKhachHang_TheoMa();
				}
				if (rdBtn_TimTheoSoDT.isSelected()) {
					TimKhachHang_TheoSoDT();
				}
			}
		});

		rdBtn_TimTheoMaKH = new JRadioButton("Mã khách hàng");
		rdBtn_TimTheoMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdBtn_TimTheoMaKH.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtn_TimTheoMaKH.setBackground(new Color(255, 255, 255));
		rdBtn_TimTheoMaKH.setBounds(774, 4, 125, 30);
		panel.add(rdBtn_TimTheoMaKH);

		rdBtn_TimTheoSoDT = new JRadioButton("Số điện thoại");
		rdBtn_TimTheoSoDT.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdBtn_TimTheoSoDT.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtn_TimTheoSoDT.setBackground(Color.WHITE);
		rdBtn_TimTheoSoDT.setBounds(901, 4, 125, 30);
		panel.add(rdBtn_TimTheoSoDT);

		ButtonGroup btnGr_TimTheoLoai = new ButtonGroup();
		btnGr_TimTheoLoai.add(rdBtn_TimTheoMaKH);
		btnGr_TimTheoLoai.add(rdBtn_TimTheoSoDT);

		DocDuLieu();

	}

	public void XoaDuLieuTrenTable() {
		model = (DefaultTableModel) table_KhachHang.getModel();
		model.getDataVector().removeAllElements();
	}

	public void DocDuLieu() {
		model = (DefaultTableModel) table_KhachHang.getModel();
		model.getDataVector().removeAllElements();
		try {
			dsKH = DAO_KH.layTatCaKhachHang();
			if (dsKH != null) {
				dsKH.forEach(kh -> {
					String gender = kh.isGioiTinh() ? "Nam" : "Nữ";
					Object[] rowData = { kh.getMaKhachHang(), kh.getHoTen(), gender, kh.getNgaySinh(), kh.getDiaChi(),
							kh.getSoDienThoai(), kh.getDiemThuong(), kh.getGhiChu() };
					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu");
		}
	}

	public void XoaKhachHang() {
		int row = table_KhachHang.getSelectedRow();
		String maKhachHang = model.getValueAt(row, 0).toString();
		KhachHang khachHang = new KhachHang(maKhachHang);
		try {
			String tenKhachHang = DAO_KH.layKhachHang_TheoMaKhachHang(maKhachHang).getHoTen();
			DAO_KH.xoaKhachHang(khachHang);
			JOptionPane.showMessageDialog(null, "Xóa khách hàng" + tenKhachHang + "thành công");
			model.removeRow(row);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

	public void TimKhachHang_TheoMa() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txt_TimKiem.getText().trim();
		KhachHang kh_MaKH = DAO_KH.layKhachHang_TheoMaKhachHang(chuoiTimKiem);
		try {
			dsKH.add(kh_MaKH);
			if (dsKH != null) {
				String gender = kh_MaKH.isGioiTinh() ? "Nam" : "Nữ";
				Object[] rowData = { kh_MaKH.getMaKhachHang(), kh_MaKH.getHoTen(), gender, kh_MaKH.getNgaySinh(),
						kh_MaKH.getDiaChi(), kh_MaKH.getSoDienThoai(), kh_MaKH.getDiemThuong(), kh_MaKH.getGhiChu() };
				model.addRow(rowData);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có khách hàng nào có mã: " + chuoiTimKiem);
		}
	}

	public void TimKhachHang_TheoSoDT() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txt_TimKiem.getText().trim();
		KhachHang kh_SoDT = DAO_KH.layKhachHang_TheoSoDienThoai(chuoiTimKiem);
		try {
			dsKH.add(kh_SoDT);
			if (dsKH != null) {
				String gender = kh_SoDT.isGioiTinh() ? "Nam" : "Nữ";
				Object[] rowData = { kh_SoDT.getMaKhachHang(), kh_SoDT.getHoTen(), gender, kh_SoDT.getNgaySinh(),
						kh_SoDT.getDiaChi(), kh_SoDT.getSoDienThoai(), kh_SoDT.getDiemThuong(), kh_SoDT.getGhiChu() };
				model.addRow(rowData);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có khách hàng nào có số điện thoại: " + chuoiTimKiem);
		}
	}


	public void LocDuLieu() {
	    int loc_tuoiTu, loc_tuoiDen; // Lấy tuổi
	    try {
	        loc_tuoiTu = Integer.parseInt(txt_TuoiTu.getText().trim());
	    } catch (NumberFormatException e) {
	        // Xử lý ngoại lệ nếu người dùng không nhập số tuổi tối thiểu
	        loc_tuoiTu = 0;
	        txt_TuoiTu.setText("0");
	    }    
	    try {
	        loc_tuoiDen = Integer.parseInt(txt_TuoiDen.getText().trim());
	    } catch (NumberFormatException e) {
	        // Xử lý ngoại lệ nếu người dùng không nhập số tuổi tối đa
	        loc_tuoiDen = Integer.MAX_VALUE; // Lọc theo tất cả các tuổi
	    }

	    int loc_diemThuongTu, loc_diemThuongDen; // Lấy điểm thưởng
	    try {
	    	 loc_diemThuongTu = Integer.parseInt(txt_DiemThuongTu.getText().trim());
	    } catch (NumberFormatException e) {
	        // Xử lý ngoại lệ nếu người dùng không nhập số tuổi tối thiểu
	    	loc_diemThuongTu = 0;
	    	txt_DiemThuongTu.setText("0");
	    }
	    try {  
	        loc_diemThuongDen = Integer.parseInt(txt_DiemThuongDen.getText().trim());
	    } catch (NumberFormatException e) {
	        loc_diemThuongDen = Integer.MAX_VALUE; // Lọc theo tất cả điểm thưởng
	    }

	    // Kiểm tra nếu không chọn lọc theo giới tính thì mặc định là lọc tất cả
	    boolean loc_nam = chcbx_Nam.isSelected();
	    boolean loc_nu = chcbx_Nu.isSelected();
	    boolean loc_tatCa = !loc_nam && !loc_nu; // Nếu cả nam và nữ đều không được chọn

	    model.getDataVector().removeAllElements();
	    boolean ketQuaLoc = false;

	    for (KhachHang kh : DAO_KH.layTatCaKhachHang()) {
	        String gender = kh.isGioiTinh() ? "Nam" : "Nữ";
	        Calendar ngayHienTai = Calendar.getInstance();
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(kh.getNgaySinh());
	        int tuoi = ngayHienTai.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
	        int diemThuong = kh.getDiemThuong();

	        if ((loc_tatCa || (loc_nam && kh.isGioiTinh()) || (loc_nu && !kh.isGioiTinh())) &&
	            (loc_tuoiTu <= tuoi && tuoi <= loc_tuoiDen) &&
	            (loc_diemThuongTu <= diemThuong && diemThuong <= loc_diemThuongDen)) {
	            Object[] rowData = { kh.getMaKhachHang(), kh.getHoTen(), gender, kh.getNgaySinh(),
	                kh.getDiaChi(), kh.getSoDienThoai(), diemThuong, kh.getGhiChu() };
	            model.addRow(rowData);
	            ketQuaLoc = true;
	        }
	    }

	    if (!ketQuaLoc) {
	        JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp với tiêu chí lọc.");
	    }
	}



}