package GUI;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import GUI.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Phong;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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

public class JPanel_BaoCaoThongKe extends JPanel implements ActionListener {

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

	private JTable table_HoaDon;
	private JTextField textField;

	private JButton btnThemKhachHang;

	private KhachHang_DAO DAO_KH;
	private HoaDon_DAO DAO_HD;
	private NhanVien_DAO DAO_NV;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<HoaDon> dsHD;
	private ArrayList<NhanVien> dsNV;

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
	public JPanel_BaoCaoThongKe() {
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

		table_HoaDon = new JTable();
		table_HoaDon.setBackground(Color.WHITE);
		table_HoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Ngày lập", "Khách hàng", "Nhân viên", "Tổng tiền" }));
		table_HoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane_HoaDon = new JScrollPane();
		scrollPane_HoaDon.setBounds(10, 10, 1019, 615);
		scrollPane_HoaDon.add(table_HoaDon);
		scrollPane_HoaDon.setViewportView(table_HoaDon);

		panel_Table.add(scrollPane_HoaDon);

		dsHD = DAO_HD.layTatCaHoaDon();
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
		try {
			
					Object[] rowData = {  };

					model.addRow(rowData);
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		table_HoaDon.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_HoaDon.getSelectedRow();
//            	txtDiaDiem.setText(model.getValueAt(row, 2).toString());
//        		date_KH.setDate((Date) model.getValueAt(row, 3));
//            	String maKhachHang =  model.getValueAt(row, 0).toString();
//            	String hoTen = model.getValueAt(row, 1).toString();
//            	String gioiTinh = model.getValueAt(row, 2).toString();
//            	String ngaySinh = model.getValueAt(row, 3).toString();
//            	String diaChi = model.getValueAt(row, 4).toString();
//            	String sdt = model.getValueAt(row, 5).toString();
//            	String diemThuong = model.getValueAt(row, 6).toString();
//            	String ghiChu = model.getValueAt(row, 7).toString();
//               System.out.println(maKhachHang + "," + hoTen + "," + gioiTinh + "," + ngaySinh + "," + diaChi + "," + sdt + "," + diemThuong + "," + ghiChu );
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

		btnThemKhachHang = new JButton("Thêm");

		btnThemKhachHang.setIcon(new ImageIcon(JPanel_BaoCaoThongKe.class.getResource("/icon/add.png")));
		btnThemKhachHang.setForeground(Color.WHITE);
		btnThemKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThemKhachHang.setBackground(Color.decode(hexColor_Green));
		btnThemKhachHang.setBounds(10, 0, 125, 35);
		panel.add(btnThemKhachHang);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setIcon(new ImageIcon(JPanel_BaoCaoThongKe.class.getResource("/icon/trash.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnXoa.setBackground(Color.decode(hexColor_Red));
		btnXoa.setBounds(145, 0, 125, 35);
		panel.add(btnXoa);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_BaoCaoThongKe.class.getResource("/icon/refresh.png")));
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
		btnTimKiem.setIcon(new ImageIcon(JPanel_BaoCaoThongKe.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// Add event:
		btnThemKhachHang.addActionListener((ActionListener) this);

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