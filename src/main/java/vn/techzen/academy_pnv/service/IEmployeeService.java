package vn.techzen.academy_pnv.service;



import vn.techzen.academy_pnv.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv.model.Employee;

import java.util.List;
import java.util.UUID;

public interface IEmployeeService {
    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);

    Employee findById(UUID id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    Employee delete(Employee employee);
}