package pl.wsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmailContainingIgnoreCase(String emailFragment);

    List<User> findByBirthDateBefore(LocalDate date);
}
