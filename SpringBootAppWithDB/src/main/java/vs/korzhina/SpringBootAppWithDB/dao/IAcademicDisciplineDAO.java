package vs.korzhina.SpringBootAppWithDB.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vs.korzhina.SpringBootAppWithDB.entity.AcademicDiscipline;

@Repository
public interface IAcademicDisciplineDAO {

    List<AcademicDiscipline> getAllDisciplines();
    AcademicDiscipline saveDiscipline(AcademicDiscipline academicDiscipline);
    AcademicDiscipline getDiscipline(int id);
    void deleteDiscipline(int id);
}
