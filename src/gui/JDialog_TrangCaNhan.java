package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.input.Tailer;

import com.formdev.flatlaf.FlatLightLaf;

import connectDB.ConnectDB;
import dao.LoaiNhanVien_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.KhachHang;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.TaiKhoan;
import other.HelpRamDomKH;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;

public class JDialog_TrangCaNhan extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;

	private JTextField txt_MaNhanVien;
	private JTextField txt_TenNhanVien;
	private JTextField txt_SoDienThoai;
	private JTextField txt_DiaChi;
	private JTextField txt_CCCD;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");

	private LoaiNhanVien_DAO DAO_LNV;

	private ArrayList<LoaiNhanVien> listLNV;

	private JButton btn_Them;
	private JButton btn_BoQua;

	private ButtonGroup btngr_GioiTinh;

	private JDateChooser dateCh_NgaySinh;

	private JLabel img_show_panel;

	private String pathImg;

	private AbstractButton rdbtn_Nam;

	private AbstractButton rdbtn_Nu;
	private JTextField txt_TrangThai;
	private JTextField txt_chucVu;
	private JPasswordField txt_Password;

	private JCheckBox cboShowPassword;
	private JTextField txt_Email;

	private NhanVien nv;

	private NhanVien_DAO DAO_NV;

	private JButton btn_ChangePwd;

	private TaiKhoan TK;

	private TaiKhoan_DAO DAO_TK;
	private JTextField txt_Calam;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JDialog_TrangCaNhan(NhanVien nhanvien) {

		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JDialog_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setBounds(100, 100, 1034, 494);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnl_TieuDe = new JPanel();
		pnl_TieuDe.setBackground(Color.WHITE);
		pnl_TieuDe.setBounds(22, 11, 237, 35);
		contentPane.add(pnl_TieuDe);
		pnl_TieuDe.setLayout(null);

		JLabel lbl_Title = new JLabel("THÔNG TIN NHÂN VIÊN");
		lbl_Title.setBounds(0, 10, 237, 20);
		lbl_Title.setFont(new Font("Segoe UI", Font.BOLD, 17));

		pnl_TieuDe.add(lbl_Title);

		JPanel pnl_Anh = new JPanel();
		pnl_Anh.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnl_Anh.setBackground(Color.WHITE);
		pnl_Anh.setBounds(26, 70, 179, 172);
		contentPane.add(pnl_Anh);
		pnl_Anh.setLayout(null);

		///
		img_show_panel = new JLabel();
		img_show_panel.setBounds(10, 10, 159, 153);
		pnl_Anh.add(img_show_panel);

		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setBackground(Color.WHITE);
		pnl_ThongTin.setBounds(245, 70, 765, 328);
		contentPane.add(pnl_ThongTin);
		pnl_ThongTin.setLayout(null);

		JPanel pnl_MaNhanVien = new JPanel();
		pnl_MaNhanVien.setBackground(Color.WHITE);
		pnl_MaNhanVien.setBounds(10, 5, 350, 25);
		pnl_ThongTin.add(pnl_MaNhanVien);
		pnl_MaNhanVien.setLayout(null);

		JLabel lbl_MaNhanVien = new JLabel("Mã nhân viên");
		lbl_MaNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_MaNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_MaNhanVien.setBounds(0, 0, 110, 25);
		pnl_MaNhanVien.add(lbl_MaNhanVien);

		txt_MaNhanVien = new JTextField();
		txt_MaNhanVien.setEditable(false);
		txt_MaNhanVien.setBounds(125, 0, 225, 25);
		pnl_MaNhanVien.add(txt_MaNhanVien);
		txt_MaNhanVien.setColumns(10);

		JPanel pnl_ChucVu = new JPanel();
		pnl_ChucVu.setBackground(Color.WHITE);
		pnl_ChucVu.setLayout(null);
		pnl_ChucVu.setBounds(405, 5, 350, 30);
		pnl_ThongTin.add(pnl_ChucVu);

		JLabel lbl_Email = new JLabel("Email");
		lbl_Email.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Email.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_Email.setBounds(0, 0, 110, 25);
		pnl_ChucVu.add(lbl_Email);

		txt_Email = new JTextField();
		txt_Email.setText((String) null);
		txt_Email.setColumns(10);
		txt_Email.setBounds(125, 1, 225, 24);
		pnl_ChucVu.add(txt_Email);

		JPanel pnl_TenNhanVien = new JPanel();
		pnl_TenNhanVien.setBackground(Color.WHITE);
		pnl_TenNhanVien.setLayout(null);
		pnl_TenNhanVien.setBounds(10, 50, 350, 25);
		pnl_ThongTin.add(pnl_TenNhanVien);

		JLabel lbl_TenNhanVien = new JLabel("Tên nhân viên");
		lbl_TenNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TenNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TenNhanVien.setBounds(0, 0, 110, 25);
		pnl_TenNhanVien.add(lbl_TenNhanVien);

		txt_TenNhanVien = new JTextField();
		txt_TenNhanVien.setColumns(10);
		txt_TenNhanVien.setBounds(125, 0, 225, 25);
		pnl_TenNhanVien.add(txt_TenNhanVien);

		JPanel pnl_NgaySinh = new JPanel();
		pnl_NgaySinh.setBackground(Color.WHITE);
		pnl_NgaySinh.setLayout(null);
		pnl_NgaySinh.setBounds(10, 95, 350, 25);
		pnl_ThongTin.add(pnl_NgaySinh);

		JLabel lbl_NgaySinh = new JLabel("Ngày sinh");
		lbl_NgaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_NgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_NgaySinh.setBounds(0, 0, 110, 25);
		pnl_NgaySinh.add(lbl_NgaySinh);

		dateCh_NgaySinh = new JDateChooser();
		dateCh_NgaySinh.setDateFormatString("yyyy-MM-dd");
		dateCh_NgaySinh.setBounds(127, 0, 223, 25);
		pnl_NgaySinh.add(dateCh_NgaySinh);

		JPanel pnl_GioiTinh = new JPanel();
		pnl_GioiTinh.setBackground(Color.WHITE);
		pnl_GioiTinh.setLayout(null);
		pnl_GioiTinh.setBounds(10, 140, 350, 25);
		pnl_ThongTin.add(pnl_GioiTinh);

		btngr_GioiTinh = new ButtonGroup();

		JLabel lbl_GioiTinh = new JLabel("Giới tính");
		lbl_GioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_GioiTinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_GioiTinh.setBounds(0, 0, 110, 25);
		pnl_GioiTinh.add(lbl_GioiTinh);

		rdbtn_Nam = new JRadioButton("Nam");
		rdbtn_Nam.setBackground(Color.WHITE);
		rdbtn_Nam.setBounds(125, 0, 50, 25);
		pnl_GioiTinh.add(rdbtn_Nam);

		rdbtn_Nu = new JRadioButton("Nữ");
		rdbtn_Nu.setBackground(Color.WHITE);
		rdbtn_Nu.setBounds(190, 0, 50, 25);
		pnl_GioiTinh.add(rdbtn_Nu);
		rdbtn_Nam.setActionCommand("Nam");
		rdbtn_Nu.setActionCommand("Nu");

		btngr_GioiTinh.add(rdbtn_Nu);
		btngr_GioiTinh.add(rdbtn_Nam);

		JPanel pnl_TrangThai = new JPanel();
		pnl_TrangThai.setBackground(Color.WHITE);
		pnl_TrangThai.setLayout(null);
		pnl_TrangThai.setBounds(10, 185, 350, 29);
		pnl_ThongTin.add(pnl_TrangThai);

		JLabel lbl_TrangThai = new JLabel("Trạng thái");
		lbl_TrangThai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_TrangThai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TrangThai.setBounds(0, 0, 110, 25);
		pnl_TrangThai.add(lbl_TrangThai);

		txt_TrangThai = new JTextField();
		txt_TrangThai.setColumns(10);
		txt_TrangThai.setBounds(120, 1, 225, 25);
		txt_TrangThai.setEditable(false);
		pnl_TrangThai.add(txt_TrangThai);

		String[] dsTrangThai = { "Chọn trạng thái", "Còn làm", "Nghỉ việc", "Nghỉ phép" };

		JPanel pnl_SoDienThoai = new JPanel();
		pnl_SoDienThoai.setBackground(Color.WHITE);
		pnl_SoDienThoai.setLayout(null);
		pnl_SoDienThoai.setBounds(405, 50, 350, 25);
		pnl_ThongTin.add(pnl_SoDienThoai);

		JLabel lbl_SoDienThoai = new JLabel("Số điện thoại");
		lbl_SoDienThoai.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_SoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_SoDienThoai.setBounds(0, 0, 110, 25);
		pnl_SoDienThoai.add(lbl_SoDienThoai);

		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setColumns(10);
		txt_SoDienThoai.setBounds(125, 0, 225, 25);
		pnl_SoDienThoai.add(txt_SoDienThoai);

		JPanel pnl_DiaChi = new JPanel();
		pnl_DiaChi.setBackground(Color.WHITE);
		pnl_DiaChi.setLayout(null);
		pnl_DiaChi.setBounds(405, 95, 350, 25);
		pnl_ThongTin.add(pnl_DiaChi);

		JLabel lbl_DiaChi = new JLabel("Địa chỉ");
		lbl_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_DiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_DiaChi.setBounds(0, 0, 110, 25);
		pnl_DiaChi.add(lbl_DiaChi);

		txt_DiaChi = new JTextField();
		txt_DiaChi.setColumns(10);
		txt_DiaChi.setBounds(125, 0, 225, 25);
		pnl_DiaChi.add(txt_DiaChi);

		JPanel pnl_CCCD = new JPanel();
		pnl_CCCD.setBackground(Color.WHITE);
		pnl_CCCD.setLayout(null);
		pnl_CCCD.setBounds(405, 140, 350, 25);
		pnl_ThongTin.add(pnl_CCCD);

		JLabel lbl_CCCD = new JLabel("Số CCCD");
		lbl_CCCD.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CCCD.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_CCCD.setBounds(0, 0, 110, 25);
		pnl_CCCD.add(lbl_CCCD);

		txt_CCCD = new JTextField();
		txt_CCCD.setColumns(10);
		txt_CCCD.setBounds(125, 0, 225, 25);
		pnl_CCCD.add(txt_CCCD);

		JLabel lbl_Password = new JLabel("Mật khẩu");
		lbl_Password.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Password.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_Password.setBounds(405, 185, 110, 25);
		pnl_ThongTin.add(lbl_Password);

		txt_Password = new JPasswordField();
		txt_Password.setBounds(526, 185, 198, 25);
		txt_Password.setEditable(false);
		pnl_ThongTin.add(txt_Password);

		JButton btn_ChonAnh = new JButton("Chọn ảnh");
		btn_ChonAnh.setIcon(new ImageIcon(JDialog_TrangCaNhan.class.getResource("/icon/upload.png")));
		btn_ChonAnh.setBounds(26, 262, 179, 32);
		contentPane.add(btn_ChonAnh);
		btn_ChonAnh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_ChonAnh.setForeground(new Color(255, 255, 255));

		btn_ChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img_show_panel.setIcon(ResizeImage(chooseFileEvent("image")));
			}

			public ImageIcon ResizeImage(String ImagePath) {
				ImageIcon MyImage = new ImageIcon(ImagePath);
				Image img = MyImage.getImage();
				Image newImg = img.getScaledInstance(img_show_panel.getWidth(), img_show_panel.getHeight(),
						Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(newImg);
				return image;
			}
		});

		btn_ChonAnh.setBackground(new Color(0, 128, 255));

		nv = new NhanVien();
		DAO_NV = new NhanVien_DAO();
		nv = DAO_NV.timNhanVien_TheoMaNhanVien(nhanvien.getMaNhanVien());

		txt_MaNhanVien.setText(nv.getMaNhanVien());
		txt_TenNhanVien.setText(nv.getHoTen());

		try {
			dateCh_NgaySinh.setDate(nv.getNgaySinh());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (nv.isGioiTinh()) {
			rdbtn_Nam.setSelected(true);
		} else {
			rdbtn_Nu.setSelected(true);
		}

		DAO_LNV = new LoaiNhanVien_DAO();
		LoaiNhanVien LNV = new LoaiNhanVien();
		LNV = DAO_LNV.layLoaiNhanVien_TheoMaLoaiNhanVien(nv.getloaiNhanVien().getMaLoaiNhanVien());

		TK = new TaiKhoan();
		DAO_TK = new TaiKhoan_DAO();

		TK = DAO_TK.timTaiKhoan_TheoMaNhanVien(nv.getMaNhanVien());

		txt_TrangThai.setText(nv.getTrangThai());
		txt_SoDienThoai.setText(nv.getSoDienThoai());
		txt_DiaChi.setText(nv.getDiaChi());
		txt_CCCD.setText(nv.getCCCD());
		txt_Email.setText(TK.getEmail().trim());

		TK = DAO_TK.timTaiKhoan_TheoMaNhanVien(nv.getMaNhanVien());
		txt_Password.setText(TK.getMatKhau().trim());

		cboShowPassword = new JCheckBox("");
		cboShowPassword.setBackground(new Color(255, 255, 255));
		cboShowPassword.setBounds(730, 185, 29, 25);
		pnl_ThongTin.add(cboShowPassword);

		btn_Them = new JButton("Lưu");
		btn_Them.setIcon(new ImageIcon(JDialog_TrangCaNhan.class.getResource("/icon/save_16px.png")));
		btn_Them.setBounds(526, 288, 110, 30);
		pnl_ThongTin.add(btn_Them);
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_Them.setBackground(Color.decode(hexColor_Orange));

		btn_BoQua = new JButton("Bỏ qua");
		btn_BoQua.setIcon(new ImageIcon(JDialog_TrangCaNhan.class.getResource("/icon/exit_16px.png")));
		btn_BoQua.setBounds(645, 288, 110, 30);
		pnl_ThongTin.add(btn_BoQua);
		btn_BoQua.setForeground(Color.WHITE);
		btn_BoQua.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_BoQua.setBackground(Color.decode(hexColor_Blue2));

		txt_chucVu = new JTextField();
		txt_chucVu.setBounds(130, 239, 225, 25);
		pnl_ThongTin.add(txt_chucVu);
		txt_chucVu.setColumns(10);
		txt_chucVu.setEditable(false);
		txt_chucVu.setText(LNV.getTenLoaiNhanVien());

		JLabel lbl_ChucVu = new JLabel("Chức vụ");
		lbl_ChucVu.setBounds(10, 238, 110, 25);
		pnl_ThongTin.add(lbl_ChucVu);
		lbl_ChucVu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ChucVu.setFont(new Font("Segoe UI", Font.BOLD, 13));

		btn_ChangePwd = new JButton("Đổi mật khẩu");
		btn_ChangePwd.setForeground(Color.WHITE);
		btn_ChangePwd.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_ChangePwd.setBackground(Color.decode(hexColor_Green));
		btn_ChangePwd.setBounds(618, 220, 137, 30);
		pnl_ThongTin.add(btn_ChangePwd);

		JLabel lbl_CaLam = new JLabel("Ca làm");
		lbl_CaLam.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_CaLam.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_CaLam.setBounds(10, 277, 110, 25);
		pnl_ThongTin.add(lbl_CaLam);

		txt_Calam = new JTextField();
		txt_Calam.setText((String) null);
		txt_Calam.setEditable(false);
		txt_Calam.setColumns(10);
		txt_Calam.setBounds(130, 278, 96, 25);
		pnl_ThongTin.add(txt_Calam);
		btn_BoQua.addActionListener(this);

		btn_Them.addActionListener(this);

		nv = DAO_NV.timNhanVien_TheoMaNhanVien(nhanvien.getMaNhanVien());
		ImageIcon originalIcon = new ImageIcon(JDialog_CapNhatDichVu.class.getResource("/img/" + nv.getAnhThe()));
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(159, 176, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);

		LocalTime currentTime = LocalTime.now();
		int hour = currentTime.getHour();

		if (hour >= 7 && hour <= 11) {
			txt_Calam.setText("Ca 1");
		} else if (hour >= 12 && hour <= 16) {
			txt_Calam.setText("Ca 2");

		} else if (hour >= 17 && hour <= 22) {
			txt_Calam.setText("Ca 3");

		} else {
			txt_Calam.setText("Ca 4");
		}

		img_show_panel.setIcon(resizedIcon);
		cboShowPassword.addItemListener(this);
		btn_ChangePwd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_Them)) {
			if (ValueDate()) {
				CapNhatNhanVien();
				JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thành công.");
			}
		}

		if (o.equals(btn_BoQua)) {
			dispose();
		}

		if (o.equals(btn_ChangePwd)) {
			TK = DAO_TK.timKiemTaiKhoan(txt_MaNhanVien.getText().trim());
			JFrame_DoiMatKhau doiMatKhau = new JFrame_DoiMatKhau(TK);
			doiMatKhau.setVisible(true);
		}
	}

	public boolean ValueDate() {
		String tenNV = txt_TenNhanVien.getText().trim();
		boolean gt_Nam = rdbtn_Nam.isSelected();
		boolean gt_Nu = rdbtn_Nu.isSelected();
		String soDienThoai = txt_SoDienThoai.getText().trim();
		String diaChi = txt_DiaChi.getText().trim();
		String cccd = txt_CCCD.getText().trim();
		String email = txt_Email.getText().trim();

		if (txt_TenNhanVien.equals("")) {
			txt_TenNhanVien.requestFocus();
			JOptionPane.showMessageDialog(null, "Tên nhân viên không được rỗng");
			return false;
		} else if (!(tenNV.length() > 0
				&& tenNV.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\\r\\n\"\r\n"
						+ "					+ \"fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\\r\\n\"\r\n"
						+ "					+ \"UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+"))) {
			System.out.println(tenNV);
			JOptionPane.showMessageDialog(null, "Tên nhân viên không hợp lệ");
			txt_TenNhanVien.requestFocus();
			return false;
		}

		try {
			Date ngaySinh = new Date(dateCh_NgaySinh.getDate().getTime());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -18);
			java.util.Date chkNgaySinh = new java.util.Date(cal.getTimeInMillis());
			if (!(ngaySinh.before(chkNgaySinh))) {
				JOptionPane.showMessageDialog(null, "Nhân viên này chưa đủ 18 tuổi!");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
		}

		if (!gt_Nam && !gt_Nu) {
			JOptionPane.showMessageDialog(null, "Giới tính chưa được chọn!");
			return false;
		}

		if (soDienThoai.equals("")) {
			txt_SoDienThoai.requestFocus();
			JOptionPane.showMessageDialog(null, "Số điện thoại không được rỗng");
			return false;
		} else if (!(soDienThoai.length() > 0 && soDienThoai.matches("^(\\+84|0)(3|9|5|7|8)\\d{8}$"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			txt_SoDienThoai.requestFocus();
			return false;
		}

		if (diaChi.equals("")) {
			txt_DiaChi.requestFocus();
			JOptionPane.showMessageDialog(null, "Địa chỉ không được rỗng");
			return false;
		} else if (!(diaChi.length() > 0 && diaChi.matches("[\\p{L}0-9,.'_ ]+"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ");
			txt_DiaChi.requestFocus();
			return false;
		}

		if (cccd.equals("")) {
			txt_CCCD.requestFocus();
			JOptionPane.showMessageDialog(null, "Căn cước công dân không được rỗng");
			return false;
		} else if (!(cccd.length() > 0 && cccd.matches("^(([0-9]{9})|([0-9]{12}))$"))) {
			JOptionPane.showMessageDialog(null, "CCCD / CMND không hợp lệ");
			txt_CCCD.requestFocus();
			return false;
		}

		if (email.equals("")) {
			txt_Email.requestFocus();
			JOptionPane.showMessageDialog(null, "Email không được rỗng");
			return false;
		} else if (!(email.length() > 0 && email.matches("^\\S+@\\S+\\.\\S+$"))) {
			JOptionPane.showMessageDialog(null, "Email không hợp lệ");
			txt_Email.requestFocus();
			return false;
		}
		return true;
	}

	public void CapNhatNhanVien() {
		if (ValueDate()) {

			String anhThe;
			if (pathImg != null) {
				File file = new File(pathImg);
				String fileName = file.getName();
				anhThe = fileName;
			} else {
				anhThe = "noImage.jpg";
			}

			String CCCD = txt_CCCD.getText();
			String diaChi = txt_DiaChi.getText();
			boolean gioiTinh = btngr_GioiTinh.getSelection().getActionCommand().equals("Nam");
			String hoTen = txt_TenNhanVien.getText();
			Date ngaySinh = null;
			try {
				ngaySinh = new Date((dateCh_NgaySinh).getDate().getTime());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
			}

			String soDienThoai = txt_SoDienThoai.getText();
			String trangThai = txt_TrangThai.getText();
			String maNhanVien = txt_MaNhanVien.getText().trim();

			LoaiNhanVien loaiNhanVien = null;
			String loaiNV = txt_chucVu.getText();

			loaiNhanVien = DAO_LNV.layLoaiNhanVien_TheoTenLoaiNhanVien(loaiNV);
			NhanVien nv = new NhanVien(maNhanVien, loaiNhanVien, hoTen, gioiTinh, ngaySinh, soDienThoai, CCCD, diaChi,
					trangThai, anhThe);

			String email = txt_Email.getText().trim();
			TaiKhoan TK = new TaiKhoan();
			TaiKhoan_DAO DAO_TK = new TaiKhoan_DAO();
			TK = DAO_TK.capNhatEmail_TheoMaNhanVien(hoTen, maNhanVien, email);

			try {
				NhanVien_DAO DAO_NV = new NhanVien_DAO();
				if (DAO_NV.capNhatNhanVien(nv)) {
					JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công");
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin nhân viên thất bại. Vui lòng thử lại");
				}

			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showConfirmDialog(null, "Cập nhật thông tin nhân viên thất bại, vui lòng thử lại");
				e2.printStackTrace();
			}
		}
	}

	public String chooseFileEvent(String typeFile) {
		JFileChooser file = new JFileChooser();
		String path = "";
		file.setCurrentDirectory(new File("src/img"));

		FileNameExtensionFilter filterImage = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png", "xlsx",
				"xls");
		FileNameExtensionFilter filterExcel = new FileNameExtensionFilter("xlsx", "xls");

		// Doc path image
		if (typeFile.equals("image")) {
			file.addChoosableFileFilter(filterImage);
		}
		// Doc path excel
		else if (typeFile.equals("excel")) {
			file.addChoosableFileFilter(filterExcel);
		}

		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {

			File selectedFile = file.getSelectedFile();
			path = selectedFile.getAbsolutePath();
			pathImg += path;
			return path;
		}

		else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("Không tìm thấy file tải lên");
			JOptionPane.showMessageDialog(null, "Không tìm thấy file tải lên");
		}
		return path;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			txt_Password.setEchoChar(cboShowPassword.isSelected() ? '\u0000' : '*');
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			char echoChar = cboShowPassword.isSelected() ? '\u0000' : '*';
			txt_Password.setEchoChar(echoChar);
		}
	}
}