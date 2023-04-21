package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;

@Repository
public interface StudentSelectDao extends JpaRepository<StudentSelect,String>{

	List<StudentSelect> findByStudentId(String studentId);

	boolean existsByStudentId(String studentId);

	boolean existsByStudentNameAndClassCode(String className, String classCode);

	boolean existsByClassCode(String classCode);

	boolean existsByStartTimeGreaterThan(Integer endTime);

	List<StudentSelect> findByClassCode(String classCode);


//	boolean existsByClassCode(String classCode);


}
