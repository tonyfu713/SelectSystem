package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentSelectPK implements Serializable {


	private static final long serialVersionUID = 1L;

    private String studentId;

    private String classCode;
    
    public StudentSelectPK() {
    	
    }

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

