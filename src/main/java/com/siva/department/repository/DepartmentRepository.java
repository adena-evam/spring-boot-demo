package com.siva.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siva.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
