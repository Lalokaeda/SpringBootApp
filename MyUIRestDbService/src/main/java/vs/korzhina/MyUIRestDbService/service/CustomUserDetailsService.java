package vs.korzhina.MyUIRestDbService.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vs.korzhina.MyUIRestDbService.entity.User;
import vs.korzhina.MyUIRestDbService.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private IUserRepository userRepository;

    public CustomUserDetailsService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(usernameOrEmail);
        if(user!=null){
            return new org.springframework.security.core.userdetails.User(user.getEmail(), 
                                                                        user.getPassword(),
                                                                        user.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getName()))
                                                                        .collect(Collectors.toList()));
        } else{
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }

}
