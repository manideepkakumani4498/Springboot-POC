package com.spring.mongodb.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.mongodb.Repositories.StudentRepositories;
import com.spring.mongodb.model.Student;


@Service
public class StudentService {
	@Autowired
	private StudentRepositories repositories;
	
	
	public Student add(Student student) {
		Student savedstudent=repositories.save(student);
		return savedstudent;
	}
	public List<Student> getall(){
		List<Student> slist=null;
		slist=(List<Student>) repositories.findAll();
			return slist;
	}
	
	public Student getbyid(int id){
			return repositories.findById(id).get();
	}
	public Student update(Student student) {
	Student savedstudent=repositories.save(student);
	return savedstudent;
			}
public void deletebyid(int id) {
			repositories.deleteById(id);
	}
	public void deleteall() {
		repositories.deleteAll();
	}
}
