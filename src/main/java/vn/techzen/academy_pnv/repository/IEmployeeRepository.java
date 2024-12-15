package vn.techzen.academy_pnv.repository;



import vn.techzen.academy_pnv.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv.model.Employee;

import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository {

    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);

    List<Employee> findAll();

    Employee findById(UUID id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    Employee delete(Employee employee);
}
