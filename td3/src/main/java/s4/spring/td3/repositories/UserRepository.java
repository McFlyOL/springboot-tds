package s4.spring.td3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.td3.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstname(String firstname);
    User findById(int id);
    List<User> findByLastname(String lastname);
    List<User> findByEmail(String email);
    List<User> findBySuspended(String suspended);
}