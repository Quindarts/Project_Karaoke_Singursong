package GUI;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
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

	public ButtonCellRendererEditor(ChiTietDichVu chiTietDichVu) {
		this.chiTietDichVu = chiTietDichVu;
		
		button = new JButton("xóa");
        button.setBounds( 0,0,40,40);
		button.addActionListener(e -> {
			System.out.println("click me!!!");
		});
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

}
