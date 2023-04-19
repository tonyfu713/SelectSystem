package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.SubjectSystem;
import com.example.demo.vo.StudentRequest;
import com.example.demo.vo.StudentResponse;
import com.example.demo.vo.StudentSelectRequest;
import com.example.demo.vo.StudentSelectResponse;

public interface StudentService {
	//功能_添加學生
	public StudentResponse addStudentList(StudentRequest studentRequest);

	//功能_刪除學生
	public StudentResponse delletStudentList(StudentRequest studentRequest);

}
