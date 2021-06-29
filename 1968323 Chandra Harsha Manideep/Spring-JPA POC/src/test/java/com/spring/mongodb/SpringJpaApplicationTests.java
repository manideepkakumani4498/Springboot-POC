package com.spring.mongodb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


import com.spring.mongodb.Controller.StudentController;
import com.spring.mongodb.Repositories.StudentRepositories;
import com.spring.mongodb.Service.StudentService;
import com.spring.mongodb.model.Student;

@SpringBootTest
class SpringJpaApplicationTests {
	StudentController st=new StudentController();
	@Autowired
	private StudentService service;
	@MockBean
	private StudentRepositories repositories;
	@Test
	public void savetest(){
		Student student=new Student(4,"Manideep","Manideep4");
		when(repositories.save(student)).thenReturn(student);
		assertEquals(student,service.add(student));
	}
	@Test
	public void getalltest() {
		List<Student> student=new ArrayList<Student>();
		Student st=new Student(2,"chandra","chandra2");
		Student st1=new Student(3,"manideep","manideep3");
		student.add(st);
		student.add(st1);
		when(repositories.findAll()).thenReturn(student);
		assertEquals(student,service.getall());
	}
	@Test
	public void getbyidtest(){
		Student student =new Student(45,"Harsha","Harsha45");
		when(repositories.findById(student.getId()).get()).thenReturn(student);
		assertEquals(student,service.getbyid(student.getId()));
	}
	@Test
	public void updatetest() {
		Student student=new Student(88,"Chandra","Chandra88");	
		when(repositories.save(student)).thenReturn(student);
		assertEquals(student,service.update(student));
	}
	@Test
	public void deletebyidtest() {
		Student student =new Student(540,"abi","abi540");
		repositories.deleteById(student.getId());
		verify(repositories,times(1)).deleteById(student.getId());
	}
	@Test
	public void deletealltest() {
		Student st=new Student(1968,"chandra","chandra1968");
		Student st1=new Student(323,"kakumani","kakumani123");
		repositories.save(st);
		repositories.save(st1);
		repositories.deleteAll();
		verify(repositories,times(1)).deleteAll();
	}
}