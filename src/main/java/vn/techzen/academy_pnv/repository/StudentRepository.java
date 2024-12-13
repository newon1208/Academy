package vn.techzen.academy_pnv.repository;

import vn.techzen.academy_pnv.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Tan", 18),
            new Student(2, "Duc", 19)
    ));

    // Lấy tất cả sinh viên
    public List<Student> findAll() {
        return students;
    }

    // Tìm sinh viên theo ID
    public Student findById(int id) {
        Optional<Student> student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        return student.orElse(null); // Trả về null nếu không tìm thấy
    }

    // Thêm sinh viên mới
    public void save(Student student) {
        students.add(student);
    }

    // Cập nhật sinh viên
    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
        }
    }

    // Xóa sinh viên theo ID
    public void deleteById(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
