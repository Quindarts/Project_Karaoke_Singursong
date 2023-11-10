package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;

import ConnectDB.ConnectDB;
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
import OtherFunction.HelpRamDomKH;
import OtherFunction.HelpRamDomMa;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Modal_PhieuDatPhongTruoc extends JFrame {

	private static Modal_PhieuDatPhongTruoc frame;
	private JPanel contentPane;
	private JTextField txtGioDatPhong;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private JTextField txtMaPDP;
	private JTextField txtMaPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoDienThoai;
	private JTextField txtTenKH;
	private JTextField txtTienCoc;
	private JTextField txtNhanVien;
	private JTextField textField;

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

	private Phong p;
	private LoaiPhong_DAO DAO_LP;
	private LoaiPhong lp;
	private JDateChooser date_DatPhong;
	private JButton btnDatPhong;
	private JDateChooser date_NhanPhong;

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private JTable table_DSPhong;
	private ArrayList<Phong> dsP;
	private TrangThaiPhong_DAO DAO_TTP;
	private DefaultTableModel model;
	private NhanVien nhanVien;
	private String ma;
	private JTextArea txtMoTa;
	private String maPDP;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			frame = new Modal_PhieuDatPhongTruoc(nhanVien);
//			frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
//			FlatLightLaf.setup();
//			frame.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the panel.
	 */
	public Modal_PhieuDatPhongTruoc(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		
	
//		try {
//			ConnectDB.getInstance().connect();
////			System.out.println("Connected!!!!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 709);
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
		panel_PDP.setBounds(0, 0, 884, 670);
		contentPane.add(panel_PDP);
		panel_PDP.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(22, 332, 417, 155);
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
		txtMaPhong.setEnabled(false);
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(102, 25, 294, 27);
		panel.add(txtMaPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEnabled(false);
		txtLoaiPhong.setEditable(false);
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
		panel_1.setBounds(449, 332, 413, 155);
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
		panel_2.setBounds(22, 45, 840, 86);
		panel_PDP.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTGDatPhong = new JLabel("Thời gian đặt phòng");
		lblTGDatPhong.setForeground(new Color(0, 0, 0));
		lblTGDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTGDatPhong.setBounds(10, 11, 136, 27);
		panel_2.add(lblTGDatPhong);

		date_DatPhong = new JDateChooser();
		date_DatPhong.setEnabled(false);
		date_DatPhong.setDateFormatString("yyyy-MM-dd  h:mm:ss a");
		date_DatPhong.setDate(new java.util.Date());
		date_DatPhong.setBounds(167, 11, 157, 27);
		panel_2.add(date_DatPhong);

		txtGioDatPhong = new JTextField();
		txtGioDatPhong.setEnabled(false);
		txtGioDatPhong.setBounds(325, 12, 55, 27);
		panel_2.add(txtGioDatPhong);
		txtGioDatPhong.setColumns(10);

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
		date_NhanPhong.setDateFormatString("yyyy-MM-dd  h:mm:ss a");
		date_NhanPhong.setBounds(167, 49, 157, 27);
		panel_2.add(date_NhanPhong);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(325, 50, 55, 27);
		panel_2.add(textField);

		JLabel lblLoiPhng = new JLabel("Loại phòng");
		lblLoiPhng.setForeground(Color.BLACK);
		lblLoiPhng.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoiPhng.setBounds(390, 50, 82, 27);
		panel_2.add(lblLoiPhng);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(463, 50, 136, 27);
		panel_2.add(comboBox);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(688, 49, 140, 27);
		panel_2.add(btnNewButton);

		JLabel lblLoaiPhong_1_1_1_1 = new JLabel("Mô tả");
		lblLoaiPhong_1_1_1_1.setForeground(Color.BLACK);
		lblLoaiPhong_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLoaiPhong_1_1_1_1.setBounds(32, 491, 82, 27);
		panel_PDP.add(lblLoaiPhong_1_1_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(22, 519, 840, 68);
		panel_PDP.add(panel_3);
		panel_3.setLayout(null);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(10, 11, 820, 46);
		panel_3.add(txtMoTa);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taoPhieu();
			}
		});

		btnDatPhong.setBackground(Color.decode(hexColor_Green));
		btnDatPhong.setForeground(new Color(255, 255, 255));
		btnDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDatPhong.setBounds(652, 629, 100, 30);
		panel_PDP.add(btnDatPhong);

		JButton btnHy = new JButton("Hủy");
		btnHy.setBackground(Color.decode(hexColor_Blue2));
		btnHy.setForeground(new Color(255, 255, 255));
		btnHy.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnHy.setBounds(762, 629, 100, 30);
		panel_PDP.add(btnHy);

		JLabel lblPhiutPhng = new JLabel("PHIẾU ĐẶT PHÒNG TRƯỚC");
		lblPhiutPhng.setForeground(new Color(5, 74, 145));
		lblPhiutPhng.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPhiutPhng.setBounds(22, 11, 237, 27);
		panel_PDP.add(lblPhiutPhng);

		JPanel panel_DSPhongTrong = new JPanel();
		panel_DSPhongTrong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_DSPhongTrong.setBounds(22, 136, 840, 185);
		panel_PDP.add(panel_DSPhongTrong);
		panel_DSPhongTrong.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 820, 163);
		panel_DSPhongTrong.add(scrollPane);

		table_DSPhong = new JTable();
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
		table_DSPhong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phòng", "Loại phòng", "Trạng thái", "Giá phòng/Giờ" }));
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
			// TODO: handle exception
		}
		scrollPane.setViewportView(table_DSPhong);

	}

	public void taoPhieu() {
		HelpRamDomMa help = new HelpRamDomMa();
		maPDP = help.taoMa("PhieuDatPhong", "maPhieuDat", "PD");
//		String maPDP = txtMaPDP.getText().trim();
		String maPhong = txtMaPhong.getText().toString().trim();
		Phong p = new Phong(maPhong);
		NhanVien nv = new NhanVien(nhanVien.getMaNhanVien());
		KhachHang_DAO DAO_KH = new KhachHang_DAO();
		KhachHang kh = DAO_KH.layKhachHang_TheoSDT(txtSoDienThoai.getText().trim());
		java.sql.Date tgDatPhong = new java.sql.Date(date_DatPhong.getDate().getTime());
		java.sql.Date tgNhanPhong = new java.sql.Date(date_NhanPhong.getDate().getTime());
		Double tienCoc = Double.parseDouble(txtTienCoc.getText());
		String moTa = txtMoTa.getText().trim();
		DAO_PDP = new PhieuDatPhong_DAO();
		PhieuDatPhong pdp = new PhieuDatPhong(maPDP, p, nv, kh, tgDatPhong, tgNhanPhong, tienCoc, "Chờ nhận phòng", moTa);
		
		if(DAO_PDP.taoPhieuDatPhong(pdp)){
			JOptionPane.showMessageDialog(null, "Thêm phiếu thành công");
		}
		else {
			JOptionPane.showMessageDialog(null, "Thất bại");
		}
		
		
		
		
	}
}
