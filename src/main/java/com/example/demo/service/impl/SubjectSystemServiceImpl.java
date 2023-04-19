package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.entity.SubjectSystem;
import com.example.demo.repository.StudentDao;
import com.example.demo.repository.StudentSelectDao;
import com.example.demo.repository.SubjectSystemDao;
import com.example.demo.service.ifs.SubjectSystemService;
import com.example.demo.vo.SubjectSystemRequest;
import com.example.demo.vo.SubjectSystemResponse;



@Service
public class SubjectSystemServiceImpl implements SubjectSystemService {
	
	@Autowired
	public SubjectSystemDao subjectSystemDao;

	@Autowired
	public StudentDao studentDao;
	
	@Autowired
	public StudentSelectDao studentSelectDao;

	//功能_新增課表
	@Override
	public SubjectSystemResponse addclasslist(SubjectSystemRequest subjectSystemRequest) {
		
		List<SubjectSystem> subjectSystemList = subjectSystemRequest.getSubjectSystemList();
		List<SubjectSystem> errorList = new ArrayList<>();
		
		if(CollectionUtils.isEmpty(subjectSystemList)) {
			return new SubjectSystemResponse("資料輸入不完全");
		}
		
		//防呆_未輸入資訊
		for(SubjectSystem item : subjectSystemList) {
			if(!StringUtils.hasText(item.getClassCode())) {
				return new SubjectSystemResponse ("未輸入課程代碼");
			}
			if(!StringUtils.hasText(item.getClassName())) {
				return new SubjectSystemResponse ("未輸入課程名稱");
			}
			if((item.getDay()) == null) {
				return new SubjectSystemResponse ("未輸入課程代碼");
			}
			if((item.getStartTime()) == null) {
				return new SubjectSystemResponse ("未輸入上課時間");
			}
			if((item.getEndTime()) == null) {
				return new SubjectSystemResponse ("未輸入下課時間");
			}
			if((item.getCredit()) == null) {
				return new SubjectSystemResponse ("未輸入學分數");
			}
			
			//防呆_id(課程代碼)不能重複
			//如果重複 把資料放進錯誤List
			if(subjectSystemDao.existsById(item.getClassCode())) {
				errorList.add(item);
			}
			
		}
		//如果錯誤List有東西 報代碼重複
		
		if(!errorList.isEmpty()) {
			
			return new SubjectSystemResponse ("課程代碼重複");
		}
		
		//存進資料庫
		subjectSystemDao.saveAll(subjectSystemList);
		for(SubjectSystem item2 : subjectSystemList) {
				System.out.println(item2);
				
			}

		return new SubjectSystemResponse (subjectSystemList,"新增課表成功");
	}
	
	//功能_課程代碼找課程資訊
	@Override
	public List<SubjectSystem> findByClassCode(String classCode) {
		System.out.println(classCode);

		return subjectSystemDao.findByClassCode(classCode);
	}

	//功能_課程名稱找課程資訊
	@Override
	public List<SubjectSystem> findByClassName(String className) {

		return subjectSystemDao.findByClassName(className);
	}

	//功能_刪除資料庫的資料
	@Override
	public SubjectSystemResponse delletclasslist(SubjectSystemRequest subjectSystemRequest) {
		String subjectSystem = subjectSystemRequest.getClassCode();
		
		//防呆_輸入課程為空
		if(!StringUtils.hasText(subjectSystem)) {
			return new SubjectSystemResponse("請輸入欲刪除課程代碼");
		}
		//資料庫沒有這個課程
		if(!subjectSystemDao.existsById(subjectSystem)) {
			return new SubjectSystemResponse ("無此課程");
		}
		//有學生選這個課程
		if(studentSelectDao.existsByClassCode(subjectSystem)) {
			return new SubjectSystemResponse ("已有學生選課");
	
		}	
		subjectSystemDao.deleteById(subjectSystem);
		return new SubjectSystemResponse ("刪除成功");
	}

	//功能_修改課程資訊
	@Override
	public SubjectSystemResponse resetclasslist(SubjectSystemRequest subjectSystemRequest) {
		List<SubjectSystem> subjectSystemList = subjectSystemRequest.getSubjectSystemList();
		
		if(CollectionUtils.isEmpty(subjectSystemList)) {
			return new SubjectSystemResponse("資料輸入不完全");
		}
		for(SubjectSystem item : subjectSystemList) {

			if(!StringUtils.hasText(item.getClassCode())) {
				return new SubjectSystemResponse ("未輸入課程代碼");
			}
			if(!StringUtils.hasText(item.getClassName())) {
				return new SubjectSystemResponse ("未輸入課程名稱");
			}
			if((item.getDay()) == null) {
				return new SubjectSystemResponse ("未輸入課程代碼");
			}
			if((item.getStartTime()) == null) {
				return new SubjectSystemResponse ("未輸入上課時間");
			}
			if((item.getEndTime()) == null) {
				return new SubjectSystemResponse ("未輸入下課時間");
			}
			if((item.getCredit()) == null) {
				return new SubjectSystemResponse ("未輸入學分數");
			}
			if(!subjectSystemDao.existsById(item.getClassCode())) {
				return new SubjectSystemResponse ("不存在此課程代碼，無法修改");
			}
			subjectSystemDao.deleteAll(subjectSystemList);
			subjectSystemDao.saveAll(subjectSystemList);;

		}
		
		return new SubjectSystemResponse (subjectSystemList,"修改課表成功");
	}

	
	
}
