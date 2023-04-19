package com.example.demo.vo;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {
	@JsonProperty("student_list")
	private List<Student> studentlist;
	
	
	private String message;


	public StudentResponse(List<Student> studentlist, String message) {
		super();
		this.studentlist = studentlist;
		this.message = message;
	}
	
	public StudentResponse(String message) {
		super();
		this.message = message;
	}
	
	
	public List<Student> getStudentlist() {
		return studentlist;
	}	

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}

	public String getMessage() {
		return message;
	}
	
	
	public void setMessage(String message) {
		this.message = message;
	}

	
	

	
	

}
