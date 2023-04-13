package com.sch.common.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.MappedSuperclass;

/*
 * NB Once a class is of type abstract, an object of that class
 * can not be created. Abstract class are super class and they 
 * contain variable and method that is inherited by other classes
 * 
 * @MappedSuperclass indicate this class is a super class
 */

@MappedSuperclass
public abstract class IdBaseEntity {

	//NB for inheritance purpose the access type of the variable should be change to protected
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		protected Integer id;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
}
