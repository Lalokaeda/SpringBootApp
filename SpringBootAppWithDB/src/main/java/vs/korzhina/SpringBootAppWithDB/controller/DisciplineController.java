package vs.korzhina.SpringBootAppWithDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vs.korzhina.SpringBootAppWithDB.entity.AcademicDiscipline;
import vs.korzhina.SpringBootAppWithDB.entity.Student;
import vs.korzhina.SpringBootAppWithDB.service.IAcademicDisciplineService;

@RestController
@RequestMapping("/api")
public class DisciplineController {
 @Autowired
    private IAcademicDisciplineService disciplineService;

    @GetMapping("/disciplines")
    public ResponseEntity<List<AcademicDiscipline>> allDisciplines() {
        List<AcademicDiscipline> allDisciplines = disciplineService.getAllDisciplines();
        return ResponseEntity.ok(allDisciplines);
    }
    
    @GetMapping("/disciplines/{id}")
    public ResponseEntity<AcademicDiscipline> getDiscipline(@PathVariable("id") int id) {
        AcademicDiscipline discipline = disciplineService.getDiscipline(id);
        return discipline != null ? ResponseEntity.ok(discipline) : ResponseEntity.notFound().build();
    }
    
    @PostMapping("/disciplines")
    public ResponseEntity<String> saveDiscipline(@RequestBody AcademicDiscipline discipline) {
        try{
        AcademicDiscipline savedDiscipline = disciplineService.saveDiscipline(discipline);
        return ResponseEntity.status(HttpStatus.CREATED).body("Дисциплина создана с ID: " + savedDiscipline.getId());
        } catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Произошла ошибка при сохранении!");
        }
    }
    
    @PutMapping("/disciplines")
    public ResponseEntity<String> updateDiscipline(@RequestBody AcademicDiscipline discipline) {
        boolean isUpdated = disciplineService.saveDiscipline(discipline) != null;
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body("Дисциплина обновлена успешно!"): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Дисциплина не найдена!");
    }

    @DeleteMapping("/disciplines/{id}")
    public void deleteDiscipline(@PathVariable("id") int id) {
       disciplineService.deleteDiscipline(id);
    }
}
