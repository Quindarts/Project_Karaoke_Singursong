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
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import DAO.KhachHang_DAO;
import DAO.PhieuDatPhong_DAO;
import Entity.KhachHang;
import Entity.PhieuDatPhong;
import Entity.Phong;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;

public class JPanel_QuanLyPhieuDatPhong extends JPanel implements ActionListener {

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

	private JTable table_PhieuDatPhong;

	private PhieuDatPhong_DAO DAO_PDP;
	private ArrayList<PhieuDatPhong> dsPDP;
	private ImageIcon addIcon;
	private JTextField txtTenPhong;
	private JPanel panel_TimKiem;
	private JTextField txtKhachHang;
	private JTextField textField_2;
	private JLabel lblTrangThai;
	private JComboBox cbTrangThai;

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
	public JPanel_QuanLyPhieuDatPhong() {
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
		add(panel);
		panel.setLayout(null);

		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_Table.setBackground(Color.decode(hexColor_Blue1));
		panel_Table.setBounds(0, 37, 1296, 635);
		panel.add(panel_Table);
		panel_Table.setLayout(null);

		addIcon = new ImageIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/add.png")).getImage()
				.getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		table_PhieuDatPhong = new JTable();
		table_PhieuDatPhong.setBackground(Color.WHITE);
		table_PhieuDatPhong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phiếu đặt", "Tên phòng", "Tên nhân viên", "Tên khách hàng", "Thời gian đặt phòng",
						"Thời gian nhận phòng", "Tiền cọc", "Trạng thái", "Mô tả", "Hủy" }));

		table_PhieuDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_PhieuDatPhong);
		scrollPane.setViewportView(table_PhieuDatPhong);
		panel_Table.add(scrollPane);

		DAO_PDP = new PhieuDatPhong_DAO();
		DefaultTableModel model = (DefaultTableModel) table_PhieuDatPhong.getModel();
		try {
			dsPDP = DAO_PDP.layTatCaPhieuDatPhong();
			if (dsPDP != null) {
				dsPDP.forEach(pdp -> {

					Object[] rowData = { pdp.getMaPhieuDat(), pdp.getPhong().getMaPhong(),
							pdp.getNhanVien().getMaNhanVien(), pdp.getKhachHang().getMaKhachHang(),
							pdp.getThoiGianDatPhong(), pdp.getThoiGianNhanPhong(), pdp.getTienCoc(), pdp.getTrangThai(),
							pdp.getMoTa(), addIcon };

					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

//		table_PhieuDatPhong.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int row = table_PhieuDatPhong.getSelectedRow();
//            	txtDiaDiem.setText(model.getValueAt(row, 2).toString());
//        		date_KH.setDate((Date) model.getValueAt(row, 3));
//				String maKhachHang = model.getValueAt(row, 0).toString();
//				String hoTen = model.getValueAt(row, 1).toString();
//				String gioiTinh = model.getValueAt(row, 2).toString();
//				String ngaySinh = model.getValueAt(row, 3).toString();
//				String diaChi = model.getValueAt(row, 4).toString();
//				String sdt = model.getValueAt(row, 5).toString();
//				String diemThuong = model.getValueAt(row, 6).toString();
//				String ghiChu = model.getValueAt(row, 7).toString();
//				System.out.println(maKhachHang + "," + hoTen + "," + gioiTinh + "," + ngaySinh + "," + diaChi + ","
//						+ sdt + "," + diemThuong + "," + ghiChu);
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//			}
//		});

		panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(Color.WHITE);
		panel_TimKiem.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TimKiem.setBounds(1031, 10, 255, 615);
		panel_Table.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);

		txtTenPhong = new JTextField();
		txtTenPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtTenPhong.setBackground(new Color(255, 255, 255));
		txtTenPhong.setToolTipText("Nhập tên phòng");
		txtTenPhong.setBounds(10, 66, 235, 30);
		panel_TimKiem.add(txtTenPhong);
		txtTenPhong.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên phòng");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 36, 122, 30);
		panel_TimKiem.add(lblNewLabel);

		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTnKhchHng.setBounds(10, 106, 122, 30);
		panel_TimKiem.add(lblTnKhchHng);

		txtKhachHang = new JTextField();
		txtKhachHang.setToolTipText("Nhập tên phòng");
		txtKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtKhachHang.setColumns(10);
		txtKhachHang.setBackground(Color.WHITE);
		txtKhachHang.setBounds(10, 146, 235, 30);
		panel_TimKiem.add(txtKhachHang);

		lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTrangThai.setBounds(10, 186, 122, 30);
		panel_TimKiem.add(lblTrangThai);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 316, 235, 27);
//		panel_2.add(dateChooser);
		panel_TimKiem.add(dateChooser);

		JLabel dcNgayDat = new JLabel("Ngày đặt");
		dcNgayDat.setFont(new Font("Segoe UI", Font.BOLD, 15));
		dcNgayDat.setBounds(10, 276, 122, 30);
		panel_TimKiem.add(dcNgayDat);

		cbTrangThai = new JComboBox();
		cbTrangThai.setBounds(10, 226, 235, 30);
		panel_TimKiem.add(cbTrangThai);

		// Đổ giữ liệu vào JCombobox TrangThaiPhong
		DefaultComboBoxModel<String> dataModelTT = new DefaultComboBoxModel<String>();
		dataModelTT.addElement("Chọn trạng thái");
		ArrayList<PhieuDatPhong> listPDP = DAO_PDP.layTatCaPhieuDatPhong();
		if (listPDP != null) {
			for (PhieuDatPhong pdp : listPDP) {
				dataModelTT.addElement(pdp.getTrangThai());
			}
		} else {
			dataModelTT.addElement("Error");
		}
		cbTrangThai.setModel(dataModelTT);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(70, 366, 123, 35);
		panel_TimKiem.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		txtTenPhong.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtTenPhong.setText("");
			}
		});

		JButton btnHuyPDP = new JButton("Hủy phiếu");
		btnHuyPDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHuyPDP.setIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/trash.png")));
		btnHuyPDP.setForeground(Color.WHITE);
		btnHuyPDP.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnHuyPDP.setBackground(Color.decode(hexColor_Red));
		btnHuyPDP.setBounds(10, 0, 125, 35);
		panel.add(btnHuyPDP);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setBounds(145, 0, 125, 35);
		panel.add(btnLamMoi);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

	}

}
