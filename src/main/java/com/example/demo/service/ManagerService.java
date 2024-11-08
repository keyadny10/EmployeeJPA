package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Manager;

public interface ManagerService {

	//add
		void AddManager(Manager m);
		
		//read
		Manager Login(String username,String password);
		
		boolean managerUsername(String username);
		
		List<Manager> selectAll();
		
		void deleteById(int id);
		
		Integer findIdByUsername(String username);	
		
		
}
