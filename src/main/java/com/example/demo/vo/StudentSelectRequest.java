package com.example.demo.vo;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentSelectRequest {
	
	@JsonProperty("student_select_list")
	private List<StudentSelect> stutentSelectList;
	
	
	private String studentId;
	
	private String className;


	public List<StudentSelect> getStutentSelectList() {
		return stutentSelectList;
	}

	public void setStutentSelectList(List<StudentSelect> stutentSelectList) {
		this.stutentSelectList = stutentSelectList;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentid(String studentId) {
		this.studentId = studentId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
