package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import other.HelpXLSX;

public class demo extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JButton btnNewButton = new JButton("Đọc file Excel test ở folder Demo file Employee Write");
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			HelpXLSX xls = new HelpXLSX();

			public void actionPerformed(ActionEvent e) {
//				xls.writeXLSXFile("Demo/quang.xlsx");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public String chooseFileEvent(String typeFile) {
		JFileChooser file = new JFileChooser();
		String path = "";
		file.setCurrentDirectory(new File(System.getProperty("user.home")));

		FileNameExtensionFilter filterImage = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png", "xlsx",
				"xls");
		FileNameExtensionFilter filterExcel = new FileNameExtensionFilter("xlsx", "xls");

		// Doc path image
		if (typeFile.equals("image")) {
			file.addChoosableFileFilter(filterImage);
		}
		// Doc path excel
		else if (typeFile.equals("excel")) {
			file.addChoosableFileFilter(filterExcel);
		}

		int result = file.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {

			File selectedFile = file.getSelectedFile();
			path = selectedFile.getAbsolutePath();
			return path;
		}

		else if (result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy file tải lên");
		}
		return path;
	}

}
