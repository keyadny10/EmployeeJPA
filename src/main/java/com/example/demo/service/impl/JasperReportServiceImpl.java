package com.example.demo.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class JasperReportServiceImpl {
	 @Autowired
     EmployeeDao myDataRepository;

 public void generatePdfReport(String jrxmlFilePath,String outputFilePath) throws JRException {

	
	 
	   List<Employee> data = myDataRepository.findAll();
        

        // 確認數據是否被讀取
        if (data.isEmpty()) {
            throw new RuntimeException("No data found for report generation.");
        }

        // 載入 JRXML 檔案
        String fontfile = "JasperReport/Employee.jrxml"; 
        
       InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fontfile);//用於存儲從資源文件獲取的輸入流=返回Class 物件.負責加載類和資源.尋找字型
        
        if (inputStream == null) {
            throw new RuntimeException("Unable to find JRXML file");
        }
        
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        // 使用數據源
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

        // 準備參數
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ReportTitle", "My Report Title");

        // 產生報告
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // 輸出 PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputFilePath);
    }
 
 
 public ByteArrayOutputStream generatePdfReport(String jrxmlFilePath, List<Employee> data) throws JRException {
	    if (data.isEmpty()) {
	        throw new RuntimeException("No data found for report generation.");
	    }

	    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(jrxmlFilePath);
	    if (inputStream == null) {
	        throw new RuntimeException("Unable to find JRXML file");
	    }

	    JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("ReportTitle", "My Report Title");

	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);

	    return byteArrayOutputStream;
	}
}

