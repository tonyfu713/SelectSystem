package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.StudentSelectPK;
import com.example.demo.entity.SubjectSystem;


@Repository
public interface SubjectSystemDao extends JpaRepository<SubjectSystem,String>{

	
	List<SubjectSystem> findByClassName (String className);

	List<SubjectSystem> findByClassCode(String classCode);

//	boolean existByClassCode(String classCode);

	boolean existsByClassName(String className);



}
