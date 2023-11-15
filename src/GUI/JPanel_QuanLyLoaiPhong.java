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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.Phong_DAO;
import Entity.KhachHang;
import Entity.LoaiPhong;
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

public class JPanel_QuanLyLoaiPhong extends JPanel implements ActionListener {

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

	private JTable table_LoaiPhong;
	private JTextField textField;

	private JButton btnThem;

	private ArrayList<KhachHang> dsKH;
	private LoaiPhong_DAO DAO_LP;
	private ArrayList<LoaiPhong> dsLP;

	private Phong_DAO DAO_P;
	private DefaultTableModel model;
	private JButton btnLamMoi;

	private String[] rowData;


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
	public JPanel_QuanLyLoaiPhong() {
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

		table_LoaiPhong = new JTable();
		table_LoaiPhong.setBackground(Color.WHITE);

		table_LoaiPhong.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã loại phòng",
				"Tên loại phòng", "Số lượng khách tối đa", "Giá tiền", "Hình ảnh", "Mô tả" })
		{
			@Override
            public boolean isCellEditable(int row, int column) {
                // Ngăn chặn việc chỉnh sửa nội dung trong bảng, nhưng vẫn cho phép chọn dữ liệu
                return false;
            }
		}
				);

		table_LoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_LoaiPhong);
		scrollPane.setViewportView(table_LoaiPhong);

		panel_Table.add(scrollPane);

		docDuLieu();

		table_LoaiPhong.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int row = table_LoaiPhong.getSelectedRow();

					String maLoaiPhong = model.getValueAt(row, 0).toString();
					String tenPhong = model.getValueAt(row, 1).toString();
					String soLuong = model.getValueAt(row, 2).toString();
					String giaTien = model.getValueAt(row, 3).toString();
					String hinhAnh = model.getValueAt(row, 4).toString();
					String moTa = model.getValueAt(row, 5).toString();
	
					Modal_ThemLoaiPhong modal_loaiPhong = new Modal_ThemLoaiPhong(hinhAnh);
					modal_loaiPhong.setVisible(true);
					modal_loaiPhong.setModalThemLoaiPhong(maLoaiPhong, tenPhong, giaTien, soLuong, hinhAnh, moTa);
					
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

		btnThem.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(Color.decode(hexColor_Green));
		btnThem.setBounds(10, 0, 125, 35);
		panel.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int row = table_LoaiPhong.getSelectedRow();
				String maLP = model.getValueAt(row, 0).toString();
				LoaiPhong lp = new LoaiPhong(maLP);
				try {
					Phong p = new Phong();
					DAO_P = new Phong_DAO();
					
					ArrayList<Phong> dsP = DAO_P.timDSPhongTheoMaLoaiPhong(maLP);
					
					
					for( Phong value : dsP) {
						DAO_P.xoaPhong(value);
					}
					
					DAO_LP = new LoaiPhong_DAO();
					String tenLoaiPhong = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(maLP).getTenLoaiPhong();	
					DAO_LP.xoaLoaiPhong(lp);
					JOptionPane.showMessageDialog(null, "Xóa " + tenLoaiPhong + " thành công");
					model.removeRow(row);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại");
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/trash.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnXoa.setBackground(Color.decode(hexColor_Red));
		btnXoa.setBounds(145, 0, 125, 35);
		panel.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/refresh.png")));
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
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// Add event:
		btnThem.addActionListener((ActionListener) this);
		btnLamMoi.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			Modal_ThemLoaiPhong modal_laoPhong = new Modal_ThemLoaiPhong("");
			modal_laoPhong.setVisible(true);
		}
		
		if(o.equals(btnLamMoi)) {
			docDuLieu();
		}

	}
	
	public void docDuLieu() {
		model = (DefaultTableModel) table_LoaiPhong.getModel();
		model.getDataVector().removeAllElements();
		
		DAO_LP = new LoaiPhong_DAO();
		
		try {
			dsLP = DAO_LP.layTatCaLoaiPhong();
			if (dsLP != null) {
				dsLP.forEach(lp -> {

					Object[] rowData = { lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getSoLuongToiDa(),
							lp.getGiaTien(), lp.getHinhAnh(), lp.getMoTa() };

					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}