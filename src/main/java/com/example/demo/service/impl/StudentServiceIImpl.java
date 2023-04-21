package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.example.demo.repository.StudentDao;
import com.example.demo.repository.StudentSelectDao;
import com.example.demo.repository.SubjectSystemDao;
import com.example.demo.service.ifs.StudentService;
import com.example.demo.vo.StudentRequest;
import com.example.demo.vo.StudentResponse;
import com.example.demo.vo.StudentSelectRequest;
import com.example.demo.vo.StudentSelectResponse;

@Service
public class StudentServiceIImpl implements StudentService{
	
	@Autowired
	public StudentDao studentDao;
	@Autowired
	public SubjectSystemDao subjectSystemDao;
	@Autowired
	public StudentSelectDao studentSelectDao;
	


	//功能_添加學生
	@Override
	public StudentResponse addStudentList(StudentRequest studentRequest) {
		List<Student> reqStudentList = studentRequest.getStudentlist();
		List<Student>errorStudentList = new ArrayList<>();

		//可以輸入僅1筆資料，但必須用list格式
		if(CollectionUtils.isEmpty(reqStudentList)) {
			return new StudentResponse("資料輸入不完全");
		}
		for(Student item : reqStudentList) {
			if(!StringUtils.hasText(item.getStudentId())) {
				return new StudentResponse("未輸入學號");
			}
			if(!StringUtils.hasText(item.getStudentName())) {
				return new StudentResponse("未輸入姓名");
			}
			if(studentDao.existsById(item.getStudentId())) {
				errorStudentList.add(item);
			}
		}
		if(!errorStudentList.isEmpty()) {
			return new StudentResponse("學號重複");			
		}
		studentDao.saveAll(reqStudentList);
		
		return new StudentResponse(reqStudentList,"成功");
	}
	
	//功能_刪除學生
	@Override
	public StudentResponse deleteStudentList(StudentRequest studentRequest) {
		String reqStudent = studentRequest.getStudentId();
		
		//防呆_沒輸入東西
		if(!StringUtils.hasText(reqStudent)) {
			return new StudentResponse("資料輸入不完全");
		}
		
		if(!StringUtils.hasText(reqStudent)) {
			return new StudentResponse("未輸入學號");
		}
		if(studentSelectDao.existsByStudentId(reqStudent)) {
			return new StudentResponse("請先刪除已選課程");
		}
		if(!studentDao.existsById(reqStudent)) {
			return new StudentResponse("沒有這個學生資料");
		}		
		//資料刪除後 存進資料庫
		studentDao.deleteById(reqStudent);;
		
		return new StudentResponse("已刪除學生資訊");
	}



}
