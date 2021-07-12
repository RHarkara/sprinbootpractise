package com.springboot.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practice.entity.Department;
import com.springboot.practice.error.DepartmentNotFountException;
import com.springboot.practice.service.DepartmentService;


@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/save")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.debug("New Department Added "+department);
		return departmentService.save(department);
	}

	@GetMapping("/getall")
	public List<Department> getAllDepartment() {
		LOGGER.debug("All Deparments Seen ");
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/getDepartment/{id}") 
		public Department getDepartmentById(@PathVariable("id") Long departmentId ) throws DepartmentNotFountException {
			return departmentService.getDepartmentById(departmentId);
	}
	
	@GetMapping("/getDepartmentByName/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDeparmentById(@PathVariable("id") Long deparmentId) {
		return departmentService.deleteById(deparmentId);
	}
	
	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
	}
	
	
}
