package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ManagerDao;
import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	 ManagerDao md;

	@Override
	public void AddManager(Manager m) {
		
		
		
		
		
		md.save(m);
		
	 
		
	}

	@Override
	public Manager Login(String username, String password) {
		
		/*if(l.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(l.get(0));*/
		/*List<Manager> l=md.SelectManager(username, password);
		Manager[] m=l.toArray(new Manager[1]);
		
		return m[0]; */
		  List<Manager> managers = md.SelectManager(username, password);
		    return managers.isEmpty() ? null : managers.get(0); //如果没有匹配的用户，返回 null
	}

	@Override
	public boolean managerUsername(String username) {
	List<Manager> l=md.SelectByusername(username);
		
		boolean x=false;
		if(l.size()!=0) x=true;
		
		
		return x;
	}
	

	@Override
	public List<Manager> selectAll() {
		
		return md.findAll();
	}

	@Override
	public void deleteById(int id) {
		md.deleteById(id);
		
		
	}

	@Override
	public Integer findIdByUsername(String username) {
		 List<Manager> managers = md.SelectByusername(username);
		    if (!managers.isEmpty()) {
		        return managers.get(0).getId(); // 假設 Manager 類有 getId() 方法
		    }
		    return null; // 找不到時返回 null
	}

	
	 
}
