package com.spring.mongodb.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.mongodb.controller.CellController;

class CellControllertest {
	
	private MockMvc mockmvc;
	
	@InjectMocks
	private CellController controller;
	@Before
	public void setUp() throws Exception{
		mockmvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	@Test
	public void methodtest() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("add")).andExpect(MockMvcResultMatchers
				.status().isOk()).andExpect(MockMvcResultMatchers.content()
						.string("celllist added:"));
	}

}
