package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name="employee_person")

public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String no1;
		private String name;
		private String phone;
		private String address;
		public Employee(String no1, String name, String phone, String address) {
			super();
			this.no1 = no1;
			this.name = name;
			this.phone = phone;
			this.address = address;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
