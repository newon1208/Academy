package vn.techzen.academy_pnv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.techzen.academy_pnv.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
