package com.springboot.practice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.practice.entity.Department;
import com.springboot.practice.repos.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepos;

	@BeforeAll // For all the test cases only one this method will be called
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach // By this annotation this perticular method will be called for each and every
				// method present in our testcases
	void setUp() {

		Department department = Department.builder().departmentName("IT").departmentAddress("HZB")
				.departmentCode("1205").deparmentId(1520).build();
		Mockito.when(departmentRepos.findByDepartmentName("IT")).thenReturn(department);

	}

	
	@Test
	@DisplayName("Get Data based on valid Department Name")
	@Disabled
	public void whenValidDepartmentName_thenDepartmentShouldFound() {

		String departmentName = "IT";
		Department found = departmentService.getDepartmentByName(departmentName);

		assertEquals(departmentName, found.getDepartmentName());
		

	}

}
