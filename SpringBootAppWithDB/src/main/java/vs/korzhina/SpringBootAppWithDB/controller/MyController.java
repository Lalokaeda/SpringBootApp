package vs.korzhina.SpringBootAppWithDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vs.korzhina.SpringBootAppWithDB.entity.Student;
import vs.korzhina.SpringBootAppWithDB.service.IStudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> allStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }
    
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        return student != null ? ResponseEntity.ok(student): ResponseEntity.notFound().build();
    }
    
    @PostMapping("/students")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        try{
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Студент создан с ID: " + savedStudent.getId());
        } catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Произошла ошибка при сохранении!");
        }
    }
    
    @PutMapping("/students")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        boolean isUpdated = studentService.saveStudent(student) != null;
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body("Студент обновлен успешно!"): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студент не найден!");
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
       studentService.deleteStudent(id);
    }
}
