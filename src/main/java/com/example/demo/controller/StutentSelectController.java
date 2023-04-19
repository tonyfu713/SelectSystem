package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.example.demo.service.ifs.StudentSelectService;
import com.example.demo.service.ifs.SubjectSystemService;
import com.example.demo.vo.StudentSelectRequest;
import com.example.demo.vo.StudentSelectResponse;
import com.example.demo.vo.SubjectSystemRequest;
import com.example.demo.vo.SubjectSystemResponse;

@RestController
public class StutentSelectController {
	@Autowired
	private StudentSelectService studentSelectService;

	
	@PostMapping("add_studend_select_list")
	public StudentSelectResponse addStudentSelectList(@RequestBody StudentSelectRequest studentSelectRequest){

		return studentSelectService.addStudentSelectList(studentSelectRequest);
	}
	
	@PostMapping("dellet_studend_select_list")
	public StudentSelectResponse delletStudentSelectList(@RequestBody StudentSelectRequest studentSelectRequest) {
		
		return studentSelectService.delletStudentSelectList(studentSelectRequest);
	}
	
	@PostMapping("find_by_student_id")
	public List<StudentSelect> findByStudentId(@RequestBody StudentSelectRequest studentSelectRequest) {

		return studentSelectService.findByStudentId(studentSelectRequest.getStudentId());
	}
	



}
