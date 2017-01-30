package com.erdi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="Student")
	public class Student implements Serializable{


	private static final long serialVersionUID = 9096624520182898625L;

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "stid")
	 private Integer stId;
	 
	 @Column(name="stname")
	 private String stName;
	 
	 @Column(name="stSurname")
	 private String stSurname;
	 
	 @Column(name="stDepartment")
	 private String stDepartment;
	 
	 @Column(name="stTelephone")
	 private String stTelephone;
	 
	 @Column(name="stAddress")
	 private String stAddress;
	 
	 public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStSurname() {
		return stSurname;
	}

	public void setStSurname(String stSurname) {
		this.stSurname = stSurname;
	}

	public String getStDepartment() {
		return stDepartment;
	}

	public void setStDepartment(String stDepartment) {
		this.stDepartment = stDepartment;
	}

	public String getStTelephone() {
		return stTelephone;
	}

	public void setStTelephone(String stTelephone) {
		this.stTelephone = stTelephone;
	}

	public String getStAddress() {
		return stAddress;
	}

	public void setStAddress(String stAddress) {
		this.stAddress = stAddress;
	}


	}