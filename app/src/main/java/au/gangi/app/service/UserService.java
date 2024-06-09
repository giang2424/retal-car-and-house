package au.gangi.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.gangi.app.entity.User;
import au.gangi.app.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    // public User saveUser(User user) {
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     return userRepository.save(user);
    // }
}
