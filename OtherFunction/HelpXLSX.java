package OtherFunction;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HelpXLSX {
	
	public static void readerXLSXFile(String path) {
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
	
	public  static void writeXLSXFile(String path) {	
		XSSFWorkbook workbook = new XSSFWorkbook(); 

		//Create a blank sheet

		XSSFSheet sheet = workbook.createSheet("Employee Data");

		//Prepare data to be written as an Object[]

		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
		data.put("2", new Object[] {1, "Amit", "Shukla"});
		data.put("3", new Object[] {2, "Lokesh", "Gupta"});
		data.put("4", new Object[] {3, "John", "Adwards"});
		data.put("5", new Object[] {4, "Brian", "Schultz"});

		//Iterate over data and write to sheet

		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {

		  Row row = sheet.createRow(rownum++);
		  Object [] objArr = data.get(key);
		  int cellnum = 0;
		  for (Object obj : objArr)
		  {
		     Cell cell = row.createCell(cellnum++);
		     if(obj instanceof String)
		          cell.setCellValue((String)obj);
		      else if(obj instanceof Integer)
		          cell.setCellValue((Integer)obj);
		  }
		}

		//Write the workbook in file system

		try {
		  FileOutputStream out = new FileOutputStream(new File(path));
		  workbook.write(out);
		  out.close();
		  System.out.println("create file successfully");
		} 
		catch (Exception e) {
		  e.printStackTrace();
		}
	}
}