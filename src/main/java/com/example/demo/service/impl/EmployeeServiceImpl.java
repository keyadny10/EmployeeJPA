package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeDao ed;
	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		ed.save(e);
	}

	@Override
	public List<Employee> SelectAll() {
		// TODO Auto-generated method stub
		return ed.findAll();
	}

	@Override
	public Employee Login(String Employee_username, String Employee_password) {
		List<Employee> l=ed.selectMember(Employee_username, Employee_password);
		Employee[] m=l.toArray(new Employee[1]);
		
		return m[0];	}

	@Override
	public void updateEmployee(Employee e) {
		ed.save(e);
		System.out.println("修改成功");
		
	}

	@Override
	public void deleteEmployee(int id) {
		ed.deleteById(id);
		System.out.println("刪除成功");
		
	}

	@Override
	public Page<Employee> getEmployeesWithPagination(Pageable pageable) {
		return ed.findAll(pageable);
	}

	
	
	}

	