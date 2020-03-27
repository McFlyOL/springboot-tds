package s4.spring.evaluation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.evaluation.models.Language;

import java.util.List;

public interface repositoryLanguage extends JpaRepository<Language, Integer>
{
    List<Language> findAll();
    Language findByName(String name);
    List<Language> findById(int id);
}