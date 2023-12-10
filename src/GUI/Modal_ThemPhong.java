package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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
import java.util.Collection;
import java.util.regex.Pattern;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

import com.ctc.wstx.shaded.msv_core.verifier.identity.Matcher;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JScrollPane;
import java.awt.Choice;
import javax.swing.JScrollBar;
import com.toedter.components.JSpinField;

import DAO.LoaiPhong_DAO;
import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.LoaiPhong;
import Entity.Phong;
import Entity.TrangThaiPhong;
import OtherFunction.HelpRamDomMaPhong;

import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class Modal_ThemPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txt__MaPhong;
	private JLabel lbl__TenPhong;
	private JDateChooser date_NgayTaoPhong;
	private JLabel img_show_panel;
	private String pathImg = "";
	private Phong_DAO DAO_P = new Phong_DAO();
	private LoaiPhong_DAO DAO_LP = new LoaiPhong_DAO();
	private TrangThaiPhong_DAO DAO_TTP = new TrangThaiPhong_DAO();
	private JTextField txt_TenPhong;
	private JTextArea txtA_GhiChu;
	private ArrayList<LoaiPhong> listLP;
	private JComboBox<String> cbBox_LoaiPhong;
	private JComboBox<String> cbBox_TrangThaiPhong;
	private ArrayList<TrangThaiPhong> listTTP;
	private SimpleDateFormat dateFormat_YMD = new SimpleDateFormat("yyyy-MM-dd");
	private JButton btn__Save;
	private JComboBox<String> cbBox_viTriPhong;
	
	private String tinhTrang;
	
	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	
	public Modal_ThemPhong() {
		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Modal_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setBounds(100, 100, 926, 347);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 912, 310);
		contentPane.add(panel_1);

		/****/
		panel_1.setLayout(null);
		//
		JLabel lbl__LoaiPhong = new JLabel("Loại phòng");
		lbl__LoaiPhong.setBounds(43, 130, 96, 25);
		lbl__LoaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panel_1.add(lbl__LoaiPhong);

		lbl__TenPhong = new JLabel("Tên phòng");
		lbl__TenPhong.setBounds(43, 90, 119, 25);
		lbl__TenPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panel_1.add(lbl__TenPhong);

		txt__MaPhong = new JTextField();
		txt__MaPhong.setEnabled(false);
		txt__MaPhong.setBounds(172, 50, 255, 25);
		panel_1.add(txt__MaPhong);
		txt__MaPhong.setColumns(10);

		JLabel lbl__MaPhong = new JLabel("Mã phòng");
		lbl__MaPhong.setBounds(43, 50, 119, 25);
		lbl__MaPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panel_1.add(lbl__MaPhong);

		JButton btn__exit = new JButton("Thoát");
		btn__exit.setBackground(Color.decode(hexColor_Blue2));
		btn__exit.setIcon(new ImageIcon(Modal_ThemPhong.class.getResource("/icon/exit_16px.png")));
		btn__exit.setForeground(new Color(255, 255, 255));
		btn__exit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__exit.setBounds(766, 252, 110, 30);
		panel_1.add(btn__exit);

		btn__exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JLabel lbl__GhiChu = new JLabel("Ghi chú");
		lbl__GhiChu.setBounds(503, 130, 60, 25);
		lbl__GhiChu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panel_1.add(lbl__GhiChu);

		btn__Save = new JButton("Lưu");
		btn__Save.setBackground(Color.decode(hexColor_Orange));
		btn__Save.setIcon(new ImageIcon(Modal_ThemPhong.class.getResource("/icon/save_16px.png")));
		btn__Save.setForeground(new Color(255, 255, 255));
		btn__Save.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn__Save.setBounds(646, 252, 110, 30);
		panel_1.add(btn__Save);

		btn__Save.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
//				 TODO Auto-generated method stub
				
				if(txt__MaPhong.getText().equals("")) {
					themPhong();
				}else {
					capNhatPhong();
				}
			}
			
			
			
		});

		JLabel lbl_NgayTaoPhong = new JLabel("Ngày tạo phòng");
		lbl_NgayTaoPhong.setBounds(493, 90, 105, 25);
		lbl_NgayTaoPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panel_1.add(lbl_NgayTaoPhong);

		JLabel lbl_ViTriPhong = new JLabel("Vị trí phòng");
		lbl_ViTriPhong.setBounds(493, 50, 109, 25);
		lbl_ViTriPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panel_1.add(lbl_ViTriPhong);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(641, 42, 0, 0);
		panel_1.add(verticalBox_1);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_4);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_6);

		JLabel lbl__tieuDe = new JLabel("THÔNG TIN PHÒNG");
		lbl__tieuDe.setForeground(Color.decode(hexColor_Blue1));
		lbl__tieuDe.setBounds(22, 11, 828, 39);
		panel_1.add(lbl__tieuDe);
		lbl__tieuDe.setFont(new Font("Segoe UI", Font.BOLD, 16));

		date_NgayTaoPhong = new JDateChooser();
		date_NgayTaoPhong.setBounds(621, 90, 255, 25);
		date_NgayTaoPhong.setEnabled(false);
		
//		Date today = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(today);
        date_NgayTaoPhong.setDate(new java.util.Date());
		panel_1.add(date_NgayTaoPhong);
		

		JPanel pnl_GhiChu = new JPanel();
		pnl_GhiChu.setBackground(new Color(255, 255, 255));
		pnl_GhiChu.setBorder(new LineBorder(new Color(192, 192, 192)));
		pnl_GhiChu.setBounds(621, 130, 255, 103);
		panel_1.add(pnl_GhiChu);
		pnl_GhiChu.setLayout(null);

		txt_TenPhong = new JTextField();
		txt_TenPhong.setColumns(10);
		txt_TenPhong.setBounds(172, 90, 255, 25);
		txt_TenPhong.setEditable(false);
		panel_1.add(txt_TenPhong);

		JLabel lbl_TrangThaiPhong = new JLabel("Trạng thái phòng");
		lbl_TrangThaiPhong.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_TrangThaiPhong.setBounds(43, 170, 119, 27);
		panel_1.add(lbl_TrangThaiPhong);

		cbBox_TrangThaiPhong = new JComboBox<String>();
		cbBox_TrangThaiPhong.setBackground(Color.WHITE);
		cbBox_TrangThaiPhong.setBounds(172, 170, 255, 25);
		panel_1.add(cbBox_TrangThaiPhong);
		DAO_TTP = new TrangThaiPhong_DAO();
		try {
			listTTP = DAO_TTP.layTatCaTrangThaiPhong();
			if (listTTP != null) {
				listTTP.forEach((loaiTTP) -> {
					cbBox_TrangThaiPhong.addItem(loaiTTP.getTenTrangThai().trim());
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		cbBox_LoaiPhong = new JComboBox<String>();
		cbBox_LoaiPhong.setBackground(Color.WHITE);
		cbBox_LoaiPhong.setBounds(172, 130, 255, 25);
		panel_1.add(cbBox_LoaiPhong);
		
		cbBox_viTriPhong = new JComboBox<String>();
		cbBox_viTriPhong.setBackground(Color.WHITE);
		cbBox_viTriPhong.setBounds(621, 50, 255, 25);
		cbBox_viTriPhong.addItem("Lầu 1");
		cbBox_viTriPhong.addItem("Lầu 2");
		cbBox_viTriPhong.addItem("Lầu 3");
		cbBox_viTriPhong.addItem("Lầu 4");
		cbBox_viTriPhong.addItem("Lầu 5");
		panel_1.add(cbBox_viTriPhong);
		
				txtA_GhiChu = new JTextArea();
				txtA_GhiChu.setBounds(631, 142, 232, 80);
				panel_1.add(txtA_GhiChu);
				txtA_GhiChu.setBackground(new Color(255, 255, 255));
				txtA_GhiChu.setLineWrap(true);

		DAO_LP = new LoaiPhong_DAO();
		try {
			listLP = DAO_LP.layTatCaLoaiPhong();
			if (listLP != null) {
				listLP.forEach((loaiP) -> {
					cbBox_LoaiPhong.addItem(loaiP.getTenLoaiPhong().trim());
				});
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void setModal_ThemPhong(String maPhong, String tenPhong, String loaiPhong, String trangThai,String tinhTrang, String viTri, String ngayTao, String ghiChu) {
		txt__MaPhong.setText(maPhong);
		txt_TenPhong.setText(tenPhong);
		cbBox_LoaiPhong.setSelectedItem(loaiPhong);
		cbBox_TrangThaiPhong.setSelectedItem(trangThai);
//		txt_ViTriPhong.setText(viTri);
		txtA_GhiChu.setText(ghiChu);
			
		java.util.Date ngayTaotr;
		try {
			ngayTaotr = dateFormat_YMD.parse(ngayTao);
			date_NgayTaoPhong.setDate(ngayTaotr);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		
		cbBox_viTriPhong.setEditable(false);
		cbBox_viTriPhong.setEnabled(false);
		cbBox_viTriPhong.setSelectedItem(viTri.trim());
		
		date_NgayTaoPhong.setEnabled(false);
		
	}
	
	public void themPhong() {
		String maPhong = txt__MaPhong.getText();
		String tenPhong = txt_TenPhong.getText();
		java.sql.Date ngayTaoPhong = new java.sql.Date(date_NgayTaoPhong.getDate().getTime());
		String viTriPhong = cbBox_viTriPhong.getSelectedItem().toString();
		String ghiChu = txtA_GhiChu.getText().trim();
		
		Pattern pattern = Pattern.compile("\\d+");
	    java.util.regex.Matcher matcher = pattern.matcher(viTriPhong);

	    StringBuilder result = new StringBuilder();
	       while (matcher.find()) {
	            result.setLength(0); // Xóa nội dung trước đó
	            result.append(matcher.group());
	       }

//	      --------
	    maPhong = HelpRamDomMaPhong.taoMa(String.valueOf(result));
	    tenPhong = maPhong;

		LoaiPhong lp = null;
		TrangThaiPhong ttp = null;

		if (DAO_P.timPhong_TheoMaLoaiPhong(maPhong) != null) {
			JOptionPane.showMessageDialog(null, "Phòng này đã tồn tại.");
		}

		try {
			// Lay LoaiPhong
			lp = DAO_LP.layLoaiPhong_TheoTenLoaiPhong(cbBox_LoaiPhong.getSelectedItem().toString());
			if (lp == null) {
				JOptionPane.showMessageDialog(null, "Tạo phòng thất bại, vui lòng thử lại.");
				return;
			}

			// Lay Trangthaiphong
			ttp = DAO_TTP.timTrangThaiPhong_TheoTenTrangThai(cbBox_TrangThaiPhong.getSelectedItem().toString());
			if (ttp == null) {
				JOptionPane.showMessageDialog(null, "Tạo phòng thất bại, vui lòng thử lại.");
				return;
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Tạo phòng thất bại, vui lòng thử lại.");
		}

		if(!ttp.getMaTrangThai().trim().equals("OOO")) {
			tinhTrang = "Đang hoạt động";
		} else {
			tinhTrang = "Sửa chữa";
		}
		
		Phong phong = new Phong(maPhong, tenPhong, lp, ttp, ngayTaoPhong, viTriPhong, ghiChu, tinhTrang);

		try {
			if (DAO_P.taoPhong(phong)) {
				
				JOptionPane.showMessageDialog(null, "Tạo phòng mới thành công!");
				setVisible(false);
			} else {
				
				JOptionPane.showMessageDialog(null, "Tạo phòng thất bại, vui lòng thử lại.");
				return;
			}

		} catch (Exception e2) {

			e2.printStackTrace();
		}
	}
	
	public void capNhatPhong() {
		String maPhong = txt__MaPhong.getText();
		String tenPhong = txt_TenPhong.getText();
		java.sql.Date ngayTaoPhong = new java.sql.Date(date_NgayTaoPhong.getDate().getTime());
		String viTriPhong = cbBox_viTriPhong.getSelectedItem().toString();
		String ghiChu = txtA_GhiChu.getText().trim();
//		String tinhTrangPhong = cbBox_TrangThaiPhong.getSelectedItem().toString();
		
		LoaiPhong lp = null;
		TrangThaiPhong ttp = null;

		if (DAO_P.timPhong_TheoMaLoaiPhong(maPhong) != null) {
			JOptionPane.showMessageDialog(null, "Phòng này đã tồn tại.");
		}

		try {
			// Lay LoaiPhong
			lp = DAO_LP.layLoaiPhong_TheoTenLoaiPhong(cbBox_LoaiPhong.getSelectedItem().toString());
			if (lp == null) {
				JOptionPane.showMessageDialog(null, "Cập nhật phòng thất bại, vui lòng thử lại.");
				return;
			}

			// Lay Trangthaiphong
			ttp = DAO_TTP.timTrangThaiPhong_TheoTenTrangThai(cbBox_TrangThaiPhong.getSelectedItem().toString());
			if (ttp == null) {
				JOptionPane.showMessageDialog(null, "Cập nhật phòng thất bại, vui lòng thử lại.");
				return;
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cập nhật phòng thất bại, vui lòng thử lại.");
		}

		if(!ttp.getMaTrangThai().trim().equals("OOO")) {
			tinhTrang = "Đang hoạt động";
		} else {
			tinhTrang = "Sửa chữa";
		}
		Phong phong = new Phong(maPhong, tenPhong, lp, ttp, ngayTaoPhong, viTriPhong, ghiChu, tinhTrang);

		try {
			if (DAO_P.capNhatPhong(phong)) {
				JOptionPane.showMessageDialog(null, "Cập nhật phòng thành công!");
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Cập nhật phòng thất bại, vui lòng thử lại.");
				return;
			}
		} catch (Exception e2) {

			e2.printStackTrace();
		}
	}
}