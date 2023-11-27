package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ConnectDB.ConnectDB;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import DAO.ChiTietDichVu_DAO;
import DAO.DichVu_DAO;
import DAO.HoaDon_DAO;
import DAO.LoaiPhong_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import Entity.ChiTietDichVu;
import Entity.DichVu;
import Entity.HoaDon;
import Entity.LoaiPhong;
import Entity.PhieuDatPhong;
import Entity.Phong;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Modal_DatDichVu extends JFrame implements ActionListener {

	/**
	 * Color
	 */

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Green = "#4BAC4D";
	private JPanel contentPane;
	private JTextField txt_tenPhong;
	private JTextField txt_loaiPhong;
	private JTextField txt_timKiem;
	private JTable table_dvDatPhong;
	private DefaultTableModel model_dsDichVu;
	private JTable tableDichVu;
	private DichVu_DAO DAO_DV;
	private ArrayList<DichVu> dsDV;
	private DefaultTableModel model_dichVuDatPhong;

	private JButton btn_thoat;
	private JButton btn_them;
	private JButton btn_timKiem;
	private JButton btn_xacNhan;

	private DichVu dv;
	private Phong phong;

	// DAO
	private Phong_DAO DAO_Phong;
	private PhieuDatPhong_DAO DAO_PDP;
	private PhieuDatPhong phieuDat;
	private HoaDon_DAO DAO_HD;
	private HoaDon hoaDon;
	private ChiTietDichVu_DAO DAO_CTDV;
	private ArrayList<ChiTietDichVu> dsCTDV_HD;

	private JTextField txt_soLuongMonDat;
	private JTextField txt_TinhTongDichVu;
	private JTextField txt_tongTienMonDat;
	private JTextField txt_tenMon;
	private JButton btn_tangMonDat;
	private JButton btn_giamMonDat;
	private final DecimalFormat dcf = new DecimalFormat("#,##0 VND");
	private JButton btn_capNhatTongTien;
	private LoaiPhong_DAO DAO_LP;
	private LoaiPhong loaiPhong;

	public Modal_DatDichVu(Phong phong) {
		this.phong = phong;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1000, 600);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_tableDichVu = new JPanel();
		panel_tableDichVu.setBounds(24, 90, 408, 350);
		contentPane.add(panel_tableDichVu);
		panel_tableDichVu.setLayout(null);
		String cols[] = { "Mã mặt hàng", "Tên mặt hàng", "Số lượng", "Giá bán" };
		model_dsDichVu = new DefaultTableModel(cols, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			};

		};

		tableDichVu = new JTable();
		tableDichVu.setModel(model_dsDichVu);

		tableDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 400, 350);

		scrollPane.add(tableDichVu);
		scrollPane.setViewportView(tableDichVu);
		panel_tableDichVu.add(scrollPane);

		DocDLDichVu();
		///
		JPanel panel_dichVuDatPhong = new JPanel();
		panel_dichVuDatPhong.setBounds(468, 91, 505, 350);

		contentPane.add(panel_dichVuDatPhong);
		panel_dichVuDatPhong.setLayout(null);

		table_dvDatPhong = new JTable();
		table_dvDatPhong.setBounds(0, 0, 1, 1);
		String cols_model_dichVuDatPhong[] = { "Mã mặt hàng", "Tên mặt hàng", "Số lượng", "Giá bán", "Thành tiền", "" };

		model_dichVuDatPhong = new DefaultTableModel(cols_model_dichVuDatPhong, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5; // Đặt tất cả các ô không thể chỉnh sửa
			}
		};
		;

		table_dvDatPhong = new JTable();
		table_dvDatPhong.setModel(model_dichVuDatPhong);

		panel_dichVuDatPhong.add(table_dvDatPhong);
		table_dvDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 0, 505, 350);

		scrollPane2.add(table_dvDatPhong);
		scrollPane2.setViewportView(table_dvDatPhong);
		panel_dichVuDatPhong.add(scrollPane2);

		// panel ben phai phia duoi
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(468, 470, 505, 40);

		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Tổng tiền:");
		lblNewLabel_4.setBounds(0, 5, 106, 18);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panel_2.add(lblNewLabel_4);
		txt_TinhTongDichVu = new JTextField();
		txt_TinhTongDichVu.setBounds(70, 5, 180, 25);
		panel_2.add(txt_TinhTongDichVu);
		txt_TinhTongDichVu.setColumns(10);
		txt_TinhTongDichVu.setEditable(false);

		btn_capNhatTongTien = new JButton("Cập nhật tổng tiền");
		btn_capNhatTongTien.setBounds(230, 5, 150, 25);
		panel_2.add(btn_capNhatTongTien);

		// panel ben trai phia duoi
		btn_them = new JButton("Đặt món");
		btn_them.setBackground(Color.decode(hexColor_Green));
		btn_them.setForeground(Color.WHITE);
		btn_them.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_them.setBounds(307, 14, 91, 21);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(24, 470, 408, 83);
		panel_3.setLayout(null);
		panel_3.add(btn_them);
		contentPane.add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("Tên món");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2.setBounds(20, 14, 90, 20);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Số lượng đặt");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(20, 45, 83, 20);
		panel_3.add(lblNewLabel_2_1);

		txt_tenMon = new JTextField();
		txt_tenMon.setBounds(113, 15, 180, 19);
		panel_3.add(txt_tenMon);
		txt_tenMon.setEditable(false);
		txt_tenMon.setColumns(10);

		txt_soLuongMonDat = new JTextField();
		txt_soLuongMonDat.setColumns(10);
		txt_soLuongMonDat.setBounds(151, 47, 96, 19);
		panel_3.add(txt_soLuongMonDat);

		btn_tangMonDat = new JButton("+");
		btn_tangMonDat.setBackground(SystemColor.textHighlight);
		btn_tangMonDat.setForeground(SystemColor.text);
		btn_tangMonDat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_tangMonDat.setBounds(245, 47, 49, 19);
		panel_3.add(btn_tangMonDat);

		btn_giamMonDat = new JButton("-");
		btn_giamMonDat.setBackground(SystemColor.textHighlight);
		btn_giamMonDat.setForeground(new Color(255, 255, 255));
		btn_giamMonDat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_giamMonDat.setBounds(113, 47, 39, 19);
		panel_3.add(btn_giamMonDat);

		btn_thoat = new JButton("Thoát");
		btn_thoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_thoat.setForeground(Color.WHITE);
		btn_thoat.setBackground(Color.decode(hexColor_Blue1));
		btn_thoat.setBounds(698, 530, 126, 33);
		contentPane.add(btn_thoat);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(24, 20, 408, 36);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		txt_timKiem = new JTextField();
		txt_timKiem.setBounds(0, 2, 287, 29);
		panel_4.add(txt_timKiem);
		txt_timKiem.setColumns(10);

		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setBounds(297, 2, 111, 29);
		panel_4.add(btn_timKiem);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(468, 17, 505, 39);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 5, 244, 34);
		panel_5.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên phòng");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setBounds(0, 4, 80, 19);
		panel.add(lblNewLabel);

		txt_tenPhong = new JTextField(phong.getTenPhong());
		txt_tenPhong.setBounds(74, 4, 160, 19);
		txt_tenPhong.setEditable(false);
		panel.add(txt_tenPhong);
		txt_tenPhong.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(261, 5, 244, 34);
		panel_5.add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Loại phòng");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(0, 4, 78, 20);
		panel_1.add(lblNewLabel_1);
		DAO_LP = new LoaiPhong_DAO();
		try {
			loaiPhong = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(phong.getLoaiPhong().getMaLoaiPhong());
			txt_loaiPhong = new JTextField(loaiPhong.getTenLoaiPhong());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		txt_loaiPhong.setColumns(10);
		txt_loaiPhong.setEditable(false);
		txt_loaiPhong.setBounds(80, 6, 160, 19);
		panel_1.add(txt_loaiPhong);

		btn_xacNhan = new JButton("Xác nhận");
		btn_xacNhan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_xacNhan.setForeground(Color.WHITE);
		btn_xacNhan.setBackground(Color.decode(hexColor_Green));
		btn_xacNhan.setBounds(850, 530, 126, 33);
		contentPane.add(btn_xacNhan);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(165, 42, 42));
		panel_6.setBounds(468, 52, 505, 40);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Danh sách món khách đặt");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 5, 505, 25);
		panel_6.add(lblNewLabel_3);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBackground(SystemColor.textHighlight);
		panel_6_1.setBounds(24, 52, 408, 40);
		contentPane.add(panel_6_1);

		JLabel lblNewLabel_3_1 = new JLabel("Danh sách món của quán");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(SystemColor.text);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(0, 5, 408, 25);
		panel_6_1.add(lblNewLabel_3_1);

		DocDlDichVuHoaDon();
		btn_thoat.addActionListener(this);
		btn_them.addActionListener(this);
		btn_giamMonDat.addActionListener(this);
		btn_tangMonDat.addActionListener(this);
		btn_timKiem.addActionListener(this);
		btn_xacNhan.addActionListener(this);
		btn_capNhatTongTien.addActionListener(this);

		tableDichVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableDichVu.getSelectedRow();
				DefaultTableModel md = (DefaultTableModel) tableDichVu.getModel();
				String maDichVu = model_dsDichVu.getValueAt(row, 0).toString();
				String tenDichVu = model_dsDichVu.getValueAt(row, 1).toString();
				String soLuong = model_dsDichVu.getValueAt(row, 2).toString();
				String donGia = model_dsDichVu.getValueAt(row, 3).toString();
				dv = new DichVu(maDichVu, tenDichVu, Double.parseDouble(donGia));
				txt_tenMon.setText(tenDichVu);
				txt_soLuongMonDat.setText("1");

			}
		});
		table_dvDatPhong.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table_dvDatPhong.rowAtPoint(evt.getPoint());
				int col = table_dvDatPhong.columnAtPoint(evt.getPoint());

				if (col == 2) {
					int selectedItem = Integer.parseInt(table_dvDatPhong.getValueAt(row, 2).toString());

					Modal_CapNhatSoLuong md = new Modal_CapNhatSoLuong(table_dvDatPhong, tableDichVu, selectedItem, col,
							row);
					md.setVisible(true);
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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_capNhatTongTien)) {
			Double tongTien = 0.0;
			for (int i = 0; i < table_dvDatPhong.getRowCount(); i++) {
				try {
					Double thanhTien = dcf.parse(table_dvDatPhong.getValueAt(i, 4).toString()).doubleValue();

					tongTien = tongTien + thanhTien;

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (tongTien > 0) {
				String dcf_tongTien = dcf.format(tongTien);
				txt_TinhTongDichVu.setText(dcf_tongTien);
			}
		}
		// btn thoat
		if (o.equals(btn_thoat)) {
			this.setVisible(false);
		}
		if (o.equals(btn_giamMonDat)) {

			int sl = Integer.parseInt(txt_soLuongMonDat.getText());

			if (sl >= 2) {
				txt_soLuongMonDat.setText(String.valueOf(sl - 1));
			}
		}
		if (o.equals(btn_tangMonDat)) {

			int sl = Integer.parseInt(txt_soLuongMonDat.getText());

			String maDichVu = dv.getMaDichVu().toString();
			int rowCount = tableDichVu.getRowCount();
			int soLuongBanDau = 0;

			for (int i = 0; i < rowCount; i++) {
				if (maDichVu.equals(tableDichVu.getValueAt(i, 0).toString())) {
					soLuongBanDau = Integer.parseInt(tableDichVu.getValueAt(i, 2).toString());

				}
			}
			if (sl == soLuongBanDau) {
				JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng tồn");
				txt_soLuongMonDat.setText(String.valueOf(sl));

			}

			else
				txt_soLuongMonDat.setText(String.valueOf(sl + 1));

		}

		if (o.equals(btn_timKiem)) {

		}
		if (o.equals(btn_xacNhan)) {

			boolean checkresult = DAO_CTDV.xoaCTDichVu_TheoMaHoaDon_TheoMaPhong(hoaDon.getMaHoaDon(),
					phong.getMaPhong());
			System.out.println(hoaDon.getMaHoaDon() + phong.getMaPhong());
			
			for (int i = 0; i < table_dvDatPhong.getRowCount(); i++) {

				String maDichVu = table_dvDatPhong.getValueAt(i, 0).toString();
				ChiTietDichVu ctdv = new ChiTietDichVu(hoaDon, new DichVu(maDichVu),
						Integer.parseInt(table_dvDatPhong.getValueAt(i, 2).toString()), phong);
				try {
					System.out.println(ctdv.toString());
					DAO_CTDV.taoCTDichVu(ctdv);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			JOptionPane.showMessageDialog(null, "Cập nhật dịch vụ thành công");
			setVisible(false);

		}
		// btn dat mon

		if (o.equals(btn_them)) {

			int row = tableDichVu.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Phải chọn dịch vụ để đặt dịch vụ!");
			}

			String maDichVu = model_dsDichVu.getValueAt(row, 0).toString();
			String tenDichVu = model_dsDichVu.getValueAt(row, 1).toString();
			String soLuongBanDau = model_dsDichVu.getValueAt(row, 2).toString();
			String donGia = model_dsDichVu.getValueAt(row, 3).toString();

			int convert_soLuongBanDau = Integer.parseInt(soLuongBanDau);

			if (convert_soLuongBanDau <= 0) {
				JOptionPane.showInternalMessageDialog(null, "Hết hàng!!");
			}

			else {

				DichVu dv = new DichVu(maDichVu, tenDichVu, Double.parseDouble(donGia));

				if (model_dichVuDatPhong.getRowCount() == 0) {
					String soLuong = txt_soLuongMonDat.getText();

					double thanhTien = Double.parseDouble(soLuong) * dv.getDonGia();
					String dcf_thanhTienMoi = dcf.format(thanhTien);
					Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(), 1, dv.getDonGia(), dcf_thanhTienMoi };
					model_dichVuDatPhong.addRow(rowData);
				}

				else {

					boolean kiemTraMathang = false;

					for (int r = 0; r < model_dichVuDatPhong.getRowCount(); r++) {

						if (dv.getMaDichVu().equals(model_dichVuDatPhong.getValueAt(r, 0).toString())) {

							JOptionPane.showMessageDialog(null,
									"Dịch vụ này đã được thêm, vui lòng trỏ vào ô số lượng của danh sách khách đặt để cập nhật lại số lượng!");
							kiemTraMathang = true;
						}

					}
					if (kiemTraMathang == false) {
						String soLuong = txt_soLuongMonDat.getText();

						Double thanhTien = Integer.parseInt(soLuong) * dv.getDonGia();

						String dcf_thanhTienMoi = dcf.format(thanhTien);

						Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(), soLuong, dv.getDonGia(),
								dcf_thanhTienMoi };
						model_dichVuDatPhong.addRow(rowData);

						for (int i = 0; i < tableDichVu.getRowCount(); i++) {
							if (dv.getMaDichVu() == tableDichVu.getValueAt(i, 0).toString()) {
								int soLuongBanDau2 = Integer.parseInt(tableDichVu.getValueAt(i, 2).toString());

								tableDichVu.setValueAt(String.valueOf(soLuongBanDau2 - 1), i, 2);
							}
						}

					}
				}
			}

		}

	}

	public void xoaDL() {
		model_dsDichVu.getDataVector().removeAllElements();
		model_dsDichVu.fireTableDataChanged();
	}

	public void DocDLDichVu() {
		DAO_DV = new DichVu_DAO();

		try {
			dsDV = DAO_DV.layTatCaDichVu();
			if (dsDV != null) {
				dsDV.forEach(dv -> {
					Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(),
							dv.getThongTinDichVu().tinhSoLuongConLai(), dv.getDonGia() };

					model_dsDichVu.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void DocDlDichVuHoaDon() {
		try {

			DAO_HD = new HoaDon_DAO();
			DAO_CTDV = new ChiTietDichVu_DAO();

			hoaDon = DAO_HD.layHoaDon_DangChoThanhToan(phong.getMaPhong());

			if (hoaDon != null) {
				dsCTDV_HD = DAO_CTDV.layDanhSachChiTietDichVu_TheoMaPhong_TheoMaHD(phong.getMaPhong(),
						hoaDon.getMaHoaDon());

				System.out.println(dsCTDV_HD);
				if (dsCTDV_HD != null) {
					dsCTDV_HD.forEach(ctdv -> {
						// Lưu chi tiết dịch vụ
						DichVu dv = ctdv.getDichVu();
						// Cap nhat thanh tien moi

						double thanhTienMoi = dv.getDonGia() * ctdv.getSoLuong();

						String dcf_thanhTienMoi = dcf.format(thanhTienMoi);

						Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(), ctdv.getSoLuong(), dv.getDonGia(),
								dcf_thanhTienMoi };

						// Cập nhật số lượng ở table dịch vụ

						for (int i = 0; i < tableDichVu.getRowCount(); i++) {

							if (dv.getMaDichVu().equals(tableDichVu.getValueAt(i, 0).toString())) {

								tableDichVu.setValueAt(
										String.valueOf(dv.getThongTinDichVu().getSoLuong() - ctdv.getSoLuong()), i, 2);
							}
						}
						model_dichVuDatPhong.addRow(rowData);
					});

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
