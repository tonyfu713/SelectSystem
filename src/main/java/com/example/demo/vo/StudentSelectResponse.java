package com.example.demo.vo;

import java.util.List;

import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentSelectResponse {
	
	@JsonProperty("subject_system_list")
	private List<StudentSelect> stutentSelectList;
	
	private String message;
	
	
	//建構方法
	public StudentSelectResponse(List<StudentSelect> stutentSelectList, String message) {
		super();
		this.stutentSelectList = stutentSelectList;
		this.message = message;
	}
	
	public StudentSelectResponse(String message) {
		super();
		this.message = message;
	}



	//get/set
	public List<StudentSelect> getStutentSelectList() {
		return stutentSelectList;
	}

	public void setStutentSelectList(List<StudentSelect> stutentSelectList) {
		this.stutentSelectList = stutentSelectList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
