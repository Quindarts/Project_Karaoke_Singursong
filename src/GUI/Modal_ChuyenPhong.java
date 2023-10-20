package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Entity.Phong;

/**
 * ModalChuyenPhong
 * 
 * 
 */
public class Modal_ChuyenPhong extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Phong phong;
	private int width = 500;
	private int height = 200;
	private String title;
	

	public Modal_ChuyenPhong(Phong phong) throws HeadlessException {
		super();
		this.phong = phong;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.white);
		setSize(400, 200);
		setTitle("Chuyển phòng");
		setBackground(Color.white);
		setLayout(new BorderLayout());
		JLabel nameLabel = new JLabel(phong.getTenPhong());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(nameLabel, BorderLayout.CENTER);
	}


	public Modal_ChuyenPhong(Phong phong, int width, int height, String title) {
		super();
		this.phong = phong;
		this.width = width;
		this.height = height;
		this.title = title;
		//
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.white);
		setSize(400, 200);
		setTitle("Chuyển phòng");
		setBackground(Color.white);
		setLayout(new BorderLayout());

		JLabel nameLabel = new JLabel(phong.getTenPhong());

		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(nameLabel, BorderLayout.CENTER);
	}

}
