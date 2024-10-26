package vs.korzhina.SpringBootAppWithDB.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import vs.korzhina.SpringBootAppWithDB.entity.AcademicDiscipline;

@Slf4j
@Repository
public class AcademicDisciplineDAO implements IAcademicDisciplineDAO {
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<AcademicDiscipline> getAllDisciplines() {
       Query query = entityManager.createQuery("from Academic_Discipline");
        List<AcademicDiscipline> allDisciplines =query.getResultList();
        log.info("getallDisciplines " +allDisciplines);
        return allDisciplines;
    }

    @Override
    public AcademicDiscipline saveDiscipline(AcademicDiscipline academicDiscipline) {
        return entityManager.merge(academicDiscipline);
    }

    @Override
    public AcademicDiscipline getDiscipline(int id) {
        return entityManager.find(AcademicDiscipline.class, id);
    }

    @Override
    public void deleteDiscipline(int id) {
        Query query = entityManager.createQuery("delete from Academic_Discipline " +
                                                "where id =:disciplineId");
        query.setParameter("disciplineId", id);
        query.executeUpdate();
    }

}
