package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page; // 確保引入 Page 類
import org.springframework.data.domain.Pageable; // 引入 Pageable

public interface EmployeeService {
	//creat
		void addEmployee(Employee e);
		
		//read
		List<Employee> SelectAll();
		Employee Login(String Employee_username,String Employee_password);
		
		//update
		void updateEmployee(Employee e);
		
		//delete
		void deleteEmployee(int id);

		 Page<Employee> getEmployeesWithPagination(Pageable pageable);
}
