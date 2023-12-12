package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietDichVu_DAO;
import dao.DichVu_DAO;
import dao.Phong_DAO;
import dao.ThongTinDichVu_DAO;
import entity.ChiTietDichVu;
import entity.DichVu;
import entity.HoaDon;
import entity.Phong;
import entity.ThongTinDichVu;

public class JDialog_CapNhatSoLuongDVThanhToan extends JFrame implements ActionListener {

	private double donGiaDV;

	private int soLuong;
	private int colSelected;
	private int rowSelected;
	private int soLuongBanDau;
	private DichVu_DAO DAO_DV;
	private DichVu dv;
	private final DecimalFormat dcf = new DecimalFormat("#,##0 VND");
	private JPanel contentPane;
	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";
	private String hexColor_Orange = "#F17300";
	private String hexColor_Red = "#E11F1F";
	private String hexColor_Green = "#4BAC4D";
	private JButton btn_saveTT;
	private JButton btn_giamTT;
	private JButton btn_tangTT;

	private HoaDon hoaDonTT = null;
	private Phong phongTT = null;
	private JTable table_datDichVu;
	private JTextField txt_soLuong;

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getSoLuongBanDau() {
		return soLuongBanDau;
	}

	public void setSoLuongBanDau(int soLuongBanDau) {
		this.soLuongBanDau = soLuongBanDau;
	}

	public JTable getTable_datDichVu() {
		return table_datDichVu;
	}

	public void setTable_datDichVu(JTable table_datDichVu) {
		this.table_datDichVu = table_datDichVu;
	}

	public double getDonGiaDV() {
		return donGiaDV;
	}

	public void setDonGiaDV(double donGiaDV) {
		this.donGiaDV = donGiaDV;
	}

	public HoaDon getHoaDonTT() {
		return hoaDonTT;
	}

	public void setHoaDonTT(HoaDon hoaDonTT) {
		this.hoaDonTT = hoaDonTT;
	}

	public Phong getPhongTT() {
		return phongTT;
	}

	public void setPhongTT(Phong phongTT) {
		this.phongTT = phongTT;
	}

	public JDialog_CapNhatSoLuongDVThanhToan(JTable table_datDichVu, int soLuong, int colSelected, int rowSelected,
			HoaDon hd) {

		setHoaDonTT(hd);
		try {
			Phong_DAO DAO_P = new Phong_DAO();
			String maP = table_datDichVu.getValueAt(rowSelected, 1).toString();
			DAO_P = new Phong_DAO();
			Phong ph = DAO_P.timPhong_TheoMaPhong(maP);
			setPhongTT(ph);

		} catch (Exception e) {
			// TODO: handle exception
		}
		;

		setFont(new Font("Segoe UI", Font.PLAIN, 13));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(JDialog_CapNhatDichVu.class.getResource("/icon/microphone.png")));
		setTitle("SING UR SONG");
		setBounds(100, 100, 1024, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		this.table_datDichVu = table_datDichVu;
		this.soLuong = soLuong;
		this.colSelected = colSelected;
		this.rowSelected = rowSelected;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 198);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 366, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		txt_soLuong = new JTextField();
		txt_soLuong.setBorder(null);
		txt_soLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_soLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txt_soLuong.setBounds(157, 11, 50, 36);
		panel.add(txt_soLuong);
		txt_soLuong.setColumns(10);

		btn_giamTT = new JButton("");
		btn_giamTT.setBorderPainted(false);
		btn_giamTT.setContentAreaFilled(false);
		btn_giamTT.setIcon(new ImageIcon(JDialog_CapNhatSoLuong.class.getResource("/icon/minus_black.png")));
		btn_giamTT.setSelectedIcon(new ImageIcon(JDialog_CapNhatSoLuong.class.getResource("/icon/minus_black.png")));
		btn_giamTT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_giamTT.setBounds(111, 11, 50, 36);
		panel.add(btn_giamTT);

		btn_tangTT = new JButton("");
		btn_tangTT.setBorderPainted(false);
		btn_tangTT.setContentAreaFilled(false);
		btn_tangTT.setIcon(new ImageIcon(JDialog_CapNhatSoLuong.class.getResource("/icon/add_black.png")));
		btn_tangTT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_tangTT.setBounds(203, 11, 50, 36);
		panel.add(btn_tangTT);

		JLabel lblNewLabel = new JLabel("SỐ LƯỢNG");
		lblNewLabel.setForeground(Color.decode(hexColor_Blue1));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 0, 352, 35);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 119, 366, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);

		btn_saveTT = new JButton("Xác nhận");
		btn_saveTT.setForeground(new Color(255, 255, 255));
		btn_saveTT.setBackground(Color.decode(hexColor_Orange));
		btn_saveTT.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btn_saveTT.setBounds(134, 0, 94, 30);
		panel_1.add(btn_saveTT);

		txt_soLuong.setText(String.valueOf(soLuong));
		btn_giamTT.addActionListener(this);
		btn_saveTT.addActionListener(this);
		btn_tangTT.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		int soLuongDaSuDungChuaThanhToan = 0;
		try {

			String tenDV = table_datDichVu.getValueAt(rowSelected, 2).toString();
			DAO_DV = new DichVu_DAO();
			dv = DAO_DV.layDuyNhatMotDichVu_TheoTenDichVu(tenDV);
			if (dv != null) {
				setSoLuongBanDau(dv.getThongTinDichVu().tinhSoLuongConLai());
				setDonGiaDV(dv.getDonGia());
				soLuongDaSuDungChuaThanhToan = Integer
						.parseInt(table_datDichVu.getValueAt(rowSelected, colSelected).toString());
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

		// btn thanh toan
		if (o.equals(btn_giamTT)) {
			int soLuongCapNhat = Integer.parseInt(txt_soLuong.getText().toString());

			if (soLuongCapNhat <= 0) {
				txt_soLuong.setText("0");
			} else
				txt_soLuong.setText(String.valueOf(soLuongCapNhat - 1));

		}

		if (o.equals(btn_tangTT)) {

			int soLuongCapNhat = Integer.parseInt(txt_soLuong.getText().toString());
			if (soLuongCapNhat >= getSoLuongBanDau()) {
				JOptionPane.showMessageDialog(null, "Số lượng tồn kho dịch vụ này không đủ !");
				txt_soLuong.setText(String.valueOf(getSoLuongBanDau()));
			} else
				txt_soLuong.setText(String.valueOf(soLuongCapNhat + 1));
		}
		if (o.equals(btn_saveTT)) {

			String soLuong = txt_soLuong.getText().toString().trim();

			if (Integer.parseInt(soLuong) == 0) {

				DefaultTableModel model = (DefaultTableModel) table_datDichVu.getModel();

				int t = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dịch vụ này?", "Xóa",
						JOptionPane.YES_NO_OPTION);
				if (t == JOptionPane.YES_OPTION) {

					ChiTietDichVu_DAO DAO_CTDV = new ChiTietDichVu_DAO();
					ChiTietDichVu ctdv = new ChiTietDichVu(getHoaDonTT(), dv, 0, getPhongTT());

					if (DAO_CTDV.xoaCTDichVu_TheoMaHD_MaP(ctdv)) {
						JOptionPane.showMessageDialog(null,
								"Xoá " + ctdv.getDichVu().getTenDichVu() + " thanh toán thành công!");
					}
					model.removeRow(rowSelected);
				}
				setVisible(false);

			} else {

				if (Integer.parseInt(txt_soLuong.getText()) > getSoLuongBanDau()) {

					txt_soLuong.setText(String.valueOf(getSoLuongBanDau()));
					// Cap nhat thanh tien moi
					int soLuongMoiCapNhat = Integer.parseInt(txt_soLuong.getText());
					double thanhTienMoi = soLuongMoiCapNhat * getDonGiaDV();

					String dcf_thanhTienMoi = dcf.format(thanhTienMoi);
					table_datDichVu.setValueAt(dcf_thanhTienMoi, rowSelected, 4);

					table_datDichVu.setValueAt(getSoLuongBanDau(), rowSelected, colSelected);
					JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng tồn");
				}

				if (Integer.parseInt(txt_soLuong.getText()) <= getSoLuongBanDau()) {

					int soLuongMoiCapNhat = Integer.parseInt(txt_soLuong.getText());

					double thanhTienMoi = soLuongMoiCapNhat * getDonGiaDV();

					table_datDichVu.setValueAt(soLuongMoiCapNhat, rowSelected, 4);
					table_datDichVu.setValueAt(dcf.format(thanhTienMoi), rowSelected, 5);
					ChiTietDichVu_DAO DAO_CTDV = new ChiTietDichVu_DAO();

					ChiTietDichVu ctdv = new ChiTietDichVu(getHoaDonTT(), dv, soLuongMoiCapNhat, getPhongTT());

					if (DAO_CTDV.capNhatCTDichVu_Theo_MaHoaDon_MaDichVu_MaPhong(ctdv)) {
						JOptionPane.showMessageDialog(null, "Cập nhật dịch vụ thanh toán thành công!!");
					}
					if (soLuongMoiCapNhat < getSoLuong()) {
						ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
						ThongTinDichVu ttdv = DAO_TTDV.timThongTinDichVu_TheoMaThongTinDichVu(
								ctdv.getDichVu().getThongTinDichVu().getMaThongTinDichVu());

						ttdv.setSoLuongDaSuDung(ttdv.getSoLuongDaSuDung() + getSoLuong() - soLuongMoiCapNhat);
						DAO_TTDV.capNhatThongTinDichVu(ttdv);
					} else if (soLuongMoiCapNhat > getSoLuong()) {

						ThongTinDichVu_DAO DAO_TTDV = new ThongTinDichVu_DAO();
						ThongTinDichVu ttdv = DAO_TTDV.timThongTinDichVu_TheoMaThongTinDichVu(
								ctdv.getDichVu().getThongTinDichVu().getMaThongTinDichVu());

						ttdv.setSoLuongDaSuDung(ttdv.getSoLuongDaSuDung() - getSoLuong() + soLuongMoiCapNhat);
						DAO_TTDV.capNhatThongTinDichVu(ttdv);

					}

					setVisible(false);
				}
			}
		}
	}

}
