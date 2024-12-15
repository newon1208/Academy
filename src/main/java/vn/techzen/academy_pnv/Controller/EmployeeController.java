package vn.techzen.academy_pnv.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(UUID.randomUUID(), "Tan", LocalDate.of(1998, 1, 15), "MALE", 15888868.88, "0975123542"),
            new Employee(UUID.randomUUID(), "Duc", LocalDate.of(1985, 5, 28), "FEMALE", 14588888.88, "0967869868"),
            new Employee(UUID.randomUUID(), "Bảo", LocalDate.of(1992, 3, 18), "MALE", 15588868.88, "0988881113"),
            new Employee(UUID.randomUUID(), "Hung", LocalDate.of(1988, 7, 5), "FEMALE", 14888888.88, "0986555333"),
            new Employee(UUID.randomUUID(), "Nhi", LocalDate.of(1995, 9, 25), "MALE", 15288888.88, "0973388668")
    ));
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "startDob", required = false) String startDob,
            @RequestParam(value = "endDob", required = false) String endDob,
            @RequestParam(value = "gender", required = false) String gender) {

        LocalDate startDate = (startDob != null) ? LocalDate.parse(startDob) : null;
        LocalDate endDate = (endDob != null) ? LocalDate.parse(endDob) : null;
        Gender genderEnum = null;

        // Chuyển đổi từ chuỗi sang enum
        if (gender != null) {
            try {
                genderEnum = Gender.valueOf(gender.toUpperCase());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build(); // Trả về lỗi nếu gender không hợp lệ
            }
        }

        List<Employee> result = employees.stream()
                .filter(e -> name == null || e.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(e -> startDate == null || (e.getDob().isEqual(startDate) || e.getDob().isAfter(startDate)))
                .filter(e -> endDate == null || (e.getDob().isEqual(endDate) || e.getDob().isBefore(endDate)))
                .filter(e -> genderEnum == null || e.getGender() == genderEnum)
                .toList();

        return ResponseEntity.ok(result);
    }

    // GET /employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employees);
    }

    // GET /employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /employees
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // PUT /employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") UUID id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOpt = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setDob(updatedEmployee.getDob());
            existingEmployee.setGender(updatedEmployee.getGender());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setPhone(updatedEmployee.getPhone());
            return ResponseEntity.ok(existingEmployee);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE /employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        boolean removed = employees.removeIf(e -> e.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}