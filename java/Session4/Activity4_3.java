package Session4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity4_3 {
	private static String FILE_NAME = "resources/TestSheet.xlsx";
	
public static void main(String[] args) {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
	
	//Initialize data
	Object[][] datatypes = {
		    {"Datatype", "Type", "Size(in bytes)"},
		    {"int", "Primitive", 2},
		    {"float", "Primitive", 4},
		    {"double", "Primitive", 8},
		    {"char", "Primitive", 1},
		    {"String", "Non-Primitive", "No fixed size"}
		};
	
	
	int rowNum = 0;
	
	for (Object[] datatype : datatypes) {
	    Row row = sheet.createRow(rowNum++);
	    int colNum = 0;
	    for (Object field : datatype) {
	        Cell cell = row.createCell(colNum++);
	        if (field instanceof String) {
	            cell.setCellValue((String) field);
	        } else if (field instanceof Integer) {
	            cell.setCellValue((Integer) field);
	        }
	    }
	}
	
	
	FileOutputStream outputStream;
	try {
		outputStream = new FileOutputStream(FILE_NAME);
		workbook.write(outputStream);
		System.out.println("Write to excel sheet is successful!!");
	} catch (FileNotFoundException e) {
		System.out.println("Error in writing to excel sheet");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Error in writing to excel sheet");
		e.printStackTrace();
	}
	
}
}
