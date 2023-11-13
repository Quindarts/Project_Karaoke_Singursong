package OtherFunction;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import GUI.JPanel_QuanLyPhieuDatPhong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class CustomTable extends JTable {
	private TableColumn buttonColumn;

	public CustomTable(DefaultTableModel model, int coll) {
		super(model);

		buttonColumn = getColumnModel().getColumn(coll);
		buttonColumn.setCellRenderer(new ButtonRenderer());
		buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
	}

	public class ButtonRenderer extends DefaultTableCellRenderer {
		private JButton deleteButton;
		private JButton editButton;

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

			// Thêm icon xóa

			deleteButton = new JButton();
			deleteButton
					.setIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/add.png")));
//			deleteButton.setBorderPainted(false);
//			deleteButton.setContentAreaFilled(false);
//			deleteButton.setFocusPainted(false);
//			deleteButton.setOpaque(false);

			// Thêm icon sửa

			editButton = new JButton();
			editButton.setIcon(new ImageIcon(JPanel_QuanLyPhieuDatPhong.class.getResource("/icon/add.png")));
//			editButton.setBorderPainted(false);
//			editButton.setContentAreaFilled(false);
//			editButton.setFocusPainted(false);
//			editButton.setOpaque(false);

			panel.add(deleteButton);
			panel.add(editButton);

			return panel;
		}

	}

	public class ButtonEditor extends DefaultCellEditor {
		private JButton button;
		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
					// Xử lý sự kiện khi icon được click
					JOptionPane.showMessageDialog(null,"ok");

				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			isPushed = true;
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			if (isPushed) {
				// Xử lý sự kiện khi icon được click
			}
			isPushed = false;
			return null;
		}

		@Override
		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}
	}

}
