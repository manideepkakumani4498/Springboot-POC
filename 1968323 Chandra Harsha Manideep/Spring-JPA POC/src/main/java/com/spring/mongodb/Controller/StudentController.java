package com.spring.mongodb.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.InvalidAttributeValueException;

import org.hibernate.MappingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;


import com.spring.mongodb.Repositories.StudentRepositories;
import com.spring.mongodb.Service.StudentService;
import com.spring.mongodb.model.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	@PostMapping("add")
	public Student add(@RequestBody Student student){
		
			Student student1=service.add(student);
			return student1;
			}
	@GetMapping("getall")
	public List<Student> getall(){
			List<Student> student1=service.getall();
			return student1;
	}
	@GetMapping("getbyid/{id}")
	public Student getbyid(@PathVariable int id){
			Student studentretrieve=service.getbyid(id);
			return studentretrieve;
	}
	@PutMapping("add")
	public Student update(@RequestBody Student student){
			Student student1=service.add(student);
			return student1;
	}
	@DeleteMapping("deletebyid/{id}")
	public void deletebyid(@PathVariable int id){
			service.deletebyid(id);
	}
	@DeleteMapping("deleteall")
	public void deleteall() {
		service.deleteall();
	}
	
}