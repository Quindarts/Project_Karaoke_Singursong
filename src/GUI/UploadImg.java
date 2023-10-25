package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UploadImg extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton button;
	JLabel img_show_panel;

	public UploadImg() {
		super("Demo Chức năng tải ảnh lên");
		button = new JButton("Chọn tệp ảnh để tải lên");
		button.putClientProperty( "JButton.buttonType", "roundRect" );
		button.setBounds(10, 266, 253, 40);

		img_show_panel = new JLabel();
		img_show_panel.setBounds(10, 10, 253, 246);
		img_show_panel.setBorder(BorderFactory.createLineBorder(Color.black));

		getContentPane().add(button);
		getContentPane().add(img_show_panel);

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				img_show_panel.setIcon(ResizeImage(chooseFileEvent("image")));
			}
		});

		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Đọc file Excel test ở folder Demo file Employee Write");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerXLSXFile(chooseFileEvent("excel"));
			}
		});		
		
		btnNewButton.setBounds(284, 50, 400, 21);
		getContentPane().add(btnNewButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700, 400);
		setVisible(true);
	}

	public ImageIcon ResizeImage(String ImagePath) {

		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(img_show_panel.getWidth(), img_show_panel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;

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
			System.out.println("Không tìm thấy file tải lên");
			JOptionPane.showMessageDialog(null, "Không tìm thấy file tải lên");
		}
		return path;
	}

	public void readerXLSXFile(String path) {
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t\t");
						break;
					default:
					}
				}
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
