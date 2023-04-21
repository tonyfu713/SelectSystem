package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.SubjectSystem;
import com.example.demo.vo.SubjectSystemRequest;
import com.example.demo.vo.SubjectSystemResponse;



public interface SubjectSystemService {
	//功能_新增課程
	public SubjectSystemResponse addclasslist(SubjectSystemRequest subjectSystemRequest);
	
	//功能_刪除課程
	public SubjectSystemResponse deleteclasslist(SubjectSystemRequest subjectSystemRequest);
	
	//功能_修改課程
	public SubjectSystemResponse resetclasslist(SubjectSystemRequest subjectSystemRequest);
	
	//功能_用課程代碼找課程資訊2
	public SubjectSystemResponse findByClassCode2(SubjectSystemRequest subjectSystemRequest);

	//功能_用課程名字找課程資訊2
	public SubjectSystemResponse findByClassName2(SubjectSystemRequest subjectSystemRequest);

	

	//功能_用課程代碼找課程資訊
	public List<SubjectSystem> findByClassCode (String classCode);
	
	//功能_用課程名字找課程資訊
	public List<SubjectSystem> findByClassName (String className);

	

}
