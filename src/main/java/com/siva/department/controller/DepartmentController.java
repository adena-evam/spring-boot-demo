package com.siva.department.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.department.entity.Department;
import com.siva.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping(value = "/")
	public Department saveDepartment(@RequestBody Department department) {
		System.out.println(department.getName());
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Long departmentId) {
		Optional<Department> d = departmentService.findDepartmentById(departmentId);	
		if (d.isPresent()) {
			return new ResponseEntity<Department>(d.get(), HttpStatus.CREATED);
		}else {			
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND );
		}			
	}
	
	@GetMapping
	public ResponseEntity<List<Department>> findAll(){
		List<Department> d = departmentService.findAllDepartments();
		return new ResponseEntity<List<Department>>(d, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteDepartment(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return new ResponseEntity<Long>(departmentId, HttpStatus.ACCEPTED);
	}
}
