package GUI;

import javax.swing.JPanel;
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
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DichVu_DAO;
import DAO.KhachHang_DAO;
import DAO.ThongTinDichVu_DAO;
import Entity.DichVu;
import Entity.KhachHang;
import Entity.Phong;
import Entity.ThongTinDichVu;

import javax.swing.JButton;
import javax.swing.AbstractButton;
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

public class JPanel_QuanLyDichVu extends JPanel implements ActionListener {

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

	private JTable table_DichVu;
	private JTextField textField;

	private JButton btnThem;

	private KhachHang_DAO DAO_KH;
	private ArrayList<KhachHang> dsKH;
	private DichVu_DAO DAO_DV;
	private ArrayList<DichVu> dsDV;
	private String[] rowData;
	private DefaultTableModel model_dichVu;
	private Modal_ThemDichVu modal_ThemDichVu;
	private JButton btnLamMoi;
	private AbstractButton btnXoa;
	private JButton btnTrangDau;
	private JButton btnTrangSau;
	private JButton btnTrangTruoc;
	private JTextField txtTrang;
	private JButton btnTrangCuoi;
	private JTextField txt_TongTrang;
	private JLabel lblNewLabel;

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
	public JPanel_QuanLyDichVu() {
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

		table_DichVu = new JTable();
		table_DichVu.setBackground(Color.WHITE);
		rowData = new String[] { "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn vị tính", "Đơn giá", "Trạng thái" };
		table_DichVu.setModel(new DefaultTableModel(new Object[][] {}, rowData));
		table_DichVu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table_DichVu.setModel(new DefaultTableModel(new Object[][] {}, rowData) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			}
		});
		model_dichVu = (DefaultTableModel) table_DichVu.getModel();

		table_DichVu.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					int row = table_DichVu.getSelectedRow();
//	            	txtDiaDiem.setText(model.getValueAt(row, 2).toString());
//	        		date_KH.setDate((Date) model.getValueAt(row, 3));
					String maDichVu = model_dichVu.getValueAt(row, 0).toString();
					String tenDichVu = model_dichVu.getValueAt(row, 1).toString();
					String soLuong = model_dichVu.getValueAt(row, 2).toString();
					String donViTinh = model_dichVu.getValueAt(row, 3).toString();
					String donGia = model_dichVu.getValueAt(row, 4).toString();
					String trangThai = model_dichVu.getValueAt(row, 5).toString();
					Modal_CapNhatDichVu md_cn = new Modal_CapNhatDichVu(maDichVu, tenDichVu, soLuong, donViTinh, donGia,
							trangThai);

					md_cn.setVisible(true);

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 500);
		scrollPane.add(table_DichVu);
		scrollPane.setViewportView(table_DichVu);

		panel_Table.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(1031, 10, 255, 615);
		panel_Table.add(panel_1);

		btnThem = new JButton("Thêm");

		btnThem.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(Color.decode(hexColor_Green));
		btnThem.setBounds(10, 0, 125, 35);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");

		btnXoa.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/trash.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnXoa.setBackground(Color.decode(hexColor_Red));
		btnXoa.setBounds(145, 0, 125, 35);
		panel.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setBounds(280, 0, 125, 35);
		panel.add(btnLamMoi);

		textField = new JTextField();
		textField.setBounds(545, 0, 223, 34);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(415, 0, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// panigation

		// btnTrangDau
		btnTrangDau = new JButton("");
		btnTrangDau.setForeground(new Color(255, 255, 255));
		btnTrangDau.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/skip_to_start_20px.png")));
		btnTrangDau.setFocusPainted(false);
		btnTrangDau.setBorder(null);
		btnTrangDau.setBackground(Color.decode(hexColor_Blue3));
		btnTrangDau.setBounds(403, 585, 30, 25);

		// btnTrangSau
		btnTrangSau = new JButton("");
		btnTrangSau.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/rewind_20px.png")));
		btnTrangSau.setFocusPainted(false);
		btnTrangSau.setBorder(null);
		btnTrangSau.setBackground(Color.decode(hexColor_Blue3));
		btnTrangSau.setBounds(440, 585, 30, 25);

		// btnTrang Hientai
		txtTrang = new JTextField();
		txtTrang.setEditable(false);
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setColumns(5);
		txtTrang.setBounds(482, 585, 30, 25);

		// btnTrangTruoc
		btnTrangTruoc = new JButton("");
		btnTrangTruoc.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/fast_forward_20px.png")));
		btnTrangTruoc.setFocusPainted(false);
		btnTrangTruoc.setBorder(null);
		btnTrangTruoc.setBackground(Color.decode(hexColor_Blue3));
		btnTrangTruoc.setBounds(522, 585, 30, 25);

		// btnTrangCuoi
		btnTrangCuoi = new JButton("");
		btnTrangCuoi.setIcon(new ImageIcon(JPanel_QuanLyDichVu.class.getResource("/icon/end_20px.png")));
		btnTrangCuoi.setFocusPainted(false);
		btnTrangCuoi.setBorder(null);
		btnTrangCuoi.setBackground(Color.decode(hexColor_Blue3));
		btnTrangCuoi.setBounds(559, 585, 30, 25);
		JPanel panel_panigation = new JPanel();
		panel_panigation.setBackground(new Color(255, 255, 255));
		panel_panigation.setBounds(337, 541, 356, 31);
		panel_Table.add(panel_panigation);

		panel_panigation.add(btnTrangDau);
		panel_panigation.add(btnTrangSau);
		panel_panigation.add(txtTrang);

		lblNewLabel = new JLabel("/");
		panel_panigation.add(lblNewLabel);

		txt_TongTrang = new JTextField();
		txt_TongTrang.setEditable(false);
		panel_panigation.add(txt_TongTrang);
		txt_TongTrang.setColumns(5);

		DAO_DV = new DichVu_DAO();
		int soLuong = DAO_DV.soLuongDichVu() / 15;

		if (DAO_DV.soLuongDichVu() % 15 > 0) {

			soLuong = DAO_DV.soLuongDichVu() / 15 + 1;
		}

		txt_TongTrang.setText(Integer.toString(soLuong));
		panel_panigation.add(btnTrangTruoc);
		panel_panigation.add(btnTrangCuoi);
		// Add event:
		denTrangDau();
		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);

		// Chuyen trang
		btnTrangCuoi.addActionListener(this);
		btnTrangDau.addActionListener(this);
		btnTrangSau.addActionListener(this);
		btnTrangTruoc.addActionListener(this);

		// panigation
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			modal_ThemDichVu = new Modal_ThemDichVu();
			modal_ThemDichVu.setVisible(true);
		}
		if (o.equals(btnLamMoi)) {
			xoaDL();
			denTrangDau();
		}
		if (o.equals(btnXoa)) {
			int row = table_DichVu.getSelectedRow();
			String maDichVu = model_dichVu.getValueAt(row, 0).toString();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn dòng cần xóa");
			} else {
				int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dịch vụ này?", "Xóa",
						JOptionPane.YES_NO_OPTION);
				if (t == JOptionPane.YES_OPTION) {
					DichVu dv = new DichVu(maDichVu);
					ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
					if (DAO_TTDV.xoaThongTinDichVu_TheoMaDichVu(maDichVu) && DAO_DV.xoaDichVu(dv)) {
						xoaDL();
						JOptionPane.showMessageDialog(null, "Xóa dịch vụ thành công");
						table_DichVu.clearSelection();
						DocDLDichVu(1, 15);

					} else {
						JOptionPane.showMessageDialog(null, "Thất bại, vui lòng thử lại");
					}
				}
			}
		}
		if (o.equals(btnTrangSau)) {
			denTrangSau();
		}
		if (o.equals(btnTrangTruoc)) {
			denTrangTruoc();
		}
		if (o.equals(btnTrangDau)) {
			denTrangDau();
		}
		if (o.equals(btnTrangCuoi)) {
			denTrangCuoiDichVu();
		}

	}

	public void xoaDL() {
		model_dichVu.getDataVector().removeAllElements();
		model_dichVu.fireTableDataChanged();
	}

	public void DocDLDichVu() {
		DAO_DV = new DichVu_DAO();

		try {
			dsDV = DAO_DV.layTatCaDichVu();
			if (dsDV != null) {
				dsDV.forEach(dv -> {

					Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(), dv.getSoLuong(), dv.getDonViTinh(),
							dv.getDonGia(), dv.getTrangThai() == true ? "Còn hàng" : "Hết hàng" };

					model_dichVu.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void DocDLDichVu(int fn, int ln) {
		DAO_DV = new DichVu_DAO();
		ArrayList<DichVu> dsDV = DAO_DV.phanTrangDichVu(fn, ln);
		dsDV.forEach(dv -> {
			Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(), dv.getSoLuong(), dv.getDonViTinh(),
					dv.getDonGia(), dv.getTrangThai() == true ? "Còn hàng" : "Hết hàng" };

			model_dichVu.addRow(rowData);
		});

	}

	public void denTrangTruoc() {

		int soLuong = DAO_DV.soLuongDichVu();
		int soTrang = Integer.parseInt(txtTrang.getText());

		int trangLonNhat;
		if (soLuong % 15 == 0) {
			trangLonNhat = soLuong / 15;
		} else {
			trangLonNhat = soLuong / 15 + 1;
		}
		if (soTrang < trangLonNhat) {
			txtTrang.setText(String.valueOf(soTrang + 1));
			int fn = 15 * soTrang + 1;
			int ln = fn + 14;
			xoaDL();
			DocDLDichVu(fn, ln);
			table_DichVu.clearSelection();

		}
	}

	public void denTrangSau() {

		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int fn = 15 * (trang - 2) + 1;
			int ln = fn + 14;
			xoaDL();
			DocDLDichVu(fn, ln);
			table_DichVu.clearSelection();
		}

	}

	public void denTrangDau() {
		xoaDL();
		DocDLDichVu(1, 15);
		txtTrang.setText(String.valueOf(1));
		table_DichVu.clearSelection();

	}

	public void denTrangCuoiDichVu() {

		int soLuong = DAO_DV.soLuongDichVu();
		int trangCuoi;
		if (soLuong % 15 == 0) {
			trangCuoi = soLuong / 15;
		} else {
			trangCuoi = soLuong / 15 + 1;
		}
		int fn = (trangCuoi - 1) * 15 + 1;
		int ln = fn + 14;
		xoaDL();
		DocDLDichVu(fn, ln);
		txtTrang.setText(String.valueOf(trangCuoi));
		table_DichVu.clearSelection();

	}

	public void trangHienTai() {

		int trang = Integer.parseInt(txtTrang.getText());
		int ln = trang * 15;
		int fn = ln - 14;
		xoaDL();
		DocDLDichVu(fn, ln);

	}

	
}
