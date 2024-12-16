package vn.techzen.academy_pnv.service;

import vn.techzen.academy_pnv.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Student save(Student student);
    List<Student> findAll();
    Optional<Student> findById(Integer id);
    Optional<Student> update(Integer id, Student student);
    boolean delete(Integer id);
}
