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
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.data.Values;

import com.toedter.calendar.JDateChooser;

import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
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

	private ImageIcon addIcon;
	private JTextField txtTenPhong;
	private JPanel panel_TimKiem;
	private JTextField txtKhachHang;
	private JTextField textField_2;
	private JLabel lblTrangThai;
	private JComboBox cbTrangThai;
	private DefaultTableModel model;
	private Modal_PhieuDatPhongTruoc modal_PhieuDatPhongTruoc;
	private JDialog_ChiTietPhieuDatPhongTruoc dialog_CTPDP;
	private Modal_CapNhatPhieuDatPhongTruoc modal_CapNhatPhieuDatPhongTruoc;
	private String[] rowData;

	private ArrayList<PhieuDatPhong> dsPDP;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<NhanVien> dsNV;
	private ArrayList<Phong> dsPhong;

	private PhieuDatPhong_DAO DAO_PDP;
	private KhachHang_DAO DAO_KH;
	private NhanVien_DAO DAO_NV;
	private Phong_DAO DAO_P;

	private KhachHang kh;
	private NhanVien nv;
	private Phong p;
	private PhieuDatPhong pdp;

	private JButton btnTimKiem;
	private JButton btnHuyPDP;
	private JButton btnLamMoi;
	private JButton btnSua;
	private JButton btnThem;

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
	public JPanel_QuanLyPhieuDatPhong(NhanVien nv) {
		this.nv = nv;
		System.out.println("PDP:::::");
		System.out.println(nv.toString());
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
		add(panel);
		panel.setLayout(null);

		modal_PhieuDatPhongTruoc = new Modal_PhieuDatPhongTruoc(nv);
		dialog_CTPDP = new JDialog_ChiTietPhieuDatPhongTruoc();
		modal_CapNhatPhieuDatPhongTruoc = new Modal_CapNhatPhieuDatPhongTruoc(nv);

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
		table_PhieuDatPhong.setModel(model = new DefaultTableModel(new Object[][] {},
				rowData = new String[] { "Mã phiếu đặt", "Tên phòng", "Tên nhân viên", "Tên khách hàng",
						"Thời gian đặt phòng", "Thời gian nhận phòng", "Tiền cọc", "Trạng thái", "Mô tả" }) {
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			}

		});

		table_PhieuDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		table_PhieuDatPhong.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					int row = table_PhieuDatPhong.getSelectedRow();
					String maPD = model.getValueAt(row, 0).toString();
					dialog_CTPDP.setVisible(true);
					dialog_CTPDP.HienThongTinTheoMaPDP(maPD);

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
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_PhieuDatPhong);
		scrollPane.setViewportView(table_PhieuDatPhong);
		panel_Table.add(scrollPane);

		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_KH = new KhachHang_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_P = new Phong_DAO();

		pdp = new PhieuDatPhong();
		kh = new KhachHang();
		nv = new NhanVien();
		p = new Phong();

		DefaultTableModel model = (DefaultTableModel) table_PhieuDatPhong.getModel();
		DocDuLieuTrenSQL();

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
		panel_TimKiem.add(dateChooser);

		JLabel dcNgayDat = new JLabel("Ngày đặt");
		dcNgayDat.setFont(new Font("Segoe UI", Font.BOLD, 15));
		dcNgayDat.setBounds(10, 276, 122, 30);
		panel_TimKiem.add(dcNgayDat);

		cbTrangThai = new JComboBox();
		cbTrangThai.setBounds(10, 226, 235, 30);
		panel_TimKiem.add(cbTrangThai);

		DefaultComboBoxModel<String> dataModelTT = new DefaultComboBoxModel<String>();
		dataModelTT.addElement("Chờ nhận phòng");
		dataModelTT.addElement("Đã hủy");
		dataModelTT.addElement("Hết hạn");

		cbTrangThai.setModel(dataModelTT);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimKiemTheoTrangThai();
			}
		});

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
		btnHuyPDP = new JButton("Hủy phiếu");
		btnHuyPDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HuyPhieu();
			}

		});
		btnHuyPDP.setIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/trash.png")));
		btnHuyPDP.setForeground(Color.WHITE);
		btnHuyPDP.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnHuyPDP.setBackground(Color.decode(hexColor_Red));
		btnHuyPDP.setBounds(749, 0, 135, 35);
		panel.add(btnHuyPDP);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setBounds(894, 0, 135, 35);
		panel.add(btnLamMoi);

		btnSua = new JButton("Sửa phiếu");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_PhieuDatPhong.getSelectedRow();
				String maPD = model.getValueAt(row, 0).toString();
				System.out.println(maPD);
				modal_CapNhatPhieuDatPhongTruoc.setVisible(true);
				modal_CapNhatPhieuDatPhongTruoc.HienThongTinTheoMaPDP(maPD);
			}
		});
		btnSua.setSelectedIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/update.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSua.setBackground(Color.decode(hexColor_Green));
		btnSua.setBounds(604, 0, 135, 35);
		panel.add(btnSua);

		btnThem = new JButton("Thêm");

		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modal_PhieuDatPhongTruoc.setVisible(true);
			}
		});

		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(new Color(75, 172, 77));
		btnThem.setBounds(458, 0, 135, 35);
		panel.add(btnThem);

	}

	private void clearTable() {
		DefaultTableModel dm = (DefaultTableModel) table_PhieuDatPhong.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void TimKiemTheoTrangThai() {
		String tt = cbTrangThai.getSelectedItem().toString();
		System.out.println(tt);
		dsPDP = DAO_PDP.layPhieuDatPhong_TheoTrangThaiPhieu(tt);
	
		if (dsPDP != null) {
			clearTable();
			for (PhieuDatPhong pdp : dsPDP) {
				KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());
				NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(pdp.getNhanVien().getMaNhanVien());
				Phong p = DAO_P.timPhong_TheoMaPhong(pdp.getPhong().getMaPhong());

				Object[] rowData = { pdp.getMaPhieuDat(), p.getTenPhong(), nv.getHoTen(), kh.getHoTen(),
						pdp.getThoiGianDatPhong(), pdp.getThoiGianNhanPhong(), pdp.getTienCoc(), pdp.getTrangThai(),
						pdp.getMoTa() };

				model.addRow(rowData);

			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy");
			
		}
	}

	public void HuyPhieu() {
		int row = table_PhieuDatPhong.getSelectedRow();
		String maPDP = (String) model.getValueAt(row, 0);
		pdp = DAO_PDP.layPhieuDatPhong_TheoMaPhieuDat(maPDP);
		try {
			if (pdp.getTrangThai().equals("Chờ nhận phòng")) {
				int choice = JOptionPane.showConfirmDialog(this,
						"Bạn có chắc chắn muốn hủy phiếu đặt phòng " + maPDP + "không ?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					if (DAO_PDP.HuyPhieuDatPhong(maPDP)) {
						JOptionPane.showMessageDialog(null, "Hủy thành công phiếu " + maPDP);
						clearTable();
						DocDuLieuTrenSQL();
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "Phiếu " + maPDP + "không thể hủy!");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Phiếu " + maPDP + "hủy thất bại!");
		}

	}

	private void DocDuLieuTrenSQL() {
		dsPDP = DAO_PDP.layTatCaPhieuDatPhong();

		if (dsPDP != null) {
			for (PhieuDatPhong pdp : dsPDP) {
				KhachHang kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());
				NhanVien nv = DAO_NV.timNhanVien_TheoMaNhanVien(pdp.getNhanVien().getMaNhanVien());
				Phong p = DAO_P.timPhong_TheoMaPhong(pdp.getPhong().getMaPhong());

				Object[] rowData = { pdp.getMaPhieuDat(), p.getTenPhong(), nv.getHoTen(), kh.getHoTen(),
						pdp.getThoiGianDatPhong(), pdp.getThoiGianNhanPhong(), pdp.getTienCoc(), pdp.getTrangThai(),
						pdp.getMoTa() };

				model.addRow(rowData);

			}
		}
	}

	private void capNhat() {
		int row = table_PhieuDatPhong.getSelectedRow();
		String maPDP = (String) model.getValueAt(row, 0);
		PhieuDatPhong pdp = DAO_PDP.layPhieuDatPhong_TheoMaPhieuDat(maPDP);
		try {
			if (pdp.getTrangThai() == "Đang đợi") {
				int choice = JOptionPane.showConfirmDialog(this,
						"Bạn có chắc chắn muốn cập nhật phiếu đặt phòng " + maPDP + "không ?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					if (DAO_PDP.capNhatPhieuDatPhong(pdp)) {
						JOptionPane.showMessageDialog(null, "Cập nhật thành công phiếu " + maPDP);
						clearTable();
						DocDuLieuTrenSQL();
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "Phiếu " + maPDP + "không thể cập nhật!");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Phiếu " + maPDP + "cập nhật thất bại!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
