package com.example.demo.vo;

import java.util.List;

import com.example.demo.entity.SubjectSystem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectSystemResponse {
	
	@JsonProperty("subject_system_list")
	private List<SubjectSystem> subjectSystemList;
	
	private String message;
	
	


	public SubjectSystemResponse(String message) {
		super();
		this.message = message;
	}

	public SubjectSystemResponse(List<SubjectSystem> subjectSystemList, String message) {
		super();
		this.subjectSystemList = subjectSystemList;
		this.message = message;
	}

	public List<SubjectSystem> getSubjectSystemList() {
		return subjectSystemList;
	}

	public void setSubjectSystemList(List<SubjectSystem> subjectSystemList) {
		this.subjectSystemList = subjectSystemList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
