package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{

	@Query(value="select * from Employee_person where employee_username=?1 and employee_password=?2",nativeQuery=true)
	List<Employee> selectMember(String username,String password);
	
	@Query(value="select * from Employee_person where id=?1",nativeQuery=true)
	List<Employee> selectById(int id);
}
