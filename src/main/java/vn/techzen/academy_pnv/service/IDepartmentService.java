package vn.techzen.academy_pnv.service;


import vn.techzen.academy_pnv.model.Department;
import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    List<Department> findAll();
    Optional<Department> findById(Integer id);
    Department save(Department department);
    Optional<Department> update(Integer id, Department department);
    boolean delete(Integer id);
}

