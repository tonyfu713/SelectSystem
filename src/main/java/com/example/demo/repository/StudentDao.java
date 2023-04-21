package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentSelect;
import com.example.demo.entity.SubjectSystem;

@Repository
public interface StudentDao extends JpaRepository<Student,String>{

	List<Student> findByStudentIdAndStudentName(String studentId, String studentName);

	boolean existsByStudentIdAndStudentName(String studentId, String studentName);

//	List<Student> findByStudendId(String studentId);


}
