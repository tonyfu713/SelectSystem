package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//學生資料
@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "student_id")
	private String studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	public Student() {
		
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

	public Student(String studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	

}
