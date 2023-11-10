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

	private LoaiPhong loaiP;
	private boolean selectDatPhong;
	private JCheckBox cbox_DatPhong;

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

		JPopupMenu menu = new JPopupMenu();
		JMenuItem xemThongTinMenuItem = new JMenuItem("Xem thông tin phòng");
		JMenuItem chuyenPhongMenuItem = new JMenuItem("Chuyển phòng");
		JMenuItem datPhongMenuItem = new JMenuItem("Đặt phòng hát ngay");
		xemThongTinMenuItem.addActionListener(e1 -> {
			JOptionPane.showMessageDialog(this, "Thông tin phòng...");
		});
		datPhongMenuItem.addActionListener(e1 -> {
			JOptionPane.showMessageDialog(this, "Bạn có chắc chắn đặt phòng này?");
			setSelectDatPhong(true);
			cbox_DatPhong.setSelected(isSelectDatPhong());
		});

		chuyenPhongMenuItem.addActionListener(e1 -> {
			JFrame chuyenPhongFrame = new Modal_ChuyenPhong(phong);
			chuyenPhongFrame.setVisible(true);
		});
		menu.add(xemThongTinMenuItem);
		menu.add(chuyenPhongMenuItem);
		menu.add(datPhongMenuItem);
		menu.show(this, e.getX(), e.getY());
	}
}
