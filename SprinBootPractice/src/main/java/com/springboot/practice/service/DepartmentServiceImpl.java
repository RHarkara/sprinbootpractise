package com.springboot.practice.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practice.entity.Department;
import com.springboot.practice.repos.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}

	@Override
	public String deleteById(Long deparmentId) {
		departmentRepository.deleteById(deparmentId);
		return "Deleted";
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department dept = departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(dept.getDepartmentName()) && !"".equals(dept.getDepartmentName())) {
			dept.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(dept.getDepartmentCode()) && !"".equals(dept.getDepartmentCode())) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(dept.getDepartmentAddress()) && !"".equals(dept.getDepartmentAddress())) {
			dept.setDepartmentAddress(department.getDepartmentAddress());
		}
		return departmentRepository.save(dept);
	}

}
