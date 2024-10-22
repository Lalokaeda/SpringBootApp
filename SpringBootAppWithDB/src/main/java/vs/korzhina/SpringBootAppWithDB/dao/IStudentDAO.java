package vs.korzhina.SpringBootAppWithDB.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vs.korzhina.SpringBootAppWithDB.entity.Student;

@Repository
public interface IStudentDAO {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(int id);
}
