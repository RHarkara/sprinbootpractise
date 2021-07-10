package com.springboot.practice.service;

import java.util.List;

import com.springboot.practice.entity.Department;

public interface DepartmentService {

	Department save(Department department);

	List<Department> getAllDepartments();

	Department getDepartmentById(Long departmentId);

	Department getDepartmentByName(String departmentName);

	String deleteById(Long deparmentId);

	Department updateDepartment(Long departmentId, Department department);

}
