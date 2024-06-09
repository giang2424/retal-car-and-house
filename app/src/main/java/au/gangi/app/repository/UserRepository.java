package au.gangi.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.gangi.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
