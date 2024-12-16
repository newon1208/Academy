package vn.techzen.academy_pnv.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv.model.Department;
import vn.techzen.academy_pnv.service.IDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentController {

    IDepartmentService departmentService;

    // GET /departments
    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> departments = departmentService.findAll();
        return ResponseEntity.ok(departments);
    }

    // POST /departments
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.save(department);
        return ResponseEntity.ok(savedDepartment);
    }

    // GET /departments/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        return departmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /departments/{id}student
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Integer id, @RequestBody Department department) {
        return departmentService.update(id, department)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /departments/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
        if (departmentService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
