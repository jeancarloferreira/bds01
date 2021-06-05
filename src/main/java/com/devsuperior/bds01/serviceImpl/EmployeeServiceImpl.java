package com.devsuperior.bds01.serviceImpl;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entity.Department;
import com.devsuperior.bds01.entity.Employee;
import com.devsuperior.bds01.repository.EmployeeRepository;
import com.devsuperior.bds01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page.map(x -> new EmployeeDTO(x));
    }

    @Override
    @Transactional
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee entity = new Employee();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment((new Department(dto.getDepartmentId(), null)));
        entity = employeeRepository.save(entity);
        return new EmployeeDTO(entity);
    }
}
