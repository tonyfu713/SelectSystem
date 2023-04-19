package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.example.demo.service.ifs.StudentSelectService;
import com.example.demo.vo.StudentResponse;
import com.example.demo.vo.StudentSelectRequest;
import com.example.demo.vo.StudentSelectResponse;

@Service
public class StudentSelectServiceImpl implements StudentSelectService {
	
	//重要!! 要獨立1人1個
	@Autowired
	public StudentSelectDao studentSelectDao;
	@Autowired
	public SubjectSystemDao subjectSystemDao;
	@Autowired
	public StudentDao studentDao;

	
	//功能_加選課程_輸入學號,學生名字,課程代碼
	@Override
	public StudentSelectResponse addStudentSelectList(StudentSelectRequest studentSelectRequest) {
		
		//輸入進來的東西轉型成List<>格式
		List<StudentSelect> stutentSelectList = studentSelectRequest.getStutentSelectList();
		//設一個空list放之後要輸出的資料
		List<StudentSelect> stutentSelectListTotal = new ArrayList<>();
		
		//遍歷輸入進來的值成item，再從不同的資料庫中取需要的值
		for(StudentSelect item : stutentSelectList) {
			//從課程資料中去找輸入進來的課程代碼
			List<SubjectSystem> subjectSystemFindByClassCode = subjectSystemDao.findByClassCode(item.getClassCode());
			//從已選課程中去找輸入進來的學號
			List<StudentSelect> stutentSelectFindByStudentId = studentSelectDao.findByStudentId(item.getStudentId());
			//從已選課程中去找輸入進來的課程代碼
			List<StudentSelect> stutentSelectFindByClassCode = studentSelectDao.findByClassCode(item.getClassCode());
			
			//防呆_資料庫沒有輸入進來的這堂課
			if(subjectSystemFindByClassCode.isEmpty()) {
				return new StudentSelectResponse("找不到此課程代碼");
			}
			//防呆_request沒有輸入學號或是名字
			if(!StringUtils.hasText(item.getStudentId())||
			   !StringUtils.hasText(item.getStudentName())) {
				return new StudentSelectResponse("資料輸入不完全");
			}
			//防呆_學生的資料庫沒有相同的學號姓名
			if(!studentDao.existsByStudentIdAndStudentName(item.getStudentId(),item.getStudentName())) {
				
				return new StudentSelectResponse("學號跟學生名字不符");
			}
			//防呆_選課資料庫已經存在輸入的這筆資料(學生姓名和課程代碼皆相同才會報錯)			
			if(studentSelectDao.existsByStudentNameAndClassCode(item.getStudentName(),item.getClassCode())) {
			
				return new StudentSelectResponse("已選過此課程");
			}
			
			
			
			
			//把student的學號名字抓出來，subjectsystem的課程內容抓出來，存進item2在轉型成list最後return出來
			//設一個新的StudentSelect來存資料
			//把藉由輸入的課程代碼找出來的課程資料庫的資料遍歷成SubjectSystem格式再存進新設的StudentSelect
			//也把一開始輸入的item的值取出來存進StudentSelect
			for(SubjectSystem subjectSystemitem : subjectSystemFindByClassCode) {
				StudentSelect newStudentSelectList = new StudentSelect(item.getStudentId(),item.getStudentName(),
						subjectSystemitem.getClassCode(),subjectSystemitem.getClassName(),
						subjectSystemitem.getDay(),subjectSystemitem.getStartTime(),
						subjectSystemitem.getEndTime(),subjectSystemitem.getCredit());
						//再把剛剛的newStudentSelectList加進一開始的stutentSelectListTotal
						stutentSelectListTotal.add(newStudentSelectList);
	
//				//等於上面的功能_有設建構方法的話
//				item2.setStudentId(item.getStudentId());
//				item2.setStudentName(item.getStudentName());
//				item2.setClassCode(subjectSystemitem.getClassCode());
//				item2.setClassName(subjectSystemitem.getClassName());
//				item2.setDay(subjectSystemitem.getDay());
//				item2.setStartTime(subjectSystemitem.getStartTime());
//				item2.setEndTime(subjectSystemitem.getEndTime());
//				item2.setCredit(subjectSystemitem.getCredit());
				
						
				
				
				
				//防呆_選課不得超過10學分
				//總學分先設成0
				Integer totalCredit = 0;
				for(StudentSelect subjectSystemitem3 : stutentSelectFindByStudentId) {
					StudentSelect item3 = new StudentSelect(subjectSystemitem3.getCredit());

					//subjectSystemitem 已選課
					//subjectSystemitem3 選課
					//防呆_衝堂 
					//舊課跟新課同天 並且
					if(subjectSystemitem.getDay() == subjectSystemitem3.getDay()&&
							//舊課下課時間不小於新課上課&下課時間	
						!((subjectSystemitem.getEndTime()<=subjectSystemitem3.getStartTime())&& 
						  (subjectSystemitem.getEndTime()<=subjectSystemitem3.getEndTime()))&&
						
							//舊課上課時間不小於新課上課&下課時間
						!((subjectSystemitem.getStartTime()>=subjectSystemitem3.getStartTime())&&
						  (subjectSystemitem.getStartTime()>=subjectSystemitem3.getEndTime()))){
						
						return new StudentSelectResponse("衝堂");						
					}
					//總休課學分= (0 + 新選的學分)
					totalCredit += (item3.getCredit()); 
				}
				//再把總休學學分 ((0 + 新選的學分) + 已選修學分*n)
				totalCredit += subjectSystemitem.getCredit();
				if(totalCredit > 10 ) {
					
					return new StudentSelectResponse("您已超過學分上限");						
				}
				
				
				//防呆_一堂課最多三個人選
				//設起始總數為1
				int sum = 1;
				//如果已選課被遍歷到1次就總數+1
				for(StudentSelect subjectSystemitem8 : stutentSelectFindByClassCode) {
					sum ++;
					
				}
				//算上起始的第1次+已選2次=3 表示可以再選
				//算上起始的第1次+已選3次>3 表示選課已達上限
				if(sum > 3) {
					return new StudentSelectResponse("該堂課人數上限已滿");	
				}
				
			}
			studentSelectDao.saveAll(stutentSelectListTotal);
		}
		return new StudentSelectResponse(stutentSelectListTotal,"選課成功");

	}
	
	//功能_退選課程
	@Override
	public StudentSelectResponse delletStudentSelectList(StudentSelectRequest studentSelectRequest) {
		List<StudentSelect> stutentSelectList = studentSelectRequest.getStutentSelectList();
		for(StudentSelect item : stutentSelectList) {
			List<SubjectSystem> stutentSelectList2 = subjectSystemDao.findByClassCode(item.getClassCode());


			//防呆_輸入數值有缺
			if(!StringUtils.hasText(item.getStudentId())||
			   !StringUtils.hasText(item.getStudentName())) {
					return new StudentSelectResponse("資料輸入不完全");
			}
			
			if(!studentDao.existsByStudentIdAndStudentName(item.getStudentId(),item.getStudentName())) {
				
				return new StudentSelectResponse("學號跟學生名字不符");
			}
			if(!studentSelectDao.existsByStudentNameAndClassCode(item.getStudentName(),item.getClassCode())) {
				
				return new StudentSelectResponse("沒有選過這堂課");
			}
			
			studentSelectDao.delete(item);
			
		}
		return new StudentSelectResponse("退選成功");
	}
	


	//功能_用學生id找學生已選課程
	@Override
	public List<StudentSelect> findByStudentId(String studentId) {
		
		return studentSelectDao.findByStudentId(studentId);
	}


}
