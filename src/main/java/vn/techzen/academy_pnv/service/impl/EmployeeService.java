package vn.techzen.academy_pnv.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv.dto.page.PageResponse;
import vn.techzen.academy_pnv.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv.model.Employee;
import vn.techzen.academy_pnv.repository.IEmployeeRepository;
import vn.techzen.academy_pnv.service.IEmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository;

    @Override
    public PageResponse<Employee> findAll(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        return PageResponse.<Employee>builder()
                .currentPage(employeePage.getNumber())
                .totalPages(employeePage.getTotalPages())
                .pageSize(employeePage.getSize())
                .totalElements(employeePage.getTotalElements())
                .data(employeePage.getContent())
                .build();
    }

    @Override
    public PageResponse<Employee> search(String name, Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findByNameContaining(name, pageable);
        return PageResponse.<Employee>builder()
                .currentPage(employeePage.getNumber())
                .totalPages(employeePage.getTotalPages())
                .pageSize(employeePage.getSize())
                .totalElements(employeePage.getTotalElements())
                .data(employeePage.getContent())
                .build();
    }

    @Override
    public List<Employee> findAll(java.awt.print.Pageable pageable) {
        return List.of();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Optional<Employee> update(Integer id, Employee employee) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(UUID id, Employee employee) {
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public List<Employee> search(EmployeeSearchRequest searchRequest, String name, java.awt.print.Pageable pageable) {
        return List.of();
    }
}
