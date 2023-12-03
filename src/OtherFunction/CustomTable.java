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
	private JButton deleteButton;
	private JButton editButton;

	public CustomTable(DefaultTableModel model, int coll) {
		super(model);

		buttonColumn = getColumnModel().getColumn(coll);
		buttonColumn.setCellRenderer(new ButtonRenderer());
		buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
	}

	public class ButtonRenderer extends DefaultTableCellRenderer {
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

			// Thêm icon xóa

			deleteButton = new JButton();
			deleteButton.setIcon(new ImageIcon(CustomTable.class.getResource("/icon/delete_red_16px.png")));
			deleteButton.setBorderPainted(true);
			deleteButton.setContentAreaFilled(true);
			deleteButton.setFocusPainted(false);
			deleteButton.setOpaque(false);

			// Thêm icon sửa

			editButton = new JButton();
			editButton.setIcon(new ImageIcon(CustomTable.class.getResource("/icon/pen_blue_16px.png")));
			editButton.setBorderPainted(true);
			editButton.setContentAreaFilled(true);
			editButton.setFocusPainted(false);
			editButton.setOpaque(false);

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
	                    handleButtonClick();
	                }
	            });
	        }

	        private void handleButtonClick() {
	            int selectedRow = getSelectedRow();
	            int selectedColumn = getSelectedColumn();

	            if (selectedColumn == buttonColumn.getModelIndex()) {
	                // Check which button was clicked
	                if (button == deleteButton) {
	                    // Handle delete button click
	                    handleDeleteButtonClick(selectedRow);
	                } else if (button == editButton) {
	                    // Handle edit button click
	                    handleEditButtonClick(selectedRow);
	                }
	            }
	        }

	        private void handleDeleteButtonClick(int selectedRow) {
	            // Implement logic to delete the selected row
//	            DefaultTableModel model = (DefaultTableModel) getModel();
	            JOptionPane.showMessageDialog(null, "Delete button clicked for row: " + selectedRow);
//	            model.removeRow(selectedRow);
	        }

	        private void handleEditButtonClick(int selectedRow) {
	            // Implement logic to edit the selected row
	            // You might open a dialog or perform any other action here
	            JOptionPane.showMessageDialog(null, "Edit button clicked for row: " + selectedRow);
	        }

	        // ... existing code ...
	    }

}
