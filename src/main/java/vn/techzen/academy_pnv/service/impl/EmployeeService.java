package vn.techzen.academy_pnv.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
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
    public Employee save(Employee employee) {
        // Lưu hoặc cập nhật thông tin Employee
        return employeeRepository.save(employee);
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
    public List<Employee> findAll() {
        // Lấy danh sách tất cả Employee từ cơ sở dữ liệu
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        // Tìm Employee theo ID
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> update(UUID id, Employee employee) {
        // Kiểm tra Employee có tồn tại không
        return employeeRepository.findById(id).map(existingEmployee -> {
            existingEmployee.setName(employee.getName());
            existingEmployee.setDob(employee.getDob());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartmentId(employee.getDepartmentId());
            return employeeRepository.save(existingEmployee);
        });
    }

    @Override
    public boolean delete(UUID id) {
        // Xóa Employee theo ID
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> search(EmployeeSearchRequest searchRequest) {
        return List.of();
    }


}
