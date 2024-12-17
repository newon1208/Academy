package vn.techzen.academy_pnv.service;

import vn.techzen.academy_pnv.dto.page.PageResponse;
import vn.techzen.academy_pnv.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv.model.Employee;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeService {
    PageResponse<Employee> findAll(org.springframework.data.domain.Pageable pageable);

    PageResponse<Employee> search(String name, org.springframework.data.domain.Pageable pageable);

    List<Employee> findAll(Pageable pageable);                          // To fetch all employees
    Optional<Employee> findById(Integer id);           // To find an employee by their ID
    Employee save(Employee employee);                   // To save a new employee
    Optional<Employee> update(Integer id, Employee employee); // To update an existing employee
    boolean delete(Integer id);                        // To delete an employee by their ID

    Optional<Employee> findById(UUID id);

    Optional<Employee> update(UUID id, Employee employee);

    boolean delete(UUID id);

    List<Employee> search(EmployeeSearchRequest searchRequest,String name, Pageable pageable);
}
