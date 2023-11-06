package GUI;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
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

	public ButtonCellRendererEditor(ChiTietDichVu chiTietDichVu) {
		this.chiTietDichVu = chiTietDichVu;

		button = new JButton("xóa");
		button.setBounds(0, 0, 20, 20);
		button.addActionListener(e -> {
			System.out.println("click me!!!");
		});
	}

	public ButtonCellRendererEditor(DefaultTableModel model, JTable table) {
		panel_main = new JPanel();

		button = new JButton("xóa");
		button.setBounds(0, 0, 10, 10);
		button.addActionListener(e -> {
			System.out.println("click me!!!");
			int row = table.getEditingRow();
			if (row != -1) {
				model.removeRow(row);
			}
			if(row  == 1) {
				model.getDataVector().removeAllElements();
			}

		});
		panel_main.add(button);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return panel_main;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.table = table;
		clickedRow = row;
		return panel_main;
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

}
