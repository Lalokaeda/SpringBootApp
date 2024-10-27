package vs.korzhina.MyUIRestDbService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vs.korzhina.MyUIRestDbService.entity.User;

public interface IUserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
}
