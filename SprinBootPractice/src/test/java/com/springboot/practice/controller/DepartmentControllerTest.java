package com.springboot.practice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.mysql.cj.result.ZonedDateTimeValueFactory;
import com.springboot.practice.entity.Department;
import com.springboot.practice.service.DepartmentService;

@WebMvcTest(controllers = DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DepartmentService departmentService;

	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = Department.builder().departmentAddress("KNR").departmentCode("EC01").departmentName("Electronics")
				.deparmentId(1L).build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inputDepartment = Department.builder().departmentAddress("KNR").departmentCode("EC01")
				.departmentName("Electronics").build();

		Mockito.when(departmentService.save(inputDepartment)).thenReturn(department);
		mockMvc.perform(
				MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON)
						.content("{\r\n" + "    \"departmentName\":\"ECE\",\r\n"
								+ "    \"departmentAddress\":\"HZB\",\r\n" + "    \"departmentCode\":\"22\"\r\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	void testGetDepartmentById() throws Exception {

		Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

		mockMvc.perform(MockMvcRequestBuilders.get(("/getDepartment/1")).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

	}

}
