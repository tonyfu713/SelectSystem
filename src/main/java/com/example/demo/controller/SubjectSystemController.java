package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SubjectSystem;
import com.example.demo.service.ifs.SubjectSystemService;
import com.example.demo.vo.SubjectSystemRequest;
import com.example.demo.vo.SubjectSystemResponse;



@RestController
public class SubjectSystemController {
	@Autowired
	private SubjectSystemService subjectSystemService;
	
	@PostMapping("addclasslist")
	public SubjectSystemResponse addclasslist(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.addclasslist(subjectSystemRequest);
	}

	@PostMapping("get_by_classcode")
	public List<SubjectSystem> findByClasscode(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.findByClassCode(subjectSystemRequest.getClassCode());
	}
	@PostMapping("get_by_class_name")
	public List<SubjectSystem> findByClassName(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.findByClassName(subjectSystemRequest.getClassName());
	}
	
	@PostMapping("delletclasslist")
	public SubjectSystemResponse delletclasslist(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.delletclasslist(subjectSystemRequest);
	}
	@PostMapping("resetclasslist")
	public SubjectSystemResponse resetclasslist(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.resetclasslist(subjectSystemRequest);
	}
	

	
}
