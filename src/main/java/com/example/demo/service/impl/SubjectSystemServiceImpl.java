package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;
import com.example.demo.repository.StudentDao;
import com.example.demo.repository.StudentSelectDao;
import com.example.demo.repository.SubjectSystemDao;
import com.example.demo.service.ifs.SubjectSystemService;
import com.example.demo.vo.StudentSelectResponse;
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

	//機能_新しいカリキュラムの追加
	@Override
	public SubjectSystemResponse addclasslist(SubjectSystemRequest subjectSystemRequest) {
		
		List<SubjectSystem> subjectSystemList = subjectSystemRequest.getSubjectSystemList();
		List<SubjectSystem> errorList = new ArrayList<>();
		
		if(CollectionUtils.isEmpty(subjectSystemList)) {
			return new SubjectSystemResponse("資料輸入不完全");
		}
		
		//防止策_情報が入力されていない
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
		
		//データベースに保存する
		subjectSystemDao.saveAll(subjectSystemList);
		for(SubjectSystem item2 : subjectSystemList) {
				System.out.println(item2);
				
			}

		return new SubjectSystemResponse (subjectSystemList,"新增課表成功");
	}
	
	//機能_classCodeで授業情報を検索する
	@Override
	public List<SubjectSystem> findByClassCode(String classCode) {
		System.out.println(classCode);

		return subjectSystemDao.findByClassCode(classCode);
	}

	//機能_課程名で授業情報を検索する
	@Override
	public List<SubjectSystem> findByClassName(String className) {

		return subjectSystemDao.findByClassName(className);
	}

	//機能_授業情報を削除する
	@Override
	public SubjectSystemResponse deleteclasslist(SubjectSystemRequest subjectSystemRequest) {
		List<SubjectSystem> subjectSystemList = subjectSystemRequest.getSubjectSystemList();
		
		if(CollectionUtils.isEmpty(subjectSystemList)) {
			return new SubjectSystemResponse("資料輸入不完全");
		}
		for(SubjectSystem item : subjectSystemList) {
			
			//防呆_輸入課程為空
			if(!StringUtils.hasText(item.getClassCode())) {
				return new SubjectSystemResponse("請輸入欲刪除課程代碼");
			}
			//資料庫沒有這個課程
			if(!subjectSystemDao.existsById(item.getClassCode())) {
				return new SubjectSystemResponse ("無此課程");
			}
			//有學生選這個課程
			if(studentSelectDao.existsByClassCode(item.getClassCode())) {
				return new SubjectSystemResponse ("已有學生選課");
				
			}	
		}
		subjectSystemDao.deleteAll(subjectSystemList);
		return new SubjectSystemResponse ("刪除成功");
		}

	//機能_授業情報を編集する
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

		}
		subjectSystemDao.saveAll(subjectSystemList);;
		
		return new SubjectSystemResponse (subjectSystemList,"修改課表成功");
	}
	
	//機能_classIdで授業情報を検索する
	@Override
	public SubjectSystemResponse findByClassCode2(SubjectSystemRequest subjectSystemRequest) {
		List<SubjectSystem> subjectSystemList = subjectSystemRequest.getSubjectSystemList();
		List<SubjectSystem> subjectSystemListTotal = new ArrayList<>();
		
		if(CollectionUtils.isEmpty(subjectSystemList)) {
			return new SubjectSystemResponse("資料輸入不完全");
		}
		for(SubjectSystem item : subjectSystemList) {

			if(!StringUtils.hasText(item.getClassCode())) {
				return new SubjectSystemResponse("未輸入學號");
			}
			if(!subjectSystemDao.existsById(item.getClassCode())) {
				return new SubjectSystemResponse("無此學生資料");
			}
			List<SubjectSystem> subjectSystemFindByClassCode = subjectSystemDao.findByClassCode(item.getClassCode());
			
			subjectSystemListTotal.addAll(subjectSystemFindByClassCode);
		}
		
		return new SubjectSystemResponse(subjectSystemListTotal,"查詢成功");
	}
	
	//機能_課程名で授業情報を検索する
	@Override
	public SubjectSystemResponse findByClassName2(SubjectSystemRequest subjectSystemRequest) {
		
		List<SubjectSystem> subjectSystemList = subjectSystemRequest.getSubjectSystemList();
		
		List<SubjectSystem> subjectSystemListTotal = new ArrayList<>();
		
		if(CollectionUtils.isEmpty(subjectSystemList)) {
			return new SubjectSystemResponse("資料輸入不完全");
		}
	
		for(SubjectSystem item : subjectSystemList) {
			
			if(!StringUtils.hasText(item.getClassName())) {
				return new SubjectSystemResponse("未輸入課程姓名");
				
			}
			
			if(!subjectSystemDao.existsByClassName(item.getClassName())) {
				return new SubjectSystemResponse("無此學生資料");
			}
			
			List<SubjectSystem> stutentSelectFindByClassName = subjectSystemDao.findByClassName(item.getClassName());
			
			subjectSystemListTotal.addAll(stutentSelectFindByClassName);
		}
		
		return new SubjectSystemResponse(subjectSystemListTotal,"查詢成功");
	}

}
