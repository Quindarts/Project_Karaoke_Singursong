package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.itextpdf.awt.geom.Dimension;

import Entity.ChiTietDichVu;
import Entity.DichVu;

public class ButtonCellRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private JButton button;
	private int clickedRow;
	private JTable table;
	private ChiTietDichVu chiTietDichVu;
	private JPanel panel_main;

	// BTN DICHVU
	private JTable tableDichVu;
	private JTable tableDichVuDatPhong;
	private DefaultTableModel modelDichVuDatPhong;
	private DefaultTableModel modelDichVu;
	private DichVu dv;


	public ButtonCellRendererEditor(DefaultTableModel model, JTable table) {
		panel_main = new JPanel();
		button = new JButton(new ImageIcon(JPanel_QuanLyDatPhong.class.getResource("/icon/delete_red_16px.png")));
		button.setBounds(0, 0, 10, 10);
		button.setForeground(Color.white);
//		button.setBackground(Color.RED);
		button.addActionListener(e -> {

			int row = table.getEditingRow();
			if (row != -1) {
				model.removeRow(row);
			}

		});

	}

	// Button them Dich vu vao dich vu dat phong
	public ButtonCellRendererEditor( DefaultTableModel modelDichVu,DefaultTableModel modelDichVuDatPhong,
			JTable tableDichVu, JTable tableDichVuDatPhong, DichVu dv) {

		this.modelDichVu = modelDichVu;
		this.modelDichVuDatPhong = modelDichVuDatPhong;
		this.dv = dv;
		this.tableDichVuDatPhong = tableDichVuDatPhong;
		this.tableDichVu = tableDichVu;

		panel_main = new JPanel();
		button = new JButton("Thêm");
		button.setBounds(0, 0, 10, 10);
		button.addActionListener(e -> {

			Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(), 1, dv.getDonGia() };
			modelDichVuDatPhong.addRow(rowData);

			for (int i = 0; i < tableDichVu.getRowCount(); i++) {
				if (dv.getMaDichVu() == tableDichVu.getValueAt(i, 0).toString()) {
					tableDichVu.setValueAt(String.valueOf((int) tableDichVu.getValueAt(i, 2) - 1), i, 2);
				}

			}

//			if (kiemTraTrungMaDichVuTrongDSDichVu(dv.getMaDichVu(), tableDichVuDatPhong) == true) {
//
//				for (int i = 0; i < tableDichVu.getRowCount(); i++) {
//					System.out.println("i::" + i);
//					if (dv.getMaDichVu() == tableDichVu.getValueAt(i, 0).toString()) {
//
////						int soLuongBanDau = Integer.parseInt((String) tableDichVu.getValueAt(i, 2));
//						System.out.println("soLuongBanDau:::" + tableDichVu.getValueAt(i, 2));
//
////						tableDichVu.setValueAt(soLuongBanDau + 1, i, 2);
//					}
//				}
//
//				for (int i = 0; i < tableDichVuDatPhong.getRowCount(); i++) {
//					if (dv.getMaDichVu() == tableDichVuDatPhong.getValueAt(0, 0)) {
//						int soLuongBanDau = (int) tableDichVuDatPhong.getValueAt(0, 2);
//						tableDichVu.setValueAt(String.valueOf(soLuongBanDau + 1), 0, 2);
//					}
//				}
//			}

		});

//		panel_main.add(button);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return button;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.table = table;
		clickedRow = row;
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

//	public boolean kiemTraTrungMaDichVuTrongDSDichVu(String maDichVu, JTable table) {
//
//		// Neu co maDichVu == ma => da co trong do roi tra ve false
//		for (int row = 0; row <= table.getRowCount(); row++) {
//			String roomCode = table.getValueAt(row, 0).toString();
//			System.out.println("room::" + roomCode);
//			if (maDichVu == roomCode) {
//				return true;
//			}
//		}
//		return false;
//	}
}
