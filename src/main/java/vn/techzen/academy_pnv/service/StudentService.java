package vn.techzen.academy_pnv.service;

import vn.techzen.academy_pnv.model.Student;
import vn.techzen.academy_pnv.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    // Lấy tất cả sinh viên
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Tìm sinh viên theo ID
    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    // Thêm sinh viên mới
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    // Cập nhật thông tin sinh viên
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    // Xóa sinh viên theo ID
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
