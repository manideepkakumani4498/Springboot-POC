package com.spring.mongodb.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.custom.Exception.ServiceException;
import com.spring.mongodb.model.CellList;
import com.spring.mongodb.repositories.CellRepositories;

@Service
public class CellService {
	@Autowired
	private CellRepositories cellRepositories;
	
	public int save(CellList cellList) throws ServiceException {
		CellList cell=null;
		cell=cellRepositories.insert(cellList);
		if(cell.getName().isEmpty())
			throw new ServiceException("enter proper data in required fields");
		return cell.getId();
	}
	
	public List<CellList> getall() throws ServiceException{
		List<CellList> listcell=new ArrayList<>();
		listcell=cellRepositories.findAll();
		if(listcell.isEmpty())
			throw new ServiceException("List is Empty");
		return listcell;
	}
	public CellList getbyid(int id) throws ServiceException {
		CellList cell=null;
		try {
			cell=cellRepositories.findById(id).get();
		}catch(Exception e) {
			throw new ServiceException("record not found with id:"+id);
		}
		return cell;
	}
	public CellList update(CellList cellList) throws ServiceException{
		CellList cell=null;
		cell=cellRepositories.save(cellList);
		if(cell.getName().isEmpty())
			throw new ServiceException("enter name in the field");
		return cell;
	}
	public String deletebyid(int id) throws ServiceException {
		CellList cell=cellRepositories.findById(id).orElseThrow(()->new ServiceException("record with id"+id+"not found"));
		cellRepositories.deleteById(cell.getId());
		return "record deleted with id:"+cell.getId();
	}
	public void deleteall() throws ServiceException {
		if(cellRepositories.findAll().isEmpty())
			throw new ServiceException("there are no items to delete");
		cellRepositories.deleteAll();
	}
	

}
