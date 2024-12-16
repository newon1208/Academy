package vn.techzen.academy_pnv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv.model.Department;
import vn.techzen.academy_pnv.repository.IDepartmentRepository;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements vn.techzen.academy_pnv.service.IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> update(Integer id, Department department) {
        // Kiểm tra xem Department có tồn tại không
        return departmentRepository.findById(id)
                .map(existingDepartment -> {
                    // Sao chép tất cả các thuộc tính từ department vào existingDepartment
                    BeanUtils.copyProperties(department, existingDepartment);
                    // Lưu lại đối tượng đã được cập nhật
                    return departmentRepository.save(existingDepartment);
                });
    }


    @Override
    public boolean delete(Integer id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
