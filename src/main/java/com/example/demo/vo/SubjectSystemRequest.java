package com.example.demo.vo;

import java.util.List;

import com.example.demo.entity.SubjectSystem;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectSystemRequest {
//	@JsonProperty("subject_system")
//	private SubjectSystem subjectSystem;
	
	@JsonProperty("subject_system_list")
	private List<SubjectSystem> subjectSystemList;

	private String classCode;

	private String className;


	

//	public SubjectSystem getSubjectSystem() {
//		return subjectSystem;
//	}
//
//	public void setSubjectSystem(SubjectSystem subjectSystem) {
//		this.subjectSystem = subjectSystem;
//	}


	public List<SubjectSystem> getSubjectSystemList() {
		return subjectSystemList;
	}
	

	public void setSubjectSystemList(List<SubjectSystem> subjectSystemList) {
		this.subjectSystemList = subjectSystemList;
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
	
	

}
