package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Toolkit;

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
import javax.swing.SpinnerDateModel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class JDialog_CapNhatPhieuDatPhongTruoc extends JFrame implements ActionListener {



	private JPanel contentPane;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private JTextField txtMaPDP;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoDienThoai;

	private JTextField txtTenKH;
	private JTextField txtTienCoc;
	private JTextField txtNhanVien;

	private ArrayList<PhieuDatPhong> dsPDP;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<NhanVien> dsNV;
	private ArrayList<Phong> dsPhong;

	private PhieuDatPhong_DAO DAO_PDP;
	private KhachHang_DAO DAO_KH;
	private NhanVien_DAO DAO_NV;
	private Phong_DAO DAO_P;
	private PhieuDatPhong pdp;
	private KhachHang kh;
	private NhanVien nhanVien;
	private Phong p;
	private LoaiPhong_DAO DAO_LP;
	private LoaiPhong lp;
	private JDateChooser date_DatPhong;

	private JDateChooser date_NhanPhong;

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private JTextArea txtMoTa;
	private JTextField txtMaPhong;
	private String maPDP;
	private JButton btnLuu;
	private JTable table_DSPhong;
	private TrangThaiPhong_DAO DAO_TTP;
	private ArrayList<Phong> dsP;
	private DefaultTableModel model;
	private JButton btnTimKiem;
	private JComboBox comboBox;

	private AbstractButton btnThoat;
	private SpinnerDateModel dateModel;

	private JSpinner spnThoiGianNhanPhong;
	private JSpinner spnThoiGianDatPhong;

	private JTextField txtGioHat;

	private ArrayList<Phong> dsDemo;
	private PhieuDatPhong_DAO DAP_PDP = new PhieuDatPhong_DAO();
	/**
	 * Create the panel.
	 */
	public JDialog_CapNhatPhieuDatPhongTruoc(NhanVien nhanVien) {
		this.nhanVien = nhanVien;

		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JDialog_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 725);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_PDP = new JPanel();
		panel_PDP.setBackground(new Color(255, 255, 255));
		panel_PDP.setBounds(0, 0, 884, 684);
		contentPane.add(panel_PDP);
		panel_PDP.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(22, 380, 417, 155);
		panel_PDP.add(panel);
		panel.setLayout(null);

		JLabel lblTenPhong = new JLabel("Mã phòng");
		lblTenPhong.setForeground(new Color(0, 0, 0));
		lblTenPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenPhong.setBounds(10, 25, 82, 27);
		panel.add(lblTenPhong);

		JLabel lblLoaiPhong_1_1 = new JLabel("Loại phòng");
		lblLoaiPhong_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1.setBounds(10, 65, 82, 27);
		panel.add(lblLoaiPhong_1_1);

		JLabel lblLoaiPhong_1_1_1 = new JLabel("Giá phòng");
		lblLoaiPhong_1_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_1.setBounds(10, 105, 82, 27);
		panel.add(lblLoaiPhong_1_1_1);

		txtMaPhong = new JTextField();
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(102, 25, 294, 27);
		panel.add(txtMaPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEnabled(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(102, 65, 294, 27);
		panel.add(txtLoaiPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEnabled(false);
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(102, 105, 294, 27);
		panel.add(txtGiaPhong);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(449, 380, 413, 155);
		panel_PDP.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSoDienThoai.setBounds(10, 25, 85, 27);
		panel_1.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtTenKH.setText("");
					String regexSDT = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
					Pattern patternSDT = Pattern.compile(regexSDT);
					java.util.regex.Matcher matcher = patternSDT.matcher(txtSoDienThoai.getText().trim());
					if (!matcher.matches()) {
						JOptionPane.showMessageDialog(null, "Số điện thoại bạn nhập vào không đúng", "Thông báo lỗi",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						txtTenKH.setEnabled(true);
					}

					if (txtSoDienThoai.getText().trim() != "" && matcher.matches()) {
						KhachHang_DAO KH_DAO = new KhachHang_DAO();
						KhachHang kh = new KhachHang();
						if (KH_DAO.layKhachHang_TheoSDT(txtSoDienThoai.getText().trim()) != null) {
							kh = KH_DAO.layKhachHang_TheoSDT(txtSoDienThoai.getText().trim());
							txtTenKH.setText(kh.getHoTen());
							txtTenKH.setEnabled(false);
						} else {
							txtTenKH.setEnabled(true);
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(120, 25, 276, 27);
		panel_1.add(txtSoDienThoai);

		JLabel lblLoaiPhong_1_1_2 = new JLabel("Tên khách hàng");
		lblLoaiPhong_1_1_2.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_2.setBounds(10, 65, 100, 27);
		panel_1.add(lblLoaiPhong_1_1_2);

		txtTenKH = new JTextField();
		txtTenKH.setEnabled(false);
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(120, 65, 276, 27);
		panel_1.add(txtTenKH);

		JLabel lblTienCoc = new JLabel("Tiền cọc");
		lblTienCoc.setForeground(Color.BLACK);
		lblTienCoc.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTienCoc.setBounds(10, 105, 82, 27);
		panel_1.add(lblTienCoc);

		txtTienCoc = new JTextField();
		txtTienCoc.setEnabled(false);
		txtTienCoc.setEditable(false);
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(120, 105, 276, 27);
		panel_1.add(txtTienCoc);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(22, 45, 840, 128);
		panel_PDP.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTGDatPhong = new JLabel("Thời gian đặt phòng");
		lblTGDatPhong.setForeground(new Color(0, 0, 0));
		lblTGDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTGDatPhong.setBounds(10, 11, 136, 27);
		panel_2.add(lblTGDatPhong);

		date_DatPhong = new JDateChooser();
		date_DatPhong.setEnabled(false);
		date_DatPhong.setDateFormatString("yyyy-MM-dd ");
		date_DatPhong.setDate(new java.util.Date());
		date_DatPhong.setBounds(167, 11, 108, 27);
		panel_2.add(date_DatPhong);

		JLabel lblNhanVien = new JLabel("Nhân viên");
		lblNhanVien.setForeground(new Color(0, 0, 0));
		lblNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNhanVien.setBounds(390, 10, 82, 27);
		panel_2.add(lblNhanVien);

		JLabel lblMaPDP = new JLabel("Mã phiếu ");
		lblMaPDP.setForeground(new Color(0, 0, 0));
		lblMaPDP.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPDP.setBounds(622, 11, 82, 27);
		panel_2.add(lblMaPDP);

		txtMaPDP = new JTextField();
		txtMaPDP.setEnabled(false);
		txtMaPDP.setEditable(false);
		txtMaPDP.setText(maPDP);
		txtMaPDP.setBounds(688, 11, 140, 27);
		panel_2.add(txtMaPDP);
		txtMaPDP.setColumns(10);

		txtNhanVien = new JTextField();

		txtNhanVien.setEnabled(false);
		txtNhanVien.setEditable(false);
		txtNhanVien.setText(nhanVien.getHoTen());
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(463, 11, 136, 27);
		panel_2.add(txtNhanVien);

		JLabel lblThiGianNhn = new JLabel("Thời gian nhận phòng");
		lblThiGianNhn.setForeground(Color.BLACK);
		lblThiGianNhn.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblThiGianNhn.setBounds(10, 49, 149, 27);
		panel_2.add(lblThiGianNhn);

		date_NhanPhong = new JDateChooser();
		date_NhanPhong.setDateFormatString("yyyy-MM-dd");
		date_NhanPhong.setBounds(167, 49, 108, 27);
		panel_2.add(date_NhanPhong);

		JLabel lblLoiPhng = new JLabel("Loại phòng");
		lblLoiPhng.setForeground(Color.BLACK);
		lblLoiPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoiPhng.setBounds(390, 50, 82, 27);
		panel_2.add(lblLoiPhng);

		comboBox = new JComboBox();
		DAO_LP = new LoaiPhong_DAO();
		ArrayList<LoaiPhong> dsLP = DAO_LP.layTatCaLoaiPhong();
		for (LoaiPhong lp : dsLP) {
			comboBox.addItem(lp.getMaLoaiPhong());
			;
		}
		comboBox.setBounds(463, 50, 136, 27);
		panel_2.add(comboBox);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(JDialog_CapNhatPhieuDatPhongTruoc.class.getResource("/icon/seach_16px.png")));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue1));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocPhongTrongTheoNgay();
			}
		});
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnTimKiem.setBounds(688, 49, 140, 30);
		panel_2.add(btnTimKiem);

		dateModel = new SpinnerDateModel();
		dateModel.setCalendarField(Calendar.MINUTE);

		SpinnerDateModel dateModel1 = new SpinnerDateModel();
		dateModel1.setCalendarField(Calendar.MINUTE);

		spnThoiGianNhanPhong = new JSpinner(dateModel1);
		JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spnThoiGianNhanPhong, "HH:mm");
		spnThoiGianNhanPhong.setEditor(editor1);
		spnThoiGianNhanPhong.setBounds(285, 50, 65, 27);
		panel_2.add(spnThoiGianNhanPhong);

		SpinnerDateModel dateModel2 = new SpinnerDateModel();
		dateModel2.setCalendarField(Calendar.MINUTE);
		spnThoiGianDatPhong = new JSpinner(dateModel2);
		spnThoiGianDatPhong.setEnabled(false);
		JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spnThoiGianDatPhong, "HH:mm");
		spnThoiGianDatPhong.setEditor(editor2);
		spnThoiGianDatPhong.setBounds(285, 11, 65, 27);
		panel_2.add(spnThoiGianDatPhong);

		JLabel lblTraPhongDK = new JLabel("Số giờ hát dự kiến");
		lblTraPhongDK.setForeground(Color.BLACK);
		lblTraPhongDK.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTraPhongDK.setBounds(10, 86, 160, 27);
		panel_2.add(lblTraPhongDK);

		txtGioHat = new JTextField();
		txtGioHat.setBounds(167, 86, 108, 27);
		panel_2.add(txtGioHat);
		txtGioHat.setColumns(10);

		JLabel lblLoaiPhong_1_1_1_1 = new JLabel("Mô tả");
		lblLoaiPhong_1_1_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_1_1.setBounds(32, 536, 82, 27);
		panel_PDP.add(lblLoaiPhong_1_1_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(22, 564, 840, 68);
		panel_PDP.add(panel_3);
		panel_3.setLayout(null);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(10, 11, 820, 46);
		panel_3.add(txtMoTa);

		btnLuu = new JButton("Lưu");
		btnLuu.setSelectedIcon(new ImageIcon(JDialog_CapNhatPhieuDatPhongTruoc.class.getResource("/icon/save_16px.png")));

		btnLuu.setBackground(Color.decode(hexColor_Green));
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLuu.setBounds(652, 643, 100, 30);
		panel_PDP.add(btnLuu);

		btnThoat = new JButton("Thoát");
		btnThoat.setSelectedIcon(
				new ImageIcon(JDialog_CapNhatPhieuDatPhongTruoc.class.getResource("/icon/exit_16px.png")));
		btnThoat.setBackground(Color.decode(hexColor_Blue2));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThoat.setBounds(762, 643, 100, 30);
		panel_PDP.add(btnThoat);

		JLabel lblPhiutPhng = new JLabel("CẬP NHẬT PHIẾU ĐẶT PHÒNG TRƯỚC");
		lblPhiutPhng.setForeground(new Color(5, 74, 145));
		lblPhiutPhng.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPhiutPhng.setBounds(22, 11, 389, 27);
		panel_PDP.add(lblPhiutPhng);

		JPanel panel_DSPhongTrong = new JPanel();
		panel_DSPhongTrong.setBackground(new Color(255, 255, 255));
		panel_DSPhongTrong.setBorder(new TitledBorder(null, "Danh s\u00E1ch ph\u00F2ng hát",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DSPhongTrong.setBounds(22, 184, 840, 193);
		panel_PDP.add(panel_DSPhongTrong);
		panel_DSPhongTrong.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 19, 820, 163);
		panel_DSPhongTrong.add(scrollPane);

		table_DSPhong = new JTable();
		table_DSPhong.setFillsViewportHeight(true);
		table_DSPhong.setBackground(new Color(255, 255, 255));
		table_DSPhong.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_DSPhong.getSelectedRow();
				txtMaPhong.setText(model.getValueAt(row, 0).toString());
				txtLoaiPhong.setText(model.getValueAt(row, 1).toString());
				txtGiaPhong.setText(model.getValueAt(row, 3).toString());
				txtTienCoc.setText(model.getValueAt(row, 3).toString());

			}
		});
		table_DSPhong.setModel(new DefaultTableModel(new Object[][] {}, new String[] {

				"M\u00E3 ph\u00F2ng", "Lo\u1EA1i ph\u00F2ng", "Tr\u1EA1ng th\u00E1i", "Gi\u00E1 ph\u00F2ng/Gi\u1EDD"

		}));
		DAO_P = new Phong_DAO();

		DAO_LP = new LoaiPhong_DAO();

		DAO_TTP = new TrangThaiPhong_DAO();

		dsP = new ArrayList<Phong>();

		model = (DefaultTableModel) table_DSPhong.getModel();

		try {
			dsP = DAO_P.layTatCaPhong();

			if (dsP != null) {

				dsP.forEach(p -> {

					LoaiPhong lp = new LoaiPhong();
					TrangThaiPhong ttp = new TrangThaiPhong();
					ttp = DAO_TTP.timTrangThaiPhong_TheoMaTrangThai(p.getTrangThaiPhong().getMaTrangThai());
					lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
					Object[] rowData = { p.getMaPhong(), p.getLoaiPhong().getMaLoaiPhong(), ttp.getTenTrangThai(),
							lp.getGiaTien() };
					model.addRow(rowData);

				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table_DSPhong);

		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTimKiem.addActionListener(this);

	}

	public void capNhat() {

		String maPDP = txtMaPDP.getText().trim();
		String maPhong = txtMaPhong.getText().toString().trim();
		Phong p = new Phong(maPhong);
		NhanVien nv = new NhanVien(nhanVien.getMaNhanVien());
		KhachHang_DAO DAO_KH = new KhachHang_DAO();
		KhachHang kh = DAO_KH.layKhachHang_TheoSDT(txtSoDienThoai.getText().trim());

		java.sql.Timestamp tgDatPhong = new java.sql.Timestamp(date_DatPhong.getDate().getTime());

		java.sql.Timestamp tgNhanPhong = new java.sql.Timestamp(date_NhanPhong.getDate().getTime());

		Double tienCoc = Double.parseDouble(txtTienCoc.getText());

		String moTa = txtMoTa.getText().trim();

		DAO_PDP = new PhieuDatPhong_DAO();

		PhieuDatPhong pdp = new PhieuDatPhong(maPDP, p, nv, kh, tgDatPhong, tgNhanPhong, tienCoc, "Chờ nhận phòng",
				moTa);

		System.out.println(pdp.toString());

		if (pdp.getTrangThai().equals("Chờ nhận phòng")) {

			if (DAO_PDP.capNhatPhieuDatPhong(pdp)) {

				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			} else {

				JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Phiếu " + maPDP + "không thể cập nhật!");
		}

	}

	private boolean Invalid() {
		// TODO Auto-generated method stub
		return false;
	}

	public void HienThongTinTheoMaPDP(String ma) {
		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_KH = new KhachHang_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_P = new Phong_DAO();
		DAO_LP = new LoaiPhong_DAO();

		KhachHang kh = new KhachHang();
		NhanVien nv = new NhanVien();
		Phong p = new Phong();
		LoaiPhong lp = new LoaiPhong();

		pdp = DAO_PDP.layPhieuDatPhong_TheoMaPhieuDat(ma);

		p = DAO_P.timPhong_TheoMaPhong(pdp.getPhong().getMaPhong());

		kh = DAO_KH.layKhachHang_TheoMaKhachHang(pdp.getKhachHang().getMaKhachHang());

		nv = DAO_NV.timNhanVien_TheoMaNhanVien(pdp.getNhanVien().getMaNhanVien());

		lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());

		txtMaPDP.setText(pdp.getMaPhieuDat());

		txtLoaiPhong.setText(p.getLoaiPhong().getMaLoaiPhong());

		txtNhanVien.setText(nv.getHoTen());

		txtTenKH.setText(kh.getHoTen());

		txtSoDienThoai.setText(kh.getSoDienThoai());

		txtGiaPhong.setText(Double.toString(lp.getGiaTien()));

		txtMaPhong.setText(pdp.getPhong().getMaPhong());

		txtTienCoc.setText(Double.toString(pdp.getTienCoc()));

		date_DatPhong.setDate(pdp.getThoiGianDatPhong());

		date_NhanPhong.setDate(pdp.getThoiGianNhanPhong());

		txtMoTa.setText(pdp.getMoTa());

	}

	public void LocPhongTrongTheoNgay() {

		int soGioHat = Integer.parseInt(txtGioHat.getText());

		Timestamp timestampNhanPhong = selectDateTime(date_NhanPhong, spnThoiGianNhanPhong);

		Timestamp timestampTraPhong = tinhGioTraPhongDKTheoSoGioHat(date_NhanPhong, spnThoiGianNhanPhong, soGioHat);

		String lphong = (String) comboBox.getSelectedItem();

		List<Phong> dsP = DAO_P.layDanhSachPhongTrongTheoNgayVaLoaiPhong(timestampTraPhong, timestampNhanPhong, lphong);

		if (dsP != null) {

			clearTable();

			for (Phong p : dsP) {

				LoaiPhong lp = new LoaiPhong();
				TrangThaiPhong ttp = new TrangThaiPhong();
				ttp = DAO_TTP.timTrangThaiPhong_TheoMaTrangThai(p.getTrangThaiPhong().getMaTrangThai());

				lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());

				Object[] rowData = { p.getMaPhong(), p.getLoaiPhong().getMaLoaiPhong(), ttp.getTenTrangThai(),
						lp.getGiaTien() };

				model.addRow(rowData);

			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy");

		}
	}

	public Timestamp selectDateTime(JDateChooser date, JSpinner hour) {

		Date selectedDate = date.getDate();
		Date selectedTime = (Date) hour.getValue();

		// Kết hợp ngày và giờ thành một giá trị java.util.Date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedTime);

		Calendar selectedDateTime = Calendar.getInstance();
		selectedDateTime.setTime(selectedDate);
		selectedDateTime.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
		selectedDateTime.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
		selectedDateTime.set(Calendar.SECOND, 0);
		selectedDateTime.set(Calendar.MILLISECOND, 0);

		// Chuyển đổi giá trị thành java.sql.Timestamp
		Timestamp timestamp = new Timestamp(selectedDateTime.getTimeInMillis());
		return timestamp;
	}

	public Timestamp tinhGioTraPhongDKTheoSoGioHat(JDateChooser date, JSpinner hour, int soGioHat) {
		Date selectedDate = date.getDate();
		Date selectedTime = (Date) hour.getValue();

		// Kết hợp ngày và giờ thành một giá trị java.util.Date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedTime);
		calendar.add(Calendar.HOUR, soGioHat);

		Calendar selectedDateTime = Calendar.getInstance();
		selectedDateTime.setTime(selectedDate);
		selectedDateTime.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
		selectedDateTime.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
		selectedDateTime.set(Calendar.SECOND, 0);
		selectedDateTime.set(Calendar.MILLISECOND, 0);

		// Chuyển đổi giá trị thành java.sql.Timestamp
		Timestamp timestamp = new Timestamp(selectedDateTime.getTimeInMillis());
		return timestamp;
	}

	public void clearTable() {

		DefaultTableModel model = (DefaultTableModel) table_DSPhong.getModel();
		model.setRowCount(0);
	}

	public Timestamp selectDateTimeNhanPhong(JDateChooser date, JSpinner hour) {
		Date selectedDate = date.getDate() == null ? new Date() : date.getDate();
		Date selectedTime = (Date) hour.getValue();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedTime);

		Calendar selectedDateTime = Calendar.getInstance();
		selectedDateTime.setTime(selectedDate);
		selectedDateTime.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
		selectedDateTime.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
		selectedDateTime.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
		selectedDateTime.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND));

		Timestamp timestamp = new Timestamp(selectedDateTime.getTimeInMillis());
		return timestamp;
	}

	public void renderDanhSachPhongTrong() {

		model = (DefaultTableModel) table_DSPhong.getModel();

		Timestamp timestampNhanPhong = selectDateTimeNhanPhong(date_NhanPhong, spnThoiGianNhanPhong);

		String maLoaiP = comboBox.getSelectedItem().toString().trim().equals("Tất cả") ? ""
				: comboBox.getSelectedItem().toString().trim();

		String soGioHatDuKien = txtGioHat.getText().trim().equals("") ? "1" : txtGioHat.getText();
		try {

			dsP = DAO_P.timDSPhongTheoMaLoaiPhong(maLoaiP);

			dsDemo = new ArrayList<Phong>();
			dsDemo = DAP_PDP.danhSachPhongDat_theoPhieuDat(timestampNhanPhong, soGioHatDuKien, maLoaiP);
			if (dsDemo != null) {
				dsDemo.forEach(ph -> {
					dsP.forEach(phRender -> {
						if (phRender.getMaPhong().trim().equals(ph.getMaPhong().trim())) {
							phRender.setTrangThaiPhong(new TrangThaiPhong("OCP"));
						}
					});
				});
			}

			// Lọc phòng trống
			if (dsP != null) {
				dsP.forEach(p -> {
					LoaiPhong lp = new LoaiPhong();
					TrangThaiPhong ttp = new TrangThaiPhong();

					ttp = DAO_TTP.timTrangThaiPhong_TheoMaTrangThai(p.getTrangThaiPhong().getMaTrangThai());
					lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());

					Object[] rowData = { p.getMaPhong(), p.getLoaiPhong().getMaLoaiPhong(), ttp.getTenTrangThai(),
							lp.getGiaTien() };
					if (p.getTrangThaiPhong().getMaTrangThai().trim().equals("VC")) {
						model.addRow(rowData);
					}

				});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void locPhongTrongTheoNgay() {

		clearTable();
		renderDanhSachPhongTrong();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnLuu)) {
			capNhat();
		}
		if (o.equals(btnThoat)) {
			dispose();
		}
		if (o.equals(btnTimKiem)) {
			locPhongTrongTheoNgay();
		}
	}

}
