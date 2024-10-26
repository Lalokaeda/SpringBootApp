package vs.korzhina.SpringBootAppWithDB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vs.korzhina.SpringBootAppWithDB.entity.AcademicDiscipline;

@Service
public interface IAcademicDisciplineService {

    List<AcademicDiscipline> getAllDisciplines();

    AcademicDiscipline saveDiscipline(AcademicDiscipline academicDiscipline);
    
    AcademicDiscipline getDiscipline(int id);
    
    void deleteDiscipline(int id);
}
