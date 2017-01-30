package com.erdi.service;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.erdi.model.Student;
import com.erdi.report.Fill;
import com.erdi.report.Writer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("downloadService")
@Transactional
public class DownloadService {

	private static Logger logger = Logger.getLogger("service");
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void downloadXLS(HttpServletResponse response) throws ClassNotFoundException {
		logger.debug("Downloading");
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("POI Worksheet");
		
		int startRowIndex = 2;
		int startColIndex = 2;
	
		Fill.fillReport(worksheet, startRowIndex, startColIndex, getDatasource());
		String fileName = "StudentList.xls";
		response.setHeader("Content-Disposition", "inline; filename=" + fileName);
		response.setContentType("application/vnd.ms-excel");
		Writer.write(response, worksheet);
	}
	@SuppressWarnings("unchecked")
	private List<Student> getDatasource() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Student");
		List<Student> result = query.list();
		return result;
	}
}