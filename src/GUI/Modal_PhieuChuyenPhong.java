package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Modal_PhieuChuyenPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtGio;
	
	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	
	private JTextField txtMaPDP;
	private JTextField txtTenPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoDienThoai;
	private JTextField txtTenKH;
	private JTextField txtNhanVien;
	private JTextField textField;
	private JTable table;


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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin ph\u00F2ng m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(22, 354, 417, 155);
		panel_PDP.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenPhong = new JLabel("Tên phòng");
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
		
		txtTenPhong = new JTextField();
		txtTenPhong.setEnabled(false);
		txtTenPhong.setEditable(false);
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(102, 25, 294, 27);
		panel.add(txtTenPhong);
		
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
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(466, 354, 413, 155);
		panel_PDP.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSoDienThoai.setBounds(10, 25, 85, 27);
		panel_1.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEnabled(false);
		txtSoDienThoai.setEditable(false);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(22, 45, 857, 86);
		panel_PDP.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTGDatPhong = new JLabel("Thời gian chuyển phòng");
		lblTGDatPhong.setForeground(new Color(0, 0, 0));
		lblTGDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTGDatPhong.setBounds(199, 11, 155, 27);
		panel_2.add(lblTGDatPhong);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(376, 11, 157, 27);
		panel_2.add(dateChooser);
		
		txtGio = new JTextField();
		txtGio.setEnabled(false);
		txtGio.setBounds(534, 12, 55, 27);
		panel_2.add(txtGio);
		txtGio.setColumns(10);
		
		JLabel lblNhanVien = new JLabel("Nhân viên");
		lblNhanVien.setForeground(new Color(0, 0, 0));
		lblNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNhanVien.setBounds(615, 49, 82, 27);
		panel_2.add(lblNhanVien);
		
		JLabel lblMaPDP = new JLabel("Mã phiếu ");
		lblMaPDP.setForeground(new Color(0, 0, 0));
		lblMaPDP.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaPDP.setBounds(615, 11, 82, 27);
		panel_2.add(lblMaPDP);
		
		txtMaPDP = new JTextField();
		txtMaPDP.setEditable(false);
		txtMaPDP.setEnabled(false);
		txtMaPDP.setBounds(701, 11, 140, 27);
		panel_2.add(txtMaPDP);
		txtMaPDP.setColumns(10);
		
		txtNhanVien = new JTextField();
		txtNhanVien.setEnabled(false);
		txtNhanVien.setEditable(false);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(701, 49, 140, 27);
		panel_2.add(txtNhanVien);
		
		JLabel lblThiGianNhn = new JLabel("Thời gian nhận phòng");
		lblThiGianNhn.setForeground(Color.BLACK);
		lblThiGianNhn.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblThiGianNhn.setBounds(199, 49, 149, 27);
		panel_2.add(lblThiGianNhn);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(376, 49, 157, 27);
		panel_2.add(dateChooser_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(534, 50, 55, 27);
		panel_2.add(textField);
		
		JButton btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDatPhong.setBackground(Color.decode(hexColor_Green));
		btnDatPhong.setForeground(new Color(255, 255, 255));
		btnDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDatPhong.setBounds(762, 520, 100, 30);
		panel_PDP.add(btnDatPhong);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setBackground(Color.decode(hexColor_Blue2));
		btnHy.setForeground(new Color(255, 255, 255));
		btnHy.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnHy.setBounds(652, 520, 100, 30);
		panel_PDP.add(btnHy);
		
		JLabel lblPhiutPhng = new JLabel("CHUYỂN PHÒNG");
		lblPhiutPhng.setForeground(new Color(5, 74, 145));
		lblPhiutPhng.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblPhiutPhng.setBounds(22, 11, 237, 27);
		panel_PDP.add(lblPhiutPhng);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch ph\u00F2ng tr\u1ED1ng hi\u1EC7n t\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(22, 142, 857, 205);
		panel_PDP.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 837, 171);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phòng", "Tên phòng", "Loại phòng",
						"Trạng thái", "Ngày tạo phòng", "Vị trí phòng",
						"Ghi chú", "Tình trạng phòng" }) );
		scrollPane.setViewportView(table);

	}
}
