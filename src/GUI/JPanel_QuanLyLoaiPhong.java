package GUI;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import GUI.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.Phong_DAO;
import DAO.TrangThaiPhong_DAO;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.Phong;
import Entity.TrangThaiPhong;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;

public class JPanel_QuanLyLoaiPhong extends JPanel implements ActionListener, KeyListener, ItemListener {

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

	private JTable table_LoaiPhong;
	private JTextField txt_find;

	private JButton btnThem;

	private ArrayList<KhachHang> dsKH;
	private LoaiPhong_DAO DAO_LP;
	private ArrayList<LoaiPhong> dsLP;

	private Phong_DAO DAO_P;
	private DefaultTableModel model;
	private JButton btnLamMoi;

	private String[] rowData;
	private JComboBox<String>  cboNumberPeople;
	private JComboBox<String> cboPrice;


	/**
	 * Rounded JPanel
	 */
	public class RoundedTransparentBorder extends AbstractBorder {
		private int cornerRadius;
		private Color borderColor;
		private Color backgroundColor;
		private float alpha;

		public RoundedTransparentBorder(int cornerRadius, Color borderColor, Color backgroundColor, float alpha) {
			this.cornerRadius = cornerRadius;
			this.borderColor = borderColor;
			this.backgroundColor = backgroundColor;
			this.alpha = alpha;
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
		}

		@Override
		public Insets getBorderInsets(Component c, Insets insets) {
			insets.left = insets.top = insets.right = insets.bottom = cornerRadius;
			return insets;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			if (width <= 0 || height <= 0) {
				return;
			}

			Graphics2D g2d = (Graphics2D) g.create();

			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

			RoundRectangle2D.Float roundRect = new RoundRectangle2D.Float(x, y, width - 1, height - 1, cornerRadius,
					cornerRadius);

			g2d.setColor(backgroundColor);
			g2d.fill(roundRect);
			g2d.setColor(borderColor);
			g2d.draw(roundRect);

			g2d.dispose();
		}

	}

	/**
	 * Create the panel.
	 */
	public JPanel_QuanLyLoaiPhong() {
		setBackground(Color.decode(hexColor_Blue1));
		setLayout(null);
		setBounds(0, 0, 1296, 672);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1296, 672);
		panel.setBackground(Color.decode(hexColor_Blue1));
//		panel.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		add(panel);
		panel.setLayout(null);

		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new RoundedTransparentBorder(20, Color.decode(hexColor_Blue1), Color.WHITE, 1.0f));
		panel_Table.setBackground(Color.decode(hexColor_Blue1));
//		panel_Table.setBackground(Color.WHITE);
		panel_Table.setBounds(0, 37, 1296, 635);
		panel.add(panel_Table);
		panel_Table.setLayout(null);

		table_LoaiPhong = new JTable();
		table_LoaiPhong.setBackground(Color.WHITE);

		table_LoaiPhong.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã loại phòng",
				"Tên loại phòng", "Số lượng khách tối đa", "Giá tiền", "Hình ảnh", "Mô tả" })
		{
			@Override
            public boolean isCellEditable(int row, int column) {
                // Ngăn chặn việc chỉnh sửa nội dung trong bảng, nhưng vẫn cho phép chọn dữ liệu
                return false;
            }
		}
				);

		table_LoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_LoaiPhong);
		scrollPane.setViewportView(table_LoaiPhong);

		panel_Table.add(scrollPane);

		docDuLieu();

		table_LoaiPhong.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int row = table_LoaiPhong.getSelectedRow();

					String maLoaiPhong = model.getValueAt(row, 0).toString();
					String tenPhong = model.getValueAt(row, 1).toString();
					String soLuong = model.getValueAt(row, 2).toString();
					String giaTien = model.getValueAt(row, 3).toString();
					String hinhAnh = model.getValueAt(row, 4).toString();
					String moTa = model.getValueAt(row, 5).toString();
	
					Modal_CapNhatLoaiPhong modal_CNloaiPhong = new Modal_CapNhatLoaiPhong();
					modal_CNloaiPhong.setVisible(true);
					modal_CNloaiPhong.setModalThemLoaiPhong(maLoaiPhong, tenPhong, giaTien, soLuong, hinhAnh, moTa);
					
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(1031, 10, 255, 615);
		panel_Table.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBounds(10, 35, 235, 163);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		cboNumberPeople = new JComboBox();
		cboNumberPeople.setBounds(139, 36, 86, 36);
		panel_2.add(cboNumberPeople);
		cboNumberPeople.addItem("Tất cả");
		cboNumberPeople.addItem("5");
		cboNumberPeople.addItem("12");
		
		JLabel lblNewLabel = new JLabel("Số lượng khách: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 36, 119, 36);
		panel_2.add(lblNewLabel);
		
		JLabel lblMcGiTin = new JLabel("Mức giá tiền: ");
		lblMcGiTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMcGiTin.setBounds(10, 92, 119, 36);
		panel_2.add(lblMcGiTin);
		
		cboPrice = new JComboBox();
		cboPrice.setBounds(116, 94, 109, 36);
		panel_2.add(cboPrice);
		cboPrice.addItem("Tất cả");
		cboPrice.addItem("20.000 VND");
		cboPrice.addItem("40.000 VND");
		cboPrice.addItem("60.000 VND");
		cboPrice.addItem("80.000 VND");
		cboPrice.addItem("100.000 VND");

		btnThem = new JButton("Thêm");

		btnThem.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(Color.decode(hexColor_Green));
		btnThem.setBounds(10, 0, 125, 35);
		panel.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int row = table_LoaiPhong.getSelectedRow();
				String maLP = model.getValueAt(row, 0).toString();
				LoaiPhong lp = new LoaiPhong(maLP);
				try {
					Phong p = new Phong();
					DAO_P = new Phong_DAO();
					
					ArrayList<Phong> dsP = DAO_P.timDSPhongTheoMaLoaiPhong(maLP);
					
					
					for( Phong value : dsP) {
						DAO_P.capNhat_TinhTrangPhong(value.getMaPhong(), "Không sử dụng");
						DAO_P.capNhat_TranThaiPhong(value.getMaPhong(), "OOO");
					}
					
					DAO_LP = new LoaiPhong_DAO();
					String tenLoaiPhong = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(maLP).getTenLoaiPhong();
					int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Đóng?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						DAO_LP.xoaLoaiPhong(lp);
						JOptionPane.showMessageDialog(null, "Xóa " + tenLoaiPhong + " thành công");
						model.removeRow(row);
					} else {
					   
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại");
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/trash.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnXoa.setBackground(Color.decode(hexColor_Red));
		btnXoa.setBounds(145, 0, 125, 35);
		panel.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setBounds(280, 0, 125, 35);
		panel.add(btnLamMoi);

		txt_find = new JTextField();
		txt_find.setBounds(545, 0, 223, 34);
		panel.add(txt_find);
		txt_find.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(415, 0, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyLoaiPhong.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// Add event:
		btnThem.addActionListener((ActionListener) this);
		btnLamMoi.addActionListener(this);
		txt_find.addKeyListener(this);
		cboNumberPeople.addItemListener(this);
		cboPrice.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			Modal_ThemLoaiPhong modal_laoPhong = new Modal_ThemLoaiPhong();
			modal_laoPhong.setVisible(true);
		}
		
		if(o.equals(btnLamMoi)) {
			cboNumberPeople.setSelectedItem("Tất cả");
			cboPrice.setSelectedItem("Tất cả");
			docDuLieu();
		}

	}
	
	public void docDuLieu() {
		model = (DefaultTableModel) table_LoaiPhong.getModel();
		model.getDataVector().removeAllElements();
		
		DAO_LP = new LoaiPhong_DAO();
		
		try {
			dsLP = DAO_LP.layTatCaLoaiPhong();
			if (dsLP != null) {
				dsLP.forEach(lp -> {

					Object[] rowData = { lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getSoLuongToiDa(),
							lp.getGiaTien(), lp.getHinhAnh(), lp.getMoTa() };

					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void TimTheoMaLP() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = txt_find.getText().trim();
		LoaiPhong ma_loai_phong= DAO_LP.layLoaiPhong_TheoMaLoaiPhong(chuoiTimKiem);
		
		dsLP = DAO_LP.timDSPhongTheoMaLPhong(chuoiTimKiem);
		
		try {
			dsLP.add(ma_loai_phong);
			if (dsLP != null) {
							
				dsLP = DAO_LP.timDSPhongTheoMaLPhong(chuoiTimKiem);
				if (dsLP != null) {
					dsLP.forEach(lp -> {

						Object[] rowData = { lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getSoLuongToiDa(),
								lp.getGiaTien(), lp.getHinhAnh(), lp.getMoTa() };

						model.addRow(rowData);
					});
				}
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có phòng nào có mã: " + chuoiTimKiem);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			TimTheoMaLP();
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED) {
			txt_find.setText("");
			
			String selectNumber = (String) cboNumberPeople.getSelectedItem();
			String selectPrice = (String) cboPrice.getSelectedItem();
			String priceConvert;
			
			model = (DefaultTableModel) table_LoaiPhong.getModel();
	    	model.getDataVector().removeAllElements();
	    	switch (selectPrice) {
	    	case "20.000 VND" :
	    		priceConvert = "20000.00";
	    		break;
	    	case "40.000 VND" :
	    		priceConvert = "40000.00";
	    		break;
	    	case "60.000 VND" :
	    		priceConvert = "60000.00";
	    		break;
	    	case "80.000 VND" :
	    		priceConvert = "80000.00";
	    		break;
	    	case "100.000 VND" :
	    		priceConvert = "100000.00";
	    		break;
			default:
				priceConvert = "Tất cả";
			}
	    	
	    	
	    	dsLP = DAO_LP.timDStheoSoLuongVaGiaTien(selectNumber,priceConvert);    	
	    	try {
	    		if (dsLP != null) {
	    			if(!dsLP.isEmpty()) {
	    				dsLP.forEach(lp -> {

							Object[] rowData = { lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getSoLuongToiDa(),
									lp.getGiaTien(), lp.getHinhAnh(), lp.getMoTa() };

							model.addRow(rowData);
						});	
	    			} else {
	    				model = (DefaultTableModel) table_LoaiPhong.getModel();
   				     	model.getDataVector().removeAllElements();
   				     	model.fireTableDataChanged();
	    			}
				}
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Không chuỗi này");
			}
		}
	}	
}