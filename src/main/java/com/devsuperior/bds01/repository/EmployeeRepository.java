package com.devsuperior.bds01.repository;

import com.devsuperior.bds01.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
