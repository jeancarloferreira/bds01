package com.devsuperior.bds01.repository;

import com.devsuperior.bds01.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
