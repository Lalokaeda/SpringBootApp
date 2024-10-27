package vs.korzhina.MyUIRestDbService.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import vs.korzhina.MyUIRestDbService.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
