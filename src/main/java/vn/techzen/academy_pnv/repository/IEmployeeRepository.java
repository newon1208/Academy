package vn.techzen.academy_pnv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techzen.academy_pnv.model.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {

    // Tìm kiếm theo tên và mức lương trong khoảng
    List<Employee> findByNameContainingAndSalaryBetween(String name, Double fromSalary, Double toSalary);

    Page<Employee> findByNameContaining(String name, Pageable pageable);
}
