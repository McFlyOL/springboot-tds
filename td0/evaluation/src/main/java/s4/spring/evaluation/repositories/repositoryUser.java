package s4.spring.evaluation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.evaluation.models.User;

import java.util.List;

public interface repositoryUser extends JpaRepository<User,Integer>
{
    List<User> findAll();
    User findById(int Id);
    User findByName(String name);
    User findByEmail(String email);
}