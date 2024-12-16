package vn.techzen.academy_pnv.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv.model.Student;
import vn.techzen.academy_pnv.repository.IStudentRepository;
import vn.techzen.academy_pnv.service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        // Lấy danh sách sinh viên từ cơ sở dữ liệu
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> update(Integer id, Student student) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
