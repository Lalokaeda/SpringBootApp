package vs.korzhina.SpringBootAppWithDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vs.korzhina.SpringBootAppWithDB.dao.AcademicDisciplineDAO;
import vs.korzhina.SpringBootAppWithDB.entity.AcademicDiscipline;

@Service
public class AcademicDisciplineService implements IAcademicDisciplineService{

    @Autowired
    private AcademicDisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<AcademicDiscipline> getAllDisciplines() {
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public AcademicDiscipline saveDiscipline(AcademicDiscipline academicDiscipline) {
        return disciplineDAO.saveDiscipline(academicDiscipline);
    }

    @Override
    @Transactional
    public AcademicDiscipline getDiscipline(int id) {
        return disciplineDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {
        disciplineDAO.deleteDiscipline(id);
    }

}
