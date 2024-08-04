package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.json.ParseException;
import com.toedter.calendar.JDateChooser;

import dao.KhachHang_DAO;
import entity.KhachHang;
import other.HelpRamDomKH;
import other.HelpValidate;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class JDialog_ThemKhachHang extends JFrame implements ActionListener {

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

	private JPanel contentPane;
	private JTextField txt__MaKH;
	private JTextField txt__TenKH;
	private JTextField txt__DiaChi;
	private JLabel lbl__TenKH;
	private ButtonGroup btngr__gioiTinh;
	private JTextField txt__SDT;

	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private JButton btn__exit;
	private JButton btn__Save;
	private JTextArea txtA__GhiChu;
	private JDateChooser date_NgaySinh;

	private HelpValidate help;
	private KhachHang_DAO DAO_KH;
	private JRadioButton rdbt__nu;
	private JRadioButton rdbt__nam;
	private Calendar cal = Calendar.getInstance();

	public JDialog_ThemKhachHang() {

		DAO_KH = new KhachHang_DAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 336);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(5, 0, 926, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/****/
		btngr__gioiTinh = new ButtonGroup();
		//
		JLabel lbl__NgaySinh = new JLabel("Ngày Sinh");
		lbl__NgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__NgaySinh.setBounds(43, 150, 96, 25);
		panel_1.add(lbl__NgaySinh);

		JLabel lbl__gioiTinh = new JLabel("Giới Tính");
		lbl__gioiTinh.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__gioiTinh.setBounds(43, 200, 70, 27);
		panel_1.add(lbl__gioiTinh);

		lbl__TenKH = new JLabel("Tên Khách Hàng");
		lbl__TenKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__TenKH.setBounds(43, 110, 119, 25);
		panel_1.add(lbl__TenKH);

		txt__MaKH = new JTextField();

		txt__MaKH.setEditable(false);
		txt__MaKH.setBounds(172, 70, 255, 25);
		panel_1.add(txt__MaKH);
		txt__MaKH.setColumns(10);

		txt__TenKH = new JTextField();
		txt__TenKH.setBounds(172, 110, 255, 25);
		panel_1.add(txt__TenKH);
		txt__TenKH.setColumns(50);

		JLabel lbl__MaKH = new JLabel("Mã Khách Hàng");
		lbl__MaKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__MaKH.setBounds(43, 70, 119, 25);
		panel_1.add(lbl__MaKH);

		txt__SDT = new JTextField();
		txt__SDT.setBounds(604, 70, 255, 25);
		panel_1.add(txt__SDT);
		btn__exit = new JButton("Thoát");
		btn__exit.setIcon(new ImageIcon(JDialog_ThemKhachHang.class.getResource("/icon/exit_16px.png")));
		btn__exit.setForeground(new Color(255, 255, 255));
		btn__exit.setBackground(Color.decode(hexColor_Blue2));
		btn__exit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__exit.setBounds(749, 246, 110, 30);
		panel_1.add(btn__exit);

		JLabel lbl__GhiChu = new JLabel("Ghi Chú");
		lbl__GhiChu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__GhiChu.setBounds(493, 150, 60, 25);
		panel_1.add(lbl__GhiChu);

		btn__Save = new JButton("Lưu");
		btn__Save.setIcon(new ImageIcon(JDialog_ThemKhachHang.class.getResource("/icon/save_16px.png")));
		btn__Save.setForeground(new Color(255, 255, 255));
		btn__Save.setBackground(Color.decode(hexColor_Green));
		btn__Save.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__Save.setBounds(629, 246, 110, 30);
		panel_1.add(btn__Save);

		JLabel lbl__DiaChi = new JLabel("Địa Chỉ");
		lbl__DiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__DiaChi.setBounds(493, 110, 49, 25);
		panel_1.add(lbl__DiaChi);

		JLabel lbl__SDT = new JLabel("Số Điện Thoại");
		lbl__SDT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl__SDT.setBounds(490, 70, 109, 25);
		panel_1.add(lbl__SDT);

		rdbt__nu = new JRadioButton("Nữ");
		rdbt__nu.setBackground(new Color(255, 255, 255));
		rdbt__nu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbt__nu.setBounds(265, 200, 70, 27);
		panel_1.add(rdbt__nu);
		btngr__gioiTinh.add(rdbt__nu);

		rdbt__nam = new JRadioButton("Nam");
		rdbt__nam.setSize(70, 27);
		rdbt__nam.setLocation(172, 200);
		rdbt__nam.setBackground(new Color(255, 255, 255));
		rdbt__nam.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		panel_1.add(rdbt__nam);
		btngr__gioiTinh.add(rdbt__nam);

		rdbt__nam.setActionCommand("Nam");
		rdbt__nu.setActionCommand("Nu");

		JLabel lbl__tieuDe = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lbl__tieuDe.setForeground(Color.decode(hexColor_Blue1));
		;
		lbl__tieuDe.setBounds(22, 11, 849, 39);
		panel_1.add(lbl__tieuDe);
		lbl__tieuDe.setFont(new Font("Segoe UI", Font.BOLD, 17));

		date_NgaySinh = new JDateChooser();
		date_NgaySinh.setDateFormatString("yyyy-MM-dd");
		date_NgaySinh.setBounds(172, 150, 255, 25);
		panel_1.add(date_NgaySinh);

		JPanel pnl_GhiChu = new JPanel();
		pnl_GhiChu.setBackground(new Color(255, 255, 255));
		pnl_GhiChu.setBorder(new LineBorder(new Color(192, 192, 192)));
		pnl_GhiChu.setBounds(604, 150, 257, 68);
		panel_1.add(pnl_GhiChu);
		pnl_GhiChu.setLayout(null);

		txtA__GhiChu = new JTextArea();
		txtA__GhiChu.setForeground(new Color(0, 0, 0));
		txtA__GhiChu.setBounds(1, 1, 255, 63);
		pnl_GhiChu.add(txtA__GhiChu);

		txt__DiaChi = new JTextField();
		txt__DiaChi.setBounds(604, 110, 255, 25);
		panel_1.add(txt__DiaChi);

//---------------------------

		btn__Save.addActionListener(this);
		btn__exit.addActionListener(this);

	}

	public void setModal_ThemKhachHang(String maKH, String tenKH, String gioiTinh, String ngaySinh, String soDienThoai,
			String diaChi, String ghiChu) {
		txt__MaKH.setText(maKH);
		txt__TenKH.setText(tenKH);
		txt__SDT.setText(soDienThoai);
		txt__DiaChi.setText(diaChi);
		java.util.Date ngaySinhStr;
		try {
			ngaySinhStr = dateFormat_YMD.parse(ngaySinh);
			date_NgaySinh.setDate(ngaySinhStr);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		txtA__GhiChu.setText(ghiChu);
		if (gioiTinh.equals("Nam")) {
			rdbt__nam.setSelected(true);
		} else {
			rdbt__nu.setSelected(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();

		if (o.equals(btn__Save)) {
			if (txt__MaKH.getText().equals("")) {
				themKhachHang();
			} else {
				capNhatKhachHang();
			}
		}

		if (o.equals(btn__exit)) {
			setVisible(false);
		}

	}

	public void themKhachHang() {
		if (ValueDate()) {
			String tenKhachHang = txt__TenKH.getText();
			String diaChi = txt__DiaChi.getText();
			String sdt = txt__SDT.getText();
			java.sql.Date ngaySinh = new Date((date_NgaySinh).getDate().getTime());
//			Date dt = (Date) cal.getTime();
			String ghiChu = txtA__GhiChu.getText();
			HelpRamDomKH helpRamDomKH = new HelpRamDomKH(txt__SDT.getText());
			String maKhachHang = helpRamDomKH.taoMa("KhachHang", "maKhachHang", "KH");
			int diemThuong = 0;
			boolean gioiTinh = btngr__gioiTinh.getSelection().getActionCommand().equals("Nam");
			KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, diaChi, sdt, diemThuong,
					ghiChu);
			if (DAO_KH.layKhachHang_TheoMaKhachHang(maKhachHang) == null) {
				try {
					DAO_KH.taoKhachHang(kh);
					txt__MaKH.setText(maKhachHang);
					JOptionPane.showMessageDialog(null, "Thêm khách hàng " + tenKhachHang + " thành công!");
					setVisible(false);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Không thể thêm khách hàng!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Khách hàng " + tenKhachHang + " đã tồn tại!");

			}
		}
	}

	public void capNhatKhachHang() {
		if (ValueDate()) {
			String tenKhachHang = txt__TenKH.getText();
			String diaChi = txt__DiaChi.getText();
			String sdt = txt__SDT.getText();
			java.sql.Date ngaySinh = new Date((date_NgaySinh).getDate().getTime());
			String ghiChu = txtA__GhiChu.getText();
			String maKhachHang = txt__MaKH.getText();
			int diemThuong = 0;
			boolean gioiTinh = btngr__gioiTinh.getSelection().getActionCommand().equals("Nam");
			KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, diaChi, sdt, diemThuong,
					ghiChu);
			int result = JOptionPane.showConfirmDialog(this,
					"Bạn có chắc chắn muốn cập nhật khách hàng " + tenKhachHang + "?", "Xác nhận",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				if (DAO_KH.capNhatKhachHang(kh)) {
					try {
						DAO_KH.capNhatKhachHang(kh);
						JOptionPane.showMessageDialog(null, "Cập nhật khách hàng " + tenKhachHang + " thành công!");
						setVisible(false);
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Không thể cập nhật khách hàng!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Khách hàng " + tenKhachHang + " không đã tồn tại!");
				}
			}
		}
	}

	public boolean ValueDate() {
		String tenKH = txt__TenKH.getText().trim();
		String soDienThoai = txt__SDT.getText().trim();
		String diaChi = txt__DiaChi.getText().trim();
		boolean gt_Nam = rdbt__nam.isSelected();
		boolean gt_Nu = rdbt__nu.isSelected();

		if (txt__TenKH.equals("")) {
			txt__TenKH.requestFocus();
			JOptionPane.showMessageDialog(null, "Tên nhân viên không được rỗng");
			return false;
		} else if (!(tenKH.matches(
				"^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*"))) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không hợp lệ");
			txt__TenKH.requestFocus();
			return false;
		}

		try {
			Date ngaySinh = new Date(date_NgaySinh.getDate().getTime());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -16);
			java.util.Date chkNgaySinh = new java.util.Date(cal.getTimeInMillis());
			if (!(ngaySinh.before(chkNgaySinh))) {
				JOptionPane.showMessageDialog(null, "Khách hàng này chưa đủ 16 tuổi!");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
			return false;
		}

		if (!gt_Nam && !gt_Nu) {
			JOptionPane.showMessageDialog(null, "Giới tính chưa được chọn!");
			return false;
		}

		if (soDienThoai.equals("")) {
			txt__SDT.requestFocus();
			JOptionPane.showMessageDialog(null, "Số điện thoại không được rỗng");
			return false;
		} else if (!(soDienThoai.matches("^(\\+84|0)(3|9|5|7|8)\\d{8}$"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			txt__SDT.requestFocus();
			return false;
		}

//		if (!(diaChi.matches("[\\p{L}0-9,.'_ ]+"))) {
//			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ");
//			txt__DiaChi.requestFocus();
//			return false;
//		}
		return true;
	}
}