package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Manager;

public interface ManagerDao extends JpaRepository<Manager,Integer> {

	@Query(value="Select*from manager where username=?1 and password=?2",nativeQuery=true)
	List<Manager> SelectManager(String username,String password);
	
	
	@Query(value="select*from manager where id=?1",nativeQuery=true)
	List<Manager> SelectById(int id);
	
	@Query(value="select*from manager where username=?1",nativeQuery=true)
	List<Manager> SelectByusername(String username);
	
	
}
