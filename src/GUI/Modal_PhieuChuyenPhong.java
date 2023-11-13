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

import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;
import Entity.TrangThaiPhong;

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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Modal_PhieuChuyenPhong extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txt_SoGioDaHat;

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
	private JTextField txtMaPDP;
	private JTextField txtTenPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoDienThoai;
	private JTextField txtTenKH;
	private JTextField txtNhanVien;
	private JTable table;
	private JDateChooser date_NhanPhongBanDau;
	private JDateChooser date_ChuyenPhong;
	private JButton btnDatPhong;
	private JButton btnHy;
	private Calendar cal = Calendar.getInstance();
	private DefaultTableModel model;
	private Phong_DAO dao_Phong;
	private LoaiPhong_DAO dao_LoaiPhong;
	private TrangThaiPhong_DAO dao_TrangThaiPhong;
	private JScrollPane scrollPane;

	private PhieuDatPhong_DAO DAO_PDP;
	private NhanVien_DAO DAO_NV;
	private KhachHang_DAO DAO_KH;

	/**
	 * Create the panel.
	 */
	public Modal_PhieuChuyenPhong() {
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
		lbl_ThoiGianBatDauVoPhong.setBounds(10, 11, 196, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lbl_ThoiGianBatDauVoPhong);

		date_NhanPhongBanDau = new JDateChooser();
		date_NhanPhongBanDau.setDateFormatString("yyyy-MM-dd hh:mm");
		date_NhanPhongBanDau.setBounds(216, 11, 157, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(date_NhanPhongBanDau);

		txt_SoGioDaHat = new JTextField();
		txt_SoGioDaHat.setEnabled(false);
		txt_SoGioDaHat.setBounds(492, 11, 55, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(txt_SoGioDaHat);
		txt_SoGioDaHat.setColumns(10);

		JLabel lblNhanVien = new JLabel("Nhân viên");
		lblNhanVien.setForeground(new Color(0, 0, 0));
		lblNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNhanVien.setBounds(615, 49, 82, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lblNhanVien);

		JLabel lblMaPDP = new JLabel("Mã phiếu ");
		lblMaPDP.setForeground(new Color(0, 0, 0));
		lblMaPDP.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPDP.setBounds(615, 11, 82, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lblMaPDP);

		txtMaPDP = new JTextField();
		txtMaPDP.setEditable(false);
		txtMaPDP.setEnabled(false);
		txtMaPDP.setBounds(701, 11, 140, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(txtMaPDP);
		txtMaPDP.setColumns(10);

		txtNhanVien = new JTextField();
		txtNhanVien.setEnabled(false);
		txtNhanVien.setEditable(false);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(701, 49, 140, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(txtNhanVien);

		JLabel lbl_ThoiGianChuyenSangPhongMoi = new JLabel("Thời gian nhận phòng mới");
		lbl_ThoiGianChuyenSangPhongMoi.setForeground(Color.BLACK);
		lbl_ThoiGianChuyenSangPhongMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_ThoiGianChuyenSangPhongMoi.setBounds(10, 48, 196, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lbl_ThoiGianChuyenSangPhongMoi);

		date_ChuyenPhong = new JDateChooser();
		date_ChuyenPhong.setDateFormatString("yyyy-MM-dd hh:mm");
		date_ChuyenPhong.setBounds(216, 49, 157, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(date_ChuyenPhong);

		JLabel lbl_SoGioDaHat = new JLabel("Số giờ đã hát");
		lbl_SoGioDaHat.setForeground(Color.BLACK);
		lbl_SoGioDaHat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoGioDaHat.setBounds(397, 11, 196, 27);
		pnl_ThoiGianChuyenNhanPhongMoi.add(lbl_SoGioDaHat);

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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã phòng", "Tên phòng", "Loại phòng",
				"Trạng thái", "Ngày tạo phòng", "Vị trí phòng", "Ghi chú", "Tình trạng phòng" }) {
			private static final long serialVersionUID = -143705667217047914L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Đặt tất cả các ô không thể chỉnh sửa
			}
		});
		scrollPane.add(table);
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();
		btnDatPhong.addActionListener(this);
		btnHy.addActionListener(this);
		table.addMouseListener(this);
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
	}
	
	public void ChuyenPhong () {
		DAO_KH = new KhachHang_DAO();
		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_NV = new NhanVien_DAO();
		dao_TrangThaiPhong = new TrangThaiPhong_DAO();
		int row = table.getSelectedRow();

		String maPDP = txtMaPDP.getText();
		PhieuDatPhong phieuDatPhong = DAO_PDP.layPhieuDatPhong_TheoMaPhieuDat(maPDP);

		Phong ph = null;
		String maPhong = model.getValueAt(row, 0).toString();
		ph = dao_Phong.timPhong_TheoMaPhong(maPhong);
		
		NhanVien nv = null;
		String maNV = phieuDatPhong.getNhanVien().getMaNhanVien();
		nv = DAO_NV.timNhanVien_TheoMaNhanVien(maNV);

		KhachHang kh = null;
		String maKH = phieuDatPhong.getKhachHang().getMaKhachHang();
		kh = DAO_KH.layKhachHang_TheoMaKhachHang(maKH);
		
		TrangThaiPhong trThaiPh = new TrangThaiPhong();
		trThaiPh = dao_TrangThaiPhong.timTrangThaiPhong_TheoTenTrangThai("Đang sử dụng");

		Timestamp tgianDatPhong = null;
		try {
			tgianDatPhong = phieuDatPhong.getThoiGianDatPhong();
		} catch (Exception e2) {
			// TODO: handle exception
			tgianDatPhong = null;
		}

		Timestamp tgianNhanPhong = null;
		try {
			tgianNhanPhong = phieuDatPhong.getThoiGianNhanPhong();
		} catch (Exception e2) {
			// TODO: handle exception
			tgianDatPhong = null;
		}

		double tinCoc = phieuDatPhong.getTienCoc();
		String trangThai = phieuDatPhong.getTrangThai();
		String moTa = phieuDatPhong.getMoTa();

		phieuDatPhong = new PhieuDatPhong(maPDP, ph, nv, kh, tgianDatPhong, tgianNhanPhong, tinCoc, trangThai,
				moTa);

		try {
			int t = JOptionPane.showConfirmDialog(null, "Xác nhận chuyển phòng?", "Xác nhận",
					JOptionPane.YES_NO_OPTION);
			if (t == JOptionPane.YES_OPTION) {
				if (DAO_PDP.capNhatPhieuDatPhong(phieuDatPhong)) {
					dao_Phong.capNhat_TranThaiPhong(maPhong, trThaiPh.getMaTrangThai());
					JOptionPane.showMessageDialog(null,
							"Chuyển phòng cho phiếu đặt phòng " + maPDP.trim() + " thành công");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Thất bại, vui lòng thử lại");
				}
			}

		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Thất bại, vui lòng thử lại");
		}
	}

	public void SetModal_PhieuChuyenPhong(Timestamp thoiGianNhanPhong, String maPhieu, String tenNV, String soDT,
			String tenKH) {
		
		txtMaPDP.setText(maPhieu);
		txtNhanVien.setText(tenNV);
		txtSoDienThoai.setText(soDT);
		txtTenKH.setText(tenKH);
		date_ChuyenPhong.setDate(cal.getTime()); // Thời gian chuyển phòng là thời gian hiện tại
		date_NhanPhongBanDau.setDate(thoiGianNhanPhong); // Thời gian lần đầu khách vào phòng

		// Tính số giờ đã hát
		long khoangCachThoiGian = date_ChuyenPhong.getDate().getTime() - date_NhanPhongBanDau.getDate().getTime();
		System.out.println(date_ChuyenPhong.getDate().getTime());
		double soGioDaHat = khoangCachThoiGian / (60 * 60 * 1000);
		txt_SoGioDaHat.setText(soGioDaHat + "");

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
				Object[] rowData = { ph.getMaPhong(), ph.getTenPhong(), loaiPh.getTenLoaiPhong(),
						trThaiPh.getTenTrangThai(), ph.getNgayTaoPhong(), ph.getViTriPhong(), ph.getGhiChu(),
						ph.getTinhTrangPhong() };
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

		String tenPhong = model.getValueAt(row, 1).toString().trim();
		String tenLoaiPhong = model.getValueAt(row, 2).toString().trim();

		for (LoaiPhong loaiPh : dao_LoaiPhong.layTatCaLoaiPhong()) {
			if (tenLoaiPhong.equals(loaiPh.getTenLoaiPhong().toString().trim()))
				txtGiaPhong.setText(loaiPh.getGiaTien() + "");
		}
		txtTenPhong.setText(tenPhong);
		txtLoaiPhong.setText(tenLoaiPhong);
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