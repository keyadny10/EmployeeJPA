package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="manager")
public class Manager {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	public Manager(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
