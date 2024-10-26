package vs.korzhina.MyUIRestDbService.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.slf4j.Slf4j;
import vs.korzhina.MyUIRestDbService.dao.IStudentRepository;
import vs.korzhina.MyUIRestDbService.entity.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@RestController
public class StudentController {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentController(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @GetMapping({"/list", "/"})
    public ModelAndView getAllStudents(){
        ModelAndView mav = new ModelAndView("list-students");
        mav.addObject("students", studentRepository.findAll());
        return mav;
    }

    @GetMapping("/addStudentForm")
    public ModelAndView AddStudentForm() {
        ModelAndView mav = new ModelAndView("add-student-form");
        Student student = new Student();
        mav.addObject("student", student);
        return mav;
    }

    @PostMapping("/saveStudent")
    public RedirectView saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return new RedirectView("list");
    }
    
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int studentId) {
        ModelAndView mav = new ModelAndView("add-student-form");
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student=new Student();
        if(optionalStudent.isPresent()){
            student = optionalStudent.get();
        }
        mav.addObject("student", student);
        return mav;
    }

    @GetMapping("/deleteStudent")
    public RedirectView deleteStudent(@RequestParam int studentId, ModelAndView model) {
        studentRepository.deleteById(studentId);
        return new RedirectView("list");
    }
    
    
    
}