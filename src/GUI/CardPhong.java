package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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

import Entity.Phong;

/**
 * CardPhong
 * 
 * 
 */
public class CardPhong extends JPanel {
	
	private Phong phong;
	private int width = 100;
	private int height = 100;
	
	/**
	 * @param phong
	 */
	public CardPhong(Phong phong) {
		this.phong = phong;
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.white);

		/**
		 * tenPhong
		 */
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
	        JLabel nameLabel = new JLabel(phong.getTenPhong());
	        
	        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        add(nameLabel, BorderLayout.CENTER);
		

		addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					showPopupMenu(e);
				}
			}
		});
	}

	/**
	 *	paintComponent
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Trong
		if (phong.getTrangThaiPhong().getMaTrangThai().equals("111")) {
			g.setColor(Color.decode("#00a65a"));
		}
		
		//Dang hat
		if (phong.getTrangThaiPhong().getMaTrangThai().equals("222")) {
			g.setColor(Color.decode("#ff6868"));
		}
		//Dat truoc
		if (phong.getTrangThaiPhong().getMaTrangThai().equals("333")) {
			g.setColor(Color.decode("#3c8dbc"));
		}
		//Don dep
		if (phong.getTrangThaiPhong().getMaTrangThai().equals("444")) {
			g.setColor(Color.decode("#ce93d8"));
		}
		//Dang sua chua
		if (phong.getTrangThaiPhong().getMaTrangThai().equals("555")) {
			g.setColor(Color.decode("#b0bec5"));
		}
		
		
		g.fillRect(0, getHeight() - 20, getWidth(), 20);
		g.setColor(Color.white);
		g.drawString(phong.getTrangThaiPhong().getTenTrangThai(), 10, getHeight() - 5);
	}

	/**
	 * @param Popup Menu
	 */
	private void showPopupMenu(MouseEvent e) {
		
		JPopupMenu menu = new JPopupMenu();
		JMenuItem xemThongTinMenuItem = new JMenuItem("Xem thông tin phòng");
		JMenuItem chuyenPhongMenuItem = new JMenuItem("Chuyển phòng");

		xemThongTinMenuItem.addActionListener(e1 -> {
			JOptionPane.showMessageDialog(this, "Thông tin phòng...");
		});

		chuyenPhongMenuItem.addActionListener(e1 -> {
			JFrame chuyenPhongFrame = new Modal_ChuyenPhong(phong);
			chuyenPhongFrame.setVisible(true);
		});
		menu.add(xemThongTinMenuItem);
		menu.add(chuyenPhongMenuItem);
		menu.show(this, e.getX(), e.getY());
	}
}
