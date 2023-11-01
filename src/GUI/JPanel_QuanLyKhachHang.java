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
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import Entity.KhachHang;
import Entity.Phong;

import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;


public class JPanel_QuanLyKhachHang extends JPanel implements ActionListener {

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt_TuoiDen;
	private JTextField txt_TuoiTu;
	private JCheckBox chcbx_Nam;
	private JCheckBox chcbx_Nu;
	private JCheckBox chcbx_TatCa;
	private ButtonGroup btnGr_LocTheoGioiTinh;

	private JButton btnThemKhachHang;

//	private AbstractButton btnThem;

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
					modal_ThemKhachHang.setModal_ThemKhachHang(maKhachHang, hoTen, gioiTinh, ngaySinh, sdt, diaChi, ghiChu);

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

		chcbx_Nu = new JCheckBox("Nữ");
		chcbx_Nu.setBackground(new Color(255, 255, 255));
		chcbx_Nu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chcbx_Nu.setBounds(72, 35, 64, 21);
		pnl_Loc_TheoGioiTinh.add(chcbx_Nu);

		chcbx_TatCa = new JCheckBox("Tất cả");
		chcbx_TatCa.setBackground(new Color(255, 255, 255));
		chcbx_TatCa.setFont(new Font("Tahoma", Font.PLAIN, 13));
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

		JPanel pnl_Loc_TheoNgaySinh = new JPanel();
		pnl_Loc_TheoNgaySinh.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoNgaySinh.setBackground(new Color(255, 255, 255));
		pnl_Loc_TheoNgaySinh.setLayout(null);
		pnl_Loc_TheoNgaySinh.setBounds(10, 115, 235, 97);
		pnl_Loc.add(pnl_Loc_TheoNgaySinh);

		JLabel lbl_Loc_NgaySinh = new JLabel("Ngày sinh");
		lbl_Loc_NgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_Loc_NgaySinh.setBounds(10, 10, 100, 16);
		pnl_Loc_TheoNgaySinh.add(lbl_Loc_NgaySinh);

		JLabel lbl_NgayBatDau = new JLabel("Từ :");
		lbl_NgayBatDau.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_NgayBatDau.setBounds(10, 40, 45, 13);
		pnl_Loc_TheoNgaySinh.add(lbl_NgayBatDau);

		JLabel lbl_NgayBatDau_1 = new JLabel("Đến :");
		lbl_NgayBatDau_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_NgayBatDau_1.setBounds(10, 66, 45, 13);
		pnl_Loc_TheoNgaySinh.add(lbl_NgayBatDau_1);

		JDateChooser dateCh_NgayTu = new JDateChooser();
		dateCh_NgayTu.setBounds(46, 35, 179, 19);
		pnl_Loc_TheoNgaySinh.add(dateCh_NgayTu);

		JDateChooser dateCh_NgayDen = new JDateChooser();
		dateCh_NgayDen.setBounds(46, 60, 179, 19);
		pnl_Loc_TheoNgaySinh.add(dateCh_NgayDen);

		JPanel pnl_Loc_TheoDiemThuong = new JPanel();
		pnl_Loc_TheoDiemThuong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnl_Loc_TheoDiemThuong.setBackground(new Color(255, 255, 255));
		pnl_Loc_TheoDiemThuong.setLayout(null);
		pnl_Loc_TheoDiemThuong.setBounds(10, 302, 235, 70);
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

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(155, 38, 70, 19);
		pnl_Loc_TheoDiemThuong.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(40, 38, 70, 19);
		pnl_Loc_TheoDiemThuong.add(textField_1);

		JPanel pnl_Loc_TheoTuoi = new JPanel();
		pnl_Loc_TheoTuoi.setLayout(null);
		pnl_Loc_TheoTuoi.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnl_Loc_TheoTuoi.setBackground(Color.WHITE);
		pnl_Loc_TheoTuoi.setBounds(10, 222, 235, 70);
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

		btnThemKhachHang = new JButton("Thêm");

		btnThemKhachHang.setIcon(new ImageIcon(JPanel_QuanLyKhachHang.class.getResource("/icon/add.png")));
		btnThemKhachHang.setForeground(Color.WHITE);
		btnThemKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThemKhachHang.setBackground(Color.decode(hexColor_Green));
		btnThemKhachHang.setBounds(10, 0, 125, 35);
		panel.add(btnThemKhachHang);

//		btnThem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				modal_ThemKhachHang.setVisible(true);
//				model.fireTableDataChanged();
//				DocDuLieu();
//			}
//		});

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaKhachHang();
//				DocDuLieu();
			}
		});
		btnXoa.setIcon(new ImageIcon(JPanel_QuanLyKhachHang.class.getResource("/icon/trash.png")));
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
		btnTimKiem.setBounds(415, 0, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyKhachHang.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// Add event:
		btnThemKhachHang.addActionListener((ActionListener) this);

		DocDuLieu();
	}

	
	public void setJPanel_QuanLyKhachHang(boolean hiden) {
		if(hiden) {
			DocDuLieu();	
		}
	}
	
	public void DocDuLieu() {
		model = (DefaultTableModel) table_KhachHang.getModel();
		model.getDataVector().removeAllElements();
	
		try {
			dsKH = DAO_KH.layTatCaKhachHang();
			if (dsKH != null) {
				dsKH.forEach(kh -> {
					String gender;
					if (kh.isGioiTinh()) {
						gender = "Nam";
					} else {
						gender = "Nữ";
					}
					Object[] rowData = { kh.getMaKhachHang(), kh.getHoTen(), gender, kh.getNgaySinh(), kh.getDiaChi(),
							kh.getSoDienThoai(), kh.getDiemThuong(), kh.getGhiChu() };
					model.addRow(rowData);
					table_KhachHang.setModel(model);
				});	
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu");
		}
	}
	
	public void XoaKhachHang () {
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
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThemKhachHang)) {
			Modal_ThemKhachHang modalTKH = new Modal_ThemKhachHang();
			modalTKH.setVisible(true);
		}

	}

}
