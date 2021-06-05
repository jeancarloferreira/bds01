package com.devsuperior.bds01.serviceImpl;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entity.Department;
import com.devsuperior.bds01.repository.DepartmentRepository;
import com.devsuperior.bds01.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        List<Department> list = departmentRepository.findAll(Sort.by("name"));
        return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }
}
