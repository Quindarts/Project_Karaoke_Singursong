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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import DAO.LoaiNhanVien_DAO;
import DAO.NhanVien_DAO;
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
	private DefaultTableModel model;
	private Modal_ThemNhanVien model_ThemNhanVien;

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
		table_NhanVien.setModel(new DefaultTableModel(new Object[][] {},
				header));
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
					String anhThe = model.getValueAt(row, 9).toString();
					model_ThemNhanVien = new Modal_ThemNhanVien();
					model_ThemNhanVien.setVisible(true);
					model_ThemNhanVien.setModal_ThemNhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, sdt, cccd, diaChi, trangThai, anhThe);
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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(1031, 10, 255, 615);
		panel_Table.add(panel_1);

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
		btnLamMoi.setBounds(280, 0, 125, 35);
		panel.add(btnLamMoi);

		txt_TimKiem = new JTextField();
		txt_TimKiem.setBounds(545, 0, 223, 34);
		panel.add(txt_TimKiem);
		txt_TimKiem.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(415, 0, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyNhanVien.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		rdBtn_TimTheoMaKH = new JRadioButton("Mã nhân viên");
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
		
		// Add event:
		btnThem.addActionListener((ActionListener) this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		
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
			if(rdBtn_TimTheoMaKH.isSelected()) {
				TimNhanVien_TheoMa();
			}
			else if (rdBtn_TimTheoSoDT.isSelected()) {
				TimNhanVien_TheoSoDT();
			}
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
					Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(),
							gender , nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(), nv.getAnhThe()};

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
				Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(),
						gender , nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(), nv.getAnhThe()};

				model.addRow(rowData);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có nhân viên nào có mã: " + chuoiTimKiem);
		}
	}
	
	public void TimNhanVien_TheoSoDT() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txt_TimKiem.getText().trim();
		NhanVien nv = DAO_NV.timNhanVien_TheoSoDienThoai(chuoiTimKiem);
		try {
			dsNV.add(nv);
			if (dsNV != null) {
				LoaiNhanVien loaiNV = new LoaiNhanVien();
				loaiNV = DAO_LoaiNV.layLoaiNhanVien_TheoMaLoaiNhanVien(nv.getloaiNhanVien().getMaLoaiNhanVien());
				String gender = nv.isGioiTinh() ? "Nam" : "Nữ";
				Object[] rowData = { nv.getMaNhanVien(), loaiNV.getTenLoaiNhanVien(), nv.getHoTen(),
						gender , nv.getNgaySinh(), nv.getSoDienThoai(), nv.getCCCD(), nv.getDiaChi(), nv.getTrangThai(), nv.getAnhThe()};

				model.addRow(rowData);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có nhân viên nào có mã: " + chuoiTimKiem);
		}
	}
}
