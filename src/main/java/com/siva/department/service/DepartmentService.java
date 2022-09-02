package com.siva.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.department.entity.Department;
import com.siva.department.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Optional<Department> findDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId);
	}
	
	public List<Department> findAllDepartments() {
		return departmentRepository.findAll();
	}

	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);
	}
}
