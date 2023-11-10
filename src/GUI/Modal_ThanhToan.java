package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.ConnectDB;
import DAO.Phong_DAO;
import Entity.ChiTietDichVu;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.KhuyenMai;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuDatPhong;
import Entity.Phong;
import GUI.JPanel_QuanLyKhachHang.RoundedTransparentBorder;
import OtherFunction.HelpDate;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Modal_ThanhToan extends JFrame implements ActionListener {

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private JPanel contentPane;
	private JTextField txt__tienCoc;
	private JTextField txt__chietKhau;
	private JTextField txt__tongHoaDon;
	private JTextField txt__tienKhachDua;
	private JTextField txt__tienThoiLai;
	private JTextField txt__thoiGianNhanPhong;
	private JTextField txt__thoiGianTraPhong;
	private JTextField txt__soGioHat;
	private JTextField txt__giaPhong;
	private JTextField txt__tienPhong;
	private JTextField txt_khachHang;
	private JTextField txt__maPhong;
	private JTextField txt__soDienThoai;
	private JButton btn__exit;
	private JButton btn__thanhToan;

	// Entity
	private HoaDon hoaDon;
	private KhachHang khachHang;
	private LoaiPhong loaiPhong;
	private Phong phong;
	//
	private HelpDate hDate;
	
	private JTable table_DichVu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			private HelpDate hDate;
			private Phong_DAO DAO_P;

			public void run() {
				try {
					
					try {
						ConnectDB.getInstance().connect();
						System.out.println("Connected!!!!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					FlatLightLaf.setup();
					DAO_P = new Phong_DAO();
					Phong phong = DAO_P.timPhong_TheoMaPhong("P101");
					LoaiPhong loaiPhong = new LoaiPhong(phong.getLoaiPhong().getMaLoaiPhong());
					hDate = new HelpDate();
					KhachHang kh = new KhachHang();
					HoaDon hd = new HoaDon("HD310102122", kh, new NhanVien(), new PhieuDatPhong(), new KhuyenMai(),
							hDate.chuyenStringThanhDate("2023-10-31"), "Đang thanh toán",
							hDate.chuyenStringThanhDate("2023-10-31"));
					Modal_ThanhToan frame = new Modal_ThanhToan(hd, phong, loaiPhong, kh);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */

	/**
	 * @param hoaDon
	 * @param phong
	 * @param loaiPhong
	 * @param khachHang maPhong, loaiPhong, GiaPhong tenKhachHang, soDienThoai
	 *                  thoiGianNhanPhong, thoiGianTraPhong soGioHat tien phong =
	 *                  soGioHat x giaPhong tienDichVu tienCoc Giamgia chietKhau
	 *                  tongHoaDon = tienKhachDua tienThua
	 * 
	 */
	public Modal_ThanhToan(HoaDon hoaDon, Phong phong, LoaiPhong loaiPhong, KhachHang khachHang) {

		this.hoaDon = hoaDon;
		this.khachHang = khachHang;
		this.phong = phong;
		this.loaiPhong = loaiPhong;
	
		
		System.out.println(hoaDon.toString());
		System.out.println(khachHang.toString());
		System.out.println(loaiPhong.toString());
		System.out.println(phong.toString());


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("THANH TOÁN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 1200, 46);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(599, 433, 555, 243);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(0, 0, 255, 47);
		panel.add(panel_1_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Đã cọc");
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(0, 11, 80, 23);
		panel_1_1_1.add(lblNewLabel_1_2_1);

		txt__tienCoc = new JTextField();
		txt__tienCoc.setColumns(10);
		txt__tienCoc.setBounds(80, 10, 175, 28);
		panel_1_1_1.add(txt__tienCoc);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(new Color(255, 255, 255));
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(0, 56, 255, 77);
		panel.add(panel_1_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Chiết khấu");
		lblNewLabel_1_2_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(0, 11, 80, 23);
		panel_1_1_2.add(lblNewLabel_1_2_2);

		txt__chietKhau = new JTextField();
		txt__chietKhau.setColumns(10);
		txt__chietKhau.setBounds(0, 38, 255, 28);
		panel_1_1_2.add(txt__chietKhau);

		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setBackground(new Color(255, 255, 255));
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBounds(290, 56, 255, 67);
		panel.add(panel_1_1_3);

		JLabel lblNewLabel_1_2_3 = new JLabel("Tổng hóa đơn");
		lblNewLabel_1_2_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_3.setBounds(0, 11, 107, 23);
		panel_1_1_3.add(lblNewLabel_1_2_3);

		txt__tongHoaDon = new JTextField();
		txt__tongHoaDon.setColumns(10);
		txt__tongHoaDon.setBounds(0, 39, 255, 28);
		panel_1_1_3.add(txt__tongHoaDon);

		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setBackground(new Color(255, 255, 255));
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setBounds(0, 143, 255, 95);
		panel.add(panel_1_1_4);

		JLabel lblNewLabel_1_2_4 = new JLabel("Tiền khách đưa");
		lblNewLabel_1_2_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_4.setBounds(0, 11, 129, 23);
		panel_1_1_4.add(lblNewLabel_1_2_4);

		txt__tienKhachDua = new JTextField();
		txt__tienKhachDua.setColumns(10);
		txt__tienKhachDua.setBounds(0, 39, 255, 28);
		panel_1_1_4.add(txt__tienKhachDua);

		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setBackground(new Color(255, 255, 255));
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setBounds(290, 143, 255, 67);
		panel.add(panel_1_1_5);

		JLabel lblNewLabel_1_2_5 = new JLabel("Thối lại");
		lblNewLabel_1_2_5.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_5.setBounds(0, 11, 80, 23);
		panel_1_1_5.add(lblNewLabel_1_2_5);

		txt__tienThoiLai = new JTextField();
		txt__tienThoiLai.setColumns(10);
		txt__tienThoiLai.setBounds(0, 39, 255, 28);
		panel_1_1_5.add(txt__tienThoiLai);

		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBackground(Color.WHITE);
		panel_1_1_1_2.setBounds(290, 0, 255, 47);
		panel.add(panel_1_1_1_2);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Giảm giá (%)");
		lblNewLabel_1_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_1_2.setBounds(0, 11, 80, 23);
		panel_1_1_1_2.add(lblNewLabel_1_2_1_2);

		JTextField txt__giamGia = new JTextField();
		txt__giamGia.setColumns(10);
		txt__giamGia.setBounds(80, 10, 175, 28);
		panel_1_1_1_2.add(txt__giamGia);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(599, 205, 577, 218);
		contentPane.add(panel_2);

		JPanel panel_1_1_6 = new JPanel();
		panel_1_1_6.setBackground(new Color(255, 255, 255));
		panel_1_1_6.setLayout(null);
		panel_1_1_6.setBounds(0, 10, 255, 67);
		panel_2.add(panel_1_1_6);

		JLabel lblNewLabel_1_2_6 = new JLabel("Thời gian nhận phòng");
		lblNewLabel_1_2_6.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_6.setBounds(0, 0, 211, 23);
		panel_1_1_6.add(lblNewLabel_1_2_6);

		txt__thoiGianNhanPhong = new JTextField();
		txt__thoiGianNhanPhong.setColumns(10);
		txt__thoiGianNhanPhong.setBounds(0, 29, 255, 28);
		panel_1_1_6.add(txt__thoiGianNhanPhong);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBounds(290, 10, 255, 67);
		panel_2.add(panel_1_1_1_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Thời gian trả phòng");
		lblNewLabel_1_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_1_1.setBounds(0, 0, 255, 28);
		panel_1_1_1_1.add(lblNewLabel_1_2_1_1);

		txt__thoiGianTraPhong = new JTextField();
		txt__thoiGianTraPhong.setColumns(10);
		txt__thoiGianTraPhong.setBounds(0, 29, 255, 28);
		panel_1_1_1_1.add(txt__thoiGianTraPhong);

		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setBackground(new Color(255, 255, 255));
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBounds(0, 74, 255, 67);
		panel_2.add(panel_1_1_2_1);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Số giờ hát");
		lblNewLabel_1_2_2_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_2_1.setBounds(0, 11, 80, 23);
		panel_1_1_2_1.add(lblNewLabel_1_2_2_1);

		txt__soGioHat = new JTextField();
		txt__soGioHat.setColumns(10);
		txt__soGioHat.setBounds(0, 39, 255, 28);
		panel_1_1_2_1.add(txt__soGioHat);

		JPanel panel_1_1_3_1 = new JPanel();
		panel_1_1_3_1.setBackground(new Color(255, 255, 255));
		panel_1_1_3_1.setLayout(null);
		panel_1_1_3_1.setBounds(290, 74, 255, 67);
		panel_2.add(panel_1_1_3_1);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Giá phòng");
		lblNewLabel_1_2_3_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_3_1.setBounds(0, 11, 80, 23);
		panel_1_1_3_1.add(lblNewLabel_1_2_3_1);

		txt__giaPhong = new JTextField();
		txt__giaPhong.setColumns(10);
		txt__giaPhong.setBounds(0, 39, 255, 28);
		panel_1_1_3_1.add(txt__giaPhong);

		JPanel panel_1_1_4_1 = new JPanel();
		panel_1_1_4_1.setBackground(new Color(255, 255, 255));
		panel_1_1_4_1.setLayout(null);
		panel_1_1_4_1.setBounds(0, 143, 255, 67);
		panel_2.add(panel_1_1_4_1);

		JLabel lblNewLabel_1_2_4_1 = new JLabel("Tiền phòng");
		lblNewLabel_1_2_4_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_4_1.setBounds(0, 10, 80, 23);
		panel_1_1_4_1.add(lblNewLabel_1_2_4_1);

		txt__tienPhong = new JTextField();
		txt__tienPhong.setColumns(10);
		txt__tienPhong.setBounds(0, 39, 255, 28);
		panel_1_1_4_1.add(txt__tienPhong);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(290, 142, 255, 68);
		panel_2.add(panel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tiền dịch vụ");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(0, 11, 80, 23);
		panel_1_1.add(lblNewLabel_1_2);

		JTextField txt__tienDichVu = new JTextField();
		txt__tienDichVu.setColumns(10);
		txt__tienDichVu.setBounds(0, 40, 255, 28);
		panel_1_1.add(txt__tienDichVu);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(599, 56, 577, 139);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_1_1_8 = new JPanel();
		panel_1_1_8.setBackground(new Color(255, 255, 255));
		panel_1_1_8.setBounds(0, 0, 255, 67);
		panel_1.add(panel_1_1_8);
		panel_1_1_8.setLayout(null);

		JLabel lblNewLabel_1_2_8 = new JLabel("Mã phòng");
		lblNewLabel_1_2_8.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_8.setBounds(0, 0, 80, 23);
		panel_1_1_8.add(lblNewLabel_1_2_8);

		txt__maPhong = new JTextField();
		txt__maPhong.setColumns(10);
		txt__maPhong.setBounds(0, 33, 255, 28);
		panel_1_1_8.add(txt__maPhong);

		JPanel panel_1_1_8_2 = new JPanel();
		panel_1_1_8_2.setBackground(new Color(255, 255, 255));
		panel_1_1_8_2.setBounds(290, 0, 255, 67);
		panel_1.add(panel_1_1_8_2);
		panel_1_1_8_2.setLayout(null);

		JLabel lblNewLabel_1_2_8_2 = new JLabel("Loại phòng");
		lblNewLabel_1_2_8_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_8_2.setBounds(0, 0, 80, 23);
		panel_1_1_8_2.add(lblNewLabel_1_2_8_2);

		JTextField txt__loaiPhong = new JTextField();
		txt__loaiPhong.setColumns(10);
		txt__loaiPhong.setBounds(0, 33, 255, 28);
		panel_1_1_8_2.add(txt__loaiPhong);

		JPanel panel_1_1_7 = new JPanel();
		panel_1_1_7.setBackground(new Color(255, 255, 255));
		panel_1_1_7.setBounds(0, 63, 255, 67);
		panel_1.add(panel_1_1_7);
		panel_1_1_7.setLayout(null);

		JLabel lblNewLabel_1_2_7 = new JLabel("Tên khách hàng");
		lblNewLabel_1_2_7.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_7.setBounds(0, 6, 128, 23);
		panel_1_1_7.add(lblNewLabel_1_2_7);

		txt_khachHang = new JTextField();
		txt_khachHang.setColumns(10);
		txt_khachHang.setBounds(0, 39, 255, 28);
		panel_1_1_7.add(txt_khachHang);

		JPanel panel_1_1_8_1 = new JPanel();
		panel_1_1_8_1.setBackground(new Color(255, 255, 255));
		panel_1_1_8_1.setBounds(290, 63, 255, 67);
		panel_1.add(panel_1_1_8_1);
		panel_1_1_8_1.setLayout(null);

		JLabel lblNewLabel_1_2_8_1 = new JLabel("Số điện thoại khách hàng");
		lblNewLabel_1_2_8_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1_2_8_1.setBounds(0, 10, 174, 23);
		panel_1_1_8_1.add(lblNewLabel_1_2_8_1);

		txt__soDienThoai = new JTextField();
		txt__soDienThoai.setColumns(10);
		txt__soDienThoai.setBounds(0, 39, 255, 28);
		panel_1_1_8_1.add(txt__soDienThoai);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(885, 675, 258, 36);
		contentPane.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);

		btn__exit = new JButton("Quay lại");
		btn__exit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn__exit.setBounds(0, 0, 112, 36);
		panel_3.add(btn__exit);

		btn__thanhToan = new JButton("Thanh toán");
		btn__thanhToan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__thanhToan.setBounds(146, 0, 112, 36);
		panel_3.add(btn__thanhToan);

		JPanel panel_Table = new JPanel();
		panel_Table.setBounds(28, 56, 534, 588);
		contentPane.add(panel_Table);

		// Table thong dich vu
		panel_Table.setBackground(Color.decode(hexColor_Blue1));
		panel_Table.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Danh sách dịch vụ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 535, 35);
		panel_Table.add(lblNewLabel_1);

		table_DichVu = new JTable();
		table_DichVu.setBackground(Color.WHITE);
		table_DichVu.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "ID", "T\u00EAn m\u1EB7t h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1",
						"Th\u00E0nh ti\u1EC1n", "C\u1EADp nh\u1EADt" }));

		table_DichVu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 45, 534, 542);
		panel_Table.add(scrollPane);
		scrollPane.add(table_DichVu);
		scrollPane.setViewportView(table_DichVu);

		ChiTietDichVu ctdv = new ChiTietDichVu(hoaDon, null, 30);
		TableColumn btn__CapNhatTableDichVu = table_DichVu.getColumnModel().getColumn(5);

		btn__CapNhatTableDichVu.setCellRenderer(new ButtonCellRendererEditor(ctdv));
		btn__CapNhatTableDichVu.setCellEditor(new ButtonCellRendererEditor(ctdv));

		// Table thong dich vu

		// Event
		btn__thanhToan.addActionListener(this);
		
		txt__chietKhau.setText("5%");
		txt__maPhong.setText(phong.getMaPhong());
		txt__soDienThoai.setText(khachHang.getSoDienThoai());
		txt__soGioHat.setText("5");
//		txt__thoiGianNhanPhong.setText(hDate.chuyenDateThanhString(hoaDon.getNgayLap()));
//		txt__thoiGianTraPhong.setText(hDate.chuyenDateThanhString(hoaDon.getThoiGianKetThuc()));
		txt__tienCoc.setText("0");
		txt__tienPhong.setText("400000");
		txt__tongHoaDon.setText("500000");
		txt_khachHang.setText(khachHang.getHoTen());
		txt__giaPhong.setText(Double.toString(loaiPhong.getGiaTien()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn__exit)) {
			this.setVisible(false);
		}
		if (o.equals(btn__thanhToan)) {
			JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
		}
	}
}
