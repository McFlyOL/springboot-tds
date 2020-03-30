package s4.spring.evaluation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.evaluation.models.Category;

import java.util.List;

public interface repositoryCategory extends JpaRepository<Category, Integer>
{
    List<Category> findAll();
    Category findById(int id);
    Category findByName(String name);
}