package com.spring.mongodb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener;
import org.springframework.boot.test.context.SpringBootTest;

import com.custom.Exception.ServiceException;
import com.mongodb.assertions.Assertions;
import com.spring.mongodb.Service.CellService;
import com.spring.mongodb.model.CellList;
import com.spring.mongodb.repositories.CellRepositories;
import org.junit.*;

@SpringBootTest
class CellMongodbApplicationTests {
	@Autowired
	private CellService cellService;
	@Mock
	private CellRepositories repo;
	
	@Test
	public void savetest() throws Exception {
		CellList cell=new CellList(205,"oneplus",12);
		when(repo.save(cell)).thenReturn(cell);
		assertEquals(cell.getId()
				,cellService.save(cell));
	}
	@Test
	public void getall1test() throws ServiceException {
		List<CellList> mainlist=new ArrayList<>();
		CellList cell=new CellList(888,"iphone",6);
		CellList cell1=new CellList(889,"oneplus",12);
		mainlist.add(cell);
		mainlist.add(cell1);
		when(repo.findAll()).thenReturn(mainlist);
		Assert.assertEquals(mainlist,cellService.getall());
	}

	@Test
	public void updatetest() throws ServiceException{
		CellList cellList=new CellList(111,"oneplus",12);
		when(repo.save(cellList)).thenReturn(cellList);
		assertEquals(cellList,cellService.update(cellList));
	}
	@Test
	public void deletetest() {
		CellList cell=new CellList(123,"oneplus",12);
		repo.deleteById(cell.getId());
		verify(repo,times(1)).deleteById(cell.getId());
	}
	@Test
	public void deletealltest() {
		CellList c1=new CellList(99,"oneplus9r",12);
		CellList c2=new CellList(1111,"oneplusnord",12);
		repo.save(c1);
		repo.save(c2);
		repo.deleteAll();
		verify(repo,times(1)).deleteAll();
	}
	@Test
	public void getbyidtest() {
		int id=4599;
		Optional<CellList> cell1=Optional.ofNullable(new CellList(4599,"nokia",4));
		when(repo.findById(id)).thenReturn(cell1);
	}
	
}
