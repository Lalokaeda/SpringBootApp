package vs.korzhina.SpringBootAppWithDB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vs.korzhina.SpringBootAppWithDB.entity.Student;

@Service
public interface IStudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);
    
    Student getStudent(int id);
    
    void deleteStudent(int id);
}
