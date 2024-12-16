//package vn.techzen.academy_pnv.Controller;
//
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import vn.techzen.academy_pnv.model.Employee;
//import vn.techzen.academy_pnv.service.IEmployeeService;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/employees")
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class EmployeeController {
//
//    IEmployeeService employeeService;
//
//    // API lọc Employees
//    @GetMapping("/search")
//    public ResponseEntity<List<Employee>> searchEmployees(
//            @RequestParam(value = "name", required = false) String name,
//            @RequestParam(value = "startDob", required = false) String startDob,
//            @RequestParam(value = "endDob", required = false) String endDob,
//            @RequestParam(value = "gender", required = false) String gender) {
//
//        // Gọi phương thức tìm kiếm từ service
//        List<Employee> employees = employeeService.search( name, startDob, endDob, gender);
//        return ResponseEntity.ok(employees);
//    }
//
//    // GET /employees
//    @GetMapping
//    public ResponseEntity<List<Employee>> getEmployees() {
//        List<Employee> employees = employeeService.findAll();
//        return ResponseEntity.ok(employees);
//    }
//
//    // GET /employees/{id}
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") UUID id) {
//        return employeeService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // POST /employees
//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//        Employee savedEmployee = employeeService.save(employee);
//        return ResponseEntity.status(201).body(savedEmployee);
//    }
//
//    // PUT /employees/{id}
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") UUID id, @RequestBody Employee employee) {
//        return employeeService.update(id, employee)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // DELETE /employees/{id}
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") UUID id) {
//        if (employeeService.delete(id)) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//}
