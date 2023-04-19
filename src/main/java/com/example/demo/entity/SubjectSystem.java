package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_system")
public class SubjectSystem {
	
	@Id
	@Column(name = "class_code")
	private String classCode;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name = "day")
	private Integer day;
	
	@Column(name = "start_time")
	private Integer startTime;
	
	@Column(name = "end_time")
	private Integer endTime;
	
	@Column(name = "credit")
	private Integer credit;
	
	//重要!!
	public SubjectSystem() {
		
	}
	

	public SubjectSystem(String classCode, String className, Integer day, Integer startTime, Integer endTime, Integer credit) {
		super();
		this.classCode = classCode;
		this.className = className;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.credit = credit;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClasscode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	

}
