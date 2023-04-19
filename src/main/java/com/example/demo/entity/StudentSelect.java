package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

//以選課資料
@Entity
@IdClass(StudentSelectPK.class)
@Table(name = "student_select")
public class StudentSelect {
	
	
	//雙主鍵
	@Id
	@Column(name = "student_id")
	private String studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	//雙主鍵
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
	
	

	public StudentSelect() {
		
	}


	

	public StudentSelect(Integer credit) {
		super();
		this.credit = credit;
	}

	public StudentSelect(String studentId, String studentName, String classCode, String className, Integer day,
			Integer startTime, Integer endTime, Integer credit) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.classCode = classCode;
		this.className = className;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.credit = credit;
	}



	public String getStudentId() {
		return studentId;
	}



	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public String getClassCode() {
		return classCode;
	}



	public void setClassCode(String classCode) {
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
