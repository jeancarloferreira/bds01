package com.devsuperior.bds01.service;

import com.devsuperior.bds01.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface EmployeeService {

    Page<EmployeeDTO> findAll(Pageable pageable);

    EmployeeDTO create(EmployeeDTO dto);
}
