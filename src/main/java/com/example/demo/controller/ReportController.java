package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.impl.JasperReportServiceImpl;


import jakarta.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin
@RestController
public class ReportController {

	
	@Autowired
	JasperReportServiceImpl jrsi;
	@Autowired
	EmployeeDao ed;
	
	
	@GetMapping("jasperReport")
	public String jasperReport(HttpServletRequest request){
		
		String rul=request.getRemoteHost();
		
		try {
			String jrxmlFilePath = "JasperReport/Employee.jrxml";//String jrxmlFilePath 用於存儲 JRXML 文件的路徑
			String desktopPath = System.getProperty("user.home") + "/Desktop/report.pdf";
			jrsi.generatePdfReport(jrxmlFilePath, desktopPath);

	            return "Report generated successfully on the Desktop!";
		}catch(JRException e) {
			e.printStackTrace();
			return"Error generating report"+e.getMessage();
			
		}
		
		
	}
	@GetMapping("download")
	public ResponseEntity<byte[]> downloadReport(HttpServletRequest request) {
		String rul = request.getRemoteHost();
	    try {
	        // 獲取所有員工數據
	        List<Employee> employees =ed.findAll(); // 假設你有一個 EmployeeDao
	        if (employees.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	        }
	        
	        // 生成 PDF 報告
	        ByteArrayOutputStream pdfStream = jrsi.generatePdfReport("JasperReport/Employee.jrxml", employees);
	        
	        byte[] pdfBytes = pdfStream.toByteArray();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=Employee.pdf");

	        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}