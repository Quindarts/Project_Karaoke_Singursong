package GUI;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

import GUI.JPanel_QuanLyDatPhong.RoundedTransparentBorder;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;

public class JPanel_QuanLyPhong extends JPanel implements ActionListener, ItemListener {

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
	
	private JTable table_Phong;
	private JTextField textField;

	private JButton btnThem;
	private KhachHang_DAO DAO_KH;
	private ArrayList<KhachHang> dsKH;
	private Phong_DAO DAO_P;
	private ArrayList<Phong> dsP;
	private LoaiPhong_DAO DAO_LP;
	private DefaultTableModel model;
	private JButton btnTimKiem;
	private JComboBox<String> cbo_floor;


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
	public JPanel_QuanLyPhong() {
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

		table_Phong = new JTable();
		table_Phong.setBackground(Color.WHITE);
		table_Phong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phòng", "Tên phòng", "Loại phòng",
						"Trạng thái", "Ngày tạo phòng", "Vị trí phòng",
						"Ghi chú", "Tình trạng phòng" }) {
			@Override
            public boolean isCellEditable(int row, int column) {
                // Ngăn chặn việc chỉnh sửa nội dung trong bảng, nhưng vẫn cho phép chọn dữ liệu
                return false;
            }
		});
		table_Phong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1019, 615);
		scrollPane.add(table_Phong);
		scrollPane.setViewportView(table_Phong);

		panel_Table.add(scrollPane);

//		--------
		DocDuLieu();
		
		table_Phong.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int row = table_Phong.getSelectedRow();
					
					String maPhong = model.getValueAt(row, 0).toString();
					String tenPhong = model.getValueAt(row, 1).toString();
					String loaiPhong = model.getValueAt(row, 2).toString();
					String trangThai = model.getValueAt(row, 3).toString();
					String ngayTao = model.getValueAt(row, 4).toString();
					String viTri = model.getValueAt(row, 5).toString();
					String ghiChu = model.getValueAt(row, 6).toString();
					String tinhTrang = model.getValueAt(row, 7).toString();
					
					Modal_ThemPhong modal_ThemPhong = new Modal_ThemPhong();
					modal_ThemPhong.setVisible(true);
					modal_ThemPhong.setModal_ThemPhong(maPhong, tenPhong, loaiPhong, trangThai, tinhTrang, viTri, ngayTao, ghiChu);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(1031, 10, 255, 615);
		panel_Table.add(panel_1);
		panel_1.setLayout(null);
		
		cbo_floor = new JComboBox<String>();
		cbo_floor.setBounds(47, 28, 171, 36);
		cbo_floor.addItem("Tất cả");
		cbo_floor.addItem("Lầu 1");
		cbo_floor.addItem("Lầu 2");
		cbo_floor.addItem("Lầu 3");
		cbo_floor.addItem("Lầu 4");
		cbo_floor.addItem("Lầu 5");
		panel_1.add(cbo_floor);

		btnThem = new JButton("Thêm");
	
		btnThem.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnThem.setBackground(Color.decode(hexColor_Green));
		btnThem.setBounds(10, 0, 125, 35);
		panel.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaPhong();
			}
		});
		btnXoa.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/trash.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnXoa.setBackground(Color.decode(hexColor_Red));
		btnXoa.setBounds(145, 0, 125, 35);
		panel.add(btnXoa);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/refresh.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.setBounds(280, 0, 125, 35);
		panel.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DocDuLieu();
			}
		});
		

		textField = new JTextField();
		textField.setBounds(545, 0, 223, 34);
		panel.add(textField);
		textField.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(415, 0, 123, 35);
		panel.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(JPanel_QuanLyPhong.class.getResource("/icon/search.png")));
		btnTimKiem.setBackground(Color.decode(hexColor_Blue2));
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// Add event:
		btnThem.addActionListener((ActionListener) this);
		btnTimKiem.addActionListener(this);
		cbo_floor.addItemListener(this);

	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
//			Modal_ThemKhachHang modalTKH = new Modal_ThemKhachHang();
//			modalTKH.setVisible(true);
			
			Modal_ThemPhong modalTP = new Modal_ThemPhong();
			modalTP.setVisible(true);
		} else if(o.equals(btnTimKiem) && !textField.getText().equals("")) {
			TimKhachHang_TheoMa();
		}

	}
	
	public void XoaPhong() {
		int row = table_Phong.getSelectedRow();
		String maPhong = model.getValueAt(row, 0).toString();
		Phong phong = new Phong(maPhong);
		try {
			String tenPhong = DAO_P.timPhong_TheoMaPhong(maPhong).getTenPhong();	
			DAO_P.xoaPhong(phong);
			JOptionPane.showMessageDialog(null, "Xóa khách hàng" + tenPhong + "thành công");
			model.removeRow(row);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}
	
	public void DocDuLieu() {
		model = (DefaultTableModel) table_Phong.getModel();
		model.getDataVector().removeAllElements();
		
		DAO_LP = new LoaiPhong_DAO();
		DAO_P = new Phong_DAO();
		
		try {
			dsP = DAO_P.layTatCaPhong();
			if (dsP != null) {
				dsP.forEach(p -> {
					LoaiPhong lp = new LoaiPhong();
					lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
					TrangThaiPhong_DAO DAO_trangThai = new TrangThaiPhong_DAO();
					
					TrangThaiPhong trangThai = new TrangThaiPhong();
					
					
					trangThai = DAO_trangThai.timTrangThaiPhong_TheoMaTrangThai(p.getTrangThaiPhong().getMaTrangThai().trim());
					
					Object[] rowData = {p.getMaPhong(), p.getTenPhong(), lp.getTenLoaiPhong(), trangThai.getTenTrangThai(), p.getNgayTaoPhong(), p.getViTriPhong(), p.getGhiChu(), p.getTinhTrangPhong()};
					
					model.addRow(rowData);
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void TimKhachHang_TheoMa() {
		model.getDataVector().removeAllElements();
		String chuoiTimKiem = textField.getText().trim();
		Phong ma_phong= DAO_P.timPhong_TheoMaPhong(chuoiTimKiem);

		try {
			dsP.add(ma_phong);
			if (dsP != null) {
				
				LoaiPhong lp = new LoaiPhong();
				lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(ma_phong.getLoaiPhong().getMaLoaiPhong());
				TrangThaiPhong_DAO DAO_trangThai = new TrangThaiPhong_DAO();
				
				TrangThaiPhong trangThai = new TrangThaiPhong();
				
				
				trangThai = DAO_trangThai.timTrangThaiPhong_TheoMaTrangThai(ma_phong.getTrangThaiPhong().getMaTrangThai().trim());
				
				Object[] rowData = {ma_phong.getMaPhong(), ma_phong.getTenPhong(), lp.getTenLoaiPhong(), trangThai.getTenTrangThai(), ma_phong.getNgayTaoPhong(), ma_phong.getViTriPhong(), ma_phong.getGhiChu(), ma_phong.getTinhTrangPhong()};
				
				model.addRow(rowData);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có khách hàng nào có mã: " + chuoiTimKiem);
		}
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
            // Xử lý sự kiện khi một mục được chọn
            String selectedOption = (String) cbo_floor.getSelectedItem();
            
            model = (DefaultTableModel) table_Phong.getModel();
	    	model.getDataVector().removeAllElements();
    		
    		DAO_LP = new LoaiPhong_DAO();
    		DAO_P = new Phong_DAO();
    		
    		try {
    			
    			dsP = DAO_P.timPhongTheoLau(selectedOption);
    			if (dsP != null) {
    				if(!dsP.isEmpty()) {
    					dsP.forEach(p -> {
        					LoaiPhong lp = new LoaiPhong();
        					lp = DAO_LP.layLoaiPhong_TheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
        					TrangThaiPhong_DAO DAO_trangThai = new TrangThaiPhong_DAO();
        					
        					TrangThaiPhong trangThai = new TrangThaiPhong();
        					
        					
        					trangThai = DAO_trangThai.timTrangThaiPhong_TheoMaTrangThai(p.getTrangThaiPhong().getMaTrangThai().trim());
        					
        					Object[] rowData = {p.getMaPhong(), p.getTenPhong(), lp.getTenLoaiPhong(), trangThai.getTenTrangThai(), p.getNgayTaoPhong(), p.getViTriPhong(), p.getGhiChu(), p.getTinhTrangPhong()};
        					
        					model.addRow(rowData);
        				});
    				} else {
    					model.getDataVector().removeAllElements();
    				}
    				
    			} 
    			
    		} catch (Exception e1) {
    		
    		}
    		
    		if(selectedOption.equals("Tất cả")) {
    			DocDuLieu();
    		}
        }
		
	}



	private void clearTable(DefaultTableModel model_clear) {
		// TODO Auto-generated method stub
		model_clear.setRowCount(0);
		System.out.println(312);
		
	}

}