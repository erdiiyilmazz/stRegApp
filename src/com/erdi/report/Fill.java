package com.erdi.report;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import com.erdi.model.Student;

public class Fill {

	public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<Student> datasource) {

		HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
		bodyCellStyle.setWrapText(true);

		for (int i=startRowIndex; i+startRowIndex-2< datasource.size()+2; i++) {
			HSSFRow row = worksheet.createRow((short) i+1);
			
			// Get Id
			HSSFCell cell1 = row.createCell(startColIndex+0);
			cell1.setCellValue(datasource.get(i-2).getStId());
			cell1.setCellStyle(bodyCellStyle);

			// Get Name
			HSSFCell cell2 = row.createCell(startColIndex+1);
			cell2.setCellValue(datasource.get(i-2).getStName());
			cell2.setCellStyle(bodyCellStyle);

			// Get Surname
			HSSFCell cell3 = row.createCell(startColIndex+2);
			cell3.setCellValue(datasource.get(i-2).getStSurname());
			cell3.setCellStyle(bodyCellStyle);

			// Get Department
			HSSFCell cell4 = row.createCell(startColIndex+3);
			cell4.setCellValue(datasource.get(i-2).getStDepartment());
			cell4.setCellStyle(bodyCellStyle);

			// Get Telephone
			HSSFCell cell5 = row.createCell(startColIndex+4);
			cell5.setCellValue(datasource.get(i-2).getStTelephone());
			cell5.setCellStyle(bodyCellStyle);
		
			// Get Address
			HSSFCell cell6 = row.createCell(startColIndex+5);
			cell6.setCellValue(datasource.get(i-2).getStAddress());
			cell6.setCellStyle(bodyCellStyle);
		}
	}
}