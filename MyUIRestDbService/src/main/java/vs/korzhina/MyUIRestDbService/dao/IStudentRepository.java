package vs.korzhina.MyUIRestDbService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vs.korzhina.MyUIRestDbService.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
