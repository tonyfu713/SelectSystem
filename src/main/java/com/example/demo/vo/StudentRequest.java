package com.example.demo.vo;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentRequest {
	@JsonProperty("student_list")
	private List<Student> studentlist;
	
	private Student student;
	
	private String studentId;

	
	
	public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	

}
