package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import DAO.LoaiPhong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.LoaiPhong;
import Entity.Phong;
import Entity.TrangThaiPhong;
import javax.swing.JCheckBox;
import java.awt.Font;

import java.util.ArrayList;
import java.util.Calendar;

import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.PhieuDatPhong_DAO;
import DAO.Phong_DAO;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuDatPhong;

/**
 * CardPhong
 * 
 * 
 */
public class CardPhong extends JPanel {
	private Phong phong;
	private int width = 150;
	private int height = 150;

	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";

	
	private boolean selectDatPhong;
	private JCheckBox cbox_DatPhong;
	


	private LoaiPhong loaiP;
	private KhachHang kh;
	private NhanVien nv;
	private PhieuDatPhong pdp;
	private PhieuDatPhong phieu;
	private ArrayList<Phong> dsPhong;
	private ArrayList<KhachHang> dsKhachHang;
	private ArrayList<NhanVien> dsNhanVien;
	private ArrayList<PhieuDatPhong> dsPhieuDatPhong;
	private KhachHang_DAO DAO_KH;
	private NhanVien_DAO DAO_NV;
	private PhieuDatPhong_DAO DAO_PDP;
	private Phong_DAO DAO_P;
	private Calendar cal = Calendar.getInstance();
	private String tenNV;
	private String tenKH;
	private String sdtKH;
	private LoaiPhong_DAO DAO_LP;
	private TrangThaiPhong_DAO DAO_TTP;
	private TrangThaiPhong_DAO dao_TrangThaiPhong;


	/**
	 * @param phong
	 */

	public CardPhong(Phong phong) {
		this.phong = phong;

		setPreferredSize(new Dimension(width, height));

		/**
		 * tenPhong
		 */
		setBackground(Color.decode(hexColor_Blue4));
		setLayout(null);

		JLabel nameLabel = new JLabel(phong.getMaPhong());
		nameLabel.setBackground(new Color(5, 74, 145));
		nameLabel.setBounds(0, 0, 150, 150);
		nameLabel.setForeground(Color.decode(hexColor_Blue1));
		nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(nameLabel);

		cbox_DatPhong = new JCheckBox("Đặt phòng này");
		cbox_DatPhong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		cbox_DatPhong.setForeground(new Color(51, 153, 255));
		cbox_DatPhong.setBounds(0, 0, 150, 21);

		System.out.println(phong.getTrangThaiPhong().getMaTrangThai());

		if (phong.getTrangThaiPhong().getMaTrangThai().trim().equals("VC")) {
			add(cbox_DatPhong);
			cbox_DatPhong.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						selectDatPhong = true;
					} else {
						selectDatPhong = false;
					}
				}
			});
		}
		addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					showPopupMenu(e);
				}
			}
		});

	}

	public boolean isSelectDatPhong() {
		return selectDatPhong;
	}

	public void setSelectDatPhong(boolean selectDatPhong) {
		this.selectDatPhong = selectDatPhong;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		TrangThaiPhong trangThaiP = null;

		TrangThaiPhong_DAO DAO_TTP = new TrangThaiPhong_DAO();

		try {
			trangThaiP = DAO_TTP.timTrangThaiPhong_TheoMaTrangThai(phong.getTrangThaiPhong().getMaTrangThai());
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(trangThaiP);

		// Trong
		if (phong.getTrangThaiPhong().getMaTrangThai().trim().equals("VC")) {
			g.setColor(Color.decode("#00a65a"));
		}

		// Dang hat
		if (phong.getTrangThaiPhong().getMaTrangThai().trim().equals("OC")) {
			g.setColor(Color.decode("#ff6868"));
		}
		// Dat truoc
		if (phong.getTrangThaiPhong().getMaTrangThai().trim().equals("OCP")) {
			g.setColor(Color.decode("#3c8dbc"));
		}
		// Dang sua chua
		if (phong.getTrangThaiPhong().getMaTrangThai().trim().equals("OOO")) {
			g.setColor(Color.decode("#b0bec5"));
		}
		g.fillRect(0, getHeight() - 20, getWidth(), 20);
		g.setColor(Color.white);
		g.drawString(trangThaiP.getTenTrangThai(), 10, getHeight() - 5);
	}

	private void showPopupMenu(MouseEvent e) {
		DAO_PDP = new PhieuDatPhong_DAO();
		DAO_NV = new NhanVien_DAO();
		DAO_P = new Phong_DAO();
		DAO_KH = new KhachHang_DAO();
		DAO_LP = new LoaiPhong_DAO();
		DAO_TTP = new TrangThaiPhong_DAO();
		nv = new NhanVien();
		phieu = new PhieuDatPhong();
		dsPhieuDatPhong = DAO_PDP.layTatCaPhieuDatPhong();
		dsPhong = DAO_P.layTatCaPhong();
		dao_TrangThaiPhong = new TrangThaiPhong_DAO();


		JPopupMenu menu = new JPopupMenu();
		JMenuItem xemThongTinMenuItem = new JMenuItem("Xem thông tin phòng");
		JMenuItem chuyenPhongMenuItem = new JMenuItem("Chuyển phòng");
		JMenuItem datPhongMenuItem = new JMenuItem("Đặt phòng hát ngay");
		
		datPhongMenuItem.addActionListener(e1 -> {
			JOptionPane.showMessageDialog(this, "Bạn có chắc chắn đặt phòng này?");
			setSelectDatPhong(true);
			cbox_DatPhong.setSelected(isSelectDatPhong());
		});
		xemThongTinMenuItem.addActionListener(e1 -> {
			try {
				phong = DAO_P.timPhong_TheoMaPhong(phong.getMaPhong());
				String anhPhong = "";
				String tenPhong = phong.getTenPhong();
				String viTriPhong = phong.getViTriPhong();		
				String tinhTrang = phong.getTinhTrangPhong();
				
				LoaiPhong loaiP = null;
				loaiP = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(phong.getLoaiPhong().getMaLoaiPhong());
				String tenLoaiPhong = loaiP.getTenLoaiPhong();
				String giaPhong = loaiP.getGiaTien()+"";			
				
				TrangThaiPhong trThaiP = null;
				trThaiP = DAO_TTP.timTrangThaiPhong_TheoMaTrangThai(phong.getTrangThaiPhong().getMaTrangThai());
				String trangThaiPhong = trThaiP.getTenTrangThai();
				Modal_XemThongTinPhong thongTinPhong = new Modal_XemThongTinPhong();
				thongTinPhong.setVisible(true);
				thongTinPhong.SetModal_XemThongTinPhong(anhPhong,tenPhong , tenLoaiPhong, viTriPhong, giaPhong, trangThaiPhong, tinhTrang);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		});
		chuyenPhongMenuItem.addActionListener(e1 -> {		
			try {
				if (dsPhieuDatPhong != null)
					for (PhieuDatPhong pdp : dsPhieuDatPhong) {
						phieu = DAO_PDP.layPhieuDatPhong_TheoMaPhong(phong.getMaPhong());
						nv = phieu.getNhanVien();
						tenNV = DAO_NV.timNhanVien_TheoMaNhanVien(nv.getMaNhanVien()).getHoTen();
						kh = phieu.getKhachHang();
						tenKH = DAO_KH.layKhachHang_TheoMaKhachHang(kh.getMaKhachHang()).getHoTen();
						sdtKH = DAO_KH.layKhachHang_TheoMaKhachHang(kh.getMaKhachHang()).getSoDienThoai();
						if (phieu != null)
							break;
					}
				Modal_PhieuChuyenPhong phieuChuyenPhong = new Modal_PhieuChuyenPhong();
				phieuChuyenPhong.setVisible(true);
				phieuChuyenPhong.SetModal_PhieuChuyenPhong(phieu.getThoiGianNhanPhong(), phieu.getMaPhieuDat(), tenNV, tenKH, sdtKH);
				
				// Cập nhật lại trạng thái phòng
				TrangThaiPhong trThaiPh = new TrangThaiPhong();
				trThaiPh = dao_TrangThaiPhong.timTrangThaiPhong_TheoTenTrangThai("Trống");
				DAO_P.capNhat_TranThaiPhong(phong.getMaPhong(), trThaiPh.getMaTrangThai());

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Phòng này chưa được đặt!");
			}

		});
		menu.add(xemThongTinMenuItem);
		menu.add(chuyenPhongMenuItem);
		menu.add(datPhongMenuItem);
		menu.show(this, e.getX(), e.getY());
	}
}
