package vn.techzen.academy_pnv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techzen.academy_pnv.model.Student;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContainingAndScoreBetween(String nane, Double fromScore, Double toScore);
   @Query("""
    FROM Student WHERE name like CONCAT('%',:name,'%')
    AND (:fromScore IS NULL OR score >= :fromScore)
    AND (:toScore IS NULL OR score <= :toScore)
""")
    List<Student> findStr(String nane, Double fromScore, Double toScore);

}
