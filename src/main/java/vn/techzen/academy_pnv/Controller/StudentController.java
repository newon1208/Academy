package vn.techzen.academy_pnv.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1, "Tan", 18),
                    new Student(2, "duc", 19)
            )
    );

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId((int) (Math.random() * 10000)); // Consider using a more reliable ID generation
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}