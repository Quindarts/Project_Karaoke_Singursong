package gui;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import dao.KhachHang_DAO;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import dao.TrangThaiPhong_DAO;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import entity.TrangThaiPhong;
import gui.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.geom.RoundRectangle2D;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import org.apache.poi.ss.usermodel.DataFormat;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class JPanel_QuanLyPhong extends JPanel implements ActionListener, ItemListener, KeyListener {

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

	private JTable table_Phong;
	private JTextField txtFindCodeRoom;

	private JButton btnThem;
	private KhachHang_DAO DAO_KH;
	private ArrayList<KhachHang> dsKH;
	private Phong_DAO DAO_P;
	private ArrayList<Phong> dsP;
	private LoaiPhong_DAO DAO_LP;
	private DefaultTableModel model;
	private JButton btnTimKiem;
	private JComboBox<String> cbo_floor;
	private JLabel textField;
	private JComboBox<String> cbo_status;
	private TrangThaiPhong_DAO DAO_TTP;
	private JDateChooser date_From;
	private JDateChooser date_To;
	private JButton btn_find_date;
	private JButton btnXoa;

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
	public JPanel_QuanLyPhong(NhanVien nhanVien) {
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

		table_Phong = new JTable();
		table_Phong.setBackground(Color.WHITE);
		table_Phong.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã phòng", "Tên phòng",
				"Loại phòng", "Trạng thái", "Ngày tạo phòng", "Vị trí phòng", "Ghi chú", "Tình trạng phòng" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Ngăn chặn việc chỉnh sửa nội dung trong bảng, nhưng vẫn cho phép chọn dữ liệu
				return false;
			}
		});
		table_Phong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_Phong);
		scrollPane.setViewportView(table_Phong);

		panel_Table.add(scrollPane);

//		--------
		DocDuLieu();

		table_Phong.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table_Phong.getSelectedRow();

					String maPhong = model.getValueAt(row, 0).toString();
					String tenPhong = model.getValueAt(row, 1).toString();
					String loaiPhong = model.getValueAt(row, 2).toString();
					String trangThai = model.getValueAt(row, 3).toString();
					String ngayTao = model.getValueAt(row, 4).toString();
					String viTri = model.getValueAt(row, 5).toString();
					String ghiChu = model.getValueAt(row, 6).toString();
					String tinhTrang = model.getValueAt(row, 7).toString();

					JDialog_ThemPhong modal_ThemPhong = new JDialog_ThemPhong();
					modal_ThemPhong.setVisible(true);
					modal_ThemPhong.setModal_ThemPhong(maPhong, tenPhong, loaiPhong, trangThai, tinhTrang, viTri,
							ngayTao, ghiChu);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(1031, 10, 255, 615);
		panel_Table.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBounds(27, 25, 204, 161);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		cbo_floor = new JComboBox<String>();
		cbo_floor.setBounds(10, 48, 184, 30);
		panel_2.add(cbo_floor);
		cbo_floor.addItem("Tất cả");
		cbo_floor.addItem("Lầu 1");
		cbo_floor.addItem("Lầu 2");
		cbo_floor.addItem("Lầu 3");
		cbo_floor.addItem("Lầu 4");
		cbo_floor.addItem("Lầu 5");

		cbo_status = new JComboBox<String>();
		cbo_status.setBounds(10, 112, 184, 30);
		panel_2.add(cbo_status);
		cbo_status.addItem("Tất cả");
		cbo_status.addItem("Trống");
		cbo_status.addItem("Đã Đặt");
		cbo_status.addItem("Đang sử dụng");
		cbo_status.addItem("Không phục vụ");

		JLabel lblNewLabel = new JLabel("Lầu: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 25, 75, 20);
		panel_2.add(lblNewLabel);

		JLabel lblTnhTrng = new JLabel("Tình trạng phòng: ");
		lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnhTrng.setBounds(10, 82, 184, 20);
		panel_2.add(lblTnhTrng);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Tìm theo ngày tạo", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 255)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(27, 196, 218, 148);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		date_From = new JDateChooser();
		date_From.setBounds(56, 16, 152, 30);
		date_From.setDateFormatString("yyyy-MM-dd");
		panel_3.add(date_From);

		date_To = new JDateChooser();
		date_To.setBounds(56, 56, 152, 30);
		date_To.setDateFormatString("yyyy-MM-dd");
		panel_3.add(date_To);

		btn_find_date = new JButton("Lọc");
		btn_find_date.setForeground(new Color(255, 255, 255));
		btn_find_date.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_find_date.setBackground(SystemColor.textHighlight);
		btn_find_date.setBounds(10, 103, 198, 30);
		panel_3.add(btn_find_date);

		JLabel lblNewLabel_1 = new JLabel("Từ :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 16, 63, 30);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Đến :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 56, 63, 30);
		panel_3.add(lblNewLabel_1_1);

		btnThem = new JButton("Thêm");

		btnThem.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(Color.decode(hexColor_Green));
		btnThem.setBounds(10, 0, 125, 35);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/trash.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnXoa.setBackground(Color.decode(hexColor_Red));
		btnXoa.setBounds(145, 0, 125, 35);
		panel.add(btnXoa);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBounds(280, 0, 125, 35);
		panel.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DocDuLieu();
				cbo_floor.setSelectedItem("Tất cả");
				cbo_status.setSelectedItem("Tất cả");
				date_From.setDate(null);
				date_To.setDate(null);
			}
		});

		txtFindCodeRoom = new JTextField();
		txtFindCodeRoom.setBounds(545, 0, 223, 34);
		panel.add(txtFindCodeRoom);
		txtFindCodeRoom.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(415, 0, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// Add event:
		btnThem.addActionListener((ActionListener) this);
		btnXoa.addActionListener(this);
		btn_find_date.addActionListener(this);
		btnTimKiem.addActionListener(this);
		txtFindCodeRoom.addKeyListener(this);
		cbo_status.addItemListener(this);
		cbo_floor.addItemListener(this);

		if (!nhanVien.getloaiNhanVien().getMaLoaiNhanVien().trim().equals("LNV000")) {
			btnThem.removeActionListener(this);
			btnXoa.removeActionListener(this);

			btnThem.setForeground(Color.WHITE);
			btnThem.setBackground(Color.LIGHT_GRAY);
			btnXoa.setForeground(Color.WHITE);
			btnXoa.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
//			Modal_ThemKhachHang modalTKH = new Modal_ThemKhachHang();
//			modalTKH.setVisible(true);
			JDialog_ThemPhong modalTP = new JDialog_ThemPhong();
			modalTP.setVisible(true);
		} else if (o.equals(btnTimKiem) && !txtFindCodeRoom.getText().equals("")) {
			TimKhachHang_TheoMa();
		} else if (o.equals(btn_find_date)) {
			if (date_From.getDate() != null && date_To.getDate() != null) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date1 = LocalDate.parse(df.format(date_From.getDate()), formatter);
				LocalDate date2 = LocalDate.parse(df.format(date_To.getDate()), formatter);

				long daysDifference = date2.toEpochDay() - date1.toEpochDay();
				if (daysDifference >= 0) {
					cbo_floor.setSelectedIndex(0);
					cbo_status.setSelectedIndex(0);
					model = (DefaultTableModel) table_Phong.getModel();
					model.getDataVector().removeAllElements();
					ArrayList<Phong> dsP = new ArrayList<>();

					dsP = DAO_P.timdsPhongtheoThoigian(df.format(date_From.getDate()), df.format(date_To.getDate()));
					if (!dsP.isEmpty()) {
						for (Phong value : dsP) {
							LoaiPhong lp = new LoaiPhong();
							lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(value.getLoaiPhong().getMaLoaiPhong());
							TrangThaiPhong_DAO DAO_trangThai = new TrangThaiPhong_DAO();

							TrangThaiPhong trangThai = new TrangThaiPhong();

							trangThai = DAO_trangThai.timTrangThaiPhong_TheoMaTrangThai(
									value.getTrangThaiPhong().getMaTrangThai().trim());

							Object[] rowData = { value.getMaPhong(), value.getTenPhong(), lp.getTenLoaiPhong(),
									trangThai.getTenTrangThai(), value.getNgayTaoPhong(), value.getViTriPhong(),
									value.getGhiChu(), value.getTinhTrangPhong() };

							model.addRow(rowData);
						}
					} else {
						model = (DefaultTableModel) table_Phong.getModel();
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ngày bạn nhập vào đã sai");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Phải nhập đầy đủ");
			}
		}

		if (o.equals(btnXoa)) {
			XoaPhong();
		}
	}

	public void XoaPhong() {
		int row = table_Phong.getSelectedRow();
		String maPhong = model.getValueAt(row, 0).toString();
		Phong phong = new Phong(maPhong);
		try {
			int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Đóng?",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				String tenPhong = DAO_P.timPhong_TheoMaPhong(maPhong).getTenPhong();
				if (DAO_P.capNhat_TrangThaiPhong(maPhong, "OOO")
						&& DAO_P.capNhat_TinhTrangPhong(maPhong, "Không sử dụng")) {
					DAO_P.xoaPhong(phong);
					JOptionPane.showMessageDialog(null, "Xóa khách hàng" + tenPhong + "thành công");
					model.removeRow(row);
				}
			} else {

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

	public void DocDuLieu() {
		model = (DefaultTableModel) table_Phong.getModel();
		model.getDataVector().removeAllElements();

		DAO_LP = new LoaiPhong_DAO();
		DAO_P = new Phong_DAO();

		try {
			dsP = DAO_P.layTatCaPhong();
			if (dsP != null) {
				dsP.forEach(p -> {
					LoaiPhong lp = new LoaiPhong();
					lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
					TrangThaiPhong_DAO DAO_trangThai = new TrangThaiPhong_DAO();

					TrangThaiPhong trangThai = new TrangThaiPhong();

					trangThai = DAO_trangThai
							.timTrangThaiPhong_TheoMaTrangThai(p.getTrangThaiPhong().getMaTrangThai().trim());

					Object[] rowData = { p.getMaPhong(), p.getTenPhong(), lp.getTenLoaiPhong(),
							trangThai.getTenTrangThai(), p.getNgayTaoPhong(), p.getViTriPhong(), p.getGhiChu(),
							p.getTinhTrangPhong() };

					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void TimKhachHang_TheoMa() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txtFindCodeRoom.getText().trim();
		Phong ma_phong = DAO_P.timPhong_TheoMaPhong(chuoiTimKiem);

		dsP = DAO_P.timDSPhongTheoMaPhong(chuoiTimKiem);

		try {
			if (dsP.size() != 0) {
				if (dsP != null) {

					for (Phong value : dsP) {

						LoaiPhong lp = new LoaiPhong();
						lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(value.getLoaiPhong().getMaLoaiPhong());
						TrangThaiPhong_DAO DAO_trangThai = new TrangThaiPhong_DAO();

						TrangThaiPhong trangThai = new TrangThaiPhong();

						trangThai = DAO_trangThai
								.timTrangThaiPhong_TheoMaTrangThai(value.getTrangThaiPhong().getMaTrangThai().trim());

						Object[] rowData = { value.getMaPhong(), value.getTenPhong(), lp.getTenLoaiPhong(),
								trangThai.getTenTrangThai(), value.getNgayTaoPhong(), value.getViTriPhong(),
								value.getGhiChu(), value.getTinhTrangPhong() };

						model.addRow(rowData);
					}

				}
			} else {
				model = (DefaultTableModel) table_Phong.getModel();
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có phòng nào có mã: " + chuoiTimKiem);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// Xử lý sự kiện khi một mục được chọn
			txtFindCodeRoom.setText("");

			String selectFloor = (String) cbo_floor.getSelectedItem();
			String selectStatus = (String) cbo_status.getSelectedItem();

			model = (DefaultTableModel) table_Phong.getModel();
			model.getDataVector().removeAllElements();

			DAO_LP = new LoaiPhong_DAO();
			DAO_P = new Phong_DAO();
			DAO_TTP = new TrangThaiPhong_DAO();
			TrangThaiPhong TTP = new TrangThaiPhong();
			TTP = DAO_TTP.timTrangThaiPhong_TheoTenTrangThai(selectStatus);

			try {
				if (!(TTP == null)) {
					dsP = DAO_P.timDSPhongWhenSelectCBO(selectFloor, TTP.getMaTrangThai().trim());
				} else {
					dsP = DAO_P.timDSPhongWhenSelectCBO(selectFloor, "Tất cả");
				}
				if (dsP != null) {
					if (!dsP.isEmpty()) {
						dsP.forEach(p -> {

							LoaiPhong lp = new LoaiPhong();
							lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
							TrangThaiPhong_DAO DAO_trangThai = new TrangThaiPhong_DAO();

							TrangThaiPhong trangThai = new TrangThaiPhong();

							trangThai = DAO_trangThai
									.timTrangThaiPhong_TheoMaTrangThai(p.getTrangThaiPhong().getMaTrangThai().trim());

							Object[] rowData = { p.getMaPhong(), p.getTenPhong(), lp.getTenLoaiPhong(),
									trangThai.getTenTrangThai(), p.getNgayTaoPhong(), p.getViTriPhong(), p.getGhiChu(),
									p.getTinhTrangPhong() };

							model.addRow(rowData);
						});
					} else {
						model = (DefaultTableModel) table_Phong.getModel();
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged();
//    					clearTable(model);

					}

				}

			} catch (Exception e1) {

			}

//    		if( selectFloor.equals("Tất cả") || selectStatus.equals("Tất cả") || selectTinhTrang.equals("Tất cả")) {
//    			DocDuLieu();
//    		}
		}

	}

	private Data convertToSqlDate(Component date_From2) {
		// TODO Auto-generated method stub
		return null;
	}

	private void clearTable(DefaultTableModel model_clear) {
		// TODO Auto-generated method stub
		while (model_clear.getRowCount() > 0) {
			model_clear.removeRow(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("đã vào hàm");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			TimKhachHang_TheoMa();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}