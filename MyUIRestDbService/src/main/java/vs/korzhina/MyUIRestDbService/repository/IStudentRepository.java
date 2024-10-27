package vs.korzhina.MyUIRestDbService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vs.korzhina.MyUIRestDbService.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
