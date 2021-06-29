package com.spring.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.custom.Exception.ServiceException;
import com.spring.mongodb.Service.CellService;
import com.spring.mongodb.model.CellList;
import com.spring.mongodb.repositories.CellRepositories;



@RestController
public class CellController {
	@Autowired
	private CellRepositories cellRepositories;
	@Autowired
	private CellService cellservice;
	@PostMapping("add")
	public String method(@RequestBody CellList cellList) throws ServiceException {
		cellservice.save(cellList);
		return "celllist added:"+cellList.getId();
	}
	@GetMapping("fetch")
	public List<CellList> method1() throws ServiceException{
		return cellservice.getall();
	}
	@GetMapping("fetch/{id}")
	public CellList method2(@PathVariable int id) throws ServiceException{
		CellList cell=cellservice.getbyid(id);
		return cell;
	
	}
	@PutMapping("update")
	public CellList method3(@RequestBody CellList cellList) throws ServiceException{
		return cellservice.update(cellList);
		
	}
	@DeleteMapping("deleteall")
	public void deleteall() throws ServiceException {
		cellservice.deleteall();
	}
	@DeleteMapping("delete/{id}")
	public String deletebyid(@PathVariable int id) throws ServiceException {
		return cellservice.deletebyid(id);
	}
}
