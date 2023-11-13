package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.ThongTinDichVu_DAO;
import Entity.DichVu;
import Entity.ThongTinDichVu;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class CardDichVu extends JPanel {
	private DichVu dichVu;
	private ThongTinDichVu ttdv;
	private String hexColor_Blue1 = "#054A91";
	private String hexColor_Blue2 = "#3E7CB1";
	private String hexColor_Blue3 = "#81A4CD";
	private String hexColor_Blue4 = "#DBE4EE";

	private int width = 190;
	private int height = 230;
	private ThongTinDichVu_DAO DAO_TTDV;
	private JLabel img_show_panel;

	public CardDichVu(DichVu dichVu) {
		setBackground(new Color(255, 255, 255));
		this.dichVu = dichVu;

		DAO_TTDV = new ThongTinDichVu_DAO();
		this.ttdv = DAO_TTDV.timThongTinDichVu_TheoMaDichVu(dichVu.getMaDichVu());

		setPreferredSize(new Dimension(width, height));
		setLayout(null);

		JPanel main_card = new JPanel();
		main_card.setBackground(new Color(255, 255, 255));
		main_card.setBounds(18, 18, 150, 150);
		add(main_card);
		main_card.setLayout(null);

		img_show_panel = new JLabel();
		img_show_panel.setBounds(0, 0, 150, 150);

		img_show_panel.setIcon(ResizeImage(ttdv.getHinhAnh()));
		main_card.add(img_show_panel);

		JLabel lbl_giaTien = new JLabel(Double.toString(dichVu.getDonGia()));
		lbl_giaTien.setForeground(new Color(255, 69, 0));
		lbl_giaTien.setBounds(18, 190, 140, 20);
		add(lbl_giaTien);
		lbl_giaTien.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JLabel lbl_tenDichVu = new JLabel(dichVu.getTenDichVu());
		lbl_tenDichVu.setForeground(new Color(0, 102, 153));
		lbl_tenDichVu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_tenDichVu.setBounds(18, 170, 150, 21);
		add(lbl_tenDichVu);

		JButton btn_Xem = new JButton("Chi tiết");
		btn_Xem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_Xem.setForeground(new Color(255, 255, 255));
		btn_Xem.setBackground(new Color(50, 205, 50));
		btn_Xem.setBounds(87, 190, 80, 21);
		add(btn_Xem);
	}

	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(img_show_panel.getWidth(), img_show_panel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
}