package com.springboot.practice.repos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springboot.practice.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() {

		Department department = Department.builder().departmentName("Electronics").departmentAddress("WGL").deparmentId(1145L)
				.departmentCode("M03").build();
		entityManager.persist(department);
		
	}
	
	@Test
	public void whenFindById_thenReturnDepratment() {
		Department department = departmentRepository.findById(1145L).get();
		assertEquals(department.getDepartmentName(), "Electronics");
	}

}
