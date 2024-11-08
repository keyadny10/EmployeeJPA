package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("employee_person")
public class EmployeeController {
	@Autowired
	EmployeeService es;
	
	@PostMapping("addEmployee")
	public ResponseEntity<String> AddEmployee(@RequestBody Employee e,HttpServletRequest request) 
	{


		String rul=request.getRemoteHost();
		
		 // 驗證必要字段
	    if (e.getNo1()== null || e.getName() == null || e.getPhone() == null || e.getAddress() == null ||
	        e.getNo1().isEmpty() || e.getName().isEmpty() || e.getPhone().isEmpty() || e.getAddress().isEmpty()) {
	        return ResponseEntity.status(400).body("所有字段都必須填寫！");
	    }
	
		
		
		try {
			es.addEmployee(e);
			System.out.print(e.toString());
            return ResponseEntity.status(200).body("建檔成功");
            
        
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Error adding employee: " + ex.getMessage());
        }
    }

		
		
	@GetMapping("queryEmployee")
	public ResponseEntity<Page<Employee>> queryEmployee(Pageable pageable) {
	    Page<Employee> employeePage = es.getEmployeesWithPagination(pageable);
	    return ResponseEntity.ok(employeePage);
	}
	/*@GetMapping("queryEmployee")
	public List<Employee> queryEmployee(HttpServletRequest request, String jasperReport) {
		String rul=request.getRemoteHost();
		
         
		return es.SelectAll();
	}*/
	
	@PutMapping("updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee e,HttpServletRequest request) {
		String rul=request.getRemoteHost();
		 if (e.getId()==null||e.getNo1()== null || e.getName() == null || e.getPhone() == null || e.getAddress() == null ||e.getId().equals(null)||
			       e.getNo1().isEmpty()|| e.getName().isEmpty() || e.getPhone().isEmpty() || e.getAddress().isEmpty()) {
			        return ResponseEntity.status(400).body("所有字段都必須填寫！");
			    }

		    try {
		        es.updateEmployee(e);
		        return ResponseEntity.status(200).body("更新成功");
		    } catch (Exception ex) {
		        return ResponseEntity.status(500).body("更新失敗: " + ex.getMessage());
		    }
		}
		
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id,HttpServletRequest request) {
		String rul=request.getRemoteHost();
		 try {
		        es.deleteEmployee(id);
		        return ResponseEntity.status(200).body("刪除成功");
		    } catch (Exception ex) {
		        return ResponseEntity.status(500).body("刪除失敗: " + ex.getMessage());
		    }
		}
	}
	


