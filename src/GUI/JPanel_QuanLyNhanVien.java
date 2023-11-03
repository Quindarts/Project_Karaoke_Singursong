package GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.AbstractBorder;

import GUI.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiNhanVien_DAO;
import DAO.NhanVien_DAO;
import Entity.KhachHang;
import Entity.LoaiNhanVien;
import Entity.NhanVien;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class JPanel_QuanLyNhanVien extends JPanel implements ActionListener {

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

	private JTable table_NhanVien;
	private JTextField txt_TimKiem;

	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnTimKiem;

	private NhanVien_DAO DAO_NV;
	private ArrayList<NhanVien> dsNV;
	private LoaiNhanVien_DAO DAO_LoaiNV;
	private JRadioButton rdBtn_TimTheoMaKH;
	private JRadioButton rdBtn_TimTheoSoDT;
	private JRadioButton rdBtn_TimTheoCCCD;
	private DefaultTableModel model;
	private Modal_ThemNhanVien model_ThemNhanVien;
	private JTextField txt_TuoiDen;
	private JTextField txt_TuoiTu;
	private JCheckBox chcbx_Nam;
	private JCheckBox chcbx_Nu;
	private JCheckBox chcbx_TatCa;
	private JCheckBox chcbx_QuanLy;
	private JCheckBox chcbx_ThuNgan;
	private JCheckBox chcbx_TatCaLoaiNV;
	private JCheckBox chcbx_TiepTan;
	private JCheckBox chcbx_ConLam;
	private JCheckBox chcbx_NghiPhep;
	private JCheckBox chcbx_TatCaTrangThai;
	private JCheckBox chcbx_NghiLam;
	private JButton btnLoc;

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
	public JPanel_QuanLyNhanVien() {
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

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

		table_NhanVien = new JTable();
		table_NhanVien.setBackground(Color.WHITE);
		Object[] header = { "Mã nhân viên", "Loại nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh",
				"Số điện thoại", "CCCD", "Địa chỉ", "Trạng thái", "Ảnh thẻ" };
		table_NhanVien.setModel(new DefaultTableModel(new Object[][] {}, header));
		table_NhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_NhanVien);
		scrollPane.setViewportView(table_NhanVien);

		model = (DefaultTableModel) table_NhanVien.getModel();
		table_NhanVien.setModel(new DefaultTableModel(new Object[][] {}, header) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			}
		});

		panel_Table.add(scrollPane);

		JPanel pnl_Loc = new JPanel();
		pnl_Loc.setLayout(null);
		pnl_Loc.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_Loc.setBackground(Color.WHITE);
		pnl_Loc.setBounds(1035, 10, 255, 615);
		panel_Table.add(pnl_Loc);

		JPanel pnl_Loc_TheoGioiTinh = new JPanel();
		pnl_Loc_TheoGioiTinh.setLayout(null);
		pnl_Loc_TheoGioiTinh.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoGioiTinh.setBackground(Color.WHITE);
		pnl_Loc_TheoGioiTinh.setBounds(10, 35, 235, 70);
		pnl_Loc.add(pnl_Loc_TheoGioiTinh);

		JLabel lbl_Loc_GioTinh = new JLabel("Giới tính");
		lbl_Loc_GioTinh.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_Loc_GioTinh.setBounds(10, 10, 100, 16);
		pnl_Loc_TheoGioiTinh.add(lbl_Loc_GioTinh);

		chcbx_Nam = new JCheckBox("Nam");
		chcbx_Nam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_Nam.setBackground(Color.WHITE);
		chcbx_Nam.setBounds(6, 35, 64, 21);
		pnl_Loc_TheoGioiTinh.add(chcbx_Nam);

		chcbx_Nu = new JCheckBox("Nữ");
		chcbx_Nu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_Nu.setBackground(Color.WHITE);
		chcbx_Nu.setBounds(72, 35, 64, 21);
		pnl_Loc_TheoGioiTinh.add(chcbx_Nu);

		chcbx_TatCa = new JCheckBox("Tất cả");
		chcbx_TatCa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_TatCa.setBackground(Color.WHITE);
		chcbx_TatCa.setBounds(138, 35, 64, 21);
		pnl_Loc_TheoGioiTinh.add(chcbx_TatCa);

		ButtonGroup btnGr_LocTheoGioiTinh = new ButtonGroup();
		btnGr_LocTheoGioiTinh.add(chcbx_Nam);
		btnGr_LocTheoGioiTinh.add(chcbx_Nu);
		btnGr_LocTheoGioiTinh.add(chcbx_TatCa);

		JLabel lbl_Loc = new JLabel("BỘ LỌC TÌM KIẾM");
		lbl_Loc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Loc.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbl_Loc.setBounds(10, 5, 235, 25);
		pnl_Loc.add(lbl_Loc);

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

		JPanel pnl_Loc_TheoGioiTinh_1 = new JPanel();
		pnl_Loc_TheoGioiTinh_1.setLayout(null);
		pnl_Loc_TheoGioiTinh_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoGioiTinh_1.setBackground(Color.WHITE);
		pnl_Loc_TheoGioiTinh_1.setBounds(10, 195, 235, 90);
		pnl_Loc.add(pnl_Loc_TheoGioiTinh_1);

		JLabel lbl_Loc_LoaiNV = new JLabel("Loại nhân viên");
		lbl_Loc_LoaiNV.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_Loc_LoaiNV.setBounds(10, 10, 100, 16);
		pnl_Loc_TheoGioiTinh_1.add(lbl_Loc_LoaiNV);

		chcbx_QuanLy = new JCheckBox("Quản lý");
		chcbx_QuanLy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_QuanLy.setBackground(Color.WHITE);
		chcbx_QuanLy.setBounds(10, 35, 104, 21);
		pnl_Loc_TheoGioiTinh_1.add(chcbx_QuanLy);

		chcbx_ThuNgan = new JCheckBox("Thu ngân");
		chcbx_ThuNgan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_ThuNgan.setBackground(Color.WHITE);
		chcbx_ThuNgan.setBounds(10, 60, 100, 21);
		pnl_Loc_TheoGioiTinh_1.add(chcbx_ThuNgan);

		chcbx_TatCaLoaiNV = new JCheckBox("Tất cả");
		chcbx_TatCaLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_TatCaLoaiNV.setBackground(Color.WHITE);
		chcbx_TatCaLoaiNV.setBounds(129, 60, 64, 21);
		pnl_Loc_TheoGioiTinh_1.add(chcbx_TatCaLoaiNV);

		chcbx_TiepTan = new JCheckBox("Tiếp tân");
		chcbx_TiepTan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_TiepTan.setBackground(Color.WHITE);
		chcbx_TiepTan.setBounds(129, 35, 100, 21);
		pnl_Loc_TheoGioiTinh_1.add(chcbx_TiepTan);

		ButtonGroup btnGr_LocTheoChucVu = new ButtonGroup();
		btnGr_LocTheoChucVu.add(chcbx_QuanLy);
		btnGr_LocTheoChucVu.add(chcbx_ThuNgan);
		btnGr_LocTheoChucVu.add(chcbx_TiepTan);
		btnGr_LocTheoChucVu.add(chcbx_TatCaLoaiNV);

		JPanel pnl_Loc_TheoGioiTinh_1_1 = new JPanel();
		pnl_Loc_TheoGioiTinh_1_1.setLayout(null);
		pnl_Loc_TheoGioiTinh_1_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoGioiTinh_1_1.setBackground(Color.WHITE);
		pnl_Loc_TheoGioiTinh_1_1.setBounds(10, 295, 235, 90);
		pnl_Loc.add(pnl_Loc_TheoGioiTinh_1_1);

		JLabel lbl_Loc_DiaChi = new JLabel("Trạng thái");
		lbl_Loc_DiaChi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_Loc_DiaChi.setBounds(10, 10, 100, 16);
		pnl_Loc_TheoGioiTinh_1_1.add(lbl_Loc_DiaChi);

		chcbx_ConLam = new JCheckBox("Còn làm");
		chcbx_ConLam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_ConLam.setBackground(Color.WHITE);
		chcbx_ConLam.setBounds(10, 35, 104, 21);
		pnl_Loc_TheoGioiTinh_1_1.add(chcbx_ConLam);

		chcbx_NghiPhep = new JCheckBox("Nghỉ phép");
		chcbx_NghiPhep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_NghiPhep.setBackground(Color.WHITE);
		chcbx_NghiPhep.setBounds(10, 60, 100, 21);
		pnl_Loc_TheoGioiTinh_1_1.add(chcbx_NghiPhep);

		chcbx_TatCaTrangThai = new JCheckBox("Tất cả");
		chcbx_TatCaTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_TatCaTrangThai.setBackground(Color.WHITE);
		chcbx_TatCaTrangThai.setBounds(129, 60, 64, 21);
		pnl_Loc_TheoGioiTinh_1_1.add(chcbx_TatCaTrangThai);

		chcbx_NghiLam = new JCheckBox("Nghỉ làm");
		chcbx_NghiLam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_NghiLam.setBackground(Color.WHITE);
		chcbx_NghiLam.setBounds(129, 35, 100, 21);
		pnl_Loc_TheoGioiTinh_1_1.add(chcbx_NghiLam);

		ButtonGroup btnGr_LocTheoTrangThai = new ButtonGroup();
		btnGr_LocTheoTrangThai.add(chcbx_ConLam);
		btnGr_LocTheoTrangThai.add(chcbx_NghiPhep);
		btnGr_LocTheoTrangThai.add(chcbx_NghiLam);
		btnGr_LocTheoTrangThai.add(chcbx_TatCaTrangThai);

		btnLoc = new JButton("Lọc");
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLoc.setBackground(new Color(62, 124, 177));
		btnLoc.setBounds(69, 570, 123, 35);
		pnl_Loc.add(btnLoc);

		table_NhanVien.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table_NhanVien.getSelectedRow();
					String maNhanVien = model.getValueAt(row, 0).toString();
					String loaiNhanVien = model.getValueAt(row, 1).toString();
					String hoTen = model.getValueAt(row, 2).toString();
					String gioiTinh = model.getValueAt(row, 3).toString();
					String ngaySinh = model.getValueAt(row, 4).toString();
					String sdt = model.getValueAt(row, 5).toString();
					String cccd = model.getValueAt(row, 6).toString();
					String diaChi = model.getValueAt(row, 7).toString();
					String trangThai = model.getValueAt(row, 8).toString();
					String anhThe = "";
					try {
						anhThe = model.getValueAt(row, 9).toString();
					} catch (Exception e2) {
						anhThe = "";
					}
					model_ThemNhanVien = new Modal_ThemNhanVien();
					model_ThemNhanVien.setVisible(true);
					model_ThemNhanVien.setModal_ThemNhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, sdt,
							cccd, diaChi, trangThai, anhThe);
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

		btnThem = new JButton("Thêm");

		btnThem.setIcon(new ImageIcon(JPanel_QuanLyNhanVien.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(Color.decode(hexColor_Green));
		btnThem.setBounds(10, 0, 125, 35);
		panel.add(btnThem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyNhanVien.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setBounds(145, 0, 125, 35);
		panel.add(btnLamMoi);

		txt_TimKiem = new JTextField();
		txt_TimKiem.setBounds(415, 0, 223, 34);
		panel.add(txt_TimKiem);
		txt_TimKiem.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(280, 0, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyNhanVien.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		rdBtn_TimTheoMaKH = new JRadioButton("Mã nhân viên");
		rdBtn_TimTheoMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdBtn_TimTheoMaKH.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtn_TimTheoMaKH.setBackground(new Color(255, 255, 255));
		rdBtn_TimTheoMaKH.setBounds(656, 4, 125, 30);
		panel.add(rdBtn_TimTheoMaKH);

		rdBtn_TimTheoSoDT = new JRadioButton("Số điện thoại");
		rdBtn_TimTheoSoDT.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdBtn_TimTheoSoDT.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtn_TimTheoSoDT.setBackground(Color.WHITE);
		rdBtn_TimTheoSoDT.setBounds(783, 4, 125, 30);
		panel.add(rdBtn_TimTheoSoDT);

		rdBtn_TimTheoCCCD = new JRadioButton("Chứng minh thư");
		rdBtn_TimTheoCCCD.setHorizontalAlignment(SwingConstants.CENTER);
		rdBtn_TimTheoCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdBtn_TimTheoCCCD.setBackground(Color.WHITE);
		rdBtn_TimTheoCCCD.setBounds(910, 4, 125, 30);
		panel.add(rdBtn_TimTheoCCCD);

		ButtonGroup btnGr_TimTheoLoai = new ButtonGroup();
		btnGr_TimTheoLoai.add(rdBtn_TimTheoMaKH);
		btnGr_TimTheoLoai.add(rdBtn_TimTheoSoDT);
		btnGr_TimTheoLoai.add(rdBtn_TimTheoSoDT);

		// Add event:
		btnThem.addActionListener((ActionListener) this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnLoc.addActionListener(this);

		DAO_NV = new NhanVien_DAO();
		DAO_LoaiNV = new LoaiNhanVien_DAO();
		DocDuLieu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			model_ThemNhanVien = new Modal_ThemNhanVien();
			model_ThemNhanVien.setVisible(true);
			DocDuLieu();
		}

		if (o.equals(btnLamMoi)) {
			DocDuLieu();
		}
		if (o.equals(btnTimKiem)) {
			if (rdBtn_TimTheoMaKH.isSelected()) {
				TimNhanVien_TheoMa();
			} else if (rdBtn_TimTheoSoDT.isSelected()) {
				TimNhanVien_TheoSoDT();
			} else if (rdBtn_TimTheoCCCD.isSelected()) {
				TimNhanVien_TheoCCCD();
			}
		}
		if (o.equals(btnLoc)) {
			LocDuLieu();
		}
	}

	public void XoaDuLieuTrenTable() {
		model = (DefaultTableModel) table_NhanVien.getModel();
		model.getDataVector().removeAllElements();
	}

	public void DocDuLieu() {
		model = (DefaultTableModel) table_NhanVien.getModel();
		model.getDataVector().removeAllElements();
		try {
			dsNV = DAO_NV.layTatCaNhanVien();
			if (dsNV != null) {
				dsNV.forEach(nv -> {
					LoaiNhanVien loaiNV = new LoaiNhanVien();
					loaiNV = DAO_LoaiNV.layLoaiNhanVien_TheoMaLoaiNhanVien(nv.getloaiNhanVien().getMaLoaiNhanVien());
					String gender = nv.isGioiTinh() ? "Nam" : "Nữ";
					Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(), gender,
							nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(),
							nv.getAnhThe() };
					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void TimNhanVien_TheoMa() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txt_TimKiem.getText().trim();
		NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(chuoiTimKiem);
		try {
			dsNV.add(nv);
			if (dsNV != null) {
				LoaiNhanVien loaiNV = new LoaiNhanVien();
				loaiNV = DAO_LoaiNV.layLoaiNhanVien_TheoMaLoaiNhanVien(nv.getloaiNhanVien().getMaLoaiNhanVien());
				String gender = nv.isGioiTinh() ? "Nam" : "Nữ";
				Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(), gender,
						nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(),
						nv.getAnhThe() };
				model.addRow(rowData);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có nhân viên nào có mã: " + chuoiTimKiem);
		}
	}

	public void TimNhanVien_TheoSoDT() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txt_TimKiem.getText().trim();
		dsNV = DAO_NV.layTatCaNhanVien();
		boolean ketQuaTim = false;
		for (NhanVien nv : DAO_NV.layTatCaNhanVien()) {
			String gender = nv.isGioiTinh() ? "Nam" : "Nữ";
			LoaiNhanVien loaiNV = new LoaiNhanVien();
			loaiNV = DAO_LoaiNV.layLoaiNhanVien_TheoMaLoaiNhanVien(nv.getloaiNhanVien().getMaLoaiNhanVien());
			String sdt = nv.getSoDienThoai().trim();
			if (sdt.equals(chuoiTimKiem)) {
				Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(), gender,
						nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(),
						nv.getAnhThe() };
				model.addRow(rowData);
				ketQuaTim = true;
			}
		}

		if (!ketQuaTim) {
			JOptionPane.showMessageDialog(null, "Không có nhân viên nào có số điện thoại: " + chuoiTimKiem);
		}
	}

	public void TimNhanVien_TheoCCCD() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txt_TimKiem.getText().trim();
		dsNV = DAO_NV.layTatCaNhanVien();
		boolean ketQuaTim = false;
		for (NhanVien nv : DAO_NV.layTatCaNhanVien()) {
			String gender = nv.isGioiTinh() ? "Nam" : "Nữ";
			LoaiNhanVien loaiNV = new LoaiNhanVien();
			loaiNV = DAO_LoaiNV.layLoaiNhanVien_TheoMaLoaiNhanVien(nv.getloaiNhanVien().getMaLoaiNhanVien());
			String cccd = nv.getCCCD().trim();
			if (cccd.equals(chuoiTimKiem)) {
				Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(), gender,
						nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(),
						nv.getAnhThe() };
				model.addRow(rowData);
				ketQuaTim = true;
			}
		}

		if (!ketQuaTim) {
			JOptionPane.showMessageDialog(null, "Không có nhân viên nào có chứng minh thư: " + chuoiTimKiem);
		}
	}

	public void LocDuLieu() {
		int loc_tuoiTu, loc_tuoiDen; // Lấy tuổi
		try {
			loc_tuoiTu = Integer.parseInt(txt_TuoiTu.getText().trim());
		} catch (NumberFormatException e) { // Xử lý ngoại lệ nếu người dùng không nhập số tuổi tối thiểu
			loc_tuoiTu = 0;
		}
		try {
			loc_tuoiDen = Integer.parseInt(txt_TuoiDen.getText().trim());
		} catch (NumberFormatException e) {// Xử lý ngoại lệ nếu người dùng không nhập số tuổi tối đa
			loc_tuoiDen = Integer.MAX_VALUE; // Lọc theo tất cả các tuổi
		}

		// Kiểm tra nếu không chọn lọc theo giới tính thì mặc định là lọc tất cả
		boolean loc_nam = chcbx_Nam.isSelected();
		boolean loc_nu = chcbx_Nu.isSelected();
		boolean loc_tatCa_GioiTinh = !loc_nam && !loc_nu; // Nếu cả nam và nữ đều không được chọn

		boolean loc_TrangThai_ConLam = chcbx_ConLam.isSelected();
		boolean loc_TrangThai_NghiLam = chcbx_NghiLam.isSelected();
		boolean loc_TrangThai_NghiPhep = chcbx_NghiPhep.isSelected();
		boolean loc_TrangThai_TatCa = !loc_TrangThai_ConLam && !loc_TrangThai_NghiLam && !loc_TrangThai_NghiPhep;

		boolean loc_ChucVu_QuanLy = chcbx_QuanLy.isSelected();
		boolean loc_ChucVu_ThuNgan = chcbx_ThuNgan.isSelected();
		boolean loc_ChucVu_TiepTan = chcbx_TiepTan.isSelected();
		boolean loc_ChucVu_TatCa = !loc_ChucVu_QuanLy && !loc_ChucVu_ThuNgan && !loc_ChucVu_TiepTan;

		model.getDataVector().removeAllElements();
		boolean ketQuaLoc = false;

		for (NhanVien nv : DAO_NV.layTatCaNhanVien()) {
			String gender = nv.isGioiTinh() ? "Nam" : "Nữ";
			Calendar ngayHienTai = Calendar.getInstance();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nv.getNgaySinh());
			int tuoi = ngayHienTai.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
			LoaiNhanVien loaiNV = new LoaiNhanVien();
			loaiNV = DAO_LoaiNV.layLoaiNhanVien_TheoMaLoaiNhanVien(nv.getloaiNhanVien().getMaLoaiNhanVien());
			
			
			if ((loc_tatCa_GioiTinh || (loc_nam && nv.isGioiTinh()) || (loc_nu && !nv.isGioiTinh()))
					&& (loc_tuoiTu <= tuoi && tuoi <= loc_tuoiDen)
					&& ((loc_ChucVu_TatCa) || (loc_ChucVu_QuanLy && loaiNV.getTenLoaiNhanVien().equals("Quản lý"))
							|| (loc_ChucVu_ThuNgan && loaiNV.getTenLoaiNhanVien().equals("Nhân viên thu ngân"))
							|| (loc_ChucVu_TiepTan && loaiNV.getTenLoaiNhanVien().equals("Nhân viên tiếp tân")))
					&& ((loc_TrangThai_TatCa) || (loc_TrangThai_ConLam && nv.getTrangThai().equals("Còn làm"))
							|| (loc_TrangThai_NghiLam && nv.getTrangThai().equals("Nghỉ làm"))
							|| (loc_TrangThai_NghiPhep && nv.getTrangThai().equals("Nghỉ phép")))) {
				
				Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(), gender,
						nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(),
						nv.getAnhThe() };
				model.addRow(rowData);
				ketQuaLoc = true;
			}
		}

		if (!ketQuaLoc) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp với tiêu chí lọc.");
		}
	}

}
