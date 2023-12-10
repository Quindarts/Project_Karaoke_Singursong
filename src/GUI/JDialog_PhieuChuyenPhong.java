package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.ChiTietDichVu_DAO;
import DAO.ChiTietHoaDon_DAO;
import DAO.DichVu_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.ChiTietDichVu;
import Entity.ChiTietHoaDon;
import Entity.DichVu;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;
import Entity.TrangThaiPhong;
import OtherFunction.HelpRamDomMa;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JDialog_PhieuChuyenPhong extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat dateFormat_HM = new SimpleDateFormat("HH:mm");
	private SimpleDateFormat dateFormat_YMDHMS = new SimpleDateFormat("dd-M-yyyy hh:mm");
	private JTextField txtTenPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoDienThoai;
	private JTextField txtTenKH;
	private JTable table;
	private JDateChooser date_NhanPhongBanDau;
	private JButton btnDatPhong;
	private JButton btnHy;
	private Calendar cal = Calendar.getInstance();
	private Phong phong;
	private HoaDon hoaDon;
	private ChiTietHoaDon chiTietHD;
	private DefaultTableModel model;
	private Phong_DAO dao_Phong;
	private LoaiPhong_DAO dao_LoaiPhong;
	private TrangThaiPhong_DAO dao_TrangThaiPhong;
	private JScrollPane scrollPane;

	private PhieuDatPhong_DAO DAO_PDP;
	private NhanVien_DAO DAO_NV;
	private KhachHang_DAO DAO_KH;
	private HoaDon_DAO DAO_HD;
	private ChiTietHoaDon_DAO DAO_CTHD;
	private ChiTietDichVu_DAO DAO_CTDV;
	private DichVu_DAO DAO_DV;
	private DichVu dv;
	private JComboBox<String> cbx_LoaiPhong;
	private JComboBox<String> cbx_Lau;
	private ArrayList<LoaiPhong> listLoaiPhong;
	private JButton btn_lamMoi;
	private JButton btn_timKiem;

	/**
	 * Create the panel.
	 */
	public JDialog_PhieuChuyenPhong(Phong phong, HoaDon hoaDon, ChiTietHoaDon chiTietHD) {
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.chiTietHD = chiTietHD;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 911, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
//		contentPane.setBackground(Color.decode(hexColor_Blue1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_PDP = new JPanel();
		panel_PDP.setBackground(new Color(255, 255, 255));
		panel_PDP.setBounds(0, 0, 895, 567);
		contentPane.add(panel_PDP);
		panel_PDP.setLayout(null);

		JPanel pnl_ThongTinPhongMoi = new JPanel();
		pnl_ThongTinPhongMoi.setBackground(new Color(255, 255, 255));
		pnl_ThongTinPhongMoi.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin ph\u00F2ng m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnl_ThongTinPhongMoi.setBounds(22, 354, 417, 155);
		panel_PDP.add(pnl_ThongTinPhongMoi);
		pnl_ThongTinPhongMoi.setLayout(null);

		JLabel lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setForeground(new Color(0, 0, 0));
		lblTenPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenPhong.setBounds(10, 25, 82, 27);
		pnl_ThongTinPhongMoi.add(lblTenPhong);

		JLabel lblLoaiPhong_1_1 = new JLabel("Loại phòng");
		lblLoaiPhong_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1.setBounds(10, 65, 82, 27);
		pnl_ThongTinPhongMoi.add(lblLoaiPhong_1_1);

		JLabel lblLoaiPhong_1_1_1 = new JLabel("Giá phòng");
		lblLoaiPhong_1_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_1.setBounds(10, 105, 82, 27);
		pnl_ThongTinPhongMoi.add(lblLoaiPhong_1_1_1);

		txtTenPhong = new JTextField();
		txtTenPhong.setEnabled(false);
		txtTenPhong.setEditable(false);
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(102, 25, 294, 27);
		pnl_ThongTinPhongMoi.add(txtTenPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEnabled(false);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(102, 65, 294, 27);
		pnl_ThongTinPhongMoi.add(txtLoaiPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEnabled(false);
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(102, 105, 294, 27);
		pnl_ThongTinPhongMoi.add(txtGiaPhong);

		JPanel pnl_ThongTinKhachHang = new JPanel();
		pnl_ThongTinKhachHang.setBackground(new Color(255, 255, 255));
		pnl_ThongTinKhachHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnl_ThongTinKhachHang.setBounds(466, 354, 413, 155);
		panel_PDP.add(pnl_ThongTinKhachHang);
		pnl_ThongTinKhachHang.setLayout(null);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSoDienThoai.setBounds(10, 25, 85, 27);
		pnl_ThongTinKhachHang.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEnabled(false);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(120, 25, 276, 27);
		pnl_ThongTinKhachHang.add(txtSoDienThoai);

		JLabel lblLoaiPhong_1_1_2 = new JLabel("Tên khách hàng");
		lblLoaiPhong_1_1_2.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_2.setBounds(10, 65, 100, 27);
		pnl_ThongTinKhachHang.add(lblLoaiPhong_1_1_2);

		txtTenKH = new JTextField();
		txtTenKH.setEnabled(false);
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(120, 65, 276, 27);
		pnl_ThongTinKhachHang.add(txtTenKH);

		JPanel pnl_ThoiGianChuyenNhanPhongMoi = new JPanel();
		pnl_ThoiGianChuyenNhanPhongMoi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnl_ThoiGianChuyenNhanPhongMoi.setBackground(new Color(255, 255, 255));
		pnl_ThoiGianChuyenNhanPhongMoi.setBounds(22, 45, 857, 86);
		panel_PDP.add(pnl_ThoiGianChuyenNhanPhongMoi);
		pnl_ThoiGianChuyenNhanPhongMoi.setLayout(null);

		JLabel lbl_ThoiGianBatDauVoPhong = new JLabel("Thời gian vào nhận phòng");
		lbl_ThoiGianBatDauVoPhong.setForeground(new Color(0, 0, 0));
		lbl_ThoiGianBatDauVoPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_ThoiGianBatDauVoPhong.setBounds(10, 10, 196, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lbl_ThoiGianBatDauVoPhong);

		date_NhanPhongBanDau = new JDateChooser();
		date_NhanPhongBanDau.getCalendarButton().setEnabled(false);
		date_NhanPhongBanDau.setDateFormatString("yyyy-MM-dd hh:mm");
		date_NhanPhongBanDau.setBounds(200, 11, 157, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(date_NhanPhongBanDau);

		JLabel lbl_LoaiPhong = new JLabel("Loại phòng");
		lbl_LoaiPhong.setForeground(Color.BLACK);
		lbl_LoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_LoaiPhong.setBounds(424, 10, 95, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lbl_LoaiPhong);

		JLabel lbl_Lau = new JLabel("Lầu");
		lbl_Lau.setForeground(Color.BLACK);
		lbl_Lau.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_Lau.setBounds(424, 40, 95, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lbl_Lau);

		cbx_LoaiPhong = new JComboBox<String>();
		cbx_LoaiPhong.setBounds(529, 12, 193, 21);
		pnl_ThoiGianChuyenNhanPhongMoi.add(cbx_LoaiPhong);
		dao_LoaiPhong = new LoaiPhong_DAO();
		cbx_LoaiPhong.addItem("Chọn loại phòng");
		try {
			listLoaiPhong = dao_LoaiPhong.layTatCaLoaiPhong();
			if (listLoaiPhong != null) {
				listLoaiPhong.forEach((lp) -> {
					cbx_LoaiPhong.addItem(lp.getTenLoaiPhong());
				});
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		cbx_Lau = new JComboBox<String>();
		cbx_Lau.setBounds(529, 42, 120, 21);
		pnl_ThoiGianChuyenNhanPhongMoi.add(cbx_Lau);

		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setForeground(Color.WHITE);
		btn_lamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_lamMoi.setBackground(new Color(62, 124, 177));
		btn_lamMoi.setBounds(747, 46, 100, 30);
		pnl_ThoiGianChuyenNhanPhongMoi.add(btn_lamMoi);

		btn_timKiem = new JButton("Tìm kiếm");
		btn_timKiem.setForeground(Color.WHITE);
		btn_timKiem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_timKiem.setBackground(new Color(62, 124, 177));
		btn_timKiem.setBounds(747, 7, 100, 30);
		pnl_ThoiGianChuyenNhanPhongMoi.add(btn_timKiem);
		cbx_Lau.addItem("Chọn lầu");
		cbx_Lau.addItem("Lầu 1");
		cbx_Lau.addItem("Lầu 2");
		cbx_Lau.addItem("Lầu 3");
		cbx_Lau.addItem("Lầu 4");
		cbx_Lau.addItem("Lầu 5");

		btnDatPhong = new JButton("Chuyển phòng");
		btnDatPhong.setBackground(Color.decode(hexColor_Green));
		btnDatPhong.setForeground(new Color(255, 255, 255));
		btnDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDatPhong.setBounds(741, 519, 138, 30);
		panel_PDP.add(btnDatPhong);

		btnHy = new JButton("Hủy");
		btnHy.setBackground(Color.decode(hexColor_Blue2));
		btnHy.setForeground(new Color(255, 255, 255));
		btnHy.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnHy.setBounds(631, 519, 100, 30);
		panel_PDP.add(btnHy);

		JLabel lblPhiutPhng = new JLabel("CHUYỂN PHÒNG");
		lblPhiutPhng.setForeground(new Color(5, 74, 145));
		lblPhiutPhng.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPhiutPhng.setBounds(22, 11, 237, 27);
		panel_PDP.add(lblPhiutPhng);

		JPanel dsPhongTrongHienTai = new JPanel();
		dsPhongTrongHienTai.setBackground(new Color(255, 255, 255));
		dsPhongTrongHienTai.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch ph\u00F2ng tr\u1ED1ng hi\u1EC7n t\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		dsPhongTrongHienTai.setBounds(22, 142, 857, 205);
		panel_PDP.add(dsPhongTrongHienTai);
		dsPhongTrongHienTai.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 837, 171);
		dsPhongTrongHienTai.add(scrollPane);

		table = new JTable();

		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "T\u00EAn ph\u00F2ng", "Lo\u1EA1i ph\u00F2ng", "Tr\u1EA1ng th\u00E1i",
						"Ng\u00E0y t\u1EA1o ph\u00F2ng", "V\u1ECB tr\u00ED ph\u00F2ng", "Ghi ch\u00FA" }));
		scrollPane.add(table);
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();
		btnDatPhong.addActionListener(this);
		btnHy.addActionListener(this);
		btn_lamMoi.addActionListener(this);
		table.addMouseListener(this);

		cbx_Lau.addActionListener(this);
		cbx_LoaiPhong.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDatPhong)) {
			ChuyenPhong();

		}
		if (o.equals(btnHy)) {
			setVisible(false);
		}

		if (o.equals(cbx_Lau) || o.equals(cbx_LoaiPhong)) {
			LocPhong();
		}

		if (o.equals(btn_lamMoi)) {
			cbx_Lau.setSelectedIndex(0);
			cbx_LoaiPhong.setSelectedIndex(0);
		}
	}

	public void ChuyenPhong() {

		DAO_KH = new KhachHang_DAO();
		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_NV = new NhanVien_DAO();
		dao_TrangThaiPhong = new TrangThaiPhong_DAO();
		DAO_HD = new HoaDon_DAO();
		DAO_CTHD = new ChiTietHoaDon_DAO();
		DAO_CTDV = new ChiTietDichVu_DAO();

		int row = table.getSelectedRow();

		Phong phongMoi = null;
		String maPhongMoi = model.getValueAt(row, 0).toString();
		phongMoi = dao_Phong.timPhong_TheoMaPhong(maPhongMoi);

		KhachHang kh = null;
		String maKH = hoaDon.getKhachHang().getMaKhachHang();
		kh = DAO_KH.layKhachHang_TheoMaKhachHang(maKH);

		try {
			dao_Phong = new Phong_DAO();
			DAO_CTDV = new ChiTietDichVu_DAO();

			int t = JOptionPane.showConfirmDialog(null, "Xác nhận chuyển phòng?", "Xác nhận",
					JOptionPane.YES_NO_OPTION);

			if (t == JOptionPane.YES_OPTION) {

				chiTietHD.setPhong(phongMoi);

				if (DAO_CTHD.capNhatCTHoaDon_TheoMaHoaDon_MaPhong(chiTietHD, phong.getMaPhong())) {
					dao_Phong.capNhat_TrangThaiPhong(maPhongMoi, "OC");
					dao_Phong.capNhat_TrangThaiPhong(phong.getMaPhong(), "VC");

					ArrayList<ChiTietDichVu> dsCTDV = DAO_CTDV.layDanhSachChiTietDichVu_TheoMaHoaDon_MaPhong(
							chiTietHD.getHoaDon().getMaHoaDon(), phong.getMaPhong());

					if (dsCTDV != null) {

						dsCTDV.forEach(ctdv -> {
							DAO_CTDV.capNhatCTDichVu_TheoMaHoaDon_MaDichVu(ctdv, maPhongMoi);
						});
					}

					JOptionPane.showMessageDialog(null, "Chuyển phòng thành công");

				} else {
					JOptionPane.showMessageDialog(null, "Chuyển phòng thất bại, thử lại sau");
				}

				dispose();

			}
//			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Thất bại, vui lòng thử lại");
		}
	}

	public void SetModal_PhieuChuyenPhong(Timestamp thoiGianNhanPhong, String soDT, String tenKH) {

		txtSoDienThoai.setText(soDT);
		txtTenKH.setText(tenKH);
		date_NhanPhongBanDau.setDate(thoiGianNhanPhong); // Thời gian lần đầu khách vào phòng
		dao_Phong = new Phong_DAO();
		dao_LoaiPhong = new LoaiPhong_DAO();
		dao_TrangThaiPhong = new TrangThaiPhong_DAO();

		// Lấy danh sách phòng trống và không thêm phòng từ card phòng được chọn
		for (Phong ph : dao_Phong.layTatCaPhong()) {

			LoaiPhong loaiPh = new LoaiPhong();
			loaiPh = dao_LoaiPhong.layLoaiPhong_TheoMaLoaiPhong(ph.getLoaiPhong().getMaLoaiPhong());

			TrangThaiPhong trThaiPh = new TrangThaiPhong();
			trThaiPh = dao_TrangThaiPhong.timTrangThaiPhong_TheoMaTrangThai(ph.getTrangThaiPhong().getMaTrangThai());
			String maTrangThai = trThaiPh.getMaTrangThai().toString().trim();

			if (maTrangThai.equals("VC")) {
				Object[] rowData = { ph.getTenPhong(), loaiPh.getTenLoaiPhong(), trThaiPh.getTenTrangThai(),
						ph.getNgayTaoPhong(), ph.getViTriPhong(), ph.getGhiChu() };
				model.addRow(rowData);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(table) && e.getClickCount() == 1) {
			SetThongTinPhongMoi();
		}
	}

	public void SetThongTinPhongMoi() {
		int row = table.getSelectedRow();

		String tenPhong = model.getValueAt(row, 0).toString().trim();
		String tenLoaiPhong = model.getValueAt(row, 1).toString().trim();

		for (LoaiPhong loaiPh : dao_LoaiPhong.layTatCaLoaiPhong()) {
			if (tenLoaiPhong.equals(loaiPh.getTenLoaiPhong().toString().trim()))
				txtGiaPhong.setText(loaiPh.getGiaTien() + "");
		}
		txtTenPhong.setText(tenPhong);
		txtLoaiPhong.setText(tenLoaiPhong);
	}

	public void LocPhong() {
		boolean ketQuaLoc = false;

		String lau_isSelected = cbx_Lau.getSelectedItem().toString().trim();
		String chonLau = cbx_Lau.getItemAt(0).toString().trim();

		String loaiPh_isSelected = cbx_LoaiPhong.getSelectedItem().toString().trim();
		String chonLoaiPhong = cbx_LoaiPhong.getItemAt(0).toString().trim();

		model.getDataVector().removeAllElements();
		for (Phong ph : dao_Phong.layTatCaPhong()) {
			boolean kiemTra = true;

			LoaiPhong loaiPh = new LoaiPhong();
			loaiPh = dao_LoaiPhong.layLoaiPhong_TheoMaLoaiPhong(ph.getLoaiPhong().getMaLoaiPhong());

			TrangThaiPhong trThaiPh = new TrangThaiPhong();
			trThaiPh = dao_TrangThaiPhong.timTrangThaiPhong_TheoMaTrangThai(ph.getTrangThaiPhong().getMaTrangThai());
			String maTrangThai = trThaiPh.getMaTrangThai().toString().trim();

			if (!lau_isSelected.equals(chonLau) && !(ph.getViTriPhong().toString().trim()).equals(lau_isSelected)) {
				kiemTra = false;
			}

			if (!loaiPh_isSelected.equals(chonLoaiPhong)
					&& !(loaiPh.getTenLoaiPhong().toString().trim()).equals(loaiPh_isSelected)) {
				kiemTra = false;
			}

			if (maTrangThai.equals("VC") && kiemTra == true) {
				Object[] rowData = { ph.getTenPhong(), loaiPh.getTenLoaiPhong(), trThaiPh.getTenTrangThai(),
						ph.getNgayTaoPhong(), ph.getViTriPhong(), ph.getGhiChu() };
				model.addRow(rowData);
			}
		}
		if (!ketQuaLoc) {
			model.fireTableDataChanged();
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
}