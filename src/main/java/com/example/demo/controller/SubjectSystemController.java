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
	
	
	@PostMapping("add_class_list")
	public SubjectSystemResponse addclasslist(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.addclasslist(subjectSystemRequest);
	}	
	@PostMapping("delete_class_list")
	public SubjectSystemResponse deleteclasslist(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.deleteclasslist(subjectSystemRequest);
	}
	@PostMapping("reset_class_list")
	public SubjectSystemResponse resetclasslist(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.resetclasslist(subjectSystemRequest);
	}
	
	@PostMapping("find_by_class_code2")
	public SubjectSystemResponse findByClassCode2(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.findByClassCode2(subjectSystemRequest);
	}
	@PostMapping("find_by_class_name2")
	public SubjectSystemResponse findByClassName2(@RequestBody SubjectSystemRequest subjectSystemRequest) {

		return subjectSystemService.findByClassName2(subjectSystemRequest);
	}

	
	@PostMapping("get_by_classcode")
	public List<SubjectSystem> findByClasscode(@RequestBody SubjectSystemRequest subjectSystemRequest) {
		
		return subjectSystemService.findByClassCode(subjectSystemRequest.getClassCode());
	}
	@PostMapping("get_by_class_name")
	public List<SubjectSystem> findByClassName(@RequestBody SubjectSystemRequest subjectSystemRequest) {
		
		return subjectSystemService.findByClassName(subjectSystemRequest.getClassName());
	}

	
}
