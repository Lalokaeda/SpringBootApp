package vs.korzhina.MyUIRestDbService.service;

import java.util.List;

import vs.korzhina.MyUIRestDbService.dto.UserDto;
import vs.korzhina.MyUIRestDbService.entity.User;

public interface IUserService {

    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
