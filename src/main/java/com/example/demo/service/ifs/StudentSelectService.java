package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.example.demo.vo.StudentRequest;
import com.example.demo.vo.StudentResponse;
import com.example.demo.vo.StudentSelectRequest;
import com.example.demo.vo.StudentSelectResponse;

public interface StudentSelectService {
	//功能_加選課程
	public StudentSelectResponse addStudentSelectList(StudentSelectRequest studentSelectRequest);
	
	//功能_刪除課程
	public StudentSelectResponse deleteStudentSelectList(StudentSelectRequest studentSelectRequest);
	
//	//功能_學生找已選的課程
//	public List<StudentSelect> findByStudentId (String studentId);

	//功能_找學生已選課程
	public StudentSelectResponse findByStudentId2(StudentSelectRequest studentSelectRequest);



}
