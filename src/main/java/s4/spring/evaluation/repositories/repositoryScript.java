package s4.spring.evaluation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.evaluation.models.Script;
import s4.spring.evaluation.models.User;

import java.util.List;

public interface repositoryScript extends JpaRepository<Script,Integer> {
    List<Script> findAll();
    Script findById(int id);
    List<Script> findByUser(User user);
    List<Script> findByTitle(String title);
    List<Script> findByDescription(String description);
    List<Script> findByContent(String content);
    List<Script> findByCreationDate(String creationDate);
}