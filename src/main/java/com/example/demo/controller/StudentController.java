package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SubjectSystem;
import com.example.demo.service.ifs.StudentService;
import com.example.demo.service.ifs.SubjectSystemService;
import com.example.demo.vo.StudentRequest;
import com.example.demo.vo.StudentResponse;
import com.example.demo.vo.StudentSelectRequest;
import com.example.demo.vo.StudentSelectResponse;
import com.example.demo.vo.SubjectSystemRequest;

@RestController
public class StudentController {
	@Autowired
	public StudentService studentService;
	

	@PostMapping("add_student_list")
	public StudentResponse addStudentList(@RequestBody StudentRequest studentRequest) {

		return studentService.addStudentList(studentRequest);
	}
	@PostMapping("delete_student_list")
	public StudentResponse deleteStudentList(@RequestBody StudentRequest studentRequest) {

		return studentService.deleteStudentList(studentRequest);
	}
	
	

	
	


}
